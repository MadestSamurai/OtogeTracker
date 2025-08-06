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

public val Fa.`Boxes-packing`: ImageVector
    get() {
        if (`_boxes-packing` != null) {
            return `_boxes-packing`!!
        }
        `_boxes-packing` = Builder(name = "Boxes-packing", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 64.0f)
                lineTo(320.0f, 64.0f)
                lineTo(320.0f, 120.0f)
                curveTo(320.0f, 133.3f, 330.7f, 144.0f, 344.0f, 144.0f)
                lineTo(424.0f, 144.0f)
                curveTo(437.3f, 144.0f, 448.0f, 133.3f, 448.0f, 120.0f)
                lineTo(448.0f, 64.0f)
                lineTo(528.0f, 64.0f)
                curveTo(554.5f, 64.0f, 576.0f, 85.5f, 576.0f, 112.0f)
                lineTo(576.0f, 528.0f)
                curveTo(576.0f, 554.5f, 554.5f, 576.0f, 528.0f, 576.0f)
                lineTo(419.2f, 576.0f)
                curveTo(427.4f, 561.9f, 432.0f, 545.5f, 432.0f, 528.0f)
                lineTo(432.0f, 368.0f)
                curveTo(442.0f, 354.6f, 448.0f, 338.0f, 448.0f, 320.0f)
                lineTo(448.0f, 288.0f)
                curveTo(448.0f, 243.8f, 412.2f, 208.0f, 368.0f, 208.0f)
                lineTo(192.0f, 208.0f)
                lineTo(192.0f, 112.0f)
                curveTo(192.0f, 85.5f, 213.5f, 64.0f, 240.0f, 64.0f)
                close()
                moveTo(64.0f, 400.0f)
                lineTo(384.0f, 400.0f)
                lineTo(384.0f, 528.0f)
                curveTo(384.0f, 554.5f, 362.5f, 576.0f, 336.0f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(85.5f, 576.0f, 64.0f, 554.5f, 64.0f, 528.0f)
                lineTo(64.0f, 400.0f)
                close()
                moveTo(80.0f, 256.0f)
                lineTo(368.0f, 256.0f)
                curveTo(385.7f, 256.0f, 400.0f, 270.3f, 400.0f, 288.0f)
                lineTo(400.0f, 320.0f)
                curveTo(400.0f, 337.7f, 385.7f, 352.0f, 368.0f, 352.0f)
                lineTo(80.0f, 352.0f)
                curveTo(62.3f, 352.0f, 48.0f, 337.7f, 48.0f, 320.0f)
                lineTo(48.0f, 288.0f)
                curveTo(48.0f, 270.3f, 62.3f, 256.0f, 80.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_boxes-packing`!!
    }

private var `_boxes-packing`: ImageVector? = null
