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

public val Fa.Tree: ImageVector
    get() {
        if (_tree != null) {
            return _tree!!
        }
        _tree = Builder(name = "Tree", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(327.0f, 32.0f, 333.7f, 35.1f, 338.3f, 40.5f)
                lineTo(474.3f, 200.5f)
                curveTo(480.4f, 207.6f, 481.7f, 217.6f, 477.8f, 226.1f)
                curveTo(473.9f, 234.6f, 465.4f, 240.0f, 456.0f, 240.0f)
                lineTo(431.1f, 240.0f)
                lineTo(506.3f, 328.5f)
                curveTo(512.4f, 335.6f, 513.7f, 345.6f, 509.8f, 354.1f)
                curveTo(505.9f, 362.6f, 497.4f, 368.0f, 488.0f, 368.0f)
                lineTo(449.5f, 368.0f)
                lineTo(538.3f, 472.5f)
                curveTo(544.4f, 479.6f, 545.7f, 489.6f, 541.8f, 498.1f)
                curveTo(537.9f, 506.6f, 529.4f, 512.0f, 520.0f, 512.0f)
                lineTo(352.0f, 512.0f)
                lineTo(352.0f, 576.0f)
                curveTo(352.0f, 593.7f, 337.7f, 608.0f, 320.0f, 608.0f)
                curveTo(302.3f, 608.0f, 288.0f, 593.7f, 288.0f, 576.0f)
                lineTo(288.0f, 512.0f)
                lineTo(120.0f, 512.0f)
                curveTo(110.6f, 512.0f, 102.1f, 506.6f, 98.2f, 498.1f)
                curveTo(94.3f, 489.6f, 95.6f, 479.6f, 101.7f, 472.5f)
                lineTo(190.5f, 368.0f)
                lineTo(152.0f, 368.0f)
                curveTo(142.6f, 368.0f, 134.1f, 362.6f, 130.2f, 354.1f)
                curveTo(126.3f, 345.6f, 127.6f, 335.6f, 133.7f, 328.5f)
                lineTo(208.9f, 240.0f)
                lineTo(184.0f, 240.0f)
                curveTo(174.6f, 240.0f, 166.1f, 234.6f, 162.2f, 226.1f)
                curveTo(158.3f, 217.6f, 159.6f, 207.6f, 165.7f, 200.5f)
                lineTo(301.7f, 40.5f)
                curveTo(306.3f, 35.1f, 313.0f, 32.0f, 320.0f, 32.0f)
                close()
            }
        }
        .build()
        return _tree!!
    }

private var _tree: ImageVector? = null
