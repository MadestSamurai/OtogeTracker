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

public val Fa.`Diagram-next`: ImageVector
    get() {
        if (`_diagram-next` != null) {
            return `_diagram-next`!!
        }
        `_diagram-next` = Builder(name = "Diagram-next", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 288.0f)
                curveTo(515.3f, 288.0f, 544.0f, 259.3f, 544.0f, 224.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 224.0f)
                curveTo(96.0f, 259.3f, 124.7f, 288.0f, 160.0f, 288.0f)
                lineTo(288.0f, 288.0f)
                lineTo(288.0f, 352.0f)
                lineTo(256.0f, 352.0f)
                curveTo(249.5f, 352.0f, 243.7f, 355.9f, 241.2f, 361.9f)
                curveTo(238.7f, 367.9f, 240.1f, 374.8f, 244.7f, 379.3f)
                lineTo(308.7f, 443.3f)
                curveTo(314.9f, 449.5f, 325.1f, 449.5f, 331.3f, 443.3f)
                lineTo(395.3f, 379.3f)
                curveTo(399.9f, 374.7f, 401.2f, 367.8f, 398.8f, 361.9f)
                curveTo(396.4f, 356.0f, 390.5f, 352.0f, 384.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                lineTo(352.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                close()
                moveTo(160.0f, 352.0f)
                curveTo(124.7f, 352.0f, 96.0f, 380.7f, 96.0f, 416.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 380.7f, 515.3f, 352.0f, 480.0f, 352.0f)
                lineTo(446.0f, 352.0f)
                curveTo(451.6f, 373.7f, 445.5f, 397.1f, 429.3f, 413.3f)
                lineTo(365.3f, 477.3f)
                curveTo(340.3f, 502.3f, 299.8f, 502.3f, 274.8f, 477.3f)
                lineTo(210.8f, 413.3f)
                curveTo(194.6f, 397.1f, 188.4f, 373.7f, 194.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_diagram-next`!!
    }

private var `_diagram-next`: ImageVector? = null
