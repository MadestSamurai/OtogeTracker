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

public val Fa.`Graduation-cap`: ImageVector
    get() {
        if (`_graduation-cap` != null) {
            return `_graduation-cap`!!
        }
        `_graduation-cap` = Builder(name = "Graduation-cap", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(80.0f, 259.8f)
                lineTo(289.2f, 345.9f)
                curveTo(299.0f, 349.9f, 309.4f, 352.0f, 320.0f, 352.0f)
                curveTo(330.6f, 352.0f, 341.0f, 349.9f, 350.8f, 345.9f)
                lineTo(593.2f, 246.1f)
                curveTo(602.2f, 242.4f, 608.0f, 233.7f, 608.0f, 224.0f)
                curveTo(608.0f, 214.3f, 602.2f, 205.6f, 593.2f, 201.9f)
                lineTo(350.8f, 102.1f)
                curveTo(341.0f, 98.1f, 330.6f, 96.0f, 320.0f, 96.0f)
                curveTo(309.4f, 96.0f, 299.0f, 98.1f, 289.2f, 102.1f)
                lineTo(46.8f, 201.9f)
                curveTo(37.8f, 205.6f, 32.0f, 214.3f, 32.0f, 224.0f)
                lineTo(32.0f, 520.0f)
                curveTo(32.0f, 533.3f, 42.7f, 544.0f, 56.0f, 544.0f)
                curveTo(69.3f, 544.0f, 80.0f, 533.3f, 80.0f, 520.0f)
                lineTo(80.0f, 259.8f)
                close()
                moveTo(128.0f, 331.5f)
                lineTo(128.0f, 448.0f)
                curveTo(128.0f, 501.0f, 214.0f, 544.0f, 320.0f, 544.0f)
                curveTo(426.0f, 544.0f, 512.0f, 501.0f, 512.0f, 448.0f)
                lineTo(512.0f, 331.4f)
                lineTo(369.1f, 390.3f)
                curveTo(353.5f, 396.7f, 336.9f, 400.0f, 320.0f, 400.0f)
                curveTo(303.1f, 400.0f, 286.5f, 396.7f, 270.9f, 390.3f)
                lineTo(128.0f, 331.4f)
                close()
            }
        }
        .build()
        return `_graduation-cap`!!
    }

private var `_graduation-cap`: ImageVector? = null
