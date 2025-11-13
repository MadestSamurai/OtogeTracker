package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1

/**
 * PlayData 分类提供者
 * 提供各种分类方式的分类列表
 */
object ChunithmPlayDataCategoryProvider {
    
    /**
     * 获取难度分类列表
     */
    fun getDifficultyCategories(): List<PlayDataCategory> {
        return listOf(
            PlayDataCategory(
                type = PlayDataCategoryType.DIFFICULTY,
                name = "BASIC",
                key = "basic",
                color = CHUNI_DIFF_BASIC
            ),
            PlayDataCategory(
                type = PlayDataCategoryType.DIFFICULTY,
                name = "ADVANCED",
                key = "advanced",
                color = CHUNI_DIFF_ADVANCED
            ),
            PlayDataCategory(
                type = PlayDataCategoryType.DIFFICULTY,
                name = "EXPERT",
                key = "expert",
                color = CHUNI_DIFF_EXPERT
            ),
            PlayDataCategory(
                type = PlayDataCategoryType.DIFFICULTY,
                name = "MASTER",
                key = "master",
                color = CHUNI_DIFF_MASTER
            ),
            PlayDataCategory(
                type = PlayDataCategoryType.DIFFICULTY,
                name = "ULTIMA",
                key = "ultima",
                color = CHUNI_DIFF_ULTIMA_1
            )
        )
    }
    
    /**
     * 获取类型（Genre）分类列表
     * 基于 CHUNITHM 常见曲目类型
     */
    fun getGenreCategories(): List<PlayDataCategory> {
        return listOf(
            PlayDataCategory(PlayDataCategoryType.GENRE, "POPS & ANIME", "POPS & ANIME"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "niconico", "niconico"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "東方Project", "東方Project"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "VARIETY", "VARIETY"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "イロドリミドリ", "イロドリミドリ"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "ゲキマイ", "ゲキマイ"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "ORIGINAL", "ORIGINAL"),
            PlayDataCategory(PlayDataCategoryType.GENRE, "WORLD'S END", "WORLD'S END")
        )
    }
    
    /**
     * 获取版本分类列表
     * 基于 CHUNITHM 历代版本
     */
    fun getVersionCategories(): List<PlayDataCategory> {
        return listOf(
            PlayDataCategory(PlayDataCategoryType.VERSION, "LUMINOUS", "LUMINOUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "SUN PLUS", "SUN PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "SUN", "SUN"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "NEW PLUS", "NEW PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "NEW", "NEW"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "PARADISE LOST", "PARADISE LOST"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "PARADISE", "PARADISE"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "CRYSTAL PLUS", "CRYSTAL PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "CRYSTAL", "CRYSTAL"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "AMAZON PLUS", "AMAZON PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "AMAZON", "AMAZON"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "STAR PLUS", "STAR PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "STAR", "STAR"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "AIR PLUS", "AIR PLUS"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "AIR", "AIR"),
            PlayDataCategory(PlayDataCategoryType.VERSION, "CHUNITHM", "CHUNITHM")
        )
    }
    
    /**
     * 获取定数（Level）分类列表
     * 基于难度数值范围
     */
    fun getLevelCategories(): List<PlayDataCategory> {
        return listOf(
            PlayDataCategory(PlayDataCategoryType.LEVEL, "15", "15.0-15.9"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "14+", "14.7-14.9"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "14", "14.0-14.6"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "13+", "13.7-13.9"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "13", "13.0-13.6"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "12+", "12.7-12.9"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "11-12", "11.0-12.6"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "6-10", "6.0-10.9"),
            PlayDataCategory(PlayDataCategoryType.LEVEL, "1-5", "1.0-5.9")
        )
    }
    
    /**
     * 根据分类类型获取对应的分类列表
     */
    fun getCategoriesByType(type: PlayDataCategoryType): List<PlayDataCategory> {
        return when (type) {
            PlayDataCategoryType.DIFFICULTY -> getDifficultyCategories()
            PlayDataCategoryType.GENRE -> getGenreCategories()
            PlayDataCategoryType.VERSION -> getVersionCategories()
            PlayDataCategoryType.LEVEL -> getLevelCategories()
        }
    }
}
