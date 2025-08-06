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

public val Fa.`Oil-can`: ImageVector
    get() {
        if (`_oil-can` != null) {
            return `_oil-can`!!
        }
        `_oil-can` = Builder(name = "Oil-can", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 177.7f, 352.0f, 160.0f)
                curveTo(352.0f, 142.3f, 337.7f, 128.0f, 320.0f, 128.0f)
                lineTo(192.0f, 128.0f)
                curveTo(174.3f, 128.0f, 160.0f, 142.3f, 160.0f, 160.0f)
                curveTo(160.0f, 177.7f, 174.3f, 192.0f, 192.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                lineTo(224.0f, 224.0f)
                lineTo(48.0f, 224.0f)
                curveTo(21.5f, 224.0f, 0.0f, 245.5f, 0.0f, 272.0f)
                lineTo(0.0f, 336.8f)
                curveTo(0.0f, 355.8f, 11.2f, 373.0f, 28.5f, 380.7f)
                lineTo(96.0f, 410.7f)
                lineTo(96.0f, 432.0f)
                curveTo(96.0f, 458.5f, 117.5f, 480.0f, 144.0f, 480.0f)
                lineTo(403.1f, 480.0f)
                curveTo(421.5f, 480.0f, 438.9f, 472.1f, 451.1f, 458.3f)
                lineTo(633.5f, 251.7f)
                curveTo(645.8f, 237.8f, 633.2f, 216.3f, 615.1f, 220.2f)
                lineTo(448.0f, 256.0f)
                lineTo(397.5f, 230.8f)
                curveTo(388.6f, 226.4f, 378.8f, 224.0f, 368.9f, 224.0f)
                lineTo(288.0f, 224.0f)
                lineTo(288.0f, 192.0f)
                lineTo(320.0f, 192.0f)
                close()
                moveTo(96.0f, 272.0f)
                lineTo(96.0f, 358.1f)
                lineTo(48.0f, 336.8f)
                lineTo(48.0f, 272.0f)
                lineTo(96.0f, 272.0f)
                close()
            }
        }
        .build()
        return `_oil-can`!!
    }

private var `_oil-can`: ImageVector? = null
