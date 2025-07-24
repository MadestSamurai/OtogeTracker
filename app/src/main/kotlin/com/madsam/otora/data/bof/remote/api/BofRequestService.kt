package com.madsam.otora.data.bof.remote.api

import android.content.Context
import android.util.Log
import com.madsam.otora.data.bof.local.model.BofCommentDetailEntity
import com.madsam.otora.data.bof.local.model.BofCommentEntity
import com.madsam.otora.data.bof.local.model.BofEntryEntity
import com.madsam.otora.data.bof.local.model.BofPointEntity
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofTeamPointEntity
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.data.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.xilinjia.krdb.Realm
import io.github.xilinjia.krdb.RealmConfiguration
import io.github.xilinjia.krdb.UpdatePolicy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.time.LocalDate
import java.util.concurrent.Executors
import kotlin.collections.forEach

class BofRequestService(private val context: Context) {
    companion object {
        private const val TAG = "BofRequestService"
    }

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(BofAPI::class.java)
    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
    private val semaphore = Semaphore(4)

    private val realmConfig = RealmConfiguration.Builder(
        schema = setOf(
            BofEntryEntity::class,
            BofPointEntity::class,
            BofTeamEntity::class,
            BofTeamPointEntity::class,
            BofCommentEntity::class,
            BofCommentDetailEntity::class
        )
    )
        .name("otoge-tracker-bof.realm")
        .schemaVersion(1)
        .build()

    private suspend fun requestBofttEntryData(date: String, onComplete: () -> Unit) {
        val bofCall = api.getBofttData(date)
        val response = try {
            bofCall.execute()
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, "Exception: ${e.message}")
            return
        }

        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful")
            return
        }

        val bofEntryList = response.body()
        if (bofEntryList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofEntryList.forEach { entry ->
                    val entity = BofEntryEntity().apply {
                        id = "${date}_${entry.no}"
                        no = entry.no
                        team = entry.team
                        this.date = date
                        artist = entry.artist
                        genre = entry.genre
                        title = entry.title
                        regist = entry.regist
                        update = entry.update
                    }
                    this.copyToRealm(entity, UpdatePolicy.ALL)
                    entry.total.forEach { point ->
                        val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
                        val pointEntity = BofPointEntity().apply {
                            id = "${timeInMillis}_${entry.no}"
                            no = entry.no
                            time = timeInMillis
                            total = point.value
                            impr = entry.impr.find { it.time == point.time }?.value
                                ?: entry.impr.lastOrNull { it.time < point.time }?.value ?: 0
                            median = entry.median.find { it.time == point.time }?.value
                                ?: entry.median.lastOrNull { it.time < point.time }?.value ?: 0.0
                            avg = entry.avg.find { it.time == point.time }?.value
                                ?: entry.avg.lastOrNull { it.time < point.time }?.value ?: 0.0
                        }
                        this.copyToRealm(pointEntity, UpdatePolicy.ALL)
                    }
                }
            }
            onComplete()
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        } finally {
            realm.close()
        }
    }

    private suspend fun requestBofttTeamData(date: String) {
        val bofTeamCall = api.getBofttTeamData(date)
        val response = bofTeamCall.execute()
        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful")
            return
        }

        val bofTeamList = response.body()
        if (bofTeamList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofTeamList.forEach { team ->
                    val entity = BofTeamEntity().apply {
                        this.id = "${date}_${team.team}"
                        this.date = date
                        this.team = team.team
                        this.title1 = team.title1
                        this.title2 = team.title2
                        this.title3 = team.title3
                        this.title4 = team.title4
                        this.artist1 = team.artist1
                        this.artist2 = team.artist2
                        this.artist3 = team.artist3
                        this.artist4 = team.artist4
                        this.fs1 = team.fs1
                        this.fs2 = team.fs2
                        this.fs3 = team.fs3
                        this.fs4 = team.fs4
                    }
                    this.copyToRealm(entity, UpdatePolicy.ALL)
                    team.total.forEach { point ->
                        val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
                        val pointEntity = BofTeamPointEntity().apply {
                            id = "${timeInMillis}_${team.team}"
                            time = timeInMillis
                            this.team = team.team
                            total = point.value
                            median = team.median.find { it.time == point.time }?.value
                                ?: team.median.lastOrNull { it.time < point.time }?.value ?: ""
                            impr = team.impr.find { it.time == point.time }?.value
                                ?: team.impr.lastOrNull { it.time < point.time }?.value ?: 0
                            total1 = team.total1.find { it.time == point.time }?.value
                                ?: team.total1.lastOrNull { it.time < point.time }?.value ?: ""
                            median1 = team.median1.find { it.time == point.time }?.value
                                ?: team.median1.lastOrNull { it.time < point.time }?.value ?: ""
                            total2 = team.total2.find { it.time == point.time }?.value
                                ?: team.total2.lastOrNull { it.time < point.time }?.value ?: ""
                            median2 = team.median2.find { it.time == point.time }?.value
                                ?: team.median2.lastOrNull { it.time < point.time }?.value ?: ""
                            total3 = team.total3.find { it.time == point.time }?.value
                                ?: team.total3.lastOrNull { it.time < point.time }?.value ?: ""
                            median3 = team.median3.find { it.time == point.time }?.value
                                ?: team.median3.lastOrNull { it.time < point.time }?.value ?: ""
                            total4 = team.total4.find { it.time == point.time }?.value
                                ?: team.total4.lastOrNull { it.time < point.time }?.value ?: ""
                            median4 = team.median4.find { it.time == point.time }?.value
                                ?: team.median4.lastOrNull { it.time < point.time }?.value ?: ""
                        }
                        this.copyToRealm(pointEntity, UpdatePolicy.ALL)
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        } finally {
            realm.close()
        }
    }

    private suspend fun requestBofttCommentData(date: String) {
        val bofCommentCall = api.getBofttComment(date)
        val response = bofCommentCall.execute()
        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful")
            return
        }

        val bofCommentList = response.body()
        if (bofCommentList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofCommentList.forEach { comment ->
                    val entity = BofCommentEntity().apply {
                        id = "${date}_${comment.user}${if (comment.pattern != null) "_${comment.pattern}" else ""}"
                        this.date = date
                        user = comment.user
                        pattern = if (comment.pattern != null) comment.pattern.toString() else ""
                        country = comment.country
                        vote = comment.vote
                        voteTotal = comment.voteTotal
                        voteAve = comment.voteAve
                        short = comment.short
                        shortTotal = comment.shortTotal
                        shortAve = comment.shortAve
                        shortComment = comment.shortComment
                        long = comment.long
                        longTotal = comment.longTotal
                        longAve = comment.longAve
                        longComment = comment.longComment
                        total = comment.total
                        totalAve = comment.totalAve
                    }
                    this.copyToRealm(entity, UpdatePolicy.ALL)
                    val details = listOf(comment.voteDetail, comment.shortDetail, comment.longDetail)

                    details.forEach { detailList ->
                        if (detailList.isNotEmpty()) {
                            detailList.forEach { detail ->
                                val detailEntity = BofCommentDetailEntity().apply {
                                    id = "${detail.evalNumber}_${detail.workNumber}"
                                    user = comment.user
                                    score = detail.score
                                    code = detail.evalNumber
                                    country = detail.evalPosition
                                    workNumber = detail.workNumber
                                    this.date = date
                                    type = when (detailList) {
                                        comment.voteDetail -> "vote"
                                        comment.shortDetail -> "short"
                                        else -> "long"
                                    }
                                }
                                this.copyToRealm(detailEntity, UpdatePolicy.ALL)
                            }
                        }
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        } finally {
            realm.close()
        }
    }

    fun requestBofttData(dateTime: LocalDate, onComplete: () -> Unit) {
        val startDate = LocalDate.parse("2024-10-16")
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("dates", dateToRequest, context)) {
                serviceScope.launch(dispatcher) {
                    semaphore.withPermit {
                        requestBofttEntryData(dateToRequest) {
                            if (currentDate.isBefore(dateTime)) {
                                ShareUtil.insertStringArray("dates", dateToRequest, context)
                            }
                            onComplete()
                        }
                    }
                }
            }
            currentDate = currentDate.minusDays(1)
        }
    }

    fun requestBofttTeamData(dateTime: LocalDate, onComplete: () -> Unit) {
        val startDate = LocalDate.parse("2024-10-16")
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("datesTeam", dateToRequest, context)) {
                serviceScope.launch(dispatcher) {
                    semaphore.withPermit {
                        requestBofttTeamData(dateToRequest)
                        if (currentDate.isBefore(dateTime)) {
                            ShareUtil.insertStringArray("datesTeam", dateToRequest, context)
                        }
                        onComplete()
                    }
                }
            }
            currentDate = currentDate.minusDays(1)
        }
    }

    fun requestBofttCommentData(dateTime: LocalDate, onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            requestBofttCommentData("2025-01-08") //TODO: 2025-01-08
            onComplete()
        }
    }
}