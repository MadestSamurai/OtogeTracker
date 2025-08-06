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

public val Fa.`Camera-retro`: ImageVector
    get() {
        if (`_camera-retro` != null) {
            return `_camera-retro`!!
        }
        `_camera-retro` = Builder(name = "Camera-retro", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 480.0f)
                lineTo(64.0f, 272.0f)
                lineTo(200.2f, 272.0f)
                curveTo(213.7f, 251.8f, 232.2f, 235.2f, 253.9f, 224.0f)
                lineTo(64.0f, 224.0f)
                lineTo(64.0f, 189.7f)
                curveTo(64.0f, 154.4f, 92.7f, 125.7f, 128.0f, 125.7f)
                lineTo(128.1f, 125.7f)
                curveTo(129.3f, 109.1f, 143.1f, 96.0f, 160.0f, 96.0f)
                lineTo(192.0f, 96.0f)
                curveTo(208.9f, 96.0f, 222.7f, 109.1f, 223.9f, 125.7f)
                lineTo(256.0f, 125.7f)
                lineTo(307.2f, 101.9f)
                curveTo(315.6f, 98.0f, 324.8f, 95.9f, 334.1f, 95.9f)
                lineTo(512.0f, 96.0f)
                curveTo(547.3f, 96.0f, 576.0f, 124.7f, 576.0f, 160.0f)
                lineTo(576.0f, 224.0f)
                lineTo(386.0f, 224.0f)
                curveTo(407.7f, 235.2f, 426.2f, 251.8f, 439.7f, 272.0f)
                lineTo(575.9f, 272.0f)
                lineTo(575.9f, 480.0f)
                curveTo(575.9f, 515.3f, 547.2f, 544.0f, 511.9f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                close()
                moveTo(320.0f, 256.0f)
                curveTo(284.9f, 254.9f, 252.1f, 272.9f, 234.2f, 303.1f)
                curveTo(216.3f, 333.3f, 216.3f, 370.8f, 234.2f, 401.0f)
                curveTo(252.1f, 431.2f, 284.9f, 449.2f, 320.0f, 448.1f)
                curveTo(355.1f, 449.2f, 387.9f, 431.2f, 405.8f, 401.0f)
                curveTo(423.7f, 370.8f, 423.7f, 333.3f, 405.8f, 303.1f)
                curveTo(387.9f, 272.9f, 355.1f, 254.9f, 320.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_camera-retro`!!
    }

private var `_camera-retro`: ImageVector? = null
