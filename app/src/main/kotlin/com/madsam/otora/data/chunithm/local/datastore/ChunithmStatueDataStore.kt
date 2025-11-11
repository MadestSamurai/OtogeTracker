package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChunithmStatueDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.statueDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_statue")

/**
 * 企鹅雕像数据存储
 */
internal class ChunithmStatueDataStore(private val context: Context) {
    
    companion object {
        private val SOUL_KEY = intPreferencesKey("soul")
        private val SLIVER_KEY = intPreferencesKey("sliver")
        private val GOLD_KEY = intPreferencesKey("gold")
        private val RAINBOW_KEY = intPreferencesKey("rainbow")
    }
    
    /**
     * 保存企鹅雕像数据
     */
    suspend fun saveStatueData(statue: ChunithmStatueDTO) {
        context.statueDataStore.edit { preferences ->
            preferences[SOUL_KEY] = statue.soul
            preferences[SLIVER_KEY] = statue.sliver
            preferences[GOLD_KEY] = statue.gold
            preferences[RAINBOW_KEY] = statue.rainbow
        }
    }
    
    /**
     * 读取企鹅雕像数据
     */
    val statueData: Flow<ChunithmStatueDTO> = context.statueDataStore.data.map { preferences ->
        ChunithmStatueDTO(
            soul = preferences[SOUL_KEY] ?: 0,
            sliver = preferences[SLIVER_KEY] ?: 0,
            gold = preferences[GOLD_KEY] ?: 0,
            rainbow = preferences[RAINBOW_KEY] ?: 0
        )
    }
}
