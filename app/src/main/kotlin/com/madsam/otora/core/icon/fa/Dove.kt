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

public val Fa.Dove: ImageVector
    get() {
        if (_dove != null) {
            return _dove!!
        }
        _dove = Builder(name = "Dove", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(560.0f, 128.0f)
                curveTo(573.2f, 128.0f, 580.7f, 143.1f, 572.8f, 153.6f)
                lineTo(544.0f, 192.0f)
                lineTo(544.0f, 368.0f)
                curveTo(544.0f, 447.5f, 479.5f, 512.0f, 400.0f, 512.0f)
                lineTo(288.0f, 512.0f)
                lineTo(241.7f, 558.3f)
                curveTo(231.3f, 568.7f, 215.2f, 570.7f, 202.6f, 563.1f)
                lineTo(105.5f, 504.9f)
                curveTo(88.5f, 494.7f, 90.5f, 469.4f, 108.9f, 462.0f)
                lineTo(224.0f, 416.0f)
                curveTo(87.8f, 375.1f, 71.5f, 233.8f, 86.0f, 159.7f)
                curveTo(89.6f, 141.9f, 109.3f, 135.4f, 125.3f, 144.2f)
                lineTo(384.0f, 288.0f)
                lineTo(384.0f, 208.0f)
                curveTo(384.0f, 163.8f, 419.8f, 128.0f, 464.0f, 128.0f)
                lineTo(560.0f, 128.0f)
                close()
                moveTo(464.0f, 184.0f)
                curveTo(450.7f, 184.0f, 440.0f, 194.7f, 440.0f, 208.0f)
                curveTo(440.0f, 221.3f, 450.7f, 232.0f, 464.0f, 232.0f)
                curveTo(477.3f, 232.0f, 488.0f, 221.3f, 488.0f, 208.0f)
                curveTo(488.0f, 194.7f, 477.3f, 184.0f, 464.0f, 184.0f)
                close()
                moveTo(246.5f, 54.4f)
                curveTo(258.9f, 40.7f, 279.8f, 45.5f, 289.0f, 61.5f)
                lineTo(345.4f, 159.8f)
                curveTo(339.6f, 174.2f, 336.2f, 189.9f, 336.0f, 206.3f)
                lineTo(202.1f, 132.0f)
                curveTo(212.2f, 100.4f, 229.1f, 73.6f, 246.5f, 54.4f)
                close()
            }
        }
        .build()
        return _dove!!
    }

private var _dove: ImageVector? = null
