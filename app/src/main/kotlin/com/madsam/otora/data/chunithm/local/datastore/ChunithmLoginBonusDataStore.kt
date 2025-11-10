package com.madsam.otora.data.chunithm.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO
import com.madsam.otora.data.chunithm.remote.model.DailyReward
import com.madsam.otora.data.chunithm.remote.model.MonthlyReward
import com.madsam.otora.data.chunithm.remote.model.WeekdayBonus
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
        private val DAILY_LOGIN_DAY = intPreferencesKey("login_bonus_daily_login_day")
        private val MONTHLY_REWARDS_JSON = stringPreferencesKey("login_bonus_monthly_rewards")
        private val DAILY_REWARDS_JSON = stringPreferencesKey("login_bonus_daily_rewards")
        private val WEEKDAY_BONUSES_JSON = stringPreferencesKey("login_bonus_weekday_bonuses")
    }

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val monthlyRewardsAdapter = moshi.adapter<List<MonthlyReward>>(
        Types.newParameterizedType(List::class.java, MonthlyReward::class.java)
    )

    private val dailyRewardsAdapter = moshi.adapter<List<DailyReward>>(
        Types.newParameterizedType(List::class.java, DailyReward::class.java)
    )

    private val weekdayBonusesAdapter = moshi.adapter<List<WeekdayBonus>>(
        Types.newParameterizedType(List::class.java, WeekdayBonus::class.java)
    )

    suspend fun saveLoginBonusData(bonus: ChuniLoginBonusDTO) {
        context.chunithmLoginBonusDataStore.edit { preferences ->
            preferences[CURRENT_MONTH] = bonus.currentMonth
            preferences[MONTHLY_DAYS] = bonus.monthlyDays
            preferences[TOTAL_DAYS] = bonus.totalDays
            preferences[DAILY_LOGIN_DAY] = bonus.dailyLoginDay
            preferences[MONTHLY_REWARDS_JSON] = monthlyRewardsAdapter.toJson(bonus.monthlyRewards)
            preferences[DAILY_REWARDS_JSON] = dailyRewardsAdapter.toJson(bonus.dailyRewards)
            preferences[WEEKDAY_BONUSES_JSON] = weekdayBonusesAdapter.toJson(bonus.weekdayBonuses)
        }
    }

    fun getLoginBonusFlow(): Flow<ChuniLoginBonusDTO?> {
        return context.chunithmLoginBonusDataStore.data.map { preferences ->
            val currentMonth = preferences[CURRENT_MONTH] ?: 0
            val monthlyDays = preferences[MONTHLY_DAYS] ?: 0
            val totalDays = preferences[TOTAL_DAYS] ?: 0
            val dailyLoginDay = preferences[DAILY_LOGIN_DAY] ?: 0

            // 如果所有基本值都为 0，返回 null 以表示无数据
            if (currentMonth == 0 && monthlyDays == 0 && totalDays == 0) {
                null
            } else {
                val monthlyRewardsJson = preferences[MONTHLY_REWARDS_JSON] ?: "[]"
                val dailyRewardsJson = preferences[DAILY_REWARDS_JSON] ?: "[]"
                val weekdayBonusesJson = preferences[WEEKDAY_BONUSES_JSON] ?: "[]"

                ChuniLoginBonusDTO(
                    currentMonth = currentMonth,
                    monthlyDays = monthlyDays,
                    totalDays = totalDays,
                    dailyLoginDay = dailyLoginDay,
                    monthlyRewards = monthlyRewardsAdapter.fromJson(monthlyRewardsJson) ?: emptyList(),
                    dailyRewards = dailyRewardsAdapter.fromJson(dailyRewardsJson) ?: emptyList(),
                    weekdayBonuses = weekdayBonusesAdapter.fromJson(weekdayBonusesJson) ?: emptyList()
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
