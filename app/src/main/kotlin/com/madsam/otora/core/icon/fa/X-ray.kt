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

public val Fa.`X-ray`: ImageVector
    get() {
        if (`_x-ray` != null) {
            return `_x-ray`!!
        }
        `_x-ray` = Builder(name = "X-ray", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(561.7f, 96.0f, 576.0f, 110.3f, 576.0f, 128.0f)
                curveTo(576.0f, 145.7f, 561.7f, 160.0f, 544.0f, 160.0f)
                lineTo(544.0f, 480.0f)
                curveTo(561.7f, 480.0f, 576.0f, 494.3f, 576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                curveTo(64.0f, 494.3f, 78.3f, 480.0f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                curveTo(78.3f, 160.0f, 64.0f, 145.7f, 64.0f, 128.0f)
                close()
                moveTo(344.0f, 184.0f)
                curveTo(344.0f, 170.7f, 333.3f, 160.0f, 320.0f, 160.0f)
                curveTo(306.7f, 160.0f, 296.0f, 170.7f, 296.0f, 184.0f)
                lineTo(296.0f, 200.0f)
                lineTo(232.0f, 200.0f)
                curveTo(218.7f, 200.0f, 208.0f, 210.7f, 208.0f, 224.0f)
                curveTo(208.0f, 237.3f, 218.7f, 248.0f, 232.0f, 248.0f)
                lineTo(296.0f, 248.0f)
                lineTo(296.0f, 296.0f)
                lineTo(216.0f, 296.0f)
                curveTo(202.7f, 296.0f, 192.0f, 306.7f, 192.0f, 320.0f)
                curveTo(192.0f, 333.3f, 202.7f, 344.0f, 216.0f, 344.0f)
                lineTo(296.0f, 344.0f)
                lineTo(296.0f, 392.0f)
                lineTo(232.0f, 392.0f)
                curveTo(218.7f, 392.0f, 208.0f, 402.7f, 208.0f, 416.0f)
                curveTo(208.0f, 429.3f, 218.7f, 440.0f, 232.0f, 440.0f)
                lineTo(296.0f, 440.0f)
                lineTo(296.0f, 456.0f)
                curveTo(296.0f, 469.3f, 306.7f, 480.0f, 320.0f, 480.0f)
                curveTo(333.3f, 480.0f, 344.0f, 469.3f, 344.0f, 456.0f)
                lineTo(344.0f, 440.0f)
                lineTo(408.0f, 440.0f)
                curveTo(421.3f, 440.0f, 432.0f, 429.3f, 432.0f, 416.0f)
                curveTo(432.0f, 402.7f, 421.3f, 392.0f, 408.0f, 392.0f)
                lineTo(344.0f, 392.0f)
                lineTo(344.0f, 344.0f)
                lineTo(424.0f, 344.0f)
                curveTo(437.3f, 344.0f, 448.0f, 333.3f, 448.0f, 320.0f)
                curveTo(448.0f, 306.7f, 437.3f, 296.0f, 424.0f, 296.0f)
                lineTo(344.0f, 296.0f)
                lineTo(344.0f, 248.0f)
                lineTo(408.0f, 248.0f)
                curveTo(421.3f, 248.0f, 432.0f, 237.3f, 432.0f, 224.0f)
                curveTo(432.0f, 210.7f, 421.3f, 200.0f, 408.0f, 200.0f)
                lineTo(344.0f, 200.0f)
                lineTo(344.0f, 184.0f)
                close()
            }
        }
        .build()
        return `_x-ray`!!
    }

private var `_x-ray`: ImageVector? = null
