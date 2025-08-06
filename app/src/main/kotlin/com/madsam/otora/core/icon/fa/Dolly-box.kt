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

public val Fa.`Dolly-box`: ImageVector
    get() {
        if (`_dolly-box` != null) {
            return `_dolly-box`!!
        }
        `_dolly-box` = Builder(name = "Dolly-box", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 64.0f)
                curveTo(46.3f, 64.0f, 32.0f, 78.3f, 32.0f, 96.0f)
                curveTo(32.0f, 113.7f, 46.3f, 128.0f, 64.0f, 128.0f)
                lineTo(136.9f, 128.0f)
                lineTo(229.0f, 404.2f)
                curveTo(206.5f, 421.8f, 192.0f, 449.2f, 192.0f, 480.0f)
                curveTo(192.0f, 533.0f, 235.0f, 576.0f, 288.0f, 576.0f)
                curveTo(340.4f, 576.0f, 383.1f, 534.0f, 384.0f, 481.7f)
                lineTo(586.1f, 414.3f)
                curveTo(602.9f, 408.7f, 611.9f, 390.6f, 606.3f, 373.8f)
                curveTo(600.7f, 357.0f, 582.6f, 348.0f, 565.8f, 353.6f)
                lineTo(363.8f, 421.0f)
                curveTo(346.6f, 398.9f, 319.9f, 384.5f, 289.8f, 384.0f)
                lineTo(197.7f, 107.8f)
                curveTo(188.9f, 81.6f, 164.5f, 64.0f, 136.9f, 64.0f)
                lineTo(64.0f, 64.0f)
                close()
                moveTo(240.0f, 480.0f)
                curveTo(240.0f, 453.5f, 261.5f, 432.0f, 288.0f, 432.0f)
                curveTo(314.5f, 432.0f, 336.0f, 453.5f, 336.0f, 480.0f)
                curveTo(336.0f, 506.5f, 314.5f, 528.0f, 288.0f, 528.0f)
                curveTo(261.5f, 528.0f, 240.0f, 506.5f, 240.0f, 480.0f)
                close()
                moveTo(312.5f, 153.3f)
                curveTo(287.3f, 161.5f, 273.5f, 188.6f, 281.7f, 213.8f)
                lineTo(321.3f, 335.5f)
                curveTo(329.5f, 360.7f, 356.6f, 374.5f, 381.8f, 366.3f)
                lineTo(503.5f, 326.7f)
                curveTo(528.7f, 318.5f, 542.5f, 291.4f, 534.3f, 266.2f)
                lineTo(494.8f, 144.5f)
                curveTo(486.6f, 119.3f, 459.5f, 105.5f, 434.3f, 113.7f)
                lineTo(312.5f, 153.3f)
                close()
            }
        }
        .build()
        return `_dolly-box`!!
    }

private var `_dolly-box`: ImageVector? = null
