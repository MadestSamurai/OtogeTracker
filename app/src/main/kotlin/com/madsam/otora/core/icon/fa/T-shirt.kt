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

public val Fa.`T-shirt`: ImageVector
    get() {
        if (`_t-shirt` != null) {
            return `_t-shirt`!!
        }
        `_t-shirt` = Builder(name = "T-shirt", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.2f, 176.0f)
                curveTo(364.4f, 176.0f, 400.2f, 140.2f, 400.2f, 96.0f)
                lineTo(453.7f, 96.0f)
                curveTo(470.7f, 96.0f, 487.0f, 102.7f, 499.0f, 114.7f)
                lineTo(617.6f, 233.4f)
                curveTo(630.1f, 245.9f, 630.1f, 266.2f, 617.6f, 278.7f)
                lineTo(566.9f, 329.4f)
                curveTo(554.4f, 341.9f, 534.1f, 341.9f, 521.6f, 329.4f)
                lineTo(480.2f, 288.0f)
                lineTo(480.2f, 512.0f)
                curveTo(480.2f, 547.3f, 451.5f, 576.0f, 416.2f, 576.0f)
                lineTo(224.2f, 576.0f)
                curveTo(188.9f, 576.0f, 160.2f, 547.3f, 160.2f, 512.0f)
                lineTo(160.2f, 288.0f)
                lineTo(118.8f, 329.4f)
                curveTo(106.3f, 341.9f, 86.0f, 341.9f, 73.5f, 329.4f)
                lineTo(22.9f, 278.6f)
                curveTo(10.4f, 266.1f, 10.4f, 245.8f, 22.9f, 233.3f)
                lineTo(141.5f, 114.7f)
                curveTo(153.5f, 102.7f, 169.8f, 96.0f, 186.8f, 96.0f)
                lineTo(240.3f, 96.0f)
                curveTo(240.3f, 140.2f, 276.1f, 176.0f, 320.3f, 176.0f)
                close()
            }
        }
        .build()
        return `_t-shirt`!!
    }

private var `_t-shirt`: ImageVector? = null
