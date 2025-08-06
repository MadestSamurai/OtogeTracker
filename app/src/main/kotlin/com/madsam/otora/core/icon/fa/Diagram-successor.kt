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

public val Fa.`Diagram-successor`: ImageVector
    get() {
        if (`_diagram-successor` != null) {
            return `_diagram-successor`!!
        }
        `_diagram-successor` = Builder(name = "Diagram-successor", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(385.2f, 201.9f)
                curveTo(387.7f, 195.9f, 393.5f, 192.0f, 400.0f, 192.0f)
                lineTo(440.0f, 192.0f)
                lineTo(440.0f, 168.0f)
                curveTo(440.0f, 154.7f, 429.3f, 144.0f, 416.0f, 144.0f)
                lineTo(318.0f, 144.0f)
                curveTo(319.3f, 149.1f, 320.0f, 154.5f, 320.0f, 160.0f)
                lineTo(320.0f, 224.0f)
                curveTo(320.0f, 259.3f, 291.3f, 288.0f, 256.0f, 288.0f)
                lineTo(160.0f, 288.0f)
                curveTo(124.7f, 288.0f, 96.0f, 259.3f, 96.0f, 224.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                curveTo(455.8f, 96.0f, 488.0f, 128.2f, 488.0f, 168.0f)
                lineTo(488.0f, 192.0f)
                lineTo(528.0f, 192.0f)
                curveTo(534.5f, 192.0f, 540.3f, 195.9f, 542.8f, 201.9f)
                curveTo(545.3f, 207.9f, 543.9f, 214.8f, 539.3f, 219.3f)
                lineTo(475.3f, 283.3f)
                curveTo(469.1f, 289.5f, 458.9f, 289.5f, 452.7f, 283.3f)
                lineTo(388.7f, 219.3f)
                curveTo(384.1f, 214.7f, 382.8f, 207.8f, 385.2f, 201.9f)
                close()
                moveTo(480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 416.0f)
                curveTo(96.0f, 380.7f, 124.7f, 352.0f, 160.0f, 352.0f)
                lineTo(480.0f, 352.0f)
                curveTo(515.3f, 352.0f, 544.0f, 380.7f, 544.0f, 416.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                close()
                moveTo(256.0f, 224.0f)
                lineTo(256.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                lineTo(160.0f, 224.0f)
                lineTo(256.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_diagram-successor`!!
    }

private var `_diagram-successor`: ImageVector? = null
