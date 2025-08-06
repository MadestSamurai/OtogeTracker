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

public val Fa.`Bread-slice`: ImageVector
    get() {
        if (`_bread-slice` != null) {
            return `_bread-slice`!!
        }
        `_bread-slice` = Builder(name = "Bread-slice", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 496.0f)
                lineTo(128.0f, 320.0f)
                curveTo(92.7f, 320.0f, 64.0f, 291.3f, 64.0f, 256.0f)
                curveTo(64.0f, 39.5f, 576.0f, 39.5f, 576.0f, 256.0f)
                curveTo(576.0f, 291.3f, 547.3f, 320.0f, 512.0f, 320.0f)
                lineTo(512.0f, 496.0f)
                curveTo(512.0f, 522.5f, 490.5f, 544.0f, 464.0f, 544.0f)
                lineTo(176.0f, 544.0f)
                curveTo(149.5f, 544.0f, 128.0f, 522.5f, 128.0f, 496.0f)
                close()
            }
        }
        .build()
        return `_bread-slice`!!
    }

private var `_bread-slice`: ImageVector? = null
