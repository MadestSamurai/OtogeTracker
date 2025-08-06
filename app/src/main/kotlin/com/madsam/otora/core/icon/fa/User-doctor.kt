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

public val Fa.`User-doctor`: ImageVector
    get() {
        if (`_user-doctor` != null) {
            return `_user-doctor`!!
        }
        `_user-doctor` = Builder(name = "User-doctor", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 72.0f)
                curveTo(253.7f, 72.0f, 200.0f, 125.7f, 200.0f, 192.0f)
                curveTo(200.0f, 258.3f, 253.7f, 312.0f, 320.0f, 312.0f)
                curveTo(386.3f, 312.0f, 440.0f, 258.3f, 440.0f, 192.0f)
                curveTo(440.0f, 125.7f, 386.3f, 72.0f, 320.0f, 72.0f)
                close()
                moveTo(380.0f, 384.8f)
                curveTo(374.6f, 384.3f, 369.0f, 384.0f, 363.4f, 384.0f)
                lineTo(276.5f, 384.0f)
                curveTo(270.9f, 384.0f, 265.4f, 384.3f, 259.9f, 384.8f)
                lineTo(259.9f, 452.3f)
                curveTo(276.4f, 459.9f, 287.9f, 476.6f, 287.9f, 495.9f)
                curveTo(287.9f, 522.4f, 266.4f, 543.9f, 239.9f, 543.9f)
                curveTo(213.4f, 543.9f, 191.9f, 522.4f, 191.9f, 495.9f)
                curveTo(191.9f, 476.5f, 203.4f, 459.8f, 219.9f, 452.3f)
                lineTo(219.9f, 393.9f)
                curveTo(157.0f, 417.0f, 112.0f, 477.6f, 112.0f, 548.6f)
                curveTo(112.0f, 563.7f, 124.3f, 576.0f, 139.4f, 576.0f)
                lineTo(500.5f, 576.0f)
                curveTo(515.6f, 576.0f, 527.9f, 563.7f, 527.9f, 548.6f)
                curveTo(527.9f, 477.6f, 482.9f, 417.1f, 419.9f, 394.0f)
                lineTo(419.9f, 431.4f)
                curveTo(443.2f, 439.6f, 459.9f, 461.9f, 459.9f, 488.0f)
                lineTo(459.9f, 520.0f)
                curveTo(459.9f, 531.0f, 450.9f, 540.0f, 439.9f, 540.0f)
                curveTo(428.9f, 540.0f, 419.9f, 531.0f, 419.9f, 520.0f)
                lineTo(419.9f, 488.0f)
                curveTo(419.9f, 477.0f, 410.9f, 468.0f, 399.9f, 468.0f)
                curveTo(388.9f, 468.0f, 379.9f, 477.0f, 379.9f, 488.0f)
                lineTo(379.9f, 520.0f)
                curveTo(379.9f, 531.0f, 370.9f, 540.0f, 359.9f, 540.0f)
                curveTo(348.9f, 540.0f, 339.9f, 531.0f, 339.9f, 520.0f)
                lineTo(339.9f, 488.0f)
                curveTo(339.9f, 461.9f, 356.6f, 439.7f, 379.9f, 431.4f)
                lineTo(379.9f, 384.8f)
                close()
            }
        }
        .build()
        return `_user-doctor`!!
    }

private var `_user-doctor`: ImageVector? = null
