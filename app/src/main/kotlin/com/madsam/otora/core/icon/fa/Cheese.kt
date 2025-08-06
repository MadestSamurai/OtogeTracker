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

public val Fa.Cheese: ImageVector
    get() {
        if (_cheese != null) {
            return _cheese!!
        }
        _cheese = Builder(name = "Cheese", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 304.2f)
                lineTo(576.0f, 320.0f)
                lineTo(64.0f, 320.0f)
                curveTo(64.0f, 300.0f, 74.0f, 281.3f, 90.6f, 270.2f)
                lineTo(338.9f, 104.7f)
                curveTo(347.5f, 99.0f, 357.5f, 96.0f, 367.8f, 96.0f)
                curveTo(482.8f, 96.0f, 576.0f, 189.2f, 576.0f, 304.2f)
                close()
                moveTo(576.0f, 368.0f)
                lineTo(576.0f, 480.0f)
                curveTo(576.0f, 515.3f, 547.3f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                lineTo(64.0f, 368.0f)
                lineTo(576.0f, 368.0f)
                close()
            }
        }
        .build()
        return _cheese!!
    }

private var _cheese: ImageVector? = null
