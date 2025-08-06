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

public val Fa.`Arrow-right-from-bracket`: ImageVector
    get() {
        if (`_arrow-right-from-bracket` != null) {
            return `_arrow-right-from-bracket`!!
        }
        `_arrow-right-from-bracket` = Builder(name = "Arrow-right-from-bracket", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 160.0f)
                curveTo(241.7f, 160.0f, 256.0f, 145.7f, 256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 241.7f, 96.0f, 224.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(107.0f, 96.0f, 64.0f, 139.0f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 501.0f, 107.0f, 544.0f, 160.0f, 544.0f)
                lineTo(224.0f, 544.0f)
                curveTo(241.7f, 544.0f, 256.0f, 529.7f, 256.0f, 512.0f)
                curveTo(256.0f, 494.3f, 241.7f, 480.0f, 224.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(142.3f, 480.0f, 128.0f, 465.7f, 128.0f, 448.0f)
                lineTo(128.0f, 192.0f)
                curveTo(128.0f, 174.3f, 142.3f, 160.0f, 160.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                close()
                moveTo(566.6f, 342.6f)
                curveTo(579.1f, 330.1f, 579.1f, 309.8f, 566.6f, 297.3f)
                lineTo(438.6f, 169.3f)
                curveTo(426.1f, 156.8f, 405.8f, 156.8f, 393.3f, 169.3f)
                curveTo(380.8f, 181.8f, 380.8f, 202.1f, 393.3f, 214.6f)
                lineTo(466.7f, 288.0f)
                lineTo(256.0f, 288.0f)
                curveTo(238.3f, 288.0f, 224.0f, 302.3f, 224.0f, 320.0f)
                curveTo(224.0f, 337.7f, 238.3f, 352.0f, 256.0f, 352.0f)
                lineTo(466.7f, 352.0f)
                lineTo(393.3f, 425.4f)
                curveTo(380.8f, 437.9f, 380.8f, 458.2f, 393.3f, 470.7f)
                curveTo(405.8f, 483.2f, 426.1f, 483.2f, 438.6f, 470.7f)
                lineTo(566.6f, 342.7f)
                close()
            }
        }
        .build()
        return `_arrow-right-from-bracket`!!
    }

private var `_arrow-right-from-bracket`: ImageVector? = null
