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

public val Fa.Paste: ImageVector
    get() {
        if (_paste != null) {
            return _paste!!
        }
        _paste = Builder(name = "Paste", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(92.7f, 64.0f, 64.0f, 92.7f, 64.0f, 128.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(240.0f, 512.0f)
                lineTo(240.0f, 288.0f)
                curveTo(240.0f, 226.1f, 290.1f, 176.0f, 352.0f, 176.0f)
                lineTo(416.0f, 176.0f)
                lineTo(416.0f, 128.0f)
                curveTo(416.0f, 92.7f, 387.3f, 64.0f, 352.0f, 64.0f)
                lineTo(128.0f, 64.0f)
                close()
                moveTo(312.0f, 176.0f)
                lineTo(168.0f, 176.0f)
                curveTo(154.7f, 176.0f, 144.0f, 165.3f, 144.0f, 152.0f)
                curveTo(144.0f, 138.7f, 154.7f, 128.0f, 168.0f, 128.0f)
                lineTo(312.0f, 128.0f)
                curveTo(325.3f, 128.0f, 336.0f, 138.7f, 336.0f, 152.0f)
                curveTo(336.0f, 165.3f, 325.3f, 176.0f, 312.0f, 176.0f)
                close()
                moveTo(352.0f, 224.0f)
                curveTo(316.7f, 224.0f, 288.0f, 252.7f, 288.0f, 288.0f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 547.3f, 316.7f, 576.0f, 352.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 346.5f)
                curveTo(576.0f, 329.5f, 569.3f, 313.2f, 557.3f, 301.2f)
                lineTo(498.8f, 242.7f)
                curveTo(486.8f, 230.7f, 470.5f, 224.0f, 453.5f, 224.0f)
                lineTo(352.0f, 224.0f)
                close()
            }
        }
        .build()
        return _paste!!
    }

private var _paste: ImageVector? = null
