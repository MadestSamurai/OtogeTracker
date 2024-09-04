package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.entity.chuni.ChuniCookie
import com.madsam.otora.utils.CommonUtils
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
    private fun requestHome() {
        try {
            val connect = Jsoup.connect(CommonUtils.encodeURL("$URL/home"))
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
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val jsonAdapter = moshi.adapter(ChuniCard::class.java)
                val json = jsonAdapter.toJson(chuniCard)
                println(json)
                ShareUtil.putString("chuniCard", json, context)
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread")
        }
    }

    private fun requestRecord() {
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
            val mapTitle = doc.getElementsByClass("map_title_text text_l text_b").text()
            println(mapTitle)
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
        serviceScope.launch { mutex.withLock { requestHome() }}
        serviceScope.launch { mutex.withLock { requestRecord() }}
        // Save the cookies
        ShareUtil.putString("chuniToken", cookie.token, context)
        ShareUtil.putString("chuniExpires", cookie.expires, context)
        ShareUtil.putString("chuniUserId", cookie.userId, context)
    }
}