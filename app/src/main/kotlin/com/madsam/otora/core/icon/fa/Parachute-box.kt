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

public val Fa.`Parachute-box`: ImageVector
    get() {
        if (`_parachute-box` != null) {
            return `_parachute-box`!!
        }
        `_parachute-box` = Builder(name = "Parachute-box", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 288.0f)
                curveTo(192.0f, 216.2f, 208.3f, 152.4f, 233.5f, 107.4f)
                curveTo(259.1f, 61.6f, 290.6f, 40.0f, 320.0f, 40.0f)
                curveTo(349.4f, 40.0f, 380.9f, 61.6f, 406.5f, 107.4f)
                curveTo(431.7f, 152.4f, 448.0f, 216.2f, 448.0f, 288.0f)
                lineTo(344.0f, 288.0f)
                lineTo(344.0f, 384.0f)
                lineTo(352.0f, 384.0f)
                curveTo(361.3f, 384.0f, 370.1f, 386.0f, 378.0f, 389.5f)
                lineTo(496.4f, 288.0f)
                lineTo(495.9f, 288.0f)
                curveTo(495.9f, 209.6f, 478.2f, 137.4f, 448.3f, 84.0f)
                curveTo(442.2f, 73.0f, 435.4f, 62.7f, 428.0f, 53.1f)
                curveTo(514.5f, 89.0f, 575.8f, 168.2f, 575.8f, 272.0f)
                curveTo(575.8f, 279.0f, 572.7f, 285.7f, 567.4f, 290.2f)
                lineTo(411.4f, 424.1f)
                curveTo(414.4f, 431.5f, 416.0f, 439.5f, 416.0f, 448.0f)
                lineTo(416.0f, 512.0f)
                curveTo(416.0f, 547.3f, 387.3f, 576.0f, 352.0f, 576.0f)
                lineTo(288.0f, 576.0f)
                curveTo(252.7f, 576.0f, 224.0f, 547.3f, 224.0f, 512.0f)
                lineTo(224.0f, 448.0f)
                curveTo(224.0f, 439.6f, 225.6f, 431.5f, 228.6f, 424.1f)
                lineTo(72.4f, 290.2f)
                curveTo(67.1f, 285.7f, 64.0f, 279.0f, 64.0f, 272.0f)
                curveTo(64.0f, 168.2f, 125.3f, 88.9f, 211.8f, 53.1f)
                curveTo(204.5f, 62.6f, 197.7f, 73.0f, 191.6f, 84.0f)
                curveTo(161.7f, 137.4f, 144.0f, 209.6f, 144.0f, 288.0f)
                lineTo(143.5f, 288.0f)
                lineTo(261.9f, 389.5f)
                curveTo(269.9f, 386.0f, 278.7f, 384.0f, 287.9f, 384.0f)
                lineTo(295.9f, 384.0f)
                lineTo(295.9f, 288.0f)
                lineTo(191.9f, 288.0f)
                close()
            }
        }
        .build()
        return `_parachute-box`!!
    }

private var `_parachute-box`: ImageVector? = null
