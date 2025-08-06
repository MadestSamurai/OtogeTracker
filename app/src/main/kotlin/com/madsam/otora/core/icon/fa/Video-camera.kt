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

public val Fa.`Video-camera`: ImageVector
    get() {
        if (`_video-camera` != null) {
            return `_video-camera`!!
        }
        `_video-camera` = Builder(name = "Video-camera", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(384.0f, 512.0f)
                curveTo(419.3f, 512.0f, 448.0f, 483.3f, 448.0f, 448.0f)
                lineTo(448.0f, 192.0f)
                curveTo(448.0f, 156.7f, 419.3f, 128.0f, 384.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(496.0f, 400.0f)
                lineTo(569.5f, 458.8f)
                curveTo(573.7f, 462.2f, 578.9f, 464.0f, 584.3f, 464.0f)
                curveTo(597.4f, 464.0f, 608.0f, 453.4f, 608.0f, 440.3f)
                lineTo(608.0f, 199.7f)
                curveTo(608.0f, 186.6f, 597.4f, 176.0f, 584.3f, 176.0f)
                curveTo(578.9f, 176.0f, 573.7f, 177.8f, 569.5f, 181.2f)
                lineTo(496.0f, 240.0f)
                lineTo(496.0f, 400.0f)
                close()
            }
        }
        .build()
        return `_video-camera`!!
    }

private var `_video-camera`: ImageVector? = null
