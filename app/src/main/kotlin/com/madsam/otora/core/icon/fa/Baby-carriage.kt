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

public val Fa.`Baby-carriage`: ImageVector
    get() {
        if (`_baby-carriage` != null) {
            return `_baby-carriage`!!
        }
        `_baby-carriage` = Builder(name = "Baby-carriage", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 272.0f)
                lineTo(128.0f, 352.0f)
                curveTo(128.0f, 405.0f, 171.0f, 448.0f, 224.0f, 448.0f)
                lineTo(416.0f, 448.0f)
                curveTo(469.0f, 448.0f, 512.0f, 405.0f, 512.0f, 352.0f)
                lineTo(512.0f, 240.0f)
                lineTo(552.0f, 240.0f)
                curveTo(565.3f, 240.0f, 576.0f, 229.3f, 576.0f, 216.0f)
                curveTo(576.0f, 202.7f, 565.3f, 192.0f, 552.0f, 192.0f)
                lineTo(488.0f, 192.0f)
                curveTo(474.7f, 192.0f, 464.0f, 202.7f, 464.0f, 216.0f)
                lineTo(464.0f, 272.0f)
                lineTo(128.0f, 272.0f)
                close()
                moveTo(128.2f, 224.0f)
                lineTo(352.0f, 224.0f)
                lineTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                lineTo(296.0f, 64.0f)
                curveTo(205.9f, 64.0f, 132.4f, 134.9f, 128.2f, 224.0f)
                close()
                moveTo(224.0f, 528.0f)
                curveTo(224.0f, 501.5f, 202.5f, 480.0f, 176.0f, 480.0f)
                curveTo(149.5f, 480.0f, 128.0f, 501.5f, 128.0f, 528.0f)
                curveTo(128.0f, 554.5f, 149.5f, 576.0f, 176.0f, 576.0f)
                curveTo(202.5f, 576.0f, 224.0f, 554.5f, 224.0f, 528.0f)
                close()
                moveTo(512.0f, 528.0f)
                curveTo(512.0f, 501.5f, 490.5f, 480.0f, 464.0f, 480.0f)
                curveTo(437.5f, 480.0f, 416.0f, 501.5f, 416.0f, 528.0f)
                curveTo(416.0f, 554.5f, 437.5f, 576.0f, 464.0f, 576.0f)
                curveTo(490.5f, 576.0f, 512.0f, 554.5f, 512.0f, 528.0f)
                close()
            }
        }
        .build()
        return `_baby-carriage`!!
    }

private var `_baby-carriage`: ImageVector? = null
