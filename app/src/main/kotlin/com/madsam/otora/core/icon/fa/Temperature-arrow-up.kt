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

public val Fa.`Temperature-arrow-up`: ImageVector
    get() {
        if (`_temperature-arrow-up` != null) {
            return `_temperature-arrow-up`!!
        }
        `_temperature-arrow-up` = Builder(name = "Temperature-arrow-up", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                lineTo(248.5f, 160.0f)
                curveTo(248.5f, 146.7f, 237.8f, 136.0f, 224.5f, 136.0f)
                curveTo(211.2f, 136.0f, 200.5f, 146.7f, 200.5f, 160.0f)
                lineTo(200.5f, 372.7f)
                curveTo(177.0f, 382.2f, 160.5f, 405.2f, 160.5f, 432.0f)
                curveTo(160.5f, 467.3f, 189.2f, 496.0f, 224.5f, 496.0f)
                close()
                moveTo(503.1f, 73.4f)
                lineTo(567.1f, 137.4f)
                curveTo(579.6f, 149.9f, 579.6f, 170.2f, 567.1f, 182.7f)
                curveTo(554.6f, 195.2f, 534.3f, 195.2f, 521.8f, 182.7f)
                lineTo(512.4f, 173.3f)
                lineTo(512.4f, 352.0f)
                curveTo(512.4f, 369.7f, 498.1f, 384.0f, 480.4f, 384.0f)
                curveTo(462.7f, 384.0f, 448.4f, 369.7f, 448.4f, 352.0f)
                lineTo(448.4f, 173.3f)
                lineTo(439.0f, 182.7f)
                curveTo(426.5f, 195.2f, 406.2f, 195.2f, 393.7f, 182.7f)
                curveTo(381.2f, 170.2f, 381.2f, 149.9f, 393.7f, 137.4f)
                lineTo(457.7f, 73.4f)
                curveTo(463.7f, 67.4f, 471.8f, 64.0f, 480.3f, 64.0f)
                curveTo(488.8f, 64.0f, 496.9f, 67.4f, 502.9f, 73.4f)
                close()
            }
        }
        .build()
        return `_temperature-arrow-up`!!
    }

private var `_temperature-arrow-up`: ImageVector? = null
