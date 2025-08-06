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

public val Fa.`Ticket-alt`: ImageVector
    get() {
        if (`_ticket-alt` != null) {
            return `_ticket-alt`!!
        }
        `_ticket-alt` = Builder(name = "Ticket-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 192.0f)
                curveTo(32.0f, 156.7f, 60.7f, 128.0f, 96.0f, 128.0f)
                lineTo(544.0f, 128.0f)
                curveTo(579.3f, 128.0f, 608.0f, 156.7f, 608.0f, 192.0f)
                lineTo(608.0f, 256.0f)
                curveTo(608.0f, 264.8f, 600.6f, 271.7f, 592.3f, 274.6f)
                curveTo(573.5f, 281.1f, 560.0f, 299.0f, 560.0f, 320.0f)
                curveTo(560.0f, 341.0f, 573.5f, 358.9f, 592.3f, 365.4f)
                curveTo(600.6f, 368.3f, 608.0f, 375.2f, 608.0f, 384.0f)
                lineTo(608.0f, 448.0f)
                curveTo(608.0f, 483.3f, 579.3f, 512.0f, 544.0f, 512.0f)
                lineTo(96.0f, 512.0f)
                curveTo(60.7f, 512.0f, 32.0f, 483.3f, 32.0f, 448.0f)
                lineTo(32.0f, 384.0f)
                curveTo(32.0f, 375.2f, 39.4f, 368.3f, 47.7f, 365.4f)
                curveTo(66.5f, 358.9f, 80.0f, 341.0f, 80.0f, 320.0f)
                curveTo(80.0f, 299.0f, 66.5f, 281.1f, 47.7f, 274.6f)
                curveTo(39.4f, 271.7f, 32.0f, 264.8f, 32.0f, 256.0f)
                lineTo(32.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_ticket-alt`!!
    }

private var `_ticket-alt`: ImageVector? = null
