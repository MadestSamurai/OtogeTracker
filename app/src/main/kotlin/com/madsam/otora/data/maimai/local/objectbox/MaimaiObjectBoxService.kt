package com.madsam.otora.data.maimai.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.maimai.local.model.*
import com.madsam.otora.data.maimai.remote.model.*
import io.objectbox.Box
import io.objectbox.kotlin.boxFor

/**
 * Maimai ObjectBox 数据库操作服务
 */
internal class MaimaiObjectBoxService {
    companion object {
        private const val TAG = "MaimaiObjectBoxService"
    }
    
    private val boxStore by lazy { ObjectBoxManager.getBoxStore() }
    
    private val userBox: Box<MaimaiUserEntity> by lazy {
        boxStore.boxFor()
    }
    
    private val scoreBox: Box<MaimaiScoreEntity> by lazy {
        boxStore.boxFor()
    }
    
    private val recordBox: Box<MaimaiPlayRecordEntity> by lazy {
        boxStore.boxFor()
    }
    
    private val collectionBox: Box<MaimaiCollectionEntity> by lazy {
        boxStore.boxFor()
    }
    
    /**
     * 保存用户数据
     */
    fun saveUserData(userData: MaimaiUserDTO) {
        try {
            // 先查询是否已存在用户数据
            val existingUser = userBox.query().build().findFirst()
            val userId = existingUser?.id ?: 0L // 如果已存在则使用现有ID，否则用0让ObjectBox自动分配
            
            val entity = MaimaiUserEntity(
                id = userId, // 使用现有ID或0
                userName = userData.userName,
                rating = userData.rating,
                maxRating = userData.maxRating,
                title = userData.title,
                titlePlate = userData.titlePlate,
                trophyName = userData.trophyName,
                iconUrl = userData.iconUrl,
                plateUrl = userData.plateUrl,
                frameUrl = userData.frameUrl,
                playCount = userData.playCount,
                totalScore = userData.totalScore,
                starCount = userData.starCount,
                syncedAt = System.currentTimeMillis()
            )
            userBox.put(entity)
            Log.d(TAG, "User data saved successfully with ID: $userId")
        } catch (e: Exception) {
            Log.e(TAG, "Error saving user data", e)
        }
    }
    
    /**
     * 获取用户数据
     */
    fun getUserData(): MaimaiUserEntity? {
        return try {
            // 查询第一个（唯一的）用户数据
            userBox.query().build().findFirst()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting user data", e)
            null
        }
    }
    
    /**
     * 保存 Rating 数据（BEST 或 NEW）
     */
    fun saveRatingData(scores: List<MaimaiScoreDTO>, ratingType: String) {
        try {
            // 删除旧的同类型数据
            val oldScores = scoreBox.query(MaimaiScoreEntity_.ratingType.equal(ratingType)).build().find()
            scoreBox.remove(oldScores)
            
            // 保存新数据
            val entities = scores.map { score ->
                MaimaiScoreEntity(
                    songId = score.id,
                    title = score.title,
                    difficulty = score.difficulty,
                    level = score.level,
                    score = score.score,
                    rank = score.rank,
                    comboStatus = score.comboStatus,
                    syncStatus = score.syncStatus,
                    deluxscore = score.deluxscore,
                    genre = score.genre,
                    coverUrl = score.coverUrl,
                    ratingType = ratingType,
                    syncedAt = System.currentTimeMillis()
                )
            }
            scoreBox.put(entities)
            Log.d(TAG, "Saved ${entities.size} $ratingType rating scores")
        } catch (e: Exception) {
            Log.e(TAG, "Error saving rating data", e)
        }
    }
    
    /**
     * 获取 Rating 数据
     */
    fun getRatingData(ratingType: String): List<MaimaiScoreEntity> {
        return try {
            scoreBox.query(MaimaiScoreEntity_.ratingType.equal(ratingType)).build().find()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting rating data", e)
            emptyList()
        }
    }
    
    /**
     * 保存游戏记录统计数据
     */
    fun savePlayRecordData(records: List<MaimaiPlayRecordDTO>) {
        try {
            // 清空旧数据
            recordBox.removeAll()
            
            // 保存新数据
            val entities = records.map { record ->
                MaimaiPlayRecordEntity(
                    difficulty = record.difficulty,
                    clearCount = record.clearCount,
                    clearTotal = record.clearTotal,
                    fcCount = record.fcCount,
                    fcTotal = record.fcTotal,
                    fcpCount = record.fcpCount,
                    fcpTotal = record.fcpTotal,
                    apCount = record.apCount,
                    apTotal = record.apTotal,
                    appCount = record.appCount,
                    appTotal = record.appTotal,
                    fsCount = record.fsCount,
                    fsTotal = record.fsTotal,
                    fspCount = record.fspCount,
                    fspTotal = record.fspTotal,
                    fdxCount = record.fdxCount,
                    fdxTotal = record.fdxTotal,
                    fdxpCount = record.fdxpCount,
                    fdxpTotal = record.fdxpTotal,
                    syncedAt = System.currentTimeMillis()
                )
            }
            recordBox.put(entities)
            Log.d(TAG, "Saved ${entities.size} play records")
        } catch (e: Exception) {
            Log.e(TAG, "Error saving play record data", e)
        }
    }
    
    /**
     * 获取游戏记录统计数据
     */
    fun getPlayRecordData(): List<MaimaiPlayRecordEntity> {
        return try {
            recordBox.all
        } catch (e: Exception) {
            Log.e(TAG, "Error getting play record data", e)
            emptyList()
        }
    }
    
    /**
     * 保存收藏品数据
     */
    fun saveCollectionData(collection: MaimaiCollectionDTO) {
        try {
            val entities = mutableListOf<MaimaiCollectionEntity>()
            
            // 头像
            entities.addAll(collection.icons.map { icon ->
                MaimaiCollectionEntity(
                    itemId = icon.id,
                    name = icon.name,
                    category = MaimaiCollectionEntity.CATEGORY_ICON,
                    imageUrl = icon.imageUrl,
                    isOwned = icon.isOwned,
                    syncedAt = System.currentTimeMillis()
                )
            })
            
            // 背景板
            entities.addAll(collection.plates.map { plate ->
                MaimaiCollectionEntity(
                    itemId = plate.id,
                    name = plate.name,
                    category = MaimaiCollectionEntity.CATEGORY_PLATE,
                    imageUrl = plate.imageUrl,
                    isOwned = plate.isOwned,
                    syncedAt = System.currentTimeMillis()
                )
            })
            
            // 边框
            entities.addAll(collection.frames.map { frame ->
                MaimaiCollectionEntity(
                    itemId = frame.id,
                    name = frame.name,
                    category = MaimaiCollectionEntity.CATEGORY_FRAME,
                    imageUrl = frame.imageUrl,
                    isOwned = frame.isOwned,
                    syncedAt = System.currentTimeMillis()
                )
            })
            
            // 姓名框
            entities.addAll(collection.trophies.map { trophy ->
                MaimaiCollectionEntity(
                    itemId = trophy.id,
                    name = trophy.name,
                    category = MaimaiCollectionEntity.CATEGORY_TROPHY,
                    imageUrl = "",
                    isOwned = trophy.isOwned,
                    syncedAt = System.currentTimeMillis()
                )
            })
            
            // 清空旧数据并保存
            collectionBox.removeAll()
            collectionBox.put(entities)
            Log.d(TAG, "Saved ${entities.size} collection items")
        } catch (e: Exception) {
            Log.e(TAG, "Error saving collection data", e)
        }
    }
    
    /**
     * 获取收藏品数据
     */
    fun getCollectionData(category: String): List<MaimaiCollectionEntity> {
        return try {
            collectionBox.query(MaimaiCollectionEntity_.category.equal(category)).build().find()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting collection data", e)
            emptyList()
        }
    }
}
