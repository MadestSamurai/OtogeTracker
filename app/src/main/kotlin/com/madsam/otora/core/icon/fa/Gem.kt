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

public val Fa.Gem: ImageVector
    get() {
        if (_gem != null) {
            return _gem!!
        }
        _gem = Builder(name = "Gem", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(180.7f, 97.8f)
                curveTo(185.2f, 91.7f, 192.4f, 88.0f, 200.0f, 88.0f)
                lineTo(440.0f, 88.0f)
                curveTo(447.6f, 88.0f, 454.8f, 91.6f, 459.3f, 97.8f)
                lineTo(571.3f, 249.8f)
                curveTo(578.1f, 259.0f, 577.4f, 271.7f, 569.8f, 280.2f)
                lineTo(337.8f, 536.2f)
                curveTo(333.3f, 541.2f, 326.8f, 544.1f, 320.0f, 544.1f)
                curveTo(313.2f, 544.1f, 306.8f, 541.2f, 302.2f, 536.2f)
                lineTo(70.2f, 280.2f)
                curveTo(62.5f, 271.7f, 61.9f, 259.0f, 68.7f, 249.8f)
                lineTo(180.7f, 97.8f)
                close()
                moveTo(219.2f, 137.6f)
                curveTo(215.9f, 140.1f, 215.0f, 144.6f, 217.1f, 148.1f)
                lineTo(274.5f, 243.8f)
                lineTo(127.3f, 256.0f)
                curveTo(123.2f, 256.3f, 120.0f, 259.8f, 120.0f, 264.0f)
                curveTo(120.0f, 268.2f, 123.2f, 271.6f, 127.3f, 272.0f)
                lineTo(319.3f, 288.0f)
                curveTo(319.7f, 288.0f, 320.2f, 288.0f, 320.6f, 288.0f)
                lineTo(512.6f, 272.0f)
                curveTo(516.7f, 271.7f, 519.9f, 268.2f, 519.9f, 264.0f)
                curveTo(519.9f, 259.8f, 516.7f, 256.4f, 512.6f, 256.0f)
                lineTo(365.4f, 243.7f)
                lineTo(422.8f, 148.1f)
                curveTo(424.9f, 144.6f, 424.0f, 140.0f, 420.7f, 137.6f)
                curveTo(417.4f, 135.2f, 412.8f, 135.6f, 410.0f, 138.6f)
                lineTo(320.0f, 236.2f)
                lineTo(229.9f, 138.6f)
                curveTo(227.1f, 135.6f, 222.5f, 135.2f, 219.2f, 137.6f)
                close()
            }
        }
        .build()
        return _gem!!
    }

private var _gem: ImageVector? = null
