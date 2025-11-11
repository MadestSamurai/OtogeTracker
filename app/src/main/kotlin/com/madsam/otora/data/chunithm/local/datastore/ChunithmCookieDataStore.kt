package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChunithmCookieDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.chunithmCookieDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_cookie")

/**
 * Chunithm Cookie DataStore 服务
 * 存储网络请求所需的 Cookie 信息
 */
internal class ChunithmCookieDataStore(private val context: Context) {

    companion object {
        private val TOKEN = stringPreferencesKey("chuni_token")
        private val EXPIRES = stringPreferencesKey("chuni_expires")
        private val MAX_AGE = stringPreferencesKey("chuni_max_age")
        private val PATH = stringPreferencesKey("chuni_path")
        private val SAME_SITE = stringPreferencesKey("chuni_same_site")
        private val USER_ID = stringPreferencesKey("chuni_user_id")
        private val FRIEND_CODE_LIST = stringPreferencesKey("chuni_friend_code_list")
        private val GA = stringPreferencesKey("chuni_ga")
        private val GA_KEY = stringPreferencesKey("chuni_ga_key")
        private val GA_VALUE = stringPreferencesKey("chuni_ga_value")
    }

    /**
     * 保存 Cookie 数据
     */
    suspend fun saveCookie(cookie: ChunithmCookieDTO) {
        context.chunithmCookieDataStore.edit { preferences ->
            preferences[TOKEN] = cookie.token
            preferences[EXPIRES] = cookie.expires
            preferences[MAX_AGE] = cookie.maxAge
            preferences[PATH] = cookie.path
            preferences[SAME_SITE] = cookie.sameSite
            preferences[USER_ID] = cookie.userId
            preferences[FRIEND_CODE_LIST] = cookie.friendCodeList
            preferences[GA] = cookie.ga
            preferences[GA_KEY] = cookie.gaKey
            preferences[GA_VALUE] = cookie.gaValue
        }
    }

    /**
     * 获取 Cookie Flow
     */
    fun getCookieFlow(): Flow<ChunithmCookieDTO> {
        return context.chunithmCookieDataStore.data.map { preferences ->
            ChunithmCookieDTO(
                token = preferences[TOKEN] ?: "",
                expires = preferences[EXPIRES] ?: "",
                maxAge = preferences[MAX_AGE] ?: "",
                path = preferences[PATH] ?: "",
                sameSite = preferences[SAME_SITE] ?: "",
                userId = preferences[USER_ID] ?: "",
                friendCodeList = preferences[FRIEND_CODE_LIST] ?: "",
                ga = preferences[GA] ?: "",
                gaKey = preferences[GA_KEY] ?: "",
                gaValue = preferences[GA_VALUE] ?: ""
            )
        }
    }

    /**
     * 获取 Cookie（一次性）
     */
    suspend fun getCookie(): ChunithmCookieDTO {
        return getCookieFlow().first()
    }
}
