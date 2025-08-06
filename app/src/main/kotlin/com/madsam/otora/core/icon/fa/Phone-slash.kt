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

public val Fa.`Phone-slash`: ImageVector
    get() {
        if (`_phone-slash` != null) {
            return `_phone-slash`!!
        }
        `_phone-slash` = Builder(name = "Phone-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(567.0f, 39.1f)
                curveTo(576.4f, 29.7f, 591.6f, 29.7f, 600.9f, 39.1f)
                curveTo(610.2f, 48.5f, 610.3f, 63.7f, 600.9f, 73.0f)
                lineTo(73.0f, 601.1f)
                curveTo(63.6f, 610.5f, 48.4f, 610.5f, 39.1f, 601.1f)
                curveTo(29.8f, 591.7f, 29.7f, 576.5f, 39.1f, 567.2f)
                lineTo(173.5f, 432.6f)
                curveTo(121.2f, 374.5f, 83.6f, 302.8f, 66.8f, 223.4f)
                curveTo(50.7f, 147.1f, 105.9f, 84.6f, 170.5f, 66.9f)
                lineTo(176.0f, 65.4f)
                curveTo(195.7f, 60.0f, 216.3f, 70.1f, 224.1f, 88.9f)
                lineTo(264.6f, 186.2f)
                curveTo(271.5f, 202.7f, 266.7f, 221.8f, 252.8f, 233.2f)
                lineTo(208.7f, 269.3f)
                curveTo(221.6f, 297.8f, 238.3f, 324.1f, 258.2f, 347.8f)
                lineTo(567.0f, 39.1f)
                close()
                moveTo(416.6f, 573.1f)
                curveTo(353.6f, 559.7f, 295.3f, 533.3f, 244.9f, 496.8f)
                lineTo(329.8f, 412.0f)
                curveTo(342.0f, 420.2f, 354.8f, 427.6f, 368.1f, 434.2f)
                lineTo(406.7f, 387.0f)
                curveTo(418.0f, 373.1f, 437.1f, 368.4f, 453.7f, 375.2f)
                lineTo(551.0f, 415.8f)
                curveTo(569.8f, 423.6f, 579.9f, 444.2f, 574.5f, 463.9f)
                lineTo(573.0f, 469.4f)
                curveTo(555.4f, 534.0f, 492.8f, 589.2f, 416.6f, 573.1f)
                close()
            }
        }
        .build()
        return `_phone-slash`!!
    }

private var `_phone-slash`: ImageVector? = null
