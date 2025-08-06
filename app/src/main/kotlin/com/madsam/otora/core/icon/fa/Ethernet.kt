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

public val Fa.Ethernet: ImageVector
    get() {
        if (_ethernet != null) {
            return _ethernet!!
        }
        _ethernet = Builder(name = "Ethernet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 288.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 497.7f, 78.3f, 512.0f, 96.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                lineTo(128.0f, 408.0f)
                curveTo(128.0f, 394.7f, 138.7f, 384.0f, 152.0f, 384.0f)
                curveTo(165.3f, 384.0f, 176.0f, 394.7f, 176.0f, 408.0f)
                lineTo(176.0f, 512.0f)
                lineTo(240.0f, 512.0f)
                lineTo(240.0f, 408.0f)
                curveTo(240.0f, 394.7f, 250.7f, 384.0f, 264.0f, 384.0f)
                curveTo(277.3f, 384.0f, 288.0f, 394.7f, 288.0f, 408.0f)
                lineTo(288.0f, 512.0f)
                lineTo(352.0f, 512.0f)
                lineTo(352.0f, 408.0f)
                curveTo(352.0f, 394.7f, 362.7f, 384.0f, 376.0f, 384.0f)
                curveTo(389.3f, 384.0f, 400.0f, 394.7f, 400.0f, 408.0f)
                lineTo(400.0f, 512.0f)
                lineTo(464.0f, 512.0f)
                lineTo(464.0f, 408.0f)
                curveTo(464.0f, 394.7f, 474.7f, 384.0f, 488.0f, 384.0f)
                curveTo(501.3f, 384.0f, 512.0f, 394.7f, 512.0f, 408.0f)
                lineTo(512.0f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(561.7f, 512.0f, 576.0f, 497.7f, 576.0f, 480.0f)
                lineTo(576.0f, 288.0f)
                curveTo(576.0f, 270.3f, 561.7f, 256.0f, 544.0f, 256.0f)
                lineTo(512.0f, 256.0f)
                lineTo(512.0f, 224.0f)
                curveTo(512.0f, 206.3f, 497.7f, 192.0f, 480.0f, 192.0f)
                lineTo(448.0f, 192.0f)
                lineTo(448.0f, 160.0f)
                curveTo(448.0f, 142.3f, 433.7f, 128.0f, 416.0f, 128.0f)
                lineTo(224.0f, 128.0f)
                curveTo(206.3f, 128.0f, 192.0f, 142.3f, 192.0f, 160.0f)
                lineTo(192.0f, 192.0f)
                lineTo(160.0f, 192.0f)
                curveTo(142.3f, 192.0f, 128.0f, 206.3f, 128.0f, 224.0f)
                lineTo(128.0f, 256.0f)
                lineTo(96.0f, 256.0f)
                curveTo(78.3f, 256.0f, 64.0f, 270.3f, 64.0f, 288.0f)
                close()
            }
        }
        .build()
        return _ethernet!!
    }

private var _ethernet: ImageVector? = null
