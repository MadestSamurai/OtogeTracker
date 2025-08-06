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

public val Fa.Clipboard: ImageVector
    get() {
        if (_clipboard != null) {
            return _clipboard!!
        }
        _clipboard = Builder(name = "Clipboard", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 96.0f)
                lineTo(439.4f, 96.0f)
                curveTo(428.4f, 76.9f, 407.7f, 64.0f, 384.0f, 64.0f)
                lineTo(256.0f, 64.0f)
                curveTo(232.3f, 64.0f, 211.6f, 76.9f, 200.6f, 96.0f)
                lineTo(192.0f, 96.0f)
                curveTo(156.7f, 96.0f, 128.0f, 124.7f, 128.0f, 160.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 160.0f)
                curveTo(512.0f, 124.7f, 483.3f, 96.0f, 448.0f, 96.0f)
                close()
                moveTo(264.0f, 176.0f)
                curveTo(250.7f, 176.0f, 240.0f, 165.3f, 240.0f, 152.0f)
                curveTo(240.0f, 138.7f, 250.7f, 128.0f, 264.0f, 128.0f)
                lineTo(376.0f, 128.0f)
                curveTo(389.3f, 128.0f, 400.0f, 138.7f, 400.0f, 152.0f)
                curveTo(400.0f, 165.3f, 389.3f, 176.0f, 376.0f, 176.0f)
                lineTo(264.0f, 176.0f)
                close()
            }
        }
        .build()
        return _clipboard!!
    }

private var _clipboard: ImageVector? = null
