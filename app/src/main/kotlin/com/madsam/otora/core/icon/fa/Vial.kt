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

public val Fa.Vial: ImageVector
    get() {
        if (_vial != null) {
            return _vial!!
        }
        _vial = Builder(name = "Vial", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(406.6f, 73.4f)
                curveTo(394.1f, 60.9f, 373.8f, 60.9f, 361.3f, 73.4f)
                curveTo(348.8f, 85.9f, 348.8f, 106.2f, 361.3f, 118.7f)
                lineTo(370.7f, 128.0f)
                lineTo(92.1f, 406.6f)
                curveTo(74.1f, 424.6f, 64.0f, 449.0f, 64.0f, 474.5f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 533.0f, 107.0f, 576.0f, 160.0f, 576.0f)
                lineTo(165.5f, 576.0f)
                curveTo(191.0f, 576.0f, 215.4f, 565.9f, 233.4f, 547.9f)
                lineTo(512.0f, 269.3f)
                lineTo(521.4f, 278.7f)
                curveTo(533.9f, 291.2f, 554.2f, 291.2f, 566.7f, 278.7f)
                curveTo(579.2f, 266.2f, 579.2f, 245.9f, 566.7f, 233.4f)
                lineTo(406.7f, 73.4f)
                close()
                moveTo(269.3f, 320.0f)
                lineTo(416.0f, 173.3f)
                lineTo(466.7f, 224.0f)
                lineTo(370.7f, 320.0f)
                lineTo(269.2f, 320.0f)
                close()
            }
        }
        .build()
        return _vial!!
    }

private var _vial: ImageVector? = null
