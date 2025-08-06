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

public val Fa.Music: ImageVector
    get() {
        if (_music != null) {
            return _music!!
        }
        _music = Builder(name = "Music", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(532.0f, 71.0f)
                curveTo(539.6f, 77.1f, 544.0f, 86.3f, 544.0f, 96.0f)
                lineTo(544.0f, 400.0f)
                curveTo(544.0f, 444.2f, 501.0f, 480.0f, 448.0f, 480.0f)
                curveTo(395.0f, 480.0f, 352.0f, 444.2f, 352.0f, 400.0f)
                curveTo(352.0f, 355.8f, 395.0f, 320.0f, 448.0f, 320.0f)
                curveTo(459.2f, 320.0f, 470.0f, 321.6f, 480.0f, 324.6f)
                lineTo(480.0f, 207.9f)
                lineTo(256.0f, 257.7f)
                lineTo(256.0f, 464.0f)
                curveTo(256.0f, 508.2f, 213.0f, 544.0f, 160.0f, 544.0f)
                curveTo(107.0f, 544.0f, 64.0f, 508.2f, 64.0f, 464.0f)
                curveTo(64.0f, 419.8f, 107.0f, 384.0f, 160.0f, 384.0f)
                curveTo(171.2f, 384.0f, 182.0f, 385.6f, 192.0f, 388.6f)
                lineTo(192.0f, 160.0f)
                curveTo(192.0f, 145.0f, 202.4f, 132.0f, 217.1f, 128.8f)
                lineTo(505.1f, 64.8f)
                curveTo(514.6f, 62.7f, 524.5f, 65.0f, 532.1f, 71.1f)
                close()
            }
        }
        .build()
        return _music!!
    }

private var _music: ImageVector? = null
