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

public val Fa.`Temperature-low`: ImageVector
    get() {
        if (`_temperature-low` != null) {
            return `_temperature-low`!!
        }
        `_temperature-low` = Builder(name = "Temperature-low", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 160.0f)
                curveTo(160.0f, 107.0f, 203.0f, 64.0f, 256.0f, 64.0f)
                curveTo(309.0f, 64.0f, 352.0f, 107.0f, 352.0f, 160.0f)
                lineTo(352.0f, 324.7f)
                curveTo(381.5f, 351.1f, 400.0f, 389.4f, 400.0f, 432.0f)
                curveTo(400.0f, 511.5f, 335.5f, 576.0f, 256.0f, 576.0f)
                curveTo(176.5f, 576.0f, 112.0f, 511.5f, 112.0f, 432.0f)
                curveTo(112.0f, 389.4f, 130.5f, 351.0f, 160.0f, 324.7f)
                lineTo(160.0f, 160.0f)
                close()
                moveTo(256.0f, 496.0f)
                curveTo(291.3f, 496.0f, 320.0f, 467.3f, 320.0f, 432.0f)
                curveTo(320.0f, 405.1f, 303.5f, 382.1f, 280.0f, 372.7f)
                lineTo(280.0f, 344.0f)
                curveTo(280.0f, 330.7f, 269.3f, 320.0f, 256.0f, 320.0f)
                curveTo(242.7f, 320.0f, 232.0f, 330.7f, 232.0f, 344.0f)
                lineTo(232.0f, 372.7f)
                curveTo(208.5f, 382.2f, 192.0f, 405.2f, 192.0f, 432.0f)
                curveTo(192.0f, 467.3f, 220.7f, 496.0f, 256.0f, 496.0f)
                close()
                moveTo(528.0f, 144.0f)
                curveTo(528.0f, 126.3f, 513.7f, 112.0f, 496.0f, 112.0f)
                curveTo(478.3f, 112.0f, 464.0f, 126.3f, 464.0f, 144.0f)
                curveTo(464.0f, 161.7f, 478.3f, 176.0f, 496.0f, 176.0f)
                curveTo(513.7f, 176.0f, 528.0f, 161.7f, 528.0f, 144.0f)
                close()
                moveTo(416.0f, 144.0f)
                curveTo(416.0f, 99.8f, 451.8f, 64.0f, 496.0f, 64.0f)
                curveTo(540.2f, 64.0f, 576.0f, 99.8f, 576.0f, 144.0f)
                curveTo(576.0f, 188.2f, 540.2f, 224.0f, 496.0f, 224.0f)
                curveTo(451.8f, 224.0f, 416.0f, 188.2f, 416.0f, 144.0f)
                close()
            }
        }
        .build()
        return `_temperature-low`!!
    }

private var `_temperature-low`: ImageVector? = null
