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

public val Fa.`Landmark-dome`: ImageVector
    get() {
        if (`_landmark-dome` != null) {
            return `_landmark-dome`!!
        }
        `_landmark-dome` = Builder(name = "Landmark-dome", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                curveTo(288.0f, 96.9f, 288.0f, 97.8f, 288.1f, 98.6f)
                curveTo(207.6f, 112.0f, 144.1f, 175.5f, 130.6f, 256.0f)
                lineTo(128.0f, 256.0f)
                curveTo(110.3f, 256.0f, 96.0f, 270.3f, 96.0f, 288.0f)
                curveTo(96.0f, 305.7f, 110.3f, 320.0f, 128.0f, 320.0f)
                lineTo(128.0f, 480.0f)
                lineTo(76.8f, 518.4f)
                curveTo(68.7f, 524.4f, 64.0f, 533.9f, 64.0f, 544.0f)
                curveTo(64.0f, 561.7f, 78.3f, 576.0f, 96.0f, 576.0f)
                lineTo(544.0f, 576.0f)
                curveTo(561.7f, 576.0f, 576.0f, 561.7f, 576.0f, 544.0f)
                curveTo(576.0f, 533.9f, 571.3f, 524.4f, 563.2f, 518.4f)
                lineTo(512.0f, 480.0f)
                lineTo(512.0f, 320.0f)
                curveTo(529.7f, 320.0f, 544.0f, 305.7f, 544.0f, 288.0f)
                curveTo(544.0f, 270.3f, 529.7f, 256.0f, 512.0f, 256.0f)
                lineTo(509.3f, 256.0f)
                curveTo(495.8f, 175.6f, 432.3f, 112.1f, 351.8f, 98.6f)
                curveTo(351.9f, 97.7f, 351.9f, 96.9f, 351.9f, 96.0f)
                curveTo(351.9f, 78.3f, 337.6f, 64.0f, 319.9f, 64.0f)
                close()
                moveTo(400.0f, 320.0f)
                lineTo(464.0f, 320.0f)
                lineTo(464.0f, 480.0f)
                lineTo(400.0f, 480.0f)
                lineTo(400.0f, 320.0f)
                close()
                moveTo(288.0f, 480.0f)
                lineTo(288.0f, 320.0f)
                lineTo(352.0f, 320.0f)
                lineTo(352.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                close()
                moveTo(176.0f, 320.0f)
                lineTo(240.0f, 320.0f)
                lineTo(240.0f, 480.0f)
                lineTo(176.0f, 480.0f)
                lineTo(176.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_landmark-dome`!!
    }

private var `_landmark-dome`: ImageVector? = null
