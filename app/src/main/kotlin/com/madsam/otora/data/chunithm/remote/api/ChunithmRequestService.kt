package com.madsam.otora.data.chunithm.remote.api

import android.content.Context
import android.util.Log
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.madsam.otora.data.chunithm.local.api.ChunithmLocalService
import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniCookieDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniGenreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniMapDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniMapDTO.ChuniMapArea
import com.madsam.otora.data.chunithm.remote.model.ChuniPenguinDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniStatueDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserExtendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserRoleDTO
import com.madsam.otora.data.adapter.SafeIntPairAdapter
import com.madsam.otora.data.adapter.SafeBooleanAdapter
import com.madsam.otora.data.adapter.SafeDoubleAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.adapter.SafeStringListAdapter
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.JsonUtil
import com.madsam.otora.core.utils.SafeSoupUtil.safeAttr
import com.madsam.otora.core.utils.SafeSoupUtil.safeFirst
import com.madsam.otora.core.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.core.utils.SafeSoupUtil.safeSelectFirst
import com.madsam.otora.core.utils.SafeSoupUtil.safeText
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.data.BASE_URL
import com.madsam.otora.data.CHUNITHM_URL
import com.madsam.otora.data.LXNS_URL
import com.madsam.otora.data.adapter.SafeIntListAdapter
import com.madsam.otora.data.adapter.SafeLongAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Connection
import org.jsoup.Connection.Method
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure

internal class ChunithmRequestService(private val context: Context) {
    companion object {
        private const val TAG = "ChunithmRequestService"
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val isUserRequestRunning = AtomicBoolean(false)
    private val isSongsRequestRunning = AtomicBoolean(false)
    private val userAgent = ShareUtil.getString("chuniUserAgent", context) ?: ""
    private var cookie = ChuniCookieDTO(
        ShareUtil.getString("chuniToken", context) ?: "",
        ShareUtil.getString("chuniExpires", context) ?: "",
        ShareUtil.getString("chuniMaxAge", context) ?: "",
        ShareUtil.getString("chuniPath", context) ?: "",
        ShareUtil.getString("chuniSameSite", context) ?: "",
        ShareUtil.getString("chuniUserId", context) ?: "",
        ShareUtil.getString("chuniFriendCodeList", context) ?: "",
        ShareUtil.getString("chuniGa", context) ?: "",
        ShareUtil.getString("chuniGaKey", context) ?: "",
        ShareUtil.getString("chuniGaValue", context) ?: ""
    )
    private val moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .add(SafeIntAdapter())
        .add(SafeDoubleAdapter())
        .add(SafeBooleanAdapter())
        .add(SafeStringListAdapter())
        .add(SafeIntListAdapter())
        .add(SafeIntPairAdapter())
        .addLast(KotlinJsonAdapterFactory())
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
            if(cookie.gaKey.isNotEmpty()) {
                header.cookie(cookie.gaKey, cookie.gaValue)
                header.cookie("_ga", cookie.ga)
            }
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
        if (data is List<*> && data.isEmpty()) {
            Log.e(TAG, "Empty list data found in $filename")
            return
        }

        val jsonAdapter = moshi.adapter(T::class.java)
        val json = jsonAdapter.toJson(data)
        JsonUtil.saveJsonToFile(context, filename, json)
    }

    private fun parseChuniUser(doc: Document): ChuniUserDTO {
        val chuniUserDTO = ChuniUserDTO()
        chuniUserDTO.nameIn = doc.safeSelectFirst("div.player_name_in").safeText()

        chuniUserDTO.profileBackground = doc.safeSelectFirst("div.box_playerprofile")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .removePrefix("profile_")

        chuniUserDTO.reborn = doc.safeSelectFirst("div.player_reborn").safeText()
            .toIntOrNull() ?: 0
        chuniUserDTO.level = doc.safeSelectFirst("div.player_lv").safeText()
            .toIntOrNull() ?: 0

        chuniUserDTO.rating = doc.safeSelectFirst("div.player_rating_num_block")
            .select("img")
            .joinToString("") { img ->
                val srcFile = img.safeAttr("src").split("/").last()

                if (srcFile.contains("comma")) "."
                else srcFile.split(".").first().split("_").last()
                    .toInt().toString()
            }
        chuniUserDTO.ratingMax = doc.safeSelectFirst("div.player_rating_max").safeText()
        chuniUserDTO.overpower = doc.safeSelectFirst("div.player_overpower_text").safeText()
        chuniUserDTO.lastPlay = doc.safeSelectFirst("div.player_lastplaydate_text").safeText()

        chuniUserDTO.roleImageUrl = doc.safeSelectFirst("div.player_chara_info img")
            .safeAttr("src")
        chuniUserDTO.roleBase = doc.safeSelectFirst("div.player_chara_info")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()

        chuniUserDTO.honorBase = doc.safeSelectFirst("div.player_honor_short")
            .safeAttr("style")
            .split("/").last()
            .split(".").first()
            .split("_").last()

        chuniUserDTO.honorText = doc.safeSelectFirst("div.player_honor_text").safeText()

        chuniUserDTO.classEmblemBase = doc.safeSelectFirst("div.player_classemblem_base")
            .safeSelectFirst("img").safeAttr("src")

        chuniUserDTO.classEmblemTop = doc.safeSelectFirst("div.player_classemblem_top")
            .safeSelectFirst("img").safeAttr("src")

        return chuniUserDTO
    }

    private fun parseChuniPenguin(doc: Document): ChuniPenguinDTO {
        return ChuniPenguinDTO().apply {
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

    private fun parseChuniUserExtend(doc: Document): ChuniUserExtendDTO {
        val chuniUserExtendDTO = ChuniUserExtendDTO()
        chuniUserExtendDTO.friendCode = doc.getElementsByClass("user_data_friend_code").safeFirst()
            .getElementsByAttributeValue("style", "display:none;").text()
        chuniUserExtendDTO.point = doc.getElementsByClass("user_data_point").safeFirstText()
        chuniUserExtendDTO.totalPoint = doc.getElementsByClass("user_data_total_point").safeFirstText()
        chuniUserExtendDTO.playCount = doc.getElementsByClass("user_data_play_count").safeFirstText()
        return chuniUserExtendDTO
    }

    private fun requestPlayerData() {
        val doc = requestDataFromServer("$CHUNITHM_URL/home/playerData")

        val chuniUser = parseChuniUser(doc)
        val emptyCount = chuniUser::class.memberProperties.count {
            it.returnType.jvmErasure == String::class && it.getter.call(chuniUser) == ""
        }
        if (emptyCount > 5) println("Empty fields found in the file")
        else saveDataToLocal(chuniUser, "chuniUser.json")

        saveDataToLocal(parseChuniPenguin(doc), "chuniPenguin.json")
        saveDataToLocal(parseChuniUserExtend(doc), "chuniUserExt.json")
    }

    private fun parseRatingData(doc: Document): List<ChuniScoreDTO> {
        val chuniRating = mutableListOf<ChuniScoreDTO>()
        val ratingDetailBest = doc.getElementsByTag("form")
        for (rating in ratingDetailBest) {
            val title = rating.getElementsByClass("music_title").text()
            val highScore = rating.getElementsByClass("text_b").text()
            val id = rating.select("input[name=idx]").attr("value")
            val genre = rating.select("input[name=genre]").attr("value")
            val diff = rating.select("input[name=diff]").attr("value")
            val token = rating.select("input[name=token]").attr("value")
            chuniRating.add(ChuniScoreDTO(id, title, genre, diff, token, highScore))
        }
        return chuniRating
    }

    private fun requestRatingBest() {
        val doc = requestDataFromServer("$CHUNITHM_URL/home/playerData/ratingDetailBest")
        saveDataToLocal(parseRatingData(doc), "chuniRatingBest.json")
    }

    private fun requestRatingRecent() {
        val doc = requestDataFromServer("$CHUNITHM_URL/home/playerData/ratingDetailRecent")
        saveDataToLocal(parseRatingData(doc), "chuniRatingRecent.json")
    }

    private fun requestRatingNext() {
        val doc = requestDataFromServer("$CHUNITHM_URL/home/playerData/ratingDetailNext")
        saveDataToLocal(parseRatingData(doc), "chuniRatingNext.json")
    }

    private fun parseChuniMaps(doc: Document): List<ChuniMapDTO> {
        val chuniMapDTOS = mutableListOf<ChuniMapDTO>()

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
            chuniMapDTOS.add(ChuniMapDTO(title, currentPage, totalPages, areas))
        }
        return chuniMapDTOS
    }

    private fun requestMapRecord() {
        val doc = requestDataFromServer("$CHUNITHM_URL/record")
        saveDataToLocal(parseChuniMaps(doc), "chuniMapRecord.json")
    }

    private fun parsePlayLog(doc: Document): List<ChuniFullScoreDTO> {
        val chuniPlayLog = mutableListOf<ChuniFullScoreDTO>()
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
                ChuniFullScoreDTO(
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
        val doc = requestDataFromServer("$CHUNITHM_URL/record/playlog")
        saveDataToLocal(parsePlayLog(doc), "chuniPlayLog.json")
    }

    private fun parsePlayRecord(doc: Document, diff: String): ChuniPlayRecordDTO {
        val chuniPlayRecordDTO = ChuniPlayRecordDTO()

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
                imgSrc.contains("rank_13") -> chuniPlayRecordDTO.rateSSSp = Pair(count, total)  // SSS+
                imgSrc.contains("rank_12") -> chuniPlayRecordDTO.rateSSS = Pair(count, total)   // SSS
                imgSrc.contains("rank_11") -> chuniPlayRecordDTO.rateSSp = Pair(count, total)   // SS+
                imgSrc.contains("rank_10") -> chuniPlayRecordDTO.rateSS = Pair(count, total)    // SS
                imgSrc.contains("rank_9") -> chuniPlayRecordDTO.rateSp = Pair(count, total)     // S+
                imgSrc.contains("rank_8") -> chuniPlayRecordDTO.rateS = Pair(count, total)      // S

                // 达成统计
                imgSrc.contains("clear") && !imgSrc.contains("fullchain") ->
                    chuniPlayRecordDTO.rateClear = Pair(count, total)      // Clear
                imgSrc.contains("fullcombo") ->
                    chuniPlayRecordDTO.rateFC = Pair(count, total)         // FC
                imgSrc.contains("alljustice") && !imgSrc.contains("critical") ->
                    chuniPlayRecordDTO.rateAJ = Pair(count, total)         // AJ
                imgSrc.contains("alljusticecritical") ->
                    chuniPlayRecordDTO.rateAJC = Pair(count, total)        // AJC
                imgSrc.contains("fullchain") && !imgSrc.contains("fullchain2") ->
                    chuniPlayRecordDTO.rateFChain = Pair(count, total)     // FChain
                imgSrc.contains("fullchain2") ->
                    chuniPlayRecordDTO.rateFChainP = Pair(count, total)    // FChain+

                // 难度统计  
                imgSrc.contains("hard") ->
                    chuniPlayRecordDTO.rateHard = Pair(count, total)       // Hard
                imgSrc.contains("absolute") && !imgSrc.contains("absolutep") ->
                    chuniPlayRecordDTO.rateAbs = Pair(count, total)        // Abs
                imgSrc.contains("absolutep") ->
                    chuniPlayRecordDTO.rateAbsP = Pair(count, total)       // Abs+
                imgSrc.contains("catastrophy") ->
                    chuniPlayRecordDTO.rateCatas = Pair(count, total)      // Catastrophy
            }
        }

        val allGenre = doc.getElementsByClass("box05 w400")
        val genreList = mutableListOf<ChuniGenreDTO>()
        for (genre in allGenre) {
            val genreName = genre.getElementsByClass("genre scroll_point text_white").text()
            val diffLower = diff.toLowerCase(Locale.current)
            val genreScore = genre.getElementsByClass("w388 musiclist_box bg_$diffLower")
            val chuniScore = mutableListOf<ChuniFullScoreDTO>()
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
                    ChuniFullScoreDTO(
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
            genreList.add(ChuniGenreDTO(genreName, chuniScore))
        }
        chuniPlayRecordDTO.genreList = genreList
        return chuniPlayRecordDTO
    }

    private fun requestPlayRecord() {
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        for (diff in diffArray) {
            val doc = requestDataFromServer(
                link = "$CHUNITHM_URL/record/musicGenre/send$diff",
                requestBody = "genre=99&token=${cookie.token}",
                method = Method.POST
            )
            saveDataToLocal(parsePlayRecord(doc, diff), "chuniPlayRecord$diff.json")
        }
    }

    private fun parseChuniUserRole(doc: Document): ChuniUserRoleDTO {
        val roleName = doc.selectFirst("div.character_image_box_name").safeText()
        val roleImageUrl = doc.selectFirst("div.character_image_box img").safeAttr("src")
        val roleLevel = doc.select("div.character_lv_box_num img")
            .joinToString(separator = "") { img ->
                Regex("num_lv_(\\d+)")
                    .find(img.safeAttr("src"))
                    ?.groupValues?.get(1) ?: ""
            }

        return ChuniUserRoleDTO(roleName, roleLevel, roleImageUrl)
    }

    private fun parseChuniStatue(doc: Document): ChuniStatueDTO {
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

        return ChuniStatueDTO(
            soul = penguinCounts.getOrNull(0) ?: 0,
            sliver = penguinCounts.getOrNull(1) ?: 0,
            gold = penguinCounts.getOrNull(2) ?: 0,
            rainbow = penguinCounts.getOrNull(3) ?: 0
        )
    }

    private fun requestCollection() {
        val doc = requestDataFromServer("$CHUNITHM_URL/collection")
        saveDataToLocal(parseChuniUserRole(doc), "chuniUserRole.json")
        saveDataToLocal(parseChuniStatue(doc), "chuniStatue.json")
    }

    private fun parseFriendList(doc: Document): List<ChuniFriendDTO> {
        val friendList = mutableListOf<ChuniFriendDTO>()

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
                ChuniFriendDTO(
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
        val doc = requestDataFromServer("$CHUNITHM_URL/friend/")
        saveDataToLocal(parseFriendList(doc), "chuniFriend.json")
    }

    private fun parseLoginBonus(doc: Document): ChuniLoginBonusDTO {
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

        return ChuniLoginBonusDTO(
            currentMonth = currentMonth,
            monthlyDays = monthlyDays,
            totalDays = totalDays
        )
    }

    private fun requestLoginBonus() {
        val doc = requestDataFromServer("$CHUNITHM_URL/loginBonus")
        saveDataToLocal(parseLoginBonus(doc), "chuniLoginBonus.json")
    }

    private suspend fun requestSongsData() {
        val retrofitZ = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        val apiZ = retrofitZ.create(ChunithmAPI::class.java)
        var chuniJpDTO = ChuniJpDTO()
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
            chuniJpDTO = chuniData
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestSongsData: ${e.message}")
        }
        if (chuniJpDTO.songs.isEmpty()) {
            Log.e(TAG, "No songs data found in ChuniJp")
        }

        val retrofitL = Retrofit.Builder()
            .baseUrl(LXNS_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
        val apiL = retrofitL.create(ChunithmAPI::class.java)
        var chuniLxnsDTO = ChuniLxnsDTO()
        var chuniAliasesDTO = ChuniAliasesDTO()
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
            chuniLxnsDTO = chuniData
            chuniAliasesDTO = chuniAliasData
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestSongsData: ${e.message}")
        }

        if (chuniLxnsDTO.songs.isEmpty() || chuniAliasesDTO.aliases.isEmpty()) {
            Log.e(TAG, "No alias data found in Lxns")
        }
        if (chuniJpDTO.songs.isEmpty() && chuniLxnsDTO.songs.isEmpty() || chuniAliasesDTO.aliases.isEmpty()) {
            Log.e(TAG, "No songs data found in both ChuniJp and Lxns, check the api")
            return
        }

        val chunithmLocalService = ChunithmLocalService()
        chunithmLocalService.saveJPAndLxnsSongsData(chuniJpDTO, chuniLxnsDTO, chuniAliasesDTO)
    }

    private fun updateCookie(response: Connection.Response) {
        val cookies = response.cookies()

        cookies.forEach { (name, value) ->
            when (name) {
                "_t" -> cookie.token = value
                "expires" -> cookie.expires = value
                "userId" -> cookie.userId = value
                "_ga" -> cookie.ga = value
                cookie.gaKey -> cookie.gaValue = value
            }
        }
    }

    fun getUserData() {
        if (!isUserRequestRunning.getAndSet(true)) {
            serviceScope.launch {
                try {
                    setOf(
                        ::requestPlayerData,
                        ::requestRatingBest,
                        ::requestRatingRecent,
                        ::requestRatingNext,
                        ::requestMapRecord,
                        ::requestPlayLog,
                        ::requestPlayRecord,
                        ::requestCollection,
                        ::requestFriend,
                        ::requestLoginBonus
                    ).forEach { requestFunc ->
                        requestFunc()
                    }

                    ShareUtil.putString("chuniToken", cookie.token, context)
                    ShareUtil.putString("chuniExpires", cookie.expires, context)
                    ShareUtil.putString("chuniUserId", cookie.userId, context)
                    ShareUtil.putString("chuniGa", cookie.ga, context)
                } finally {
                    isUserRequestRunning.set(false)
                }
            }
        }
    }

    fun getChuniSongsData() {
        if (!isSongsRequestRunning.getAndSet(true)) {
            serviceScope.launch {
                try {
                    requestSongsData()
                } finally {
                    isSongsRequestRunning.set(false)
                }
            }
        }
    }
}