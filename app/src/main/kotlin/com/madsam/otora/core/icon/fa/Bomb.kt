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

public val Fa.Bomb: ImageVector
    get() {
        if (_bomb != null) {
            return _bomb!!
        }
        _bomb = Builder(name = "Bomb", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 48.0f)
                curveTo(518.9f, 48.0f, 525.0f, 52.4f, 527.2f, 58.9f)
                lineTo(540.7f, 99.3f)
                lineTo(581.1f, 112.8f)
                curveTo(587.6f, 115.0f, 592.0f, 121.1f, 592.0f, 128.0f)
                curveTo(592.0f, 134.9f, 587.6f, 141.0f, 581.1f, 143.2f)
                lineTo(540.7f, 156.7f)
                lineTo(527.2f, 197.1f)
                curveTo(525.0f, 203.6f, 518.9f, 208.0f, 512.0f, 208.0f)
                curveTo(505.1f, 208.0f, 499.0f, 203.6f, 496.8f, 197.1f)
                lineTo(483.3f, 156.7f)
                lineTo(442.9f, 143.2f)
                curveTo(436.4f, 141.0f, 432.0f, 134.9f, 432.0f, 128.0f)
                curveTo(432.0f, 121.1f, 436.4f, 115.0f, 442.9f, 112.8f)
                lineTo(483.3f, 99.3f)
                lineTo(496.8f, 58.9f)
                curveTo(499.0f, 52.4f, 505.1f, 48.0f, 512.0f, 48.0f)
                close()
                moveTo(353.4f, 161.4f)
                curveTo(365.9f, 148.9f, 386.2f, 148.9f, 398.7f, 161.4f)
                lineTo(478.7f, 241.4f)
                curveTo(491.2f, 253.9f, 491.2f, 274.2f, 478.7f, 286.7f)
                lineTo(467.8f, 297.6f)
                curveTo(475.7f, 319.6f, 480.0f, 343.3f, 480.0f, 368.1f)
                curveTo(480.0f, 483.0f, 386.9f, 576.1f, 272.0f, 576.1f)
                curveTo(157.1f, 576.1f, 64.0f, 482.9f, 64.0f, 368.0f)
                curveTo(64.0f, 253.1f, 157.1f, 160.0f, 272.0f, 160.0f)
                curveTo(296.7f, 160.0f, 320.5f, 164.3f, 342.5f, 172.3f)
                lineTo(353.4f, 161.4f)
                close()
                moveTo(176.0f, 368.0f)
                curveTo(176.0f, 315.0f, 219.0f, 272.0f, 272.0f, 272.0f)
                curveTo(285.3f, 272.0f, 296.0f, 261.3f, 296.0f, 248.0f)
                curveTo(296.0f, 234.7f, 285.3f, 224.0f, 272.0f, 224.0f)
                curveTo(192.5f, 224.0f, 128.0f, 288.5f, 128.0f, 368.0f)
                curveTo(128.0f, 381.3f, 138.7f, 392.0f, 152.0f, 392.0f)
                curveTo(165.3f, 392.0f, 176.0f, 381.3f, 176.0f, 368.0f)
                close()
            }
        }
        .build()
        return _bomb!!
    }

private var _bomb: ImageVector? = null
