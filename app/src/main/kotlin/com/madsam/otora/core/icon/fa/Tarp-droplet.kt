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

public val Fa.`Tarp-droplet`: ImageVector
    get() {
        if (`_tarp-droplet` != null) {
            return `_tarp-droplet`!!
        }
        `_tarp-droplet` = Builder(name = "Tarp-droplet", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 224.0f)
                curveTo(355.3f, 224.0f, 384.0f, 197.1f, 384.0f, 164.0f)
                curveTo(384.0f, 140.0f, 350.3f, 93.9f, 331.8f, 70.5f)
                curveTo(325.7f, 62.8f, 314.3f, 62.8f, 308.2f, 70.5f)
                curveTo(289.7f, 93.9f, 256.0f, 140.0f, 256.0f, 164.0f)
                curveTo(256.0f, 197.1f, 284.7f, 224.0f, 320.0f, 224.0f)
                close()
                moveTo(432.0f, 160.0f)
                curveTo(432.0f, 221.9f, 381.9f, 272.0f, 320.0f, 272.0f)
                curveTo(258.1f, 272.0f, 208.0f, 221.9f, 208.0f, 160.0f)
                curveTo(208.0f, 148.9f, 209.6f, 138.1f, 212.6f, 128.0f)
                lineTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(405.5f, 512.0f)
                curveTo(422.5f, 512.0f, 438.8f, 505.3f, 450.8f, 493.3f)
                lineTo(557.3f, 386.7f)
                curveTo(569.3f, 374.7f, 576.0f, 358.4f, 576.0f, 341.4f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(427.4f, 128.0f)
                curveTo(430.4f, 138.1f, 432.0f, 148.9f, 432.0f, 160.0f)
                close()
                moveTo(517.5f, 336.0f)
                lineTo(400.0f, 453.5f)
                lineTo(400.0f, 360.0f)
                curveTo(400.0f, 346.7f, 410.7f, 336.0f, 424.0f, 336.0f)
                lineTo(517.5f, 336.0f)
                close()
                moveTo(160.0f, 192.0f)
                curveTo(177.7f, 192.0f, 192.0f, 206.3f, 192.0f, 224.0f)
                curveTo(192.0f, 241.7f, 177.7f, 256.0f, 160.0f, 256.0f)
                curveTo(142.3f, 256.0f, 128.0f, 241.7f, 128.0f, 224.0f)
                curveTo(128.0f, 206.3f, 142.3f, 192.0f, 160.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_tarp-droplet`!!
    }

private var `_tarp-droplet`: ImageVector? = null
