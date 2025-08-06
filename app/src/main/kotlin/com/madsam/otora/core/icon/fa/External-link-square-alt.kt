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

public val Fa.`External-link-square-alt`: ImageVector
    get() {
        if (`_external-link-square-alt` != null) {
            return `_external-link-square-alt`!!
        }
        `_external-link-square-alt` = Builder(name = "External-link-square-alt", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                close()
                moveTo(264.0f, 224.0f)
                curveTo(254.3f, 224.0f, 245.5f, 229.8f, 241.8f, 238.8f)
                curveTo(238.1f, 247.8f, 240.1f, 258.1f, 247.0f, 265.0f)
                lineTo(282.0f, 300.0f)
                lineTo(215.0f, 367.0f)
                curveTo(205.6f, 376.4f, 205.6f, 391.6f, 215.0f, 400.9f)
                lineTo(239.0f, 424.9f)
                curveTo(248.4f, 434.3f, 263.6f, 434.3f, 272.9f, 424.9f)
                lineTo(339.9f, 357.9f)
                lineTo(374.9f, 392.9f)
                curveTo(381.8f, 399.8f, 392.1f, 401.8f, 401.1f, 398.1f)
                curveTo(410.1f, 394.4f, 416.0f, 385.7f, 416.0f, 376.0f)
                lineTo(416.0f, 248.0f)
                curveTo(416.0f, 234.7f, 405.3f, 224.0f, 392.0f, 224.0f)
                lineTo(264.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_external-link-square-alt`!!
    }

private var `_external-link-square-alt`: ImageVector? = null
