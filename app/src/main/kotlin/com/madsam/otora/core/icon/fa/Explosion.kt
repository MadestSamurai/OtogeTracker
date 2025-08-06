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

public val Fa.Explosion: ImageVector
    get() {
        if (_explosion != null) {
            return _explosion!!
        }
        _explosion = Builder(name = "Explosion", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(333.3f, 32.0f, 344.0f, 42.7f, 344.0f, 56.0f)
                lineTo(344.0f, 104.0f)
                curveTo(344.0f, 117.3f, 333.3f, 128.0f, 320.0f, 128.0f)
                curveTo(306.7f, 128.0f, 296.0f, 117.3f, 296.0f, 104.0f)
                lineTo(296.0f, 56.0f)
                curveTo(296.0f, 42.7f, 306.7f, 32.0f, 320.0f, 32.0f)
                close()
                moveTo(320.0f, 192.0f)
                curveTo(332.4f, 192.0f, 342.7f, 201.4f, 343.9f, 213.7f)
                lineTo(357.4f, 355.6f)
                lineTo(531.6f, 75.3f)
                curveTo(538.3f, 64.6f, 552.1f, 60.8f, 563.3f, 66.8f)
                curveTo(574.5f, 72.8f, 579.1f, 86.3f, 573.9f, 97.8f)
                lineTo(436.8f, 402.6f)
                curveTo(439.0f, 404.9f, 441.1f, 407.3f, 443.1f, 409.7f)
                lineTo(540.3f, 355.0f)
                curveTo(550.8f, 349.1f, 563.9f, 351.9f, 571.2f, 361.4f)
                curveTo(578.5f, 370.9f, 577.5f, 384.4f, 569.0f, 392.9f)
                lineTo(482.0f, 479.9f)
                lineTo(410.6f, 479.9f)
                curveTo(397.4f, 442.6f, 361.9f, 415.9f, 320.1f, 415.9f)
                curveTo(278.3f, 415.9f, 242.7f, 442.6f, 229.6f, 479.9f)
                lineTo(150.0f, 479.9f)
                lineTo(74.5f, 427.6f)
                curveTo(64.6f, 421.0f, 61.2f, 408.1f, 66.4f, 397.5f)
                curveTo(71.6f, 386.9f, 83.8f, 381.6f, 95.1f, 385.1f)
                lineTo(192.3f, 415.5f)
                curveTo(195.3f, 411.6f, 198.4f, 407.9f, 201.7f, 404.2f)
                lineTo(139.4f, 300.3f)
                curveTo(133.3f, 290.2f, 135.5f, 277.2f, 144.5f, 269.6f)
                curveTo(153.5f, 262.0f, 166.7f, 262.1f, 175.6f, 269.7f)
                lineTo(278.0f, 357.6f)
                curveTo(279.5f, 357.2f, 281.0f, 356.8f, 282.5f, 356.5f)
                lineTo(296.1f, 213.8f)
                curveTo(297.3f, 201.5f, 307.6f, 192.1f, 320.0f, 192.1f)
                close()
                moveTo(96.0f, 528.0f)
                lineTo(552.0f, 528.0f)
                curveTo(565.3f, 528.0f, 576.0f, 538.7f, 576.0f, 552.0f)
                curveTo(576.0f, 565.3f, 565.3f, 576.0f, 552.0f, 576.0f)
                lineTo(88.0f, 576.0f)
                curveTo(74.7f, 576.0f, 64.0f, 565.3f, 64.0f, 552.0f)
                curveTo(64.0f, 538.7f, 74.7f, 528.0f, 88.0f, 528.0f)
                lineTo(96.0f, 528.0f)
                close()
            }
        }
        .build()
        return _explosion!!
    }

private var _explosion: ImageVector? = null
