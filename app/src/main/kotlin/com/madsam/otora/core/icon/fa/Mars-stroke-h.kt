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

public val Fa.`Mars-stroke-h`: ImageVector
    get() {
        if (`_mars-stroke-h` != null) {
            return `_mars-stroke-h`!!
        }
        `_mars-stroke-h` = Builder(name = "Mars-stroke-h", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.5f, 320.0f)
                curveTo(320.5f, 258.1f, 270.4f, 208.0f, 208.5f, 208.0f)
                curveTo(146.6f, 208.0f, 96.5f, 258.1f, 96.5f, 320.0f)
                curveTo(96.5f, 381.9f, 146.6f, 432.0f, 208.5f, 432.0f)
                curveTo(270.4f, 432.0f, 320.5f, 381.9f, 320.5f, 320.0f)
                close()
                moveTo(208.5f, 144.0f)
                curveTo(294.8f, 144.0f, 366.6f, 206.1f, 381.6f, 288.1f)
                curveTo(382.6f, 288.0f, 383.5f, 288.0f, 384.5f, 288.0f)
                lineTo(400.5f, 288.0f)
                lineTo(400.5f, 256.0f)
                curveTo(400.5f, 238.3f, 414.8f, 224.0f, 432.5f, 224.0f)
                curveTo(450.2f, 224.0f, 464.5f, 238.3f, 464.5f, 256.0f)
                lineTo(464.5f, 288.0f)
                lineTo(525.9f, 288.0f)
                lineTo(503.5f, 260.0f)
                curveTo(492.5f, 246.2f, 494.7f, 226.1f, 508.5f, 215.0f)
                curveTo(522.3f, 203.9f, 542.4f, 206.2f, 553.5f, 220.0f)
                lineTo(617.5f, 300.0f)
                curveTo(626.8f, 311.7f, 626.8f, 328.3f, 617.5f, 340.0f)
                lineTo(553.5f, 420.0f)
                curveTo(542.5f, 433.8f, 522.3f, 436.0f, 508.5f, 425.0f)
                curveTo(494.7f, 414.0f, 492.5f, 393.8f, 503.5f, 380.0f)
                lineTo(525.9f, 352.0f)
                lineTo(464.5f, 352.0f)
                lineTo(464.5f, 384.0f)
                curveTo(464.5f, 401.7f, 450.2f, 416.0f, 432.5f, 416.0f)
                curveTo(414.8f, 416.0f, 400.5f, 401.7f, 400.5f, 384.0f)
                lineTo(400.5f, 352.0f)
                lineTo(384.5f, 352.0f)
                curveTo(383.5f, 352.0f, 382.6f, 352.0f, 381.6f, 351.9f)
                curveTo(366.6f, 433.9f, 294.8f, 496.0f, 208.5f, 496.0f)
                curveTo(111.3f, 496.0f, 32.5f, 417.2f, 32.5f, 320.0f)
                curveTo(32.5f, 222.8f, 111.3f, 144.0f, 208.5f, 144.0f)
                close()
            }
        }
        .build()
        return `_mars-stroke-h`!!
    }

private var `_mars-stroke-h`: ImageVector? = null
