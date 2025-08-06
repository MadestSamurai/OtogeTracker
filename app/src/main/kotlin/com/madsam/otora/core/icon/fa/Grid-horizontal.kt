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

public val Fa.`Grid-horizontal`: ImageVector
    get() {
        if (`_grid-horizontal` != null) {
            return `_grid-horizontal`!!
        }
        `_grid-horizontal` = Builder(name = "Grid-horizontal", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(152.0f, 160.0f)
                curveTo(174.1f, 160.0f, 192.0f, 177.9f, 192.0f, 200.0f)
                lineTo(192.0f, 248.0f)
                curveTo(192.0f, 270.1f, 174.1f, 288.0f, 152.0f, 288.0f)
                lineTo(104.0f, 288.0f)
                curveTo(81.9f, 288.0f, 64.0f, 270.1f, 64.0f, 248.0f)
                lineTo(64.0f, 200.0f)
                curveTo(64.0f, 177.9f, 81.9f, 160.0f, 104.0f, 160.0f)
                lineTo(152.0f, 160.0f)
                close()
                moveTo(344.0f, 288.0f)
                lineTo(296.0f, 288.0f)
                curveTo(273.9f, 288.0f, 256.0f, 270.1f, 256.0f, 248.0f)
                lineTo(256.0f, 200.0f)
                curveTo(256.0f, 177.9f, 273.9f, 160.0f, 296.0f, 160.0f)
                lineTo(344.0f, 160.0f)
                curveTo(366.1f, 160.0f, 384.0f, 177.9f, 384.0f, 200.0f)
                lineTo(384.0f, 248.0f)
                curveTo(384.0f, 270.1f, 366.1f, 288.0f, 344.0f, 288.0f)
                close()
                moveTo(536.0f, 288.0f)
                lineTo(488.0f, 288.0f)
                curveTo(465.9f, 288.0f, 448.0f, 270.1f, 448.0f, 248.0f)
                lineTo(448.0f, 200.0f)
                curveTo(448.0f, 177.9f, 465.9f, 160.0f, 488.0f, 160.0f)
                lineTo(536.0f, 160.0f)
                curveTo(558.1f, 160.0f, 576.0f, 177.9f, 576.0f, 200.0f)
                lineTo(576.0f, 248.0f)
                curveTo(576.0f, 270.1f, 558.1f, 288.0f, 536.0f, 288.0f)
                close()
                moveTo(536.0f, 480.0f)
                lineTo(488.0f, 480.0f)
                curveTo(465.9f, 480.0f, 448.0f, 462.1f, 448.0f, 440.0f)
                lineTo(448.0f, 392.0f)
                curveTo(448.0f, 369.9f, 465.9f, 352.0f, 488.0f, 352.0f)
                lineTo(536.0f, 352.0f)
                curveTo(558.1f, 352.0f, 576.0f, 369.9f, 576.0f, 392.0f)
                lineTo(576.0f, 440.0f)
                curveTo(576.0f, 462.1f, 558.1f, 480.0f, 536.0f, 480.0f)
                close()
                moveTo(344.0f, 352.0f)
                curveTo(366.1f, 352.0f, 384.0f, 369.9f, 384.0f, 392.0f)
                lineTo(384.0f, 440.0f)
                curveTo(384.0f, 462.1f, 366.1f, 480.0f, 344.0f, 480.0f)
                lineTo(296.0f, 480.0f)
                curveTo(273.9f, 480.0f, 256.0f, 462.1f, 256.0f, 440.0f)
                lineTo(256.0f, 392.0f)
                curveTo(256.0f, 369.9f, 273.9f, 352.0f, 296.0f, 352.0f)
                lineTo(344.0f, 352.0f)
                close()
                moveTo(152.0f, 480.0f)
                lineTo(104.0f, 480.0f)
                curveTo(81.9f, 480.0f, 64.0f, 462.1f, 64.0f, 440.0f)
                lineTo(64.0f, 392.0f)
                curveTo(64.0f, 369.9f, 81.9f, 352.0f, 104.0f, 352.0f)
                lineTo(152.0f, 352.0f)
                curveTo(174.1f, 352.0f, 192.0f, 369.9f, 192.0f, 392.0f)
                lineTo(192.0f, 440.0f)
                curveTo(192.0f, 462.1f, 174.1f, 480.0f, 152.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_grid-horizontal`!!
    }

private var `_grid-horizontal`: ImageVector? = null
