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

public val Fa.Male: ImageVector
    get() {
        if (_male != null) {
            return _male!!
        }
        _male = Builder(name = "Male", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(376.0f, 88.0f)
                curveTo(376.0f, 57.1f, 350.9f, 32.0f, 320.0f, 32.0f)
                curveTo(289.1f, 32.0f, 264.0f, 57.1f, 264.0f, 88.0f)
                curveTo(264.0f, 118.9f, 289.1f, 144.0f, 320.0f, 144.0f)
                curveTo(350.9f, 144.0f, 376.0f, 118.9f, 376.0f, 88.0f)
                close()
                moveTo(400.0f, 300.7f)
                lineTo(446.3f, 363.1f)
                curveTo(456.8f, 377.3f, 476.9f, 380.3f, 491.1f, 369.7f)
                curveTo(505.3f, 359.1f, 508.3f, 339.1f, 497.7f, 324.9f)
                lineTo(427.2f, 229.9f)
                curveTo(402.0f, 196.0f, 362.3f, 176.0f, 320.0f, 176.0f)
                curveTo(277.7f, 176.0f, 238.0f, 196.0f, 212.8f, 229.9f)
                lineTo(142.3f, 324.9f)
                curveTo(131.8f, 339.1f, 134.7f, 359.1f, 148.9f, 369.7f)
                curveTo(163.1f, 380.3f, 183.1f, 377.3f, 193.7f, 363.1f)
                lineTo(240.0f, 300.7f)
                lineTo(240.0f, 576.0f)
                curveTo(240.0f, 593.7f, 254.3f, 608.0f, 272.0f, 608.0f)
                curveTo(289.7f, 608.0f, 304.0f, 593.7f, 304.0f, 576.0f)
                lineTo(304.0f, 416.0f)
                curveTo(304.0f, 407.2f, 311.2f, 400.0f, 320.0f, 400.0f)
                curveTo(328.8f, 400.0f, 336.0f, 407.2f, 336.0f, 416.0f)
                lineTo(336.0f, 576.0f)
                curveTo(336.0f, 593.7f, 350.3f, 608.0f, 368.0f, 608.0f)
                curveTo(385.7f, 608.0f, 400.0f, 593.7f, 400.0f, 576.0f)
                lineTo(400.0f, 300.7f)
                close()
            }
        }
        .build()
        return _male!!
    }

private var _male: ImageVector? = null
