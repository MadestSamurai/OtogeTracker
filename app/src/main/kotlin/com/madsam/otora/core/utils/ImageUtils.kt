package com.madsam.otora.core.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.provider.MediaStore
import java.io.OutputStream
import androidx.core.graphics.scale

object ImageUtils {
    private const val MAX_BITMAP_HEIGHT = 32000
    private fun resizeBitmapToMaxHeight(bitmap: Bitmap): Bitmap {
        return if (bitmap.height > MAX_BITMAP_HEIGHT) {
            val aspectRatio = bitmap.width.toFloat() / bitmap.height.toFloat()
            val newWidth = (MAX_BITMAP_HEIGHT * aspectRatio).toInt()
            bitmap.scale(newWidth, MAX_BITMAP_HEIGHT)
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
        val resizedBitmap = resizeBitmapToMaxHeight(bitmap)
        val uri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
        uri?.let {
            val outputStream: OutputStream? = context.contentResolver.openOutputStream(it)
            outputStream?.use { stream ->
                resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 95, stream)
            }
        }
    }

    /**
     * 拼接多张bitmap为一张大图，如果总高度超过maxHeight（默认30000），则先等比缩放再拼接。
     * 这样可以避免超过Android Bitmap的最大尺寸限制（32767px）。
     */
    fun combineBitmaps(bitmaps: List<Bitmap>, maxHeight: Int = 30000): Bitmap {
        if (bitmaps.isEmpty()) throw IllegalArgumentException("Bitmap list is empty")
        val width = bitmaps[0].width
        
        // 1. 先计算总高度
        val totalHeight = bitmaps.sumOf { it.height }
        
        // 2. 如果总高度超过限制，计算缩放比例
        val scale = if (totalHeight > maxHeight) {
            maxHeight.toFloat() / totalHeight.toFloat()
        } else {
            1.0f
        }
        
        // 3. 计算缩放后的尺寸
        val finalWidth = (width * scale).toInt()
        val finalHeight = if (totalHeight > maxHeight) maxHeight else totalHeight
        
        // 4. 创建最终的bitmap
        val result = Bitmap.createBitmap(finalWidth, finalHeight, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(result)
        
        // 5. 逐个缩放并绘制每个bitmap
        var y = 0
        for (bmp in bitmaps) {
            if (scale < 1.0f) {
                // 需要缩放
                val scaledHeight = (bmp.height * scale).toInt()
                val scaledWidth = (bmp.width * scale).toInt()
                val scaledBmp = bmp.scale(scaledWidth, scaledHeight)
                canvas.drawBitmap(scaledBmp, 0f, y.toFloat(), null)
                scaledBmp.recycle()
                y += scaledHeight
            } else {
                // 不需要缩放，直接绘制
                canvas.drawBitmap(bmp, 0f, y.toFloat(), null)
                y += bmp.height
            }
        }
        
        return result
    }
}