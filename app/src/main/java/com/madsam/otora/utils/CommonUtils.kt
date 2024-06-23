package com.madsam.otora.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
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
     * @return 日时分秒字符串
     */
    fun secondToDHMS(value: Long): String {
        val day = value / (24 * 3600)
        val hour = value % (24 * 3600) / 3600
        val minute = value % 3600 / 60
        val second = value % 60
        return if (day > 0) {
            "${day}d${hour}h${minute}m${second}s"
        } else if (hour > 0) {
            "${hour}h${minute}m${second}s"
        } else if (minute > 0) {
            "${minute}m${second}s"
        } else {
            "${second}s"
        }
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
}
