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

public val Fa.`Door-closed`: ImageVector
    get() {
        if (`_door-closed` != null) {
            return `_door-closed`!!
        }
        `_door-closed` = Builder(name = "Door-closed", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(483.3f, 64.0f, 512.0f, 92.7f, 512.0f, 128.0f)
                lineTo(512.0f, 512.0f)
                curveTo(529.7f, 512.0f, 544.0f, 526.3f, 544.0f, 544.0f)
                curveTo(544.0f, 561.7f, 529.7f, 576.0f, 512.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(110.3f, 576.0f, 96.0f, 561.7f, 96.0f, 544.0f)
                curveTo(96.0f, 526.3f, 110.3f, 512.0f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(416.0f, 352.0f)
                curveTo(433.7f, 352.0f, 448.0f, 337.7f, 448.0f, 320.0f)
                curveTo(448.0f, 302.3f, 433.7f, 288.0f, 416.0f, 288.0f)
                curveTo(398.3f, 288.0f, 384.0f, 302.3f, 384.0f, 320.0f)
                curveTo(384.0f, 337.7f, 398.3f, 352.0f, 416.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_door-closed`!!
    }

private var `_door-closed`: ImageVector? = null
