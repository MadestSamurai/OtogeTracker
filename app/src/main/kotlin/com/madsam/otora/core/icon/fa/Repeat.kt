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

public val Fa.Repeat: ImageVector
    get() {
        if (_repeat != null) {
            return _repeat!!
        }
        _repeat = Builder(name = "Repeat", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(534.6f, 182.6f)
                curveTo(547.1f, 170.1f, 547.1f, 149.8f, 534.6f, 137.3f)
                lineTo(470.6f, 73.3f)
                curveTo(461.4f, 64.1f, 447.7f, 61.4f, 435.7f, 66.4f)
                curveTo(423.7f, 71.4f, 416.0f, 83.1f, 416.0f, 96.0f)
                lineTo(416.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                curveTo(150.0f, 128.0f, 64.0f, 214.0f, 64.0f, 320.0f)
                curveTo(64.0f, 337.7f, 78.3f, 352.0f, 96.0f, 352.0f)
                curveTo(113.7f, 352.0f, 128.0f, 337.7f, 128.0f, 320.0f)
                curveTo(128.0f, 249.3f, 185.3f, 192.0f, 256.0f, 192.0f)
                lineTo(416.0f, 192.0f)
                lineTo(416.0f, 224.0f)
                curveTo(416.0f, 236.9f, 423.8f, 248.6f, 435.8f, 253.6f)
                curveTo(447.8f, 258.6f, 461.5f, 255.8f, 470.7f, 246.7f)
                lineTo(534.7f, 182.7f)
                close()
                moveTo(105.4f, 457.4f)
                curveTo(92.9f, 469.9f, 92.9f, 490.2f, 105.4f, 502.7f)
                lineTo(169.4f, 566.7f)
                curveTo(178.6f, 575.9f, 192.3f, 578.6f, 204.3f, 573.6f)
                curveTo(216.3f, 568.6f, 224.0f, 556.9f, 224.0f, 544.0f)
                lineTo(224.0f, 512.0f)
                lineTo(384.0f, 512.0f)
                curveTo(490.0f, 512.0f, 576.0f, 426.0f, 576.0f, 320.0f)
                curveTo(576.0f, 302.3f, 561.7f, 288.0f, 544.0f, 288.0f)
                curveTo(526.3f, 288.0f, 512.0f, 302.3f, 512.0f, 320.0f)
                curveTo(512.0f, 390.7f, 454.7f, 448.0f, 384.0f, 448.0f)
                lineTo(224.0f, 448.0f)
                lineTo(224.0f, 416.0f)
                curveTo(224.0f, 403.1f, 216.2f, 391.4f, 204.2f, 386.4f)
                curveTo(192.2f, 381.4f, 178.5f, 384.2f, 169.3f, 393.3f)
                lineTo(105.3f, 457.3f)
                close()
            }
        }
        .build()
        return _repeat!!
    }

private var _repeat: ImageVector? = null
