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

public val Fa.`Tachometer-alt-fast`: ImageVector
    get() {
        if (`_tachometer-alt-fast` != null) {
            return `_tachometer-alt-fast`!!
        }
        `_tachometer-alt-fast` = Builder(name = "Tachometer-alt-fast", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(352.0f, 160.0f)
                curveTo(352.0f, 142.3f, 337.7f, 128.0f, 320.0f, 128.0f)
                curveTo(302.3f, 128.0f, 288.0f, 142.3f, 288.0f, 160.0f)
                curveTo(288.0f, 177.7f, 302.3f, 192.0f, 320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 177.7f, 352.0f, 160.0f)
                close()
                moveTo(320.0f, 480.0f)
                curveTo(355.3f, 480.0f, 384.0f, 451.3f, 384.0f, 416.0f)
                curveTo(384.0f, 399.8f, 378.0f, 384.9f, 368.0f, 373.7f)
                lineTo(437.5f, 234.8f)
                curveTo(443.4f, 222.9f, 438.6f, 208.5f, 426.8f, 202.6f)
                curveTo(415.0f, 196.7f, 400.5f, 201.5f, 394.6f, 213.3f)
                lineTo(325.1f, 352.2f)
                curveTo(323.4f, 352.1f, 321.7f, 352.0f, 320.0f, 352.0f)
                curveTo(284.7f, 352.0f, 256.0f, 380.7f, 256.0f, 416.0f)
                curveTo(256.0f, 451.3f, 284.7f, 480.0f, 320.0f, 480.0f)
                close()
                moveTo(240.0f, 208.0f)
                curveTo(240.0f, 190.3f, 225.7f, 176.0f, 208.0f, 176.0f)
                curveTo(190.3f, 176.0f, 176.0f, 190.3f, 176.0f, 208.0f)
                curveTo(176.0f, 225.7f, 190.3f, 240.0f, 208.0f, 240.0f)
                curveTo(225.7f, 240.0f, 240.0f, 225.7f, 240.0f, 208.0f)
                close()
                moveTo(160.0f, 352.0f)
                curveTo(177.7f, 352.0f, 192.0f, 337.7f, 192.0f, 320.0f)
                curveTo(192.0f, 302.3f, 177.7f, 288.0f, 160.0f, 288.0f)
                curveTo(142.3f, 288.0f, 128.0f, 302.3f, 128.0f, 320.0f)
                curveTo(128.0f, 337.7f, 142.3f, 352.0f, 160.0f, 352.0f)
                close()
                moveTo(512.0f, 320.0f)
                curveTo(512.0f, 302.3f, 497.7f, 288.0f, 480.0f, 288.0f)
                curveTo(462.3f, 288.0f, 448.0f, 302.3f, 448.0f, 320.0f)
                curveTo(448.0f, 337.7f, 462.3f, 352.0f, 480.0f, 352.0f)
                curveTo(497.7f, 352.0f, 512.0f, 337.7f, 512.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_tachometer-alt-fast`!!
    }

private var `_tachometer-alt-fast`: ImageVector? = null
