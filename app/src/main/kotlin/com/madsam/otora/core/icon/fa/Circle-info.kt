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

public val Fa.`Circle-info`: ImageVector
    get() {
        if (`_circle-info` != null) {
            return `_circle-info`!!
        }
        `_circle-info` = Builder(name = "Circle-info", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(288.0f, 224.0f)
                curveTo(288.0f, 206.3f, 302.3f, 192.0f, 320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 206.3f, 352.0f, 224.0f)
                curveTo(352.0f, 241.7f, 337.7f, 256.0f, 320.0f, 256.0f)
                curveTo(302.3f, 256.0f, 288.0f, 241.7f, 288.0f, 224.0f)
                close()
                moveTo(280.0f, 288.0f)
                lineTo(328.0f, 288.0f)
                curveTo(341.3f, 288.0f, 352.0f, 298.7f, 352.0f, 312.0f)
                lineTo(352.0f, 400.0f)
                lineTo(360.0f, 400.0f)
                curveTo(373.3f, 400.0f, 384.0f, 410.7f, 384.0f, 424.0f)
                curveTo(384.0f, 437.3f, 373.3f, 448.0f, 360.0f, 448.0f)
                lineTo(280.0f, 448.0f)
                curveTo(266.7f, 448.0f, 256.0f, 437.3f, 256.0f, 424.0f)
                curveTo(256.0f, 410.7f, 266.7f, 400.0f, 280.0f, 400.0f)
                lineTo(304.0f, 400.0f)
                lineTo(304.0f, 336.0f)
                lineTo(280.0f, 336.0f)
                curveTo(266.7f, 336.0f, 256.0f, 325.3f, 256.0f, 312.0f)
                curveTo(256.0f, 298.7f, 266.7f, 288.0f, 280.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_circle-info`!!
    }

private var `_circle-info`: ImageVector? = null
