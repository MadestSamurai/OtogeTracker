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

public val Fa.`Envelope-square`: ImageVector
    get() {
        if (`_envelope-square` != null) {
            return `_envelope-square`!!
        }
        `_envelope-square` = Builder(name = "Envelope-square", defaultWidth = 640.0.dp,
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
                moveTo(305.1f, 331.9f)
                lineTo(204.4f, 271.4f)
                curveTo(196.7f, 266.8f, 192.0f, 258.5f, 192.0f, 249.5f)
                curveTo(192.0f, 235.4f, 203.4f, 224.0f, 217.5f, 224.0f)
                lineTo(422.4f, 224.0f)
                curveTo(436.5f, 224.0f, 447.9f, 235.4f, 447.9f, 249.5f)
                curveTo(447.9f, 258.5f, 443.2f, 266.8f, 435.5f, 271.4f)
                lineTo(334.9f, 331.9f)
                curveTo(330.4f, 334.6f, 325.3f, 336.0f, 320.0f, 336.0f)
                curveTo(314.7f, 336.0f, 309.6f, 334.6f, 305.1f, 331.9f)
                close()
                moveTo(448.0f, 301.3f)
                lineTo(448.0f, 384.0f)
                curveTo(448.0f, 401.7f, 433.7f, 416.0f, 416.0f, 416.0f)
                lineTo(224.0f, 416.0f)
                curveTo(206.3f, 416.0f, 192.0f, 401.7f, 192.0f, 384.0f)
                lineTo(192.0f, 301.3f)
                lineTo(288.7f, 359.3f)
                curveTo(298.1f, 365.0f, 309.0f, 368.0f, 320.0f, 368.0f)
                curveTo(331.0f, 368.0f, 341.9f, 365.0f, 351.3f, 359.3f)
                lineTo(448.0f, 301.3f)
                close()
            }
        }
        .build()
        return `_envelope-square`!!
    }

private var `_envelope-square`: ImageVector? = null
