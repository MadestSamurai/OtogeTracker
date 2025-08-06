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

public val Fa.`Hand-scissors`: ImageVector
    get() {
        if (`_hand-scissors` != null) {
            return `_hand-scissors`!!
        }
        `_hand-scissors` = Builder(name = "Hand-scissors", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(104.0f, 272.0f)
                curveTo(81.9f, 272.0f, 64.0f, 289.9f, 64.0f, 312.0f)
                curveTo(64.0f, 334.1f, 81.9f, 352.0f, 104.0f, 352.0f)
                lineTo(284.2f, 352.0f)
                curveTo(276.6f, 360.5f, 272.0f, 371.7f, 272.0f, 384.0f)
                curveTo(272.0f, 409.3f, 291.5f, 430.0f, 316.3f, 431.9f)
                curveTo(308.6f, 440.4f, 304.0f, 451.7f, 304.0f, 464.0f)
                curveTo(304.0f, 490.5f, 325.5f, 512.0f, 352.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                curveTo(518.7f, 512.0f, 576.0f, 454.7f, 576.0f, 384.0f)
                lineTo(576.0f, 270.9f)
                curveTo(576.0f, 230.7f, 560.0f, 192.1f, 531.6f, 163.6f)
                curveTo(508.8f, 140.8f, 478.0f, 128.0f, 445.8f, 128.0f)
                lineTo(400.0f, 128.0f)
                curveTo(378.7f, 128.0f, 360.7f, 141.9f, 354.4f, 161.1f)
                lineTo(428.9f, 184.8f)
                curveTo(437.3f, 187.5f, 442.0f, 196.5f, 439.3f, 204.9f)
                curveTo(436.6f, 213.3f, 427.6f, 218.0f, 419.2f, 215.3f)
                lineTo(352.1f, 193.9f)
                lineTo(352.1f, 194.0f)
                lineTo(148.1f, 129.9f)
                curveTo(126.9f, 123.2f, 104.5f, 134.9f, 97.9f, 156.0f)
                curveTo(91.3f, 177.1f, 103.0f, 199.5f, 124.1f, 206.2f)
                lineTo(333.5f, 272.0f)
                lineTo(104.0f, 272.0f)
                close()
            }
        }
        .build()
        return `_hand-scissors`!!
    }

private var `_hand-scissors`: ImageVector? = null
