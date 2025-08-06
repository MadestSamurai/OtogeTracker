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

public val Fa.Random: ImageVector
    get() {
        if (_random != null) {
            return _random!!
        }
        _random = Builder(name = "Random", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(467.8f, 98.4f)
                curveTo(479.8f, 93.4f, 493.5f, 96.2f, 502.7f, 105.3f)
                lineTo(566.7f, 169.3f)
                curveTo(572.7f, 175.3f, 576.1f, 183.4f, 576.1f, 191.9f)
                curveTo(576.1f, 200.4f, 572.7f, 208.5f, 566.7f, 214.5f)
                lineTo(502.7f, 278.5f)
                curveTo(493.5f, 287.7f, 479.8f, 290.4f, 467.8f, 285.4f)
                curveTo(455.8f, 280.4f, 448.0f, 268.9f, 448.0f, 256.0f)
                lineTo(448.0f, 224.0f)
                lineTo(416.0f, 224.0f)
                curveTo(405.9f, 224.0f, 396.4f, 228.7f, 390.4f, 236.8f)
                lineTo(358.0f, 280.0f)
                lineTo(318.0f, 226.7f)
                lineTo(339.2f, 198.4f)
                curveTo(357.3f, 174.2f, 385.8f, 160.0f, 416.0f, 160.0f)
                lineTo(448.0f, 160.0f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 115.1f, 455.8f, 103.4f, 467.8f, 98.4f)
                close()
                moveTo(218.0f, 360.0f)
                lineTo(258.0f, 413.3f)
                lineTo(236.8f, 441.6f)
                curveTo(218.7f, 465.8f, 190.2f, 480.0f, 160.0f, 480.0f)
                lineTo(96.0f, 480.0f)
                curveTo(78.3f, 480.0f, 64.0f, 465.7f, 64.0f, 448.0f)
                curveTo(64.0f, 430.3f, 78.3f, 416.0f, 96.0f, 416.0f)
                lineTo(160.0f, 416.0f)
                curveTo(170.1f, 416.0f, 179.6f, 411.3f, 185.6f, 403.2f)
                lineTo(218.0f, 360.0f)
                close()
                moveTo(502.6f, 534.6f)
                curveTo(493.4f, 543.8f, 479.7f, 546.5f, 467.7f, 541.5f)
                curveTo(455.7f, 536.5f, 448.0f, 524.9f, 448.0f, 512.0f)
                lineTo(448.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(385.8f, 480.0f, 357.3f, 465.8f, 339.2f, 441.6f)
                lineTo(185.6f, 236.8f)
                curveTo(179.6f, 228.7f, 170.1f, 224.0f, 160.0f, 224.0f)
                lineTo(96.0f, 224.0f)
                curveTo(78.3f, 224.0f, 64.0f, 209.7f, 64.0f, 192.0f)
                curveTo(64.0f, 174.3f, 78.3f, 160.0f, 96.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                curveTo(190.2f, 160.0f, 218.7f, 174.2f, 236.8f, 198.4f)
                lineTo(390.4f, 403.2f)
                curveTo(396.4f, 411.3f, 405.9f, 416.0f, 416.0f, 416.0f)
                lineTo(448.0f, 416.0f)
                lineTo(448.0f, 384.0f)
                curveTo(448.0f, 371.1f, 455.8f, 359.4f, 467.8f, 354.4f)
                curveTo(479.8f, 349.4f, 493.5f, 352.2f, 502.7f, 361.3f)
                lineTo(566.7f, 425.3f)
                curveTo(572.7f, 431.3f, 576.1f, 439.4f, 576.1f, 447.9f)
                curveTo(576.1f, 456.4f, 572.7f, 464.5f, 566.7f, 470.5f)
                lineTo(502.7f, 534.5f)
                close()
            }
        }
        .build()
        return _random!!
    }

private var _random: ImageVector? = null
