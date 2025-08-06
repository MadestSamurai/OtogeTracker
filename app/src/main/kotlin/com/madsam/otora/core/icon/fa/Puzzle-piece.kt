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

public val Fa.`Puzzle-piece`: ImageVector
    get() {
        if (`_puzzle-piece` != null) {
            return `_puzzle-piece`!!
        }
        `_puzzle-piece` = Builder(name = "Puzzle-piece", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 64.0f)
                curveTo(323.3f, 64.0f, 352.0f, 85.5f, 352.0f, 112.0f)
                curveTo(352.0f, 122.4f, 347.6f, 132.0f, 340.0f, 139.9f)
                curveTo(333.4f, 146.8f, 328.0f, 155.2f, 328.0f, 164.8f)
                curveTo(328.0f, 179.8f, 340.2f, 192.0f, 355.2f, 192.0f)
                lineTo(400.0f, 192.0f)
                curveTo(426.5f, 192.0f, 448.0f, 213.5f, 448.0f, 240.0f)
                lineTo(448.0f, 284.8f)
                curveTo(448.0f, 299.8f, 460.2f, 312.0f, 475.2f, 312.0f)
                curveTo(484.7f, 312.0f, 493.2f, 306.6f, 500.1f, 300.0f)
                curveTo(508.0f, 292.5f, 517.6f, 288.0f, 528.0f, 288.0f)
                curveTo(554.5f, 288.0f, 576.0f, 316.7f, 576.0f, 352.0f)
                curveTo(576.0f, 387.3f, 554.5f, 416.0f, 528.0f, 416.0f)
                curveTo(517.6f, 416.0f, 507.9f, 411.6f, 500.1f, 404.0f)
                curveTo(493.2f, 397.4f, 484.8f, 392.0f, 475.2f, 392.0f)
                curveTo(460.2f, 392.0f, 448.0f, 404.2f, 448.0f, 419.2f)
                lineTo(448.0f, 528.0f)
                curveTo(448.0f, 554.5f, 426.5f, 576.0f, 400.0f, 576.0f)
                lineTo(343.2f, 576.0f)
                curveTo(330.4f, 576.0f, 320.0f, 565.6f, 320.0f, 552.8f)
                curveTo(320.0f, 543.6f, 325.8f, 535.5f, 333.2f, 530.0f)
                curveTo(344.8f, 521.3f, 352.0f, 509.3f, 352.0f, 496.0f)
                curveTo(352.0f, 469.5f, 323.3f, 448.0f, 288.0f, 448.0f)
                curveTo(252.7f, 448.0f, 224.0f, 469.5f, 224.0f, 496.0f)
                curveTo(224.0f, 509.3f, 231.2f, 521.3f, 242.8f, 530.0f)
                curveTo(250.2f, 535.5f, 256.0f, 543.5f, 256.0f, 552.8f)
                curveTo(256.0f, 565.6f, 245.6f, 576.0f, 232.8f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(85.5f, 576.0f, 64.0f, 554.5f, 64.0f, 528.0f)
                lineTo(64.0f, 407.2f)
                curveTo(64.0f, 394.4f, 74.4f, 384.0f, 87.2f, 384.0f)
                curveTo(96.4f, 384.0f, 104.5f, 389.8f, 110.0f, 397.2f)
                curveTo(118.7f, 408.8f, 130.7f, 416.0f, 144.0f, 416.0f)
                curveTo(170.5f, 416.0f, 192.0f, 387.3f, 192.0f, 352.0f)
                curveTo(192.0f, 316.7f, 170.5f, 288.0f, 144.0f, 288.0f)
                curveTo(130.7f, 288.0f, 118.7f, 295.2f, 110.0f, 306.8f)
                curveTo(104.5f, 314.2f, 96.5f, 320.0f, 87.2f, 320.0f)
                curveTo(74.4f, 320.0f, 64.0f, 309.6f, 64.0f, 296.8f)
                lineTo(64.0f, 240.0f)
                curveTo(64.0f, 213.5f, 85.5f, 192.0f, 112.0f, 192.0f)
                lineTo(220.8f, 192.0f)
                curveTo(235.8f, 192.0f, 248.0f, 179.8f, 248.0f, 164.8f)
                curveTo(248.0f, 155.3f, 242.6f, 146.8f, 236.0f, 139.9f)
                curveTo(228.5f, 132.0f, 224.0f, 122.4f, 224.0f, 112.0f)
                curveTo(224.0f, 85.5f, 252.7f, 64.0f, 288.0f, 64.0f)
                close()
            }
        }
        .build()
        return `_puzzle-piece`!!
    }

private var `_puzzle-piece`: ImageVector? = null
