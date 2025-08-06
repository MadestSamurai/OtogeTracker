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

public val Fa.Magnet: ImageVector
    get() {
        if (_magnet != null) {
            return _magnet!!
        }
        _magnet = Builder(name = "Magnet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 240.0f)
                lineTo(96.0f, 352.0f)
                curveTo(96.0f, 475.7f, 196.3f, 576.0f, 320.0f, 576.0f)
                curveTo(443.7f, 576.0f, 544.0f, 475.7f, 544.0f, 352.0f)
                lineTo(544.0f, 240.0f)
                lineTo(416.0f, 240.0f)
                lineTo(416.0f, 352.0f)
                curveTo(416.0f, 405.0f, 373.0f, 448.0f, 320.0f, 448.0f)
                curveTo(267.0f, 448.0f, 224.0f, 405.0f, 224.0f, 352.0f)
                lineTo(224.0f, 240.0f)
                lineTo(96.0f, 240.0f)
                close()
                moveTo(96.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                lineTo(224.0f, 128.0f)
                curveTo(224.0f, 110.3f, 209.7f, 96.0f, 192.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                curveTo(110.3f, 96.0f, 96.0f, 110.3f, 96.0f, 128.0f)
                lineTo(96.0f, 192.0f)
                close()
                moveTo(416.0f, 192.0f)
                lineTo(544.0f, 192.0f)
                lineTo(544.0f, 128.0f)
                curveTo(544.0f, 110.3f, 529.7f, 96.0f, 512.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(430.3f, 96.0f, 416.0f, 110.3f, 416.0f, 128.0f)
                lineTo(416.0f, 192.0f)
                close()
            }
        }
        .build()
        return _magnet!!
    }

private var _magnet: ImageVector? = null
