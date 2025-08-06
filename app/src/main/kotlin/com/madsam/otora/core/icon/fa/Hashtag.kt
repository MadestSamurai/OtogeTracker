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

public val Fa.Hashtag: ImageVector
    get() {
        if (_hashtag != null) {
            return _hashtag!!
        }
        _hashtag = Builder(name = "Hashtag", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(278.7f, 64.7f)
                curveTo(296.0f, 68.4f, 307.0f, 85.4f, 303.3f, 102.7f)
                lineTo(284.2f, 192.0f)
                lineTo(410.7f, 192.0f)
                lineTo(432.7f, 89.3f)
                curveTo(436.4f, 72.0f, 453.4f, 61.0f, 470.7f, 64.7f)
                curveTo(488.0f, 68.4f, 499.0f, 85.4f, 495.3f, 102.7f)
                lineTo(476.2f, 192.0f)
                lineTo(544.0f, 192.0f)
                curveTo(561.7f, 192.0f, 576.0f, 206.3f, 576.0f, 224.0f)
                curveTo(576.0f, 241.7f, 561.7f, 256.0f, 544.0f, 256.0f)
                lineTo(462.4f, 256.0f)
                lineTo(435.0f, 384.0f)
                lineTo(502.8f, 384.0f)
                curveTo(520.5f, 384.0f, 534.8f, 398.3f, 534.8f, 416.0f)
                curveTo(534.8f, 433.7f, 520.5f, 448.0f, 502.8f, 448.0f)
                lineTo(421.2f, 448.0f)
                lineTo(399.2f, 550.7f)
                curveTo(395.5f, 568.0f, 378.5f, 579.0f, 361.2f, 575.3f)
                curveTo(343.9f, 571.6f, 332.9f, 554.6f, 336.6f, 537.3f)
                lineTo(355.7f, 448.0f)
                lineTo(229.2f, 448.0f)
                lineTo(207.2f, 550.7f)
                curveTo(203.5f, 568.0f, 186.5f, 579.0f, 169.2f, 575.3f)
                curveTo(151.9f, 571.6f, 140.9f, 554.6f, 144.6f, 537.3f)
                lineTo(163.8f, 448.0f)
                lineTo(96.0f, 448.0f)
                curveTo(78.3f, 448.0f, 64.0f, 433.7f, 64.0f, 416.0f)
                curveTo(64.0f, 398.3f, 78.3f, 384.0f, 96.0f, 384.0f)
                lineTo(177.6f, 384.0f)
                lineTo(205.0f, 256.0f)
                lineTo(137.2f, 256.0f)
                curveTo(119.5f, 256.0f, 105.2f, 241.7f, 105.2f, 224.0f)
                curveTo(105.2f, 206.3f, 119.5f, 192.0f, 137.2f, 192.0f)
                lineTo(218.8f, 192.0f)
                lineTo(240.8f, 89.3f)
                curveTo(244.4f, 72.0f, 261.4f, 61.0f, 278.7f, 64.7f)
                close()
                moveTo(270.4f, 256.0f)
                lineTo(243.0f, 384.0f)
                lineTo(369.5f, 384.0f)
                lineTo(396.9f, 256.0f)
                lineTo(270.4f, 256.0f)
                close()
            }
        }
        .build()
        return _hashtag!!
    }

private var _hashtag: ImageVector? = null
