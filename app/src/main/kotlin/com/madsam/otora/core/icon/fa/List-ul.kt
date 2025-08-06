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

public val Fa.`List-ul`: ImageVector
    get() {
        if (`_list-ul` != null) {
            return `_list-ul`!!
        }
        `_list-ul` = Builder(name = "List-ul", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(112.0f, 208.0f)
                curveTo(138.5f, 208.0f, 160.0f, 186.5f, 160.0f, 160.0f)
                curveTo(160.0f, 133.5f, 138.5f, 112.0f, 112.0f, 112.0f)
                curveTo(85.5f, 112.0f, 64.0f, 133.5f, 64.0f, 160.0f)
                curveTo(64.0f, 186.5f, 85.5f, 208.0f, 112.0f, 208.0f)
                close()
                moveTo(256.0f, 128.0f)
                curveTo(238.3f, 128.0f, 224.0f, 142.3f, 224.0f, 160.0f)
                curveTo(224.0f, 177.7f, 238.3f, 192.0f, 256.0f, 192.0f)
                lineTo(544.0f, 192.0f)
                curveTo(561.7f, 192.0f, 576.0f, 177.7f, 576.0f, 160.0f)
                curveTo(576.0f, 142.3f, 561.7f, 128.0f, 544.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                close()
                moveTo(256.0f, 288.0f)
                curveTo(238.3f, 288.0f, 224.0f, 302.3f, 224.0f, 320.0f)
                curveTo(224.0f, 337.7f, 238.3f, 352.0f, 256.0f, 352.0f)
                lineTo(544.0f, 352.0f)
                curveTo(561.7f, 352.0f, 576.0f, 337.7f, 576.0f, 320.0f)
                curveTo(576.0f, 302.3f, 561.7f, 288.0f, 544.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                close()
                moveTo(256.0f, 448.0f)
                curveTo(238.3f, 448.0f, 224.0f, 462.3f, 224.0f, 480.0f)
                curveTo(224.0f, 497.7f, 238.3f, 512.0f, 256.0f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(561.7f, 512.0f, 576.0f, 497.7f, 576.0f, 480.0f)
                curveTo(576.0f, 462.3f, 561.7f, 448.0f, 544.0f, 448.0f)
                lineTo(256.0f, 448.0f)
                close()
                moveTo(112.0f, 528.0f)
                curveTo(138.5f, 528.0f, 160.0f, 506.5f, 160.0f, 480.0f)
                curveTo(160.0f, 453.5f, 138.5f, 432.0f, 112.0f, 432.0f)
                curveTo(85.5f, 432.0f, 64.0f, 453.5f, 64.0f, 480.0f)
                curveTo(64.0f, 506.5f, 85.5f, 528.0f, 112.0f, 528.0f)
                close()
                moveTo(160.0f, 320.0f)
                curveTo(160.0f, 293.5f, 138.5f, 272.0f, 112.0f, 272.0f)
                curveTo(85.5f, 272.0f, 64.0f, 293.5f, 64.0f, 320.0f)
                curveTo(64.0f, 346.5f, 85.5f, 368.0f, 112.0f, 368.0f)
                curveTo(138.5f, 368.0f, 160.0f, 346.5f, 160.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_list-ul`!!
    }

private var `_list-ul`: ImageVector? = null
