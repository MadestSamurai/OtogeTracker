package com.madsam.otora

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        applicationInfo.labelRes = 0
        applicationInfo.nonLocalizedLabel = "OtogeTracker"
    }
}