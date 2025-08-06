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

public val Fa.`Turn-up`: ImageVector
    get() {
        if (`_turn-up` != null) {
            return `_turn-up`!!
        }
        `_turn-up` = Builder(name = "Turn-up", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 73.4f)
                curveTo(309.9f, 60.9f, 330.2f, 60.9f, 342.7f, 73.4f)
                lineTo(470.7f, 201.4f)
                curveTo(479.9f, 210.6f, 482.6f, 224.3f, 477.6f, 236.3f)
                curveTo(472.6f, 248.3f, 460.9f, 256.0f, 448.0f, 256.0f)
                lineTo(384.0f, 256.0f)
                lineTo(384.0f, 416.0f)
                curveTo(384.0f, 504.4f, 312.4f, 576.0f, 224.0f, 576.0f)
                lineTo(160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 480.0f)
                curveTo(128.0f, 462.3f, 142.3f, 448.0f, 160.0f, 448.0f)
                lineTo(224.0f, 448.0f)
                curveTo(241.7f, 448.0f, 256.0f, 433.7f, 256.0f, 416.0f)
                lineTo(256.0f, 256.0f)
                lineTo(192.0f, 256.0f)
                curveTo(179.1f, 256.0f, 167.4f, 248.2f, 162.4f, 236.2f)
                curveTo(157.4f, 224.2f, 160.2f, 210.5f, 169.3f, 201.3f)
                lineTo(297.3f, 73.3f)
                close()
            }
        }
        .build()
        return `_turn-up`!!
    }

private var `_turn-up`: ImageVector? = null
