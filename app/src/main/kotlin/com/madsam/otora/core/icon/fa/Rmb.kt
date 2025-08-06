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

public val Fa.Rmb: ImageVector
    get() {
        if (_rmb != null) {
            return _rmb!!
        }
        _rmb = Builder(name = "Rmb", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(202.9f, 110.7f)
                curveTo(193.3f, 95.8f, 173.5f, 91.5f, 158.7f, 101.1f)
                curveTo(143.9f, 110.7f, 139.5f, 130.4f, 149.1f, 145.3f)
                lineTo(271.7f, 336.0f)
                lineTo(216.0f, 336.0f)
                curveTo(202.7f, 336.0f, 192.0f, 346.7f, 192.0f, 360.0f)
                curveTo(192.0f, 373.3f, 202.7f, 384.0f, 216.0f, 384.0f)
                lineTo(288.0f, 384.0f)
                lineTo(288.0f, 416.0f)
                lineTo(216.0f, 416.0f)
                curveTo(202.7f, 416.0f, 192.0f, 426.7f, 192.0f, 440.0f)
                curveTo(192.0f, 453.3f, 202.7f, 464.0f, 216.0f, 464.0f)
                lineTo(288.0f, 464.0f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 529.7f, 302.3f, 544.0f, 320.0f, 544.0f)
                curveTo(337.7f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                lineTo(352.0f, 464.0f)
                lineTo(424.0f, 464.0f)
                curveTo(437.3f, 464.0f, 448.0f, 453.3f, 448.0f, 440.0f)
                curveTo(448.0f, 426.7f, 437.3f, 416.0f, 424.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                lineTo(352.0f, 384.0f)
                lineTo(424.0f, 384.0f)
                curveTo(437.3f, 384.0f, 448.0f, 373.3f, 448.0f, 360.0f)
                curveTo(448.0f, 346.7f, 437.3f, 336.0f, 424.0f, 336.0f)
                lineTo(368.3f, 336.0f)
                lineTo(490.9f, 145.3f)
                curveTo(500.5f, 130.4f, 496.2f, 110.6f, 481.3f, 101.1f)
                curveTo(466.4f, 91.6f, 446.6f, 95.8f, 437.1f, 110.7f)
                lineTo(320.0f, 292.8f)
                lineTo(202.9f, 110.7f)
                close()
            }
        }
        .build()
        return _rmb!!
    }

private var _rmb: ImageVector? = null
