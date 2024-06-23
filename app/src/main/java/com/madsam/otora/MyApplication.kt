package com.madsam.otora

import android.app.Application

/**
 * 项目名: MusiCord
 * 文件名: MyApplication
 * 创建者: MadSamurai
 * 创建时间:2023/1/24 17:42
 * 描述: 用于启动MediaControllerService的应用块
 */
class MyApplication : Application() {
    companion object {
        const val MY_TAG = "Otoge_log"
    }

//    fun startService() {
//        Log.i(MY_TAG, "MyApplication startService")
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            //8.0以上系统启动为前台服务, 否则在后台, 测试中发现过几分钟后MediaController监听不到音乐信息
//            startForegroundService(Intent(this, MediaControllerService::class.java))
//        } else {
//            startService(Intent(this, MediaControllerService::class.java))
//        }
//    }
}