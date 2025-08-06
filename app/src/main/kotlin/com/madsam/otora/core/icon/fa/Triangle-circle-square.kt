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

public val Fa.`Triangle-circle-square`: ImageVector
    get() {
        if (`_triangle-circle-square` != null) {
            return `_triangle-circle-square`!!
        }
        `_triangle-circle-square` = Builder(name = "Triangle-circle-square", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(331.2f, 64.0f, 341.7f, 69.9f, 347.4f, 79.5f)
                lineTo(443.4f, 239.5f)
                curveTo(449.3f, 249.4f, 449.5f, 261.7f, 443.8f, 271.7f)
                curveTo(438.1f, 281.7f, 427.5f, 288.0f, 416.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                curveTo(212.5f, 288.0f, 201.8f, 281.8f, 196.2f, 271.8f)
                curveTo(190.6f, 261.8f, 190.7f, 249.5f, 196.6f, 239.6f)
                lineTo(292.6f, 79.6f)
                curveTo(298.3f, 69.9f, 308.8f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(192.0f, 336.0f)
                curveTo(253.9f, 336.0f, 304.0f, 386.1f, 304.0f, 448.0f)
                curveTo(304.0f, 509.9f, 253.9f, 560.0f, 192.0f, 560.0f)
                curveTo(130.1f, 560.0f, 80.0f, 509.9f, 80.0f, 448.0f)
                curveTo(80.0f, 386.1f, 130.1f, 336.0f, 192.0f, 336.0f)
                close()
                moveTo(392.0f, 352.0f)
                lineTo(504.0f, 352.0f)
                curveTo(526.1f, 352.0f, 544.0f, 369.9f, 544.0f, 392.0f)
                lineTo(544.0f, 504.0f)
                curveTo(544.0f, 526.1f, 526.1f, 544.0f, 504.0f, 544.0f)
                lineTo(392.0f, 544.0f)
                curveTo(369.9f, 544.0f, 352.0f, 526.1f, 352.0f, 504.0f)
                lineTo(352.0f, 392.0f)
                curveTo(352.0f, 369.9f, 369.9f, 352.0f, 392.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_triangle-circle-square`!!
    }

private var `_triangle-circle-square`: ImageVector? = null
