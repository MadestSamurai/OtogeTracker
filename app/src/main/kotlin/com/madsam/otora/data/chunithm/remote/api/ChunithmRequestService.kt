package com.madsam.otora.data.chunithm.remote.api

import android.content.Context
import android.util.Log
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import com.fleeksoft.ksoup.nodes.Element
import com.madsam.otora.core.utils.StringUtils
import com.madsam.otora.core.utils.UserAgentUtils
import com.madsam.otora.core.datastore.UserAgentDataStore
import com.madsam.otora.data.BASE_URL
import com.madsam.otora.data.CHUNITHM_URL
import com.madsam.otora.data.adapter.SafeBooleanAdapter
import com.madsam.otora.data.adapter.SafeDoubleAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeIntListAdapter
import com.madsam.otora.data.adapter.SafeIntPairAdapter
import com.madsam.otora.data.adapter.SafeLongAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.adapter.SafeStringListAdapter
import com.madsam.otora.data.chunithm.local.datastore.ChunithmCookieDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmPenguinDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmStatueDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmUserDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmUserExtDataStore
import com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmRatingEntity
import com.madsam.otora.data.chunithm.local.objectbox.ChunithmObjectBoxService
import com.madsam.otora.data.chunithm.remote.model.ChunithmAvatarItemDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmCookieDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmGenreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmMapDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmMapDTO.ChuniMapArea
import com.madsam.otora.data.chunithm.remote.model.ChunithmPenguinDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmPlayRecordDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmStatueDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmUserExtendDTO
import com.madsam.otora.data.chunithm.remote.model.DailyReward
import com.madsam.otora.data.chunithm.remote.model.MonthlyReward
import com.madsam.otora.data.chunithm.remote.model.WeekdayBonus
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
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.atomic.AtomicBoolean

internal class ChunithmRequestService(private val context: Context) {
    companion object {
        private const val TAG = "ChunithmRequestService"
        
        // Regex patterns - 提取为常量以提高性能和可读性
        private val HONOR_STYLE_REGEX = Regex("honor_bg_([a-zA-Z0-9]+)")
        private val URL_EXTRACTOR_REGEX = Regex("url\\(([^)]+)\\)")
        private val CHARACTER_LEVEL_REGEX = Regex("num_s_lv_(\\d)\\.png")
        private val LOGIN_DAYS_REGEX = Regex("num_lv_(\\d+)")
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val isUserRequestRunning = AtomicBoolean(false)
    private val isSongsRequestRunning = AtomicBoolean(false)
    private val chunithmLocalService = ChunithmObjectBoxService()
    
    // DataStore 实例复用
    private val userDataStore by lazy { ChunithmUserDataStore(context) }
    private val penguinDataStore by lazy { ChunithmPenguinDataStore(context) }
    private val userExtDataStore by lazy { ChunithmUserExtDataStore(context) }
    private val statueDataStore by lazy { ChunithmStatueDataStore(context) }
    private val cookieDataStore by lazy { ChunithmCookieDataStore(context) }
    private val userAgentDataStore by lazy { UserAgentDataStore(context) }
    
    // UserAgent 从 DataStore 延迟加载
    private var userAgent: String? = null
    
    /**
     * 获取 UserAgent，首次调用时从 DataStore 加载
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
    private var cookie: ChunithmCookieDTO? = null
    
    /**
     * 获取 Cookie，首次调用时从 DataStore 加载
     */
    private suspend fun getCookie(): ChunithmCookieDTO {
        if (cookie == null) {
            cookie = cookieDataStore.getCookie()
        }
        return cookie!!
    }
    
    /**
     * 更新 Cookie 并保存到 DataStore
     */
    private suspend fun updateCookie(newCookie: ChunithmCookieDTO) {
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
    
    private fun buildCookieString(cookie: ChunithmCookieDTO): String = buildString {
        append("_t=${cookie.token}")
        append("; expires=${cookie.expires}")
        append("; Max-Age=${cookie.maxAge}")
        append("; path=${cookie.path}")
        append("; SameSite=${cookie.sameSite}")
        append("; userId=${cookie.userId}")
        append("; friendCodeList=${cookie.friendCodeList}")
        
        if (cookie.gaKey.isNotEmpty()) {
            append("; ${cookie.gaKey}=${cookie.gaValue}")
            append("; _ga=${cookie.ga}")
        }
    }

    private fun parseChuniUser(doc: Document): ChunithmUserDTO {
        Log.d(TAG, "=== Starting parseChuniUser ===")
        val chunithmUserDTO = ChunithmUserDTO()
        
        chunithmUserDTO.nameIn = doc.selectFirst("div.player_name_in")?.text() ?: ""
        Log.d(TAG, "nameIn: ${chunithmUserDTO.nameIn}")

        // 更健壮的背景解析，直接从 style 属性中提取
        chunithmUserDTO.profileBackground = doc.selectFirst("div.box_playerprofile")
            ?.attr("style")
            ?.let { style ->
                Log.d(TAG, "Profile background style: $style")
                // 匹配 url(...) 中的内容
                URL_EXTRACTOR_REGEX.find(style)?.groupValues?.getOrNull(1)
                    ?.split("/")?.lastOrNull()
                    ?.split(".")?.firstOrNull()
                    ?.removePrefix("profile_")
            } ?: ""
        Log.d(TAG, "profileBackground: ${chunithmUserDTO.profileBackground}")

        chunithmUserDTO.reborn = doc.selectFirst("div.player_reborn")?.text()?.toIntOrNull() ?: 0
        Log.d(TAG, "reborn: ${chunithmUserDTO.reborn}")
        
        chunithmUserDTO.level = doc.selectFirst("div.player_lv")?.text()?.toIntOrNull() ?: 0
        Log.d(TAG, "level: ${chunithmUserDTO.level}")

        // 简化 rating 解析逻辑
        val ratingBlock = doc.selectFirst("div.player_rating_num_block")
        Log.d(TAG, "Rating block found: ${ratingBlock != null}")
        
        val ratingImages = ratingBlock?.select("img")
        Log.d(TAG, "Rating images count: ${ratingImages?.size ?: 0}")
        
        chunithmUserDTO.rating = ratingImages
            ?.mapNotNull { img ->
                val srcFile = img.attr("src").split("/").lastOrNull() ?: return@mapNotNull null
                Log.d(TAG, "Processing rating image: $srcFile")

                when {
                    srcFile.contains("comma") -> {
                        Log.d(TAG, "Found comma")
                        "."
                    }
                    else -> {
                        // 从文件名中提取数字，如 rating_platinum_01.png -> 01 -> 1
                        val number = srcFile.split(".").firstOrNull()
                            ?.split("_")?.lastOrNull()
                            ?.toIntOrNull()
                            ?.toString()
                        
                        if (number == null) {
                            Log.w(TAG, "Failed to parse rating number from: $srcFile")
                        } else {
                            Log.d(TAG, "Parsed rating digit: $number from $srcFile")
                        }
                        number
                    }
                }
            }
            ?.joinToString("")
            ?.also { Log.d(TAG, "Joined rating string: '$it'") }
            ?.takeIf { it.isNotBlank() } // 如果结果为空则返回 null
            ?: "0.00" // 默认值改为 "0.00" 而不是空字符串
        Log.d(TAG, "Final rating: ${chunithmUserDTO.rating}")
        
        chunithmUserDTO.overpower = doc.selectFirst("div.player_overpower_text")?.text() ?: ""
        Log.d(TAG, "overpower: ${chunithmUserDTO.overpower}")
        
        chunithmUserDTO.lastPlay = doc.selectFirst("div.player_lastplaydate_text")?.text() ?: ""
        Log.d(TAG, "lastPlay: ${chunithmUserDTO.lastPlay}")

        chunithmUserDTO.roleImageUrl = doc.selectFirst("div.player_chara_info img")?.attr("src") ?: ""
        Log.d(TAG, "roleImageUrl: ${chunithmUserDTO.roleImageUrl}")
        
        // 使用正则表达式更精确地提取 charaframe 类型
        chunithmUserDTO.roleBase = doc.selectFirst("div.player_chara_info")
            ?.attr("style")
            ?.let { style ->
                Log.d(TAG, "Role base style: $style")
                URL_EXTRACTOR_REGEX.find(style)?.groupValues?.getOrNull(1)
                    ?.split("/")?.lastOrNull()
                    ?.split(".")?.firstOrNull()
                    ?.removePrefix("charaframe_")
            } ?: ""
        Log.d(TAG, "roleBase: ${chunithmUserDTO.roleBase}")

        val (honor1, honor2, honor3, honorBase1, honorBase2, honorBase3) = extractHonorInfo(doc)
        chunithmUserDTO.honor1 = honor1
        chunithmUserDTO.honor2 = honor2
        chunithmUserDTO.honor3 = honor3
        chunithmUserDTO.honorBase1 = honorBase1
        chunithmUserDTO.honorBase2 = honorBase2
        chunithmUserDTO.honorBase3 = honorBase3
        Log.d(TAG, "Honors: [$honor1, $honor2, $honor3]")
        Log.d(TAG, "Honor bases: [$honorBase1, $honorBase2, $honorBase3]")

        chunithmUserDTO.classEmblemBase = doc.selectFirst("div.player_classemblem_base")
            ?.selectFirst("img")?.attr("src") ?: ""
        Log.d(TAG, "classEmblemBase: ${chunithmUserDTO.classEmblemBase}")

        chunithmUserDTO.classEmblemTop = doc.selectFirst("div.player_classemblem_top")
            ?.selectFirst("img")?.attr("src") ?: ""
        Log.d(TAG, "classEmblemTop: ${chunithmUserDTO.classEmblemTop}")

        Log.d(TAG, "=== Completed parseChuniUser ===")
        return chunithmUserDTO
    }

    /**
     * 提取荣誉信息，支持最多3个荣誉称号及其背景类型
     * @return Sextuple(honor1, honor2, honor3, honorBase1, honorBase2, honorBase3)
     */
    private fun extractHonorInfo(root: Element): Sextuple<String, String, String, String, String, String> {
        val honorBlocks = root.select("div.player_honor_short")
        if (honorBlocks.isEmpty()) {
            return Sextuple("", "", "", "", "", "")
        }

        // 提取所有荣誉文本（从 span 中），最多3个
        val honorTexts = honorBlocks.mapNotNull { honorBlock ->
            honorBlock.selectFirst("span")
                ?.text()
                ?.takeIf { it.isNotBlank() }
        }

        // 从每个荣誉的 style 属性中提取背景类型
        // 例如：style="background-image:url(...honor_bg_platina.png)" -> "platina"
        val honorBases = honorBlocks.map { honorBlock ->
            honorBlock.attr("style")
                .let { style ->
                    HONOR_STYLE_REGEX.find(style)?.groupValues?.getOrNull(1) ?: ""
                }
        }

        return Sextuple(
            honorTexts.getOrNull(0) ?: "",
            honorTexts.getOrNull(1) ?: "",
            honorTexts.getOrNull(2) ?: "",
            honorBases.getOrNull(0) ?: "",
            honorBases.getOrNull(1) ?: "",
            honorBases.getOrNull(2) ?: ""
        )
    }

    /**
     * 六元组数据类，用于返回六个值
     */
    private data class Sextuple<out A, out B, out C, out D, out E, out F>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F
    )

    private fun parseChuniPenguin(doc: Document): ChunithmPenguinDTO {
        return ChunithmPenguinDTO().apply {
            back = doc.selectFirst("div.avatar_back img")?.attr("src") ?: ""
            skinfootR = doc.selectFirst("div.avatar_skinfoot_r img")?.attr("src") ?: ""
            skinfootL = doc.selectFirst("div.avatar_skinfoot_l img")?.attr("src") ?: ""
            skin = doc.selectFirst("div.avatar_skin img")?.attr("src") ?: ""
            wear = doc.selectFirst("div.avatar_wear img")?.attr("src") ?: ""
            face = doc.selectFirst("div.avatar_face img")?.attr("src") ?: ""
            faceCover = doc.selectFirst("div.avatar_faceCover img")?.attr("src") ?: ""
            head = doc.selectFirst("div.avatar_head img")?.attr("src") ?: ""
            handR = doc.selectFirst("div.avatar_hand_r img")?.attr("src") ?: ""
            handL = doc.selectFirst("div.avatar_hand_l img")?.attr("src") ?: ""
            itemR = doc.selectFirst("div.avatar_item_r img")?.attr("src") ?: ""
            itemL = doc.selectFirst("div.avatar_item_l img")?.attr("src") ?: ""
            front = doc.selectFirst("div.avatar_front img")?.attr("src") ?: ""  // 新增
        }
    }

    private fun parseChuniUserExtend(doc: Document): ChunithmUserExtendDTO {
        val chunithmUserExtendDTO = ChunithmUserExtendDTO()
        chunithmUserExtendDTO.friendCode = doc.getElementsByClass("user_data_friend_code").firstOrNull()
            ?.getElementsByAttributeValue("style", "display:none;")?.text() ?: ""
        chunithmUserExtendDTO.point = doc.getElementsByClass("user_data_point").firstOrNull()?.text() ?: ""
        chunithmUserExtendDTO.totalPoint = doc.getElementsByClass("user_data_total_point").firstOrNull()?.text() ?: ""
        chunithmUserExtendDTO.playCount = doc.getElementsByClass("user_data_play_count").firstOrNull()?.text() ?: ""
        return chunithmUserExtendDTO
    }

    private suspend fun requestPlayerData() {
        val doc = requestDataFromServer("$CHUNITHM_URL/home/playerData") ?: run {
            Log.e(TAG, "Failed to get document from server")
            return
        }

        // 并行解析三个数据
        val chuniUser = parseChuniUser(doc)
        val penguinData = parseChuniPenguin(doc)
        val userExtData = parseChuniUserExtend(doc)
        
        // 验证用户数据质量
        if (!isUserDataValid(chuniUser)) {
            Log.w(TAG, "User data validation failed, skipping user data save")
            // 即使用户数据无效，仍保存 penguin 和 userExt 数据
        } else {
            // 并行保存三个数据到 DataStore
            coroutineScope {
                launch { userDataStore.saveUserData(chuniUser) }
                launch { penguinDataStore.savePenguinData(penguinData) }
                launch { userExtDataStore.saveUserExtData(userExtData) }
            }
        }
    }
    
    /**
     * 验证用户数据是否有效
     * 通过检查关键字段是否为空来判断
     */
    private fun isUserDataValid(user: ChunithmUserDTO): Boolean {
        // 检查关键字段而不是用反射计数所有空字段
        return user.nameIn.isNotEmpty() && 
               user.rating.isNotEmpty() && 
               user.rating != "0.00"
    }

    private fun parseRatingData(doc: Document): List<ChunithmScoreDTO> =
        doc.getElementsByTag("form").map { rating ->
            ChunithmScoreDTO(
                id = rating.select("input[name=idx]").attr("value"),
                title = rating.getElementsByClass("music_title").text(),
                genre = rating.select("input[name=genre]").attr("value"),
                diff = rating.select("input[name=diff]").attr("value"),
                token = rating.select("input[name=token]").attr("value"),
                highScore = rating.getElementsByClass("text_b").text()
            )
        }

    /**
     * 通用的 Rating 数据请求函数
     * @param endpoint API 端点路径
     * @param ratingType Rating 类型 (BEST/RECENT/SUGGEST)
     */
    private suspend fun requestRatingData(endpoint: String, ratingType: String) {
        requestDataFromServer("$CHUNITHM_URL$endpoint")?.let { doc ->
            val ratingData = parseRatingData(doc)
            chunithmLocalService.saveRatingData(ratingData, ratingType)
        }
    }

    private suspend fun requestRatingBest() = 
        requestRatingData("/home/playerData/ratingDetailBest", ChunithmRatingEntity.TYPE_BEST)

    private suspend fun requestRatingRecent() = 
        requestRatingData("/home/playerData/ratingDetailRecent", ChunithmRatingEntity.TYPE_RECENT)

    private suspend fun requestRatingNext() = 
        requestRatingData("/home/playerData/ratingDetailNext", ChunithmRatingEntity.TYPE_SUGGEST)

    private fun parseChuniMaps(doc: Document): List<ChunithmMapDTO> =
        doc.select("div.map_block.w400").map { block ->
            val title = block.select("div.map_title_text.text_l.text_b").text()
            val currentPage = block.select("div.map_title_page_num.font_90").text().toIntOrNull() ?: 0
            val totalPages = block.select("div.map_title_page_den.font_90").text().toIntOrNull() ?: 0
            
            // 获取所有9个格子（包括空白格子），保持位置信息
            val areas = block.select("div.maparea_block")
                .map { areaBlock ->
                    // 检查是否是空白格子
                    val isBlank = areaBlock.selectFirst("div.maparea_blank") != null
                    
                    if (isBlank) {
                        // 空白格子
                        ChuniMapArea(
                            imageUrl = null,
                            remain = 0,
                            skillSeed = null
                        )
                    } else {
                        // 有内容的格子
                        areaBlock.selectFirst("div.maparea")?.let { mapAreaDiv ->
                            // 尝试多种可能的图标选择器
                            val imageUrl = mapAreaDiv.select("div.map_icon div.map_icon_avatar img").attr("src")
                                .takeIf { it.isNotBlank() }
                                ?: mapAreaDiv.select("div.map_icon div.map_icon_chara img").attr("src")
                                    .takeIf { it.isNotBlank() }
                                ?: mapAreaDiv.select("div.map_icon div.map_icon_nameplate img").attr("src")
                                    .takeIf { it.isNotBlank() }
                            
                            ChuniMapArea(
                                imageUrl = imageUrl,
                                remain = mapAreaDiv.select("div.map_remain div.map_remain_text")
                                    .text()
                                    .toIntOrNull() ?: 0,
                                skillSeed = mapAreaDiv.select("div.map_skillseed_block div.map_skillseed_text")
                                    .text()
                                    .takeIf { it.isNotBlank() }
                            )
                        } ?: ChuniMapArea(null, 0, null) // 防御性代码
                    }
                }
            
            ChunithmMapDTO(title, currentPage, totalPages, areas)
        }

    private suspend fun requestMapRecord() {
        requestDataFromServer("$CHUNITHM_URL/record")?.let { doc ->
            val mapData = parseChuniMaps(doc)
            chunithmLocalService.saveMapData(mapData)
        }
    }

    /**
     * 从图片 src 中提取最后一段标识符
     * 例如: "path/to/icon_clear.png" -> "clear"
     */
    private fun extractIconIdentifier(src: String): String =
        src.split("/").lastOrNull()
            ?.split(".")?.firstOrNull()
            ?.split("_")?.lastOrNull()
            ?: ""

    /**
     * 解析标记字符串，提取 clear、combo、chain 类型
     */
    private fun parseMarks(clearMarks: String): Triple<String, String, String> {
        val clear = when {
            clearMarks.contains("catastrophy") -> "catastrophy"
            clearMarks.contains("absolutep") -> "absolutep"
            clearMarks.contains("absolute") -> "absolute"
            clearMarks.contains("hard") -> "hard"
            clearMarks.contains("clear") -> "clear"
            else -> ""
        }
        
        val combo = when {
            clearMarks.contains("alljusticecritical") -> "ajc"
            clearMarks.contains("alljustice") -> "alljustice"
            clearMarks.contains("fullcombo") -> "fullcombo"
            else -> ""
        }
        
        val chain = when {
            clearMarks.contains("fullchain2") -> "fullchain2"
            clearMarks.contains("fullchain") -> "fullchain"
            else -> ""
        }
        
        return Triple(clear, combo, chain)
    }

    private fun parsePlayLog(doc: Document): List<ChunithmFullScoreDTO> =
        doc.getElementsByClass("frame02 w400").map { log ->
            val title = log.getElementsByClass("play_musicdata_title").text()
            val level = extractIconIdentifier(
                log.getElementsByClass("play_track_result")
                    .select("img").attr("src")
            )
            val score = log.getElementsByClass("play_musicdata_score_text").text()
            
            val marks = log.getElementsByClass("play_musicdata_icon clearfix")
            val clearMarks = marks.select("img")
                .joinToString("") { extractIconIdentifier(it.attr("src")) }
            
            val (clear, combo, chain) = parseMarks(clearMarks)
            
            val rankNum = extractIconIdentifier(
                marks.select("img[src*='rank']").attr("src")
            ).toIntOrNull() ?: -1
            
            val date = log.getElementsByClass("play_datalist_date").text()
            val trackNumber = log.getElementsByClass("play_track_text").text()
                .split(" ").lastOrNull() ?: ""
            
            ChunithmFullScoreDTO(
                title = title,
                diff = level,
                score = score,
                clear = clear,
                combo = combo,
                chain = chain,
                rank = rankNum,
                date = date,
                trackNumber = trackNumber
            )
        }

    private suspend fun requestPlayLog() {
        requestDataFromServer("$CHUNITHM_URL/record/playlog")?.let { doc ->
            val playLogs = parsePlayLog(doc)
            chunithmLocalService.savePlayLogs(playLogs)
        }
    }

    /**
     * 解析统计类别图片中的标识符，统一去掉 icon_ 前缀
     * 例如: "path/to/icon_rank_13.png" -> "rank_13"
     *       "path/to/icon_clear.png" -> "clear"
     */
    private fun extractStatsIdentifier(src: String): String {
        val filename = src.split("/").lastOrNull()
            ?.split(".")?.firstOrNull()
            ?: ""
        
        // 统一去掉 icon_ 前缀
        return filename.removePrefix("icon_")
    }

    private fun parsePlayRecord(doc: Document, diff: String): ChunithmPlayRecordDTO {
        val chunithmPlayRecordDTO = ChunithmPlayRecordDTO()
        var totalSongs = 0

        // 解析统计数据
        doc.select("div.score_list").forEach { scoreList ->
            val imgSrc = scoreList.select("div.score_list_top img").attr("src")
            val identifier = extractStatsIdentifier(imgSrc)
            
            val count = scoreList.select("div.score_num_text").text()
                .replace(",", "").trim()
                .toIntOrNull() ?: 0
            
            val total = scoreList.select("div.score_all_text.font_small").text()
                .replace("/", "").replace(",", "").trim()
                .toIntOrNull() ?: 0

            // 设置总曲目数（使用第一个找到的total值）
            if (totalSongs == 0 && total > 0) {
                totalSongs = total
            }

            // 使用标识符直接匹配，避免多次字符串搜索
            when (identifier) {
                // 评级统计
                "rank_13" -> chunithmPlayRecordDTO.rateSSSp = count  // SSS+
                "rank_12" -> chunithmPlayRecordDTO.rateSSS = count   // SSS
                "rank_11" -> chunithmPlayRecordDTO.rateSSp = count   // SS+
                "rank_10" -> chunithmPlayRecordDTO.rateSS = count    // SS
                "rank_9" -> chunithmPlayRecordDTO.rateSp = count     // S+
                "rank_8" -> chunithmPlayRecordDTO.rateS = count      // S
                // 达成统计（已去掉 icon_ 前缀）
                "clear" -> chunithmPlayRecordDTO.rateClear = count      // Clear
                "fullcombo" -> chunithmPlayRecordDTO.rateFC = count     // FC
                "alljustice" -> chunithmPlayRecordDTO.rateAJ = count    // AJ
                "alljusticecritical" -> chunithmPlayRecordDTO.rateAJC = count  // AJC
                "fullchain" -> chunithmPlayRecordDTO.rateFChain = count   // FChain
                "fullchain2" -> chunithmPlayRecordDTO.rateFChainP = count // FChain+
                // 难度统计（已去掉 icon_ 前缀）
                "hard" -> chunithmPlayRecordDTO.rateHard = count       // Hard
                "brave" -> chunithmPlayRecordDTO.rateBrave = count     // Brave
                "absolute" -> chunithmPlayRecordDTO.rateAbs = count    // Absolute
                "catastrophy" -> chunithmPlayRecordDTO.rateCatas = count // Catastrophy
            }
        }

        chunithmPlayRecordDTO.totalSongs = totalSongs

        // 解析各分类的成绩列表
        val diffLower = diff.toLowerCase(Locale.current)
        chunithmPlayRecordDTO.genreList = doc.getElementsByClass("box05 w400").map { genre ->
            val genreName = genre.getElementsByClass("genre scroll_point text_white").text()
            val genreScores = genre.getElementsByClass("w388 musiclist_box bg_$diffLower")
                .map { score ->
                    val marks = score.getElementsByClass("play_musicdata_icon clearfix").select("img")
                    val clearMarks = marks.joinToString("") { extractIconIdentifier(it.attr("src")) }
                    val (clear, combo, chain) = parseMarks(clearMarks)
                    val rankNum = extractIconIdentifier(
                        marks.select("img[src*='rank']").attr("src")
                    ).toIntOrNull() ?: -1

                    ChunithmFullScoreDTO(
                        id = score.select("input[name=idx]").attr("value"),
                        title = score.getElementsByClass("music_title").text(),
                        diff = score.select("input[name=diff]").attr("value"),
                        score = score.getElementsByClass("play_musicdata_highscore").select("span").text(),
                        genre = score.select("input[name=genre]").attr("value"),
                        token = score.select("input[name=token]").attr("value"),
                        clear = clear,
                        combo = combo,
                        chain = chain,
                        rank = rankNum
                    )
                }
            
            ChunithmGenreDTO(genreName, genreScores)
        }
        
        return chunithmPlayRecordDTO
    }

    private suspend fun requestPlayRecord() {
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        val currentCookie = getCookie()
        
        diffArray.forEach { diff ->
            val requestBody = mapOf(
                "genre" to "99",
                "token" to currentCookie.token
            )
            requestDataFromServer(
                link = "$CHUNITHM_URL/record/musicGenre/send$diff",
                requestBody = requestBody,
                isPost = true
            )?.let { doc ->
                val playRecordData = parsePlayRecord(doc, diff)
                chunithmLocalService.savePlayRecordData(playRecordData, diff)
            }
        }
    }

    private fun parseChuniStatue(doc: Document): ChunithmStatueDTO {
        val penguinCounts = mutableListOf<Int>()
        val penguinContainer = doc.select("div.box01_title.text_b")
            .firstOrNull { it.text().contains("企鹅雕像") }
            ?.parent()

        penguinContainer?.select("div.ticket_block_block")?.forEach { block ->
            block.select("div.ticket_hold_mini span.font_large")
                .forEach { span ->
                    penguinCounts.add(span.text().toIntOrNull() ?: 0)
                }
        }

        return ChunithmStatueDTO(
            soul = penguinCounts.getOrNull(0) ?: 0,
            sliver = penguinCounts.getOrNull(1) ?: 0,
            gold = penguinCounts.getOrNull(2) ?: 0,
            rainbow = penguinCounts.getOrNull(3) ?: 0
        )
    }
    
    /**
     * 解析角色列表页面
     * 从 /mobile/collection/characterList/ 页面提取所有角色数据
     */
    private fun parseCharacterList(doc: Document): List<ChunithmCharacterEntity> {
        val characters = mutableListOf<ChunithmCharacterEntity>()
        val currentTime = System.currentTimeMillis()
        
        try {
            // 获取 token
            val token = doc.select("input[name=token]").firstOrNull()?.attr("value") ?: ""
            
            // 获取当前使用的角色名称
            // 找到包含"使用中的角色"标题的 box01，然后在其内部找 character_list_block
            val currentCharacterName = doc.select("div.box01.w420")
                .firstOrNull { box -> 
                    box.select("div.box01_title").text().contains("使用中的角色")
                }
                ?.select("div.character_list_block div.character_name_block")
                ?.text()
                ?.trim() ?: ""
            
            // 解析所有拥有的角色
            val characterBlocks = doc.select("div.box01.w420.mt_25")
            characterBlocks.forEach { categoryBlock ->
                categoryBlock.select("div.character_list_block").forEach { block ->
                    // 获取角色名称，判断是否是当前使用的角色
                    val characterName = block.select("div.character_name_block form a").text().trim()
                    val isCurrentlyUsed = characterName == currentCharacterName
                    
                    parseCharacterBlock(block, isCurrentlyUsed = isCurrentlyUsed, token = token, syncedAt = currentTime)?.let {
                        characters.add(it)
                    }
                }
            }
            
            Log.d(TAG, "Parsed ${characters.size} characters (current: ${characters.count { it.isCurrentlyUsed }}, owned: ${characters.count { !it.isCurrentlyUsed }})")
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing character list", e)
        }
        
        return characters
    }
    
    /**
     * 解析单个角色块
     */
    private fun parseCharacterBlock(
        block: Element, 
        isCurrentlyUsed: Boolean, 
        token: String,
        syncedAt: Long
    ): ChunithmCharacterEntity? {
        try {
            // 获取角色ID（从 input[name=chara] 中获取）
            val charaId = block.select("input[name=chara]").firstOrNull()?.attr("value") ?: ""
            if (charaId.isEmpty()) {
                Log.w(TAG, "Character ID is empty, skipping")
                return null
            }
            
            // 获取角色名称（在 form a 标签中）
            val name = block.select("div.character_name_block form a").text().trim()
            if (name.isEmpty()) {
                Log.w(TAG, "Character name is empty, skipping")
                return null
            }
            
            // 获取角色图片URL（使用 data-original 属性，因为是懒加载）
            val imageUrl = block.select("div.list_chara_img img.lazy").attr("data-original")
            
            // 解析边框类型（从 div.list_chara_img 的背景图片URL提取）
            val frameStyle = block.select("div.list_chara_img").attr("style")
            val frameType = when {
                frameStyle.contains("charaframe_normal.png") -> ChunithmCharacterEntity.FRAME_NORMAL
                frameStyle.contains("charaframe_copper.png") -> ChunithmCharacterEntity.FRAME_COPPER
                frameStyle.contains("charaframe_silver.png") -> ChunithmCharacterEntity.FRAME_SILVER
                frameStyle.contains("charaframe_gold.png") -> ChunithmCharacterEntity.FRAME_GOLD
                frameStyle.contains("charaframe_platina.png") -> ChunithmCharacterEntity.FRAME_PLATINA
                else -> ChunithmCharacterEntity.FRAME_NORMAL
            }
            
            // 检查是否满级（查找 span.character_list_rank_max）
            val isMaxLevel = block.select("span.character_list_rank_max img").isNotEmpty()
            
            // 解析等级（从 span.character_list_rank_num 中的数字图片拼接）
            val levelImages = block.select("span.character_list_rank_num img")
            val level = levelImages
                .mapNotNull { img ->
                    val src = img.attr("src")
                    val digitMatch = CHARACTER_LEVEL_REGEX.find(src)
                    digitMatch?.groupValues?.get(1)
                }
                .joinToString("")
                .toIntOrNull() ?: 0
            
            // 获取经验条宽度
            val expBarWidth = if (!isMaxLevel) {
                block.select("div.character_list_gage_base img")
                    .firstOrNull()
                    ?.attr("width")
                    ?.replace("px", "")
                    ?.toIntOrNull() ?: 0
            } else {
                0 // 满级时经验条宽度为0
            }
            
            // 解析技能种子信息（可选）
            val skillSeedBlock = block.select("div.character_list_skillseed_block").firstOrNull()
            val skillSeedImageUrl = skillSeedBlock?.select("img.character_list_skillseed_img")
                ?.attr("src") ?: ""
            val skillSeedText = skillSeedBlock?.select("div.character_list_skillseed_txt")
                ?.text()?.trim() ?: ""
            val skillSeedVersionImageUrl = skillSeedBlock?.select("img.character_list_skillseed_version")
                ?.attr("src") ?: ""
            
            return ChunithmCharacterEntity(
                id = 0, // ObjectBox will auto-generate
                charaId = charaId,
                name = name,
                imageUrl = imageUrl,
                frameType = frameType,
                level = level,
                expBarWidth = expBarWidth,
                isMaxLevel = isMaxLevel,
                skillSeedImageUrl = skillSeedImageUrl,
                skillSeedText = skillSeedText,
                skillSeedVersionImageUrl = skillSeedVersionImageUrl,
                isCurrentlyUsed = isCurrentlyUsed,
                token = token,
                syncedAt = syncedAt
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing character block", e)
            return null
        }
    }

    private suspend fun requestCollection() {
        val doc = requestDataFromServer("$CHUNITHM_URL/collection") ?: return
        
        // 保存企鹅雕像数据到 DataStore（使用复用的实例）
        val statueData = parseChuniStatue(doc)
        statueDataStore.saveStatueData(statueData)
    }
    
    /**
     * 请求角色列表数据
     */
    private suspend fun requestCharacterList() {
        try {
            Log.d(TAG, "Requesting character list...")
            val doc = requestDataFromServer("$CHUNITHM_URL/collection/characterList/") ?: return
            
            // 解析角色数据
            val characters = parseCharacterList(doc)
            
            if (characters.isEmpty()) {
                Log.w(TAG, "No character data found")
                return
            }
            
            // 保存到 ObjectBox
            chunithmLocalService.saveCharacterData(characters, replaceAll = true)
            Log.d(TAG, "Character list saved: ${characters.size} characters")
            
            // 记录一些统计信息
            val currentChar = characters.firstOrNull { it.isCurrentlyUsed }
            val maxLevelCount = characters.count { it.isMaxLevel }
            val skillSeedCount = characters.count { it.skillSeedText.isNotEmpty() }
            
            Log.d(TAG, "Character stats - Current: ${currentChar?.name}, Max level: $maxLevelCount, With skill seed: $skillSeedCount")
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting character list", e)
        }
    }

    private fun parseFriendList(doc: Document): List<ChunithmFriendDTO> {
        val friendList = mutableListOf<ChunithmFriendDTO>()

        val friendBlocks = doc.select("div.friend_block")
        friendBlocks.forEach { block ->
            // 获取角色相关信息
            val roleImageUrl = block.selectFirst("div.player_data_left div.player_chara_info img")
                ?.attr("src") ?: ""

            val roleBase = block.selectFirst("div.player_data_left div.player_chara_info")
                ?.attr("style")?.split("/")?.lastOrNull()
                ?.split(".")?.firstOrNull()
                ?.split("_")?.lastOrNull()
                ?: ""

            // 获取背景板信息
            val profileBackground = block.selectFirst("div.box_playerprofile")
                ?.attr("style")?.split("/")?.lastOrNull()
                ?.split(".")?.firstOrNull()
                ?.removePrefix("profile_")
                ?: ""

            // 获取荣誉相关信息（支持最多3个荣誉及其背景）
            val (honor1, honor2, honor3, honorBase1, honorBase2, honorBase3) = extractHonorInfo(block)

            val classEmblemBase = block.selectFirst("div.player_classemblem_base")
                ?.selectFirst("img")?.attr("src") ?: ""
            val classEmblemTop = block.selectFirst("div.player_classemblem_top")
                ?.selectFirst("img")?.attr("src") ?: ""

            // 获取基本信息
            val reborn = block.selectFirst("div.player_reborn")?.text()?.toIntOrNull() ?: 0
            val level = block.selectFirst("div.player_lv")?.text()?.toIntOrNull() ?: 0
            val friendName = block.selectFirst("div.player_name_in form a")?.text() ?: ""
            val friendCode = block.selectFirst("input[name=idx]")?.attr("value") ?: ""
            val rating = block.selectFirst("div.player_rating_num_block")
                ?.select("img")
                ?.mapNotNull { img ->
                    val srcFile = img.attr("src").split("/").lastOrNull() ?: return@mapNotNull null

                    when {
                        srcFile.contains("comma") -> "."
                        else -> {
                            srcFile.split(".").firstOrNull()
                                ?.split("_")?.lastOrNull()
                                ?.toIntOrNull()
                                ?.toString()
                        }
                    }
                }
                ?.joinToString("")
                ?.takeIf { it.isNotBlank() }
                ?: "0.00"
            val overpower = block.selectFirst("div.player_overpower_text")?.text() ?: ""
            val lastPlayDate = block.selectFirst("div.player_lastplaydate_text")?.text() ?: ""

            // 检查按钮状态
            val isFavorite = block.selectFirst("div.friend_favorite_off") != null
            val isScored = block.selectFirst("div.friend_score_off") != null

            friendList.add(
                ChunithmFriendDTO(
                    friendName = friendName,
                    friendCode = friendCode,
                    profileBackground = profileBackground,
                    reborn = reborn,
                    level = level,
                    rating = rating,
                    overpower = overpower,
                    lastPlay = lastPlayDate,
                    roleImageUrl = roleImageUrl,
                    roleBase = roleBase,
                    honor1 = honor1,
                    honor2 = honor2,
                    honor3 = honor3,
                    honorBase1 = honorBase1,
                    honorBase2 = honorBase2,
                    honorBase3 = honorBase3,
                    isFavorite = isFavorite,
                    isScored = isScored,
                    classEmblemBase = classEmblemBase,
                    classEmblemTop = classEmblemTop
                )
            )
        }
        return friendList
    }

    private suspend fun requestFriend(
        onProgress: ((Float, String) -> Unit)? = null
    ) {
        val doc = requestDataFromServer("$CHUNITHM_URL/friend/") ?: return
        val friendListData = parseFriendList(doc)
        
        val chunithmObjectBoxService = ChunithmObjectBoxService()
        chunithmObjectBoxService.saveFriendListData(friendListData)
        
        // 为每个友人获取所有难度的成绩数据
        val favoriteCount = friendListData.count { it.isFavorite && it.friendCode.isNotEmpty() }
        Log.i(TAG, "Fetching friend scores for $favoriteCount favorite friends")
        
        if (favoriteCount == 0) {
            return
        }
        
        var processedCount = 0
        for (friend in friendListData) {
            if (friend.friendCode.isNotEmpty() && friend.isFavorite) {
                processedCount++
                
                // 更新好友处理进度
                withContext(Dispatchers.Main) {
                    onProgress?.invoke(
                        processedCount.toFloat() / favoriteCount,
                        "获取好友数据 (${processedCount}/${favoriteCount})"
                    )
                }
                
                // 获取所有难度的成绩 (0=Basic, 1=Advanced, 2=Expert, 3=Master, 4=Ultima)
                for (difficulty in 0..4) {
                    try {
                        requestFriendScoreList(friend.friendCode, difficulty)
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to fetch scores for ${friend.friendName}: ${e.message}")
                    }
                }
            }
        }
    }

    private fun parseLoginBonus(doc: Document): ChuniLoginBonusDTO {
        // 解析月度累计登录天数
        val monthlyDays = doc.select("div.monthly_cumulative_login_bonus_days_count_num img")
            .firstOrNull()?.attr("src")
            ?.let { src ->
                LOGIN_DAYS_REGEX.find(src)?.groupValues?.get(1)?.toIntOrNull()
            } ?: 0
        
        // 解析月度累计奖励列表
        val monthlyRewards = mutableListOf<MonthlyReward>()
        val monthlyRewardBlocks = doc.select("div.monthly_cumulative_login_bonus_reward")
        for (block in monthlyRewardBlocks) {
            val dayText = block.selectFirst("div.bonus_days_block")?.text() ?: ""
            val day = dayText.replace(Regex("[^0-9]"), "").toIntOrNull() ?: 0
            
            val imageUrl = block.selectFirst("div.monthly_cumulative_login_bonus_reward_img img")?.attr("src") ?: ""
            val rewardName = block.selectFirst("div.bonus_reward_name span")?.text() ?: ""
            // 根据当前累计天数判断是否已完成（达到或超过里程碑天数即为已完成）
            val isCompleted = monthlyDays >= day
            
            if (day > 0) {
                monthlyRewards.add(
                    MonthlyReward(
                        day = day,
                        imageUrl = imageUrl,
                        rewardName = rewardName,
                        isCompleted = isCompleted
                    )
                )
            }
        }
        
        // 解析每日登录奖励
        val dailyRewards = mutableListOf<DailyReward>()
        val dailyBlocks = doc.select("div.bonus_block_off, div.bonus_block_on, div.bonus_block_next")
        var dailyLoginDay = 0
        
        for (block in dailyBlocks) {
            val dayText = block.selectFirst("div.bonus_days_block")?.text() ?: ""
            val day = dayText.replace(Regex("[^0-9]"), "").toIntOrNull() ?: 0
            
            val imageUrl = block.selectFirst("div.bonus_reward_block img")?.attr("src") ?: ""
            val rewardName = block.selectFirst("div.bonus_reward_name span")?.text() ?: ""
            
            val isReceived = block.hasClass("bonus_block_off")
            val isNext = block.hasClass("bonus_block_next")
            
            if (day > 0) {
                dailyRewards.add(
                    DailyReward(
                        day = day,
                        imageUrl = imageUrl,
                        rewardName = rewardName,
                        isReceived = isReceived,
                        isNext = isNext
                    )
                )
                
                // 计算当前登录天数（最后一个已领取的天数）
                if (isReceived && day > dailyLoginDay) {
                    dailyLoginDay = day
                }
            }
        }
        
        // 解析每周奖励（不记录isToday，使用时动态判断）
        val weekdayBonuses = mutableListOf<WeekdayBonus>()
        val weekdayBlocks = doc.select("div.weekday_bonus_list_block div.weekday_bonus_block, div.weekday_bonus_today div.weekday_bonus_today_block")
        
        for (block in weekdayBlocks) {
            val weekday = block.selectFirst("div.weekday_bonus_week")?.text() ?: ""
            val iconUrl = block.selectFirst("div.weekday_bonus_info_icon img")?.attr("src") ?: ""
            val description = block.selectFirst("div.weekday_bonus_info_text")?.text() ?: ""
            
            if (weekday.isNotEmpty()) {
                weekdayBonuses.add(
                    WeekdayBonus(
                        weekday = weekday,
                        iconUrl = iconUrl,
                        description = description,
                        isToday = false  // 固定为false，使用时动态判断
                    )
                )
            }
        }

        return ChuniLoginBonusDTO(
            currentMonth = monthlyDays,
            monthlyDays = monthlyDays,
            totalDays = 0, // 总天数信息在HTML中不明确，保留为0
            monthlyRewards = monthlyRewards,
            dailyLoginDay = dailyLoginDay,
            dailyRewards = dailyRewards,
            weekdayBonuses = weekdayBonuses
        )
    }

    private suspend fun requestLoginBonus() {
        requestDataFromServer("$CHUNITHM_URL/loginBonus")?.let { doc ->
            val loginBonusData = parseLoginBonus(doc)
            // 保存到 ObjectBox
            val objectBoxService = ChunithmObjectBoxService()
            objectBoxService.saveLoginBonusData(
                currentMonthDays = loginBonusData.currentMonth,
                dailyStreakDay = loginBonusData.dailyLoginDay,
                monthlyRewards = loginBonusData.monthlyRewards,
                dailyRewards = loginBonusData.dailyRewards,
                weekdayBonuses = loginBonusData.weekdayBonuses
            )
        }
    }

    private fun parseFriendScoreList(doc: Document): List<ChunithmFullScoreDTO> {
        val friendScoreList = mutableListOf<ChunithmFullScoreDTO>()
        
        // 选择所有歌曲容器
        val scoreBlocks = doc.select("div.w388.music_box")
        for (block in scoreBlocks) {
            // 获取歌曲标题
            val title = block.select("div.block_underline.text_b.text_c div").text()
            
            // 获取对比结果容器
            val resultBlock = block.select("div.vs_list_result_block").first()
            if (resultBlock != null) {
                val infoBlocks = resultBlock.select("div.vs_list_infoblock")
                
                if (infoBlocks.size >= 2) {
                    // 第一个infoBlock是我的分数（但我们只需要友人分数）
                    // 第二个infoBlock是友人分数
                    val friendInfoBlock = infoBlocks[1]
                    val friendScore = friendInfoBlock.select("div.play_musicdata_highscore").text()
                    val friendBadgeImages = friendInfoBlock.select("div.vs_list_friendbatch img")
                    
                    // 解析友人的标记（只需要combo相关）
                    val friendMarks = friendBadgeImages.map { img ->
                        img.attr("src").split("/").last().split(".").first()
                    }
                    
                    // 在友人成绩页面中，只有Combo类型标记是有意义的
                    val friendCombo = when {
                        friendMarks.any { it.contains("alljusticecritical") } -> "ajc"
                        friendMarks.any { it.contains("alljustice") } -> "alljustice"
                        friendMarks.any { it.contains("fullcombo") } -> "fullcombo"
                        else -> ""
                    }
                    
                    // 添加友人的分数记录（只有当友人分数不为空且不为0时）
                    if (friendScore.isNotEmpty() && friendScore != "0") {
                        friendScoreList.add(
                            ChunithmFullScoreDTO(
                                title = title,
                                score = friendScore,
                                combo = friendCombo, // 只设置有意义的字段
                                isPersonalRecord = false // 标记为友人记录
                            )
                        )
                    }
                }
            }
        }
        
        return friendScoreList
    }

    private suspend fun requestFriendScoreList(friendCode: String, difficulty: Int) {
        try {
            val currentCookie = getCookie()
            val requestBody = mapOf(
                "genre" to "99",
                "friend" to friendCode,
                "radio_diff" to difficulty.toString(),
                "token" to currentCookie.token
            )
            
            val doc = requestDataFromServer(
                link = "$CHUNITHM_URL/friend/genreVs/sendBattleStart/",
                requestBody = requestBody,
                isPost = true
            ) ?: return
            
            val friendScoreData = parseFriendScoreList(doc)
            
            val difficultyNames = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
            val diffName = difficultyNames.getOrNull(difficulty) ?: "Unknown"
            
            val chunithmObjectBoxService = ChunithmObjectBoxService()
            chunithmObjectBoxService.saveFriendScoreData(friendScoreData, friendCode, diffName)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching friend score: ${e.message}")
            throw e
        }
    }

    private suspend fun requestSongsData() {
        try {
            val api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ChunithmAPI::class.java)
            
            val mergedData = fetchWithErrorHandling("Merged data") { api.getChunithmMergedData().execute() }
            
            if (mergedData?.songs?.isEmpty() != false) {
                Log.e(TAG, "No merged songs data found, check the api")
                return
            }
            
            val chunithmObjectBoxService = ChunithmObjectBoxService()
            chunithmObjectBoxService.saveMergedSongsData(mergedData)
            
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in requestSongsData: ${e.message}")
        }
    }
    
    private inline fun <reified T> fetchWithErrorHandling(
        dataType: String,
        request: () -> retrofit2.Response<T>
    ): T? {
        return try {
            val response = request()
            if (response.isSuccessful) {
                response.body() ?: run {
                    Log.e(TAG, "Failed to get $dataType: response body is null")
                    null
                }
            } else {
                Log.e(TAG, "Failed to get $dataType: ${response.code()}")
                null
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in $dataType: ${e.message}")
            null
        }
    }

    fun getUserData(
        onSuccess: (() -> Unit)? = null,
        onError: ((String) -> Unit)? = null,
        onProgress: ((Float, String) -> Unit)? = null
    ) {
        if (!isUserRequestRunning.getAndSet(true)) {
            serviceScope.launch {
                try {
                    // 基础步骤数（不包括好友数据）
                    val baseSteps = 10
                    var currentStep = 0
                    
                    // Helper function to update progress for base steps
                    suspend fun updateBaseProgress(message: String) {
                        currentStep++
                        val progress = (currentStep.toFloat() / (baseSteps + 1)) * 0.85f // 前85%给基础步骤
                        withContext(Dispatchers.Main) {
                            onProgress?.invoke(progress, message)
                        }
                    }
                    
                    // Regular request functions with progress updates
                    updateBaseProgress("获取玩家数据...")
                    requestPlayerData()
                    
                    updateBaseProgress("获取Rating Best...")
                    requestRatingBest()
                    
                    updateBaseProgress("获取Rating Recent...")
                    requestRatingRecent()
                    
                    updateBaseProgress("获取Rating Next...")
                    requestRatingNext()
                    
                    updateBaseProgress("获取地图记录...")
                    requestMapRecord()
                    
                    updateBaseProgress("获取游戏记录...")
                    requestPlayLog()
                    
                    updateBaseProgress("获取收藏数据...")
                    requestCollection()
                    
                    updateBaseProgress("获取角色列表...")
                    requestCharacterList()
                    
                    updateBaseProgress("获取Avatar部件...")
                    requestAllAvatarItems { avatarProgress, avatarMessage ->
                        // Avatar部件进度映射到总进度的一小部分
                        val mappedProgress = 0.85f * ((currentStep - 1 + avatarProgress) / (baseSteps + 1))
                        onProgress?.invoke(mappedProgress, avatarMessage)
                    }
                    
                    updateBaseProgress("获取登录奖励...")
                    requestLoginBonus()

                    updateBaseProgress("处理成绩记录...")
                    requestPlayRecord()
                    
                    // 好友数据处理，占用最后的15%进度
                    requestFriend { friendProgress, friendMessage ->
                        val totalProgress = 0.85f + (friendProgress * 0.15f) // 85% + 好友进度的15%
                        onProgress?.invoke(totalProgress, friendMessage)
                    }

                    // 保存 Cookie 到 DataStore（只保存必要的字段）
                    val currentCookie = getCookie()
                    updateCookie(currentCookie)
                    
                    withContext(Dispatchers.Main) {
                        onSuccess?.invoke()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        onError?.invoke(e.message ?: "未知错误")
                    }
                } finally {
                    isUserRequestRunning.set(false)
                }
            }
        }
    }

    fun getChuniSongsData(
        onSuccess: (() -> Unit)? = null,
        onError: ((String) -> Unit)? = null,
        onProgress: ((Float, String) -> Unit)? = null
    ) {
        if (!isSongsRequestRunning.getAndSet(true)) {
            serviceScope.launch {
                try {
                    withContext(Dispatchers.Main) {
                        onProgress?.invoke(0.1f, "初始化连接...")
                    }
                    delay(100)
                    
                    withContext(Dispatchers.Main) {
                        onProgress?.invoke(0.5f, "下载歌曲数据...")
                    }
                    
                    requestSongsData()

                    withContext(Dispatchers.Main) {
                        onProgress?.invoke(1.0f, "完成")
                        onSuccess?.invoke()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        onError?.invoke(e.message ?: "更新失败")
                    }
                } finally {
                    isSongsRequestRunning.set(false)
                }
            }
        } else {
            serviceScope.launch {
                withContext(Dispatchers.Main) {
                    onError?.invoke("歌曲数据更新正在进行中")
                }
            }
        }
    }
    
    // ==================== Avatar 自定义部件相关方法 ====================
    
    /**
     * 解析 Avatar 自定义页面的部件列表
     * @param doc HTML 文档
     * @param category 部件类型（face, head, wear, item, back, front）
     * @return Avatar 部件 DTO 列表
     */
    private fun parseAvatarItems(doc: Document, category: String): List<ChunithmAvatarItemDTO> {
        try {
            Log.d(TAG, "=== Parsing avatar items for category: $category ===")
            val items = mutableListOf<ChunithmAvatarItemDTO>()
            
            // 解析当前使用的部件（在 box01 w420 中，不在 box01 w420 name="wardId..." 中）
            val currentItemBlock = doc.select("div.box01.w420").firstOrNull { block ->
                block.selectFirst("div.box01_title.text_b")?.text()?.contains("设置中的") == true
            }
            
            val currentItem = currentItemBlock?.let { block ->
                parseAvatarItemBlock(block, category, isCurrentlyUsed = true)
            }
            
            currentItem?.let { items.add(it) }
            
            // 解析可用的部件列表
            val itemBlocks = doc.select("div.box01.w420[name^=wardId]")
            itemBlocks.forEach { block ->
                val item = parseAvatarItemBlock(block, category, isCurrentlyUsed = false)
                item?.let { items.add(it) }
            }
            
            Log.d(TAG, "Parsed ${items.size} avatar items for category $category")
            return items
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing avatar items for category $category", e)
            return emptyList()
        }
    }
    
    /**
     * 解析单个 Avatar 部件块
     */
    private fun parseAvatarItemBlock(
        block: Element,
        category: String,
        isCurrentlyUsed: Boolean
    ): ChunithmAvatarItemDTO? {
        try {
            // 获取图片 URL
            val imageUrl = block.select("div.avatar_img_side img")
                .firstOrNull()
                ?.attr("src") ?: ""
            
            // 获取部件名称 - 优先从 avatar_parts_name_block 中查找（可用部件），否则直接查找 avatar_parts_name（使用中的部件）
            val name = block.select("div.avatar_parts_name_block div.avatar_parts_name")
                .firstOrNull()
                ?.text()
                ?.trim()
                ?: block.select("div.avatar_parts_name")
                    .firstOrNull()
                    ?.text()
                    ?.trim()
                ?: ""
            
            // 获取 token 和 idx
            val token = block.select("input[name=token]").attr("value")
            val itemId = block.select("input[name=idx]").attr("value")
            
            // 如果没有名称，则无效
            if (name.isEmpty()) {
                Log.w(TAG, "Avatar item has no name, skipping")
                return null
            }
            
            // 如果不是当前使用的，必须有 ID
            if (itemId.isEmpty() && !isCurrentlyUsed) {
                Log.w(TAG, "Avatar item '$name' has no ID and is not currently used, skipping")
                return null
            }
            
            Log.d(TAG, "Parsed avatar item: name='$name', id='$itemId', isCurrentlyUsed=$isCurrentlyUsed")
            
            return ChunithmAvatarItemDTO(
                itemId = itemId,
                name = name,
                category = category,
                imageUrl = imageUrl,
                isCurrentlyUsed = isCurrentlyUsed,
                token = token
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing avatar item block", e)
            return null
        }
    }
    
    /**
     * 请求指定类型的 Avatar 部件数据
     * @param category 部件类型（face, head, wear, item, back, front）
     */
    private suspend fun requestAvatarItems(category: String) {
        try {
            val categoryPath = when (category) {
                "face" -> "customiseFace"
                "head" -> "customiseHead"
                "wear" -> "customiseWear"
                "item" -> "customiseItem"
                "back" -> "customiseBack"
                "front" -> "customiseFront"
                else -> return
            }
            
            Log.d(TAG, "Requesting avatar items for category: $category")
            val doc = requestDataFromServer("$CHUNITHM_URL/collection/avatarCustom/$categoryPath/") ?: return
            
            // 解析部件数据
            val items = parseAvatarItems(doc, category)
            
            if (items.isEmpty()) {
                Log.w(TAG, "No avatar items found for category: $category")
                return
            }
            
            // 转换为 Entity
            val syncedAt = System.currentTimeMillis()
            val entities = items.map { dto ->
                com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity(
                    id = 0, // ObjectBox auto-generate
                    itemId = dto.itemId,
                    name = dto.name,
                    category = dto.category,
                    imageUrl = dto.imageUrl,
                    isCurrentlyUsed = dto.isCurrentlyUsed,
                    token = dto.token,
                    syncedAt = syncedAt
                )
            }
            
            // 保存到 ObjectBox（只替换该类型的数据）
            chunithmLocalService.saveAvatarItems(entities, category)
            Log.d(TAG, "Avatar items saved for category $category: ${entities.size} items")
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting avatar items for category $category", e)
        }
    }
    
    /**
     * 请求所有 Avatar 部件数据
     */
    suspend fun requestAllAvatarItems(
        onProgress: ((Float, String) -> Unit)? = null
    ) {
        try {
            val categories = listOf("face", "head", "wear", "item", "back", "front")
            val categoryNames = mapOf(
                "face" to "面孔",
                "head" to "头部",
                "wear" to "服装",
                "item" to "道具",
                "back" to "背部",
                "front" to "前部"
            )
            
            categories.forEachIndexed { index, category ->
                val progress = (index + 1).toFloat() / categories.size
                val categoryName = categoryNames[category] ?: category
                withContext(Dispatchers.Main) {
                    onProgress?.invoke(progress, "获取${categoryName}部件...")
                }
                
                requestAvatarItems(category)
                delay(500) // 避免请求过快
            }
            
            withContext(Dispatchers.Main) {
                onProgress?.invoke(1.0f, "完成")
            }
            
            Log.d(TAG, "All avatar items requested successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting all avatar items", e)
            throw e
        }
    }
}
