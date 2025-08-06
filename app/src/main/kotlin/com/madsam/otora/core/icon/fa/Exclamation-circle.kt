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

public val Fa.`Exclamation-circle`: ImageVector
    get() {
        if (`_exclamation-circle` != null) {
            return `_exclamation-circle`!!
        }
        `_exclamation-circle` = Builder(name = "Exclamation-circle", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(320.0f, 200.0f)
                curveTo(333.3f, 200.0f, 344.0f, 210.7f, 344.0f, 224.0f)
                lineTo(344.0f, 336.0f)
                curveTo(344.0f, 349.3f, 333.3f, 360.0f, 320.0f, 360.0f)
                curveTo(306.7f, 360.0f, 296.0f, 349.3f, 296.0f, 336.0f)
                lineTo(296.0f, 224.0f)
                curveTo(296.0f, 210.7f, 306.7f, 200.0f, 320.0f, 200.0f)
                close()
                moveTo(293.3f, 416.0f)
                curveTo(292.7f, 406.1f, 297.6f, 396.7f, 306.1f, 391.5f)
                curveTo(314.6f, 386.4f, 325.3f, 386.4f, 333.8f, 391.5f)
                curveTo(342.3f, 396.7f, 347.2f, 406.1f, 346.6f, 416.0f)
                curveTo(347.2f, 425.9f, 342.3f, 435.3f, 333.8f, 440.5f)
                curveTo(325.3f, 445.6f, 314.6f, 445.6f, 306.1f, 440.5f)
                curveTo(297.6f, 435.3f, 292.7f, 425.9f, 293.3f, 416.0f)
                close()
            }
        }
        .build()
        return `_exclamation-circle`!!
    }

private var `_exclamation-circle`: ImageVector? = null
