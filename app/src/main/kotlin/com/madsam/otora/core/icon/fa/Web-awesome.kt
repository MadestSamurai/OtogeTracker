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

public val Fa.`Web-awesome`: ImageVector
    get() {
        if (`_web-awesome` != null) {
            return `_web-awesome`!!
        }
        `_web-awesome` = Builder(name = "Web-awesome", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(372.2f, 116.0f)
                curveTo(372.2f, 136.9f, 359.8f, 155.0f, 342.0f, 163.2f)
                lineTo(448.0f, 256.0f)
                lineTo(552.4f, 235.1f)
                curveTo(547.1f, 227.4f, 544.0f, 218.0f, 544.0f, 208.0f)
                curveTo(544.0f, 181.5f, 565.5f, 160.0f, 592.0f, 160.0f)
                curveTo(618.5f, 160.0f, 640.0f, 181.5f, 640.0f, 208.0f)
                curveTo(640.0f, 234.0f, 619.4f, 255.1f, 593.6f, 256.0f)
                lineTo(481.0f, 506.3f)
                curveTo(470.7f, 529.3f, 447.8f, 544.0f, 422.6f, 544.0f)
                lineTo(217.4f, 544.0f)
                curveTo(192.2f, 544.0f, 169.4f, 529.2f, 159.0f, 506.3f)
                lineTo(46.4f, 256.0f)
                curveTo(20.6f, 255.1f, 0.0f, 234.0f, 0.0f, 208.0f)
                curveTo(0.0f, 181.5f, 21.5f, 160.0f, 48.0f, 160.0f)
                curveTo(74.5f, 160.0f, 96.0f, 181.5f, 96.0f, 208.0f)
                curveTo(96.0f, 218.1f, 92.9f, 227.4f, 87.6f, 235.1f)
                lineTo(192.0f, 256.0f)
                lineTo(298.1f, 163.1f)
                curveTo(280.4f, 154.8f, 268.1f, 136.8f, 268.1f, 116.0f)
                curveTo(268.1f, 87.3f, 291.4f, 64.0f, 320.1f, 64.0f)
                curveTo(348.8f, 64.0f, 372.1f, 87.3f, 372.1f, 116.0f)
                close()
            }
        }
        .build()
        return `_web-awesome`!!
    }

private var `_web-awesome`: ImageVector? = null
