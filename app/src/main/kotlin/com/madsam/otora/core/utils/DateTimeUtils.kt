package com.madsam.otora.core.utils

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

/**
 * 日期时间工具类
 * 
 * 提供日期时间转换、格式化等功能
 */
object DateTimeUtils {
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
}
