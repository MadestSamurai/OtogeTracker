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

public val Fa.Sailboat: ImageVector
    get() {
        if (_sailboat != null) {
            return _sailboat!!
        }
        _sailboat = Builder(name = "Sailboat", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(304.0f, 99.9f)
                lineTo(304.0f, 448.0f)
                lineTo(80.0f, 448.0f)
                curveTo(71.2f, 448.0f, 64.0f, 455.2f, 64.0f, 464.0f)
                curveTo(64.0f, 525.9f, 114.1f, 576.0f, 176.0f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(525.9f, 576.0f, 576.0f, 525.9f, 576.0f, 464.0f)
                curveTo(576.0f, 455.2f, 568.8f, 448.0f, 560.0f, 448.0f)
                lineTo(352.0f, 448.0f)
                lineTo(352.0f, 400.0f)
                lineTo(513.7f, 400.0f)
                curveTo(526.6f, 400.0f, 534.2f, 385.6f, 526.9f, 375.0f)
                lineTo(333.2f, 90.9f)
                curveTo(324.3f, 77.9f, 304.0f, 84.2f, 304.0f, 99.9f)
                close()
                moveTo(256.0f, 384.0f)
                lineTo(256.0f, 199.8f)
                curveTo(256.0f, 183.7f, 235.0f, 177.7f, 226.4f, 191.3f)
                lineTo(111.3f, 375.5f)
                curveTo(104.6f, 386.2f, 112.3f, 400.0f, 124.9f, 400.0f)
                lineTo(240.0f, 400.0f)
                curveTo(248.8f, 400.0f, 256.0f, 392.8f, 256.0f, 384.0f)
                close()
            }
        }
        .build()
        return _sailboat!!
    }

private var _sailboat: ImageVector? = null
