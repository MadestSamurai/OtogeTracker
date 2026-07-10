package com.madsam.otora.ui.record.osu.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.madsam.otora.R
import com.madsam.otora.core.utils.DateTimeUtils.dateCodeToMillis
import java.util.Locale

private const val SecondMillis = 1_000L
private const val MinuteMillis = 60 * SecondMillis
private const val HourMillis = 60 * MinuteMillis
private const val DayMillis = 24 * HourMillis
private const val WeekMillis = 7 * DayMillis
private const val MonthMillis = 30 * DayMillis
private const val YearMillis = 365 * DayMillis

@Composable
internal fun localizedRelativeTime(value: String): String {
    val timestamp = remember(value) { dateCodeToMillis(value) }
    if (timestamp <= 0L) return stringResource(R.string.osu_time_unknown)

    val delta = (System.currentTimeMillis() - timestamp).coerceAtLeast(0L)
    return when {
        delta < 30 * SecondMillis -> stringResource(R.string.osu_time_just_now)
        delta < MinuteMillis -> relativeQuantity(R.plurals.osu_time_seconds_ago, delta / SecondMillis)
        delta < HourMillis -> relativeQuantity(R.plurals.osu_time_minutes_ago, delta / MinuteMillis)
        delta < DayMillis -> relativeQuantity(R.plurals.osu_time_hours_ago, delta / HourMillis)
        delta < WeekMillis -> relativeQuantity(R.plurals.osu_time_days_ago, delta / DayMillis)
        delta < MonthMillis -> relativeQuantity(R.plurals.osu_time_weeks_ago, delta / WeekMillis)
        delta < YearMillis -> relativeQuantity(R.plurals.osu_time_months_ago, delta / MonthMillis)
        delta < 20 * YearMillis -> relativeQuantity(R.plurals.osu_time_years_ago, delta / YearMillis)
        else -> stringResource(R.string.osu_time_long_ago)
    }
}

@Composable
private fun relativeQuantity(resourceId: Int, count: Long): String {
    val safeCount = count.coerceAtLeast(1L).coerceAtMost(Int.MAX_VALUE.toLong()).toInt()
    return pluralStringResource(resourceId, safeCount, safeCount)
}

@Composable
internal fun localizedPlayStyle(playStyle: String): String {
    val labels = mapOf(
        "mouse" to stringResource(R.string.osu_play_style_mouse),
        "keyboard" to stringResource(R.string.osu_play_style_keyboard),
        "tablet" to stringResource(R.string.osu_play_style_tablet),
        "touch" to stringResource(R.string.osu_play_style_touch)
    )
    val separator = stringResource(R.string.osu_list_separator)
    return playStyle
        .split(',')
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .joinToString(separator) { labels[it.lowercase(Locale.ROOT)] ?: it }
}

@Composable
internal fun localizedCountryName(countryCode: String, fallback: String): String {
    val locale = LocalConfiguration.current.locales[0]
    return remember(countryCode, fallback, locale) {
        runCatching {
            Locale.Builder()
                .setRegion(countryCode.uppercase(Locale.ROOT))
                .build()
                .getDisplayCountry(locale)
                .ifBlank { fallback }
        }.getOrDefault(fallback)
    }
}

@Composable
internal fun localizedBeatmapStatus(status: String): String = when (status.lowercase(Locale.ROOT)) {
    "qualified" -> stringResource(R.string.osu_status_qualified)
    "approved" -> stringResource(R.string.osu_status_approved)
    "loved" -> stringResource(R.string.osu_status_loved)
    else -> status
}
