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

public val Fa.Stethoscope: ImageVector
    get() {
        if (_stethoscope != null) {
            return _stethoscope!!
        }
        _stethoscope = Builder(name = "Stethoscope", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 112.0f)
                curveTo(64.0f, 85.5f, 85.5f, 64.0f, 112.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                curveTo(177.7f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                curveTo(192.0f, 113.7f, 177.7f, 128.0f, 160.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                lineTo(128.0f, 256.0f)
                curveTo(128.0f, 309.0f, 171.0f, 352.0f, 224.0f, 352.0f)
                curveTo(277.0f, 352.0f, 320.0f, 309.0f, 320.0f, 256.0f)
                lineTo(320.0f, 128.0f)
                lineTo(288.0f, 128.0f)
                curveTo(270.3f, 128.0f, 256.0f, 113.7f, 256.0f, 96.0f)
                curveTo(256.0f, 78.3f, 270.3f, 64.0f, 288.0f, 64.0f)
                lineTo(336.0f, 64.0f)
                curveTo(362.5f, 64.0f, 384.0f, 85.5f, 384.0f, 112.0f)
                lineTo(384.0f, 256.0f)
                curveTo(384.0f, 333.4f, 329.0f, 398.0f, 256.0f, 412.8f)
                lineTo(256.0f, 432.0f)
                curveTo(256.0f, 493.9f, 306.1f, 544.0f, 368.0f, 544.0f)
                curveTo(429.9f, 544.0f, 480.0f, 493.9f, 480.0f, 432.0f)
                lineTo(480.0f, 346.5f)
                curveTo(442.7f, 333.3f, 416.0f, 297.8f, 416.0f, 256.0f)
                curveTo(416.0f, 203.0f, 459.0f, 160.0f, 512.0f, 160.0f)
                curveTo(565.0f, 160.0f, 608.0f, 203.0f, 608.0f, 256.0f)
                curveTo(608.0f, 297.8f, 581.3f, 333.4f, 544.0f, 346.5f)
                lineTo(544.0f, 432.0f)
                curveTo(544.0f, 529.2f, 465.2f, 608.0f, 368.0f, 608.0f)
                curveTo(270.8f, 608.0f, 192.0f, 529.2f, 192.0f, 432.0f)
                lineTo(192.0f, 412.8f)
                curveTo(119.0f, 398.0f, 64.0f, 333.4f, 64.0f, 256.0f)
                lineTo(64.0f, 112.0f)
                close()
                moveTo(512.0f, 288.0f)
                curveTo(529.7f, 288.0f, 544.0f, 273.7f, 544.0f, 256.0f)
                curveTo(544.0f, 238.3f, 529.7f, 224.0f, 512.0f, 224.0f)
                curveTo(494.3f, 224.0f, 480.0f, 238.3f, 480.0f, 256.0f)
                curveTo(480.0f, 273.7f, 494.3f, 288.0f, 512.0f, 288.0f)
                close()
            }
        }
        .build()
        return _stethoscope!!
    }

private var _stethoscope: ImageVector? = null
