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

public val Fa.`Shield-heart`: ImageVector
    get() {
        if (`_shield-heart` != null) {
            return `_shield-heart`!!
        }
        `_shield-heart` = Builder(name = "Shield-heart", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(333.4f, 66.9f)
                curveTo(329.2f, 65.0f, 324.7f, 64.0f, 320.0f, 64.0f)
                curveTo(315.3f, 64.0f, 310.8f, 65.0f, 306.6f, 66.9f)
                lineTo(118.3f, 146.8f)
                curveTo(96.3f, 156.1f, 79.9f, 177.8f, 80.0f, 204.0f)
                curveTo(80.5f, 303.2f, 121.3f, 484.7f, 293.6f, 567.2f)
                curveTo(310.3f, 575.2f, 329.7f, 575.2f, 346.4f, 567.2f)
                curveTo(518.8f, 484.7f, 559.6f, 303.2f, 560.0f, 204.0f)
                curveTo(560.1f, 177.8f, 543.7f, 156.1f, 521.7f, 146.8f)
                lineTo(333.4f, 66.9f)
                close()
                moveTo(313.6f, 247.5f)
                lineTo(320.0f, 256.0f)
                lineTo(326.4f, 247.5f)
                curveTo(337.5f, 232.7f, 354.9f, 224.0f, 373.3f, 224.0f)
                curveTo(405.7f, 224.0f, 432.0f, 250.3f, 432.0f, 282.7f)
                lineTo(432.0f, 288.0f)
                curveTo(432.0f, 337.1f, 366.2f, 386.1f, 335.5f, 406.3f)
                curveTo(326.0f, 412.5f, 314.0f, 412.5f, 304.6f, 406.3f)
                curveTo(273.9f, 386.1f, 208.1f, 337.0f, 208.1f, 288.0f)
                lineTo(208.1f, 282.7f)
                curveTo(208.1f, 250.3f, 234.4f, 224.0f, 266.8f, 224.0f)
                curveTo(285.3f, 224.0f, 302.7f, 232.7f, 313.7f, 247.5f)
                close()
            }
        }
        .build()
        return `_shield-heart`!!
    }

private var `_shield-heart`: ImageVector? = null
