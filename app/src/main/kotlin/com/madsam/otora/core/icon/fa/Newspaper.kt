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

public val Fa.Newspaper: ImageVector
    get() {
        if (_newspaper != null) {
            return _newspaper!!
        }
        _newspaper = Builder(name = "Newspaper", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 480.0f)
                lineTo(64.0f, 184.0f)
                curveTo(64.0f, 170.7f, 74.7f, 160.0f, 88.0f, 160.0f)
                curveTo(101.3f, 160.0f, 112.0f, 170.7f, 112.0f, 184.0f)
                lineTo(112.0f, 472.0f)
                curveTo(112.0f, 485.3f, 122.7f, 496.0f, 136.0f, 496.0f)
                curveTo(149.3f, 496.0f, 160.0f, 485.3f, 160.0f, 472.0f)
                lineTo(160.0f, 160.0f)
                curveTo(160.0f, 124.7f, 188.7f, 96.0f, 224.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(547.3f, 96.0f, 576.0f, 124.7f, 576.0f, 160.0f)
                lineTo(576.0f, 480.0f)
                curveTo(576.0f, 515.3f, 547.3f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                close()
                moveTo(224.0f, 192.0f)
                lineTo(224.0f, 256.0f)
                curveTo(224.0f, 273.7f, 238.3f, 288.0f, 256.0f, 288.0f)
                lineTo(320.0f, 288.0f)
                curveTo(337.7f, 288.0f, 352.0f, 273.7f, 352.0f, 256.0f)
                lineTo(352.0f, 192.0f)
                curveTo(352.0f, 174.3f, 337.7f, 160.0f, 320.0f, 160.0f)
                lineTo(256.0f, 160.0f)
                curveTo(238.3f, 160.0f, 224.0f, 174.3f, 224.0f, 192.0f)
                close()
                moveTo(248.0f, 432.0f)
                curveTo(234.7f, 432.0f, 224.0f, 442.7f, 224.0f, 456.0f)
                curveTo(224.0f, 469.3f, 234.7f, 480.0f, 248.0f, 480.0f)
                lineTo(488.0f, 480.0f)
                curveTo(501.3f, 480.0f, 512.0f, 469.3f, 512.0f, 456.0f)
                curveTo(512.0f, 442.7f, 501.3f, 432.0f, 488.0f, 432.0f)
                lineTo(248.0f, 432.0f)
                close()
                moveTo(224.0f, 360.0f)
                curveTo(224.0f, 373.3f, 234.7f, 384.0f, 248.0f, 384.0f)
                lineTo(488.0f, 384.0f)
                curveTo(501.3f, 384.0f, 512.0f, 373.3f, 512.0f, 360.0f)
                curveTo(512.0f, 346.7f, 501.3f, 336.0f, 488.0f, 336.0f)
                lineTo(248.0f, 336.0f)
                curveTo(234.7f, 336.0f, 224.0f, 346.7f, 224.0f, 360.0f)
                close()
                moveTo(424.0f, 240.0f)
                curveTo(410.7f, 240.0f, 400.0f, 250.7f, 400.0f, 264.0f)
                curveTo(400.0f, 277.3f, 410.7f, 288.0f, 424.0f, 288.0f)
                lineTo(488.0f, 288.0f)
                curveTo(501.3f, 288.0f, 512.0f, 277.3f, 512.0f, 264.0f)
                curveTo(512.0f, 250.7f, 501.3f, 240.0f, 488.0f, 240.0f)
                lineTo(424.0f, 240.0f)
                close()
            }
        }
        .build()
        return _newspaper!!
    }

private var _newspaper: ImageVector? = null
