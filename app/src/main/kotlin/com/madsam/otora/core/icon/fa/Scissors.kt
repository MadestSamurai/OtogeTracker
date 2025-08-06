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

public val Fa.Scissors: ImageVector
    get() {
        if (_scissors != null) {
            return _scissors!!
        }
        _scissors = Builder(name = "Scissors", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 320.0f)
                lineTo(216.5f, 359.5f)
                curveTo(203.9f, 354.6f, 190.3f, 352.0f, 176.0f, 352.0f)
                curveTo(114.1f, 352.0f, 64.0f, 402.1f, 64.0f, 464.0f)
                curveTo(64.0f, 525.9f, 114.1f, 576.0f, 176.0f, 576.0f)
                curveTo(237.9f, 576.0f, 288.0f, 525.9f, 288.0f, 464.0f)
                curveTo(288.0f, 449.7f, 285.3f, 436.1f, 280.5f, 423.5f)
                lineTo(563.2f, 140.8f)
                curveTo(570.3f, 133.7f, 570.3f, 122.3f, 563.2f, 115.2f)
                curveTo(534.9f, 86.9f, 489.1f, 86.9f, 460.8f, 115.2f)
                lineTo(320.0f, 256.0f)
                lineTo(280.5f, 216.5f)
                curveTo(285.4f, 203.9f, 288.0f, 190.3f, 288.0f, 176.0f)
                curveTo(288.0f, 114.1f, 237.9f, 64.0f, 176.0f, 64.0f)
                curveTo(114.1f, 64.0f, 64.0f, 114.1f, 64.0f, 176.0f)
                curveTo(64.0f, 237.9f, 114.1f, 288.0f, 176.0f, 288.0f)
                curveTo(190.3f, 288.0f, 203.9f, 285.3f, 216.5f, 280.5f)
                lineTo(256.0f, 320.0f)
                close()
                moveTo(353.9f, 417.9f)
                lineTo(460.8f, 524.8f)
                curveTo(489.1f, 553.1f, 534.9f, 553.1f, 563.2f, 524.8f)
                curveTo(570.3f, 517.7f, 570.3f, 506.3f, 563.2f, 499.2f)
                lineTo(417.9f, 353.9f)
                lineTo(353.9f, 417.9f)
                close()
                moveTo(128.0f, 176.0f)
                curveTo(128.0f, 149.5f, 149.5f, 128.0f, 176.0f, 128.0f)
                curveTo(202.5f, 128.0f, 224.0f, 149.5f, 224.0f, 176.0f)
                curveTo(224.0f, 202.5f, 202.5f, 224.0f, 176.0f, 224.0f)
                curveTo(149.5f, 224.0f, 128.0f, 202.5f, 128.0f, 176.0f)
                close()
                moveTo(176.0f, 416.0f)
                curveTo(202.5f, 416.0f, 224.0f, 437.5f, 224.0f, 464.0f)
                curveTo(224.0f, 490.5f, 202.5f, 512.0f, 176.0f, 512.0f)
                curveTo(149.5f, 512.0f, 128.0f, 490.5f, 128.0f, 464.0f)
                curveTo(128.0f, 437.5f, 149.5f, 416.0f, 176.0f, 416.0f)
                close()
            }
        }
        .build()
        return _scissors!!
    }

private var _scissors: ImageVector? = null
