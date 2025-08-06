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

public val Fa.`Circle-chevron-right`: ImageVector
    get() {
        if (`_circle-chevron-right` != null) {
            return `_circle-chevron-right`!!
        }
        `_circle-chevron-right` = Builder(name = "Circle-chevron-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                close()
                moveTo(305.0f, 441.0f)
                curveTo(295.6f, 450.4f, 280.4f, 450.4f, 271.1f, 441.0f)
                curveTo(261.8f, 431.6f, 261.7f, 416.4f, 271.1f, 407.1f)
                lineTo(358.1f, 320.1f)
                lineTo(271.1f, 233.1f)
                curveTo(261.7f, 223.7f, 261.7f, 208.5f, 271.1f, 199.2f)
                curveTo(280.5f, 189.9f, 295.7f, 189.8f, 305.0f, 199.2f)
                lineTo(409.0f, 303.0f)
                curveTo(418.4f, 312.4f, 418.4f, 327.6f, 409.0f, 336.9f)
                lineTo(305.0f, 441.0f)
                close()
            }
        }
        .build()
        return `_circle-chevron-right`!!
    }

private var `_circle-chevron-right`: ImageVector? = null
