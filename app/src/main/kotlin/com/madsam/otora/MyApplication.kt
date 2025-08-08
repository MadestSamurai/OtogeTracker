package com.madsam.otora

import android.app.Application
import com.madsam.otora.data.chunithm.local.objectbox.ObjectBoxManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        applicationInfo.labelRes = 0
        applicationInfo.nonLocalizedLabel = "OtogeTracker"
        
        // 初始化ObjectBox数据库
        ObjectBoxManager.init(this)
    }
}