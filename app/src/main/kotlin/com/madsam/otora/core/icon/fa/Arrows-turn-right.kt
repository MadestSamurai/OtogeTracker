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

public val Fa.`Arrows-turn-right`: ImageVector
    get() {
        if (`_arrows-turn-right` != null) {
            return `_arrows-turn-right`!!
        }
        `_arrows-turn-right` = Builder(name = "Arrows-turn-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(409.4f, 57.4f)
                curveTo(421.9f, 44.9f, 442.2f, 44.9f, 454.7f, 57.4f)
                lineTo(534.7f, 137.4f)
                curveTo(547.2f, 149.9f, 547.2f, 170.2f, 534.7f, 182.7f)
                lineTo(454.7f, 262.7f)
                curveTo(442.2f, 275.2f, 421.9f, 275.2f, 409.4f, 262.7f)
                curveTo(396.9f, 250.2f, 396.9f, 229.9f, 409.4f, 217.4f)
                lineTo(434.7f, 192.0f)
                lineTo(224.0f, 192.0f)
                curveTo(188.7f, 192.0f, 160.0f, 220.7f, 160.0f, 256.0f)
                lineTo(160.0f, 288.0f)
                curveTo(160.0f, 305.7f, 145.7f, 320.0f, 128.0f, 320.0f)
                curveTo(110.3f, 320.0f, 96.0f, 305.7f, 96.0f, 288.0f)
                lineTo(96.0f, 256.0f)
                curveTo(96.0f, 185.3f, 153.3f, 128.0f, 224.0f, 128.0f)
                lineTo(434.7f, 128.0f)
                lineTo(409.3f, 102.6f)
                curveTo(396.8f, 90.1f, 396.8f, 69.8f, 409.3f, 57.3f)
                close()
                moveTo(313.4f, 313.4f)
                curveTo(325.9f, 300.9f, 346.2f, 300.9f, 358.7f, 313.4f)
                lineTo(438.7f, 393.4f)
                curveTo(451.2f, 405.9f, 451.2f, 426.2f, 438.7f, 438.7f)
                lineTo(358.7f, 518.7f)
                curveTo(346.2f, 531.2f, 325.9f, 531.2f, 313.4f, 518.7f)
                curveTo(300.9f, 506.2f, 300.9f, 485.9f, 313.4f, 473.4f)
                lineTo(338.7f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(174.3f, 448.0f, 160.0f, 462.3f, 160.0f, 480.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 145.7f, 544.0f, 128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 427.0f, 139.0f, 384.0f, 192.0f, 384.0f)
                lineTo(338.7f, 384.0f)
                lineTo(313.3f, 358.6f)
                curveTo(300.8f, 346.1f, 300.8f, 325.8f, 313.3f, 313.3f)
                close()
            }
        }
        .build()
        return `_arrows-turn-right`!!
    }

private var `_arrows-turn-right`: ImageVector? = null
