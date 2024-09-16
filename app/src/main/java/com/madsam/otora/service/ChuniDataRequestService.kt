package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.entity.chuni.ChuniCookie
import com.madsam.otora.entity.chuni.ChuniDataExtend
import com.madsam.otora.entity.chuni.ChuniFullScore
import com.madsam.otora.entity.chuni.ChuniGenre
import com.madsam.otora.entity.chuni.ChuniPenguin
import com.madsam.otora.entity.chuni.ChuniScore
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.SafeSoupUtil.safeFirst
import com.madsam.otora.utils.SafeSoupUtil.safeFirstAttr
import com.madsam.otora.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.utils.SafeSoupUtil.safePreviousElementSibling
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.jsoup.Connection
import org.jsoup.Jsoup
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
class ChuniDataRequestService(private val context: Context) {
    companion object {
        const val TAG = "ChuniDataRequestService"
        const val URL = "https://chunithm.wahlap.com/mobile/"
    }
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
        .add(KotlinJsonAdapterFactory())
        .build()
    private fun requestPlayerData() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/home/playerData"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            // Parse the player data
            val chuniCard = ChuniCard()
            chuniCard.charaInfo = doc.getElementsByClass("player_chara_info").select("img").safeFirstAttr("src")
            chuniCard.charaBase = doc.getElementsByClass("player_chara_info").safeFirstAttr("style")
                .split("/").last()
                .split(".").first()
                .split("_").last()
            chuniCard.honorBase = doc.getElementsByClass("player_honor_short").safeFirstAttr("style")
                .split("/").last()
                .split(".").first()
                .split("_").last()
            chuniCard.honorText = doc.getElementsByClass("player_honor_text").safeFirstText()
            chuniCard.reborn = doc.getElementsByClass("player_reborn").safeFirstText()
                .toIntOrNull() ?: 0
            chuniCard.lv = doc.getElementsByClass("player_lv").safeFirstText()
                .toIntOrNull() ?: 0
            chuniCard.nameIn = doc.getElementsByClass("player_name_in").safeFirstText()
            val playerClassEmblemBaseBlock = doc.getElementsByClass("player_classemblem_base")
            chuniCard.classEmblemBase = playerClassEmblemBaseBlock.select("img").safeFirstAttr("src")
                .split("/").last()
                .split(".").first()
                .split("_").last()
                .toIntOrNull() ?: 0
            val playerClassEmblemTopBlock = doc.getElementsByClass("player_classemblem_top")
            chuniCard.classEmblemTop = playerClassEmblemTopBlock.select("img").safeFirstAttr("src")
                .split("/").last()
                .split(".").first()
                .split("_").last()
                .toIntOrNull() ?: 0
            val playerRatingNumBlock = doc.getElementsByClass("player_rating_num_block")
            val ratingImages = playerRatingNumBlock.select("img")
            // Find the comma separator
            val commaSeparator = doc.getElementsByClass("player_rating_comma").first()
            val commaIndex = ratingImages.indexOf(commaSeparator.safePreviousElementSibling()) + 1
            chuniCard.rating = ratingImages.joinToString("") {
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
            chuniCard.ratingMax = doc.getElementsByClass("player_rating_max").safeFirstText()
            chuniCard.overpower = doc.getElementsByClass("player_overpower_text").safeFirstText()
            chuniCard.lastPlay = doc.getElementsByClass("player_lastplaydate_text").safeFirstText()
            val emptyCount = chuniCard::class.memberProperties.count {
                it.returnType.jvmErasure == String::class && it.getter.call(chuniCard) == ""
            }
            if (emptyCount > 5) {
                println("Empty fields found in the file")
            } else {
                val jsonAdapterCard = moshi.adapter(ChuniCard::class.java)
                val jsonCard = jsonAdapterCard.toJson(chuniCard)
                ShareUtil.putString("chuniCard", jsonCard, context)
            }
            // Parse the penguin data
            val chuniPenguin = ChuniPenguin()
            chuniPenguin.back = doc.getElementsByClass("avatar_back").select("img").safeFirstAttr("src")
            chuniPenguin.skinfootR = doc.getElementsByClass("avatar_skinfoot_r").select("img").safeFirstAttr("src")
            chuniPenguin.skinfootL = doc.getElementsByClass("avatar_skinfoot_l").select("img").safeFirstAttr("src")
            chuniPenguin.skin = doc.getElementsByClass("avatar_skin").select("img").safeFirstAttr("src")
            chuniPenguin.wear = doc.getElementsByClass("avatar_wear").select("img").safeFirstAttr("src")
            chuniPenguin.face = doc.getElementsByClass("avatar_face").select("img").safeFirstAttr("src")
            chuniPenguin.faceCover = doc.getElementsByClass("avatar_face_cover").select("img").safeFirstAttr("src")
            chuniPenguin.head = doc.getElementsByClass("avatar_head").select("img").safeFirstAttr("src")
            chuniPenguin.handR = doc.getElementsByClass("avatar_hand_r").select("img").safeFirstAttr("src")
            chuniPenguin.handL = doc.getElementsByClass("avatar_hand_l").select("img").safeFirstAttr("src")
            chuniPenguin.itemR = doc.getElementsByClass("avatar_item_r").select("img").safeFirstAttr("src")
            chuniPenguin.itemL = doc.getElementsByClass("avatar_item_l").select("img").safeFirstAttr("src")
            val jsonAdapterPenguin = moshi.adapter(ChuniPenguin::class.java)
            val jsonPenguin = jsonAdapterPenguin.toJson(chuniPenguin)
            ShareUtil.putString("chuniPenguin", jsonPenguin, context)
            // Parse the extend data
            val chuniDataExtend = ChuniDataExtend()
            chuniDataExtend.friendCode = doc.getElementsByClass("user_data_friend_code").safeFirst()
                .getElementsByAttributeValue("style", "display:none;").text()
            chuniDataExtend.point = doc.getElementsByClass("user_data_point").safeFirstText()
            chuniDataExtend.totalPoint = doc.getElementsByClass("user_data_total_point").safeFirstText()
            chuniDataExtend.playCount = doc.getElementsByClass("user_data_play_count").safeFirstText()
            val jsonAdapterExtend = moshi.adapter(ChuniDataExtend::class.java)
            val jsonExtend = jsonAdapterExtend.toJson(chuniDataExtend)
            ShareUtil.putString("chuniDataExtend", jsonExtend, context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestPlayerData")
        }
    }

    private fun requestRatingDetailBest() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/home/playerData/ratingDetailBest"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            // Parse the rating detail best
            val chuniRatingBest  = mutableListOf<ChuniScore>()
            val ratingDetailBest = doc.getElementsByTag("form")
            for (rating in ratingDetailBest) {
                val title = rating.getElementsByClass("music_title").text()
                val highScore = rating.getElementsByClass("text_b").text()
                val id = rating.select("input[name=idx]").attr("value")
                val genre = rating.select("input[name=genre]").attr("value")
                val diff = rating.select("input[name=diff]").attr("value")
                val token = rating.select("input[name=token]").attr("value")
                chuniRatingBest.add(ChuniScore(id, title, genre, diff, token, highScore))
            }
            val jsonAdapter = moshi.adapter(List::class.java)
            val json = jsonAdapter.toJson(chuniRatingBest)
            ShareUtil.putString("chuniRatingDetailBest", json, context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailBest")
        }
    }
    private fun requestRatingDetailRecent() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/home/playerData/ratingDetailRecent"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            // Parse the rating detail recent
            val chuniRatingRecent  = mutableListOf<ChuniScore>()
            val ratingDetailRecent = doc.getElementsByTag("form")
            for (rating in ratingDetailRecent) {
                val title = rating.getElementsByClass("music_title").text()
                val highScore = rating.getElementsByClass("text_b").text()
                val id = rating.select("input[name=idx]").attr("value")
                val genre = rating.select("input[name=genre]").attr("value")
                val diff = rating.select("input[name=diff]").attr("value")
                val token = rating.select("input[name=token]").attr("value")
                chuniRatingRecent.add(ChuniScore(id, title, genre, diff, token, highScore))
            }
            val jsonAdapter = moshi.adapter(List::class.java)
            val json = jsonAdapter.toJson(chuniRatingRecent)
            ShareUtil.putString("chuniRatingDetailRecent", json, context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailRecent")
        }
    }
    private fun requestRatingDetailNext() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/home/playerData/ratingDetailNext"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            // Parse the rating detail next
            val chuniRatingNext  = mutableListOf<ChuniScore>()
            val ratingDetailNext = doc.getElementsByTag("form")
            for (rating in ratingDetailNext) {
                val title = rating.getElementsByClass("music_title").text()
                val highScore = rating.getElementsByClass("text_b").text()
                val id = rating.select("input[name=idx]").attr("value")
                val genre = rating.select("input[name=genre]").attr("value")
                val diff = rating.select("input[name=diff]").attr("value")
                val token = rating.select("input[name=token]").attr("value")
                chuniRatingNext.add(ChuniScore(id, title, genre, diff, token, highScore))
            }
            val jsonAdapter = moshi.adapter(List::class.java)
            val json = jsonAdapter.toJson(chuniRatingNext)
            ShareUtil.putString("chuniRatingDetailNext", json, context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailNext")
        }
    }
    private fun requestMapRecord() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/record"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            //TODO: Parse the map record
            ShareUtil.putString("chuniRecord", doc.toString(), context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestMapRecord")
        }
    }
    private fun requestPlayLog() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/record/playlog"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            val chuniPlayLog = mutableListOf<ChuniFullScore>()
            val playLog = doc.getElementsByClass("frame02 w400")
            for (log in playLog) {
                val title = log.getElementsByClass("play_musicdata_title").text()
                val level = log.getElementsByClass("play_track_result").select("img").attr("src")
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
                val jacket = log.getElementsByClass("play_jacket_img").select("img").attr("data-original")
                val date = log.getElementsByClass("play_datalist_date").text()
                val trackNumber = log.getElementsByClass("play_track_text").text().split(" ").last()
                chuniPlayLog.add(ChuniFullScore(
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
                ))
            }
            val jsonAdapter = moshi.adapter(List::class.java)
            val json = jsonAdapter.toJson(chuniPlayLog)
            ShareUtil.putString("chuniPlayLog", json, context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestPlayLog")
        }
    }
    private fun requestPlayRecord() {
        val diffArray = arrayOf("basic", "advanced", "expert", "master", "ultima")
        for (diff in diffArray) {
            try {
                val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/record/musicGenre/send$diff"))
                val header = connect.header("User-Agent", userAgent)
                header.cookie("_t", cookie.token)
                header.cookie("expires", cookie.expires)
                header.cookie("Max-Age", cookie.maxAge)
                header.cookie("path", cookie.path)
                header.cookie("SameSite", cookie.sameSite)
                header.cookie("userId", cookie.userId)
                header.cookie("friendCodeList", cookie.friendCodeList)
                connect.requestBody("genre=99&token=${cookie.token}")
                val response = connect.method(Connection.Method.POST).execute()
                val doc = response.parse()
                updateCookie(response)
                val allGenre = doc.getElementsByClass("box05 w400")
                val chuniGenre = mutableListOf<ChuniGenre>()
                for (genre in allGenre) {
                    val genreName = genre.getElementsByClass("genre_title").text()
                    val genreScore = genre.getElementsByClass("w388 musiclist_box bg_master")
                    val chuniScore = mutableListOf<ChuniFullScore>()
                    for (score in genreScore) {
                        val id = score.select("input[name=idx]").attr("value")
                        val title = score.getElementsByClass("music_title").text()
                        val level = score.select("input[name=diff]").attr("value")
                        val highScore = score.getElementsByClass("play_musicdata_highscore").safeFirstText()
                        val genreId = score.select("input[name=genre]").attr("value")
                        val token = score.select("input[name=token]").attr("value")
                        val marks = score.getElementsByClass("music_icon").select("img")
                        val clearMarks = marks.joinToString("") {
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
                        chuniScore.add(ChuniFullScore(
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
                            rank = rank,
                        ))
                    }
                    chuniGenre.add(ChuniGenre(genreName, chuniScore))
                }
                val jsonAdapter = moshi.adapter(List::class.java)
                val json = jsonAdapter.toJson(chuniGenre)
                ShareUtil.putString("chuniPlayRecord${diff[0].uppercaseChar()}${diff.substring(1)}", json, context)
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuMedalsThread")
            }
        }
    }
    private fun requestCollection() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/collection"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            ShareUtil.putString("chuniCollection", doc.toString(), context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread")
        }
    }
    private fun requestFriend() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/friend"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            ShareUtil.putString("chuniFriend", doc.toString(), context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread")
        }
    }

    private fun requestLoginBonus() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/loginBonus"))
            val header = connect.header("User-Agent", userAgent)
            header.cookie("_t", cookie.token)
            header.cookie("expires", cookie.expires)
            header.cookie("Max-Age", cookie.maxAge)
            header.cookie("path", cookie.path)
            header.cookie("SameSite", cookie.sameSite)
            header.cookie("userId", cookie.userId)
            header.cookie("friendCodeList", cookie.friendCodeList)
            val response = connect.execute()
            val doc = response.parse()
            updateCookie(response)
            ShareUtil.putString("chuniLoginBonus", doc.toString(), context)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread")
        }
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
        serviceScope.launch { mutex.withLock { requestPlayerData() }}
        serviceScope.launch { mutex.withLock { requestRatingDetailBest() }}
        serviceScope.launch { mutex.withLock { requestRatingDetailRecent() }}
        serviceScope.launch { mutex.withLock { requestRatingDetailNext() }}
        serviceScope.launch { mutex.withLock { requestMapRecord() }}
        serviceScope.launch { mutex.withLock { requestPlayLog() }}
        serviceScope.launch { mutex.withLock { requestPlayRecord() }}
        serviceScope.launch { mutex.withLock { requestCollection() }}
        serviceScope.launch { mutex.withLock { requestFriend() }}
        serviceScope.launch { mutex.withLock { requestLoginBonus() }}
        // Save the cookies
        ShareUtil.putString("chuniToken", cookie.token, context)
        ShareUtil.putString("chuniExpires", cookie.expires, context)
        ShareUtil.putString("chuniUserId", cookie.userId, context)
    }
}