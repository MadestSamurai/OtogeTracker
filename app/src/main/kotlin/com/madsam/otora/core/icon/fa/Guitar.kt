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

public val Fa.Guitar: ImageVector
    get() {
        if (_guitar != null) {
            return _guitar!!
        }
        _guitar = Builder(name = "Guitar", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(529.0f, 71.0f)
                curveTo(519.6f, 61.6f, 504.4f, 61.6f, 495.1f, 71.0f)
                lineTo(447.0f, 119.0f)
                curveTo(444.6f, 121.4f, 442.7f, 124.3f, 441.5f, 127.5f)
                lineTo(426.1f, 168.5f)
                lineTo(348.6f, 246.1f)
                curveTo(303.5f, 216.7f, 249.3f, 215.9f, 217.6f, 247.7f)
                curveTo(206.6f, 258.7f, 199.6f, 272.3f, 196.2f, 287.3f)
                curveTo(192.5f, 303.9f, 177.1f, 318.0f, 160.1f, 318.9f)
                curveTo(134.5f, 320.2f, 110.8f, 329.6f, 92.8f, 347.5f)
                curveTo(48.0f, 392.3f, 56.4f, 473.3f, 111.5f, 528.4f)
                curveTo(166.6f, 583.5f, 247.6f, 592.0f, 292.4f, 547.2f)
                curveTo(310.3f, 529.3f, 319.8f, 505.5f, 321.0f, 479.9f)
                curveTo(321.9f, 462.9f, 336.0f, 447.6f, 352.6f, 443.8f)
                curveTo(367.6f, 440.4f, 381.2f, 433.3f, 392.2f, 422.4f)
                curveTo(424.0f, 390.6f, 423.2f, 336.5f, 393.8f, 291.4f)
                lineTo(471.4f, 213.8f)
                lineTo(512.4f, 198.4f)
                curveTo(515.6f, 197.2f, 518.5f, 195.3f, 520.9f, 192.9f)
                lineTo(568.9f, 144.9f)
                curveTo(578.3f, 135.5f, 578.3f, 120.3f, 568.9f, 111.0f)
                lineTo(529.0f, 71.0f)
                close()
                moveTo(272.0f, 320.0f)
                curveTo(298.5f, 320.0f, 320.0f, 341.5f, 320.0f, 368.0f)
                curveTo(320.0f, 394.5f, 298.5f, 416.0f, 272.0f, 416.0f)
                curveTo(245.5f, 416.0f, 224.0f, 394.5f, 224.0f, 368.0f)
                curveTo(224.0f, 341.5f, 245.5f, 320.0f, 272.0f, 320.0f)
                close()
            }
        }
        .build()
        return _guitar!!
    }

private var _guitar: ImageVector? = null
