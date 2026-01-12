package com.madsam.otora.data.maimai.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.maimai.remote.model.MaimaiCookieDTO
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.maimaiCookieDataStore: DataStore<Preferences> by preferencesDataStore(name = "maimai_cookie")

/**
 * Maimai Cookie DataStore
 */
internal class MaimaiCookieDataStore(private val context: Context) {
    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val USER_ID_KEY = stringPreferencesKey("userId")
        private val FRIEND_CODE_LIST_KEY = stringPreferencesKey("friendCodeList")
    }
    
    suspend fun saveCookie(cookie: MaimaiCookieDTO) {
        context.maimaiCookieDataStore.edit { preferences ->
            preferences[TOKEN_KEY] = cookie.token
            preferences[USER_ID_KEY] = cookie.userId
            preferences[FRIEND_CODE_LIST_KEY] = cookie.friendCodeList
        }
    }
    
    suspend fun getCookie(): MaimaiCookieDTO {
        return context.maimaiCookieDataStore.data.map { preferences ->
            MaimaiCookieDTO(
                token = preferences[TOKEN_KEY] ?: "",
                userId = preferences[USER_ID_KEY] ?: "",
                friendCodeList = preferences[FRIEND_CODE_LIST_KEY] ?: ""
            )
        }.first()
    }
    
    suspend fun clearCookie() {
        context.maimaiCookieDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
