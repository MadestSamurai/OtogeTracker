package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChunithmPenguinDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.chunithmPenguinDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_penguin")

/**
 * Chunithm 企鹅装扮数据 DataStore 服务
 * 使用 DataStore Preferences 存储企鹅装扮配置数据
 */
internal class ChunithmPenguinDataStore(private val context: Context) {
    
    companion object {
        private val BACK = stringPreferencesKey("back")
        private val SKINFOOT_R = stringPreferencesKey("skinfoot_r")
        private val SKINFOOT_L = stringPreferencesKey("skinfoot_l")
        private val SKIN = stringPreferencesKey("skin")
        private val WEAR = stringPreferencesKey("wear")
        private val FACE = stringPreferencesKey("face")
        private val FACE_COVER = stringPreferencesKey("face_cover")
        private val HEAD = stringPreferencesKey("head")
        private val HAND_R = stringPreferencesKey("hand_r")
        private val HAND_L = stringPreferencesKey("hand_l")
        private val ITEM_R = stringPreferencesKey("item_r")
        private val ITEM_L = stringPreferencesKey("item_l")
        private val FRONT = stringPreferencesKey("front")
    }
    
    /**
     * 保存企鹅装扮数据
     */
    suspend fun savePenguinData(penguin: ChunithmPenguinDTO) {
        context.chunithmPenguinDataStore.edit { preferences ->
            preferences[BACK] = penguin.back
            preferences[SKINFOOT_R] = penguin.skinfootR
            preferences[SKINFOOT_L] = penguin.skinfootL
            preferences[SKIN] = penguin.skin
            preferences[WEAR] = penguin.wear
            preferences[FACE] = penguin.face
            preferences[FACE_COVER] = penguin.faceCover
            preferences[HEAD] = penguin.head
            preferences[HAND_R] = penguin.handR
            preferences[HAND_L] = penguin.handL
            preferences[ITEM_R] = penguin.itemR
            preferences[ITEM_L] = penguin.itemL
            preferences[FRONT] = penguin.front
        }
    }
    
    /**
     * 获取企鹅装扮数据 Flow
     */
    fun getPenguinDataFlow(): Flow<ChunithmPenguinDTO?> {
        return context.chunithmPenguinDataStore.data.map { preferences ->
            val skin = preferences[SKIN] ?: ""
            if (skin.isEmpty()) {
                null
            } else {
                ChunithmPenguinDTO(
                    back = preferences[BACK] ?: "",
                    skinfootR = preferences[SKINFOOT_R] ?: "",
                    skinfootL = preferences[SKINFOOT_L] ?: "",
                    skin = skin,
                    wear = preferences[WEAR] ?: "",
                    face = preferences[FACE] ?: "",
                    faceCover = preferences[FACE_COVER] ?: "",
                    head = preferences[HEAD] ?: "",
                    handR = preferences[HAND_R] ?: "",
                    handL = preferences[HAND_L] ?: "",
                    itemR = preferences[ITEM_R] ?: "",
                    itemL = preferences[ITEM_L] ?: "",
                    front = preferences[FRONT] ?: ""
                )
            }
        }
    }
    
    /**
     * 获取企鹅装扮数据（挂起函数）
     * 获取当前 DataStore 中的第一个值
     */
    suspend fun getPenguinData(): ChunithmPenguinDTO? {
        return getPenguinDataFlow().first()
    }
}
