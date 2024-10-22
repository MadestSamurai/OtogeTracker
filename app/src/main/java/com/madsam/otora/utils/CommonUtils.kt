package com.madsam.otora.utils

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationManagerCompat
import com.madsam.otora.consts.Colors
import com.madsam.otora.consts.GradientBrush
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

/**
 * 项目名: OtogeTracker
 * 文件名: Utils
 * 创建者: MadSamurai
 * 创建时间:2023/1/24 18:20
 * 描述: 工具类
 */

object CommonUtils {
    /**
     * 是否开启通知权限
     *
     * @param context 上下文
     */
    fun isNotificationListenerEnabled(context: Context): Boolean {
        val packageNames = NotificationManagerCompat.getEnabledListenerPackages(context)
        return packageNames.contains(context.packageName)
    }

    /**
     * 开启通知权限
     *
     * @param context 上下文
     */
    fun openNotificationListenSettings(context: Context) {
        try {
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

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
        val current = System.currentTimeMillis()
        val delta = current - dateCodeToMillis(value)
        return when {
            delta < 30 * 1000 -> "recent"
            delta < 60 * 1000 -> "${delta / 1000} seconds ago"
            delta < 60L * 60 * 1000 -> "${delta / (60L * 1000)} minute${if (delta / (60L * 1000) > 1) "s" else ""} ago"
            delta < 24L * 60 * 60 * 1000 -> "${delta / (60L * 60 * 1000)} hour${if (delta / (60L * 60 * 1000) > 1) "s" else ""} ago"
            delta < 7L * 24 * 60 * 60 * 1000 -> "${delta / (24L * 60 * 60 * 1000)} day${if (delta / (24L * 60 * 60 * 1000) > 1) "s" else ""} ago"
            delta < 30L * 24 * 60 * 60 * 1000 -> "${delta / (7L * 24 * 60 * 60 * 1000)} week${if (delta / (7L * 24 * 60 * 60 * 1000) > 1) "s" else ""} ago"
            delta < 365L * 24 * 60 * 60 * 1000 -> "${delta / (30L * 24 * 60 * 60 * 1000)} month${if (delta / (30L * 24 * 60 * 60 * 1000) > 1) "s" else ""} ago"
            delta >= 365L * 24 * 60 * 60 * 1000 * 10 -> "too long ago"
            else -> "${delta / (365L * 24 * 60 * 60 * 1000)} year${if (delta / (365L * 24 * 60 * 60 * 1000) > 1) "s" else ""} ago"
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
        return localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()
    }

    /**
     * 毫秒数时间戳转换为年月日时分秒
     *
     * @param millis 毫秒数时间戳
     * @return 年月日时分秒
     */
    fun millisToYmd(millis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), java.time.ZoneId.systemDefault())
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
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
        return String.format(Locale.getDefault(), "%.2f%%", value)
    }

    /**
     * 浮点数格式化成两位小数
     *
     * @param value 长整型
     * @return 两位小数字符串
     */
    fun formatNumber(number: Double): String {
        return if (number == number.toInt().toDouble()) {
            number.toInt().toString()
        } else {
            String.format("%.2f", number).replace(Regex("0*$"), "").replace(Regex("\\.$"), "")
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
            in 0..14 -> GradientBrush.OSU_LEVEL_WHITE
            in 15..29 -> GradientBrush.OSU_LEVEL_BLUE
            in 30..44 -> GradientBrush.OSU_LEVEL_GREEN
            in 45..59 -> GradientBrush.OSU_LEVEL_YELLOW
            in 60..69 -> GradientBrush.OSU_LEVEL_RED
            in 70..79 -> GradientBrush.OSU_LEVEL_PURPLE
            in 80..89 -> GradientBrush.OSU_LEVEL_BRONZE
            in 90..99 -> GradientBrush.OSU_LEVEL_SILVER
            in 100..104 -> GradientBrush.OSU_LEVEL_GOLD
            in 105..109 -> GradientBrush.OSU_LEVEL_PLATINUM
            else -> GradientBrush.OSU_LEVEL_RAINBOW
        }
    }

    /**
     * 获取Rating对应的颜色
     *
     * @param value 字符串
     * @return 颜色值
     */
    fun getRatingBrush(value: String): Color {
        try {
            val valueFloat = value.toFloat()
            return when (valueFloat) {
                in 15.25..16.00 -> Colors.OSU_LEVEL_PLATINUM_1
                in 14.50..15.24 -> Colors.OSU_LEVEL_GOLD_1
                in 14.25..14.49 -> Colors.OSU_LEVEL_SILVER_1
                else -> Colors.OSU_LEVEL_WHITE_1
            }
        } catch (nfe: NumberFormatException) {
            return Colors.OSU_LEVEL_WHITE_1
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
        return cookie.split(";")
            .map { it.trim() }
            .map { it.split("=") }
            .associate { it[0] to it[1] }
    }
}
