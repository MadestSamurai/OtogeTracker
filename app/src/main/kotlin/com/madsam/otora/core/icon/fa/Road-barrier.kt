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

public val Fa.`Road-barrier`: ImageVector
    get() {
        if (`_road-barrier` != null) {
            return `_road-barrier`!!
        }
        `_road-barrier` = Builder(name = "Road-barrier", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 96.0f)
                curveTo(14.3f, 96.0f, 0.0f, 110.3f, 0.0f, 128.0f)
                lineTo(0.0f, 512.0f)
                curveTo(0.0f, 529.7f, 14.3f, 544.0f, 32.0f, 544.0f)
                curveTo(49.7f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 330.3f)
                lineTo(149.2f, 160.0f)
                lineTo(64.0f, 160.0f)
                lineTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 49.7f, 96.0f, 32.0f, 96.0f)
                close()
                moveTo(405.2f, 160.0f)
                lineTo(330.9f, 160.0f)
                lineTo(325.5f, 170.7f)
                lineTo(234.9f, 352.0f)
                lineTo(309.2f, 352.0f)
                lineTo(314.6f, 341.3f)
                lineTo(405.2f, 160.0f)
                close()
                moveTo(362.8f, 352.0f)
                lineTo(437.1f, 352.0f)
                lineTo(442.5f, 341.3f)
                lineTo(533.1f, 160.0f)
                lineTo(458.8f, 160.0f)
                lineTo(453.4f, 170.7f)
                lineTo(362.8f, 352.0f)
                close()
                moveTo(202.8f, 160.0f)
                lineTo(197.4f, 170.7f)
                lineTo(106.8f, 352.0f)
                lineTo(181.1f, 352.0f)
                lineTo(186.5f, 341.3f)
                lineTo(277.1f, 160.0f)
                lineTo(202.8f, 160.0f)
                close()
                moveTo(490.8f, 352.0f)
                lineTo(576.0f, 352.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 590.3f, 544.0f, 608.0f, 544.0f)
                curveTo(625.7f, 544.0f, 640.0f, 529.7f, 640.0f, 512.0f)
                lineTo(640.0f, 128.0f)
                curveTo(640.0f, 110.3f, 625.7f, 96.0f, 608.0f, 96.0f)
                curveTo(590.3f, 96.0f, 576.0f, 110.3f, 576.0f, 128.0f)
                lineTo(576.0f, 181.7f)
                lineTo(490.8f, 352.0f)
                close()
            }
        }
        .build()
        return `_road-barrier`!!
    }

private var `_road-barrier`: ImageVector? = null
