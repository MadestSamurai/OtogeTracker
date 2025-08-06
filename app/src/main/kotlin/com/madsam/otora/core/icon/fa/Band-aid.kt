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

public val Fa.`Band-aid`: ImageVector
    get() {
        if (`_band-aid` != null) {
            return `_band-aid`!!
        }
        `_band-aid` = Builder(name = "Band-aid", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(496.0f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(579.3f, 480.0f, 608.0f, 451.3f, 608.0f, 416.0f)
                lineTo(608.0f, 224.0f)
                curveTo(608.0f, 188.7f, 579.3f, 160.0f, 544.0f, 160.0f)
                lineTo(496.0f, 160.0f)
                lineTo(496.0f, 480.0f)
                close()
                moveTo(448.0f, 160.0f)
                lineTo(192.0f, 160.0f)
                lineTo(192.0f, 480.0f)
                lineTo(448.0f, 480.0f)
                lineTo(448.0f, 160.0f)
                close()
                moveTo(96.0f, 160.0f)
                curveTo(60.7f, 160.0f, 32.0f, 188.7f, 32.0f, 224.0f)
                lineTo(32.0f, 416.0f)
                curveTo(32.0f, 451.3f, 60.7f, 480.0f, 96.0f, 480.0f)
                lineTo(144.0f, 480.0f)
                lineTo(144.0f, 160.0f)
                lineTo(96.0f, 160.0f)
                close()
                moveTo(248.0f, 272.0f)
                curveTo(248.0f, 258.7f, 258.7f, 248.0f, 272.0f, 248.0f)
                curveTo(285.3f, 248.0f, 296.0f, 258.7f, 296.0f, 272.0f)
                curveTo(296.0f, 285.3f, 285.3f, 296.0f, 272.0f, 296.0f)
                curveTo(258.7f, 296.0f, 248.0f, 285.3f, 248.0f, 272.0f)
                close()
                moveTo(368.0f, 248.0f)
                curveTo(381.3f, 248.0f, 392.0f, 258.7f, 392.0f, 272.0f)
                curveTo(392.0f, 285.3f, 381.3f, 296.0f, 368.0f, 296.0f)
                curveTo(354.7f, 296.0f, 344.0f, 285.3f, 344.0f, 272.0f)
                curveTo(344.0f, 258.7f, 354.7f, 248.0f, 368.0f, 248.0f)
                close()
                moveTo(248.0f, 368.0f)
                curveTo(248.0f, 354.7f, 258.7f, 344.0f, 272.0f, 344.0f)
                curveTo(285.3f, 344.0f, 296.0f, 354.7f, 296.0f, 368.0f)
                curveTo(296.0f, 381.3f, 285.3f, 392.0f, 272.0f, 392.0f)
                curveTo(258.7f, 392.0f, 248.0f, 381.3f, 248.0f, 368.0f)
                close()
                moveTo(368.0f, 344.0f)
                curveTo(381.3f, 344.0f, 392.0f, 354.7f, 392.0f, 368.0f)
                curveTo(392.0f, 381.3f, 381.3f, 392.0f, 368.0f, 392.0f)
                curveTo(354.7f, 392.0f, 344.0f, 381.3f, 344.0f, 368.0f)
                curveTo(344.0f, 354.7f, 354.7f, 344.0f, 368.0f, 344.0f)
                close()
            }
        }
        .build()
        return `_band-aid`!!
    }

private var `_band-aid`: ImageVector? = null
