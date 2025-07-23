package com.madsam.otora.core.utils

import android.util.Log
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.GradientBrush.BlueGradientBg
import com.madsam.otora.core.theme.GradientBrush.BronzeGradientBg
import com.madsam.otora.core.theme.GradientBrush.BronzeGradientText
import com.madsam.otora.core.theme.GradientBrush.GoldGradientBg
import com.madsam.otora.core.theme.GradientBrush.GoldGradientText
import com.madsam.otora.core.theme.GradientBrush.GreenGradientBg
import com.madsam.otora.core.theme.GradientBrush.GreenGradientText
import com.madsam.otora.core.theme.GradientBrush.PlatinumGradientBg
import com.madsam.otora.core.theme.GradientBrush.PlatinumGradientText
import com.madsam.otora.core.theme.GradientBrush.PurpleGradientBg
import com.madsam.otora.core.theme.GradientBrush.PurpleGradientText
import com.madsam.otora.core.theme.GradientBrush.RainbowGradientBg
import com.madsam.otora.core.theme.GradientBrush.RainbowGradientText
import com.madsam.otora.core.theme.GradientBrush.RedGradientBg
import com.madsam.otora.core.theme.GradientBrush.RedGradientText
import com.madsam.otora.core.theme.GradientBrush.SilverGradientBg
import com.madsam.otora.core.theme.GradientBrush.SilverGradientText
import com.madsam.otora.core.theme.GradientBrush.WhiteGradientBg
import com.madsam.otora.core.theme.GradientBrush.WhiteGradientText
import com.madsam.otora.core.theme.GradientBrush.YellowGradientBg
import com.madsam.otora.core.theme.GradientBrush.YellowGradientText
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.text.DecimalFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

object CommonUtils {
    /**
     * 秒转换为日时分秒
     *
     * @param value 秒数
     * @return 日时分秒,逗号分隔
     */
    fun secondToDHMS(value: Long): String {
        val day = value / (24 * 3600)
        val hour = value % (24 * 3600) / 3600
        val minute = value % 3600 / 60
        val second = value % 60
        return String.format(Locale.getDefault(), "%d,%d,%d,%d", day, hour, minute, second)
    }

    /**
     * 日期码转换为年月日时分秒
     *
     * @param value 日期码 格式 2011-03-25T11:21:02+00:00
     * @return 年月日时分秒+UTC
     */
    fun dateCodeToYMDHMSU(value: String): String {
        val millis = dateCodeToMillis(value)
        val offsetDateTime = OffsetDateTime.ofInstant(
            Instant.ofEpochMilli(millis),
            TimeZone.getDefault().toZoneId()
        )
        val utc = TimeZone.getDefault().rawOffset / 3600000
        val utcStr = if (utc >= 0) "+$utc" else utc.toString()
        return offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC${utcStr}'"))
    }

    /**
     * 日期码转换为毫秒数时间戳
     *
     * @param value 日期码 格式 2011-03-25T11:21:02+00:00
     * @return 毫秒数时间戳
     */
    fun dateCodeToMillis(value: String): Long {
        if (value.isEmpty()) return 0L
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        val offsetDateTime = OffsetDateTime.parse(value, formatter)
        return offsetDateTime.toInstant().toEpochMilli()
    }

    /**
     * 毫秒数时间戳转换为日期码
     *
     * @param value 毫秒数时间戳
     * @return 日期码
     */
    fun millisToDateCode(value: Long): String {
        val offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneOffset.UTC)
        return offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    /**
     * 日期码转换为最近时间
     * 少于30秒显示刚刚,少于1分钟显示秒,少于1小时显示分钟,少于1天显示小时,少于1周显示天,少于1月显示周,少于1年显示月,否则显示年
     *
     * @param value 日期码 格式 2011-03-25T11:21:02+00:00
     * @return 最近时间
     */
    fun dateCodeToRecent(value: String): String {
        val delta = System.currentTimeMillis() - dateCodeToMillis(value)

        val timeMap = mapOf(
            30 * 1000L to "recent",
            60 * 1000L to "seconds",
            60L * 60 * 1000 to "minute",
            24L * 60 * 60 * 1000 to "hour",
            7L * 24 * 60 * 60 * 1000 to "day",
            30L * 24 * 60 * 60 * 1000 to "week",
            365L * 24 * 60 * 60 * 1000 to "month"
        )

        timeMap.entries.find { delta < it.key }?.let { current ->
            if (current.value == "recent") return "recent"

            val prev = timeMap.entries.toList().getOrNull(
                timeMap.entries.indexOf(current) - 1
            ) ?: return "error"

            val count = delta / prev.key
            return "$count ${prev.value}${if (count > 1) "s" else ""} ago"
        }

        return if (delta >= 365L * 24 * 60 * 60 * 1000 * 20) {
            "too long ago"
        } else {
            val years = delta / (365L * 24 * 60 * 60 * 1000)
            "$years year${if (years > 1) "s" else ""} ago"
        }
    }

    /**
     * 年月日时分秒转换为时间戳
     *
     * @param date 年月日 格式 2011-03-25
     * @param time 时分秒 格式 11:21:02
     * @return 毫秒数时间戳
     */
    fun ymdToMillis(date: String, time: String): Long {
        val localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE)
        val timeWithoutSeconds = time.substring(0, 5) + ":00"
        val localTime = LocalTime.parse(timeWithoutSeconds, DateTimeFormatter.ISO_TIME)
        val localDateTime = LocalDateTime.of(localDate, localTime)
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }

    /**
     * 毫秒数时间戳转换为年月日时分秒
     *
     * @param millis 毫秒数时间戳
     * @return 年月日时分秒
     */
    fun millisToYmd(millis: Long): String {
        val localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault())
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    /**
     * 毫秒数时间戳转换为年月日
     *
     * @param millis 毫秒数时间戳
     * @return 年月日
     */
    fun millisToDate(millis: Long): LocalDate {
        val localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault())
        return localDateTime.toLocalDate()
    }

    /**
     * 时间向下取整到最近的五分钟
     *
     * @param hm 时间 格式 11:21
     * @return 时间 格式 11:20:00
     */
    fun roundDownToNearestFiveMinutes(hm: String): String {
        val parts = hm.split(":").map { it.toInt() }
        if (parts.size != 2) {
            return "Invalid Time"
        }
        val hours = parts[0]
        val minutes = parts[1] / 5 * 5
        return String.format(Locale.getDefault(), "%02d:%02d:00", hours, minutes)
    }

    /**
     * 长整型格式化成千分位
     *
     * @param value 长整型
     * @return 带千分位分隔的字符串
     */
    fun formatNumberThousand(value: Long): String {
        return String.format(Locale.getDefault(), "%,d", value)
    }

    /**
     * 浮点数格式化成百分比
     *
     * @param value 长整型
     * @return 百分比字符串
     */
    fun formatPercent(value: Double): String {
        return String.format(Locale.getDefault(), "%.2f%%", value * 100)
    }

    /**
     * 浮点数格式化成最多两位小数
     *
     * @param number 长整型
     * @return 最多两位小数字符串
     */
    fun truncateToTwoDecimalPlaces(number: Double): String {
        val decimalFormat = DecimalFormat("#.##")
        return decimalFormat.format(number)
    }

    /**
     * 大数字符串转换为整型
     *
     * @param value 字符串
     * @return 整型
     */
    fun bigNumberToInt(value: String): Int {
        return try {
            value.replace(",", "").toInt()
        } catch (e: NumberFormatException) {
            Log.e("CommonUtils", "Big number value is not a number: $e")
            0
        }
    }

    /**
     * 获取等级对应的颜色
     *
     * @param value 整型
     * @return 颜色值
     */
    fun getLevelBrush(value: Int): Brush {
        return when (value) {
            in 0..14 -> WhiteGradientBg
            in 15..29 -> BlueGradientBg
            in 30..44 -> GreenGradientBg
            in 45..59 -> YellowGradientBg
            in 60..69 -> RedGradientBg
            in 70..79 -> PurpleGradientBg
            in 80..89 -> BronzeGradientBg
            in 90..99 -> SilverGradientBg
            in 100..104 -> GoldGradientBg
            in 105..109 -> PlatinumGradientBg
            else -> RainbowGradientBg
        }
    }

    /**
     * 获取Rating对应的颜色
     *
     * @param value 字符串
     * @return 颜色值
     */
    fun getRatingBrush(value: String): Brush {
        try {
            val valueFloat = value.toFloat()
            return when (valueFloat) {
                in 0.00..3.999 -> GreenGradientText
                in 4.00..6.999 -> YellowGradientText
                in 7.00..9.999 -> RedGradientText
                in 10.00..11.999 -> PurpleGradientText
                in 12.00..13.249 -> BronzeGradientText
                in 13.25..14.499 -> SilverGradientText
                in 14.50..15.249 -> GoldGradientText
                in 15.25..15.999 -> PlatinumGradientText
                in 16.00..18.000 -> RainbowGradientText
                else -> WhiteGradientText
            }
        } catch (nfe: NumberFormatException) {
            Log.e("CommonUtils", "Rating value is not a number: $nfe")
            return WhiteGradientText
        }
    }

    /**
     * URL编码
     *
     * @param url 字符串
     * @return 编码后的字符串
     */
    fun encodeURL(url: String): String {
        val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
        return encodedUrl.replace("%3A", ":").replace("%2F", "/")
    }

    /**
     * 大数字符串处理标记文本
     *
     * @param value 字符串
     * @return 处理后的字符串标记文本
     */
    fun bigNumberTextFormat(value: String, textSize: TextUnit): AnnotatedString {
        val split = value.split(",")
        val text = if (split.size > 2) {
            val splitSize = split.size - 2
            val firstPart = split.dropLast(splitSize).joinToString(",")
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold)) {
                    append(firstPart)
                }
                withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                    append(",${split.takeLast(splitSize).joinToString(",")}")
                }
            }
        } else {
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold)) {
                    append(split.joinToString(","))
                }
            }
        }
        return text
    }

    /**
     * Cookie处理为键值对
     *
     * @param cookie 字符串
     * @return 字符串键值对
     */
    fun parseCookie(cookie: String): Map<String, String> {
        val cookieMap = cookie.split(";")
            .map { it.trim() }
            .map { it.split("=") }
        return if (cookieMap.size < 2) {
            mapOf()
        } else {
            cookieMap.associate { it[0] to it[1] }
        }
    }
}
