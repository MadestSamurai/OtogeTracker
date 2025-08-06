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

public val Fa.`Compress-alt`: ImageVector
    get() {
        if (`_compress-alt` != null) {
            return `_compress-alt`!!
        }
        `_compress-alt` = Builder(name = "Compress-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(503.5f, 71.0f)
                curveTo(512.9f, 61.6f, 528.1f, 61.6f, 537.4f, 71.0f)
                lineTo(569.4f, 103.0f)
                curveTo(578.8f, 112.4f, 578.8f, 127.6f, 569.4f, 136.9f)
                lineTo(482.4f, 223.9f)
                lineTo(521.4f, 262.9f)
                curveTo(528.3f, 269.8f, 530.3f, 280.1f, 526.6f, 289.1f)
                curveTo(522.9f, 298.1f, 514.2f, 304.0f, 504.5f, 304.0f)
                lineTo(360.5f, 304.0f)
                curveTo(347.2f, 304.0f, 336.5f, 293.3f, 336.5f, 280.0f)
                lineTo(336.5f, 136.0f)
                curveTo(336.5f, 126.3f, 342.3f, 117.5f, 351.3f, 113.8f)
                curveTo(360.3f, 110.1f, 370.6f, 112.1f, 377.5f, 119.0f)
                lineTo(416.5f, 158.0f)
                lineTo(503.5f, 71.0f)
                close()
                moveTo(136.5f, 336.0f)
                lineTo(280.5f, 336.0f)
                curveTo(293.8f, 336.0f, 304.5f, 346.7f, 304.5f, 360.0f)
                lineTo(304.5f, 504.0f)
                curveTo(304.5f, 513.7f, 298.7f, 522.5f, 289.7f, 526.2f)
                curveTo(280.7f, 529.9f, 270.4f, 527.9f, 263.5f, 521.0f)
                lineTo(224.5f, 482.0f)
                lineTo(137.5f, 569.0f)
                curveTo(128.1f, 578.4f, 112.9f, 578.4f, 103.6f, 569.0f)
                lineTo(71.6f, 537.0f)
                curveTo(62.2f, 527.6f, 62.2f, 512.4f, 71.6f, 503.1f)
                lineTo(158.6f, 416.1f)
                lineTo(119.6f, 377.1f)
                curveTo(112.7f, 370.2f, 110.7f, 359.9f, 114.4f, 350.9f)
                curveTo(118.1f, 341.9f, 126.8f, 336.0f, 136.5f, 336.0f)
                close()
            }
        }
        .build()
        return `_compress-alt`!!
    }

private var `_compress-alt`: ImageVector? = null
