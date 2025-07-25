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
}