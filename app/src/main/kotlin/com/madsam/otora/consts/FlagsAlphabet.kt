package com.madsam.otora.consts

/**
 * 项目名: OtogeTracker
 * 文件名: Flags
 * 创建者: MadSamurai
 * 创建时间: 2024/6/12
 * 描述: 国旗字母转换器
 */
object FlagsAlphabet {
    private val FLAGS_ALPHABET: MutableMap<String, String> = HashMap()

    init {
        FLAGS_ALPHABET["A"] = "1f1e6"
        FLAGS_ALPHABET["B"] = "1f1e7"
        FLAGS_ALPHABET["C"] = "1f1e8"
        FLAGS_ALPHABET["D"] = "1f1e9"
        FLAGS_ALPHABET["E"] = "1f1ea"
        FLAGS_ALPHABET["F"] = "1f1eb"
        FLAGS_ALPHABET["G"] = "1f1ec"
        FLAGS_ALPHABET["H"] = "1f1ed"
        FLAGS_ALPHABET["I"] = "1f1ee"
        FLAGS_ALPHABET["J"] = "1f1ef"
        FLAGS_ALPHABET["K"] = "1f1f0"
        FLAGS_ALPHABET["L"] = "1f1f1"
        FLAGS_ALPHABET["M"] = "1f1f2"
        FLAGS_ALPHABET["N"] = "1f1f3"
        FLAGS_ALPHABET["O"] = "1f1f4"
        FLAGS_ALPHABET["P"] = "1f1f5"
        FLAGS_ALPHABET["Q"] = "1f1f6"
        FLAGS_ALPHABET["R"] = "1f1f7"
        FLAGS_ALPHABET["S"] = "1f1f8"
        FLAGS_ALPHABET["T"] = "1f1f9"
        FLAGS_ALPHABET["U"] = "1f1fa"
        FLAGS_ALPHABET["V"] = "1f1fb"
        FLAGS_ALPHABET["W"] = "1f1fc"
        FLAGS_ALPHABET["X"] = "1f1fd"
        FLAGS_ALPHABET["Y"] = "1f1fe"
        FLAGS_ALPHABET["Z"] = "1f1ff"
    }

    fun getFlagAlphabet(countryCode: String): String {
        var flag: String? = "https://osu.ppy.sh/assets/images/flags/"
        for (letter in countryCode) {
            flag += if (letter in 'A'..'Z') {
                FLAGS_ALPHABET[letter.toString()]
            } else {
                "1f1f6"
            }
            flag += "-"
        }
        flag = flag!!.substring(0, flag.length - 1) + ".svg"
        return flag
    }
}
