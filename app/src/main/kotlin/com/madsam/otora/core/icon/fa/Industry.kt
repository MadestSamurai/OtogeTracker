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

public val Fa.Industry: ImageVector
    get() {
        if (_industry != null) {
            return _industry!!
        }
        _industry = Builder(name = "Industry", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(78.3f, 96.0f, 64.0f, 110.3f, 64.0f, 128.0f)
                lineTo(64.0f, 496.0f)
                curveTo(64.0f, 522.5f, 85.5f, 544.0f, 112.0f, 544.0f)
                lineTo(528.0f, 544.0f)
                curveTo(554.5f, 544.0f, 576.0f, 522.5f, 576.0f, 496.0f)
                lineTo(576.0f, 216.2f)
                curveTo(576.0f, 198.0f, 556.6f, 186.5f, 540.6f, 195.1f)
                lineTo(384.0f, 279.4f)
                lineTo(384.0f, 216.2f)
                curveTo(384.0f, 198.0f, 364.6f, 186.5f, 348.6f, 195.1f)
                lineTo(192.0f, 279.4f)
                lineTo(192.0f, 128.0f)
                curveTo(192.0f, 110.3f, 177.7f, 96.0f, 160.0f, 96.0f)
                lineTo(96.0f, 96.0f)
                close()
            }
        }
        .build()
        return _industry!!
    }

private var _industry: ImageVector? = null
