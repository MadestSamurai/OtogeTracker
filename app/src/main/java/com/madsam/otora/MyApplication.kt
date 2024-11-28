package com.madsam.otora

import android.app.Application
import com.madsam.otora.entity.chunithm.ChuniRealmModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * 项目名: MusiCord
 * 文件名: MyApplication
 * 创建者: MadSamurai
 * 创建时间:2023/1/24 17:42
 * 描述: 用于启动MediaControllerService的应用块
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        applicationInfo.labelRes = 0
        applicationInfo.nonLocalizedLabel = "OtogeTracker"
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("otogetracker.realm")
            .schemaVersion(1)
            .modules(ChuniRealmModule())
            .build()
        Realm.setDefaultConfiguration(config)
    }
}