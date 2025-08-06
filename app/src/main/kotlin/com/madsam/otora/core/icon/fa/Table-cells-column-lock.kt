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

public val Fa.`Table-cells-column-lock`: ImageVector
    get() {
        if (`_table-cells-column-lock` != null) {
            return `_table-cells-column-lock`!!
        }
        `_table-cells-column-lock` = Builder(name = "Table-cells-column-lock", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 288.0f)
                lineTo(256.0f, 480.0f)
                lineTo(320.0f, 480.0f)
                lineTo(320.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                close()
                moveTo(512.0f, 209.0f)
                curveTo(465.3f, 214.8f, 426.4f, 245.8f, 409.3f, 288.0f)
                lineTo(384.0f, 288.0f)
                lineTo(384.0f, 378.8f)
                curveTo(373.9f, 394.0f, 368.0f, 412.2f, 368.0f, 431.9f)
                lineTo(368.0f, 527.9f)
                curveTo(368.0f, 533.4f, 368.5f, 538.8f, 369.3f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                lineTo(64.0f, 160.0f)
                curveTo(64.0f, 124.7f, 92.7f, 96.0f, 128.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(483.3f, 96.0f, 512.0f, 124.7f, 512.0f, 160.0f)
                lineTo(512.0f, 209.0f)
                close()
                moveTo(128.0f, 288.0f)
                lineTo(128.0f, 480.0f)
                lineTo(192.0f, 480.0f)
                lineTo(192.0f, 288.0f)
                lineTo(128.0f, 288.0f)
                close()
                moveTo(560.0f, 336.1f)
                curveTo(560.0f, 318.4f, 545.7f, 304.1f, 528.0f, 304.1f)
                curveTo(510.3f, 304.1f, 496.0f, 318.4f, 496.0f, 336.1f)
                lineTo(496.0f, 384.0f)
                lineTo(560.0f, 384.0f)
                lineTo(560.0f, 336.1f)
                close()
                moveTo(416.0f, 432.0f)
                curveTo(416.0f, 411.1f, 429.4f, 393.3f, 448.0f, 386.7f)
                lineTo(448.0f, 336.1f)
                curveTo(448.0f, 291.9f, 483.8f, 256.1f, 528.0f, 256.1f)
                curveTo(572.2f, 256.1f, 608.0f, 291.9f, 608.0f, 336.1f)
                lineTo(608.0f, 386.7f)
                curveTo(626.6f, 393.3f, 640.0f, 411.1f, 640.0f, 432.0f)
                lineTo(640.0f, 528.0f)
                curveTo(640.0f, 554.5f, 618.5f, 576.0f, 592.0f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(437.5f, 576.0f, 416.0f, 554.5f, 416.0f, 528.0f)
                lineTo(416.0f, 432.0f)
                close()
            }
        }
        .build()
        return `_table-cells-column-lock`!!
    }

private var `_table-cells-column-lock`: ImageVector? = null
