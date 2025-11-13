package com.madsam.otora.data.chunithm.ui.model

import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.data.chunithm.local.objectbox.ChunithmObjectBoxService
import kotlinx.coroutines.runBlocking

/**
 * PlayData 分类提供者
 * 提供各种分类方式的分类列表
 * 
 * Genre 和 Version 数据从数据库加载，首次访问时缓存
 */
object ChunithmPlayDataCategoryProvider {
    
    // 缓存的 genre 分类列表
    private var cachedGenreCategories: List<PlayDataCategory>? = null
    
    // 缓存的 version 分类列表
    private var cachedVersionCategories: List<PlayDataCategory>? = null
    
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
     * 从数据库动态获取所有不重复的 genre，首次加载后缓存
     */
    fun getGenreCategories(): List<PlayDataCategory> {
        // 如果已有缓存，直接返回
        cachedGenreCategories?.let { return it }
        
        // 首次加载：从数据库查询
        return runBlocking {
            val objectBoxService = ChunithmObjectBoxService()
            val allSongs = objectBoxService.getAllSongData()
            
            // 获取所有不重复的 genre，按字母顺序排序
            val uniqueGenres = allSongs
                .map { it.genre }
                .filter { it.isNotBlank() }
                .distinct()
                .sorted()
            
            val categories = uniqueGenres.map { genre ->
                PlayDataCategory(PlayDataCategoryType.GENRE, genre, genre)
            }
            
            // 缓存结果
            cachedGenreCategories = categories
            categories
        }
    }
    
    /**
     * 获取版本分类列表
     * 从数据库动态获取所有不重复的 version，首次加载后缓存
     */
    fun getVersionCategories(): List<PlayDataCategory> {
        // 如果已有缓存，直接返回
        cachedVersionCategories?.let { return it }
        
        // 首次加载：从数据库查询
        return runBlocking {
            val objectBoxService = ChunithmObjectBoxService()
            val allSongs = objectBoxService.getAllSongData()
            
            // 获取所有不重复的 version，保持原有顺序（最新的在前）
            val uniqueVersions = allSongs
                .map { it.version }
                .filter { it.isNotBlank() }
                .distinct()
            
            val categories = uniqueVersions.map { version ->
                PlayDataCategory(PlayDataCategoryType.VERSION, version, version)
            }
            
            // 缓存结果
            cachedVersionCategories = categories
            categories
        }
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
    
    /**
     * 刷新分类数据缓存
     * 在数据库更新后调用此方法以重新加载最新的分类数据
     */
    fun refreshCategories() {
        cachedGenreCategories = null
        cachedVersionCategories = null
    }
}
