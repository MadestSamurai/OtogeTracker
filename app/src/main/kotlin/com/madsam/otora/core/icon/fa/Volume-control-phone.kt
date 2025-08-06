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

public val Fa.`Volume-control-phone`: ImageVector
    get() {
        if (`_volume-control-phone` != null) {
            return `_volume-control-phone`!!
        }
        `_volume-control-phone` = Builder(name = "Volume-control-phone", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(376.0f, 32.0f)
                curveTo(504.1f, 32.0f, 608.0f, 135.9f, 608.0f, 264.0f)
                curveTo(608.0f, 277.3f, 597.3f, 288.0f, 584.0f, 288.0f)
                curveTo(570.7f, 288.0f, 560.0f, 277.3f, 560.0f, 264.0f)
                curveTo(560.0f, 162.4f, 477.6f, 80.0f, 376.0f, 80.0f)
                curveTo(362.7f, 80.0f, 352.0f, 69.3f, 352.0f, 56.0f)
                curveTo(352.0f, 42.7f, 362.7f, 32.0f, 376.0f, 32.0f)
                close()
                moveTo(384.0f, 224.0f)
                curveTo(401.7f, 224.0f, 416.0f, 238.3f, 416.0f, 256.0f)
                curveTo(416.0f, 273.7f, 401.7f, 288.0f, 384.0f, 288.0f)
                curveTo(366.3f, 288.0f, 352.0f, 273.7f, 352.0f, 256.0f)
                curveTo(352.0f, 238.3f, 366.3f, 224.0f, 384.0f, 224.0f)
                close()
                moveTo(352.0f, 152.0f)
                curveTo(352.0f, 138.7f, 362.7f, 128.0f, 376.0f, 128.0f)
                curveTo(451.1f, 128.0f, 512.0f, 188.9f, 512.0f, 264.0f)
                curveTo(512.0f, 277.3f, 501.3f, 288.0f, 488.0f, 288.0f)
                curveTo(474.7f, 288.0f, 464.0f, 277.3f, 464.0f, 264.0f)
                curveTo(464.0f, 215.4f, 424.6f, 176.0f, 376.0f, 176.0f)
                curveTo(362.7f, 176.0f, 352.0f, 165.3f, 352.0f, 152.0f)
                close()
                moveTo(176.1f, 65.4f)
                curveTo(195.8f, 60.0f, 216.4f, 70.1f, 224.2f, 88.9f)
                lineTo(264.7f, 186.2f)
                curveTo(271.6f, 202.7f, 266.8f, 221.8f, 252.9f, 233.2f)
                lineTo(208.8f, 269.3f)
                curveTo(241.3f, 340.9f, 297.8f, 399.3f, 368.1f, 434.2f)
                lineTo(406.7f, 387.0f)
                curveTo(418.0f, 373.1f, 437.1f, 368.4f, 453.7f, 375.2f)
                lineTo(551.0f, 415.8f)
                curveTo(569.8f, 423.6f, 579.9f, 444.2f, 574.5f, 463.9f)
                lineTo(573.0f, 469.4f)
                curveTo(555.4f, 534.1f, 492.9f, 589.3f, 416.6f, 573.2f)
                curveTo(241.6f, 536.1f, 103.9f, 398.4f, 66.8f, 223.4f)
                curveTo(50.7f, 147.1f, 105.9f, 84.6f, 170.5f, 66.9f)
                lineTo(176.0f, 65.4f)
                close()
            }
        }
        .build()
        return `_volume-control-phone`!!
    }

private var `_volume-control-phone`: ImageVector? = null
