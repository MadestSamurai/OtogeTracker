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

public val Fa.Anchor: ImageVector
    get() {
        if (_anchor != null) {
            return _anchor!!
        }
        _anchor = Builder(name = "Anchor", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(302.3f, 128.0f, 288.0f, 142.3f, 288.0f, 160.0f)
                curveTo(288.0f, 177.7f, 302.3f, 192.0f, 320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 177.7f, 352.0f, 160.0f)
                curveTo(352.0f, 142.3f, 337.7f, 128.0f, 320.0f, 128.0f)
                close()
                moveTo(224.0f, 160.0f)
                curveTo(224.0f, 107.0f, 267.0f, 64.0f, 320.0f, 64.0f)
                curveTo(373.0f, 64.0f, 416.0f, 107.0f, 416.0f, 160.0f)
                curveTo(416.0f, 201.8f, 389.3f, 237.4f, 352.0f, 250.5f)
                lineTo(352.0f, 508.4f)
                curveTo(414.9f, 494.1f, 462.2f, 438.7f, 463.9f, 371.9f)
                lineTo(447.8f, 386.0f)
                curveTo(437.8f, 394.7f, 422.7f, 393.7f, 413.9f, 383.7f)
                curveTo(405.1f, 373.7f, 406.2f, 358.6f, 416.2f, 349.8f)
                lineTo(480.2f, 293.8f)
                curveTo(489.2f, 285.9f, 502.8f, 285.9f, 511.8f, 293.8f)
                lineTo(575.8f, 349.8f)
                curveTo(585.8f, 358.5f, 586.8f, 373.7f, 578.1f, 383.7f)
                curveTo(569.4f, 393.7f, 554.2f, 394.7f, 544.2f, 386.0f)
                lineTo(528.0f, 371.9f)
                curveTo(525.9f, 485.0f, 433.6f, 576.0f, 320.0f, 576.0f)
                curveTo(206.4f, 576.0f, 114.1f, 485.0f, 112.0f, 371.9f)
                lineTo(95.8f, 386.1f)
                curveTo(85.8f, 394.8f, 70.7f, 393.8f, 61.9f, 383.8f)
                curveTo(53.1f, 373.8f, 54.2f, 358.7f, 64.2f, 349.9f)
                lineTo(128.2f, 293.9f)
                curveTo(137.2f, 286.0f, 150.8f, 286.0f, 159.8f, 293.9f)
                lineTo(223.8f, 349.9f)
                curveTo(233.8f, 358.6f, 234.8f, 373.8f, 226.1f, 383.8f)
                curveTo(217.4f, 393.8f, 202.2f, 394.8f, 192.2f, 386.1f)
                lineTo(176.1f, 372.0f)
                curveTo(177.9f, 438.8f, 225.2f, 494.2f, 288.0f, 508.5f)
                lineTo(288.0f, 250.6f)
                curveTo(250.7f, 237.4f, 224.0f, 201.9f, 224.0f, 160.1f)
                close()
            }
        }
        .build()
        return _anchor!!
    }

private var _anchor: ImageVector? = null
