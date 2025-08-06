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

public val Fa.Truck: ImageVector
    get() {
        if (_truck != null) {
            return _truck!!
        }
        _truck = Builder(name = "Truck", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(384.0f, 96.0f)
                curveTo(419.3f, 96.0f, 448.0f, 124.7f, 448.0f, 160.0f)
                lineTo(448.0f, 192.0f)
                lineTo(498.7f, 192.0f)
                curveTo(515.7f, 192.0f, 532.0f, 198.7f, 544.0f, 210.7f)
                lineTo(589.3f, 256.0f)
                curveTo(601.3f, 268.0f, 608.0f, 284.3f, 608.0f, 301.3f)
                lineTo(608.0f, 448.0f)
                curveTo(608.0f, 483.3f, 579.3f, 512.0f, 544.0f, 512.0f)
                lineTo(540.7f, 512.0f)
                curveTo(530.3f, 548.9f, 496.3f, 576.0f, 456.0f, 576.0f)
                curveTo(415.7f, 576.0f, 381.8f, 548.9f, 371.3f, 512.0f)
                lineTo(268.7f, 512.0f)
                curveTo(258.3f, 548.9f, 224.3f, 576.0f, 184.0f, 576.0f)
                curveTo(143.7f, 576.0f, 109.8f, 548.9f, 99.3f, 512.0f)
                lineTo(96.0f, 512.0f)
                curveTo(60.7f, 512.0f, 32.0f, 483.3f, 32.0f, 448.0f)
                lineTo(32.0f, 160.0f)
                close()
                moveTo(544.0f, 352.0f)
                lineTo(544.0f, 301.3f)
                lineTo(498.7f, 256.0f)
                lineTo(448.0f, 256.0f)
                lineTo(448.0f, 352.0f)
                lineTo(544.0f, 352.0f)
                close()
                moveTo(224.0f, 488.0f)
                curveTo(224.0f, 465.9f, 206.1f, 448.0f, 184.0f, 448.0f)
                curveTo(161.9f, 448.0f, 144.0f, 465.9f, 144.0f, 488.0f)
                curveTo(144.0f, 510.1f, 161.9f, 528.0f, 184.0f, 528.0f)
                curveTo(206.1f, 528.0f, 224.0f, 510.1f, 224.0f, 488.0f)
                close()
                moveTo(456.0f, 528.0f)
                curveTo(478.1f, 528.0f, 496.0f, 510.1f, 496.0f, 488.0f)
                curveTo(496.0f, 465.9f, 478.1f, 448.0f, 456.0f, 448.0f)
                curveTo(433.9f, 448.0f, 416.0f, 465.9f, 416.0f, 488.0f)
                curveTo(416.0f, 510.1f, 433.9f, 528.0f, 456.0f, 528.0f)
                close()
            }
        }
        .build()
        return _truck!!
    }

private var _truck: ImageVector? = null
