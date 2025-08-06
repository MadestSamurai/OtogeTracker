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

public val Fa.Gamepad: ImageVector
    get() {
        if (_gamepad != null) {
            return _gamepad!!
        }
        _gamepad = Builder(name = "Gamepad", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 128.0f)
                curveTo(554.0f, 128.0f, 640.0f, 214.0f, 640.0f, 320.0f)
                curveTo(640.0f, 426.0f, 554.0f, 512.0f, 448.0f, 512.0f)
                lineTo(192.0f, 512.0f)
                curveTo(86.0f, 512.0f, 0.0f, 426.0f, 0.0f, 320.0f)
                curveTo(0.0f, 214.0f, 86.0f, 128.0f, 192.0f, 128.0f)
                lineTo(448.0f, 128.0f)
                close()
                moveTo(192.0f, 240.0f)
                curveTo(178.7f, 240.0f, 168.0f, 250.7f, 168.0f, 264.0f)
                lineTo(168.0f, 296.0f)
                lineTo(136.0f, 296.0f)
                curveTo(122.7f, 296.0f, 112.0f, 306.7f, 112.0f, 320.0f)
                curveTo(112.0f, 333.3f, 122.7f, 344.0f, 136.0f, 344.0f)
                lineTo(168.0f, 344.0f)
                lineTo(168.0f, 376.0f)
                curveTo(168.0f, 389.3f, 178.7f, 400.0f, 192.0f, 400.0f)
                curveTo(205.3f, 400.0f, 216.0f, 389.3f, 216.0f, 376.0f)
                lineTo(216.0f, 344.0f)
                lineTo(248.0f, 344.0f)
                curveTo(261.3f, 344.0f, 272.0f, 333.3f, 272.0f, 320.0f)
                curveTo(272.0f, 306.7f, 261.3f, 296.0f, 248.0f, 296.0f)
                lineTo(216.0f, 296.0f)
                lineTo(216.0f, 264.0f)
                curveTo(216.0f, 250.7f, 205.3f, 240.0f, 192.0f, 240.0f)
                close()
                moveTo(432.0f, 336.0f)
                curveTo(414.3f, 336.0f, 400.0f, 350.3f, 400.0f, 368.0f)
                curveTo(400.0f, 385.7f, 414.3f, 400.0f, 432.0f, 400.0f)
                curveTo(449.7f, 400.0f, 464.0f, 385.7f, 464.0f, 368.0f)
                curveTo(464.0f, 350.3f, 449.7f, 336.0f, 432.0f, 336.0f)
                close()
                moveTo(496.0f, 240.0f)
                curveTo(478.3f, 240.0f, 464.0f, 254.3f, 464.0f, 272.0f)
                curveTo(464.0f, 289.7f, 478.3f, 304.0f, 496.0f, 304.0f)
                curveTo(513.7f, 304.0f, 528.0f, 289.7f, 528.0f, 272.0f)
                curveTo(528.0f, 254.3f, 513.7f, 240.0f, 496.0f, 240.0f)
                close()
            }
        }
        .build()
        return _gamepad!!
    }

private var _gamepad: ImageVector? = null
