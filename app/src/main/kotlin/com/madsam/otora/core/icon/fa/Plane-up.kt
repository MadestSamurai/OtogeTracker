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

public val Fa.`Plane-up`: ImageVector
    get() {
        if (`_plane-up` != null) {
            return `_plane-up`!!
        }
        `_plane-up` = Builder(name = "Plane-up", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(264.0f, 88.0f)
                curveTo(264.0f, 57.1f, 289.1f, 32.0f, 320.0f, 32.0f)
                curveTo(350.9f, 32.0f, 376.0f, 57.1f, 376.0f, 88.0f)
                lineTo(376.0f, 215.3f)
                lineTo(549.6f, 374.5f)
                curveTo(556.2f, 380.6f, 560.0f, 389.1f, 560.0f, 398.1f)
                lineTo(560.0f, 441.8f)
                curveTo(560.0f, 452.7f, 549.3f, 460.4f, 538.9f, 457.0f)
                lineTo(376.0f, 402.7f)
                lineTo(376.0f, 502.4f)
                lineTo(442.0f, 555.2f)
                curveTo(445.8f, 558.2f, 448.0f, 562.8f, 448.0f, 567.7f)
                lineTo(448.0f, 587.5f)
                curveTo(448.0f, 597.9f, 438.2f, 605.5f, 428.1f, 603.0f)
                lineTo(320.0f, 576.0f)
                lineTo(211.9f, 603.0f)
                curveTo(201.8f, 605.5f, 192.0f, 597.9f, 192.0f, 587.5f)
                lineTo(192.0f, 567.7f)
                curveTo(192.0f, 562.8f, 194.2f, 558.2f, 198.0f, 555.2f)
                lineTo(264.0f, 502.4f)
                lineTo(264.0f, 402.7f)
                lineTo(101.1f, 457.0f)
                curveTo(90.7f, 460.4f, 80.0f, 452.7f, 80.0f, 441.8f)
                lineTo(80.0f, 398.1f)
                curveTo(80.0f, 389.1f, 83.8f, 380.6f, 90.4f, 374.5f)
                lineTo(264.0f, 215.3f)
                lineTo(264.0f, 88.0f)
                close()
            }
        }
        .build()
        return `_plane-up`!!
    }

private var `_plane-up`: ImageVector? = null
