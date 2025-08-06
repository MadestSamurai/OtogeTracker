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

public val Fa.`Circle-chevron-left`: ImageVector
    get() {
        if (`_circle-chevron-left` != null) {
            return `_circle-chevron-left`!!
        }
        `_circle-chevron-left` = Builder(name = "Circle-chevron-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                close()
                moveTo(335.0f, 199.0f)
                curveTo(344.4f, 189.6f, 359.6f, 189.6f, 368.9f, 199.0f)
                curveTo(378.2f, 208.4f, 378.3f, 223.6f, 368.9f, 232.9f)
                lineTo(281.9f, 319.9f)
                lineTo(368.9f, 406.9f)
                curveTo(378.3f, 416.3f, 378.3f, 431.5f, 368.9f, 440.8f)
                curveTo(359.5f, 450.1f, 344.3f, 450.2f, 335.0f, 440.8f)
                lineTo(231.0f, 337.0f)
                curveTo(221.6f, 327.6f, 221.6f, 312.4f, 231.0f, 303.1f)
                lineTo(335.0f, 199.0f)
                close()
            }
        }
        .build()
        return `_circle-chevron-left`!!
    }

private var `_circle-chevron-left`: ImageVector? = null
