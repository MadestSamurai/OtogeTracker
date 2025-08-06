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

public val Fa.Bed: ImageVector
    get() {
        if (_bed != null) {
            return _bed!!
        }
        _bed = Builder(name = "Bed", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 96.0f)
                curveTo(81.7f, 96.0f, 96.0f, 110.3f, 96.0f, 128.0f)
                lineTo(96.0f, 352.0f)
                lineTo(320.0f, 352.0f)
                lineTo(320.0f, 224.0f)
                curveTo(320.0f, 206.3f, 334.3f, 192.0f, 352.0f, 192.0f)
                lineTo(512.0f, 192.0f)
                curveTo(565.0f, 192.0f, 608.0f, 235.0f, 608.0f, 288.0f)
                lineTo(608.0f, 512.0f)
                curveTo(608.0f, 529.7f, 593.7f, 544.0f, 576.0f, 544.0f)
                curveTo(558.3f, 544.0f, 544.0f, 529.7f, 544.0f, 512.0f)
                lineTo(544.0f, 448.0f)
                lineTo(96.0f, 448.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 529.7f, 81.7f, 544.0f, 64.0f, 544.0f)
                curveTo(46.3f, 544.0f, 32.0f, 529.7f, 32.0f, 512.0f)
                lineTo(32.0f, 128.0f)
                curveTo(32.0f, 110.3f, 46.3f, 96.0f, 64.0f, 96.0f)
                close()
                moveTo(144.0f, 256.0f)
                curveTo(144.0f, 220.7f, 172.7f, 192.0f, 208.0f, 192.0f)
                curveTo(243.3f, 192.0f, 272.0f, 220.7f, 272.0f, 256.0f)
                curveTo(272.0f, 291.3f, 243.3f, 320.0f, 208.0f, 320.0f)
                curveTo(172.7f, 320.0f, 144.0f, 291.3f, 144.0f, 256.0f)
                close()
            }
        }
        .build()
        return _bed!!
    }

private var _bed: ImageVector? = null
