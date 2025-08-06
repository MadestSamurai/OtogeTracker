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

public val Fa.Peace: ImageVector
    get() {
        if (_peace != null) {
            return _peace!!
        }
        _peace = Builder(name = "Peace", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 509.3f)
                lineTo(288.0f, 387.5f)
                lineTo(193.7f, 464.6f)
                curveTo(219.8f, 487.4f, 252.2f, 503.3f, 288.0f, 509.3f)
                close()
                moveTo(153.2f, 415.1f)
                lineTo(288.0f, 304.8f)
                lineTo(288.0f, 130.7f)
                curveTo(197.2f, 145.9f, 128.0f, 224.9f, 128.0f, 320.0f)
                curveTo(128.0f, 354.6f, 137.2f, 387.1f, 153.2f, 415.1f)
                close()
                moveTo(446.3f, 464.6f)
                lineTo(352.0f, 387.5f)
                lineTo(352.0f, 509.3f)
                curveTo(387.7f, 503.3f, 420.1f, 487.4f, 446.3f, 464.6f)
                close()
                moveTo(486.9f, 415.1f)
                curveTo(502.9f, 387.1f, 512.1f, 354.6f, 512.1f, 320.0f)
                curveTo(512.1f, 224.9f, 442.9f, 145.9f, 352.1f, 130.7f)
                lineTo(352.1f, 304.9f)
                lineTo(486.9f, 415.2f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
            }
        }
        .build()
        return _peace!!
    }

private var _peace: ImageVector? = null
