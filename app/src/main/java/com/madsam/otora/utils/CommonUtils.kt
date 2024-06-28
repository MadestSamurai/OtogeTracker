package com.madsam.otora.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.collection.ArrayMap
import androidx.compose.ui.graphics.Color
import androidx.core.app.NotificationManagerCompat
import com.madsam.otora.consts.Colors
import java.util.Locale

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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
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
     * 获取等级对应的颜色
     *
     * @param value 整型
     * @return 颜色值
     */
    fun getLevelColor(value: Int): Color {
        return when (value) {
            in 0..14 -> Colors.OSU_LEVEL_WHITE
            in 15..29 -> Colors.OSU_LEVEL_BLUE
            in 30..44 -> Colors.OSU_LEVEL_GREEN
            in 45..59 -> Colors.OSU_LEVEL_YELLOW
            in 60..69 -> Colors.OSU_LEVEL_RED
            in 70..79 -> Colors.OSU_LEVEL_PURPLE
            in 80..89 -> Colors.OSU_LEVEL_BRONZE
            in 90..94 -> Colors.OSU_LEVEL_SILVER
            in 95..99 -> Colors.OSU_LEVEL_GOLD
            else -> Colors.OSU_LEVEL_RUBY
        }
    }
}
