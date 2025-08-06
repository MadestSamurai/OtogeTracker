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

public val Fa.`Laptop-file`: ImageVector
    get() {
        if (`_laptop-file` != null) {
            return `_laptop-file`!!
        }
        `_laptop-file` = Builder(name = "Laptop-file", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 92.7f, 124.7f, 64.0f, 160.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(483.3f, 64.0f, 512.0f, 92.7f, 512.0f, 128.0f)
                lineTo(512.0f, 176.0f)
                lineTo(448.0f, 176.0f)
                lineTo(448.0f, 128.0f)
                lineTo(160.0f, 128.0f)
                lineTo(160.0f, 320.0f)
                lineTo(272.0f, 320.0f)
                lineTo(272.0f, 416.0f)
                lineTo(108.8f, 416.0f)
                curveTo(66.4f, 416.0f, 32.0f, 381.6f, 32.0f, 339.2f)
                curveTo(32.0f, 328.6f, 40.6f, 320.0f, 51.2f, 320.0f)
                lineTo(96.0f, 320.0f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(561.9f, 321.9f)
                curveTo(570.9f, 330.9f, 576.0f, 343.1f, 576.0f, 355.8f)
                lineTo(576.0f, 528.0f)
                curveTo(576.0f, 554.5f, 554.5f, 576.0f, 528.0f, 576.0f)
                lineTo(368.0f, 576.0f)
                curveTo(341.5f, 576.0f, 320.0f, 554.5f, 320.0f, 528.0f)
                lineTo(320.0f, 272.0f)
                curveTo(320.0f, 245.5f, 341.5f, 224.0f, 368.0f, 224.0f)
                lineTo(444.1f, 224.0f)
                curveTo(456.8f, 224.0f, 469.0f, 229.1f, 478.0f, 238.1f)
                curveTo(498.0f, 258.1f, 525.9f, 286.0f, 561.9f, 322.0f)
                close()
                moveTo(448.0f, 336.0f)
                curveTo(448.0f, 344.8f, 455.2f, 352.0f, 464.0f, 352.0f)
                lineTo(524.1f, 352.0f)
                lineTo(448.0f, 275.9f)
                lineTo(448.0f, 336.0f)
                close()
            }
        }
        .build()
        return `_laptop-file`!!
    }

private var `_laptop-file`: ImageVector? = null
