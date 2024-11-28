package com.madsam.otora.database

import io.realm.DynamicRealm
import io.realm.RealmMigration

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.database.DefaultRealmMigration
 * 创建者: MadSamurai
 * 创建时间: 2024/11/28
 * 描述: TODO
 */
class MyRealmMigration : RealmMigration {
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        val schema = realm.schema

        // Example migration logic
        var version = oldVersion
        if (version == 1L) {
            schema.get("ChuniSheetsEntity")
                ?.addField("newField", String::class.java)
            version++
        }
    }
}