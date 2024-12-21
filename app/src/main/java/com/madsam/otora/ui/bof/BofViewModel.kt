package com.madsam.otora.ui.bof

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.model.bof.ui.BofTeamShow
import com.madsam.otora.model.bof.ui.Rankable
import com.madsam.otora.service.BofDataRequestService
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import kotlin.math.max

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.BofViewModel
 * 创建者: MadSamurai
 * 创建时间: 2024/12/15
 * 描述: BOF视图模型
 */
class BofViewModel(
    context: Context
) : ViewModel() {
    companion object {
        private const val TAG = "BofViewModel"
    }

    val bofDataRequestService = BofDataRequestService(context)
    val totalData = MutableStateFlow(listOf<BofEntryShow>())
    val avgData = MutableStateFlow(listOf<BofEntryShow>())
    val medianData = MutableStateFlow(listOf<BofEntryShow>())
    val diffData = MutableStateFlow(listOf<BofEntryShow>())
    val teamData = MutableStateFlow(listOf<BofTeamShow>())

    var thresholdImpr = MutableStateFlow(1)
    var thresholdImprOld = MutableStateFlow(1)

    var selectedDate = MutableStateFlow(LocalDate.now())
    var selectedTime = MutableStateFlow("-1")
    var selectedTimeStr = MutableStateFlow("")

    fun generateSelectedTimeStr() {
        selectedTimeStr.update {
            if (selectedTime.value == "-1") {
                if (totalData.value.isEmpty()) {
                    ""
                } else {
                    CommonUtils.roundDownToNearestFiveMinutes(totalData.value.first().time)
                }
            } else {
                CommonUtils.roundDownToNearestFiveMinutes(selectedTime.value)
            }
        }
    }

    suspend fun <T> fetchData(
        fetchLatest: suspend () -> List<T>,
        fetchByTime: suspend (Long) -> List<T>
    ): List<T> {
        return if (selectedTime.value == "-1") {
            fetchLatest()
        } else {
            val timeInMillis = CommonUtils.ymdToMillis(
                selectedDate.value.toString(),
                CommonUtils.roundDownToNearestFiveMinutes(selectedTime.value)
            )
            fetchByTime(timeInMillis)
        }
    }

    fun <T, R : Comparable<R>> updateRanks(
        data: List<T>,
        oldTotalSelector: (T) -> R,
        totalSelector: (T) -> R,
        oldRankSetter: (T, Int) -> Unit,
        rankSetter: (T, Int) -> Unit,
        diffSetter: (T, Int) -> Unit,
        filter: (T) -> Boolean,
        reviewCountSelector: (T) -> Int
    ): List<T> where T : Rankable {
        var sortedData = data.sortedWith(
            compareByDescending(oldTotalSelector).thenByDescending(reviewCountSelector)
        )
        var currentOldRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && oldTotalSelector(sortedData[index - 1]) != oldTotalSelector(entry)) {
                currentOldRank = index + 1
            }
            oldRankSetter(entry, currentOldRank)
        }
        sortedData =
            data.sortedWith(compareByDescending(totalSelector).thenByDescending(reviewCountSelector))
                .filter(filter)
        var currentRank = 1
        sortedData.forEachIndexed { index, entry ->
            if (index > 0 && totalSelector(sortedData[index - 1]) != totalSelector(entry)) {
                currentRank = index + 1
            }
            rankSetter(entry, currentRank)
        }
        sortedData.forEach {
            diffSetter(it, it.oldIndex - it.index)
        }
        return sortedData
    }

    fun calculateThresholds(data: List<BofEntryShow>) {
        val sortedDataByOldImpr = data.sortedByDescending { it.oldImpr }
        thresholdImprOld.update { max(sortedDataByOldImpr.getOrNull(199)?.oldImpr ?: 0, 3) }

        val sortedDataByImpr = data.sortedByDescending { it.impr }
        thresholdImpr.update { max(sortedDataByImpr.getOrNull(199)?.impr ?: 0, 3) }
    }

    suspend fun requestTotalData() {
        val data = fetchData(
            { bofDataRequestService.getBofttEntryLatest() },
            { time -> bofDataRequestService.getBofttEntryByTime(time) }
        )

        if (data.isEmpty()) {
            Log.d(TAG, "No data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldTotal },
            { it.total },
            { entry, rank -> entry.oldIndex = rank },
            { entry, rank -> entry.index = rank },
            { entry, diff -> entry.rankDiff = diff },
            { true },
            { it.impr }
        )
        totalData.update { updatedData }
    }

    suspend fun requestAvgData() {
        val data = fetchData(
            { bofDataRequestService.getBofttEntryLatest() },
            { time -> bofDataRequestService.getBofttEntryByTime(time) }
        )
        calculateThresholds(data)
        if (data.isEmpty()) {
            Log.d(TAG, "No avg data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldAvg },
            { it.avg },
            { entry, rank -> entry.oldIndex = rank },
            { entry, rank -> entry.index = rank },
            { entry, diff -> entry.avgDiff = diff },
            { it.impr >= thresholdImpr.value },
            { it.impr }
        )
        avgData.update { updatedData }
    }

    suspend fun requestMedianData() {
        val data = fetchData(
            { bofDataRequestService.getBofttEntryLatest() },
            { time -> bofDataRequestService.getBofttEntryByTime(time) }
        )
        calculateThresholds(data)
        if (data.isEmpty()) {
            Log.d(TAG, "No median data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldMedian },
            { it.median },
            { entry, rank -> entry.oldIndex = rank },
            { entry, rank -> entry.index = rank },
            { entry, diff -> entry.medianDiff = diff },
            { it.impr >= thresholdImpr.value },
            { it.impr }
        )
        medianData.update { updatedData }
    }

    suspend fun requestDiffData() {
        val data = fetchData(
            { bofDataRequestService.getBofttEntryLatest() },
            { time -> bofDataRequestService.getBofttEntryByTime(time) }
        )
        data.forEach {
            it.totalDiff = it.total - it.oldTotal
            it.imprDiff = it.impr - it.oldImpr
        }
        val updatedData = updateRanks(
            data,
            { it.totalDiff },
            { it.totalDiff },
            { entry, rank -> entry.oldIndex = rank },
            { entry, rank -> entry.index = rank },
            { entry, diff -> entry.totalDiff = entry.totalDiff },
            { true },
            { it.imprDiff }
        )
        diffData.update { updatedData }
    }

    suspend fun requestTeamData() {
        val data = fetchData(
            { bofDataRequestService.getBofttTeamLatest() },
            { time -> bofDataRequestService.getBofttTeamByTime(time) }
        )

        if (data.isEmpty()) {
            Log.d(TAG, "No team data available for the selected date and time.")
            return
        }
        val updatedData = updateRanks(
            data,
            { it.oldTotal },
            { it.total },
            { entry, rank -> entry.oldIndex = rank },
            { entry, rank -> entry.index = rank },
            { entry, diff -> entry.rankDiff = diff },
            { true },
            { it.impr }
        )
        teamData.update { updatedData }
    }
}

class BofViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BofViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BofViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}