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

public val Fa.Mound: ImageVector
    get() {
        if (_mound != null) {
            return _mound!!
        }
        _mound = Builder(name = "Mound", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(176.4f, 243.2f)
                curveTo(206.0f, 191.7f, 260.8f, 160.0f, 320.2f, 160.0f)
                curveTo(379.6f, 160.0f, 434.4f, 191.7f, 464.1f, 243.2f)
                lineTo(572.7f, 432.0f)
                curveTo(585.0f, 453.3f, 569.6f, 480.0f, 545.0f, 480.0f)
                lineTo(95.5f, 480.0f)
                curveTo(70.9f, 480.0f, 55.5f, 453.4f, 67.8f, 432.0f)
                lineTo(176.4f, 243.2f)
                close()
            }
        }
        .build()
        return _mound!!
    }

private var _mound: ImageVector? = null
