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

public val Fa.`Sd-card`: ImageVector
    get() {
        if (`_sd-card` != null) {
            return `_sd-card`!!
        }
        `_sd-card` = Builder(name = "Sd-card", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(253.3f, 64.0f)
                curveTo(236.3f, 64.0f, 220.0f, 70.7f, 208.0f, 82.7f)
                lineTo(146.7f, 144.0f)
                curveTo(134.7f, 156.0f, 128.0f, 172.3f, 128.0f, 189.3f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                close()
                moveTo(288.0f, 152.0f)
                lineTo(288.0f, 200.0f)
                curveTo(288.0f, 213.3f, 277.3f, 224.0f, 264.0f, 224.0f)
                curveTo(250.7f, 224.0f, 240.0f, 213.3f, 240.0f, 200.0f)
                lineTo(240.0f, 152.0f)
                curveTo(240.0f, 138.7f, 250.7f, 128.0f, 264.0f, 128.0f)
                curveTo(277.3f, 128.0f, 288.0f, 138.7f, 288.0f, 152.0f)
                close()
                moveTo(376.0f, 152.0f)
                lineTo(376.0f, 200.0f)
                curveTo(376.0f, 213.3f, 365.3f, 224.0f, 352.0f, 224.0f)
                curveTo(338.7f, 224.0f, 328.0f, 213.3f, 328.0f, 200.0f)
                lineTo(328.0f, 152.0f)
                curveTo(328.0f, 138.7f, 338.7f, 128.0f, 352.0f, 128.0f)
                curveTo(365.3f, 128.0f, 376.0f, 138.7f, 376.0f, 152.0f)
                close()
                moveTo(464.0f, 152.0f)
                lineTo(464.0f, 200.0f)
                curveTo(464.0f, 213.3f, 453.3f, 224.0f, 440.0f, 224.0f)
                curveTo(426.7f, 224.0f, 416.0f, 213.3f, 416.0f, 200.0f)
                lineTo(416.0f, 152.0f)
                curveTo(416.0f, 138.7f, 426.7f, 128.0f, 440.0f, 128.0f)
                curveTo(453.3f, 128.0f, 464.0f, 138.7f, 464.0f, 152.0f)
                close()
            }
        }
        .build()
        return `_sd-card`!!
    }

private var `_sd-card`: ImageVector? = null
