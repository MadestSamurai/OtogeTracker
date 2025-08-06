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

public val Fa.Vest: ImageVector
    get() {
        if (_vest != null) {
            return _vest!!
        }
        _vest = Builder(name = "Vest", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.0f, 528.0f)
                lineTo(296.0f, 357.9f)
                curveTo(296.0f, 354.0f, 295.5f, 350.1f, 294.6f, 346.3f)
                lineTo(240.4f, 129.4f)
                curveTo(258.1f, 141.2f, 284.2f, 152.0f, 320.0f, 152.0f)
                curveTo(355.8f, 152.0f, 381.9f, 141.2f, 399.6f, 129.4f)
                lineTo(345.4f, 346.3f)
                curveTo(344.4f, 350.1f, 344.0f, 354.0f, 344.0f, 357.9f)
                lineTo(344.0f, 528.0f)
                curveTo(344.0f, 554.5f, 365.5f, 576.0f, 392.0f, 576.0f)
                lineTo(496.0f, 576.0f)
                curveTo(522.5f, 576.0f, 544.0f, 554.5f, 544.0f, 528.0f)
                lineTo(544.0f, 334.5f)
                curveTo(544.0f, 325.0f, 541.2f, 315.8f, 535.9f, 307.9f)
                lineTo(488.0f, 236.1f)
                curveTo(482.7f, 228.2f, 479.9f, 219.0f, 479.9f, 209.5f)
                lineTo(480.0f, 112.0f)
                curveTo(480.0f, 85.5f, 458.5f, 64.0f, 432.0f, 64.0f)
                lineTo(428.5f, 64.0f)
                curveTo(428.2f, 64.0f, 427.9f, 64.0f, 427.5f, 64.0f)
                curveTo(426.9f, 64.0f, 426.3f, 64.0f, 425.7f, 64.0f)
                curveTo(406.9f, 64.0f, 391.6f, 73.7f, 381.6f, 82.8f)
                curveTo(372.3f, 91.2f, 353.1f, 104.0f, 319.9f, 104.0f)
                curveTo(286.7f, 104.0f, 267.5f, 91.2f, 258.2f, 82.8f)
                curveTo(248.2f, 73.7f, 232.9f, 64.0f, 214.1f, 64.0f)
                curveTo(213.5f, 64.0f, 212.9f, 64.0f, 212.3f, 64.0f)
                curveTo(212.0f, 64.0f, 211.7f, 64.0f, 211.3f, 64.0f)
                lineTo(208.0f, 64.0f)
                curveTo(181.5f, 64.0f, 160.0f, 85.5f, 160.0f, 112.0f)
                lineTo(160.0f, 209.5f)
                curveTo(160.0f, 219.0f, 157.2f, 228.2f, 151.9f, 236.1f)
                lineTo(104.1f, 307.9f)
                curveTo(98.8f, 315.8f, 96.0f, 325.1f, 96.0f, 334.5f)
                lineTo(96.0f, 528.0f)
                curveTo(96.0f, 554.5f, 117.5f, 576.0f, 144.0f, 576.0f)
                lineTo(248.0f, 576.0f)
                curveTo(274.5f, 576.0f, 296.0f, 554.5f, 296.0f, 528.0f)
                close()
            }
        }
        .build()
        return _vest!!
    }

private var _vest: ImageVector? = null
