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

public val Fa.`Thumb-tack`: ImageVector
    get() {
        if (`_thumb-tack` != null) {
            return `_thumb-tack`!!
        }
        `_thumb-tack` = Builder(name = "Thumb-tack", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(160.0f, 78.3f, 174.3f, 64.0f, 192.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(465.7f, 64.0f, 480.0f, 78.3f, 480.0f, 96.0f)
                curveTo(480.0f, 113.7f, 465.7f, 128.0f, 448.0f, 128.0f)
                lineTo(418.5f, 128.0f)
                lineTo(428.8f, 262.1f)
                curveTo(465.9f, 283.3f, 494.6f, 318.5f, 507.0f, 361.8f)
                lineTo(510.8f, 375.2f)
                curveTo(513.6f, 384.9f, 511.6f, 395.2f, 505.6f, 403.3f)
                curveTo(499.6f, 411.4f, 490.0f, 416.0f, 480.0f, 416.0f)
                lineTo(160.0f, 416.0f)
                curveTo(150.0f, 416.0f, 140.5f, 411.3f, 134.5f, 403.3f)
                curveTo(128.5f, 395.3f, 126.5f, 384.9f, 129.3f, 375.2f)
                lineTo(133.0f, 361.8f)
                curveTo(145.4f, 318.5f, 174.0f, 283.3f, 211.2f, 262.1f)
                lineTo(221.5f, 128.0f)
                lineTo(192.0f, 128.0f)
                curveTo(174.3f, 128.0f, 160.0f, 113.7f, 160.0f, 96.0f)
                close()
                moveTo(288.0f, 464.0f)
                lineTo(352.0f, 464.0f)
                lineTo(352.0f, 576.0f)
                curveTo(352.0f, 593.7f, 337.7f, 608.0f, 320.0f, 608.0f)
                curveTo(302.3f, 608.0f, 288.0f, 593.7f, 288.0f, 576.0f)
                lineTo(288.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_thumb-tack`!!
    }

private var `_thumb-tack`: ImageVector? = null
