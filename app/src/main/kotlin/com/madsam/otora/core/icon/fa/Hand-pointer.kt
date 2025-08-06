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

public val Fa.`Hand-pointer`: ImageVector
    get() {
        if (`_hand-pointer` != null) {
            return `_hand-pointer`!!
        }
        `_hand-pointer` = Builder(name = "Hand-pointer", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 104.0f)
                curveTo(224.0f, 81.9f, 241.9f, 64.0f, 264.0f, 64.0f)
                curveTo(286.1f, 64.0f, 304.0f, 81.9f, 304.0f, 104.0f)
                lineTo(304.0f, 252.2f)
                curveTo(312.5f, 244.6f, 323.7f, 240.0f, 336.0f, 240.0f)
                curveTo(356.6f, 240.0f, 374.2f, 253.0f, 381.0f, 271.2f)
                curveTo(389.8f, 261.9f, 402.2f, 256.0f, 416.0f, 256.0f)
                curveTo(441.3f, 256.0f, 462.0f, 275.5f, 463.9f, 300.3f)
                curveTo(472.4f, 292.6f, 483.7f, 288.0f, 496.0f, 288.0f)
                curveTo(522.5f, 288.0f, 544.0f, 309.5f, 544.0f, 336.0f)
                lineTo(544.0f, 448.0f)
                curveTo(544.0f, 518.7f, 486.7f, 576.0f, 416.0f, 576.0f)
                lineTo(330.7f, 576.0f)
                curveTo(325.7f, 576.0f, 320.8f, 575.7f, 316.0f, 575.0f)
                curveTo(260.7f, 569.4f, 209.8f, 541.0f, 176.0f, 496.0f)
                lineTo(104.0f, 400.0f)
                curveTo(90.7f, 382.3f, 94.3f, 357.3f, 112.0f, 344.0f)
                curveTo(129.7f, 330.7f, 154.7f, 334.3f, 168.0f, 352.0f)
                lineTo(224.0f, 426.7f)
                lineTo(224.0f, 104.0f)
                close()
                moveTo(336.0f, 368.0f)
                curveTo(336.0f, 359.2f, 328.8f, 352.0f, 320.0f, 352.0f)
                curveTo(311.2f, 352.0f, 304.0f, 359.2f, 304.0f, 368.0f)
                lineTo(304.0f, 464.0f)
                curveTo(304.0f, 472.8f, 311.2f, 480.0f, 320.0f, 480.0f)
                curveTo(328.8f, 480.0f, 336.0f, 472.8f, 336.0f, 464.0f)
                lineTo(336.0f, 368.0f)
                close()
                moveTo(384.0f, 352.0f)
                curveTo(375.2f, 352.0f, 368.0f, 359.2f, 368.0f, 368.0f)
                lineTo(368.0f, 464.0f)
                curveTo(368.0f, 472.8f, 375.2f, 480.0f, 384.0f, 480.0f)
                curveTo(392.8f, 480.0f, 400.0f, 472.8f, 400.0f, 464.0f)
                lineTo(400.0f, 368.0f)
                curveTo(400.0f, 359.2f, 392.8f, 352.0f, 384.0f, 352.0f)
                close()
                moveTo(464.0f, 368.0f)
                curveTo(464.0f, 359.2f, 456.8f, 352.0f, 448.0f, 352.0f)
                curveTo(439.2f, 352.0f, 432.0f, 359.2f, 432.0f, 368.0f)
                lineTo(432.0f, 464.0f)
                curveTo(432.0f, 472.8f, 439.2f, 480.0f, 448.0f, 480.0f)
                curveTo(456.8f, 480.0f, 464.0f, 472.8f, 464.0f, 464.0f)
                lineTo(464.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_hand-pointer`!!
    }

private var `_hand-pointer`: ImageVector? = null
