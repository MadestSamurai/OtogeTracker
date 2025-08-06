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

public val Fa.`Vial-circle-check`: ImageVector
    get() {
        if (`_vial-circle-check` != null) {
            return `_vial-circle-check`!!
        }
        `_vial-circle-check` = Builder(name = "Vial-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(96.0f, 78.3f, 110.3f, 64.0f, 128.0f, 64.0f)
                lineTo(352.0f, 64.0f)
                curveTo(369.7f, 64.0f, 384.0f, 78.3f, 384.0f, 96.0f)
                curveTo(384.0f, 113.7f, 369.7f, 128.0f, 352.0f, 128.0f)
                lineTo(352.0f, 289.4f)
                curveTo(285.9f, 319.7f, 240.0f, 386.5f, 240.0f, 464.0f)
                curveTo(240.0f, 503.7f, 252.0f, 540.6f, 272.7f, 571.2f)
                curveTo(262.4f, 574.3f, 251.4f, 576.0f, 240.0f, 576.0f)
                curveTo(178.1f, 576.0f, 128.0f, 525.9f, 128.0f, 464.0f)
                lineTo(128.0f, 128.0f)
                curveTo(110.3f, 128.0f, 96.0f, 113.7f, 96.0f, 96.0f)
                close()
                moveTo(192.0f, 128.0f)
                lineTo(192.0f, 256.0f)
                lineTo(288.0f, 256.0f)
                lineTo(288.0f, 128.0f)
                lineTo(192.0f, 128.0f)
                close()
                moveTo(288.0f, 464.0f)
                curveTo(288.0f, 384.5f, 352.5f, 320.0f, 432.0f, 320.0f)
                curveTo(511.5f, 320.0f, 576.0f, 384.5f, 576.0f, 464.0f)
                curveTo(576.0f, 543.5f, 511.5f, 608.0f, 432.0f, 608.0f)
                curveTo(352.5f, 608.0f, 288.0f, 543.5f, 288.0f, 464.0f)
                close()
                moveTo(489.4f, 403.1f)
                curveTo(482.3f, 397.9f, 472.2f, 399.5f, 467.0f, 406.6f)
                lineTo(414.0f, 479.5f)
                lineTo(387.2f, 452.7f)
                curveTo(381.0f, 446.5f, 370.8f, 446.5f, 364.6f, 452.7f)
                curveTo(358.4f, 458.9f, 358.4f, 469.1f, 364.6f, 475.3f)
                lineTo(404.6f, 515.3f)
                curveTo(407.9f, 518.6f, 412.5f, 520.3f, 417.2f, 519.9f)
                curveTo(421.9f, 519.5f, 426.1f, 517.1f, 428.9f, 513.4f)
                lineTo(492.9f, 425.4f)
                curveTo(498.1f, 418.3f, 496.5f, 408.2f, 489.4f, 403.1f)
                close()
            }
        }
        .build()
        return `_vial-circle-check`!!
    }

private var `_vial-circle-check`: ImageVector? = null
