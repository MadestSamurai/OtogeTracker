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

public val Fa.Filter: ImageVector
    get() {
        if (_filter != null) {
            return _filter!!
        }
        _filter = Builder(name = "Filter", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(83.1f, 128.0f, 71.4f, 135.8f, 66.4f, 147.8f)
                curveTo(61.4f, 159.8f, 64.2f, 173.5f, 73.4f, 182.6f)
                lineTo(256.0f, 365.3f)
                lineTo(256.0f, 480.0f)
                curveTo(256.0f, 488.5f, 259.4f, 496.6f, 265.4f, 502.6f)
                lineTo(329.4f, 566.6f)
                curveTo(338.6f, 575.8f, 352.3f, 578.5f, 364.3f, 573.5f)
                curveTo(376.3f, 568.5f, 384.0f, 556.9f, 384.0f, 544.0f)
                lineTo(384.0f, 365.3f)
                lineTo(566.6f, 182.7f)
                curveTo(575.8f, 173.5f, 578.5f, 159.8f, 573.5f, 147.8f)
                curveTo(568.5f, 135.8f, 556.9f, 128.0f, 544.0f, 128.0f)
                lineTo(96.0f, 128.0f)
                close()
            }
        }
        .build()
        return _filter!!
    }

private var _filter: ImageVector? = null
