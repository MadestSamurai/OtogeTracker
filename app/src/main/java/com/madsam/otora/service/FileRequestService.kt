package com.madsam.otora.service

import android.content.Context
import android.net.Uri
import com.madsam.otora.activity.MainViewModel
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.utils.SafeSoupUtil.safeFirstAttr
import com.madsam.otora.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.utils.SafeSoupUtil.safePreviousElementSibling
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure

enum class FilePickerSource {
    CHUNI_PLAYDATA_BUTTON, BUTTON2
}

class FileRequestService {
    fun readFileContent(context: Context, fileUri: Uri): String {
        val stringBuilder = StringBuilder()
        context.contentResolver.openInputStream(fileUri)?.use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                BufferedReader(inputStreamReader).use { reader ->
                    var line: String? = reader.readLine()
                    while (line != null) {
                        stringBuilder.append(line)
                        line = reader.readLine()
                    }
                }
            }
        }
        return stringBuilder.toString()
    }

    fun fileAnalyser(fileContent: String, source: FilePickerSource, context: Context, mainViewModel: MainViewModel){
        when (source) {
            FilePickerSource.CHUNI_PLAYDATA_BUTTON -> {
                // Store in SharedPreferences
                val doc = Jsoup.parse(fileContent)
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
                // 利用Kotlin反射检查数据是否正常获取
                val emptyCount = chuniCard::class.memberProperties.count {
                    it.returnType.jvmErasure == String::class && it.getter.call(chuniCard) == ""
                }
                if (emptyCount > 5) {
                    println("Empty fields found in the file")
                } else {
                    // Store the data in SharedPreferences, use moshi json
                    Moshi.Builder()
                        .addLast(KotlinJsonAdapterFactory())
                        .build().adapter(ChuniCard::class.java).toJson(chuniCard).also {
                        ShareUtil.putString("analysedText", it, context)
                    }
                }
                mainViewModel.updatePickedFile()
            }
            FilePickerSource.BUTTON2 -> {
                // Handle the file picked from the second button
            }
        }
    }
}