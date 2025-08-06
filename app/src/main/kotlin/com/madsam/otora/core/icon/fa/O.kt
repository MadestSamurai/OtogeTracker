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

public val Fa.O: ImageVector
    get() {
        if (_o != null) {
            return _o!!
        }
        _o = Builder(name = "O", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 160.0f)
                curveTo(231.6f, 160.0f, 160.0f, 231.6f, 160.0f, 320.0f)
                curveTo(160.0f, 408.4f, 231.6f, 480.0f, 320.0f, 480.0f)
                curveTo(408.4f, 480.0f, 480.0f, 408.4f, 480.0f, 320.0f)
                curveTo(480.0f, 231.6f, 408.4f, 160.0f, 320.0f, 160.0f)
                close()
                moveTo(544.0f, 320.0f)
                curveTo(544.0f, 443.7f, 443.7f, 544.0f, 320.0f, 544.0f)
                curveTo(196.3f, 544.0f, 96.0f, 443.7f, 96.0f, 320.0f)
                curveTo(96.0f, 196.3f, 196.3f, 96.0f, 320.0f, 96.0f)
                curveTo(443.7f, 96.0f, 544.0f, 196.3f, 544.0f, 320.0f)
                close()
            }
        }
        .build()
        return _o!!
    }

private var _o: ImageVector? = null
