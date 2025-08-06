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

public val Fa.Award: ImageVector
    get() {
        if (_award != null) {
            return _award!!
        }
        _award = Builder(name = "Award", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(341.9f, 38.1f)
                curveTo(328.5f, 29.9f, 311.6f, 29.9f, 298.2f, 38.1f)
                curveTo(273.8f, 53.0f, 258.7f, 57.0f, 230.1f, 56.4f)
                curveTo(214.4f, 56.0f, 199.8f, 64.5f, 192.2f, 78.3f)
                curveTo(178.5f, 103.4f, 167.4f, 114.5f, 142.3f, 128.2f)
                curveTo(128.5f, 135.7f, 120.1f, 150.4f, 120.4f, 166.1f)
                curveTo(121.1f, 194.7f, 117.0f, 209.8f, 102.1f, 234.2f)
                curveTo(93.9f, 247.6f, 93.9f, 264.5f, 102.1f, 277.9f)
                curveTo(117.0f, 302.3f, 121.0f, 317.4f, 120.4f, 346.0f)
                curveTo(120.0f, 361.7f, 128.5f, 376.3f, 142.3f, 383.9f)
                curveTo(164.4f, 396.0f, 175.6f, 406.0f, 187.4f, 425.4f)
                lineTo(138.7f, 522.5f)
                curveTo(132.8f, 534.4f, 137.6f, 548.8f, 149.4f, 554.7f)
                lineTo(235.4f, 597.7f)
                curveTo(246.9f, 603.4f, 260.9f, 599.1f, 267.1f, 587.9f)
                lineTo(319.9f, 492.8f)
                lineTo(372.7f, 587.9f)
                curveTo(378.9f, 599.1f, 392.9f, 603.5f, 404.4f, 597.7f)
                lineTo(490.4f, 554.7f)
                curveTo(502.3f, 548.8f, 507.1f, 534.4f, 501.1f, 522.5f)
                lineTo(452.5f, 425.3f)
                curveTo(464.2f, 405.9f, 475.5f, 395.9f, 497.6f, 383.8f)
                curveTo(511.4f, 376.3f, 519.8f, 361.6f, 519.5f, 345.9f)
                curveTo(518.8f, 317.3f, 522.9f, 302.2f, 537.8f, 277.8f)
                curveTo(546.0f, 264.4f, 546.0f, 247.5f, 537.8f, 234.1f)
                curveTo(522.9f, 209.7f, 518.9f, 194.6f, 519.5f, 166.0f)
                curveTo(519.9f, 150.3f, 511.4f, 135.7f, 497.6f, 128.1f)
                curveTo(472.5f, 114.4f, 461.4f, 103.3f, 447.7f, 78.2f)
                curveTo(440.2f, 64.4f, 425.5f, 56.0f, 409.8f, 56.3f)
                curveTo(381.2f, 57.0f, 366.1f, 52.9f, 341.7f, 38.0f)
                close()
                moveTo(320.0f, 160.0f)
                curveTo(373.0f, 160.0f, 416.0f, 203.0f, 416.0f, 256.0f)
                curveTo(416.0f, 309.0f, 373.0f, 352.0f, 320.0f, 352.0f)
                curveTo(267.0f, 352.0f, 224.0f, 309.0f, 224.0f, 256.0f)
                curveTo(224.0f, 203.0f, 267.0f, 160.0f, 320.0f, 160.0f)
                close()
            }
        }
        .build()
        return _award!!
    }

private var _award: ImageVector? = null
