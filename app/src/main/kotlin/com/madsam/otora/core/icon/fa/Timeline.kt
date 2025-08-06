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

public val Fa.Timeline: ImageVector
    get() {
        if (_timeline != null) {
            return _timeline!!
        }
        _timeline = Builder(name = "Timeline", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 233.3f)
                curveTo(220.3f, 221.0f, 240.0f, 192.8f, 240.0f, 160.0f)
                curveTo(240.0f, 115.8f, 204.2f, 80.0f, 160.0f, 80.0f)
                curveTo(115.8f, 80.0f, 80.0f, 115.8f, 80.0f, 160.0f)
                curveTo(80.0f, 192.8f, 99.7f, 221.0f, 128.0f, 233.3f)
                lineTo(128.0f, 288.0f)
                lineTo(64.0f, 288.0f)
                curveTo(46.3f, 288.0f, 32.0f, 302.3f, 32.0f, 320.0f)
                curveTo(32.0f, 337.7f, 46.3f, 352.0f, 64.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 406.7f)
                curveTo(259.7f, 419.0f, 240.0f, 447.2f, 240.0f, 480.0f)
                curveTo(240.0f, 524.2f, 275.8f, 560.0f, 320.0f, 560.0f)
                curveTo(364.2f, 560.0f, 400.0f, 524.2f, 400.0f, 480.0f)
                curveTo(400.0f, 447.2f, 380.3f, 419.0f, 352.0f, 406.7f)
                lineTo(352.0f, 352.0f)
                lineTo(576.0f, 352.0f)
                curveTo(593.7f, 352.0f, 608.0f, 337.7f, 608.0f, 320.0f)
                curveTo(608.0f, 302.3f, 593.7f, 288.0f, 576.0f, 288.0f)
                lineTo(512.0f, 288.0f)
                lineTo(512.0f, 233.3f)
                curveTo(540.3f, 221.0f, 560.0f, 192.8f, 560.0f, 160.0f)
                curveTo(560.0f, 115.8f, 524.2f, 80.0f, 480.0f, 80.0f)
                curveTo(435.8f, 80.0f, 400.0f, 115.8f, 400.0f, 160.0f)
                curveTo(400.0f, 192.8f, 419.7f, 221.0f, 448.0f, 233.3f)
                lineTo(448.0f, 288.0f)
                lineTo(192.0f, 288.0f)
                lineTo(192.0f, 233.3f)
                close()
            }
        }
        .build()
        return _timeline!!
    }

private var _timeline: ImageVector? = null
