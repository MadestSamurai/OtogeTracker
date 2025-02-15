package com.madsam.otora.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.provider.MediaStore
import java.io.OutputStream

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.utils.ImageUtils
 * 创建者: MadSamurai
 * 创建时间: 2025/1/4
 * 描述: Image工具类
 */
object ImageUtils {
    private fun resizeBitmapIfNeeded(bitmap: Bitmap, maxHeight: Int): Bitmap {
        return if (bitmap.height > maxHeight) {
            val aspectRatio = bitmap.width.toFloat() / bitmap.height.toFloat()
            val newWidth = (maxHeight * aspectRatio).toInt()
            Bitmap.createScaledBitmap(bitmap, newWidth, maxHeight, true)
        } else {
            bitmap
        }
    }

    fun saveBitmapToGallery(context: Context, bitmap: Bitmap, title: String, description: String) {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "$title.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.TITLE, title)
            put(MediaStore.Images.Media.DESCRIPTION, description)
            put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
        }
        val resizedBitmap = resizeBitmapIfNeeded(bitmap, 32000)
        val uri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        uri?.let {
            val outputStream: OutputStream? = context.contentResolver.openOutputStream(it)
            outputStream?.use { stream ->
                resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 95, stream)
            }
        }
    }
}