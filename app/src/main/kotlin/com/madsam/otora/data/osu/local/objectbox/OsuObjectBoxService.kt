package com.madsam.otora.data.osu.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.osu.local.model.OsuBadgeEntity
import com.madsam.otora.data.osu.local.model.OsuBadgeEntity_
import com.madsam.otora.data.osu.local.model.OsuMedalEntity
import com.madsam.otora.data.osu.local.model.OsuMedalEntity_
import com.madsam.otora.data.osu.local.model.OsuRankHistoryEntity
import com.madsam.otora.data.osu.local.model.OsuRankHistoryEntity_
import com.madsam.otora.data.osu.local.model.OsuRecentActivityEntity
import com.madsam.otora.data.osu.local.model.OsuRecentActivityEntity_
import com.madsam.otora.data.osu.local.model.OsuScoreEntity
import com.madsam.otora.data.osu.local.model.OsuScoreEntity_
import com.madsam.otora.data.osu.local.model.OsuUserEntity
import com.madsam.otora.data.osu.local.model.OsuUserEntity_
import com.madsam.otora.data.osu.remote.model.OsuInfoDTO
import com.madsam.otora.data.osu.remote.model.OsuMedalItemDTO
import com.madsam.otora.data.osu.remote.model.OsuRecentActivityDTO
import com.madsam.otora.data.osu.remote.model.OsuTopRankItemDTO
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class OsuObjectBoxService {
    
    companion object {
        private const val TAG = "OsuObjectBoxService"
    }
    
    private val boxStore = ObjectBoxManager.getBoxStore()
    
    // 获取各种Box实例
    private val userBox: Box<OsuUserEntity> = boxStore.boxFor(OsuUserEntity::class.java)
    private val rankHistoryBox: Box<OsuRankHistoryEntity> = boxStore.boxFor(OsuRankHistoryEntity::class.java)
    private val scoreBox: Box<OsuScoreEntity> = boxStore.boxFor(OsuScoreEntity::class.java)
    private val recentActivityBox: Box<OsuRecentActivityEntity> = boxStore.boxFor(OsuRecentActivityEntity::class.java)
    private val badgeBox: Box<OsuBadgeEntity> = boxStore.boxFor(OsuBadgeEntity::class.java)
    private val medalBox: Box<OsuMedalEntity> = boxStore.boxFor(OsuMedalEntity::class.java)
    
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    
    // ==================== 用户数据 ====================
    
    /**
     * 保存用户数据（按天存储）
     * 同一天内多次更新会覆盖当天记录
     */
    suspend fun saveUserData(userId: Long, info: OsuInfoDTO) = withContext(Dispatchers.IO) {
        try {
            val user = info.user
            val stats = user.statistics
            val dateKey = dateFormat.format(Date())
            val uniqueKey = "${userId}_${dateKey}"
            val now = System.currentTimeMillis()
            
            // 查找是否已存在当天记录
            val existingEntity = userBox.query(
                OsuUserEntity_.uniqueKey.equal(uniqueKey)
            ).build().findFirst()
            
            val entity = (existingEntity ?: OsuUserEntity()).apply {
                this.odUserId = userId
                this.dateKey = dateKey
                this.uniqueKey = uniqueKey
                
                // 用户基础信息
                this.username = user.username
                this.country = user.country.name
                this.countryCode = user.countryCode
                this.avatarUrl = user.avatarUrl
                this.coverUrl = user.cover.url
                this.customCoverUrl = user.cover.customUrl
                this.profileHue = user.profileHue ?: -1
                this.profileColour = user.profileColour
                this.title = user.title
                this.isSupporter = user.isSupporter
                this.supportLevel = user.supportLevel
                this.isOnline = user.isOnline
                this.isBot = user.isBot
                this.isDeleted = user.isDeleted
                
                // 统计数据
                this.globalRank = stats.globalRank
                this.countryRank = stats.countryRank
                this.pp = stats.pp
                this.playCount = stats.playCount
                this.playTime = stats.playTime
                this.rankedScore = stats.rankedScore
                this.totalScore = stats.totalScore
                this.totalHits = stats.totalHits
                this.maxCombo = stats.maximumCombo
                this.accuracy = stats.hitAccuracy
                this.levelCurrent = stats.level.current.toInt()
                this.levelProgress = stats.level.progress.toInt()
                
                // Grade counts
                this.gradeSsh = stats.gradeCounts.ssh.toInt()
                this.gradeSs = stats.gradeCounts.ss.toInt()
                this.gradeSh = stats.gradeCounts.sh.toInt()
                this.gradeS = stats.gradeCounts.s.toInt()
                this.gradeA = stats.gradeCounts.a.toInt()
                
                // 其他
                this.followerCount = user.followerCount
                this.formerUsernames = user.previousUsernames.joinToString(",")
                this.tournamentBannerUrl = user.activeTournamentBanner.image
                this.highestRank = user.rankHighest.rank
                this.highestRankDate = user.rankHighest.updatedAt
                this.medalCount = user.userAchievements.size
                
                // Team信息
                this.teamId = user.team?.id ?: 0
                this.teamName = user.team?.name ?: ""
                this.teamShortName = user.team?.shortName ?: ""
                this.teamFlagUrl = user.team?.flagUrl ?: ""
                
                // 模式
                this.currentMode = info.currentMode
                
                // Mania Variants
                if (info.currentMode == "mania") {
                    val variant4k = stats.variants.find { it.variant == "4k" }
                    val variant7k = stats.variants.find { it.variant == "7k" }
                    
                    this.mania4kGlobalRank = variant4k?.globalRank ?: 0
                    this.mania4kCountryRank = variant4k?.countryRank ?: 0
                    this.mania7kGlobalRank = variant7k?.globalRank ?: 0
                    this.mania7kCountryRank = variant7k?.countryRank ?: 0
                } else {
                    this.mania4kGlobalRank = 0
                    this.mania4kCountryRank = 0
                    this.mania7kGlobalRank = 0
                    this.mania7kCountryRank = 0
                }
                
                this.updatedAt = now
            }
            
            userBox.put(entity)
            Log.d(TAG, "User data saved for userId=$userId, date=$dateKey")
            
            // 同时保存排名历史
            if (user.rankHistory.data.isNotEmpty()) {
                saveRankHistory(userId, user.rankHistory.mode, user.rankHistory.data)
            }
            
            // 保存徽章
            if (user.badges.isNotEmpty()) {
                saveBadges(userId, user.badges)
            }
            
            // 保存成就
            if (user.userAchievements.isNotEmpty() && info.achievements.isNotEmpty()) {
                saveMedals(userId, info.achievements, user.userAchievements)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save user data: ${e.message}", e)
        }
    }
    
    /**
     * 获取用户最新数据
     */
    suspend fun getLatestUserData(userId: Long): OsuUserEntity? = withContext(Dispatchers.IO) {
        try {
            userBox.query(OsuUserEntity_.odUserId.equal(userId))
                .orderDesc(OsuUserEntity_.updatedAt)
                .build()
                .findFirst()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get latest user data: ${e.message}", e)
            null
        }
    }
    
    /**
     * 获取用户历史数据（按天）
     */
    suspend fun getUserHistory(userId: Long, limit: Int = 90): List<OsuUserEntity> = withContext(Dispatchers.IO) {
        try {
            userBox.query(OsuUserEntity_.odUserId.equal(userId))
                .orderDesc(OsuUserEntity_.dateKey)
                .build()
                .find()
                .take(limit)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get user history: ${e.message}", e)
            emptyList()
        }
    }
    
    // ==================== 排名历史 ====================
    
    /**
     * 保存排名历史
     */
    private suspend fun saveRankHistory(userId: Long, mode: String, data: List<Int>) = withContext(Dispatchers.IO) {
        try {
            val uniqueKey = "${userId}_${mode}"
            val now = System.currentTimeMillis()
            
            val existingEntity = rankHistoryBox.query(
                OsuRankHistoryEntity_.uniqueKey.equal(uniqueKey)
            ).build().findFirst()
            
            val entity = (existingEntity ?: OsuRankHistoryEntity()).apply {
                this.odUserId = userId
                this.mode = mode
                this.uniqueKey = uniqueKey
                this.setRankList(data)
                this.updatedAt = now
            }
            
            rankHistoryBox.put(entity)
            Log.d(TAG, "Rank history saved for userId=$userId, mode=$mode")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save rank history: ${e.message}", e)
        }
    }
    
    /**
     * 获取排名历史
     */
    suspend fun getRankHistory(userId: Long, mode: String): OsuRankHistoryEntity? = withContext(Dispatchers.IO) {
        try {
            val uniqueKey = "${userId}_${mode}"
            rankHistoryBox.query(
                OsuRankHistoryEntity_.uniqueKey.equal(uniqueKey)
            ).build().findFirst()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get rank history: ${e.message}", e)
            null
        }
    }
    
    // ==================== 成绩数据 ====================
    
    /**
     * 保存BP成绩列表
     */
    suspend fun saveScores(userId: Long, scores: List<OsuTopRankItemDTO>, scoreType: String = "best") = withContext(Dispatchers.IO) {
        try {
            val now = System.currentTimeMillis()
            val entities = scores.mapIndexedNotNull { index, score ->
                if (score.id <= 0) return@mapIndexedNotNull null
                
                // 查找已存在的记录
                val existingEntity = scoreBox.query(
                    OsuScoreEntity_.odScoreId.equal(score.id)
                ).build().findFirst()
                
                (existingEntity ?: OsuScoreEntity()).apply {
                    this.odUserId = userId
                    this.odScoreId = score.id
                    this.scoreType = scoreType
                    
                    // 成绩基本信息
                    this.score = score.totalScore
                    this.maxCombo = score.maxCombo.toInt()
                    this.accuracy = score.accuracy
                    this.pp = score.pp
                    this.ppWeight = score.weight.pp
                    this.rank = score.rank
                    this.mods = score.mods.joinToString(",") { it.acronym }
                    this.passed = score.passed
                    this.perfect = score.isPerfectCombo
                    
                    // 统计 (osu! lazer API使用不同的字段名)
                    this.countGeki = score.statistics.perfect   // perfect (geki)
                    this.count300 = score.statistics.great      // great (300)
                    this.countKatu = score.statistics.good      // good (katu)
                    this.count100 = score.statistics.ok         // ok (100)
                    this.count50 = score.statistics.meh         // meh (50)
                    this.countMiss = score.statistics.miss      // miss
                    
                    // 谱面信息
                    this.beatmapId = score.beatmap.id
                    this.beatmapSetId = score.beatmap.beatmapSetId
                    this.beatmapTitle = score.beatmapSet.title
                    this.beatmapArtist = score.beatmapSet.artist
                    this.beatmapVersion = score.beatmap.version
                    this.beatmapDifficulty = score.beatmap.difficultyRating
                    this.beatmapBpm = score.beatmap.bpm
                    this.beatmapCs = score.beatmap.cs
                    this.beatmapAr = score.beatmap.ar
                    this.beatmapOd = score.beatmap.accuracy
                    this.beatmapHp = score.beatmap.drain
                    this.beatmapLength = score.beatmap.totalLength.toInt()
                    this.beatmapMode = score.beatmap.mode
                    this.beatmapStatus = score.beatmap.status
                    this.beatmapCoverUrl = score.beatmapSet.covers.cover
                    this.beatmapCreator = score.beatmapSet.creator
                    this.beatmapCreatorId = score.beatmapSet.userId
                    
                    // 位置
                    this.position = index + 1
                    
                    // 时间
                    this.playedAt = score.endedAt
                    this.updatedAt = now
                }
            }
            
            if (entities.isNotEmpty()) {
                scoreBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} scores for userId=$userId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save scores: ${e.message}", e)
        }
    }
    
    /**
     * 获取用户BP成绩
     */
    suspend fun getScores(userId: Long, scoreType: String = "best", limit: Int = 100): List<OsuScoreEntity> = withContext(Dispatchers.IO) {
        try {
            scoreBox.query(
                OsuScoreEntity_.odUserId.equal(userId)
                    .and(OsuScoreEntity_.scoreType.equal(scoreType))
            )
                .order(OsuScoreEntity_.position)
                .build()
                .find()
                .take(limit)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get scores: ${e.message}", e)
            emptyList()
        }
    }
    
    // ==================== 最近活动 ====================
    
    /**
     * 保存最近活动
     */
    suspend fun saveRecentActivities(userId: Long, activities: List<OsuRecentActivityDTO>) = withContext(Dispatchers.IO) {
        try {
            val now = System.currentTimeMillis()
            val entities = activities.mapNotNull { activity ->
                if (activity.id <= 0) return@mapNotNull null
                
                val existingEntity = recentActivityBox.query(
                    OsuRecentActivityEntity_.odActivityId.equal(activity.id)
                ).build().findFirst()
                
                (existingEntity ?: OsuRecentActivityEntity()).apply {
                    this.odUserId = userId
                    this.odActivityId = activity.id
                    this.type = activity.type
                    this.rank = activity.rank
                    this.scoreRank = activity.scoreRank
                    this.mode = activity.mode
                    
                    // 成就信息
                    this.achievementName = activity.achievement.name
                    this.achievementDescription = activity.achievement.description
                    this.achievementIconUrl = activity.achievement.iconUrl
                    this.achievementId = activity.achievement.id
                    
                    // 谱面信息
                    this.beatmapTitle = activity.beatmap.title
                    this.beatmapUrl = activity.beatmap.url
                    
                    // 谱面集信息
                    this.beatmapsetTitle = activity.beatmapset.title
                    this.beatmapsetUrl = activity.beatmapset.url
                    
                    this.createdAt = activity.createdAt
                    this.updatedAt = now
                }
            }
            
            if (entities.isNotEmpty()) {
                recentActivityBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} activities for userId=$userId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save recent activities: ${e.message}", e)
        }
    }
    
    /**
     * 获取最近活动
     */
    suspend fun getRecentActivities(userId: Long, limit: Int = 50): List<OsuRecentActivityEntity> = withContext(Dispatchers.IO) {
        try {
            recentActivityBox.query(OsuRecentActivityEntity_.odUserId.equal(userId))
                .orderDesc(OsuRecentActivityEntity_.createdAt)
                .build()
                .find()
                .take(limit)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get recent activities: ${e.message}", e)
            emptyList()
        }
    }
    
    // ==================== 徽章 ====================
    
    /**
     * 保存徽章
     */
    private suspend fun saveBadges(userId: Long, badges: List<OsuUserExtendDTO.Badge>) = withContext(Dispatchers.IO) {
        try {
            val now = System.currentTimeMillis()
            val entities = badges.mapNotNull { badge ->
                if (badge.imageUrl.isBlank()) return@mapNotNull null
                
                val uniqueKey = "${userId}_${badge.imageUrl}"
                val existingEntity = badgeBox.query(
                    OsuBadgeEntity_.uniqueKey.equal(uniqueKey)
                ).build().findFirst()
                
                (existingEntity ?: OsuBadgeEntity()).apply {
                    this.odUserId = userId
                    this.uniqueKey = uniqueKey
                    this.imageUrl = badge.imageUrl
                    this.image2xUrl = badge.image2xUrl
                    this.description = badge.description
                    this.awardedAt = badge.awardedAt
                    this.url = badge.url
                    this.updatedAt = now
                }
            }
            
            if (entities.isNotEmpty()) {
                badgeBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} badges for userId=$userId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save badges: ${e.message}", e)
        }
    }
    
    /**
     * 获取用户徽章
     */
    suspend fun getBadges(userId: Long): List<OsuBadgeEntity> = withContext(Dispatchers.IO) {
        try {
            badgeBox.query(OsuBadgeEntity_.odUserId.equal(userId))
                .orderDesc(OsuBadgeEntity_.awardedAt)
                .build()
                .find()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get badges: ${e.message}", e)
            emptyList()
        }
    }
    
    // ==================== 成就/奖章 ====================
    
    /**
     * 保存成就
     */
    private suspend fun saveMedals(
        userId: Long,
        allMedals: List<OsuMedalItemDTO>,
        userAchievements: List<OsuUserExtendDTO.UserAchievement>
    ) = withContext(Dispatchers.IO) {
        try {
            val now = System.currentTimeMillis()
            
            // 创建成就ID到获得时间的映射
            val achievementMap = userAchievements.associate { 
                it.achievementId.toLongOrNull() to it.achievedAt 
            }
            
            val entities = allMedals.mapNotNull { medal ->
                val achievedAt = achievementMap[medal.id] ?: return@mapNotNull null
                
                val uniqueKey = "${userId}_${medal.id}"
                val existingEntity = medalBox.query(
                    OsuMedalEntity_.uniqueKey.equal(uniqueKey)
                ).build().findFirst()
                
                (existingEntity ?: OsuMedalEntity()).apply {
                    this.odUserId = userId
                    this.odAchievementId = medal.id
                    this.uniqueKey = uniqueKey
                    this.name = medal.name
                    this.slug = medal.slug
                    this.description = medal.description
                    this.mode = medal.mode
                    this.grouping = medal.grouping
                    this.instructions = medal.instructions
                    this.ordering = medal.ordering.toIntOrNull() ?: 0
                    this.iconUrl = medal.iconUrl
                    this.achievedAt = achievedAt
                    this.updatedAt = now
                }
            }
            
            if (entities.isNotEmpty()) {
                medalBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} medals for userId=$userId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save medals: ${e.message}", e)
        }
    }
    
    /**
     * 获取用户成就
     */
    suspend fun getMedals(userId: Long): List<OsuMedalEntity> = withContext(Dispatchers.IO) {
        try {
            medalBox.query(OsuMedalEntity_.odUserId.equal(userId))
                .orderDesc(OsuMedalEntity_.achievedAt)
                .build()
                .find()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get medals: ${e.message}", e)
            emptyList()
        }
    }
    
    /**
     * 按分组获取成就
     */
    suspend fun getMedalsByGrouping(userId: Long): Map<String, List<OsuMedalEntity>> = withContext(Dispatchers.IO) {
        try {
            getMedals(userId).groupBy { it.grouping }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get medals by grouping: ${e.message}", e)
            emptyMap()
        }
    }
    
    // ==================== 清理方法 ====================
    
    /**
     * 清除用户所有数据
     */
    suspend fun clearUserData(userId: Long) = withContext(Dispatchers.IO) {
        try {
            // 删除用户数据
            userBox.query(OsuUserEntity_.odUserId.equal(userId)).build().remove()
            // 删除排名历史
            rankHistoryBox.query(OsuRankHistoryEntity_.odUserId.equal(userId)).build().remove()
            // 删除成绩
            scoreBox.query(OsuScoreEntity_.odUserId.equal(userId)).build().remove()
            // 删除活动
            recentActivityBox.query(OsuRecentActivityEntity_.odUserId.equal(userId)).build().remove()
            // 删除徽章
            badgeBox.query(OsuBadgeEntity_.odUserId.equal(userId)).build().remove()
            // 删除成就
            medalBox.query(OsuMedalEntity_.odUserId.equal(userId)).build().remove()
            
            Log.d(TAG, "All data cleared for userId=$userId")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to clear user data: ${e.message}", e)
        }
    }
    
    /**
     * 清除旧的历史数据（保留最近N天）
     */
    suspend fun cleanupOldHistory(userId: Long, keepDays: Int = 365) = withContext(Dispatchers.IO) {
        try {
            val allHistory = getUserHistory(userId, Int.MAX_VALUE)
            if (allHistory.size > keepDays) {
                val toDelete = allHistory.drop(keepDays)
                toDelete.forEach { userBox.remove(it) }
                Log.d(TAG, "Cleaned up ${toDelete.size} old history records for userId=$userId")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to cleanup old history: ${e.message}", e)
        }
    }
}
