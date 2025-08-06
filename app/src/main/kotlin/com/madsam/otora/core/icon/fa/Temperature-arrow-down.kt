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

public val Fa.`Temperature-arrow-down`: ImageVector
    get() {
        if (`_temperature-arrow-down` != null) {
            return `_temperature-arrow-down`!!
        }
        `_temperature-arrow-down` = Builder(name = "Temperature-arrow-down", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.5f, 160.0f)
                curveTo(128.5f, 107.0f, 171.5f, 64.0f, 224.5f, 64.0f)
                curveTo(277.5f, 64.0f, 320.5f, 107.0f, 320.5f, 160.0f)
                lineTo(320.5f, 324.7f)
                curveTo(350.0f, 351.1f, 368.5f, 389.4f, 368.5f, 432.0f)
                curveTo(368.5f, 511.5f, 304.0f, 576.0f, 224.5f, 576.0f)
                curveTo(145.0f, 576.0f, 80.5f, 511.5f, 80.5f, 432.0f)
                curveTo(80.5f, 389.4f, 99.0f, 351.0f, 128.5f, 324.7f)
                lineTo(128.5f, 160.0f)
                close()
                moveTo(224.5f, 496.0f)
                curveTo(259.8f, 496.0f, 288.5f, 467.3f, 288.5f, 432.0f)
                curveTo(288.5f, 405.1f, 272.0f, 382.1f, 248.5f, 372.7f)
                lineTo(248.5f, 344.0f)
                curveTo(248.5f, 330.7f, 237.8f, 320.0f, 224.5f, 320.0f)
                curveTo(211.2f, 320.0f, 200.5f, 330.7f, 200.5f, 344.0f)
                lineTo(200.5f, 372.7f)
                curveTo(177.0f, 382.2f, 160.5f, 405.2f, 160.5f, 432.0f)
                curveTo(160.5f, 467.3f, 189.2f, 496.0f, 224.5f, 496.0f)
                close()
                moveTo(503.1f, 374.6f)
                curveTo(497.1f, 380.6f, 489.0f, 384.0f, 480.5f, 384.0f)
                curveTo(472.0f, 384.0f, 463.9f, 380.6f, 457.9f, 374.6f)
                lineTo(393.9f, 310.6f)
                curveTo(381.4f, 298.1f, 381.4f, 277.8f, 393.9f, 265.3f)
                curveTo(406.4f, 252.8f, 426.7f, 252.8f, 439.2f, 265.3f)
                lineTo(448.6f, 274.7f)
                lineTo(448.6f, 96.0f)
                curveTo(448.6f, 78.3f, 462.9f, 64.0f, 480.6f, 64.0f)
                curveTo(498.3f, 64.0f, 512.6f, 78.3f, 512.6f, 96.0f)
                lineTo(512.6f, 274.7f)
                lineTo(522.0f, 265.3f)
                curveTo(534.5f, 252.8f, 554.8f, 252.8f, 567.3f, 265.3f)
                curveTo(579.8f, 277.8f, 579.8f, 298.1f, 567.3f, 310.6f)
                lineTo(503.3f, 374.6f)
                close()
            }
        }
        .build()
        return `_temperature-arrow-down`!!
    }

private var `_temperature-arrow-down`: ImageVector? = null
