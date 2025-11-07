package com.madsam.otora.core.utils

import android.util.Log
import java.util.Locale

/**
 * 数字格式化工具类
 * 
 * 提供数字格式化、转换等功能
 */
object NumberFormatUtils {
    /**
     * 长整型格式化成千分位
     *
     * @param value 长整型
     * @return 带千分位分隔的字符串
     */
    fun formatThousand(value: Long): String {
        return String.format(Locale.getDefault(), "%,d", value)
    }

    /**
     * 浮点数格式化成百分比
     *
     * @param value 浮点数
     * @return 百分比字符串
     */
    fun formatPercent(value: Double): String {
        return String.format(Locale.getDefault(), "%.2f%%", value * 100)
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
            Log.e("NumberFormatUtils", "Big number value is not a number: $e")
            0
        }
    }
}
