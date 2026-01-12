package com.madsam.otora.data.maimai.remote.api

import android.content.Context
import android.util.Log
import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import com.madsam.otora.core.utils.StringUtils
import com.madsam.otora.core.utils.UserAgentUtils
import com.madsam.otora.core.datastore.UserAgentDataStore
import com.madsam.otora.data.MAIMAI_URL
import com.madsam.otora.data.adapter.*
import com.madsam.otora.data.maimai.local.datastore.MaimaiCookieDataStore
import com.madsam.otora.data.maimai.local.datastore.MaimaiUserDataStore
import com.madsam.otora.data.maimai.local.objectbox.MaimaiObjectBoxService
import com.madsam.otora.data.maimai.remote.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Maimai 数据请求服务
 * 参考 ChunithmRequestService 实现
 */
internal class MaimaiRequestService(private val context: Context) {
    companion object {
        private const val TAG = "MaimaiRequestService"
        
        // Regex patterns
        private val URL_EXTRACTOR_REGEX = Regex("url\\(([^)]+)\\)")
        private val PERCENTAGE_REGEX = Regex("([\\d.]+)%")
        private val SCORE_REGEX = Regex("([\\d,]+)")
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val isUserRequestRunning = AtomicBoolean(false)
    private val isSongsRequestRunning = AtomicBoolean(false)
    private val maimaiLocalService = MaimaiObjectBoxService()
    
    // DataStore 实例复用
    private val userDataStore by lazy { MaimaiUserDataStore(context) }
    private val cookieDataStore by lazy { MaimaiCookieDataStore(context) }
    private val userAgentDataStore by lazy { UserAgentDataStore(context) }
    
    // UserAgent 从 DataStore 延迟加载
    private var userAgent: String? = null
    
    /**
     * 获取 UserAgent
     */
    private suspend fun getUserAgent(): String {
        if (userAgent == null) {
            userAgent = userAgentDataStore.getUserAgent().ifBlank { 
                UserAgentUtils.getDefaultUserAgent() 
            }
        }
        return userAgent!!
    }
    
    // Cookie 从 DataStore 延迟加载
    private var cookie: MaimaiCookieDTO? = null
    
    /**
     * 获取 Cookie
     */
    private suspend fun getCookie(): MaimaiCookieDTO {
        if (cookie == null) {
            cookie = cookieDataStore.getCookie()
        }
        return cookie!!
    }
    
    /**
     * 更新 Cookie
     */
    private suspend fun updateCookie(newCookie: MaimaiCookieDTO) {
        cookie = newCookie
        cookieDataStore.saveCookie(newCookie)
    }
    
    private val moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .add(SafeIntAdapter())
        .add(SafeDoubleAdapter())
        .add(SafeBooleanAdapter())
        .add(SafeStringListAdapter())
        .add(SafeIntListAdapter())
        .add(SafeIntPairAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
        .connectionPool(okhttp3.ConnectionPool(5, 5, java.util.concurrent.TimeUnit.MINUTES))
        .retryOnConnectionFailure(true)
        .build()

    /**
     * 通用的服务器数据请求方法
     */
    private suspend fun requestDataFromServer(
        link: String,
        requestBody: Map<String, String> = emptyMap(),
        isPost: Boolean = false
    ): Document? = withContext(Dispatchers.IO) {
        try {
            val encodedUrl = StringUtils.encodeURL(link)
            val currentCookie = getCookie()
            val currentUserAgent = getUserAgent()
            val cookies = buildCookieString(currentCookie)
            
            val requestBuilder = Request.Builder()
                .url(encodedUrl)
                .header("User-Agent", currentUserAgent)
                .header("Cookie", cookies)
            
            val request = if (isPost && requestBody.isNotEmpty()) {
                val formBody = FormBody.Builder().apply {
                    requestBody.forEach { (key, value) -> add(key, value) }
                }.build()
                requestBuilder.post(formBody).build()
            } else {
                requestBuilder.get().build()
            }
            
            httpClient.newCall(request).execute().use { response ->
                when {
                    response.isSuccessful -> {
                        response.body.string().let { html ->
                            Ksoup.parse(html)
                        }
                    }
                    else -> {
                        Log.e(TAG, "HTTP error ${response.code} occurred in $link")
                        null
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in $link: ${e.message}")
            null
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error in $link: ${e.message}", e)
            null
        }
    }
    
    /**
     * 构建 Cookie 字符串
     */
    private fun buildCookieString(cookie: MaimaiCookieDTO): String = buildString {
        append("_t=${cookie.token}")
        append("; userId=${cookie.userId}")
        if (cookie.friendCodeList.isNotEmpty()) {
            append("; friendCodeList=${cookie.friendCodeList}")
        }
    }

    /**
     * 解析 Maimai 用户数据
     */
    private fun parseMaimaiUser(doc: Document): MaimaiUserDTO {
        Log.d(TAG, "=== Starting parseMaimaiUser ===")
        val userDTO = MaimaiUserDTO()
        
        // 解析用户名
        userDTO.userName = doc.selectFirst("div.name_block")?.text() ?: ""
        Log.d(TAG, "userName: ${userDTO.userName}")
        
        // 解析 Rating
        userDTO.rating = doc.selectFirst("div.rating_block")?.text() ?: ""
        Log.d(TAG, "rating: ${userDTO.rating}")
        
        // 解析最高 Rating
        userDTO.maxRating = doc.selectFirst("div.max_rating_block")?.text() ?: ""
        Log.d(TAG, "maxRating: ${userDTO.maxRating}")
        
        // 解析称号
        userDTO.title = doc.selectFirst("div.trophy_block")?.text() ?: ""
        Log.d(TAG, "title: ${userDTO.title}")
        
        // 解析称号版图片
        userDTO.titlePlate = doc.selectFirst("div.trophy_block img")?.attr("src") ?: ""
        Log.d(TAG, "titlePlate: ${userDTO.titlePlate}")
        
        // 解析头像
        userDTO.iconUrl = doc.selectFirst("div.basic_block img.w_112")?.attr("src") ?: ""
        Log.d(TAG, "iconUrl: ${userDTO.iconUrl}")
        
        // 解析背景板
        userDTO.plateUrl = doc.selectFirst("div.basic_block")
            ?.attr("style")
            ?.let { style ->
                URL_EXTRACTOR_REGEX.find(style)?.groupValues?.getOrNull(1)
            } ?: ""
        Log.d(TAG, "plateUrl: ${userDTO.plateUrl}")
        
        // 解析边框
        userDTO.frameUrl = doc.selectFirst("div.basic_block div.frame")
            ?.selectFirst("img")?.attr("src") ?: ""
        Log.d(TAG, "frameUrl: ${userDTO.frameUrl}")
        
        // 解析游玩次数
        userDTO.playCount = doc.selectFirst("div.playdata_block div.playdata_play_count span")
            ?.text()?.toIntOrNull() ?: 0
        Log.d(TAG, "playCount: ${userDTO.playCount}")
        
        // 解析总分数
        userDTO.totalScore = doc.selectFirst("div.playdata_block div.playdata_total_score span")
            ?.text()?.replace(",", "")?.toLongOrNull() ?: 0L
        Log.d(TAG, "totalScore: ${userDTO.totalScore}")
        
        // 解析星星数量
        userDTO.starCount = doc.selectFirst("div.playdata_block div.playdata_star_count span")
            ?.text()?.toIntOrNull() ?: 0
        Log.d(TAG, "starCount: ${userDTO.starCount}")
        
        Log.d(TAG, "=== Completed parseMaimaiUser ===")
        return userDTO
    }

    /**
     * 解析乐曲成绩数据
     */
    private fun parseMaimaiScores(doc: Document): List<MaimaiScoreDTO> {
        Log.d(TAG, "=== Starting parseMaimaiScores ===")
        return doc.select("div.w_450").mapNotNull { scoreBlock ->
            try {
                val scoreDTO = MaimaiScoreDTO()
                
                // 乐曲标题
                scoreDTO.title = scoreBlock.selectFirst("div.music_name_block")?.text() ?: ""
                if (scoreDTO.title.isEmpty()) return@mapNotNull null
                Log.d(TAG, "Parsing song: ${scoreDTO.title}")
                
                // 难度等级
                scoreDTO.level = scoreBlock.selectFirst("div.music_lv_block")?.text() ?: ""
                
                // 难度类型（从图片 src 中解析）
                scoreDTO.difficulty = when {
                    scoreBlock.selectFirst("img[src*=diff_basic]") != null -> "BASIC"
                    scoreBlock.selectFirst("img[src*=diff_advanced]") != null -> "ADVANCED"
                    scoreBlock.selectFirst("img[src*=diff_expert]") != null -> "EXPERT"
                    scoreBlock.selectFirst("img[src*=diff_master]") != null -> "MASTER"
                    scoreBlock.selectFirst("img[src*=diff_remaster]") != null -> "Re:MASTER"
                    else -> "MASTER" // 默认为 MASTER
                }
                
                // 乐曲类型（DX 或 Standard）
                val musicType = when {
                    scoreBlock.selectFirst("img[src*=music_dx.png]") != null -> "DX"
                    scoreBlock.selectFirst("img[src*=music_standard.png]") != null -> "Standard"
                    else -> ""
                }
                scoreDTO.genre = musicType
                
                // 分数（百分比）
                val scoreBlocks = scoreBlock.select("div.music_score_block")
                if (scoreBlocks.size > 0) {
                    val scoreText = scoreBlocks[0].text()
                    scoreDTO.score = PERCENTAGE_REGEX.find(scoreText)?.groupValues?.getOrNull(1) ?: ""
                    Log.d(TAG, "  Score: ${scoreDTO.score}%")
                }
                
                // DX 分数（格式：当前分数 / 总分）
                if (scoreBlocks.size > 1) {
                    val deluxScoreText = scoreBlocks[1].text()
                    // 提取 "2,009 / 2,241" 这样的格式
                    val scores = SCORE_REGEX.findAll(deluxScoreText).toList()
                    if (scores.size >= 2) {
                        val currentScore = scores[0].value.replace(",", "")
                        val maxScore = scores[1].value.replace(",", "")
                        scoreDTO.deluxscore = "$currentScore / $maxScore"
                        Log.d(TAG, "  DX Score: ${scoreDTO.deluxscore}")
                    }
                }
                
                // 评级（按优先级检查，避免误判）
                scoreDTO.rank = when {
                    scoreBlock.selectFirst("img[src*=music_icon_sssp]") != null -> "SSS+"
                    scoreBlock.selectFirst("img[src*=music_icon_sss]") != null -> "SSS"
                    scoreBlock.selectFirst("img[src*=music_icon_ssp]") != null -> "SS+"
                    scoreBlock.selectFirst("img[src*=music_icon_ss]") != null -> "SS"
                    scoreBlock.selectFirst("img[src*=music_icon_sp]") != null -> "S+"
                    scoreBlock.selectFirst("img[src*=music_icon_s]") != null -> "S"
                    scoreBlock.selectFirst("img[src*=music_icon_aaa]") != null -> "AAA"
                    scoreBlock.selectFirst("img[src*=music_icon_aa]") != null -> "AA"
                    scoreBlock.selectFirst("img[src*=music_icon_a]") != null -> "A"
                    else -> ""
                }
                if (scoreDTO.rank.isNotEmpty()) {
                    Log.d(TAG, "  Rank: ${scoreDTO.rank}")
                }
                
                // Combo 状态（按优先级检查）
                scoreDTO.comboStatus = when {
                    scoreBlock.selectFirst("img[src*=music_icon_app]") != null -> "app"
                    scoreBlock.selectFirst("img[src*=music_icon_ap]") != null -> "ap"
                    scoreBlock.selectFirst("img[src*=music_icon_fcp]") != null -> "fcp"
                    scoreBlock.selectFirst("img[src*=music_icon_fc]") != null -> "fc"
                    else -> ""
                }
                if (scoreDTO.comboStatus.isNotEmpty()) {
                    Log.d(TAG, "  Combo: ${scoreDTO.comboStatus}")
                }
                
                // Sync 状态（按优先级检查）
                scoreDTO.syncStatus = when {
                    scoreBlock.selectFirst("img[src*=music_icon_fdxp]") != null -> "fdxp"
                    scoreBlock.selectFirst("img[src*=music_icon_fdx]") != null -> "fdx"
                    scoreBlock.selectFirst("img[src*=music_icon_fsp]") != null -> "fsp"
                    scoreBlock.selectFirst("img[src*=music_icon_fs]") != null -> "fs"
                    scoreBlock.selectFirst("img[src*=music_icon_sync]") != null -> "sync"
                    else -> ""
                }
                if (scoreDTO.syncStatus.isNotEmpty()) {
                    Log.d(TAG, "  Sync: ${scoreDTO.syncStatus}")
                }
                
                // 乐曲 ID（从隐藏的 input 中获取）
                scoreDTO.id = scoreBlock.selectFirst("input[name=idx]")?.attr("value") ?: ""
                
                Log.d(TAG, "  Successfully parsed: ${scoreDTO.title} [${scoreDTO.difficulty} ${scoreDTO.level}]")
                scoreDTO
            } catch (e: Exception) {
                Log.e(TAG, "Error parsing score block", e)
                null
            }
        }.also { 
            Log.d(TAG, "=== Completed parseMaimaiScores: ${it.size} songs parsed ===")
        }
    }

    /**
     * 解析游戏记录统计数据
     * 从乐曲列表页面的统计表格中提取数据
     */
    private fun parsePlayRecord(doc: Document): List<MaimaiPlayRecordDTO> {
        Log.d(TAG, "=== Starting parsePlayRecord ===")
        val records = mutableListOf<MaimaiPlayRecordDTO>()
        
        // 解析统计表格
        val statTable = doc.selectFirst("table.music_scorelist_table")
        if (statTable == null) {
            Log.w(TAG, "Statistics table not found")
            return records
        }
        
        // 从表格中提取统计数据
        // 表格结构分析：
        // 第一行：Clear, S, S+, SS, SS+, SSS, SSS+
        // 第二行：空, 空, 空, FC, FC+, AP, AP+
        // 第三行：空, 空, Sync, FS, FS+, FDX, FDX+
        // 第四行：随机, 空, 1星, 2星, 3星, 4星, 5星
        
        val rows = statTable.select("tr")
        val record = MaimaiPlayRecordDTO()
        
        // 从 URL 参数中获取当前难度
        // 例如：search/?genre=99&diff=3 表示 MASTER 难度
        val currentUrl = doc.location() ?: ""
        val diffParam = Regex("diff=(\\d+)").find(currentUrl)?.groupValues?.getOrNull(1)
        record.difficulty = when (diffParam) {
            "0" -> "BASIC"
            "1" -> "ADVANCED"
            "2" -> "EXPERT"
            "3" -> "MASTER"
            "4" -> "Re:MASTER"
            "10" -> "UTAGE"
            else -> "ALL"
        }
        
        try {
            // 第一行：评级统计
            if (rows.size > 0) {
                val cells = rows[0].select("td")
                if (cells.size >= 7) {
                    // Clear: 328/1198
                    val clearText = cells[0].selectFirst("div.f_10")?.text() ?: ""
                    val clearMatch = Regex("(\\d+)/(\\d+)").find(clearText)
                    if (clearMatch != null) {
                        record.clearCount = clearMatch.groupValues[1].toIntOrNull() ?: 0
                        record.clearTotal = clearMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // S, S+, SS, SS+, SSS, SSS+
                    // 依次解析其他评级
                }
            }
            
            // 第二行：Combo 统计
            if (rows.size > 1) {
                val cells = rows[1].select("td")
                if (cells.size >= 7) {
                    // FC: index 3
                    val fcText = cells[3].selectFirst("div.f_10")?.text() ?: ""
                    val fcMatch = Regex("(\\d+)/(\\d+)").find(fcText)
                    if (fcMatch != null) {
                        record.fcCount = fcMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fcTotal = fcMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // FC+: index 4
                    val fcpText = cells[4].selectFirst("div.f_10")?.text() ?: ""
                    val fcpMatch = Regex("(\\d+)/(\\d+)").find(fcpText)
                    if (fcpMatch != null) {
                        record.fcpCount = fcpMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fcpTotal = fcpMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // AP: index 5
                    val apText = cells[5].selectFirst("div.f_10")?.text() ?: ""
                    val apMatch = Regex("(\\d+)/(\\d+)").find(apText)
                    if (apMatch != null) {
                        record.apCount = apMatch.groupValues[1].toIntOrNull() ?: 0
                        record.apTotal = apMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // AP+: index 6
                    val appText = cells[6].selectFirst("div.f_10")?.text() ?: ""
                    val appMatch = Regex("(\\d+)/(\\d+)").find(appText)
                    if (appMatch != null) {
                        record.appCount = appMatch.groupValues[1].toIntOrNull() ?: 0
                        record.appTotal = appMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                }
            }
            
            // 第三行：Sync 统计
            if (rows.size > 2) {
                val cells = rows[2].select("td")
                if (cells.size >= 7) {
                    // Sync: index 2
                    // FS: index 3
                    val fsText = cells[3].selectFirst("div.f_10")?.text() ?: ""
                    val fsMatch = Regex("(\\d+)/(\\d+)").find(fsText)
                    if (fsMatch != null) {
                        record.fsCount = fsMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fsTotal = fsMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // FS+: index 4
                    val fspText = cells[4].selectFirst("div.f_10")?.text() ?: ""
                    val fspMatch = Regex("(\\d+)/(\\d+)").find(fspText)
                    if (fspMatch != null) {
                        record.fspCount = fspMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fspTotal = fspMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // FDX: index 5
                    val fdxText = cells[5].selectFirst("div.f_10")?.text() ?: ""
                    val fdxMatch = Regex("(\\d+)/(\\d+)").find(fdxText)
                    if (fdxMatch != null) {
                        record.fdxCount = fdxMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fdxTotal = fdxMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                    
                    // FDX+: index 6
                    val fdxpText = cells[6].selectFirst("div.f_10")?.text() ?: ""
                    val fdxpMatch = Regex("(\\d+)/(\\d+)").find(fdxpText)
                    if (fdxpMatch != null) {
                        record.fdxpCount = fdxpMatch.groupValues[1].toIntOrNull() ?: 0
                        record.fdxpTotal = fdxpMatch.groupValues[2].toIntOrNull() ?: 0
                    }
                }
            }
            
            records.add(record)
            Log.d(TAG, "Parsed record for difficulty: ${record.difficulty}")
            Log.d(TAG, "  Clear: ${record.clearCount}/${record.clearTotal}")
            Log.d(TAG, "  FC: ${record.fcCount}/${record.fcTotal}, FC+: ${record.fcpCount}/${record.fcpTotal}")
            Log.d(TAG, "  AP: ${record.apCount}/${record.apTotal}, AP+: ${record.appCount}/${record.appTotal}")
            Log.d(TAG, "  FS: ${record.fsCount}/${record.fsTotal}, FS+: ${record.fspCount}/${record.fspTotal}")
            Log.d(TAG, "  FDX: ${record.fdxCount}/${record.fdxTotal}, FDX+: ${record.fdxpCount}/${record.fdxpTotal}")
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing play record", e)
        }
        
        Log.d(TAG, "=== Completed parsePlayRecord ===")
        return records
    }

    /**
     * 请求用户数据（主页）
     */
    private suspend fun requestPlayerData() {
        requestDataFromServer("$MAIMAI_URL/home/")?.let { doc ->
            val userData = parseMaimaiUser(doc)
            
            if (isUserDataValid(userData)) {
                userDataStore.saveUserData(userData)
                maimaiLocalService.saveUserData(userData)
            } else {
                Log.w(TAG, "User data validation failed")
            }
        }
    }
    
    /**
     * 验证用户数据是否有效
     */
    private fun isUserDataValid(user: MaimaiUserDTO): Boolean {
        return user.userName.isNotEmpty() && user.rating.isNotEmpty()
    }

    /**
     * 请求 BEST 成绩数据
     */
    private suspend fun requestBestScores() {
        requestDataFromServer("$MAIMAI_URL/record/musicMybest/")?.let { doc ->
            val scores = parseMaimaiScores(doc)
            maimaiLocalService.saveRatingData(scores, "BEST")
        }
    }

    /**
     * 请求最近游玩数据
     */
    private suspend fun requestRecentScores() {
        requestDataFromServer("$MAIMAI_URL/record/musicLatest/")?.let { doc ->
            val scores = parseMaimaiScores(doc)
            maimaiLocalService.saveRatingData(scores, "NEW")
        }
    }

    /**
     * 请求所有成绩数据（遍历所有难度）
     */
    suspend fun requestAllScores() {
        if (!isSongsRequestRunning.compareAndSet(false, true)) {
            Log.w(TAG, "All scores request already running")
            return
        }
        
        try {
            Log.d(TAG, "Starting all scores request")
            val allScores = mutableListOf<MaimaiScoreDTO>()
            
            // 遍历所有难度: 0=BASIC, 1=ADVANCED, 2=EXPERT, 3=MASTER, 4=Re:MASTER
            val difficulties = listOf(0, 1, 2, 3, 4)
            
            for (diff in difficulties) {
                val diffName = when(diff) {
                    0 -> "BASIC"
                    1 -> "ADVANCED"
                    2 -> "EXPERT"
                    3 -> "MASTER"
                    4 -> "Re:MASTER"
                    else -> "UNKNOWN"
                }
                
                Log.d(TAG, "Requesting $diffName scores...")
                
                // genre=99 表示所有种类
                val url = "$MAIMAI_URL/record/musicGenre/search/?genre=99&diff=$diff"
                requestDataFromServer(url)?.let { doc ->
                    val scores = parseMaimaiScores(doc)
                    allScores.addAll(scores)
                    Log.d(TAG, "Fetched ${scores.size} scores for $diffName")
                }
                
                // 避免请求过快
                delay(500)
            }
            
            // 保存所有成绩到数据库
            if (allScores.isNotEmpty()) {
                maimaiLocalService.saveRatingData(allScores, "ALL")
                Log.d(TAG, "All scores request completed: ${allScores.size} total scores")
            } else {
                Log.w(TAG, "No scores found")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting all scores", e)
        } finally {
            isSongsRequestRunning.set(false)
        }
    }

    /**
     * 请求游戏记录统计
     */
    private suspend fun requestPlayRecord() {
        requestDataFromServer("$MAIMAI_URL/record/")?.let { doc ->
            val records = parsePlayRecord(doc)
            maimaiLocalService.savePlayRecordData(records)
        }
    }

    /**
     * 请求所有用户相关数据
     */
    suspend fun requestAllUserData() {
        if (!isUserRequestRunning.compareAndSet(false, true)) {
            Log.w(TAG, "User data request already running")
            return
        }
        
        try {
            Log.d(TAG, "Starting user data request")
            coroutineScope {
                launch { requestPlayerData() }
                launch { 
                    delay(500) // 避免请求过快
                    requestBestScores() 
                }
                launch { 
                    delay(1000)
                    requestRecentScores() 
                }
                launch { 
                    delay(1500)
                    requestPlayRecord() 
                }
            }
            Log.d(TAG, "User data request completed")
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting user data", e)
        } finally {
            isUserRequestRunning.set(false)
        }
    }

    /**
     * 请求所有乐曲数据
     */
    suspend fun requestAllSongData() {
        if (!isSongsRequestRunning.compareAndSet(false, true)) {
            Log.w(TAG, "Song data request already running")
            return
        }
        
        try {
            Log.d(TAG, "Starting song data request")
            // 遍历所有难度和分类请求乐曲数据
            // 实际实现需要根据需求调整
            Log.d(TAG, "Song data request completed")
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting song data", e)
        } finally {
            isSongsRequestRunning.set(false)
        }
    }
}
