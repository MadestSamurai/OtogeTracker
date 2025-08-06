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

public val Fa.`Mug-hot`: ImageVector
    get() {
        if (`_mug-hot` != null) {
            return `_mug-hot`!!
        }
        `_mug-hot` = Builder(name = "Mug-hot", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(184.0f, 48.0f)
                curveTo(170.7f, 48.0f, 160.0f, 58.7f, 160.0f, 72.0f)
                curveTo(160.0f, 110.9f, 183.4f, 131.4f, 199.1f, 145.1f)
                lineTo(200.2f, 146.1f)
                curveTo(216.5f, 160.4f, 224.0f, 167.9f, 224.0f, 184.0f)
                curveTo(224.0f, 197.3f, 234.7f, 208.0f, 248.0f, 208.0f)
                curveTo(261.3f, 208.0f, 272.0f, 197.3f, 272.0f, 184.0f)
                curveTo(272.0f, 145.1f, 248.6f, 124.6f, 232.9f, 110.9f)
                lineTo(231.8f, 109.9f)
                curveTo(215.5f, 95.7f, 208.0f, 88.1f, 208.0f, 72.0f)
                curveTo(208.0f, 58.7f, 197.3f, 48.0f, 184.0f, 48.0f)
                close()
                moveTo(128.0f, 256.0f)
                curveTo(110.3f, 256.0f, 96.0f, 270.3f, 96.0f, 288.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 533.0f, 139.0f, 576.0f, 192.0f, 576.0f)
                lineTo(384.0f, 576.0f)
                curveTo(425.8f, 576.0f, 461.4f, 549.3f, 474.5f, 512.0f)
                lineTo(480.0f, 512.0f)
                curveTo(550.7f, 512.0f, 608.0f, 454.7f, 608.0f, 384.0f)
                curveTo(608.0f, 313.3f, 550.7f, 256.0f, 480.0f, 256.0f)
                lineTo(128.0f, 256.0f)
                close()
                moveTo(480.0f, 448.0f)
                lineTo(480.0f, 320.0f)
                curveTo(515.3f, 320.0f, 544.0f, 348.7f, 544.0f, 384.0f)
                curveTo(544.0f, 419.3f, 515.3f, 448.0f, 480.0f, 448.0f)
                close()
                moveTo(320.0f, 72.0f)
                curveTo(320.0f, 58.7f, 309.3f, 48.0f, 296.0f, 48.0f)
                curveTo(282.7f, 48.0f, 272.0f, 58.7f, 272.0f, 72.0f)
                curveTo(272.0f, 110.9f, 295.4f, 131.4f, 311.1f, 145.1f)
                lineTo(312.2f, 146.1f)
                curveTo(328.5f, 160.4f, 336.0f, 167.9f, 336.0f, 184.0f)
                curveTo(336.0f, 197.3f, 346.7f, 208.0f, 360.0f, 208.0f)
                curveTo(373.3f, 208.0f, 384.0f, 197.3f, 384.0f, 184.0f)
                curveTo(384.0f, 145.1f, 360.6f, 124.6f, 344.9f, 110.9f)
                lineTo(343.8f, 109.9f)
                curveTo(327.5f, 95.7f, 320.0f, 88.1f, 320.0f, 72.0f)
                close()
            }
        }
        .build()
        return `_mug-hot`!!
    }

private var `_mug-hot`: ImageVector? = null
