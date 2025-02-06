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
import com.madsam.otora.utils.SafeSoupUtil.safeFirst
import com.madsam.otora.utils.SafeSoupUtil.safeFirstAttr
import com.madsam.otora.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.utils.SafeSoupUtil.safePreviousElementSibling
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
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(NullToDefaultIntAdapter())
        .add(NullToDefaultDoubleAdapter())
        .add(NullToDefaultBooleanAdapter())
        .add(NullToEmptyStringListAdapter())
        .add(NullToEmptyIntListAdapter())
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
        method: Method = Method.GET): Document {
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
        // Check if data is List and not empty
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
        chuniUser.charaInfo = doc.getElementsByClass("player_chara_info")
            .select("img")
            .safeFirstAttr("src")
        chuniUser.charaBase = doc.getElementsByClass("player_chara_info")
            .safeFirstAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()
        chuniUser.honorBase = doc.getElementsByClass("player_honor_short")
            .safeFirstAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()
        chuniUser.honorText = doc.getElementsByClass("player_honor_text")
            .safeFirstText()
        chuniUser.reborn = doc.getElementsByClass("player_reborn")
            .safeFirstText()
            .toIntOrNull() ?: 0
        chuniUser.lv = doc.getElementsByClass("player_lv")
            .safeFirstText()
            .toIntOrNull() ?: 0
        chuniUser.nameIn = doc.getElementsByClass("player_name_in")
            .safeFirstText()

        val playerClassEmblemBaseBlock = doc.getElementsByClass("player_classemblem_base")
        chuniUser.classEmblemBase = playerClassEmblemBaseBlock.select("img")
            .safeFirstAttr("src")
            .split("/").last()
            .split(".").first()
            .split("_").last()
            .toIntOrNull() ?: 0

        val playerClassEmblemTopBlock = doc.getElementsByClass("player_classemblem_top")
        chuniUser.classEmblemTop = playerClassEmblemTopBlock.select("img")
            .safeFirstAttr("src")
            .split("/").last()
            .split(".").first()
            .split("_").last()
            .toIntOrNull() ?: 0

        val playerRatingNumBlock = doc.getElementsByClass("player_rating_num_block")
        val ratingImages = playerRatingNumBlock.select("img")
        val commaSeparator = doc.getElementsByClass("player_rating_comma").first()
        val commaIndex = ratingImages.indexOf(commaSeparator.safePreviousElementSibling()) + 1

        chuniUser.rating = ratingImages.joinToString("") {
            if (ratingImages.indexOf(it) == commaIndex) {
                "."
            } else {
                it.attr("src")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
                    .toInt().toString()
            }
        }

        chuniUser.ratingMax = doc.getElementsByClass("player_rating_max")
            .safeFirstText()
        chuniUser.overpower = doc.getElementsByClass("player_overpower_text")
            .safeFirstText()
        chuniUser.lastPlay = doc.getElementsByClass("player_lastplaydate_text")
            .safeFirstText()

        return chuniUser
    }

    private fun parseChuniPenguin(doc: Document): ChuniPenguin {
        val chuniPenguin = ChuniPenguin()
        chuniPenguin.back = doc.getElementsByClass("avatar_back")
            .select("img").safeFirstAttr("src")
        chuniPenguin.skinfootR = doc.getElementsByClass("avatar_skinfoot_r")
            .select("img").safeFirstAttr("src")
        chuniPenguin.skinfootL = doc.getElementsByClass("avatar_skinfoot_l")
            .select("img").safeFirstAttr("src")
        chuniPenguin.skin = doc.getElementsByClass("avatar_skin")
            .select("img").safeFirstAttr("src")
        chuniPenguin.wear = doc.getElementsByClass("avatar_wear")
            .select("img").safeFirstAttr("src")
        chuniPenguin.face = doc.getElementsByClass("avatar_face")
            .select("img").safeFirstAttr("src")
        chuniPenguin.faceCover = doc.getElementsByClass("avatar_faceCover")
            .select("img").safeFirstAttr("src")
        chuniPenguin.head = doc.getElementsByClass("avatar_head")
            .select("img").safeFirstAttr("src")
        chuniPenguin.handR = doc.getElementsByClass("avatar_hand_r")
            .select("img").safeFirstAttr("src")
        chuniPenguin.handL = doc.getElementsByClass("avatar_hand_l")
            .select("img").safeFirstAttr("src")
        chuniPenguin.itemR = doc.getElementsByClass("avatar_item_r")
            .select("img").safeFirstAttr("src")
        chuniPenguin.itemL = doc.getElementsByClass("avatar_item_l")
            .select("img").safeFirstAttr("src")
        return chuniPenguin
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

    private fun parsePlayRecord(doc: Document, diff: String): List<ChuniGenre> {
        val allGenre = doc.getElementsByClass("box05 w400")
        val chuniGenre = mutableListOf<ChuniGenre>()
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
            chuniGenre.add(ChuniGenre(genreName, chuniScore))
        }
        return chuniGenre
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
        val roleName = doc.selectFirst("div.character_image_box_name")?.text() ?: ""
        val roleImageUrl = doc.selectFirst("div.character_image_box img")?.attr("src") ?: ""
        val roleLevel = doc.select("div.character_lv_box_num img").mapNotNull { img ->
            Regex("num_lv_(\\d+)").find(img.attr("src"))?.groupValues?.get(1)
        }.joinToString(separator = "")

        return ChuniUserRole(roleName, roleLevel, roleImageUrl)
    }

    private fun parseChuniStatue(doc: Document): ChuniStatue {
        val penguinCounts = mutableListOf<Int>()
        val penguinContainer = doc.select("div.box01_title.text_b")
            .firstOrNull { it.text().contains("企鹅雕像") }
            ?.parent()
        penguinContainer?.select("div.ticket_block_block")?.forEach { block ->
            block.select("div.ticket_hold_mini span.font_large").forEach { span ->
                val count = span.text().toIntOrNull() ?: 0
                penguinCounts.add(count)
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
            val roleImageUrl = block.selectFirst("div.player_data_left div.player_chara_info img")
                ?.attr("src")
                ?: ""
            val levelText = block.selectFirst("div.player_data_right div.player_name div.player_lv")
                ?.text()
                ?: "0"
            val level = levelText.toIntOrNull() ?: 0
            val friendName = block.selectFirst("div.player_data_right div.player_name_in a")
                ?.text()
                ?: ""
            val ratingMax =
                block.selectFirst("div.player_data_right div.player_rating div.player_rating_max")
                    ?.text()
                    ?: ""
            val overpower =
                block.selectFirst("div.player_data_right div.player_overpower div.player_overpower_text")
                    ?.text()
                    ?: ""
            val lastPlayDate =
                block.selectFirst("div.player_data_right div.player_lastplaydate div.player_lastplaydate_text")
                    ?.text()
                    ?: ""
            val honorText =
                block.selectFirst("div.player_data_right div.player_honor_short div.player_honor_text_view div.player_honor_text span")
                    ?.text()
                    ?: ""

            friendList.add(
                ChuniFriend(
                    friendName = friendName,
                    level = level,
                    ratingMax = ratingMax,
                    overpower = overpower,
                    lastPlayDate = lastPlayDate,
                    roleImageUrl = roleImageUrl,
                    honorText = honorText
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
        if (response.cookie("_t") != null) {
            cookie.token = response.cookie("_t")!!.toString()
        }
        if (response.cookie("expires") != null) {
            cookie.expires = response.cookie("expires")!!.toString()
        }
        if (response.cookie("userId") != null) {
            cookie.userId = response.cookie("userId")!!.toString()
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
        // Save the cookies
        ShareUtil.putString("chuniToken", cookie.token, context)
        ShareUtil.putString("chuniExpires", cookie.expires, context)
        ShareUtil.putString("chuniUserId", cookie.userId, context)
    }

    fun getChuniSongsData() {
        serviceScope.launch { mutex.withLock { requestSongsData() } }
    }

    // Get songs data from the database
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