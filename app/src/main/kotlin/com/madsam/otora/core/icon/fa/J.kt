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

public val Fa.J: ImageVector
    get() {
        if (_j != null) {
            return _j!!
        }
        _j = Builder(name = "J", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 96.0f)
                curveTo(465.7f, 96.0f, 480.0f, 110.3f, 480.0f, 128.0f)
                lineTo(480.0f, 384.0f)
                curveTo(480.0f, 472.4f, 408.4f, 544.0f, 320.0f, 544.0f)
                curveTo(231.6f, 544.0f, 160.0f, 472.4f, 160.0f, 384.0f)
                lineTo(160.0f, 352.0f)
                curveTo(160.0f, 334.3f, 174.3f, 320.0f, 192.0f, 320.0f)
                curveTo(209.7f, 320.0f, 224.0f, 334.3f, 224.0f, 352.0f)
                lineTo(224.0f, 384.0f)
                curveTo(224.0f, 437.0f, 267.0f, 480.0f, 320.0f, 480.0f)
                curveTo(373.0f, 480.0f, 416.0f, 437.0f, 416.0f, 384.0f)
                lineTo(416.0f, 128.0f)
                curveTo(416.0f, 110.3f, 430.3f, 96.0f, 448.0f, 96.0f)
                close()
            }
        }
        .build()
        return _j!!
    }

private var _j: ImageVector? = null
