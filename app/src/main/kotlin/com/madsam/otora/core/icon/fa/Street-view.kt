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

public val Fa.`Street-view`: ImageVector
    get() {
        if (`_street-view` != null) {
            return `_street-view`!!
        }
        `_street-view` = Builder(name = "Street-view", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(355.3f, 64.0f, 384.0f, 92.7f, 384.0f, 128.0f)
                curveTo(384.0f, 163.3f, 355.3f, 192.0f, 320.0f, 192.0f)
                curveTo(284.7f, 192.0f, 256.0f, 163.3f, 256.0f, 128.0f)
                curveTo(256.0f, 92.7f, 284.7f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(288.0f, 224.0f)
                lineTo(352.0f, 224.0f)
                curveTo(387.3f, 224.0f, 416.0f, 252.7f, 416.0f, 288.0f)
                lineTo(416.0f, 336.0f)
                curveTo(416.0f, 353.7f, 401.7f, 368.0f, 384.0f, 368.0f)
                lineTo(382.2f, 368.0f)
                lineTo(371.1f, 467.5f)
                curveTo(369.3f, 483.7f, 355.6f, 496.0f, 339.3f, 496.0f)
                lineTo(300.6f, 496.0f)
                curveTo(284.3f, 496.0f, 270.6f, 483.7f, 268.8f, 467.5f)
                lineTo(257.7f, 368.0f)
                lineTo(255.9f, 368.0f)
                curveTo(238.2f, 368.0f, 223.9f, 353.7f, 223.9f, 336.0f)
                lineTo(223.9f, 288.0f)
                curveTo(223.9f, 252.7f, 252.6f, 224.0f, 287.9f, 224.0f)
                close()
                moveTo(476.4f, 464.2f)
                curveTo(460.3f, 460.0f, 441.6f, 456.6f, 421.0f, 454.0f)
                lineTo(426.3f, 406.3f)
                curveTo(449.0f, 409.2f, 470.0f, 413.0f, 488.4f, 417.8f)
                curveTo(510.8f, 423.6f, 531.0f, 431.1f, 546.2f, 441.1f)
                curveTo(560.9f, 450.7f, 576.0f, 466.0f, 576.0f, 488.1f)
                curveTo(576.0f, 510.2f, 560.9f, 525.5f, 546.2f, 535.1f)
                curveTo(531.0f, 545.0f, 510.7f, 552.6f, 488.4f, 558.4f)
                curveTo(443.3f, 570.1f, 383.1f, 576.2f, 320.0f, 576.2f)
                curveTo(256.9f, 576.2f, 196.7f, 570.1f, 151.6f, 558.4f)
                curveTo(129.2f, 552.4f, 109.0f, 544.9f, 93.8f, 535.0f)
                curveTo(79.1f, 525.4f, 64.0f, 510.1f, 64.0f, 488.0f)
                curveTo(64.0f, 465.9f, 79.1f, 450.6f, 93.8f, 441.0f)
                curveTo(109.0f, 431.1f, 129.3f, 423.5f, 151.6f, 417.7f)
                curveTo(170.1f, 412.9f, 191.1f, 409.1f, 213.7f, 406.2f)
                lineTo(219.0f, 454.0f)
                curveTo(198.4f, 456.6f, 179.7f, 460.1f, 163.6f, 464.2f)
                curveTo(107.0f, 478.8f, 107.0f, 497.1f, 163.6f, 511.7f)
                curveTo(203.5f, 522.0f, 259.4f, 527.9f, 320.0f, 527.9f)
                curveTo(380.6f, 527.9f, 436.5f, 522.0f, 476.4f, 511.7f)
                curveTo(533.0f, 497.1f, 533.0f, 478.8f, 476.4f, 464.2f)
                close()
            }
        }
        .build()
        return `_street-view`!!
    }

private var `_street-view`: ImageVector? = null
