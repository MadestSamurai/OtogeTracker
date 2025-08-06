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

public val Fa.Braille: ImageVector
    get() {
        if (_braille != null) {
            return _braille!!
        }
        _braille = Builder(name = "Braille", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 208.0f)
                curveTo(252.2f, 208.0f, 288.0f, 172.2f, 288.0f, 128.0f)
                curveTo(288.0f, 83.8f, 252.2f, 48.0f, 208.0f, 48.0f)
                curveTo(163.8f, 48.0f, 128.0f, 83.8f, 128.0f, 128.0f)
                curveTo(128.0f, 172.2f, 163.8f, 208.0f, 208.0f, 208.0f)
                close()
                moveTo(208.0f, 400.0f)
                curveTo(252.2f, 400.0f, 288.0f, 364.2f, 288.0f, 320.0f)
                curveTo(288.0f, 275.8f, 252.2f, 240.0f, 208.0f, 240.0f)
                curveTo(163.8f, 240.0f, 128.0f, 275.8f, 128.0f, 320.0f)
                curveTo(128.0f, 364.2f, 163.8f, 400.0f, 208.0f, 400.0f)
                close()
                moveTo(208.0f, 536.0f)
                curveTo(194.7f, 536.0f, 184.0f, 525.3f, 184.0f, 512.0f)
                curveTo(184.0f, 498.7f, 194.7f, 488.0f, 208.0f, 488.0f)
                curveTo(221.3f, 488.0f, 232.0f, 498.7f, 232.0f, 512.0f)
                curveTo(232.0f, 525.3f, 221.3f, 536.0f, 208.0f, 536.0f)
                close()
                moveTo(208.0f, 592.0f)
                curveTo(252.2f, 592.0f, 288.0f, 556.2f, 288.0f, 512.0f)
                curveTo(288.0f, 467.8f, 252.2f, 432.0f, 208.0f, 432.0f)
                curveTo(163.8f, 432.0f, 128.0f, 467.8f, 128.0f, 512.0f)
                curveTo(128.0f, 556.2f, 163.8f, 592.0f, 208.0f, 592.0f)
                close()
                moveTo(456.0f, 512.0f)
                curveTo(456.0f, 525.3f, 445.3f, 536.0f, 432.0f, 536.0f)
                curveTo(418.7f, 536.0f, 408.0f, 525.3f, 408.0f, 512.0f)
                curveTo(408.0f, 498.7f, 418.7f, 488.0f, 432.0f, 488.0f)
                curveTo(445.3f, 488.0f, 456.0f, 498.7f, 456.0f, 512.0f)
                close()
                moveTo(512.0f, 512.0f)
                curveTo(512.0f, 467.8f, 476.2f, 432.0f, 432.0f, 432.0f)
                curveTo(387.8f, 432.0f, 352.0f, 467.8f, 352.0f, 512.0f)
                curveTo(352.0f, 556.2f, 387.8f, 592.0f, 432.0f, 592.0f)
                curveTo(476.2f, 592.0f, 512.0f, 556.2f, 512.0f, 512.0f)
                close()
                moveTo(432.0f, 296.0f)
                curveTo(445.3f, 296.0f, 456.0f, 306.7f, 456.0f, 320.0f)
                curveTo(456.0f, 333.3f, 445.3f, 344.0f, 432.0f, 344.0f)
                curveTo(418.7f, 344.0f, 408.0f, 333.3f, 408.0f, 320.0f)
                curveTo(408.0f, 306.7f, 418.7f, 296.0f, 432.0f, 296.0f)
                close()
                moveTo(432.0f, 400.0f)
                curveTo(476.2f, 400.0f, 512.0f, 364.2f, 512.0f, 320.0f)
                curveTo(512.0f, 275.8f, 476.2f, 240.0f, 432.0f, 240.0f)
                curveTo(387.8f, 240.0f, 352.0f, 275.8f, 352.0f, 320.0f)
                curveTo(352.0f, 364.2f, 387.8f, 400.0f, 432.0f, 400.0f)
                close()
                moveTo(432.0f, 208.0f)
                curveTo(476.2f, 208.0f, 512.0f, 172.2f, 512.0f, 128.0f)
                curveTo(512.0f, 83.8f, 476.2f, 48.0f, 432.0f, 48.0f)
                curveTo(387.8f, 48.0f, 352.0f, 83.8f, 352.0f, 128.0f)
                curveTo(352.0f, 172.2f, 387.8f, 208.0f, 432.0f, 208.0f)
                close()
            }
        }
        .build()
        return _braille!!
    }

private var _braille: ImageVector? = null
