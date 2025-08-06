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

public val Fa.`Candy-cane`: ImageVector
    get() {
        if (`_candy-cane` != null) {
            return `_candy-cane`!!
        }
        `_candy-cane` = Builder(name = "Candy-cane", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(517.8f, 103.6f)
                curveTo(548.0f, 149.2f, 552.5f, 206.9f, 531.1f, 256.0f)
                lineTo(365.7f, 256.0f)
                lineTo(407.1f, 214.6f)
                curveTo(407.9f, 213.8f, 408.6f, 213.0f, 409.3f, 212.2f)
                lineTo(517.8f, 103.6f)
                close()
                moveTo(364.0f, 166.9f)
                curveTo(363.2f, 167.6f, 362.4f, 168.3f, 361.6f, 169.1f)
                lineTo(333.5f, 197.2f)
                curveTo(308.5f, 222.2f, 268.0f, 222.2f, 243.0f, 197.2f)
                curveTo(218.0f, 172.2f, 218.0f, 131.7f, 243.0f, 106.7f)
                lineTo(271.0f, 78.6f)
                curveTo(325.9f, 23.8f, 410.5f, 17.3f, 472.5f, 58.4f)
                lineTo(364.0f, 166.9f)
                close()
                moveTo(221.7f, 400.0f)
                lineTo(301.7f, 320.0f)
                lineTo(482.7f, 320.0f)
                lineTo(400.2f, 402.5f)
                lineTo(400.2f, 400.0f)
                lineTo(221.7f, 400.0f)
                close()
                moveTo(338.7f, 464.0f)
                lineTo(237.4f, 565.3f)
                curveTo(212.4f, 590.3f, 171.9f, 590.3f, 146.9f, 565.3f)
                curveTo(121.9f, 540.3f, 121.9f, 499.8f, 146.9f, 474.8f)
                lineTo(157.6f, 464.1f)
                lineTo(338.6f, 464.1f)
                close()
            }
        }
        .build()
        return `_candy-cane`!!
    }

private var `_candy-cane`: ImageVector? = null
