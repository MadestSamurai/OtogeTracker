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

public val Fa.`Table-cells`: ImageVector
    get() {
        if (`_table-cells` != null) {
            return `_table-cells`!!
        }
        `_table-cells` = Builder(name = "Table-cells", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 160.0f)
                lineTo(480.0f, 224.0f)
                lineTo(416.0f, 224.0f)
                lineTo(416.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                close()
                moveTo(480.0f, 288.0f)
                lineTo(480.0f, 352.0f)
                lineTo(416.0f, 352.0f)
                lineTo(416.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                close()
                moveTo(480.0f, 416.0f)
                lineTo(480.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                lineTo(416.0f, 416.0f)
                lineTo(480.0f, 416.0f)
                close()
                moveTo(352.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                lineTo(352.0f, 352.0f)
                close()
                moveTo(288.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                lineTo(352.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                lineTo(288.0f, 416.0f)
                close()
                moveTo(224.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                lineTo(160.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                lineTo(224.0f, 352.0f)
                close()
                moveTo(160.0f, 416.0f)
                lineTo(224.0f, 416.0f)
                lineTo(224.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                lineTo(160.0f, 416.0f)
                close()
                moveTo(160.0f, 224.0f)
                lineTo(160.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                lineTo(224.0f, 224.0f)
                lineTo(160.0f, 224.0f)
                close()
                moveTo(288.0f, 224.0f)
                lineTo(288.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                lineTo(352.0f, 224.0f)
                lineTo(288.0f, 224.0f)
                close()
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
            }
        }
        .build()
        return `_table-cells`!!
    }

private var `_table-cells`: ImageVector? = null
