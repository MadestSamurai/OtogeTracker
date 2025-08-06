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

public val Fa.Coins: ImageVector
    get() {
        if (_coins != null) {
            return _coins!!
        }
        _coins = Builder(name = "Coins", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 160.0f)
                lineTo(192.0f, 144.0f)
                curveTo(192.0f, 99.8f, 278.0f, 64.0f, 384.0f, 64.0f)
                curveTo(490.0f, 64.0f, 576.0f, 99.8f, 576.0f, 144.0f)
                lineTo(576.0f, 160.0f)
                curveTo(576.0f, 190.6f, 534.7f, 217.2f, 474.0f, 230.7f)
                curveTo(471.6f, 227.9f, 469.1f, 225.2f, 466.6f, 222.7f)
                curveTo(451.1f, 207.4f, 431.1f, 195.8f, 410.2f, 187.2f)
                curveTo(368.3f, 169.7f, 313.7f, 160.1f, 256.0f, 160.1f)
                curveTo(234.1f, 160.1f, 212.7f, 161.5f, 192.2f, 164.2f)
                curveTo(192.0f, 162.9f, 192.0f, 161.5f, 192.0f, 160.1f)
                close()
                moveTo(496.0f, 417.0f)
                lineTo(496.0f, 370.8f)
                curveTo(511.1f, 366.9f, 525.3f, 362.3f, 538.2f, 356.9f)
                curveTo(551.4f, 351.4f, 564.3f, 344.7f, 576.0f, 336.6f)
                lineTo(576.0f, 352.0f)
                curveTo(576.0f, 378.8f, 544.5f, 402.5f, 496.0f, 417.0f)
                close()
                moveTo(496.0f, 321.0f)
                lineTo(496.0f, 288.0f)
                curveTo(496.0f, 283.5f, 495.6f, 279.2f, 495.0f, 275.0f)
                curveTo(510.5f, 271.1f, 525.0f, 266.4f, 538.2f, 260.8f)
                curveTo(551.4f, 255.2f, 564.3f, 248.6f, 576.0f, 240.5f)
                lineTo(576.0f, 255.9f)
                curveTo(576.0f, 282.7f, 544.5f, 306.4f, 496.0f, 320.9f)
                close()
                moveTo(64.0f, 304.0f)
                lineTo(64.0f, 288.0f)
                curveTo(64.0f, 243.8f, 150.0f, 208.0f, 256.0f, 208.0f)
                curveTo(362.0f, 208.0f, 448.0f, 243.8f, 448.0f, 288.0f)
                lineTo(448.0f, 304.0f)
                curveTo(448.0f, 348.2f, 362.0f, 384.0f, 256.0f, 384.0f)
                curveTo(150.0f, 384.0f, 64.0f, 348.2f, 64.0f, 304.0f)
                close()
                moveTo(448.0f, 400.0f)
                curveTo(448.0f, 444.2f, 362.0f, 480.0f, 256.0f, 480.0f)
                curveTo(150.0f, 480.0f, 64.0f, 444.2f, 64.0f, 400.0f)
                lineTo(64.0f, 384.6f)
                curveTo(75.6f, 392.7f, 88.5f, 399.3f, 101.8f, 404.9f)
                curveTo(143.7f, 422.4f, 198.3f, 432.0f, 256.0f, 432.0f)
                curveTo(313.7f, 432.0f, 368.3f, 422.3f, 410.2f, 404.9f)
                curveTo(423.4f, 399.4f, 436.3f, 392.7f, 448.0f, 384.6f)
                lineTo(448.0f, 400.0f)
                close()
                moveTo(448.0f, 480.6f)
                lineTo(448.0f, 496.0f)
                curveTo(448.0f, 540.2f, 362.0f, 576.0f, 256.0f, 576.0f)
                curveTo(150.0f, 576.0f, 64.0f, 540.2f, 64.0f, 496.0f)
                lineTo(64.0f, 480.6f)
                curveTo(75.6f, 488.7f, 88.5f, 495.3f, 101.8f, 500.9f)
                curveTo(143.7f, 518.4f, 198.3f, 528.0f, 256.0f, 528.0f)
                curveTo(313.7f, 528.0f, 368.3f, 518.3f, 410.2f, 500.9f)
                curveTo(423.4f, 495.4f, 436.3f, 488.7f, 448.0f, 480.6f)
                close()
            }
        }
        .build()
        return _coins!!
    }

private var _coins: ImageVector? = null
