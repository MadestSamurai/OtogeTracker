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

public val Fa.`Sort-desc`: ImageVector
    get() {
        if (`_sort-desc` != null) {
            return `_sort-desc`!!
        }
        `_sort-desc` = Builder(name = "Sort-desc", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 352.0f)
                curveTo(147.1f, 352.0f, 135.4f, 359.8f, 130.4f, 371.8f)
                curveTo(125.4f, 383.8f, 128.2f, 397.5f, 137.4f, 406.6f)
                lineTo(297.4f, 566.6f)
                curveTo(309.9f, 579.1f, 330.2f, 579.1f, 342.7f, 566.6f)
                lineTo(502.7f, 406.6f)
                curveTo(511.9f, 397.4f, 514.6f, 383.7f, 509.6f, 371.7f)
                curveTo(504.6f, 359.7f, 492.9f, 352.0f, 480.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_sort-desc`!!
    }

private var `_sort-desc`: ImageVector? = null
