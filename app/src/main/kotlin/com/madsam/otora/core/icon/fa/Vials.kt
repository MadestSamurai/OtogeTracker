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

public val Fa.Vials: ImageVector
    get() {
        if (_vials != null) {
            return _vials!!
        }
        _vials = Builder(name = "Vials", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 64.0f)
                curveTo(78.3f, 64.0f, 64.0f, 78.3f, 64.0f, 96.0f)
                curveTo(64.0f, 113.7f, 78.3f, 128.0f, 96.0f, 128.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 533.0f, 139.0f, 576.0f, 192.0f, 576.0f)
                curveTo(245.0f, 576.0f, 288.0f, 533.0f, 288.0f, 480.0f)
                lineTo(288.0f, 128.0f)
                lineTo(352.0f, 128.0f)
                lineTo(352.0f, 480.0f)
                curveTo(352.0f, 533.0f, 395.0f, 576.0f, 448.0f, 576.0f)
                curveTo(501.0f, 576.0f, 544.0f, 533.0f, 544.0f, 480.0f)
                lineTo(544.0f, 128.0f)
                curveTo(561.7f, 128.0f, 576.0f, 113.7f, 576.0f, 96.0f)
                curveTo(576.0f, 78.3f, 561.7f, 64.0f, 544.0f, 64.0f)
                lineTo(96.0f, 64.0f)
                close()
                moveTo(224.0f, 128.0f)
                lineTo(224.0f, 256.0f)
                lineTo(160.0f, 256.0f)
                lineTo(160.0f, 128.0f)
                lineTo(224.0f, 128.0f)
                close()
                moveTo(480.0f, 128.0f)
                lineTo(480.0f, 256.0f)
                lineTo(416.0f, 256.0f)
                lineTo(416.0f, 128.0f)
                lineTo(480.0f, 128.0f)
                close()
            }
        }
        .build()
        return _vials!!
    }

private var _vials: ImageVector? = null
