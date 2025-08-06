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

public val Fa.`Thumbs-down`: ImageVector
    get() {
        if (`_thumbs-down` != null) {
            return `_thumbs-down`!!
        }
        `_thumbs-down` = Builder(name = "Thumbs-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 96.0f)
                curveTo(474.5f, 96.0f, 496.0f, 117.5f, 496.0f, 144.0f)
                curveTo(496.0f, 150.3f, 494.7f, 156.2f, 492.6f, 161.7f)
                curveTo(513.0f, 167.2f, 528.0f, 185.8f, 528.0f, 208.0f)
                curveTo(528.0f, 217.1f, 525.4f, 225.6f, 521.0f, 232.9f)
                curveTo(543.2f, 237.1f, 560.0f, 256.6f, 560.0f, 280.0f)
                curveTo(560.0f, 299.7f, 548.1f, 316.6f, 531.1f, 324.0f)
                curveTo(548.1f, 331.4f, 560.0f, 348.3f, 560.0f, 368.0f)
                curveTo(560.0f, 394.5f, 538.5f, 416.0f, 512.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                lineTo(380.2f, 486.4f)
                curveTo(382.7f, 492.7f, 384.0f, 499.5f, 384.0f, 506.3f)
                lineTo(384.0f, 510.5f)
                curveTo(384.0f, 537.8f, 361.9f, 559.9f, 334.6f, 559.9f)
                curveTo(315.9f, 559.9f, 298.8f, 549.3f, 290.4f, 532.6f)
                lineTo(234.1f, 420.3f)
                curveTo(227.4f, 407.0f, 224.0f, 392.3f, 224.0f, 377.4f)
                lineTo(224.0f, 190.8f)
                curveTo(224.0f, 171.4f, 232.9f, 153.0f, 248.0f, 140.8f)
                lineTo(260.2f, 131.1f)
                curveTo(288.6f, 108.4f, 323.8f, 96.0f, 360.1f, 96.0f)
                lineTo(448.0f, 96.0f)
                close()
                moveTo(144.0f, 160.0f)
                curveTo(161.7f, 160.0f, 176.0f, 174.3f, 176.0f, 192.0f)
                lineTo(176.0f, 448.0f)
                curveTo(176.0f, 465.7f, 161.7f, 480.0f, 144.0f, 480.0f)
                lineTo(96.0f, 480.0f)
                curveTo(78.3f, 480.0f, 64.0f, 465.7f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                curveTo(64.0f, 174.3f, 78.3f, 160.0f, 96.0f, 160.0f)
                lineTo(144.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_thumbs-down`!!
    }

private var `_thumbs-down`: ImageVector? = null
