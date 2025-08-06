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

public val Fa.`Envelope-open-text`: ImageVector
    get() {
        if (`_envelope-open-text` != null) {
            return `_envelope-open-text`!!
        }
        `_envelope-open-text` = Builder(name = "Envelope-open-text", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 97.9f)
                lineTo(128.4f, 239.8f)
                lineTo(286.5f, 357.0f)
                curveTo(291.8f, 360.9f, 297.7f, 363.9f, 304.0f, 365.7f)
                lineTo(304.0f, 528.0f)
                curveTo(304.0f, 533.5f, 304.5f, 538.8f, 305.3f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                lineTo(64.0f, 240.1f)
                curveTo(64.0f, 219.8f, 73.6f, 200.7f, 89.9f, 188.7f)
                lineTo(286.5f, 43.0f)
                curveTo(296.2f, 35.8f, 307.9f, 32.0f, 320.0f, 32.0f)
                curveTo(332.1f, 32.0f, 343.8f, 35.9f, 353.5f, 43.0f)
                lineTo(550.1f, 188.7f)
                curveTo(557.3f, 194.0f, 563.2f, 200.7f, 567.5f, 208.3f)
                curveTo(565.0f, 208.1f, 562.5f, 208.0f, 560.0f, 208.0f)
                lineTo(468.6f, 208.0f)
                lineTo(320.0f, 97.9f)
                close()
                moveTo(352.0f, 304.0f)
                curveTo(352.0f, 277.5f, 373.5f, 256.0f, 400.0f, 256.0f)
                lineTo(560.0f, 256.0f)
                curveTo(586.5f, 256.0f, 608.0f, 277.5f, 608.0f, 304.0f)
                lineTo(608.0f, 528.0f)
                curveTo(608.0f, 554.5f, 586.5f, 576.0f, 560.0f, 576.0f)
                lineTo(400.0f, 576.0f)
                curveTo(373.5f, 576.0f, 352.0f, 554.5f, 352.0f, 528.0f)
                lineTo(352.0f, 304.0f)
                close()
                moveTo(432.0f, 320.0f)
                curveTo(418.7f, 320.0f, 408.0f, 330.7f, 408.0f, 344.0f)
                curveTo(408.0f, 357.3f, 418.7f, 368.0f, 432.0f, 368.0f)
                lineTo(528.0f, 368.0f)
                curveTo(541.3f, 368.0f, 552.0f, 357.3f, 552.0f, 344.0f)
                curveTo(552.0f, 330.7f, 541.3f, 320.0f, 528.0f, 320.0f)
                lineTo(432.0f, 320.0f)
                close()
                moveTo(432.0f, 416.0f)
                curveTo(418.7f, 416.0f, 408.0f, 426.7f, 408.0f, 440.0f)
                curveTo(408.0f, 453.3f, 418.7f, 464.0f, 432.0f, 464.0f)
                lineTo(488.0f, 464.0f)
                curveTo(501.3f, 464.0f, 512.0f, 453.3f, 512.0f, 440.0f)
                curveTo(512.0f, 426.7f, 501.3f, 416.0f, 488.0f, 416.0f)
                lineTo(432.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_envelope-open-text`!!
    }

private var `_envelope-open-text`: ImageVector? = null
