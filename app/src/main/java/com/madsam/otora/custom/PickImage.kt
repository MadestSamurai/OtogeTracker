package com.madsam.otora.custom

import android.content.Context
import android.content.Intent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

/**
 * 项目名: MusiCord
 * 文件名: PickImage
 * 创建者: MadSamurai
 * 创建时间:2023/9/15 11:07
 * 描述: 用于选择图片的ActivityResultContract
 */
class PickImage : ActivityResultContracts.PickVisualMedia() {
    override fun createIntent(context: Context, input: PickVisualMediaRequest): Intent {
        val intent: Intent = super.createIntent(context, input)
        val mimeTypes = arrayOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        return intent
    }
}
