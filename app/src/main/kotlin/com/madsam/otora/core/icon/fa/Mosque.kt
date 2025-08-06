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

public val Fa.Mosque: ImageVector
    get() {
        if (_mosque != null) {
            return _mosque!!
        }
        _mosque = Builder(name = "Mosque", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(206.8f, 288.0f)
                lineTo(433.2f, 288.0f)
                curveTo(476.7f, 288.0f, 512.0f, 252.7f, 512.0f, 209.2f)
                curveTo(512.0f, 183.7f, 499.7f, 159.8f, 478.9f, 145.0f)
                lineTo(329.3f, 38.6f)
                curveTo(323.7f, 34.7f, 316.3f, 34.7f, 310.8f, 38.6f)
                lineTo(161.1f, 145.0f)
                curveTo(140.3f, 159.8f, 128.0f, 183.7f, 128.0f, 209.2f)
                curveTo(128.0f, 252.7f, 163.3f, 288.0f, 206.8f, 288.0f)
                close()
                moveTo(544.0f, 576.0f)
                curveTo(579.3f, 576.0f, 608.0f, 547.3f, 608.0f, 512.0f)
                lineTo(608.0f, 288.0f)
                curveTo(608.0f, 270.3f, 593.7f, 256.0f, 576.0f, 256.0f)
                curveTo(558.3f, 256.0f, 544.0f, 270.3f, 544.0f, 288.0f)
                lineTo(544.0f, 336.0f)
                lineTo(96.0f, 336.0f)
                lineTo(96.0f, 288.0f)
                curveTo(96.0f, 270.3f, 81.7f, 256.0f, 64.0f, 256.0f)
                curveTo(46.3f, 256.0f, 32.0f, 270.3f, 32.0f, 288.0f)
                lineTo(32.0f, 512.0f)
                curveTo(32.0f, 547.3f, 60.7f, 576.0f, 96.0f, 576.0f)
                lineTo(544.0f, 576.0f)
                close()
                moveTo(272.0f, 448.0f)
                curveTo(272.0f, 421.5f, 293.5f, 400.0f, 320.0f, 400.0f)
                curveTo(346.5f, 400.0f, 368.0f, 421.5f, 368.0f, 448.0f)
                lineTo(368.0f, 528.0f)
                lineTo(272.0f, 528.0f)
                lineTo(272.0f, 448.0f)
                close()
            }
        }
        .build()
        return _mosque!!
    }

private var _mosque: ImageVector? = null
