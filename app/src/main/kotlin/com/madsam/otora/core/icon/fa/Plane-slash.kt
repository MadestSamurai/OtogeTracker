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

public val Fa.`Plane-slash`: ImageVector
    get() {
        if (`_plane-slash` != null) {
            return `_plane-slash`!!
        }
        `_plane-slash` = Builder(name = "Plane-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(417.5f, 383.8f)
                lineTo(424.6f, 376.1f)
                lineTo(551.9f, 376.1f)
                curveTo(582.8f, 376.1f, 607.9f, 351.0f, 607.9f, 320.1f)
                curveTo(607.9f, 289.2f, 582.8f, 264.1f, 551.9f, 264.1f)
                lineTo(424.7f, 264.0f)
                lineTo(265.5f, 90.4f)
                curveTo(259.5f, 83.8f, 250.9f, 80.0f, 241.9f, 80.0f)
                lineTo(198.2f, 80.0f)
                curveTo(187.3f, 80.0f, 179.6f, 90.7f, 183.0f, 101.1f)
                lineTo(207.1f, 173.2f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(162.2f, 264.0f)
                lineTo(137.6f, 264.0f)
                lineTo(84.8f, 198.0f)
                curveTo(81.8f, 194.2f, 77.2f, 192.0f, 72.3f, 192.0f)
                lineTo(52.5f, 192.0f)
                curveTo(42.1f, 192.0f, 34.5f, 201.8f, 37.0f, 211.9f)
                lineTo(64.0f, 320.0f)
                lineTo(37.0f, 428.1f)
                curveTo(34.4f, 438.2f, 42.1f, 448.0f, 52.5f, 448.0f)
                lineTo(72.3f, 448.0f)
                curveTo(77.2f, 448.0f, 81.8f, 445.8f, 84.8f, 442.0f)
                lineTo(137.6f, 376.0f)
                lineTo(237.3f, 376.0f)
                lineTo(183.0f, 538.9f)
                curveTo(179.5f, 549.3f, 187.3f, 560.0f, 198.2f, 560.0f)
                lineTo(241.9f, 560.0f)
                curveTo(250.9f, 560.0f, 259.4f, 556.2f, 265.5f, 549.6f)
                lineTo(352.7f, 454.5f)
                lineTo(162.2f, 264.0f)
                close()
            }
        }
        .build()
        return `_plane-slash`!!
    }

private var `_plane-slash`: ImageVector? = null
