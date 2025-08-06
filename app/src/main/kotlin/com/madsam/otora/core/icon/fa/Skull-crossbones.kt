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

public val Fa.`Skull-crossbones`: ImageVector
    get() {
        if (`_skull-crossbones` != null) {
            return `_skull-crossbones`!!
        }
        `_skull-crossbones` = Builder(name = "Skull-crossbones", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 208.0f)
                curveTo(480.0f, 128.5f, 408.4f, 64.0f, 320.0f, 64.0f)
                curveTo(231.6f, 64.0f, 160.0f, 128.5f, 160.0f, 208.0f)
                curveTo(160.0f, 255.1f, 185.1f, 296.9f, 224.0f, 323.2f)
                lineTo(224.0f, 352.0f)
                curveTo(224.0f, 369.7f, 238.3f, 384.0f, 256.0f, 384.0f)
                lineTo(384.0f, 384.0f)
                curveTo(401.7f, 384.0f, 416.0f, 369.7f, 416.0f, 352.0f)
                lineTo(416.0f, 323.2f)
                curveTo(454.9f, 296.9f, 480.0f, 255.1f, 480.0f, 208.0f)
                close()
                moveTo(256.0f, 192.0f)
                curveTo(273.7f, 192.0f, 288.0f, 206.3f, 288.0f, 224.0f)
                curveTo(288.0f, 241.7f, 273.7f, 256.0f, 256.0f, 256.0f)
                curveTo(238.3f, 256.0f, 224.0f, 241.7f, 224.0f, 224.0f)
                curveTo(224.0f, 206.3f, 238.3f, 192.0f, 256.0f, 192.0f)
                close()
                moveTo(352.0f, 224.0f)
                curveTo(352.0f, 206.3f, 366.3f, 192.0f, 384.0f, 192.0f)
                curveTo(401.7f, 192.0f, 416.0f, 206.3f, 416.0f, 224.0f)
                curveTo(416.0f, 241.7f, 401.7f, 256.0f, 384.0f, 256.0f)
                curveTo(366.3f, 256.0f, 352.0f, 241.7f, 352.0f, 224.0f)
                close()
                moveTo(541.5f, 403.7f)
                curveTo(534.7f, 387.4f, 516.0f, 379.7f, 499.7f, 386.5f)
                lineTo(320.0f, 461.3f)
                lineTo(140.3f, 386.5f)
                curveTo(124.0f, 379.7f, 105.3f, 387.4f, 98.5f, 403.7f)
                curveTo(91.7f, 420.0f, 99.4f, 438.7f, 115.7f, 445.5f)
                lineTo(236.8f, 496.0f)
                lineTo(115.7f, 546.5f)
                curveTo(99.4f, 553.3f, 91.7f, 572.0f, 98.5f, 588.3f)
                curveTo(105.3f, 604.6f, 124.0f, 612.3f, 140.3f, 605.5f)
                lineTo(320.0f, 530.7f)
                lineTo(499.7f, 605.5f)
                curveTo(516.0f, 612.3f, 534.7f, 604.6f, 541.5f, 588.3f)
                curveTo(548.3f, 572.0f, 540.6f, 553.3f, 524.3f, 546.5f)
                lineTo(403.2f, 496.0f)
                lineTo(524.3f, 445.5f)
                curveTo(540.6f, 438.7f, 548.3f, 420.0f, 541.5f, 403.7f)
                close()
            }
        }
        .build()
        return `_skull-crossbones`!!
    }

private var `_skull-crossbones`: ImageVector? = null
