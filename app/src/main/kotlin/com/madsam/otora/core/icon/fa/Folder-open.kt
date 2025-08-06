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

public val Fa.`Folder-open`: ImageVector
    get() {
        if (`_folder-open` != null) {
            return `_folder-open`!!
        }
        `_folder-open` = Builder(name = "Folder-open", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(88.0f, 289.6f)
                lineTo(64.4f, 360.2f)
                lineTo(64.4f, 160.0f)
                curveTo(64.4f, 124.7f, 93.1f, 96.0f, 128.4f, 96.0f)
                lineTo(267.1f, 96.0f)
                curveTo(280.9f, 96.0f, 294.4f, 100.5f, 305.5f, 108.8f)
                lineTo(343.9f, 137.6f)
                curveTo(349.4f, 141.8f, 356.2f, 144.0f, 363.1f, 144.0f)
                lineTo(480.4f, 144.0f)
                curveTo(515.7f, 144.0f, 544.4f, 172.7f, 544.4f, 208.0f)
                lineTo(544.4f, 224.0f)
                lineTo(179.0f, 224.0f)
                curveTo(137.7f, 224.0f, 101.0f, 250.4f, 87.9f, 289.6f)
                close()
                moveTo(509.8f, 512.0f)
                lineTo(131.0f, 512.0f)
                curveTo(98.2f, 512.0f, 75.1f, 479.9f, 85.5f, 448.8f)
                lineTo(133.5f, 304.8f)
                curveTo(140.0f, 285.2f, 158.4f, 272.0f, 179.0f, 272.0f)
                lineTo(557.8f, 272.0f)
                curveTo(590.6f, 272.0f, 613.7f, 304.1f, 603.3f, 335.2f)
                lineTo(555.3f, 479.2f)
                curveTo(548.8f, 498.8f, 530.4f, 512.0f, 509.8f, 512.0f)
                close()
            }
        }
        .build()
        return `_folder-open`!!
    }

private var `_folder-open`: ImageVector? = null
