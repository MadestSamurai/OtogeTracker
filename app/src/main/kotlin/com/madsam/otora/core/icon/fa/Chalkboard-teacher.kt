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

public val Fa.`Chalkboard-teacher`: ImageVector
    get() {
        if (`_chalkboard-teacher` != null) {
            return `_chalkboard-teacher`!!
        }
        `_chalkboard-teacher` = Builder(name = "Chalkboard-teacher", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 160.0f)
                curveTo(128.0f, 124.7f, 156.7f, 96.0f, 192.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(579.3f, 96.0f, 608.0f, 124.7f, 608.0f, 160.0f)
                lineTo(608.0f, 400.0f)
                lineTo(512.0f, 400.0f)
                lineTo(512.0f, 384.0f)
                curveTo(512.0f, 366.3f, 497.7f, 352.0f, 480.0f, 352.0f)
                lineTo(416.0f, 352.0f)
                curveTo(398.3f, 352.0f, 384.0f, 366.3f, 384.0f, 384.0f)
                lineTo(384.0f, 400.0f)
                lineTo(254.9f, 400.0f)
                curveTo(265.8f, 381.2f, 272.0f, 359.3f, 272.0f, 336.0f)
                curveTo(272.0f, 265.3f, 214.7f, 208.0f, 144.0f, 208.0f)
                curveTo(138.6f, 208.0f, 133.2f, 208.3f, 128.0f, 209.0f)
                lineTo(128.0f, 160.0f)
                close()
                moveTo(333.0f, 512.0f)
                curveTo(327.9f, 487.8f, 316.7f, 465.9f, 300.9f, 448.0f)
                lineTo(608.0f, 448.0f)
                curveTo(608.0f, 483.3f, 579.3f, 512.0f, 544.0f, 512.0f)
                lineTo(333.0f, 512.0f)
                close()
                moveTo(64.0f, 336.0f)
                curveTo(64.0f, 291.8f, 99.8f, 256.0f, 144.0f, 256.0f)
                curveTo(188.2f, 256.0f, 224.0f, 291.8f, 224.0f, 336.0f)
                curveTo(224.0f, 380.2f, 188.2f, 416.0f, 144.0f, 416.0f)
                curveTo(99.8f, 416.0f, 64.0f, 380.2f, 64.0f, 336.0f)
                close()
                moveTo(0.0f, 544.0f)
                curveTo(0.0f, 491.0f, 43.0f, 448.0f, 96.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(245.0f, 448.0f, 288.0f, 491.0f, 288.0f, 544.0f)
                curveTo(288.0f, 561.7f, 273.7f, 576.0f, 256.0f, 576.0f)
                lineTo(32.0f, 576.0f)
                curveTo(14.3f, 576.0f, 0.0f, 561.7f, 0.0f, 544.0f)
                close()
            }
        }
        .build()
        return `_chalkboard-teacher`!!
    }

private var `_chalkboard-teacher`: ImageVector? = null
