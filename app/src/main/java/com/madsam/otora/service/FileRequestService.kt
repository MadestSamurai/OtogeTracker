package com.madsam.otora.service

import android.content.Context
import android.net.Uri
import com.madsam.otora.ui.record.RecordUpdateViewModel
import com.madsam.otora.utils.SafeSoupUtil.safeFirstAttr
import com.madsam.otora.utils.SafeSoupUtil.safeFirstText
import com.madsam.otora.utils.SafeSoupUtil.safePreviousElementSibling
import com.madsam.otora.utils.ShareUtil
import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.InputStreamReader

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

    fun fileAnalyser(fileContent: String, source: FilePickerSource, context: Context, recordUpdateViewModel: RecordUpdateViewModel){
        when (source) {
            FilePickerSource.CHUNI_PLAYDATA_BUTTON -> {
                // Store in SharedPreferences
                val doc = Jsoup.parse(fileContent)
                val playerCharaInfo = doc.getElementsByClass("player_chara_info").select("img").safeFirstAttr("src")
                val playerHonorBase = doc.getElementsByClass("player_honor_short").safeFirstAttr("style")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
                val playerHonorText = doc.getElementsByClass("player_honor_text").safeFirstText()
                val playerReborn = doc.getElementsByClass("player_reborn").safeFirstText()
                val playerLv = doc.getElementsByClass("player_lv").safeFirstText()
                val playerNameIn = doc.getElementsByClass("player_name_in").safeFirstText()
                val playerClassEmblemBaseBlock = doc.getElementsByClass("player_classemblem_base")
                val playerClassEmblemBase = playerClassEmblemBaseBlock.select("img").safeFirstAttr("src")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
                    .toIntOrNull() ?: 0
                val playerClassEmblemTopBlock = doc.getElementsByClass("player_classemblem_top")
                val playerClassEmblemTop = playerClassEmblemTopBlock.select("img").safeFirstAttr("src")
                    .split("/").last()
                    .split(".").first()
                    .split("_").last()
                    .toIntOrNull() ?: 0
                val playerRatingNumBlock = doc.getElementsByClass("player_rating_num_block")
                //解析playerRatingNumBlock中的数据
                val ratingImages = playerRatingNumBlock.select("img")
                // Find the comma separator
                val commaSeparator = doc.getElementsByClass("player_rating_comma").first()
                val commaIndex = ratingImages.indexOf(commaSeparator.safePreviousElementSibling()) + 1
                val playerRating = ratingImages.joinToString("") {
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
                val playerRatingMax = doc.getElementsByClass("player_rating_max").safeFirstText()
                val playerOverpower = doc.getElementsByClass("player_overpower_text").safeFirstText()
                val playerLastPlay = doc.getElementsByClass("player_lastplaydate_text").safeFirstText()
                val emptyCount = listOf(playerCharaInfo, playerHonorBase, playerHonorText, playerReborn, playerLv, playerNameIn, playerRating, playerRatingMax, playerOverpower, playerLastPlay).count { it.isEmpty() }
                if (emptyCount > 3) {
                    println("Empty fields found in the file")
                } else {
                    ShareUtil.putString("analysedText", "Player Chara Info: $playerCharaInfo\n" +
                            "Player Honor Base: $playerHonorBase\n" +
                            "Player Honor Text: $playerHonorText\n" +
                            "Player Reborn: $playerReborn\n" +
                            "Player Level: $playerLv\n" +
                            "Player Name: $playerNameIn\n" +
                            "Player Class Emblem Base: $playerClassEmblemBase\n" +
                            "Player Class Emblem Top: $playerClassEmblemTop\n" +
                            "Player Rating: $playerRating\n" +
                            "Player Rating Max: $playerRatingMax\n" +
                            "Player Overpower: $playerOverpower\n" +
                            "Player Last Play: $playerLastPlay", context)
                }
                recordUpdateViewModel.updatePickedFile()
            }
            FilePickerSource.BUTTON2 -> {
                // Handle the file picked from the second button
            }
        }
    }
}