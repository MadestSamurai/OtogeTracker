package com.madsam.otora.consts

import android.graphics.Color


object OsuDiffColor{
    private val domain = listOf(0.1f, 1.25f, 2f, 2.5f, 3.25f, 4.25f, 5f, 6f, 6.75f, 7.75f, 9f)
    private val range = listOf(
        hexToColor("#4290FB"),
        hexToColor("#4FC0FF"),
        hexToColor("#4FFFD5"),
        hexToColor("#7CFF4F"),
        hexToColor("#F6F05C"),
        hexToColor("#FF8068"),
        hexToColor("#FF4E6F"),
        hexToColor("#C645B8"),
        hexToColor("#6563DE"),
        hexToColor("#18158E"),
        hexToColor("#000000")
    )
    class DiffColor(val r: Int, val g: Int, val b: Int)

    private fun interpolateColor(
        color1: DiffColor,
        color2: DiffColor,
        factor: Float
    ): DiffColor {
        val r = (color1.r + factor * (color2.r - color1.r)).toInt()
        val g = (color1.g + factor * (color2.g - color1.g)).toInt()
        val b = (color1.b + factor * (color2.b - color1.b)).toInt()
        return DiffColor(r, g, b)
    }
    private fun hexToColor(hex: String): DiffColor {
        val color = Color.parseColor(hex)
        return DiffColor(
            Color.red(color),
            Color.green(color),
            Color.blue(color)
        )
    }
    private fun mapValueToDiffColor(value: Float): DiffColor {
        if (value >= 9) return hexToColor("#000000")
        if (value <= 0.1) return hexToColor("#AAAAAA")
        if (value <= domain.first()) return range.first()
        if (value >= domain.last()) return range.last()

        for (i in 0 until domain.size - 1) {
            if (value in domain[i]..domain[i + 1]) {
                val factor = (value - domain[i]) / (domain[i + 1] - domain[i])
                return interpolateColor(range[i], range[i + 1], factor)
            }
        }
        return range.last() // Fallback, should not reach here
    }
    fun mapValueToColor(value: Float): androidx.compose.ui.graphics.Color {
        val diffColor = mapValueToDiffColor(value)
        return androidx.compose.ui.graphics.Color(Color.rgb(diffColor.r, diffColor.g, diffColor.b))
    }
    fun mapValueToTextColor(value: Float): androidx.compose.ui.graphics.Color {
        val diffColor = mapValueToDiffColor(value)
        val luminance = 0.299 * diffColor.r + 0.587 * diffColor.g + 0.114 * diffColor.b
        return if (luminance > 128) androidx.compose.ui.graphics.Color.Black else androidx.compose.ui.graphics.Color.White
    }
}