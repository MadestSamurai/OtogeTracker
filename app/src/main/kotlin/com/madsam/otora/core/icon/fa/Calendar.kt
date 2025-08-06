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

public val Fa.Calendar: ImageVector
    get() {
        if (_calendar != null) {
            return _calendar!!
        }
        _calendar = Builder(name = "Calendar", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 64.0f)
                curveTo(206.3f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                lineTo(192.0f, 128.0f)
                lineTo(160.0f, 128.0f)
                curveTo(124.7f, 128.0f, 96.0f, 156.7f, 96.0f, 192.0f)
                lineTo(96.0f, 240.0f)
                lineTo(544.0f, 240.0f)
                lineTo(544.0f, 192.0f)
                curveTo(544.0f, 156.7f, 515.3f, 128.0f, 480.0f, 128.0f)
                lineTo(448.0f, 128.0f)
                lineTo(448.0f, 96.0f)
                curveTo(448.0f, 78.3f, 433.7f, 64.0f, 416.0f, 64.0f)
                curveTo(398.3f, 64.0f, 384.0f, 78.3f, 384.0f, 96.0f)
                lineTo(384.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                lineTo(256.0f, 96.0f)
                curveTo(256.0f, 78.3f, 241.7f, 64.0f, 224.0f, 64.0f)
                close()
                moveTo(96.0f, 288.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 288.0f)
                lineTo(96.0f, 288.0f)
                close()
            }
        }
        .build()
        return _calendar!!
    }

private var _calendar: ImageVector? = null
