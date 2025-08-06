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

public val Fa.`Envelope-open`: ImageVector
    get() {
        if (`_envelope-open` != null) {
            return `_envelope-open`!!
        }
        `_envelope-open` = Builder(name = "Envelope-open", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.4f, 239.8f)
                lineTo(320.0f, 97.9f)
                lineTo(511.6f, 239.8f)
                lineTo(353.5f, 357.0f)
                curveTo(343.8f, 364.2f, 332.1f, 368.0f, 320.0f, 368.0f)
                curveTo(307.9f, 368.0f, 296.2f, 364.1f, 286.5f, 357.0f)
                lineTo(128.4f, 239.8f)
                close()
                moveTo(320.0f, 32.0f)
                curveTo(307.9f, 32.0f, 296.2f, 35.9f, 286.5f, 43.0f)
                lineTo(89.9f, 188.7f)
                curveTo(73.6f, 200.8f, 64.0f, 219.8f, 64.0f, 240.1f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 240.1f)
                curveTo(576.0f, 219.8f, 566.4f, 200.7f, 550.1f, 188.7f)
                lineTo(353.5f, 43.0f)
                curveTo(343.8f, 35.8f, 332.1f, 32.0f, 320.0f, 32.0f)
                close()
            }
        }
        .build()
        return `_envelope-open`!!
    }

private var `_envelope-open`: ImageVector? = null
