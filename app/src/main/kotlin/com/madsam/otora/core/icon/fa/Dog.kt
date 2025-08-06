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

public val Fa.Dog: ImageVector
    get() {
        if (_dog != null) {
            return _dog!!
        }
        _dog = Builder(name = "Dog", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 176.0f)
                curveTo(80.6f, 176.0f, 94.2f, 188.6f, 95.8f, 204.7f)
                lineTo(96.1f, 211.3f)
                curveTo(97.8f, 227.4f, 111.4f, 240.0f, 128.0f, 240.0f)
                lineTo(307.1f, 240.0f)
                lineTo(448.0f, 300.4f)
                lineTo(448.0f, 544.0f)
                curveTo(448.0f, 561.7f, 433.7f, 576.0f, 416.0f, 576.0f)
                lineTo(384.0f, 576.0f)
                curveTo(366.3f, 576.0f, 352.0f, 561.7f, 352.0f, 544.0f)
                lineTo(352.0f, 412.7f)
                curveTo(328.0f, 425.0f, 300.8f, 432.0f, 272.0f, 432.0f)
                curveTo(243.2f, 432.0f, 216.0f, 425.0f, 192.0f, 412.7f)
                lineTo(192.0f, 544.0f)
                curveTo(192.0f, 561.7f, 177.7f, 576.0f, 160.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(110.3f, 576.0f, 96.0f, 561.7f, 96.0f, 544.0f)
                lineTo(96.0f, 298.4f)
                curveTo(58.7f, 285.2f, 32.0f, 249.8f, 32.0f, 208.0f)
                curveTo(32.0f, 190.3f, 46.3f, 176.0f, 64.0f, 176.0f)
                close()
                moveTo(387.8f, 32.0f)
                curveTo(395.5f, 32.0f, 402.7f, 35.6f, 407.4f, 41.8f)
                lineTo(424.0f, 64.0f)
                lineTo(476.1f, 64.0f)
                curveTo(488.8f, 64.0f, 501.0f, 69.1f, 510.0f, 78.1f)
                lineTo(528.0f, 96.0f)
                lineTo(584.0f, 96.0f)
                curveTo(597.3f, 96.0f, 608.0f, 106.7f, 608.0f, 120.0f)
                lineTo(608.0f, 144.0f)
                curveTo(608.0f, 188.2f, 572.2f, 224.0f, 528.0f, 224.0f)
                lineTo(464.0f, 224.0f)
                lineTo(457.0f, 252.0f)
                lineTo(332.3f, 198.6f)
                lineTo(363.9f, 51.4f)
                curveTo(366.3f, 40.1f, 376.2f, 32.0f, 387.8f, 32.0f)
                close()
                moveTo(480.0f, 108.0f)
                curveTo(469.0f, 108.0f, 460.0f, 117.0f, 460.0f, 128.0f)
                curveTo(460.0f, 139.0f, 469.0f, 148.0f, 480.0f, 148.0f)
                curveTo(491.0f, 148.0f, 500.0f, 139.0f, 500.0f, 128.0f)
                curveTo(500.0f, 117.0f, 491.0f, 108.0f, 480.0f, 108.0f)
                close()
            }
        }
        .build()
        return _dog!!
    }

private var _dog: ImageVector? = null
