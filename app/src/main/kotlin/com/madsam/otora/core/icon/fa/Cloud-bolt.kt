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

public val Fa.`Cloud-bolt`: ImageVector
    get() {
        if (`_cloud-bolt` != null) {
            return `_cloud-bolt`!!
        }
        `_cloud-bolt` = Builder(name = "Cloud-bolt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 288.0f)
                curveTo(64.0f, 341.0f, 107.0f, 384.0f, 160.0f, 384.0f)
                lineTo(198.6f, 384.0f)
                lineTo(322.7f, 273.0f)
                curveTo(334.9f, 262.1f, 350.7f, 256.0f, 367.1f, 256.0f)
                curveTo(411.7f, 256.0f, 443.6f, 299.0f, 430.8f, 341.7f)
                lineTo(418.1f, 384.0f)
                lineTo(480.0f, 384.0f)
                curveTo(533.0f, 384.0f, 576.0f, 341.0f, 576.0f, 288.0f)
                curveTo(576.0f, 235.0f, 533.0f, 192.0f, 480.0f, 192.0f)
                curveTo(479.5f, 192.0f, 478.9f, 192.0f, 478.4f, 192.0f)
                curveTo(479.5f, 186.8f, 480.0f, 181.5f, 480.0f, 176.0f)
                curveTo(480.0f, 131.8f, 444.2f, 96.0f, 400.0f, 96.0f)
                curveTo(375.7f, 96.0f, 353.9f, 106.9f, 339.2f, 124.0f)
                curveTo(320.5f, 88.3f, 283.1f, 64.0f, 240.0f, 64.0f)
                curveTo(178.1f, 64.0f, 128.0f, 114.1f, 128.0f, 176.0f)
                curveTo(128.0f, 183.1f, 128.7f, 190.1f, 129.9f, 196.8f)
                curveTo(91.6f, 209.4f, 64.0f, 245.5f, 64.0f, 288.0f)
                close()
                moveTo(224.6f, 464.0f)
                lineTo(286.4f, 464.0f)
                lineTo(255.2f, 568.1f)
                curveTo(251.6f, 580.0f, 260.5f, 592.0f, 273.0f, 592.0f)
                curveTo(277.6f, 592.0f, 282.0f, 590.3f, 285.4f, 587.3f)
                lineTo(426.5f, 460.9f)
                curveTo(430.0f, 457.8f, 432.0f, 453.3f, 432.0f, 448.5f)
                curveTo(432.0f, 439.3f, 424.6f, 431.9f, 415.4f, 431.9f)
                lineTo(353.6f, 431.9f)
                lineTo(384.8f, 327.8f)
                curveTo(388.4f, 315.9f, 379.5f, 303.9f, 367.0f, 303.9f)
                curveTo(362.4f, 303.9f, 358.0f, 305.6f, 354.6f, 308.6f)
                lineTo(213.5f, 435.1f)
                curveTo(210.0f, 438.2f, 208.0f, 442.7f, 208.0f, 447.5f)
                curveTo(208.0f, 456.7f, 215.4f, 464.1f, 224.6f, 464.1f)
                close()
            }
        }
        .build()
        return `_cloud-bolt`!!
    }

private var `_cloud-bolt`: ImageVector? = null
