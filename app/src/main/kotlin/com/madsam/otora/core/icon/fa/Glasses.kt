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

public val Fa.Glasses: ImageVector
    get() {
        if (_glasses != null) {
            return _glasses!!
        }
        _glasses = Builder(name = "Glasses", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(175.3f, 160.0f)
                curveTo(161.3f, 160.0f, 148.8f, 169.2f, 144.7f, 182.6f)
                lineTo(102.4f, 320.0f)
                lineTo(256.0f, 320.0f)
                curveTo(273.7f, 320.0f, 288.0f, 334.3f, 288.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                curveTo(352.0f, 334.3f, 366.3f, 320.0f, 384.0f, 320.0f)
                lineTo(537.6f, 320.0f)
                lineTo(495.3f, 182.6f)
                curveTo(491.2f, 169.2f, 478.8f, 160.0f, 464.7f, 160.0f)
                lineTo(432.0f, 160.0f)
                curveTo(414.3f, 160.0f, 400.0f, 145.7f, 400.0f, 128.0f)
                curveTo(400.0f, 110.3f, 414.3f, 96.0f, 432.0f, 96.0f)
                lineTo(464.7f, 96.0f)
                curveTo(506.8f, 96.0f, 544.1f, 123.5f, 556.5f, 163.8f)
                lineTo(601.9f, 311.3f)
                curveTo(606.0f, 324.5f, 608.0f, 338.2f, 608.0f, 352.0f)
                lineTo(608.0f, 448.0f)
                curveTo(608.0f, 501.0f, 565.0f, 544.0f, 512.0f, 544.0f)
                lineTo(448.0f, 544.0f)
                curveTo(395.0f, 544.0f, 352.0f, 501.0f, 352.0f, 448.0f)
                lineTo(352.0f, 416.0f)
                lineTo(288.0f, 416.0f)
                lineTo(288.0f, 448.0f)
                curveTo(288.0f, 501.0f, 245.0f, 544.0f, 192.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(75.0f, 544.0f, 32.0f, 501.0f, 32.0f, 448.0f)
                lineTo(32.0f, 352.0f)
                curveTo(32.0f, 338.2f, 34.1f, 324.5f, 38.1f, 311.3f)
                lineTo(83.5f, 163.8f)
                curveTo(95.9f, 123.5f, 133.1f, 96.0f, 175.3f, 96.0f)
                lineTo(208.0f, 96.0f)
                curveTo(225.7f, 96.0f, 240.0f, 110.3f, 240.0f, 128.0f)
                curveTo(240.0f, 145.7f, 225.7f, 160.0f, 208.0f, 160.0f)
                lineTo(175.3f, 160.0f)
                close()
                moveTo(96.0f, 384.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 465.7f, 110.3f, 480.0f, 128.0f, 480.0f)
                lineTo(192.0f, 480.0f)
                curveTo(209.7f, 480.0f, 224.0f, 465.7f, 224.0f, 448.0f)
                lineTo(224.0f, 384.0f)
                lineTo(96.0f, 384.0f)
                close()
                moveTo(512.0f, 480.0f)
                curveTo(529.7f, 480.0f, 544.0f, 465.7f, 544.0f, 448.0f)
                lineTo(544.0f, 384.0f)
                lineTo(416.0f, 384.0f)
                lineTo(416.0f, 448.0f)
                curveTo(416.0f, 465.7f, 430.3f, 480.0f, 448.0f, 480.0f)
                lineTo(512.0f, 480.0f)
                close()
            }
        }
        .build()
        return _glasses!!
    }

private var _glasses: ImageVector? = null
