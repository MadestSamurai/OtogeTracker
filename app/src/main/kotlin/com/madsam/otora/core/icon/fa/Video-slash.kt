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

public val Fa.`Video-slash`: ImageVector
    get() {
        if (`_video-slash` != null) {
            return `_video-slash`!!
        }
        `_video-slash` = Builder(name = "Video-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(447.9f, 414.2f)
                lineTo(447.9f, 192.0f)
                curveTo(447.9f, 156.7f, 419.2f, 128.0f, 383.9f, 128.0f)
                lineTo(161.8f, 128.0f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(384.0f, 512.0f)
                curveTo(391.8f, 512.0f, 399.3f, 510.6f, 406.2f, 508.0f)
                lineTo(68.0f, 169.8f)
                curveTo(65.4f, 176.7f, 64.0f, 184.2f, 64.0f, 192.0f)
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
        return `_video-slash`!!
    }

private var `_video-slash`: ImageVector? = null
