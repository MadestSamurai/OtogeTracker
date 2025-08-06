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

public val Fa.`Draw-polygon`: ImageVector
    get() {
        if (`_draw-polygon` != null) {
            return `_draw-polygon`!!
        }
        `_draw-polygon` = Builder(name = "Draw-polygon", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(151.7f, 64.0f, 172.4f, 76.9f, 183.4f, 96.0f)
                lineTo(456.5f, 96.0f)
                curveTo(467.6f, 76.9f, 488.2f, 64.0f, 511.9f, 64.0f)
                curveTo(547.2f, 64.0f, 575.9f, 92.7f, 575.9f, 128.0f)
                curveTo(575.9f, 162.0f, 549.4f, 189.8f, 515.9f, 191.9f)
                lineTo(513.8f, 194.8f)
                lineTo(442.3f, 293.9f)
                curveTo(445.9f, 301.9f, 447.9f, 310.8f, 447.9f, 320.1f)
                curveTo(447.9f, 329.4f, 445.9f, 338.3f, 442.3f, 346.3f)
                lineTo(444.5f, 349.4f)
                lineTo(513.8f, 445.4f)
                lineTo(515.9f, 448.3f)
                curveTo(549.4f, 450.4f, 575.9f, 478.2f, 575.9f, 512.2f)
                curveTo(575.9f, 547.5f, 547.2f, 576.2f, 511.9f, 576.2f)
                curveTo(488.2f, 576.2f, 467.5f, 563.3f, 456.5f, 544.2f)
                lineTo(183.4f, 544.2f)
                curveTo(172.3f, 563.3f, 151.7f, 576.2f, 128.0f, 576.2f)
                curveTo(92.7f, 576.2f, 64.0f, 547.5f, 64.0f, 512.2f)
                curveTo(64.0f, 488.5f, 76.9f, 467.8f, 96.0f, 456.8f)
                lineTo(96.0f, 183.7f)
                curveTo(76.9f, 172.4f, 64.0f, 151.7f, 64.0f, 128.0f)
                curveTo(64.0f, 92.7f, 92.7f, 64.0f, 128.0f, 64.0f)
                close()
                moveTo(458.2f, 477.4f)
                lineTo(392.7f, 386.8f)
                lineTo(390.5f, 383.7f)
                curveTo(388.4f, 383.9f, 386.2f, 384.0f, 384.0f, 384.0f)
                curveTo(348.7f, 384.0f, 320.0f, 355.3f, 320.0f, 320.0f)
                curveTo(320.0f, 284.7f, 348.7f, 256.0f, 384.0f, 256.0f)
                curveTo(386.2f, 256.0f, 388.4f, 256.1f, 390.5f, 256.3f)
                lineTo(458.2f, 162.6f)
                curveTo(457.6f, 161.7f, 457.1f, 160.9f, 456.6f, 160.0f)
                lineTo(183.4f, 160.0f)
                curveTo(177.8f, 169.7f, 169.7f, 177.8f, 160.0f, 183.4f)
                lineTo(160.0f, 456.5f)
                curveTo(169.7f, 462.1f, 177.8f, 470.2f, 183.4f, 479.9f)
                lineTo(456.5f, 479.9f)
                curveTo(457.0f, 479.0f, 457.6f, 478.1f, 458.1f, 477.3f)
                close()
            }
        }
        .build()
        return `_draw-polygon`!!
    }

private var `_draw-polygon`: ImageVector? = null
