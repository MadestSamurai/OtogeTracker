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

public val Fa.`Layer-group`: ImageVector
    get() {
        if (`_layer-group` != null) {
            return `_layer-group`!!
        }
        `_layer-group` = Builder(name = "Layer-group", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.5f, 69.2f)
                curveTo(311.4f, 62.3f, 328.6f, 62.3f, 343.5f, 69.2f)
                lineTo(562.1f, 170.2f)
                curveTo(570.6f, 174.1f, 576.0f, 182.6f, 576.0f, 192.0f)
                curveTo(576.0f, 201.4f, 570.6f, 209.9f, 562.1f, 213.8f)
                lineTo(343.5f, 314.8f)
                curveTo(328.6f, 321.7f, 311.4f, 321.7f, 296.5f, 314.8f)
                lineTo(77.9f, 213.8f)
                curveTo(69.4f, 209.8f, 64.0f, 201.3f, 64.0f, 192.0f)
                curveTo(64.0f, 182.7f, 69.4f, 174.1f, 77.9f, 170.2f)
                lineTo(296.5f, 69.2f)
                close()
                moveTo(112.1f, 282.4f)
                lineTo(276.4f, 358.3f)
                curveTo(304.1f, 371.1f, 336.0f, 371.1f, 363.7f, 358.3f)
                lineTo(528.0f, 282.4f)
                lineTo(562.1f, 298.2f)
                curveTo(570.6f, 302.1f, 576.0f, 310.6f, 576.0f, 320.0f)
                curveTo(576.0f, 329.4f, 570.6f, 337.9f, 562.1f, 341.8f)
                lineTo(343.5f, 442.8f)
                curveTo(328.6f, 449.7f, 311.4f, 449.7f, 296.5f, 442.8f)
                lineTo(77.9f, 341.8f)
                curveTo(69.4f, 337.8f, 64.0f, 329.3f, 64.0f, 320.0f)
                curveTo(64.0f, 310.7f, 69.4f, 302.1f, 77.9f, 298.2f)
                lineTo(112.0f, 282.4f)
                close()
                moveTo(77.9f, 426.2f)
                lineTo(112.0f, 410.4f)
                lineTo(276.3f, 486.3f)
                curveTo(304.0f, 499.1f, 335.9f, 499.1f, 363.6f, 486.3f)
                lineTo(527.9f, 410.4f)
                lineTo(562.0f, 426.2f)
                curveTo(570.5f, 430.1f, 575.9f, 438.6f, 575.9f, 448.0f)
                curveTo(575.9f, 457.4f, 570.5f, 465.9f, 562.0f, 469.8f)
                lineTo(343.4f, 570.8f)
                curveTo(328.5f, 577.7f, 311.3f, 577.7f, 296.4f, 570.8f)
                lineTo(77.9f, 469.8f)
                curveTo(69.4f, 465.8f, 64.0f, 457.3f, 64.0f, 448.0f)
                curveTo(64.0f, 438.7f, 69.4f, 430.1f, 77.9f, 426.2f)
                close()
            }
        }
        .build()
        return `_layer-group`!!
    }

private var `_layer-group`: ImageVector? = null
