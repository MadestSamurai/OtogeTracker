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

public val Fa.Chair: ImageVector
    get() {
        if (_chair != null) {
            return _chair!!
        }
        _chair = Builder(name = "Chair", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(248.0f, 320.0f)
                lineTo(248.0f, 138.2f)
                curveTo(223.5f, 158.7f, 208.0f, 189.6f, 208.0f, 224.0f)
                lineTo(208.0f, 320.0f)
                lineTo(248.0f, 320.0f)
                close()
                moveTo(296.0f, 320.0f)
                lineTo(344.0f, 320.0f)
                lineTo(344.0f, 114.6f)
                curveTo(336.3f, 112.9f, 328.2f, 112.0f, 320.0f, 112.0f)
                curveTo(311.8f, 112.0f, 303.7f, 112.9f, 296.0f, 114.6f)
                lineTo(296.0f, 320.0f)
                close()
                moveTo(392.0f, 138.2f)
                lineTo(392.0f, 320.0f)
                lineTo(432.0f, 320.0f)
                lineTo(432.0f, 224.0f)
                curveTo(432.0f, 189.6f, 416.5f, 158.8f, 392.0f, 138.2f)
                close()
                moveTo(128.0f, 320.0f)
                lineTo(160.0f, 320.0f)
                lineTo(160.0f, 224.0f)
                curveTo(160.0f, 135.6f, 231.6f, 64.0f, 320.0f, 64.0f)
                curveTo(408.4f, 64.0f, 480.0f, 135.6f, 480.0f, 224.0f)
                lineTo(480.0f, 320.0f)
                lineTo(512.0f, 320.0f)
                curveTo(529.7f, 320.0f, 544.0f, 334.3f, 544.0f, 352.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 433.7f, 529.7f, 448.0f, 512.0f, 448.0f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                curveTo(462.3f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                lineTo(192.0f, 544.0f)
                curveTo(192.0f, 561.7f, 177.7f, 576.0f, 160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 448.0f)
                curveTo(110.3f, 448.0f, 96.0f, 433.7f, 96.0f, 416.0f)
                lineTo(96.0f, 352.0f)
                curveTo(96.0f, 334.3f, 110.3f, 320.0f, 128.0f, 320.0f)
                close()
            }
        }
        .build()
        return _chair!!
    }

private var _chair: ImageVector? = null
