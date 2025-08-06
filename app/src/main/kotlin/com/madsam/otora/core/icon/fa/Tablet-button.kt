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

public val Fa.`Tablet-button`: ImageVector
    get() {
        if (`_tablet-button` != null) {
            return `_tablet-button`!!
        }
        `_tablet-button` = Builder(name = "Tablet-button", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(124.7f, 64.0f, 96.0f, 92.7f, 96.0f, 128.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 547.3f, 124.7f, 576.0f, 160.0f, 576.0f)
                lineTo(480.0f, 576.0f)
                curveTo(515.3f, 576.0f, 544.0f, 547.3f, 544.0f, 512.0f)
                lineTo(544.0f, 128.0f)
                curveTo(544.0f, 92.7f, 515.3f, 64.0f, 480.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(337.7f, 464.0f, 352.0f, 478.3f, 352.0f, 496.0f)
                curveTo(352.0f, 513.7f, 337.7f, 528.0f, 320.0f, 528.0f)
                curveTo(302.3f, 528.0f, 288.0f, 513.7f, 288.0f, 496.0f)
                curveTo(288.0f, 478.3f, 302.3f, 464.0f, 320.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_tablet-button`!!
    }

private var `_tablet-button`: ImageVector? = null
