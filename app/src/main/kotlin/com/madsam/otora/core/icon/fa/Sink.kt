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

public val Fa.Sink: ImageVector
    get() {
        if (_sink != null) {
            return _sink!!
        }
        _sink = Builder(name = "Sink", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 160.0f)
                curveTo(352.0f, 142.3f, 366.3f, 128.0f, 384.0f, 128.0f)
                curveTo(401.7f, 128.0f, 416.0f, 142.3f, 416.0f, 160.0f)
                curveTo(416.0f, 177.7f, 430.3f, 192.0f, 448.0f, 192.0f)
                curveTo(465.7f, 192.0f, 480.0f, 177.7f, 480.0f, 160.0f)
                curveTo(480.0f, 107.0f, 437.0f, 64.0f, 384.0f, 64.0f)
                curveTo(331.0f, 64.0f, 288.0f, 107.0f, 288.0f, 160.0f)
                lineTo(288.0f, 352.0f)
                lineTo(224.0f, 352.0f)
                lineTo(224.0f, 312.0f)
                curveTo(224.0f, 281.1f, 198.9f, 256.0f, 168.0f, 256.0f)
                lineTo(120.0f, 256.0f)
                curveTo(106.7f, 256.0f, 96.0f, 266.7f, 96.0f, 280.0f)
                curveTo(96.0f, 293.3f, 106.7f, 304.0f, 120.0f, 304.0f)
                lineTo(168.0f, 304.0f)
                curveTo(172.4f, 304.0f, 176.0f, 307.6f, 176.0f, 312.0f)
                lineTo(176.0f, 352.0f)
                lineTo(96.0f, 352.0f)
                curveTo(78.3f, 352.0f, 64.0f, 366.3f, 64.0f, 384.0f)
                curveTo(64.0f, 401.7f, 78.3f, 416.0f, 96.0f, 416.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 533.0f, 139.0f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(501.0f, 576.0f, 544.0f, 533.0f, 544.0f, 480.0f)
                lineTo(544.0f, 416.0f)
                curveTo(561.7f, 416.0f, 576.0f, 401.7f, 576.0f, 384.0f)
                curveTo(576.0f, 366.3f, 561.7f, 352.0f, 544.0f, 352.0f)
                lineTo(464.0f, 352.0f)
                lineTo(464.0f, 312.0f)
                curveTo(464.0f, 307.6f, 467.6f, 304.0f, 472.0f, 304.0f)
                lineTo(528.0f, 304.0f)
                curveTo(541.3f, 304.0f, 552.0f, 293.3f, 552.0f, 280.0f)
                curveTo(552.0f, 266.7f, 541.3f, 256.0f, 528.0f, 256.0f)
                lineTo(472.0f, 256.0f)
                curveTo(441.1f, 256.0f, 416.0f, 281.1f, 416.0f, 312.0f)
                lineTo(416.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                lineTo(352.0f, 160.0f)
                close()
            }
        }
        .build()
        return _sink!!
    }

private var _sink: ImageVector? = null
