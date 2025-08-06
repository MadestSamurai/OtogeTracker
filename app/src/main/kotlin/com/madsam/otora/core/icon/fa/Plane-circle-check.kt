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

public val Fa.`Plane-circle-check`: ImageVector
    get() {
        if (`_plane-circle-check` != null) {
            return `_plane-circle-check`!!
        }
        `_plane-circle-check` = Builder(name = "Plane-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(232.0f, 88.0f)
                curveTo(232.0f, 57.1f, 257.1f, 32.0f, 288.0f, 32.0f)
                curveTo(318.9f, 32.0f, 344.0f, 57.1f, 344.0f, 88.0f)
                lineTo(344.0f, 215.3f)
                lineTo(422.0f, 286.8f)
                curveTo(352.7f, 315.8f, 304.0f, 384.2f, 304.0f, 464.0f)
                curveTo(304.0f, 513.3f, 322.6f, 558.3f, 353.1f, 592.3f)
                lineTo(288.0f, 576.0f)
                lineTo(179.9f, 603.0f)
                curveTo(169.8f, 605.5f, 160.0f, 597.9f, 160.0f, 587.5f)
                lineTo(160.0f, 567.7f)
                curveTo(160.0f, 562.8f, 162.2f, 558.2f, 166.0f, 555.2f)
                lineTo(232.0f, 502.4f)
                lineTo(232.0f, 402.7f)
                lineTo(69.1f, 457.0f)
                curveTo(58.7f, 460.4f, 48.0f, 452.7f, 48.0f, 441.8f)
                lineTo(48.0f, 398.1f)
                curveTo(48.0f, 389.1f, 51.8f, 380.6f, 58.4f, 374.5f)
                lineTo(232.0f, 215.3f)
                lineTo(232.0f, 88.0f)
                close()
                moveTo(352.0f, 464.0f)
                curveTo(352.0f, 384.5f, 416.5f, 320.0f, 496.0f, 320.0f)
                curveTo(575.5f, 320.0f, 640.0f, 384.5f, 640.0f, 464.0f)
                curveTo(640.0f, 543.5f, 575.5f, 608.0f, 496.0f, 608.0f)
                curveTo(416.5f, 608.0f, 352.0f, 543.5f, 352.0f, 464.0f)
                close()
                moveTo(553.4f, 403.1f)
                curveTo(546.3f, 397.9f, 536.2f, 399.5f, 531.0f, 406.6f)
                lineTo(478.0f, 479.5f)
                lineTo(451.2f, 452.7f)
                curveTo(445.0f, 446.5f, 434.8f, 446.5f, 428.6f, 452.7f)
                curveTo(422.4f, 458.9f, 422.4f, 469.1f, 428.6f, 475.3f)
                lineTo(468.6f, 515.3f)
                curveTo(471.9f, 518.6f, 476.5f, 520.3f, 481.2f, 519.9f)
                curveTo(485.9f, 519.5f, 490.1f, 517.1f, 492.9f, 513.4f)
                lineTo(556.9f, 425.4f)
                curveTo(562.1f, 418.3f, 560.5f, 408.2f, 553.4f, 403.1f)
                close()
            }
        }
        .build()
        return `_plane-circle-check`!!
    }

private var `_plane-circle-check`: ImageVector? = null
