package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChuniUserDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.chunithmUserDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_user")

/**
 * Chunithm 用户数据 DataStore 服务
 * 使用 DataStore Preferences 存储用户配置数据
 */
internal class ChunithmUserDataStore(private val context: Context) {
    
    companion object {
        // 基本信息
        private val NAME_IN = stringPreferencesKey("name_in")
        private val PROFILE_BACKGROUND = stringPreferencesKey("profile_background")
        private val REBORN = intPreferencesKey("reborn")
        private val LEVEL = intPreferencesKey("level")
        private val RATING = stringPreferencesKey("rating")
        private val OVERPOWER = stringPreferencesKey("overpower")
        private val LAST_PLAY = stringPreferencesKey("last_play")
        
        // 角色信息
        private val ROLE_IMAGE_URL = stringPreferencesKey("role_image_url")
        private val ROLE_BASE = stringPreferencesKey("role_base")
        
        // 荣誉称号（支持最多3个）
        private val HONOR_1 = stringPreferencesKey("honor_1")
        private val HONOR_2 = stringPreferencesKey("honor_2")
        private val HONOR_3 = stringPreferencesKey("honor_3")
        
        // 荣誉背景类型（支持最多3个）
        private val HONOR_BASE_1 = stringPreferencesKey("honor_base_1")
        private val HONOR_BASE_2 = stringPreferencesKey("honor_base_2")
        private val HONOR_BASE_3 = stringPreferencesKey("honor_base_3")
        
        // 徽章信息
        private val CLASS_EMBLEM_TOP = stringPreferencesKey("class_emblem_top")
        private val CLASS_EMBLEM_BASE = stringPreferencesKey("class_emblem_base")
    }
    
    /**
     * 保存用户数据
     */
    suspend fun saveUserData(user: ChuniUserDTO) {
        context.chunithmUserDataStore.edit { preferences ->
            preferences[NAME_IN] = user.nameIn
            preferences[PROFILE_BACKGROUND] = user.profileBackground
            preferences[REBORN] = user.reborn
            preferences[LEVEL] = user.level
            preferences[RATING] = user.rating
            preferences[OVERPOWER] = user.overpower
            preferences[LAST_PLAY] = user.lastPlay
            preferences[ROLE_IMAGE_URL] = user.roleImageUrl
            preferences[ROLE_BASE] = user.roleBase
            preferences[HONOR_1] = user.honor1
            preferences[HONOR_2] = user.honor2
            preferences[HONOR_3] = user.honor3
            preferences[HONOR_BASE_1] = user.honorBase1
            preferences[HONOR_BASE_2] = user.honorBase2
            preferences[HONOR_BASE_3] = user.honorBase3
            preferences[CLASS_EMBLEM_TOP] = user.classEmblemTop
            preferences[CLASS_EMBLEM_BASE] = user.classEmblemBase
        }
    }
    
    /**
     * 获取用户数据 Flow
     */
    fun getUserDataFlow(): Flow<ChuniUserDTO?> {
        return context.chunithmUserDataStore.data.map { preferences ->
            val nameIn = preferences[NAME_IN] ?: ""
            if (nameIn.isEmpty()) {
                null
            } else {
                ChuniUserDTO(
                    nameIn = nameIn,
                    profileBackground = preferences[PROFILE_BACKGROUND] ?: "",
                    reborn = preferences[REBORN] ?: 0,
                    level = preferences[LEVEL] ?: 0,
                    rating = preferences[RATING] ?: "",
                    overpower = preferences[OVERPOWER] ?: "",
                    lastPlay = preferences[LAST_PLAY] ?: "",
                    roleImageUrl = preferences[ROLE_IMAGE_URL] ?: "",
                    roleBase = preferences[ROLE_BASE] ?: "",
                    honor1 = preferences[HONOR_1] ?: "",
                    honor2 = preferences[HONOR_2] ?: "",
                    honor3 = preferences[HONOR_3] ?: "",
                    honorBase1 = preferences[HONOR_BASE_1] ?: "",
                    honorBase2 = preferences[HONOR_BASE_2] ?: "",
                    honorBase3 = preferences[HONOR_BASE_3] ?: "",
                    classEmblemTop = preferences[CLASS_EMBLEM_TOP] ?: "",
                    classEmblemBase = preferences[CLASS_EMBLEM_BASE] ?: ""
                )
            }
        }
    }
    
    /**
     * 获取用户数据（一次性）
     */
    /**
     * 获取用户数据（挂起函数）
     * 获取当前 DataStore 中的第一个值
     */
    suspend fun getUserData(): ChuniUserDTO? {
        return getUserDataFlow().first()
    }
    
    /**
     * 清除用户数据
     */
    suspend fun clearUserData() {
        context.chunithmUserDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
