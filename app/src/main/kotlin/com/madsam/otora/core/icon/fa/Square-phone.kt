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

public val Fa.`Square-phone`: ImageVector
    get() {
        if (`_square-phone` != null) {
            return `_square-phone`!!
        }
        `_square-phone` = Builder(name = "Square-phone", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(248.0f, 192.7f)
                curveTo(257.8f, 190.0f, 268.1f, 195.1f, 272.0f, 204.5f)
                lineTo(292.3f, 253.2f)
                curveTo(295.7f, 261.5f, 293.4f, 271.0f, 286.4f, 276.7f)
                lineTo(264.3f, 294.7f)
                curveTo(280.5f, 330.5f, 308.8f, 359.7f, 343.9f, 377.1f)
                lineTo(363.2f, 353.5f)
                curveTo(368.9f, 346.6f, 378.4f, 344.2f, 386.7f, 347.6f)
                lineTo(435.4f, 367.9f)
                curveTo(444.8f, 371.8f, 449.8f, 382.1f, 447.2f, 391.9f)
                lineTo(446.4f, 394.7f)
                curveTo(437.6f, 427.0f, 406.3f, 454.6f, 368.2f, 446.5f)
                curveTo(280.7f, 428.0f, 211.9f, 359.1f, 193.3f, 271.6f)
                curveTo(185.2f, 233.5f, 212.8f, 202.2f, 245.1f, 193.4f)
                lineTo(247.9f, 192.6f)
                close()
            }
        }
        .build()
        return `_square-phone`!!
    }

private var `_square-phone`: ImageVector? = null
