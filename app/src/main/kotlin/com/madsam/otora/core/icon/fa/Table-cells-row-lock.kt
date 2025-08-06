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

public val Fa.`Table-cells-row-lock`: ImageVector
    get() {
        if (`_table-cells-row-lock` != null) {
            return `_table-cells-row-lock`!!
        }
        `_table-cells-row-lock` = Builder(name = "Table-cells-row-lock", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 352.0f)
                lineTo(256.0f, 288.0f)
                lineTo(409.3f, 288.0f)
                curveTo(426.4f, 245.8f, 465.3f, 214.8f, 512.0f, 209.0f)
                lineTo(512.0f, 160.0f)
                curveTo(512.0f, 124.7f, 483.3f, 96.0f, 448.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(369.3f, 544.0f)
                curveTo(368.4f, 538.8f, 368.0f, 533.4f, 368.0f, 527.9f)
                lineTo(368.0f, 480.0f)
                lineTo(256.0f, 480.0f)
                lineTo(256.0f, 416.0f)
                lineTo(369.3f, 416.0f)
                curveTo(373.0f, 394.0f, 384.1f, 374.6f, 400.0f, 360.4f)
                lineTo(400.0f, 352.0f)
                lineTo(256.0f, 352.0f)
                close()
                moveTo(256.0f, 160.0f)
                lineTo(448.0f, 160.0f)
                lineTo(448.0f, 224.0f)
                lineTo(256.0f, 224.0f)
                lineTo(256.0f, 160.0f)
                close()
                moveTo(560.0f, 336.1f)
                lineTo(560.0f, 384.0f)
                lineTo(496.0f, 384.0f)
                lineTo(496.0f, 336.1f)
                curveTo(496.0f, 318.4f, 510.3f, 304.1f, 528.0f, 304.1f)
                curveTo(545.7f, 304.1f, 560.0f, 318.4f, 560.0f, 336.1f)
                close()
                moveTo(416.0f, 432.0f)
                lineTo(416.0f, 528.0f)
                curveTo(416.0f, 554.5f, 437.5f, 576.0f, 464.0f, 576.0f)
                lineTo(592.0f, 576.0f)
                curveTo(618.5f, 576.0f, 640.0f, 554.5f, 640.0f, 528.0f)
                lineTo(640.0f, 432.0f)
                curveTo(640.0f, 411.1f, 626.6f, 393.3f, 608.0f, 386.7f)
                lineTo(608.0f, 336.1f)
                curveTo(608.0f, 291.9f, 572.2f, 256.1f, 528.0f, 256.1f)
                curveTo(483.8f, 256.1f, 448.0f, 291.9f, 448.0f, 336.1f)
                lineTo(448.0f, 386.7f)
                curveTo(429.4f, 393.3f, 416.0f, 411.1f, 416.0f, 432.0f)
                close()
            }
        }
        .build()
        return `_table-cells-row-lock`!!
    }

private var `_table-cells-row-lock`: ImageVector? = null
