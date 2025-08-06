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

public val Fa.`Up-right-and-down-left-from-center`: ImageVector
    get() {
        if (`_up-right-and-down-left-from-center` != null) {
            return `_up-right-and-down-left-from-center`!!
        }
        `_up-right-and-down-left-from-center` = Builder(name = "Up-right-and-down-left-from-center",
                defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f,
                viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(408.0f, 64.0f)
                lineTo(552.0f, 64.0f)
                curveTo(565.3f, 64.0f, 576.0f, 74.7f, 576.0f, 88.0f)
                lineTo(576.0f, 232.0f)
                curveTo(576.0f, 241.7f, 570.2f, 250.5f, 561.2f, 254.2f)
                curveTo(552.2f, 257.9f, 541.9f, 255.9f, 535.0f, 249.0f)
                lineTo(496.0f, 210.0f)
                lineTo(409.0f, 297.0f)
                curveTo(399.6f, 306.4f, 384.4f, 306.4f, 375.1f, 297.0f)
                lineTo(343.1f, 265.0f)
                curveTo(333.7f, 255.6f, 333.7f, 240.4f, 343.1f, 231.1f)
                lineTo(430.1f, 144.1f)
                lineTo(391.1f, 105.1f)
                curveTo(384.2f, 98.2f, 382.2f, 87.9f, 385.9f, 78.9f)
                curveTo(389.6f, 69.9f, 398.3f, 64.0f, 408.0f, 64.0f)
                close()
                moveTo(232.0f, 576.0f)
                lineTo(88.0f, 576.0f)
                curveTo(74.7f, 576.0f, 64.0f, 565.3f, 64.0f, 552.0f)
                lineTo(64.0f, 408.0f)
                curveTo(64.0f, 398.3f, 69.8f, 389.5f, 78.8f, 385.8f)
                curveTo(87.8f, 382.1f, 98.1f, 384.2f, 105.0f, 391.0f)
                lineTo(144.0f, 430.0f)
                lineTo(231.0f, 343.0f)
                curveTo(240.4f, 333.6f, 255.6f, 333.6f, 264.9f, 343.0f)
                lineTo(296.9f, 375.0f)
                curveTo(306.3f, 384.4f, 306.3f, 399.6f, 296.9f, 408.9f)
                lineTo(209.9f, 495.9f)
                lineTo(248.9f, 534.9f)
                curveTo(255.8f, 541.8f, 257.8f, 552.1f, 254.1f, 561.1f)
                curveTo(250.4f, 570.1f, 241.7f, 576.0f, 232.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_up-right-and-down-left-from-center`!!
    }

private var `_up-right-and-down-left-from-center`: ImageVector? = null
