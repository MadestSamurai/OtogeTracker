package com.madsam.otora.core.utils

import java.util.Locale
import kotlin.math.floor

object CalcUtils {
    // Chuni Rating
    fun calcChuniRating(score: Int, level: Double): Double {
        val rating = when (score) {
            in 500000..800000 -> (level - 5) / 2 * (score-500000)/300000.0
            in 800001..900000 -> (level - 5) / 2 + (level - 5) / 2 * (score-800000)/100000.0
            in 900001..925000 -> level - 5 + (score-900000)*2/25000.0
            in 925001..975000 -> level - 3 + (score-925000)*3/50000.0
            in 975001..1000000 -> level + (score-975000)/25000.0
            in 1000001..1005000 -> level + 1 + (score-1000000)/10000.0
            in 1005001..1007500 -> level + 1.5 + (score-1005000)/5000.0
            in 1007501..1009000 -> level + 2 + (score-1007500)/10000.0
            in 1009001..1010000 -> level + 2.15
            else -> 0.0
        }
        val flooredRating = floor(if (rating < 0) 0.0 else rating * 100) / 100
        return String.format(Locale.US, "%.2f", flooredRating).toDouble()
    }
    // Chuni Rank
    fun calcChuniRank(score: Int): String {
        return when (score) {
            in 0..499999 -> "D"
            in 500000..599999 -> "C"
            in 600000..699999 -> "B"
            in 700000..799999 -> "BB"
            in 800000..899999 -> "BBB"
            in 900000..924999 -> "A"
            in 925000..949999 -> "AA"
            in 950000..974999 -> "AAA"
            in 975000..989999 -> "S"
            in 990000..999999 -> "S+"
            in 1000000..1004999 -> "SS"
            in 1005000..1007499 -> "SS+"
            in 1007501..1009000 -> "SSS"
            in 1009001..1010000 -> "SSS+"
            else -> "???"
        }
    }

    private val RANK_NAMES = arrayOf(
        "D", "C", "B", "BB", "BBB", "A", "AA", "AAA",
        "S", "S+", "SS", "SS+", "SSS", "SSS+"
    )

    fun numberToChuniRank(number: Int): String {
        return if (number in RANK_NAMES.indices) RANK_NAMES[number] else "?"
    }

    fun clearToChuniClear(clear: String): String {
        return when (clear) {
            "clear" -> "CLEAR"
            "hard" -> "HARD"
            "absolute" -> "ABS"
            "absolutep" -> "ABS+"
            "catastrophy" -> "CATAS"
            else -> clear.uppercase()
        }
    }

    fun comboToChuniCombo(combo: String): String {
        return when (combo) {
            "fullcombo" -> "FC"
            "alljustice" -> "AJ"
            "ajc" -> "AJC"
            else -> combo.uppercase()
        }
    }

    fun chainToChuniChain(chain: String): String {
        return when (chain) {
            "fullchain" -> "FCHAIN"
            "fullchain2" -> "FCHAIN+"
            else -> chain.uppercase()
        }
    }
}