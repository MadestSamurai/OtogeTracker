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

public val Fa.Socks: ImageVector
    get() {
        if (_socks != null) {
            return _socks!!
        }
        _socks = Builder(name = "Socks", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(316.8f, 64.0f)
                lineTo(240.0f, 64.0f)
                curveTo(213.5f, 64.0f, 192.0f, 85.5f, 192.0f, 112.0f)
                lineTo(192.0f, 128.0f)
                lineTo(304.0f, 128.0f)
                lineTo(304.0f, 112.0f)
                curveTo(304.0f, 94.5f, 308.7f, 78.1f, 316.8f, 64.0f)
                close()
                moveTo(192.0f, 176.0f)
                lineTo(192.0f, 304.0f)
                curveTo(192.0f, 324.1f, 182.5f, 343.1f, 166.4f, 355.2f)
                lineTo(102.4f, 403.2f)
                curveTo(78.2f, 421.3f, 64.0f, 449.8f, 64.0f, 480.0f)
                curveTo(64.0f, 533.0f, 107.0f, 576.0f, 160.0f, 576.0f)
                curveTo(175.4f, 576.0f, 190.5f, 572.3f, 204.0f, 565.3f)
                curveTo(186.4f, 541.4f, 176.0f, 511.9f, 176.0f, 480.0f)
                curveTo(176.0f, 434.7f, 197.3f, 392.0f, 233.6f, 364.8f)
                lineTo(297.6f, 316.8f)
                curveTo(301.6f, 313.8f, 304.0f, 309.0f, 304.0f, 304.0f)
                lineTo(304.0f, 176.0f)
                lineTo(192.0f, 176.0f)
                close()
                moveTo(352.0f, 176.0f)
                lineTo(352.0f, 304.0f)
                curveTo(352.0f, 324.1f, 342.5f, 343.1f, 326.4f, 355.2f)
                lineTo(262.4f, 403.2f)
                curveTo(238.2f, 421.3f, 224.0f, 449.8f, 224.0f, 480.0f)
                curveTo(224.0f, 533.0f, 267.0f, 576.0f, 320.0f, 576.0f)
                curveTo(340.8f, 576.0f, 361.0f, 569.3f, 377.6f, 556.8f)
                lineTo(492.8f, 470.4f)
                curveTo(525.0f, 446.2f, 544.0f, 408.3f, 544.0f, 368.0f)
                lineTo(544.0f, 176.0f)
                lineTo(352.0f, 176.0f)
                close()
                moveTo(544.0f, 128.0f)
                lineTo(544.0f, 112.0f)
                curveTo(544.0f, 85.5f, 522.5f, 64.0f, 496.0f, 64.0f)
                lineTo(400.0f, 64.0f)
                curveTo(373.5f, 64.0f, 352.0f, 85.5f, 352.0f, 112.0f)
                lineTo(352.0f, 128.0f)
                lineTo(544.0f, 128.0f)
                close()
            }
        }
        .build()
        return _socks!!
    }

private var _socks: ImageVector? = null
