package com.madsam.otora.service

import android.content.Context
import android.util.Log
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.madsam.otora.entity.ChuniSheetsEntity
import com.madsam.otora.entity.ChuniSongsEntity
import com.madsam.otora.model.chuni.net.ChuniCookie
import com.madsam.otora.model.chuni.net.ChuniFriend
import com.madsam.otora.model.chuni.net.ChuniFullScore
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniLoginBonus
import com.madsam.otora.model.chuni.net.ChuniMap
import com.madsam.otora.model.chuni.net.ChuniMap.ChuniMapArea
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.model.chuni.net.ChuniPlayRecord
import com.madsam.otora.model.chuni.net.ChuniScore
import com.madsam.otora.model.chuni.net.ChuniStatue
import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniUserExtend
import com.madsam.otora.model.chuni.net.ChuniUserRole
import com.madsam.otora.model.chuni.web.jp.ChuniJpData
import com.madsam.otora.model.chuni.web.lxns.ChuniAliases
import com.madsam.otora.model.chuni.web.lxns.LxnsData
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.madsam.otora.utils.SafeSoupUtil.safeAttr
import com.madsam.otora.utils.SafeSoupUtil.safeFirst
import com.madsam.otora.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.utils.SafeSoupUtil.safeSelectFirst
import com.madsam.otora.utils.SafeSoupUtil.safeText
import com.madsam.otora.utils.ShareUtil
import com.madsam.otora.web.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.UpdatePolicy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Connection.Method
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.service.ChuniDataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/9/4
 * 描述: 中二节奏数据请求服务
 */

private const val TAG = "ChuniDataRequestService"
private const val URL = "https://chunithm.wahlap.com/mobile/"

class ChuniDataRequestService(private val context: Context) {
    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val mutex = Mutex()
    private val userAgent = ShareUtil.getString("chuniUserAgent", context) ?: ""
    private var cookie = ChuniCookie(
        ShareUtil.getString("chuniToken", context) ?: "",
        ShareUtil.getString("chuniExpires", context) ?: "",
        ShareUtil.getString("chuniMaxAge", context) ?: "",
        ShareUtil.getString("chuniPath", context) ?: "",
        ShareUtil.getString("chuniSameSite", context) ?: "",
        ShareUtil.getString("chuniUserId", context) ?: "",
        ShareUtil.getString("chuniFriendCodeList", context) ?: ""
    )
    private val moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .add(SafeIntAdapter())
        .add(SafeDoubleAdapter())
        .add(SafeBooleanAdapter())
        .add(SafeStringListAdapter())
        .add(SafeIntListAdapter())
        .add(IntPairAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val realmConfig = RealmConfiguration.Builder(
        schema = setOf(
            ChuniSongsEntity::class,
            ChuniSheetsEntity::class,
        )
    )
        .name("otoge-tracker-chuni.realm")
        .schemaVersion(1)
        .build()

    private fun requestDataFromServer(
        link: String,
        requestBody: String = "",
        method: Method = Method.GET
    ): Document {
        lateinit var doc: Document
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL(link))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            if (requestBody.isNotEmpty())
                connect.requestBody(requestBody)
            val response = connect.method(method).execute()
            updateCookie(response)
            doc = response.parse()
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in $link: ${e.message}")
        }
        return doc
    }

    private inline fun <reified T> saveDataToLocal(data: T, filename: String) {
        // 如果是空列表则不保存
        if (data is List<*> && data.isEmpty()) {
            Log.e(TAG, "Empty list data found in $filename")
            return
        }

        val jsonAdapter = moshi.adapter(T::class.java)
        val json = jsonAdapter.toJson(data)
        JsonUtil.saveJsonToFile(context, filename, json)
    }

    private fun parseChuniUser(doc: Document): ChuniUser {
        val chuniUser = ChuniUser()
        chuniUser.nameIn = doc.safeSelectFirst("div.player_name_in").safeText()

        chuniUser.profileBackground = doc.safeSelectFirst("div.box_playerprofile")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .removePrefix("profile_")

        chuniUser.reborn = doc.safeSelectFirst("div.player_reborn").safeText()
            .toIntOrNull() ?: 0
        chuniUser.level = doc.safeSelectFirst("div.player_lv").safeText()
            .toIntOrNull() ?: 0

        chuniUser.rating = doc.safeSelectFirst("div.player_rating_num_block")
            .select("img")
            .joinToString("") { img ->
                val srcFile = img.safeAttr("src").split("/").last()

                if (srcFile.contains("comma")) "."
                else srcFile.split(".").first().split("_").last()
                    .toInt().toString()
            }
        chuniUser.ratingMax = doc.safeSelectFirst("div.player_rating_max").safeText()
        chuniUser.overpower = doc.safeSelectFirst("div.player_overpower_text").safeText()
        chuniUser.lastPlay = doc.safeSelectFirst("div.player_lastplaydate_text").safeText()

        chuniUser.roleImageUrl = doc.safeSelectFirst("div.player_chara_info img")
            .safeAttr("src")
        chuniUser.roleBase = doc.safeSelectFirst("div.player_chara_info")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()

        chuniUser.honorBase = doc.safeSelectFirst("div.player_honor_short")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()

        chuniUser.honorText = doc.safeSelectFirst("div.player_honor_text").safeText()

        chuniUser.classEmblemBase = doc.safeSelectFirst("div.player_classemblem_base")
            .safeSelectFirst("img").safeAttr("src")

        chuniUser.classEmblemTop = doc.safeSelectFirst("div.player_classemblem_top")
            .safeSelectFirst("img").safeAttr("src")

        return chuniUser
    }

    private fun parseChuniPenguin(doc: Document): ChuniPenguin {
        return ChuniPenguin().apply {
            back = doc.safeSelectFirst("div.avatar_back img").safeAttr("src")
            skinfootR = doc.safeSelectFirst("div.avatar_skinfoot_r img").safeAttr("src")
            skinfootL = doc.safeSelectFirst("div.avatar_skinfoot_l img").safeAttr("src")
            skin = doc.safeSelectFirst("div.avatar_skin img").safeAttr("src")
            wear = doc.safeSelectFirst("div.avatar_wear img").safeAttr("src")
            face = doc.safeSelectFirst("div.avatar_face img").safeAttr("src")
            faceCover = doc.safeSelectFirst("div.avatar_faceCover img").safeAttr("src")
            head = doc.safeSelectFirst("div.avatar_head img").safeAttr("src")
            handR = doc.safeSelectFirst("div.avatar_hand_r img").safeAttr("src")
            handL = doc.safeSelectFirst("div.avatar_hand_l img").safeAttr("src")
            itemR = doc.safeSelectFirst("div.avatar_item_r img").safeAttr("src")
            itemL = doc.safeSelectFirst("div.avatar_item_l img").safeAttr("src")
        }
    }

    private fun parseChuniUserExtend(doc: Document): ChuniUserExtend {
        val chuniUserExtend = ChuniUserExtend()
        chuniUserExtend.friendCode = doc.getElementsByClass("user_data_friend_code").safeFirst()
            .getElementsByAttributeValue("style", "display:none;").text()
        chuniUserExtend.point = doc.getElementsByClass("user_data_point").safeFirstText()
        chuniUserExtend.totalPoint = doc.getElementsByClass("user_data_total_point").safeFirstText()
        chuniUserExtend.playCount = doc.getElementsByClass("user_data_play_count").safeFirstText()
        return chuniUserExtend
    }

    private fun requestPlayerData() {
        val doc = requestDataFromServer("$URL/home/playerData")

        val chuniUser = parseChuniUser(doc)
        val emptyCount = chuniUser::class.memberProperties.count {
            it.returnType.jvmErasure == String::class && it.getter.call(chuniUser) == ""
        }
        if (emptyCount > 5) println("Empty fields found in the file")
        else saveDataToLocal(chuniUser, "chuniUser.json")

        saveDataToLocal(parseChuniPenguin(doc), "chuniPenguin.json")
        saveDataToLocal(parseChuniUserExtend(doc), "chuniUserExt.json")
    }

    private fun parseRatingData(doc: Document): List<ChuniScore> {
        val chuniRating = mutableListOf<ChuniScore>()
        val ratingDetailBest = doc.getElementsByTag("form")
        for (rating in ratingDetailBest) {
            val title = rating.getElementsByClass("music_title").text()
            val highScore = rating.getElementsByClass("text_b").text()
            val id = rating.select("input[name=idx]").attr("value")
            val genre = rating.select("input[name=genre]").attr("value")
            val diff = rating.select("input[name=diff]").attr("value")
            val token = rating.select("input[name=token]").attr("value")
            chuniRating.add(ChuniScore(id, title, genre, diff, token, highScore))
        }
        return chuniRating
    }

    private fun requestRatingBest() {
        val doc = requestDataFromServer("$URL/home/playerData/ratingDetailBest")
        saveDataToLocal(parseRatingData(doc), "chuniRatingBest.json")
    }

    private fun requestRatingRecent() {
        val doc = requestDataFromServer("$URL/home/playerData/ratingDetailRecent")
        saveDataToLocal(parseRatingData(doc), "chuniRatingRecent.json")
    }

    private fun requestRatingNext() {
        val doc = requestDataFromServer("$URL/home/playerData/ratingDetailNext")
        saveDataToLocal(parseRatingData(doc), "chuniRatingNext.json")
    }

    private fun parseChuniMaps(doc: Document): List<ChuniMap> {
        val chuniMaps = mutableListOf<ChuniMap>()

        val mapBlocks = doc.select("div.map_block.w400")
        for (block in mapBlocks) {
            val title = block.select("div.map_title_text.text_l.text_b").text()

            val currentPageText = block.select("div.map_title_page_num.font_90").text()
            val totalPagesText = block.select("div.map_title_page_den.font_90").text()
            val currentPage = currentPageText.toIntOrNull() ?: 0
            val totalPages = totalPagesText.toIntOrNull() ?: 0

            val areas = mutableListOf<ChuniMapArea>()
            val areaBlocks = block.select("div.maparea_block")
            for (areaBlock in areaBlocks) {
                val mapAreaDiv = areaBlock.selectFirst("div.maparea")
                if (mapAreaDiv != null) {
                    val imageUrl = mapAreaDiv.select("div.map_icon div.map_icon_avatar img")
                        .attr("src")
                        .takeIf { it.isNotBlank() }

                    val remainText = mapAreaDiv.select("div.map_remain div.map_remain_text").text()
                    val remain = remainText.toIntOrNull() ?: 0

                    val skillSeed =
                        mapAreaDiv.select("div.map_skillseed_block div.map_skillseed_text")
                            .text()
                            .takeIf { it.isNotBlank() }

                    areas.add(ChuniMapArea(imageUrl, remain, skillSeed))
                }
            }
            chuniMaps.add(ChuniMap(title, currentPage, totalPages, areas))
        }
        return chuniMaps
    }

    private fun requestMapRecord() {
        val doc = requestDataFromServer("$URL/record")
        saveDataToLocal(parseChuniMaps(doc), "chuniMapRecord.json")
    }

    private fun parsePlayLog(doc: Document): List<ChuniFullScore> {
        val chuniPlayLog = mutableListOf<ChuniFullScore>()
        val playLog = doc.getElementsByClass("frame02 w400")
        for (log in playLog) {
            val title = log.getElementsByClass("play_musicdata_title").text()
            val level = log.getElementsByClass("play_track_result")
                .select("img").attr("src")
                .split("/").last()
                .split(".").first()
                .split("_").last()
            val score = log.getElementsByClass("play_musicdata_score_text").text()
            val marks = log.getElementsByClass("play_musicdata_icon clearfix")
            val clearMarks = marks.select("img").joinToString("") {
                it.attr("src")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
            }
            val isClear = clearMarks.contains("icon_playlog_clear")
            val isFullCombo = clearMarks.contains("icon_playlog_fullcombo")
            val isAllJustice = clearMarks.contains("icon_playlog_alljustice")
            val isAJC = clearMarks.contains("icon_playlog_alljustice_critical")
            val isFullChain = clearMarks.contains("icon_playlog_fullchain")
            val rank = marks.select("img[src*='rank']").attr("src")
                .split("/").last()
                .split(".").first()
                .split("_").last()
            val jacket = log.getElementsByClass("play_jacket_img")
                .select("img").attr("data-original")
            val date = log.getElementsByClass("play_datalist_date").text()
            val trackNumber = log.getElementsByClass("play_track_text").text()
                .split(" ").last()
            chuniPlayLog.add(
                ChuniFullScore(
                    title = title,
                    diff = level,
                    score = score,
                    isClear = isClear,
                    isFullCombo = isFullCombo,
                    isAllJustice = isAllJustice,
                    isAJC = isAJC,
                    isFullChain = isFullChain,
                    rank = rank,
                    jacket = jacket,
                    date = date,
                    trackNumber = trackNumber
                )
            )
        }
        return chuniPlayLog
    }

    private fun requestPlayLog() {
        val doc = requestDataFromServer("$URL/record/playlog")
        saveDataToLocal(parsePlayLog(doc), "chuniPlayLog.json")
    }

    private fun parsePlayRecord(doc: Document, diff: String): ChuniPlayRecord {
        val chuniPlayRecord = ChuniPlayRecord()

        doc.select("div.score_list").forEach { scoreList ->
            val imgSrc = scoreList.select("div.score_list_top img").attr("src")
            val countText = scoreList.select("div.score_num_text").text()
                .replace(",", "").trim()
            val totalText = scoreList.select("div.score_all_text.font_small").text()
                .replace("/", "").replace(",", "").trim()

            val count = countText.toIntOrNull() ?: 0
            val total = totalText.toIntOrNull() ?: 0

            when {
                // 评级统计
                imgSrc.contains("rank_13") -> chuniPlayRecord.rateSSSp = Pair(count, total)  // SSS+
                imgSrc.contains("rank_12") -> chuniPlayRecord.rateSSS = Pair(count, total)   // SSS
                imgSrc.contains("rank_11") -> chuniPlayRecord.rateSSp = Pair(count, total)   // SS+
                imgSrc.contains("rank_10") -> chuniPlayRecord.rateSS = Pair(count, total)    // SS
                imgSrc.contains("rank_9") -> chuniPlayRecord.rateSp = Pair(count, total)     // S+
                imgSrc.contains("rank_8") -> chuniPlayRecord.rateS = Pair(count, total)      // S

                // 达成统计
                imgSrc.contains("clear") && !imgSrc.contains("fullchain") ->
                    chuniPlayRecord.rateClear = Pair(count, total)      // Clear
                imgSrc.contains("fullcombo") ->
                    chuniPlayRecord.rateFC = Pair(count, total)         // FC
                imgSrc.contains("alljustice") && !imgSrc.contains("critical") ->
                    chuniPlayRecord.rateAJ = Pair(count, total)         // AJ
                imgSrc.contains("alljusticecritical") ->
                    chuniPlayRecord.rateAJC = Pair(count, total)        // AJC
                imgSrc.contains("fullchain") && !imgSrc.contains("fullchain2") ->
                    chuniPlayRecord.rateFChain = Pair(count, total)     // FChain
                imgSrc.contains("fullchain2") ->
                    chuniPlayRecord.rateFChainP = Pair(count, total)    // FChain+

                // 难度统计  
                imgSrc.contains("hard") ->
                    chuniPlayRecord.rateHard = Pair(count, total)       // Hard
                imgSrc.contains("absolute") && !imgSrc.contains("absolutep") ->
                    chuniPlayRecord.rateAbs = Pair(count, total)        // Abs
                imgSrc.contains("absolutep") ->
                    chuniPlayRecord.rateAbsP = Pair(count, total)       // Abs+
                imgSrc.contains("catastrophy") ->
                    chuniPlayRecord.rateCatas = Pair(count, total)      // Catastrophy
            }
        }

        val allGenre = doc.getElementsByClass("box05 w400")
        val genreList = mutableListOf<ChuniGenre>()
        for (genre in allGenre) {
            val genreName = genre.getElementsByClass("genre scroll_point text_white").text()
            val diffLower = diff.toLowerCase(Locale.current)
            val genreScore = genre.getElementsByClass("w388 musiclist_box bg_$diffLower")
            val chuniScore = mutableListOf<ChuniFullScore>()
            for (score in genreScore) {
                val highScore = score.getElementsByClass("play_musicdata_highscore")
                    .select("span").text()
                val title = score.getElementsByClass("music_title").text()

                val id = score.select("input[name=idx]").attr("value")
                val level = score.select("input[name=diff]").attr("value")
                val genreId = score.select("input[name=genre]").attr("value")
                val token = score.select("input[name=token]").attr("value")

                val marks =
                    score.getElementsByClass("play_musicdata_icon clearfix").select("img")
                val clearMarks = marks.joinToString("") {
                    it.attr("src")
                        .split("_").last()
                }
                val isClear = clearMarks.contains("clear.png")
                val isFullCombo = clearMarks.contains("fullcombo.png")
                val isAllJustice = clearMarks.contains("alljustice.png")
                val isAJC = clearMarks.contains("alljusticecritical.png")
                val isFullChain = clearMarks.contains("fullchain.png")
                val isFullChain2 = clearMarks.contains("fullchain2.png")
                val rank = marks.select("img[src*='rank']").attr("src")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
                chuniScore.add(
                    ChuniFullScore(
                        id = id,
                        title = title,
                        diff = level,
                        score = highScore,
                        genre = genreId,
                        token = token,
                        isClear = isClear,
                        isFullCombo = isFullCombo,
                        isAllJustice = isAllJustice,
                        isAJC = isAJC,
                        isFullChain = isFullChain,
                        isFullChain2 = isFullChain2,
                        rank = rank,
                    )
                )
            }
            genreList.add(ChuniGenre(genreName, chuniScore))
        }
        chuniPlayRecord.genreList = genreList
        return chuniPlayRecord
    }

    private fun requestPlayRecord() {
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        for (diff in diffArray) {
            val doc = requestDataFromServer(
                link = "$URL/record/musicGenre/send$diff",
                requestBody = "genre=99&token=${cookie.token}",
                method = Method.POST
            )
            saveDataToLocal(parsePlayRecord(doc, diff), "chuniPlayRecord$diff.json")
        }
    }

    private fun parseChuniUserRole(doc: Document): ChuniUserRole {
        val roleName = doc.selectFirst("div.character_image_box_name").safeText()
        val roleImageUrl = doc.selectFirst("div.character_image_box img").safeAttr("src")
        val roleLevel = doc.select("div.character_lv_box_num img")
            .joinToString(separator = "") { img ->
                Regex("num_lv_(\\d+)")
                    .find(img.safeAttr("src"))
                    ?.groupValues?.get(1) ?: ""
            }

        return ChuniUserRole(roleName, roleLevel, roleImageUrl)
    }

    private fun parseChuniStatue(doc: Document): ChuniStatue {
        val penguinCounts = mutableListOf<Int>()
        val penguinContainer = doc.select("div.box01_title.text_b")
            .firstOrNull { it.text().contains("企鹅雕像") }
            ?.parent()

        penguinContainer?.select("div.ticket_block_block")?.forEach { block ->
            block.select("div.ticket_hold_mini span.font_large")
                .forEach { span ->
                    penguinCounts.add(span.safeText().toIntOrNull() ?: 0)
                }
        }

        return ChuniStatue(
            soul = penguinCounts.getOrNull(0) ?: 0,
            sliver = penguinCounts.getOrNull(1) ?: 0,
            gold = penguinCounts.getOrNull(2) ?: 0,
            rainbow = penguinCounts.getOrNull(3) ?: 0
        )
    }

    private fun requestCollection() {
        val doc = requestDataFromServer("$URL/collection")
        saveDataToLocal(parseChuniUserRole(doc), "chuniUserRole.json")
        saveDataToLocal(parseChuniStatue(doc), "chuniStatue.json")
    }

    private fun parseFriendList(doc: Document): List<ChuniFriend> {
        val friendList = mutableListOf<ChuniFriend>()

        val friendBlocks = doc.select("div.friend_block")
        friendBlocks.forEach { block ->
            // 获取角色相关信息
            val roleImageUrl =
                block.safeSelectFirst("div.player_data_left div.player_chara_info img")
                    .safeAttr("src")

            val roleBase = block.safeSelectFirst("div.player_data_left div.player_chara_info")
                .safeAttr("style").split("/").last()
                .split(".").first()
                .split("_").last()

            // 获取背景板信息
            val profileBackground = block.safeSelectFirst("div.box_playerprofile")
                .safeAttr("style").split("/").last()
                .split(".").first()
                .removePrefix("profile_")

            // 获取荣誉相关信息
            val honorText = block.safeSelectFirst("div.player_honor_text span").safeText()
            val honorBase = block.safeSelectFirst("div.player_honor_short")
                .safeAttr("style")
                .split("/").last()
                .split(".").first()
                .split("_").last()

            val classEmblemBase = block.safeSelectFirst("div.player_classemblem_base")
                .safeSelectFirst("img").safeAttr("src")
            val classEmblemTop = block.safeSelectFirst("div.player_classemblem_top")
                .safeSelectFirst("img").safeAttr("src")

            // 获取基本信息
            val reborn = block.safeSelectFirst("div.player_reborn").safeText().toIntOrNull() ?: 0
            val level = block.safeSelectFirst("div.player_lv").safeText().toIntOrNull() ?: 0
            val friendName = block.safeSelectFirst("div.player_name_in form a").safeText()
            val friendCode = block.safeSelectFirst("input[name=idx]").safeAttr("value")
            val ratingMax = block.safeSelectFirst("div.player_rating_max").safeText()
            val rating = block.safeSelectFirst("div.player_rating_num_block")
                .select("img")
                .joinToString("") { img ->
                    val srcFile = img.safeAttr("src")
                        .split("/").last()

                    if (srcFile.contains("comma")) "."
                    else srcFile.split(".").first()
                        .split("_").last()
                        .toInt()
                        .toString()
                }
            val overpower = block.safeSelectFirst("div.player_overpower_text").safeText()
            val lastPlayDate = block.safeSelectFirst("div.player_lastplaydate_text").safeText()

            // 检查按钮状态
            val isFavorite = block.selectFirst("div.friend_favorite_off") != null
            val isScored = block.selectFirst("div.friend_score_off") != null

            friendList.add(
                ChuniFriend(
                    friendName = friendName,
                    friendCode = friendCode,
                    profileBackground = profileBackground,
                    reborn = reborn,
                    level = level,
                    rating = rating,
                    ratingMax = ratingMax,
                    overpower = overpower,
                    lastPlay = lastPlayDate,
                    roleImageUrl = roleImageUrl,
                    roleBase = roleBase,
                    honorText = honorText,
                    honorBase = honorBase,
                    isFavorite = isFavorite,
                    isScored = isScored,
                    classEmblemBase = classEmblemBase,
                    classEmblemTop = classEmblemTop
                )
            )
        }
        return friendList
    }

    private fun requestFriend() {
        val doc = requestDataFromServer("$URL/friend")
        saveDataToLocal(parseFriendList(doc), "chuniFriend.json")
    }

    private fun parseLoginBonus(doc: Document): ChuniLoginBonus {
        val monthText = doc.selectFirst("div.box01_title.text_b")?.text() ?: ""
        val currentMonth =
            Regex("(\\d+)月").find(monthText)?.groupValues?.get(1)?.toIntOrNull() ?: 0
        val monthlyDays = doc.select("div.monthly_cumulative_login_bonus_days_count_num img")
            .firstOrNull()?.attr("src")
            ?.let { src ->
                Regex("num_lv_(\\d+)").find(src)?.groupValues?.get(1)?.toIntOrNull()
            } ?: 0
        val totalDays = doc.select("div.bonus_block_off div.bonus_days_block")
            .last()
            ?.text()
            ?.let { text ->
                Regex("第 (\\d+) 天").find(text)?.groupValues?.get(1)?.toIntOrNull()
            } ?: 0

        return ChuniLoginBonus(
            currentMonth = currentMonth,
            monthlyDays = monthlyDays,
            totalDays = totalDays
        )
    }

    private fun requestLoginBonus() {
        val doc = requestDataFromServer("$URL/loginBonus")
        saveDataToLocal(parseLoginBonus(doc), "chuniLoginBonus.json")
    }

    private suspend fun requestSongsData() {
        val retrofitZ = Retrofit.Builder()
            .baseUrl("https://blog.madsam.work/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        val apiZ = retrofitZ.create(Api::class.java)
        var chuniJpData = ChuniJpData()
        try {
            val chuniSongsCall = apiZ.getChunithmSongsJp()
            val response = chuniSongsCall.execute()
            if (!response.isSuccessful) {
                Log.e(TAG, "Failed to get the songs data")
                return
            }
            val chuniData = response.body()
            if (chuniData == null) {
                Log.e(TAG, "Failed to get the songs data")
                return
            }
            chuniJpData = chuniData
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestSongsData: ${e.message}")
        }
        if (chuniJpData.songs.isEmpty()) {
            Log.e(TAG, "No songs data found in ChuniJp")
        }

        val retrofitL = Retrofit.Builder()
            .baseUrl("https://maimai.lxns.net/api/v0/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        val apiL = retrofitL.create(Api::class.java)
        var chuniLxnsData = LxnsData()
        var chuniAliases = ChuniAliases()
        try {
            val chuniSongsCall = apiL.getChunithmSongsLxns()
            val chuniAliasCall = apiL.getChunithmAliasList()
            val responseSongs = chuniSongsCall.execute()
            val responseAlias = chuniAliasCall.execute()
            if (!responseSongs.isSuccessful || !responseAlias.isSuccessful) {
                Log.e(TAG, "Failed to get ${responseSongs.code()}, ${responseAlias.code()}")
                return
            }
            val chuniData = responseSongs.body()
            val chuniAliasData = responseAlias.body()
            if (chuniData == null || chuniAliasData == null) {
                Log.e(TAG, "Failed to get the songs data, data is null")
                return
            }
            chuniLxnsData = chuniData
            chuniAliases = chuniAliasData
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestSongsData: ${e.message}")
        }

        if (chuniLxnsData.songs.isEmpty() || chuniAliases.aliases.isEmpty()) {
            Log.e(TAG, "No alias data found in Lxns")
        }
        if (chuniJpData.songs.isEmpty() && chuniLxnsData.songs.isEmpty() || chuniAliases.aliases.isEmpty()) {
            Log.e(TAG, "No songs data found in both ChuniJp and Lxns, check the api")
            return
        }

        val chuniSongsLMapI = mutableMapOf<Int, LxnsData.ChuniSong>()
        for (song in chuniLxnsData.songs) {
            val chuniSong = LxnsData.ChuniSong().apply {
                id = song.id
                genre = song.genre
                title = song.title
                artist = song.artist
                bpm = song.bpm
                map = song.map
                version = song.version
                difficulties = song.difficulties
            }
            chuniSongsLMapI[song.id] = chuniSong
        }
        val chuniAliasMapI = mutableMapOf<Int, ChuniAliases.ChuniAlias>()
        for (alias in chuniAliases.aliases) {
            val chuniAliasData = ChuniAliases.ChuniAlias().apply {
                id = alias.id
                aliases = alias.aliases
            }
            chuniAliasMapI[alias.id] = chuniAliasData
        }
        for (song in chuniLxnsData.songs) {
            val chuniSong = chuniSongsLMapI[song.id]
            val chuniAliasData = chuniAliasMapI[song.id]
            if (chuniSong != null && chuniAliasData != null) {
                chuniSong.aliases = chuniAliasData.aliases.joinToString(",")
            }
            song.aliases = chuniSong?.aliases ?: ""
        }

        val chuniSongsZMap = mutableMapOf<String, ChuniJpData.ChuniSong>()
        for (song in chuniJpData.songs) {
            val chuniSong = ChuniJpData.ChuniSong().apply {
                songId = song.songId
                category = song.category
                title = song.title
                artist = song.artist
                bpm = song.bpm
                imageName = song.imageName
                version = song.version
                releaseDate = song.releaseDate
                isNew = song.isNew
                isLocked = song.isLocked
                comment = song.comment
                sheets = song.sheets
            }
            chuniSongsZMap[song.songId] = chuniSong
        }
        val chuniSongsLMapT = mutableMapOf<String, LxnsData.ChuniSong>()
        for (song in chuniLxnsData.songs) {
            if (song.difficulties.size == 1) {
                song.title = "(WE) ${song.title}"
            }
            val chuniSong = LxnsData.ChuniSong().apply {
                id = song.id
                genre = song.genre
                title = song.title
                artist = song.artist
                bpm = song.bpm
                map = song.map
                version = song.version
                difficulties = song.difficulties
                aliases = song.aliases
            }
            chuniSongsLMapT[song.title] = chuniSong
        }
        val realm = Realm.open(realmConfig)
        realm.write {
            for (song in chuniJpData.songs) {
                val chuniSongZ = chuniSongsZMap[song.songId]
                val chuniSongL = chuniSongsLMapT[song.songId]
                if (chuniSongZ == null) {
                    Log.e(TAG, "Failed to get the song data from ChuniJp")
                    continue
                }
                val chuniSongData = ChuniSongsEntity().apply {
                    id = chuniSongZ.songId
                    genre = chuniSongZ.category
                    this.title = chuniSongZ.title
                    artist = chuniSongZ.artist
                    bpm = chuniSongZ.bpm
                    imageName = chuniSongZ.imageName
                    version = chuniSongZ.version
                    releaseDate = chuniSongZ.releaseDate
                    isNew = chuniSongZ.isNew
                    isLocked = chuniSongZ.isLocked
                    comment = chuniSongZ.comment
                    cnId = chuniSongL?.id ?: -1
                    map = chuniSongL?.map ?: "-"
                    aliases = chuniSongL?.aliases ?: ""
                }
                this.copyToRealm(chuniSongData, UpdatePolicy.ALL)

                for (sheet in chuniSongZ.sheets) {
                    val chuniSheetL = if (chuniSongL == null) {
                        null
                    } else {
                        val difficultyIndex = when (sheet.difficulty) {
                            "basic" -> 0
                            "advanced" -> 1
                            "expert" -> 2
                            "master" -> 3
                            "ultima" -> 4
                            "we" -> 0
                            else -> 0
                        }
                        chuniSongL.difficulties.getOrNull(difficultyIndex)?.also {
                            if (sheet.difficulty == "ultima") {
                                Log.i(TAG, "No Ultima data found of ${chuniSongL.title}")
                            }
                        } ?: LxnsData.ChuniSong.Difficulty()
                    }
                    val chuniSheetData = ChuniSheetsEntity().apply {
                        id = "${chuniSongZ.songId}_${sheet.difficulty}"
                        type = sheet.type
                        difficulty = sheet.difficulty
                        levelJp = sheet.level
                        levelValueJp = sheet.levelValue
                        internalLevelJp = sheet.internalLevel
                        internalLevelValueJp = sheet.internalLevelValue
                        levelCn = chuniSheetL?.level ?: ""
                        levelValueCn = chuniSheetL?.levelValue ?: 0.0
                        noteDesigner =
                            chuniSheetL?.noteDesigner ?: sheet.noteDesigner
                        tap = sheet.noteCounts.tap
                        hold = sheet.noteCounts.hold
                        slide = sheet.noteCounts.slide
                        air = sheet.noteCounts.air
                        flick = sheet.noteCounts.flick
                        total = sheet.noteCounts.total
                        jp = sheet.regions.jp
                        intl = sheet.regions.intl
                        cn = chuniSheetL != null
                        isSpecial = sheet.isSpecial
                        version = chuniSheetL?.version ?: -1
                        originId = chuniSheetL?.originId ?: -1
                        kanji = chuniSheetL?.kanji ?: "-"
                        star = chuniSheetL?.star ?: 0
                    }
                    this.copyToRealm(chuniSheetData, UpdatePolicy.ALL)
                }
            }
        }
        realm.close()
    }

    private fun updateCookie(response: Connection.Response) {
        // 获取所有cookies
        val cookies = response.cookies()

        // 遍历所有cookie，更新最新值
        cookies.forEach { (name, value) ->
            when (name) {
                "_t" -> cookie.token = value
                "expires" -> cookie.expires = value
                "userId" -> cookie.userId = value
            }
        }
    }

    fun getUserData() {
        serviceScope.launch { mutex.withLock { requestPlayerData() } }
        serviceScope.launch { mutex.withLock { requestRatingBest() } }
        serviceScope.launch { mutex.withLock { requestRatingRecent() } }
        serviceScope.launch { mutex.withLock { requestRatingNext() } }
        serviceScope.launch { mutex.withLock { requestMapRecord() } }
        serviceScope.launch { mutex.withLock { requestPlayLog() } }
        serviceScope.launch { mutex.withLock { requestPlayRecord() } }
        serviceScope.launch { mutex.withLock { requestCollection() } }
        serviceScope.launch { mutex.withLock { requestFriend() } }
        serviceScope.launch { mutex.withLock { requestLoginBonus() } }
        // 保存cookie
        ShareUtil.putString("chuniToken", cookie.token, context)
        ShareUtil.putString("chuniExpires", cookie.expires, context)
        ShareUtil.putString("chuniUserId", cookie.userId, context)
    }

    fun getChuniSongsData() {
        serviceScope.launch { mutex.withLock { requestSongsData() } }
    }

    suspend fun getChuniSongData(title: String): ChuniSongsEntity {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val song = realm.query(
                    clazz = ChuniSongsEntity::class,
                    query = "id == $0",
                    title
                ).find().first()
                val songData = ChuniSongsEntity().apply {
                    id = song.id
                    genre = song.genre
                    this.title = song.title
                    artist = song.artist
                    bpm = song.bpm
                    imageName = song.imageName
                    version = song.version
                    releaseDate = song.releaseDate
                    isNew = song.isNew
                    isLocked = song.isLocked
                    comment = song.comment
                }
                songData
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the song data: ${e.message}")
                ChuniSongsEntity()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getChuniSongSheetData(title: String, diff: String): ChuniSheetsEntity {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val sheet = realm.query(
                    clazz = ChuniSheetsEntity::class,
                    query = "id == $0",
                    "${title}_${diff}"
                ).find().first()
                val sheetData = ChuniSheetsEntity().apply {
                    id = sheet.id
                    type = sheet.type
                    difficulty = sheet.difficulty
                    levelJp = sheet.levelJp
                    levelValueJp = sheet.levelValueJp
                    internalLevelJp = sheet.internalLevelJp
                    internalLevelValueJp = sheet.internalLevelValueJp
                    levelCn = sheet.levelCn
                    levelValueCn = sheet.levelValueCn
                    noteDesigner = sheet.noteDesigner
                    tap = sheet.tap
                    hold = sheet.hold
                    slide = sheet.slide
                    air = sheet.air
                    flick = sheet.flick
                    total = sheet.total
                    jp = sheet.jp
                    intl = sheet.intl
                    isSpecial = sheet.isSpecial
                }
                sheetData
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the sheet data: ${e.message}")
                ChuniSheetsEntity()
            } finally {
                realm.close()
            }
        }
    }
}