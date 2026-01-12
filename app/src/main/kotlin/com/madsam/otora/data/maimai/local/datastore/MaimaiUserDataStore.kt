package com.madsam.otora.data.maimai.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.maimai.remote.model.MaimaiUserDTO
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.maimaiUserDataStore: DataStore<Preferences> by preferencesDataStore(name = "maimai_user")

/**
 * Maimai 用户数据 DataStore
 */
internal class MaimaiUserDataStore(private val context: Context) {
    companion object {
        private val USER_NAME_KEY = stringPreferencesKey("userName")
        private val RATING_KEY = stringPreferencesKey("rating")
        private val MAX_RATING_KEY = stringPreferencesKey("maxRating")
        private val TITLE_KEY = stringPreferencesKey("title")
        private val TITLE_PLATE_KEY = stringPreferencesKey("titlePlate")
        private val TROPHY_NAME_KEY = stringPreferencesKey("trophyName")
        private val ICON_URL_KEY = stringPreferencesKey("iconUrl")
        private val PLATE_URL_KEY = stringPreferencesKey("plateUrl")
        private val FRAME_URL_KEY = stringPreferencesKey("frameUrl")
        private val PLAY_COUNT_KEY = intPreferencesKey("playCount")
        private val TOTAL_SCORE_KEY = longPreferencesKey("totalScore")
        private val STAR_COUNT_KEY = intPreferencesKey("starCount")
    }
    
    suspend fun saveUserData(user: MaimaiUserDTO) {
        context.maimaiUserDataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = user.userName
            preferences[RATING_KEY] = user.rating
            preferences[MAX_RATING_KEY] = user.maxRating
            preferences[TITLE_KEY] = user.title
            preferences[TITLE_PLATE_KEY] = user.titlePlate
            preferences[TROPHY_NAME_KEY] = user.trophyName
            preferences[ICON_URL_KEY] = user.iconUrl
            preferences[PLATE_URL_KEY] = user.plateUrl
            preferences[FRAME_URL_KEY] = user.frameUrl
            preferences[PLAY_COUNT_KEY] = user.playCount
            preferences[TOTAL_SCORE_KEY] = user.totalScore
            preferences[STAR_COUNT_KEY] = user.starCount
        }
    }
    
    suspend fun getUserData(): MaimaiUserDTO {
        return context.maimaiUserDataStore.data.map { preferences ->
            MaimaiUserDTO(
                userName = preferences[USER_NAME_KEY] ?: "",
                rating = preferences[RATING_KEY] ?: "",
                maxRating = preferences[MAX_RATING_KEY] ?: "",
                title = preferences[TITLE_KEY] ?: "",
                titlePlate = preferences[TITLE_PLATE_KEY] ?: "",
                trophyName = preferences[TROPHY_NAME_KEY] ?: "",
                iconUrl = preferences[ICON_URL_KEY] ?: "",
                plateUrl = preferences[PLATE_URL_KEY] ?: "",
                frameUrl = preferences[FRAME_URL_KEY] ?: "",
                playCount = preferences[PLAY_COUNT_KEY] ?: 0,
                totalScore = preferences[TOTAL_SCORE_KEY] ?: 0L,
                starCount = preferences[STAR_COUNT_KEY] ?: 0
            )
        }.first()
    }
}
