package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

// DataStore 实例
private val Context.chunithmLoginBonusDataStore: DataStore<Preferences> by preferencesDataStore(name = "chunithm_login_bonus")

/**
 * Chunithm 登录奖励 DataStore 服务
 */
internal class ChunithmLoginBonusDataStore(private val context: Context) {

    companion object {
        private val CURRENT_MONTH = intPreferencesKey("login_bonus_current_month")
        private val MONTHLY_DAYS = intPreferencesKey("login_bonus_monthly_days")
        private val TOTAL_DAYS = intPreferencesKey("login_bonus_total_days")
    }

    suspend fun saveLoginBonusData(bonus: ChuniLoginBonusDTO) {
        context.chunithmLoginBonusDataStore.edit { preferences ->
            preferences[CURRENT_MONTH] = bonus.currentMonth
            preferences[MONTHLY_DAYS] = bonus.monthlyDays
            preferences[TOTAL_DAYS] = bonus.totalDays
        }
    }

    fun getLoginBonusFlow(): Flow<ChuniLoginBonusDTO?> {
        return context.chunithmLoginBonusDataStore.data.map { preferences ->
            val month = preferences[CURRENT_MONTH] ?: 0
            // 如果所有值都为 0，返回 null 以表示无数据
            val monthly = preferences[MONTHLY_DAYS] ?: 0
            val total = preferences[TOTAL_DAYS] ?: 0

            if (month == 0 && monthly == 0 && total == 0) {
                null
            } else {
                ChuniLoginBonusDTO(
                    currentMonth = month,
                    monthlyDays = monthly,
                    totalDays = total
                )
            }
        }
    }

    suspend fun getLoginBonus(): ChuniLoginBonusDTO? {
        return getLoginBonusFlow().first()
    }

    suspend fun clearLoginBonusData() {
        context.chunithmLoginBonusDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
