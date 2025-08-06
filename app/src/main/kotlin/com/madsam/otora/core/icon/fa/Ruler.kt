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

public val Fa.Ruler: ImageVector
    get() {
        if (_ruler != null) {
            return _ruler!!
        }
        _ruler = Builder(name = "Ruler", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(241.1f, 580.2f)
                curveTo(222.4f, 598.9f, 192.0f, 598.9f, 173.2f, 580.2f)
                lineTo(60.1f, 467.1f)
                curveTo(41.4f, 448.4f, 41.4f, 418.0f, 60.1f, 399.2f)
                lineTo(77.1f, 382.2f)
                lineTo(150.6f, 455.7f)
                curveTo(160.0f, 465.1f, 175.2f, 465.1f, 184.5f, 455.7f)
                curveTo(193.8f, 446.3f, 193.9f, 431.1f, 184.5f, 421.8f)
                lineTo(111.0f, 348.3f)
                lineTo(144.9f, 314.4f)
                lineTo(195.8f, 365.3f)
                curveTo(205.2f, 374.7f, 220.4f, 374.7f, 229.7f, 365.3f)
                curveTo(239.0f, 355.9f, 239.1f, 340.7f, 229.7f, 331.4f)
                lineTo(178.8f, 280.5f)
                lineTo(212.7f, 246.6f)
                lineTo(286.2f, 320.1f)
                curveTo(295.6f, 329.5f, 310.8f, 329.5f, 320.1f, 320.1f)
                curveTo(329.4f, 310.7f, 329.5f, 295.5f, 320.1f, 286.2f)
                lineTo(246.6f, 212.7f)
                lineTo(280.5f, 178.8f)
                lineTo(331.4f, 229.7f)
                curveTo(340.8f, 239.1f, 356.0f, 239.1f, 365.3f, 229.7f)
                curveTo(374.6f, 220.3f, 374.7f, 205.1f, 365.3f, 195.8f)
                lineTo(314.4f, 144.9f)
                lineTo(348.3f, 111.0f)
                lineTo(421.8f, 184.5f)
                curveTo(431.2f, 193.9f, 446.4f, 193.9f, 455.7f, 184.5f)
                curveTo(465.0f, 175.1f, 465.1f, 159.9f, 455.7f, 150.6f)
                lineTo(382.2f, 77.1f)
                lineTo(399.2f, 60.1f)
                curveTo(417.9f, 41.4f, 448.3f, 41.4f, 467.1f, 60.1f)
                lineTo(580.5f, 172.9f)
                curveTo(599.2f, 191.6f, 599.2f, 222.0f, 580.5f, 240.8f)
                lineTo(241.1f, 580.2f)
                close()
            }
        }
        .build()
        return _ruler!!
    }

private var _ruler: ImageVector? = null
