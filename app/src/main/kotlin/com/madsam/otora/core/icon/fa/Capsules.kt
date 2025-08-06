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

public val Fa.Capsules: ImageVector
    get() {
        if (_capsules != null) {
            return _capsules!!
        }
        _capsules = Builder(name = "Capsules", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 176.0f)
                curveTo(128.0f, 149.5f, 149.5f, 128.0f, 176.0f, 128.0f)
                curveTo(202.5f, 128.0f, 224.0f, 149.5f, 224.0f, 176.0f)
                lineTo(224.0f, 288.0f)
                lineTo(128.0f, 288.0f)
                lineTo(128.0f, 176.0f)
                close()
                moveTo(64.0f, 176.0f)
                lineTo(64.0f, 464.0f)
                curveTo(64.0f, 525.9f, 114.1f, 576.0f, 176.0f, 576.0f)
                curveTo(237.9f, 576.0f, 288.0f, 525.9f, 288.0f, 464.0f)
                lineTo(288.0f, 358.2f)
                lineTo(404.3f, 527.7f)
                curveTo(439.8f, 579.4f, 509.6f, 592.0f, 560.3f, 555.8f)
                curveTo(611.0f, 519.6f, 623.3f, 448.3f, 587.8f, 396.6f)
                lineTo(459.3f, 209.3f)
                curveTo(423.8f, 157.6f, 354.0f, 145.0f, 303.3f, 181.2f)
                curveTo(297.7f, 185.2f, 292.6f, 189.6f, 288.0f, 194.3f)
                lineTo(288.0f, 176.0f)
                curveTo(288.0f, 114.1f, 237.9f, 64.0f, 176.0f, 64.0f)
                curveTo(114.1f, 64.0f, 64.0f, 114.1f, 64.0f, 176.0f)
                close()
                moveTo(328.6f, 304.2f)
                curveTo(312.6f, 280.9f, 318.6f, 248.9f, 340.5f, 233.2f)
                curveTo(361.7f, 218.1f, 391.0f, 222.9f, 406.5f, 245.4f)
                lineTo(473.5f, 343.0f)
                lineTo(393.6f, 398.9f)
                lineTo(328.6f, 304.1f)
                close()
            }
        }
        .build()
        return _capsules!!
    }

private var _capsules: ImageVector? = null
