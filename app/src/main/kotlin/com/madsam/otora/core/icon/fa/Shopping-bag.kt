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

public val Fa.`Shopping-bag`: ImageVector
    get() {
        if (`_shopping-bag` != null) {
            return `_shopping-bag`!!
        }
        `_shopping-bag` = Builder(name = "Shopping-bag", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 144.0f)
                curveTo(256.0f, 108.7f, 284.7f, 80.0f, 320.0f, 80.0f)
                curveTo(355.3f, 80.0f, 384.0f, 108.7f, 384.0f, 144.0f)
                lineTo(384.0f, 192.0f)
                lineTo(256.0f, 192.0f)
                lineTo(256.0f, 144.0f)
                close()
                moveTo(208.0f, 192.0f)
                lineTo(144.0f, 192.0f)
                curveTo(117.5f, 192.0f, 96.0f, 213.5f, 96.0f, 240.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 501.0f, 139.0f, 544.0f, 192.0f, 544.0f)
                lineTo(448.0f, 544.0f)
                curveTo(501.0f, 544.0f, 544.0f, 501.0f, 544.0f, 448.0f)
                lineTo(544.0f, 240.0f)
                curveTo(544.0f, 213.5f, 522.5f, 192.0f, 496.0f, 192.0f)
                lineTo(432.0f, 192.0f)
                lineTo(432.0f, 144.0f)
                curveTo(432.0f, 82.1f, 381.9f, 32.0f, 320.0f, 32.0f)
                curveTo(258.1f, 32.0f, 208.0f, 82.1f, 208.0f, 144.0f)
                lineTo(208.0f, 192.0f)
                close()
                moveTo(232.0f, 240.0f)
                curveTo(245.3f, 240.0f, 256.0f, 250.7f, 256.0f, 264.0f)
                curveTo(256.0f, 277.3f, 245.3f, 288.0f, 232.0f, 288.0f)
                curveTo(218.7f, 288.0f, 208.0f, 277.3f, 208.0f, 264.0f)
                curveTo(208.0f, 250.7f, 218.7f, 240.0f, 232.0f, 240.0f)
                close()
                moveTo(384.0f, 264.0f)
                curveTo(384.0f, 250.7f, 394.7f, 240.0f, 408.0f, 240.0f)
                curveTo(421.3f, 240.0f, 432.0f, 250.7f, 432.0f, 264.0f)
                curveTo(432.0f, 277.3f, 421.3f, 288.0f, 408.0f, 288.0f)
                curveTo(394.7f, 288.0f, 384.0f, 277.3f, 384.0f, 264.0f)
                close()
            }
        }
        .build()
        return `_shopping-bag`!!
    }

private var `_shopping-bag`: ImageVector? = null
