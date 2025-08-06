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

public val Fa.Comments: ImageVector
    get() {
        if (_comments != null) {
            return _comments!!
        }
        _comments = Builder(name = "Comments", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 208.0f)
                curveTo(416.0f, 305.2f, 330.0f, 384.0f, 224.0f, 384.0f)
                curveTo(197.3f, 384.0f, 171.9f, 379.0f, 148.8f, 370.0f)
                lineTo(67.2f, 413.2f)
                curveTo(57.9f, 418.1f, 46.5f, 416.4f, 39.0f, 409.0f)
                curveTo(31.5f, 401.6f, 29.8f, 390.1f, 34.8f, 380.8f)
                lineTo(70.4f, 313.6f)
                curveTo(46.3f, 284.2f, 32.0f, 247.6f, 32.0f, 208.0f)
                curveTo(32.0f, 110.8f, 118.0f, 32.0f, 224.0f, 32.0f)
                curveTo(330.0f, 32.0f, 416.0f, 110.8f, 416.0f, 208.0f)
                close()
                moveTo(416.0f, 576.0f)
                curveTo(321.9f, 576.0f, 243.6f, 513.9f, 227.2f, 432.0f)
                curveTo(347.2f, 430.5f, 451.5f, 345.1f, 463.0f, 229.3f)
                curveTo(546.3f, 248.5f, 608.0f, 317.6f, 608.0f, 400.0f)
                curveTo(608.0f, 439.6f, 593.7f, 476.2f, 569.6f, 505.6f)
                lineTo(605.2f, 572.8f)
                curveTo(610.1f, 582.1f, 608.4f, 593.5f, 601.0f, 601.0f)
                curveTo(593.6f, 608.5f, 582.1f, 610.2f, 572.8f, 605.2f)
                lineTo(491.2f, 562.0f)
                curveTo(468.1f, 571.0f, 442.7f, 576.0f, 416.0f, 576.0f)
                close()
            }
        }
        .build()
        return _comments!!
    }

private var _comments: ImageVector? = null
