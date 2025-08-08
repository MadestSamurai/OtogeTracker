package com.madsam.otora.core.database

import android.content.Context
import android.util.Log
import com.madsam.otora.data.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.android.Admin

/**
 * ObjectBox数据库管理器
 * 单例模式管理ObjectBox BoxStore实例
 */
object ObjectBoxManager {
    
    private const val TAG = "ObjectBoxManager"
    private var boxStore: BoxStore? = null
    
    /**
     * 初始化ObjectBox数据库
     * @param context Android上下文
     */
    fun init(context: Context) {
        if (boxStore != null) {
            return // 已经初始化
        }
        
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
            
        // Debug模式下启用ObjectBox Admin Browser
        if (com.madsam.otora.BuildConfig.DEBUG) {
            val started = Admin(boxStore).start(context.applicationContext)
            Log.i("ObjectBoxAdmin", "Started: $started")
        }
        
        Log.i(TAG, "ObjectBox initialized successfully")
    }
    
    /**
     * 获取BoxStore实例
     */
    fun getBoxStore(): BoxStore {
        return boxStore ?: throw IllegalStateException("ObjectBox未初始化，请先调用init()")
    }

    /**
     * 关闭数据库连接
     */
    fun close() {
        boxStore?.close()
        boxStore = null
    }
}
