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

public val Fa.Biking: ImageVector
    get() {
        if (_biking != null) {
            return _biking!!
        }
        _biking = Builder(name = "Biking", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 160.0f)
                curveTo(426.5f, 160.0f, 448.0f, 138.5f, 448.0f, 112.0f)
                curveTo(448.0f, 85.5f, 426.5f, 64.0f, 400.0f, 64.0f)
                curveTo(373.5f, 64.0f, 352.0f, 85.5f, 352.0f, 112.0f)
                curveTo(352.0f, 138.5f, 373.5f, 160.0f, 400.0f, 160.0f)
                close()
                moveTo(427.2f, 224.0f)
                lineTo(365.4f, 175.2f)
                curveTo(348.1f, 161.6f, 323.7f, 161.4f, 306.3f, 174.9f)
                lineTo(223.2f, 239.1f)
                curveTo(192.5f, 262.9f, 194.7f, 309.9f, 227.5f, 330.7f)
                lineTo(288.0f, 369.1f)
                lineTo(288.0f, 480.0f)
                curveTo(288.0f, 497.7f, 302.3f, 512.0f, 320.0f, 512.0f)
                curveTo(337.7f, 512.0f, 352.0f, 497.7f, 352.0f, 480.0f)
                lineTo(352.0f, 352.0f)
                curveTo(352.0f, 341.3f, 346.7f, 331.3f, 337.8f, 325.4f)
                lineTo(295.0f, 296.9f)
                lineTo(355.3f, 248.4f)
                lineTo(396.0f, 281.0f)
                curveTo(401.7f, 285.5f, 408.7f, 288.0f, 416.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(497.7f, 288.0f, 512.0f, 273.7f, 512.0f, 256.0f)
                curveTo(512.0f, 238.3f, 497.7f, 224.0f, 480.0f, 224.0f)
                lineTo(427.2f, 224.0f)
                close()
                moveTo(144.0f, 576.0f)
                curveTo(205.9f, 576.0f, 256.0f, 525.9f, 256.0f, 464.0f)
                curveTo(256.0f, 402.1f, 205.9f, 352.0f, 144.0f, 352.0f)
                curveTo(82.1f, 352.0f, 32.0f, 402.1f, 32.0f, 464.0f)
                curveTo(32.0f, 525.9f, 82.1f, 576.0f, 144.0f, 576.0f)
                close()
                moveTo(496.0f, 576.0f)
                curveTo(557.9f, 576.0f, 608.0f, 525.9f, 608.0f, 464.0f)
                curveTo(608.0f, 402.1f, 557.9f, 352.0f, 496.0f, 352.0f)
                curveTo(434.1f, 352.0f, 384.0f, 402.1f, 384.0f, 464.0f)
                curveTo(384.0f, 525.9f, 434.1f, 576.0f, 496.0f, 576.0f)
                close()
            }
        }
        .build()
        return _biking!!
    }

private var _biking: ImageVector? = null
