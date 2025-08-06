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

public val Fa.Dumpster: ImageVector
    get() {
        if (_dumpster != null) {
            return _dumpster!!
        }
        _dumpster = Builder(name = "Dumpster", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(164.3f, 128.0f)
                lineTo(138.7f, 256.0f)
                lineTo(56.0f, 256.0f)
                curveTo(42.7f, 256.0f, 32.0f, 245.3f, 32.0f, 232.0f)
                lineTo(32.0f, 227.9f)
                curveTo(32.0f, 225.3f, 32.4f, 222.8f, 33.2f, 220.3f)
                lineTo(58.5f, 144.4f)
                curveTo(61.8f, 134.6f, 71.0f, 128.0f, 81.3f, 128.0f)
                lineTo(164.3f, 128.0f)
                close()
                moveTo(187.7f, 256.0f)
                lineTo(213.3f, 128.0f)
                lineTo(296.0f, 128.0f)
                lineTo(296.0f, 256.0f)
                lineTo(187.7f, 256.0f)
                close()
                moveTo(344.0f, 128.0f)
                lineTo(426.7f, 128.0f)
                lineTo(452.3f, 256.0f)
                lineTo(344.0f, 256.0f)
                lineTo(344.0f, 128.0f)
                close()
                moveTo(475.7f, 128.0f)
                lineTo(558.7f, 128.0f)
                curveTo(569.0f, 128.0f, 578.2f, 134.6f, 581.5f, 144.4f)
                lineTo(606.8f, 220.3f)
                curveTo(607.6f, 222.7f, 608.0f, 225.3f, 608.0f, 227.9f)
                lineTo(608.0f, 232.0f)
                curveTo(608.0f, 245.3f, 597.3f, 256.0f, 584.0f, 256.0f)
                lineTo(501.3f, 256.0f)
                lineTo(475.7f, 128.0f)
                close()
                moveTo(57.7f, 304.0f)
                lineTo(582.4f, 304.0f)
                curveTo(582.0f, 306.1f, 569.1f, 377.4f, 543.5f, 517.7f)
                curveTo(540.5f, 534.0f, 525.6f, 545.3f, 509.1f, 543.8f)
                curveTo(492.6f, 542.3f, 480.0f, 528.6f, 480.0f, 512.0f)
                lineTo(480.0f, 496.0f)
                lineTo(160.0f, 496.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 528.6f, 147.4f, 542.4f, 130.9f, 543.9f)
                curveTo(114.4f, 545.4f, 99.5f, 534.0f, 96.5f, 517.7f)
                curveTo(71.0f, 377.3f, 58.0f, 306.1f, 57.7f, 304.0f)
                close()
            }
        }
        .build()
        return _dumpster!!
    }

private var _dumpster: ImageVector? = null
