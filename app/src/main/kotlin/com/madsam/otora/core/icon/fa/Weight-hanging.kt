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

public val Fa.`Weight-hanging`: ImageVector
    get() {
        if (`_weight-hanging` != null) {
            return `_weight-hanging`!!
        }
        `_weight-hanging` = Builder(name = "Weight-hanging", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 160.0f)
                curveTo(288.0f, 142.3f, 302.3f, 128.0f, 320.0f, 128.0f)
                curveTo(337.7f, 128.0f, 352.0f, 142.3f, 352.0f, 160.0f)
                curveTo(352.0f, 177.7f, 337.7f, 192.0f, 320.0f, 192.0f)
                curveTo(302.3f, 192.0f, 288.0f, 177.7f, 288.0f, 160.0f)
                close()
                moveTo(410.5f, 192.0f)
                curveTo(414.0f, 182.0f, 416.0f, 171.2f, 416.0f, 160.0f)
                curveTo(416.0f, 107.0f, 373.0f, 64.0f, 320.0f, 64.0f)
                curveTo(267.0f, 64.0f, 224.0f, 107.0f, 224.0f, 160.0f)
                curveTo(224.0f, 171.2f, 225.9f, 182.0f, 229.5f, 192.0f)
                lineTo(207.7f, 192.0f)
                curveTo(179.4f, 192.0f, 154.5f, 210.5f, 146.4f, 237.6f)
                lineTo(66.4f, 504.2f)
                curveTo(64.8f, 509.4f, 64.0f, 514.8f, 64.0f, 520.2f)
                curveTo(64.0f, 551.0f, 89.0f, 576.0f, 119.8f, 576.0f)
                lineTo(520.2f, 576.0f)
                curveTo(551.0f, 576.0f, 576.0f, 551.0f, 576.0f, 520.2f)
                curveTo(576.0f, 514.8f, 575.2f, 509.4f, 573.6f, 504.2f)
                lineTo(493.6f, 237.7f)
                curveTo(485.5f, 210.6f, 460.6f, 192.1f, 432.3f, 192.1f)
                lineTo(410.5f, 192.1f)
                close()
            }
        }
        .build()
        return `_weight-hanging`!!
    }

private var `_weight-hanging`: ImageVector? = null
