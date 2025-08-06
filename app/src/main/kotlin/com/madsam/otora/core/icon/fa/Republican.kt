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

public val Fa.Republican: ImageVector
    get() {
        if (_republican != null) {
            return _republican!!
        }
        _republican = Builder(name = "Republican", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 256.0f)
                curveTo(0.0f, 167.6f, 71.6f, 96.0f, 160.0f, 96.0f)
                lineTo(384.0f, 96.0f)
                curveTo(472.4f, 96.0f, 544.0f, 167.6f, 544.0f, 256.0f)
                lineTo(544.0f, 320.0f)
                lineTo(0.0f, 320.0f)
                lineTo(0.0f, 256.0f)
                close()
                moveTo(152.0f, 224.0f)
                curveTo(152.0f, 210.7f, 141.3f, 200.0f, 128.0f, 200.0f)
                curveTo(114.7f, 200.0f, 104.0f, 210.7f, 104.0f, 224.0f)
                curveTo(104.0f, 237.3f, 114.7f, 248.0f, 128.0f, 248.0f)
                curveTo(141.3f, 248.0f, 152.0f, 237.3f, 152.0f, 224.0f)
                close()
                moveTo(384.0f, 248.0f)
                curveTo(397.3f, 248.0f, 408.0f, 237.3f, 408.0f, 224.0f)
                curveTo(408.0f, 210.7f, 397.3f, 200.0f, 384.0f, 200.0f)
                curveTo(370.7f, 200.0f, 360.0f, 210.7f, 360.0f, 224.0f)
                curveTo(360.0f, 237.3f, 370.7f, 248.0f, 384.0f, 248.0f)
                close()
                moveTo(280.0f, 224.0f)
                curveTo(280.0f, 210.7f, 269.3f, 200.0f, 256.0f, 200.0f)
                curveTo(242.7f, 200.0f, 232.0f, 210.7f, 232.0f, 224.0f)
                curveTo(232.0f, 237.3f, 242.7f, 248.0f, 256.0f, 248.0f)
                curveTo(269.3f, 248.0f, 280.0f, 237.3f, 280.0f, 224.0f)
                close()
                moveTo(128.0f, 352.0f)
                lineTo(544.0f, 352.0f)
                lineTo(544.0f, 464.0f)
                curveTo(544.0f, 472.8f, 551.2f, 480.0f, 560.0f, 480.0f)
                curveTo(568.8f, 480.0f, 576.0f, 472.8f, 576.0f, 464.0f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 398.3f, 590.3f, 384.0f, 608.0f, 384.0f)
                curveTo(625.7f, 384.0f, 640.0f, 398.3f, 640.0f, 416.0f)
                lineTo(640.0f, 464.0f)
                curveTo(640.0f, 508.2f, 604.2f, 544.0f, 560.0f, 544.0f)
                curveTo(515.8f, 544.0f, 480.0f, 508.2f, 480.0f, 464.0f)
                lineTo(480.0f, 416.0f)
                lineTo(448.0f, 416.0f)
                lineTo(448.0f, 512.0f)
                curveTo(448.0f, 529.7f, 433.7f, 544.0f, 416.0f, 544.0f)
                lineTo(352.0f, 544.0f)
                curveTo(334.3f, 544.0f, 320.0f, 529.7f, 320.0f, 512.0f)
                lineTo(320.0f, 448.0f)
                lineTo(128.0f, 448.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 113.7f, 544.0f, 96.0f, 544.0f)
                lineTo(32.0f, 544.0f)
                curveTo(14.3f, 544.0f, 0.0f, 529.7f, 0.0f, 512.0f)
                lineTo(0.0f, 352.0f)
                lineTo(128.0f, 352.0f)
                close()
            }
        }
        .build()
        return _republican!!
    }

private var _republican: ImageVector? = null
