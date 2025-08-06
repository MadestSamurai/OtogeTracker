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

public val Fa.`Volume-low`: ImageVector
    get() {
        if (`_volume-low` != null) {
            return `_volume-low`!!
        }
        `_volume-low` = Builder(name = "Volume-low", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 416.0f)
                lineTo(192.0f, 416.0f)
                lineTo(326.1f, 535.2f)
                curveTo(332.5f, 540.9f, 340.7f, 544.0f, 349.2f, 544.0f)
                curveTo(368.4f, 544.0f, 384.0f, 528.4f, 384.0f, 509.2f)
                lineTo(384.0f, 130.8f)
                curveTo(384.0f, 111.6f, 368.4f, 96.0f, 349.2f, 96.0f)
                curveTo(340.7f, 96.0f, 332.5f, 99.1f, 326.1f, 104.8f)
                lineTo(192.0f, 224.0f)
                lineTo(144.0f, 224.0f)
                curveTo(117.5f, 224.0f, 96.0f, 245.5f, 96.0f, 272.0f)
                lineTo(96.0f, 368.0f)
                curveTo(96.0f, 394.5f, 117.5f, 416.0f, 144.0f, 416.0f)
                close()
                moveTo(476.6f, 245.5f)
                curveTo(466.3f, 237.1f, 451.2f, 238.7f, 442.8f, 249.0f)
                curveTo(434.4f, 259.3f, 436.0f, 274.4f, 446.3f, 282.8f)
                curveTo(457.1f, 291.6f, 464.0f, 305.0f, 464.0f, 320.0f)
                curveTo(464.0f, 335.0f, 457.1f, 348.4f, 446.3f, 357.3f)
                curveTo(436.0f, 365.7f, 434.5f, 380.8f, 442.8f, 391.1f)
                curveTo(451.1f, 401.4f, 466.3f, 402.9f, 476.6f, 394.6f)
                curveTo(498.1f, 376.9f, 512.0f, 350.1f, 512.0f, 320.0f)
                curveTo(512.0f, 289.9f, 498.1f, 263.1f, 476.5f, 245.5f)
                close()
            }
        }
        .build()
        return `_volume-low`!!
    }

private var `_volume-low`: ImageVector? = null
