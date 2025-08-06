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

public val Fa.Heart: ImageVector
    get() {
        if (_heart != null) {
            return _heart!!
        }
        _heart = Builder(name = "Heart", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(305.0f, 151.1f)
                lineTo(320.0f, 171.8f)
                lineTo(335.0f, 151.1f)
                curveTo(360.0f, 116.5f, 400.2f, 96.0f, 442.9f, 96.0f)
                curveTo(516.4f, 96.0f, 576.0f, 155.6f, 576.0f, 229.1f)
                lineTo(576.0f, 231.7f)
                curveTo(576.0f, 343.9f, 436.1f, 474.2f, 363.1f, 529.9f)
                curveTo(350.7f, 539.3f, 335.5f, 544.0f, 320.0f, 544.0f)
                curveTo(304.5f, 544.0f, 289.2f, 539.4f, 276.9f, 529.9f)
                curveTo(203.9f, 474.2f, 64.0f, 343.9f, 64.0f, 231.7f)
                lineTo(64.0f, 229.1f)
                curveTo(64.0f, 155.6f, 123.6f, 96.0f, 197.1f, 96.0f)
                curveTo(239.8f, 96.0f, 280.0f, 116.5f, 305.0f, 151.1f)
                close()
            }
        }
        .build()
        return _heart!!
    }

private var _heart: ImageVector? = null
