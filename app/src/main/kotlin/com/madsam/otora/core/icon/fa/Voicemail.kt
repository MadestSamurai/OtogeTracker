package com.madsam.otora.core.icon.fa

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Fa

public val Fa.Voicemail: ImageVector
    get() {
        if (_voicemail != null) {
            return _voicemail!!
        }
        _voicemail = Builder(name = "Voicemail", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 224.0f)
                curveTo(188.2f, 224.0f, 224.0f, 259.8f, 224.0f, 304.0f)
                curveTo(224.0f, 348.2f, 188.2f, 384.0f, 144.0f, 384.0f)
                curveTo(99.8f, 384.0f, 64.0f, 348.2f, 64.0f, 304.0f)
                curveTo(64.0f, 259.8f, 99.8f, 224.0f, 144.0f, 224.0f)
                close()
                moveTo(263.8f, 384.0f)
                curveTo(279.1f, 361.1f, 288.0f, 333.6f, 288.0f, 304.0f)
                curveTo(288.0f, 224.5f, 223.5f, 160.0f, 144.0f, 160.0f)
                curveTo(64.5f, 160.0f, 0.0f, 224.5f, 0.0f, 304.0f)
                curveTo(0.0f, 383.5f, 64.5f, 448.0f, 144.0f, 448.0f)
                lineTo(496.0f, 448.0f)
                curveTo(575.5f, 448.0f, 640.0f, 383.5f, 640.0f, 304.0f)
                curveTo(640.0f, 224.5f, 575.5f, 160.0f, 496.0f, 160.0f)
                curveTo(416.5f, 160.0f, 352.0f, 224.5f, 352.0f, 304.0f)
                curveTo(352.0f, 333.6f, 360.9f, 361.1f, 376.2f, 384.0f)
                lineTo(263.7f, 384.0f)
                close()
                moveTo(496.0f, 224.0f)
                curveTo(540.2f, 224.0f, 576.0f, 259.8f, 576.0f, 304.0f)
                curveTo(576.0f, 348.2f, 540.2f, 384.0f, 496.0f, 384.0f)
                curveTo(451.8f, 384.0f, 416.0f, 348.2f, 416.0f, 304.0f)
                curveTo(416.0f, 259.8f, 451.8f, 224.0f, 496.0f, 224.0f)
                close()
            }
        }
        .build()
        return _voicemail!!
    }

private var _voicemail: ImageVector? = null
