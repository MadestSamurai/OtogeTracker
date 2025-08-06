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

public val Fa.`Laptop-code`: ImageVector
    get() {
        if (`_laptop-code` != null) {
            return `_laptop-code`!!
        }
        `_laptop-code` = Builder(name = "Laptop-code", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 160.0f)
                curveTo(64.0f, 124.7f, 92.7f, 96.0f, 128.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(547.3f, 96.0f, 576.0f, 124.7f, 576.0f, 160.0f)
                lineTo(576.0f, 400.0f)
                lineTo(512.0f, 400.0f)
                lineTo(512.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                lineTo(128.0f, 400.0f)
                lineTo(64.0f, 400.0f)
                lineTo(64.0f, 160.0f)
                close()
                moveTo(0.0f, 467.2f)
                curveTo(0.0f, 456.6f, 8.6f, 448.0f, 19.2f, 448.0f)
                lineTo(620.8f, 448.0f)
                curveTo(631.4f, 448.0f, 640.0f, 456.6f, 640.0f, 467.2f)
                curveTo(640.0f, 509.6f, 605.6f, 544.0f, 563.2f, 544.0f)
                lineTo(76.8f, 544.0f)
                curveTo(34.4f, 544.0f, 0.0f, 509.6f, 0.0f, 467.2f)
                close()
                moveTo(281.0f, 273.0f)
                lineTo(250.0f, 304.0f)
                lineTo(281.0f, 335.0f)
                curveTo(290.4f, 344.4f, 290.4f, 359.6f, 281.0f, 368.9f)
                curveTo(271.6f, 378.2f, 256.4f, 378.3f, 247.1f, 368.9f)
                lineTo(199.1f, 320.9f)
                curveTo(189.7f, 311.5f, 189.7f, 296.3f, 199.1f, 287.0f)
                lineTo(247.1f, 239.0f)
                curveTo(256.5f, 229.6f, 271.7f, 229.6f, 281.0f, 239.0f)
                curveTo(290.3f, 248.4f, 290.4f, 263.6f, 281.0f, 272.9f)
                close()
                moveTo(393.0f, 239.0f)
                lineTo(441.0f, 287.0f)
                curveTo(450.4f, 296.4f, 450.4f, 311.6f, 441.0f, 320.9f)
                lineTo(393.0f, 368.9f)
                curveTo(383.6f, 378.3f, 368.4f, 378.3f, 359.1f, 368.9f)
                curveTo(349.8f, 359.5f, 349.7f, 344.3f, 359.1f, 335.0f)
                lineTo(390.1f, 304.0f)
                lineTo(359.1f, 273.0f)
                curveTo(349.7f, 263.6f, 349.7f, 248.4f, 359.1f, 239.1f)
                curveTo(368.5f, 229.8f, 383.7f, 229.7f, 393.0f, 239.1f)
                close()
            }
        }
        .build()
        return `_laptop-code`!!
    }

private var `_laptop-code`: ImageVector? = null
