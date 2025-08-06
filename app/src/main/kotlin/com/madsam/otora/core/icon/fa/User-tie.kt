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

public val Fa.`User-tie`: ImageVector
    get() {
        if (`_user-tie` != null) {
            return `_user-tie`!!
        }
        `_user-tie` = Builder(name = "User-tie", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 312.0f)
                curveTo(253.7f, 312.0f, 200.0f, 258.3f, 200.0f, 192.0f)
                curveTo(200.0f, 125.7f, 253.7f, 72.0f, 320.0f, 72.0f)
                curveTo(386.3f, 72.0f, 440.0f, 125.7f, 440.0f, 192.0f)
                curveTo(440.0f, 258.3f, 386.3f, 312.0f, 320.0f, 312.0f)
                close()
                moveTo(289.5f, 368.0f)
                lineTo(350.5f, 368.0f)
                curveTo(360.2f, 368.0f, 368.0f, 375.8f, 368.0f, 385.5f)
                curveTo(368.0f, 389.7f, 366.5f, 393.7f, 363.8f, 396.9f)
                lineTo(336.4f, 428.9f)
                lineTo(367.4f, 544.0f)
                lineTo(368.0f, 544.0f)
                lineTo(402.6f, 405.5f)
                curveTo(404.8f, 396.8f, 413.7f, 391.5f, 422.1f, 394.7f)
                curveTo(484.0f, 418.3f, 528.0f, 478.3f, 528.0f, 548.5f)
                curveTo(528.0f, 563.6f, 515.7f, 575.9f, 500.6f, 575.9f)
                lineTo(139.4f, 576.0f)
                curveTo(124.3f, 576.0f, 112.0f, 563.7f, 112.0f, 548.6f)
                curveTo(112.0f, 478.4f, 156.0f, 418.4f, 217.9f, 394.8f)
                curveTo(226.3f, 391.6f, 235.2f, 396.9f, 237.4f, 405.6f)
                lineTo(272.0f, 544.1f)
                lineTo(272.6f, 544.1f)
                lineTo(303.6f, 429.0f)
                lineTo(276.2f, 397.0f)
                curveTo(273.5f, 393.8f, 272.0f, 389.8f, 272.0f, 385.6f)
                curveTo(272.0f, 375.9f, 279.8f, 368.1f, 289.5f, 368.1f)
                close()
            }
        }
        .build()
        return `_user-tie`!!
    }

private var `_user-tie`: ImageVector? = null
