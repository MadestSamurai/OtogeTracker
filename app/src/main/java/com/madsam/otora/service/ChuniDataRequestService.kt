package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.database.DatabaseProvider
import com.madsam.otora.entity.chunithm.ChuniSheetsEntity
import com.madsam.otora.entity.chunithm.ChuniSongsEntity
import com.madsam.otora.model.chuni.net.ChuniCard
import com.madsam.otora.model.chuni.net.ChuniCookie
import com.madsam.otora.model.chuni.net.ChuniDataExtend
import com.madsam.otora.model.chuni.net.ChuniFullScore
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.model.chuni.net.ChuniScore
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
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.jsoup.Connection
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure
import kotlin.text.category

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
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(NullToDefaultIntAdapter())
        .add(NullToDefaultDoubleAdapter())
        .add(NullToDefaultBooleanAdapter())
        .add(NullToEmptyStringListAdapter())
        .add(NullToEmptyIntListAdapter())
        .addLast(KotlinJsonAdapterFactory())
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
                JsonUtil.saveJsonToFile(context, "chuniCard.json", jsonCard)
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
            JsonUtil.saveJsonToFile(context, "chuniPenguin.json", jsonPenguin)
            // Parse the extend data
            val chuniDataExtend = ChuniDataExtend()
            chuniDataExtend.friendCode = doc.getElementsByClass("user_data_friend_code").safeFirst()
                .getElementsByAttributeValue("style", "display:none;").text()
            chuniDataExtend.point = doc.getElementsByClass("user_data_point").safeFirstText()
            chuniDataExtend.totalPoint = doc.getElementsByClass("user_data_total_point").safeFirstText()
            chuniDataExtend.playCount = doc.getElementsByClass("user_data_play_count").safeFirstText()
            val jsonAdapterExtend = moshi.adapter(ChuniDataExtend::class.java)
            val jsonExtend = jsonAdapterExtend.toJson(chuniDataExtend)
            JsonUtil.saveJsonToFile(context, "chuniDataExtend.json", jsonExtend)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestPlayerData: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniRatingDetailBest.json", json)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailBest: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniRatingDetailRecent.json", json)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailRecent: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniRatingDetailNext.json", json)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestRatingDetailNext: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniMapRecord.json", doc.toString())
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestMapRecord: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniPlayLog.json", json)
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestPlayLog: ${e.message}")
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
                    val genreName = genre.getElementsByClass("genre scroll_point text_white").text()
                    val genreScore = genre.getElementsByClass("w388 musiclist_box bg_master")
                    val chuniScore = mutableListOf<ChuniFullScore>()
                    for (score in genreScore) {
                        val highScore = score.getElementsByClass("play_musicdata_highscore")
                            .select("span").text()
                        val title = score.getElementsByClass("music_title").text()

                        val id = score.select("input[name=idx]").attr("value")
                        val level = score.select("input[name=diff]").attr("value")
                        val genreId = score.select("input[name=genre]").attr("value")
                        val token = score.select("input[name=token]").attr("value")

                        val marks = score.getElementsByClass("play_musicdata_icon clearfix").select("img")
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
                            isFullChain2 = isFullChain2,
                            rank = rank,
                        ))
                    }
                    chuniGenre.add(ChuniGenre(genreName, chuniScore))
                }
                val jsonAdapter = moshi.adapter(List::class.java)
                val json = jsonAdapter.toJson(chuniGenre)
                JsonUtil.saveJsonToFile(context, "chuniPlayRecord${diff[0].uppercaseChar()}${diff.substring(1)}.json", json)
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuMedalsThread: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniCollection.json", doc.toString())
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniFriend.json", doc.toString())
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread: ${e.message}")
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
            JsonUtil.saveJsonToFile(context, "chuniLoginBonus.json", doc.toString())
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread: ${e.message}")
        }
    }

    private fun requestSongsDatas() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dp4p6x0xfi5o9.cloudfront.net")
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // Moshi
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // RxJava
            .build()
        val api = retrofit.create(Api::class.java)
        try {
            val chuniSongsCall = api.getChunithmSongsData()
            val response = chuniSongsCall.execute()
            if (response.isSuccessful) {
                val chuniDatas = response.body()
                if (chuniDatas != null) {
                    val chuniSongs = chuniDatas.songs
                    val realm = Realm.getDefaultInstance()
                    realm.executeTransaction { transactionRealm ->
                        for (song in chuniSongs) {
                            val chuniSongEntity = ChuniSongsEntity().apply {
                                id = song.songId
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
                            }
                            transactionRealm.copyToRealmOrUpdate(chuniSongEntity)

                            for (sheet in song.sheets) {
                                val chuniSheetEntity = ChuniSheetsEntity().apply {
                                    id = "${song.songId}_${sheet.difficulty}"
                                    type = sheet.type
                                    difficulty = sheet.difficulty
                                    level = sheet.level
                                    levelValue = sheet.levelValue
                                    internalLevel = sheet.internalLevel
                                    internalLevelValue = sheet.internalLevelValue
                                    noteDesigner = sheet.noteDesigner
                                    tap = sheet.noteCounts.tap
                                    hold = sheet.noteCounts.hold
                                    slide = sheet.noteCounts.slide
                                    air = sheet.noteCounts.air
                                    flick = sheet.noteCounts.flick
                                    total = sheet.noteCounts.total
                                    jp = sheet.regions.jp
                                    intl = sheet.regions.intl
                                    isSpecial = sheet.isSpecial
                                }
                                transactionRealm.copyToRealmOrUpdate(chuniSheetEntity)
                            }
                        }
                    }
                    realm.close()
                } else {
                    Log.e(TAG, "Failed to get the songs data")
                }
            } else {
                Log.e(TAG, "Failed to get the songs data")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in ChuniData-requestSongsDatas: ${e.message}")
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

    fun getChuniSongsData() {
        serviceScope.launch { mutex.withLock { requestSongsDatas() }}
    }

    // Get songs data from the database
    suspend fun getChuniSongData(title: String): ChuniSongsEntity {
        return withContext(Dispatchers.IO) {
            val realm = Realm.getDefaultInstance()
            try {
                val song = realm.where(ChuniSongsEntity::class.java)
                    .equalTo("id", title)
                    .findFirst()
                song?.let { realm.copyFromRealm(it) } ?: ChuniSongsEntity()
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
            val realm = Realm.getDefaultInstance()
            try {
                val sheet = realm.where(ChuniSheetsEntity::class.java)
                    .equalTo("id", "${title}_${diff}")
                    .findFirst()
                println(sheet)
                sheet?.let { realm.copyFromRealm(it) } ?: ChuniSheetsEntity()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the sheet data: ${e.message}")
                ChuniSheetsEntity()
            } finally {
                realm.close()
            }
        }
    }
}