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

public val Fa.`Turkish-lira`: ImageVector
    get() {
        if (`_turkish-lira` != null) {
            return `_turkish-lira`!!
        }
        `_turkish-lira` = Builder(name = "Turkish-lira", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 96.0f)
                curveTo(273.7f, 96.0f, 288.0f, 110.3f, 288.0f, 128.0f)
                lineTo(288.0f, 171.6f)
                lineTo(409.4f, 136.9f)
                curveTo(422.1f, 133.3f, 435.4f, 140.6f, 439.1f, 153.4f)
                curveTo(442.8f, 166.2f, 435.4f, 179.4f, 422.6f, 183.1f)
                lineTo(288.0f, 221.6f)
                lineTo(288.0f, 267.7f)
                lineTo(409.4f, 233.0f)
                curveTo(422.1f, 229.4f, 435.4f, 236.7f, 439.1f, 249.5f)
                curveTo(442.8f, 262.3f, 435.4f, 275.5f, 422.6f, 279.2f)
                lineTo(288.0f, 317.7f)
                lineTo(288.0f, 480.2f)
                lineTo(360.0f, 480.2f)
                curveTo(413.0f, 480.2f, 456.0f, 437.2f, 456.0f, 384.2f)
                curveTo(456.0f, 366.5f, 470.3f, 352.2f, 488.0f, 352.2f)
                curveTo(505.7f, 352.2f, 520.0f, 366.5f, 520.0f, 384.2f)
                curveTo(520.0f, 472.6f, 448.4f, 544.2f, 360.0f, 544.2f)
                lineTo(256.0f, 544.2f)
                curveTo(238.3f, 544.2f, 224.0f, 529.9f, 224.0f, 512.2f)
                lineTo(224.0f, 336.0f)
                lineTo(198.6f, 343.3f)
                curveTo(185.9f, 346.9f, 172.6f, 339.6f, 168.9f, 326.8f)
                curveTo(165.2f, 314.0f, 172.6f, 300.8f, 185.4f, 297.1f)
                lineTo(224.0f, 286.1f)
                lineTo(224.0f, 240.0f)
                lineTo(198.6f, 247.3f)
                curveTo(185.9f, 250.9f, 172.6f, 243.6f, 168.9f, 230.8f)
                curveTo(165.2f, 218.0f, 172.6f, 204.8f, 185.4f, 201.1f)
                lineTo(224.0f, 190.1f)
                lineTo(224.0f, 128.2f)
                curveTo(224.0f, 110.5f, 238.3f, 96.2f, 256.0f, 96.2f)
                close()
            }
        }
        .build()
        return `_turkish-lira`!!
    }

private var `_turkish-lira`: ImageVector? = null
