package com.madsam.otora.entity

import io.realm.annotations.RealmModule

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.RealmModules
 * 创建者: MadSamurai
 * 创建时间: 2024/12/7
 * 描述: TODO
 */
@RealmModule(classes = [BofEntryEntity::class, BofPointEntity::class, BofTeamEntity::class, BofTeamPointEntity::class])
class BofRealmModule

@RealmModule(classes = [ChuniSongsEntity::class, ChuniSheetsEntity::class])
class ChuniRealmModule