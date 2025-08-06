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

public val Fa.`Tv-alt`: ImageVector
    get() {
        if (`_tv-alt` != null) {
            return `_tv-alt`!!
        }
        `_tv-alt` = Builder(name = "Tv-alt", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 160.0f)
                lineTo(96.0f, 400.0f)
                lineTo(544.0f, 400.0f)
                lineTo(544.0f, 160.0f)
                lineTo(96.0f, 160.0f)
                close()
                moveTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(579.3f, 96.0f, 608.0f, 124.7f, 608.0f, 160.0f)
                lineTo(608.0f, 400.0f)
                curveTo(608.0f, 435.3f, 579.3f, 464.0f, 544.0f, 464.0f)
                lineTo(96.0f, 464.0f)
                curveTo(60.7f, 464.0f, 32.0f, 435.3f, 32.0f, 400.0f)
                lineTo(32.0f, 160.0f)
                close()
                moveTo(192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                curveTo(465.7f, 512.0f, 480.0f, 526.3f, 480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(174.3f, 576.0f, 160.0f, 561.7f, 160.0f, 544.0f)
                curveTo(160.0f, 526.3f, 174.3f, 512.0f, 192.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_tv-alt`!!
    }

private var `_tv-alt`: ImageVector? = null
