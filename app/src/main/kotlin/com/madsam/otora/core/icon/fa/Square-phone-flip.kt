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

public val Fa.`Square-phone-flip`: ImageVector
    get() {
        if (`_square-phone-flip` != null) {
            return `_square-phone-flip`!!
        }
        `_square-phone-flip` = Builder(name = "Square-phone-flip", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(392.0f, 192.7f)
                lineTo(394.8f, 193.5f)
                curveTo(427.1f, 202.3f, 454.7f, 233.6f, 446.6f, 271.7f)
                curveTo(428.1f, 359.2f, 359.2f, 428.0f, 271.7f, 446.6f)
                curveTo(233.6f, 454.7f, 202.3f, 427.1f, 193.5f, 394.8f)
                lineTo(192.7f, 392.0f)
                curveTo(190.0f, 382.2f, 195.1f, 371.9f, 204.5f, 368.0f)
                lineTo(253.2f, 347.7f)
                curveTo(261.5f, 344.3f, 271.0f, 346.6f, 276.7f, 353.6f)
                lineTo(296.0f, 377.2f)
                curveTo(331.1f, 359.8f, 359.4f, 330.6f, 375.6f, 294.8f)
                lineTo(353.5f, 276.8f)
                curveTo(346.6f, 271.1f, 344.2f, 261.6f, 347.6f, 253.3f)
                lineTo(367.9f, 204.6f)
                curveTo(371.8f, 195.2f, 382.1f, 190.2f, 391.9f, 192.8f)
                close()
            }
        }
        .build()
        return `_square-phone-flip`!!
    }

private var `_square-phone-flip`: ImageVector? = null
