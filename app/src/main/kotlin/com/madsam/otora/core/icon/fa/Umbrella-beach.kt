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

public val Fa.`Umbrella-beach`: ImageVector
    get() {
        if (`_umbrella-beach` != null) {
            return `_umbrella-beach`!!
        }
        `_umbrella-beach` = Builder(name = "Umbrella-beach", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(561.5f, 405.1f)
                curveTo(555.6f, 421.8f, 536.2f, 428.1f, 520.4f, 420.2f)
                lineTo(342.2f, 331.1f)
                lineTo(340.6f, 334.3f)
                lineTo(251.8f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(561.7f, 512.0f, 576.0f, 526.3f, 576.0f, 544.0f)
                curveTo(576.0f, 561.7f, 561.7f, 576.0f, 544.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(78.3f, 576.0f, 64.0f, 561.7f, 64.0f, 544.0f)
                curveTo(64.0f, 526.3f, 78.3f, 512.0f, 96.0f, 512.0f)
                lineTo(180.2f, 512.0f)
                lineTo(283.4f, 305.7f)
                lineTo(285.0f, 302.5f)
                lineTo(119.6f, 219.8f)
                curveTo(103.8f, 211.9f, 97.2f, 192.5f, 107.1f, 177.8f)
                curveTo(153.0f, 109.2f, 231.2f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 349.8f, 570.9f, 378.5f, 561.5f, 405.1f)
                close()
            }
        }
        .build()
        return `_umbrella-beach`!!
    }

private var `_umbrella-beach`: ImageVector? = null
