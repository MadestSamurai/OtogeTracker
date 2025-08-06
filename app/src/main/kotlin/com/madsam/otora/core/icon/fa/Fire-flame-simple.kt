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

public val Fa.`Fire-flame-simple`: ImageVector
    get() {
        if (`_fire-flame-simple` != null) {
            return `_fire-flame-simple`!!
        }
        `_fire-flame-simple` = Builder(name = "Fire-flame-simple", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(500.5f, 320.5f)
                lineTo(499.8f, 318.6f)
                curveTo(465.8f, 224.8f, 410.0f, 140.5f, 337.1f, 72.5f)
                lineTo(333.8f, 69.5f)
                curveTo(330.1f, 66.0f, 325.1f, 64.0f, 320.0f, 64.0f)
                curveTo(314.9f, 64.0f, 309.9f, 66.0f, 306.2f, 69.5f)
                lineTo(302.9f, 72.5f)
                curveTo(230.0f, 140.5f, 174.2f, 224.8f, 140.2f, 318.6f)
                lineTo(139.5f, 320.5f)
                curveTo(131.9f, 341.3f, 128.0f, 363.4f, 128.0f, 385.6f)
                curveTo(128.0f, 490.7f, 214.8f, 576.0f, 320.0f, 576.0f)
                curveTo(425.2f, 576.0f, 512.0f, 490.7f, 512.0f, 385.6f)
                curveTo(512.0f, 363.4f, 508.1f, 341.4f, 500.5f, 320.5f)
                close()
                moveTo(409.7f, 370.0f)
                curveTo(413.8f, 379.3f, 415.9f, 389.4f, 415.9f, 399.5f)
                curveTo(415.9f, 452.5f, 372.9f, 496.0f, 319.9f, 496.0f)
                curveTo(266.9f, 496.0f, 223.9f, 452.5f, 223.9f, 399.5f)
                curveTo(223.9f, 389.4f, 226.0f, 379.2f, 230.1f, 370.0f)
                lineTo(232.0f, 365.7f)
                curveTo(247.8f, 330.3f, 269.9f, 298.0f, 297.3f, 270.6f)
                lineTo(306.2f, 261.7f)
                curveTo(309.8f, 258.1f, 314.7f, 256.1f, 319.8f, 256.1f)
                curveTo(324.9f, 256.1f, 329.8f, 258.1f, 333.4f, 261.7f)
                lineTo(342.3f, 270.6f)
                curveTo(369.7f, 298.0f, 391.9f, 330.3f, 407.6f, 365.7f)
                lineTo(409.5f, 370.0f)
                close()
            }
        }
        .build()
        return `_fire-flame-simple`!!
    }

private var `_fire-flame-simple`: ImageVector? = null
