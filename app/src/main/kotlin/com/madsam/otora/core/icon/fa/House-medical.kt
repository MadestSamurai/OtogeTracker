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

public val Fa.`House-medical`: ImageVector
    get() {
        if (`_house-medical` != null) {
            return `_house-medical`!!
        }
        `_house-medical` = Builder(name = "House-medical", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(341.8f, 72.6f)
                curveTo(329.5f, 61.2f, 310.5f, 61.2f, 298.3f, 72.6f)
                lineTo(74.3f, 280.6f)
                curveTo(64.7f, 289.6f, 61.5f, 303.5f, 66.3f, 315.7f)
                curveTo(71.1f, 327.9f, 82.8f, 336.0f, 96.0f, 336.0f)
                lineTo(112.0f, 336.0f)
                lineTo(112.0f, 512.0f)
                curveTo(112.0f, 547.3f, 140.7f, 576.0f, 176.0f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(499.3f, 576.0f, 528.0f, 547.3f, 528.0f, 512.0f)
                lineTo(528.0f, 336.0f)
                lineTo(544.0f, 336.0f)
                curveTo(557.2f, 336.0f, 569.0f, 327.9f, 573.8f, 315.7f)
                curveTo(578.6f, 303.5f, 575.4f, 289.5f, 565.8f, 280.6f)
                lineTo(341.8f, 72.6f)
                close()
                moveTo(288.0f, 312.0f)
                curveTo(288.0f, 303.2f, 295.2f, 296.0f, 304.0f, 296.0f)
                lineTo(336.0f, 296.0f)
                curveTo(344.8f, 296.0f, 352.0f, 303.2f, 352.0f, 312.0f)
                lineTo(352.0f, 352.0f)
                lineTo(392.0f, 352.0f)
                curveTo(400.8f, 352.0f, 408.0f, 359.2f, 408.0f, 368.0f)
                lineTo(408.0f, 400.0f)
                curveTo(408.0f, 408.8f, 400.8f, 416.0f, 392.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                lineTo(352.0f, 456.0f)
                curveTo(352.0f, 464.8f, 344.8f, 472.0f, 336.0f, 472.0f)
                lineTo(304.0f, 472.0f)
                curveTo(295.2f, 472.0f, 288.0f, 464.8f, 288.0f, 456.0f)
                lineTo(288.0f, 416.0f)
                lineTo(248.0f, 416.0f)
                curveTo(239.2f, 416.0f, 232.0f, 408.8f, 232.0f, 400.0f)
                lineTo(232.0f, 368.0f)
                curveTo(232.0f, 359.2f, 239.2f, 352.0f, 248.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 312.0f)
                close()
            }
        }
        .build()
        return `_house-medical`!!
    }

private var `_house-medical`: ImageVector? = null
