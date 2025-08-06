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

public val Fa.`Bottle-droplet`: ImageVector
    get() {
        if (`_bottle-droplet` != null) {
            return `_bottle-droplet`!!
        }
        `_bottle-droplet` = Builder(name = "Bottle-droplet", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 64.0f)
                curveTo(240.0f, 46.3f, 254.3f, 32.0f, 272.0f, 32.0f)
                lineTo(368.0f, 32.0f)
                curveTo(385.7f, 32.0f, 400.0f, 46.3f, 400.0f, 64.0f)
                curveTo(400.0f, 81.7f, 385.7f, 96.0f, 368.0f, 96.0f)
                lineTo(368.0f, 199.3f)
                curveTo(432.9f, 219.7f, 480.0f, 280.3f, 480.0f, 352.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 579.3f, 451.3f, 608.0f, 416.0f, 608.0f)
                lineTo(224.0f, 608.0f)
                curveTo(188.7f, 608.0f, 160.0f, 579.3f, 160.0f, 544.0f)
                lineTo(160.0f, 352.0f)
                curveTo(160.0f, 280.4f, 207.1f, 219.7f, 272.0f, 199.3f)
                lineTo(272.0f, 96.0f)
                curveTo(254.3f, 96.0f, 240.0f, 81.7f, 240.0f, 64.0f)
                close()
                moveTo(320.0f, 480.0f)
                curveTo(355.3f, 480.0f, 384.0f, 447.6f, 384.0f, 416.0f)
                curveTo(384.0f, 394.8f, 355.1f, 351.5f, 336.1f, 325.4f)
                curveTo(328.0f, 314.3f, 311.9f, 314.3f, 303.8f, 325.4f)
                curveTo(284.8f, 351.5f, 255.9f, 394.8f, 255.9f, 416.0f)
                curveTo(255.9f, 447.6f, 284.6f, 480.0f, 319.9f, 480.0f)
                close()
            }
        }
        .build()
        return `_bottle-droplet`!!
    }

private var `_bottle-droplet`: ImageVector? = null
