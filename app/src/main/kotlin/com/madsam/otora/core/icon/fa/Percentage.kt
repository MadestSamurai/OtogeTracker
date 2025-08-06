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

public val Fa.Percentage: ImageVector
    get() {
        if (_percentage != null) {
            return _percentage!!
        }
        _percentage = Builder(name = "Percentage", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 192.0f)
                curveTo(288.0f, 139.0f, 245.0f, 96.0f, 192.0f, 96.0f)
                curveTo(139.0f, 96.0f, 96.0f, 139.0f, 96.0f, 192.0f)
                curveTo(96.0f, 245.0f, 139.0f, 288.0f, 192.0f, 288.0f)
                curveTo(245.0f, 288.0f, 288.0f, 245.0f, 288.0f, 192.0f)
                close()
                moveTo(544.0f, 448.0f)
                curveTo(544.0f, 395.0f, 501.0f, 352.0f, 448.0f, 352.0f)
                curveTo(395.0f, 352.0f, 352.0f, 395.0f, 352.0f, 448.0f)
                curveTo(352.0f, 501.0f, 395.0f, 544.0f, 448.0f, 544.0f)
                curveTo(501.0f, 544.0f, 544.0f, 501.0f, 544.0f, 448.0f)
                close()
                moveTo(534.6f, 150.6f)
                curveTo(547.1f, 138.1f, 547.1f, 117.8f, 534.6f, 105.3f)
                curveTo(522.1f, 92.8f, 501.8f, 92.8f, 489.3f, 105.3f)
                lineTo(105.3f, 489.3f)
                curveTo(92.8f, 501.8f, 92.8f, 522.1f, 105.3f, 534.6f)
                curveTo(117.8f, 547.1f, 138.1f, 547.1f, 150.6f, 534.6f)
                lineTo(534.6f, 150.6f)
                close()
            }
        }
        .build()
        return _percentage!!
    }

private var _percentage: ImageVector? = null
