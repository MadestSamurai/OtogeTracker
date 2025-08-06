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

public val Fa.`Mortar-pestle`: ImageVector
    get() {
        if (`_mortar-pestle` != null) {
            return `_mortar-pestle`!!
        }
        `_mortar-pestle` = Builder(name = "Mortar-pestle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(568.3f, 75.1f)
                curveTo(557.3f, 62.4f, 538.5f, 60.3f, 525.0f, 70.2f)
                lineTo(316.3f, 224.0f)
                lineTo(461.3f, 224.0f)
                lineTo(566.6f, 118.6f)
                curveTo(578.4f, 106.8f, 579.2f, 87.8f, 568.2f, 75.1f)
                close()
                moveTo(96.0f, 256.0f)
                curveTo(78.3f, 256.0f, 64.0f, 270.3f, 64.0f, 288.0f)
                curveTo(64.0f, 305.7f, 78.3f, 320.0f, 96.0f, 320.0f)
                curveTo(96.0f, 402.5f, 139.4f, 467.7f, 219.9f, 496.2f)
                curveTo(208.8f, 510.1f, 200.5f, 526.5f, 196.0f, 544.3f)
                curveTo(191.6f, 561.4f, 206.4f, 576.0f, 224.1f, 576.0f)
                lineTo(416.1f, 576.0f)
                curveTo(433.8f, 576.0f, 448.5f, 561.4f, 444.2f, 544.3f)
                curveTo(439.7f, 526.5f, 431.4f, 510.2f, 420.3f, 496.2f)
                curveTo(500.8f, 467.6f, 544.2f, 402.5f, 544.2f, 320.0f)
                curveTo(561.9f, 320.0f, 576.2f, 305.7f, 576.2f, 288.0f)
                curveTo(576.2f, 270.3f, 561.9f, 256.0f, 544.2f, 256.0f)
                lineTo(96.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_mortar-pestle`!!
    }

private var `_mortar-pestle`: ImageVector? = null
