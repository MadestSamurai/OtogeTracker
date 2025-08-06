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

public val Fa.Stapler: ImageVector
    get() {
        if (_stapler != null) {
            return _stapler!!
        }
        _stapler = Builder(name = "Stapler", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(640.0f, 363.3f)
                lineTo(640.0f, 496.0f)
                curveTo(640.0f, 522.5f, 618.5f, 544.0f, 592.0f, 544.0f)
                lineTo(64.0f, 544.0f)
                curveTo(46.3f, 544.0f, 32.0f, 529.7f, 32.0f, 512.0f)
                curveTo(32.0f, 494.3f, 46.3f, 480.0f, 64.0f, 480.0f)
                lineTo(448.0f, 480.0f)
                lineTo(448.0f, 432.0f)
                lineTo(96.0f, 432.0f)
                curveTo(78.3f, 432.0f, 64.0f, 417.7f, 64.0f, 400.0f)
                lineTo(64.0f, 283.4f)
                lineTo(33.8f, 278.0f)
                curveTo(14.2f, 274.5f, 0.0f, 257.5f, 0.0f, 237.6f)
                curveTo(0.0f, 228.7f, 2.9f, 220.1f, 8.2f, 213.0f)
                lineTo(43.8f, 165.5f)
                curveTo(76.6f, 121.7f, 128.2f, 95.9f, 182.9f, 95.9f)
                curveTo(209.9f, 95.9f, 236.5f, 102.2f, 260.7f, 114.3f)
                lineTo(586.9f, 277.5f)
                curveTo(619.5f, 293.7f, 640.0f, 327.0f, 640.0f, 363.3f)
                close()
                moveTo(448.0f, 368.0f)
                lineTo(448.0f, 352.0f)
                lineTo(128.0f, 294.9f)
                lineTo(128.0f, 368.0f)
                lineTo(448.0f, 368.0f)
                close()
            }
        }
        .build()
        return _stapler!!
    }

private var _stapler: ImageVector? = null
