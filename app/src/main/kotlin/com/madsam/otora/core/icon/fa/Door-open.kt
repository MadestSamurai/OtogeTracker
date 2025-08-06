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

public val Fa.`Door-open`: ImageVector
    get() {
        if (`_door-open` != null) {
            return `_door-open`!!
        }
        `_door-open` = Builder(name = "Door-open", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 128.0f)
                lineTo(448.0f, 128.0f)
                lineTo(448.0f, 544.0f)
                curveTo(448.0f, 561.7f, 462.3f, 576.0f, 480.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(529.7f, 576.0f, 544.0f, 561.7f, 544.0f, 544.0f)
                curveTo(544.0f, 526.3f, 529.7f, 512.0f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(352.0f, 64.0f)
                lineTo(352.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                curveTo(110.3f, 512.0f, 96.0f, 526.3f, 96.0f, 544.0f)
                curveTo(96.0f, 561.7f, 110.3f, 576.0f, 128.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                curveTo(369.7f, 576.0f, 384.0f, 561.7f, 384.0f, 544.0f)
                lineTo(384.0f, 128.0f)
                close()
                moveTo(256.0f, 320.0f)
                curveTo(256.0f, 302.3f, 270.3f, 288.0f, 288.0f, 288.0f)
                curveTo(305.7f, 288.0f, 320.0f, 302.3f, 320.0f, 320.0f)
                curveTo(320.0f, 337.7f, 305.7f, 352.0f, 288.0f, 352.0f)
                curveTo(270.3f, 352.0f, 256.0f, 337.7f, 256.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_door-open`!!
    }

private var `_door-open`: ImageVector? = null
