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

public val Fa.`House-medical-flag`: ImageVector
    get() {
        if (`_house-medical-flag` != null) {
            return `_house-medical-flag`!!
        }
        `_house-medical-flag` = Builder(name = "House-medical-flag", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 64.0f)
                curveTo(497.7f, 64.0f, 512.0f, 78.3f, 512.0f, 96.0f)
                lineTo(608.0f, 96.0f)
                curveTo(625.7f, 96.0f, 640.0f, 110.3f, 640.0f, 128.0f)
                lineTo(640.0f, 224.0f)
                curveTo(640.0f, 241.7f, 625.7f, 256.0f, 608.0f, 256.0f)
                lineTo(512.0f, 256.0f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                curveTo(462.3f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(448.0f, 96.0f)
                curveTo(448.0f, 78.3f, 462.3f, 64.0f, 480.0f, 64.0f)
                close()
                moveTo(267.5f, 123.1f)
                lineTo(400.0f, 250.9f)
                lineTo(400.0f, 567.4f)
                curveTo(390.6f, 572.8f, 379.7f, 576.0f, 368.0f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(76.7f, 576.0f, 48.0f, 547.3f, 48.0f, 512.0f)
                lineTo(48.0f, 368.0f)
                lineTo(28.1f, 368.0f)
                curveTo(12.6f, 368.0f, 0.0f, 355.4f, 0.0f, 339.9f)
                curveTo(0.0f, 332.3f, 3.1f, 325.0f, 8.6f, 319.7f)
                lineTo(212.5f, 123.1f)
                curveTo(219.9f, 116.0f, 229.7f, 112.0f, 240.0f, 112.0f)
                curveTo(250.3f, 112.0f, 260.1f, 116.0f, 267.5f, 123.1f)
                close()
                moveTo(204.8f, 320.8f)
                lineTo(204.8f, 364.8f)
                lineTo(160.8f, 364.8f)
                curveTo(151.1f, 364.8f, 143.2f, 372.7f, 143.2f, 382.4f)
                lineTo(143.2f, 417.6f)
                curveTo(143.2f, 427.3f, 151.1f, 435.2f, 160.8f, 435.2f)
                lineTo(204.8f, 435.2f)
                lineTo(204.8f, 479.2f)
                curveTo(204.8f, 488.9f, 212.7f, 496.8f, 222.4f, 496.8f)
                lineTo(257.6f, 496.8f)
                curveTo(267.3f, 496.8f, 275.2f, 488.9f, 275.2f, 479.2f)
                lineTo(275.2f, 435.2f)
                lineTo(319.2f, 435.2f)
                curveTo(328.9f, 435.2f, 336.8f, 427.3f, 336.8f, 417.6f)
                lineTo(336.8f, 382.4f)
                curveTo(336.8f, 372.7f, 328.9f, 364.8f, 319.2f, 364.8f)
                lineTo(275.2f, 364.8f)
                lineTo(275.2f, 320.8f)
                curveTo(275.2f, 311.1f, 267.3f, 303.2f, 257.6f, 303.2f)
                lineTo(222.4f, 303.2f)
                curveTo(212.7f, 303.2f, 204.8f, 311.1f, 204.8f, 320.8f)
                close()
            }
        }
        .build()
        return `_house-medical-flag`!!
    }

private var `_house-medical-flag`: ImageVector? = null
