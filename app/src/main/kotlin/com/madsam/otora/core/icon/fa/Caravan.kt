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

public val Fa.Caravan: ImageVector
    get() {
        if (_caravan != null) {
            return _caravan!!
        }
        _caravan = Builder(name = "Caravan", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                curveTo(486.7f, 96.0f, 544.0f, 153.3f, 544.0f, 224.0f)
                lineTo(544.0f, 416.0f)
                lineTo(608.0f, 416.0f)
                curveTo(625.7f, 416.0f, 640.0f, 430.3f, 640.0f, 448.0f)
                curveTo(640.0f, 465.7f, 625.7f, 480.0f, 608.0f, 480.0f)
                lineTo(311.6f, 480.0f)
                curveTo(311.8f, 482.6f, 312.0f, 485.3f, 312.0f, 488.0f)
                curveTo(312.0f, 536.6f, 272.6f, 576.0f, 224.0f, 576.0f)
                curveTo(175.4f, 576.0f, 136.0f, 536.6f, 136.0f, 488.0f)
                curveTo(136.0f, 485.3f, 136.1f, 482.6f, 136.4f, 480.0f)
                lineTo(96.0f, 480.0f)
                curveTo(60.7f, 480.0f, 32.0f, 451.3f, 32.0f, 416.0f)
                lineTo(32.0f, 160.0f)
                close()
                moveTo(352.0f, 416.0f)
                lineTo(416.0f, 416.0f)
                curveTo(433.7f, 416.0f, 448.0f, 401.7f, 448.0f, 384.0f)
                lineTo(448.0f, 336.0f)
                lineTo(424.0f, 336.0f)
                curveTo(410.7f, 336.0f, 400.0f, 325.3f, 400.0f, 312.0f)
                curveTo(400.0f, 298.7f, 410.7f, 288.0f, 424.0f, 288.0f)
                lineTo(448.0f, 288.0f)
                lineTo(448.0f, 224.0f)
                curveTo(448.0f, 206.3f, 433.7f, 192.0f, 416.0f, 192.0f)
                lineTo(352.0f, 192.0f)
                curveTo(334.3f, 192.0f, 320.0f, 206.3f, 320.0f, 224.0f)
                lineTo(320.0f, 384.0f)
                curveTo(320.0f, 401.7f, 334.3f, 416.0f, 352.0f, 416.0f)
                close()
                moveTo(160.0f, 192.0f)
                curveTo(142.3f, 192.0f, 128.0f, 206.3f, 128.0f, 224.0f)
                lineTo(128.0f, 288.0f)
                curveTo(128.0f, 305.7f, 142.3f, 320.0f, 160.0f, 320.0f)
                lineTo(224.0f, 320.0f)
                curveTo(241.7f, 320.0f, 256.0f, 305.7f, 256.0f, 288.0f)
                lineTo(256.0f, 224.0f)
                curveTo(256.0f, 206.3f, 241.7f, 192.0f, 224.0f, 192.0f)
                lineTo(160.0f, 192.0f)
                close()
                moveTo(224.0f, 528.0f)
                curveTo(246.1f, 528.0f, 264.0f, 510.1f, 264.0f, 488.0f)
                curveTo(264.0f, 465.9f, 246.1f, 448.0f, 224.0f, 448.0f)
                curveTo(201.9f, 448.0f, 184.0f, 465.9f, 184.0f, 488.0f)
                curveTo(184.0f, 510.1f, 201.9f, 528.0f, 224.0f, 528.0f)
                close()
            }
        }
        .build()
        return _caravan!!
    }

private var _caravan: ImageVector? = null
