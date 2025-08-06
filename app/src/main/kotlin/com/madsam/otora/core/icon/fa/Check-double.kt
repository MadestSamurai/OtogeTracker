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

public val Fa.`Check-double`: ImageVector
    get() {
        if (`_check-double` != null) {
            return `_check-double`!!
        }
        `_check-double` = Builder(name = "Check-double", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(377.9f, 130.8f)
                curveTo(388.3f, 116.5f, 385.1f, 96.5f, 370.8f, 86.1f)
                curveTo(356.5f, 75.7f, 336.5f, 78.9f, 326.1f, 93.2f)
                lineTo(220.1f, 238.9f)
                lineTo(182.6f, 201.4f)
                curveTo(170.1f, 188.9f, 149.8f, 188.9f, 137.3f, 201.4f)
                curveTo(124.8f, 213.9f, 124.8f, 234.2f, 137.3f, 246.7f)
                lineTo(201.3f, 310.7f)
                curveTo(207.9f, 317.3f, 217.1f, 320.7f, 226.4f, 320.0f)
                curveTo(235.7f, 319.3f, 244.3f, 314.5f, 249.8f, 306.9f)
                lineTo(377.8f, 130.9f)
                close()
                moveTo(505.9f, 266.8f)
                curveTo(516.3f, 252.5f, 513.1f, 232.5f, 498.8f, 222.1f)
                curveTo(484.5f, 211.7f, 464.5f, 214.9f, 454.1f, 229.2f)
                lineTo(284.1f, 462.9f)
                lineTo(214.6f, 393.4f)
                curveTo(202.1f, 380.9f, 181.8f, 380.9f, 169.3f, 393.4f)
                curveTo(156.8f, 405.9f, 156.8f, 426.2f, 169.3f, 438.7f)
                lineTo(265.3f, 534.7f)
                curveTo(271.9f, 541.3f, 281.1f, 544.7f, 290.4f, 544.0f)
                curveTo(299.7f, 543.3f, 308.3f, 538.5f, 313.8f, 530.9f)
                lineTo(505.8f, 266.9f)
                close()
            }
        }
        .build()
        return `_check-double`!!
    }

private var `_check-double`: ImageVector? = null
