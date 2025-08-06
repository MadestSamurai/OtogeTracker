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

public val Fa.`Phone-flip`: ImageVector
    get() {
        if (`_phone-flip` != null) {
            return `_phone-flip`!!
        }
        `_phone-flip` = Builder(name = "Phone-flip", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(415.8f, 89.0f)
                curveTo(423.6f, 70.2f, 444.2f, 60.1f, 463.9f, 65.5f)
                lineTo(469.4f, 67.0f)
                curveTo(534.0f, 84.6f, 589.2f, 147.2f, 573.1f, 223.4f)
                curveTo(536.0f, 398.4f, 398.3f, 536.1f, 223.3f, 573.2f)
                curveTo(147.0f, 589.4f, 84.5f, 534.1f, 66.9f, 469.5f)
                lineTo(65.4f, 464.0f)
                curveTo(60.0f, 444.3f, 70.1f, 423.7f, 88.9f, 415.9f)
                lineTo(186.2f, 375.4f)
                curveTo(202.7f, 368.5f, 221.8f, 373.3f, 233.2f, 387.2f)
                lineTo(271.8f, 434.4f)
                curveTo(342.1f, 399.5f, 398.6f, 341.1f, 431.1f, 269.5f)
                lineTo(387.0f, 233.4f)
                curveTo(373.1f, 222.1f, 368.4f, 203.0f, 375.2f, 186.4f)
                lineTo(415.8f, 89.0f)
                close()
            }
        }
        .build()
        return `_phone-flip`!!
    }

private var `_phone-flip`: ImageVector? = null
