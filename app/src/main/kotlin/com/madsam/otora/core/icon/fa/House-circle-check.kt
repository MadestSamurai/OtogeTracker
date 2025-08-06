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

public val Fa.`House-circle-check`: ImageVector
    get() {
        if (`_house-circle-check` != null) {
            return `_house-circle-check`!!
        }
        `_house-circle-check` = Builder(name = "House-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(496.0f, 608.0f)
                curveTo(416.5f, 608.0f, 352.0f, 543.5f, 352.0f, 464.0f)
                curveTo(352.0f, 384.5f, 416.5f, 320.0f, 496.0f, 320.0f)
                curveTo(575.5f, 320.0f, 640.0f, 384.5f, 640.0f, 464.0f)
                curveTo(640.0f, 543.5f, 575.5f, 608.0f, 496.0f, 608.0f)
                close()
                moveTo(268.6f, 70.5f)
                curveTo(280.8f, 61.2f, 298.3f, 61.8f, 309.8f, 72.5f)
                lineTo(527.4f, 274.5f)
                curveTo(517.2f, 272.8f, 506.7f, 271.9f, 496.1f, 271.9f)
                curveTo(417.5f, 271.9f, 350.0f, 319.1f, 320.3f, 386.7f)
                curveTo(315.2f, 384.9f, 309.8f, 383.9f, 304.1f, 383.9f)
                lineTo(272.1f, 383.9f)
                curveTo(245.6f, 383.9f, 224.1f, 405.4f, 224.1f, 431.9f)
                lineTo(224.1f, 527.9f)
                lineTo(315.1f, 527.9f)
                curveTo(321.2f, 545.2f, 329.7f, 561.3f, 340.2f, 575.9f)
                lineTo(144.0f, 576.0f)
                curveTo(108.7f, 576.0f, 80.0f, 547.3f, 80.0f, 512.0f)
                lineTo(80.0f, 336.0f)
                lineTo(64.0f, 336.0f)
                curveTo(50.8f, 336.0f, 39.0f, 327.9f, 34.2f, 315.7f)
                curveTo(29.4f, 303.5f, 32.6f, 289.5f, 42.2f, 280.6f)
                lineTo(266.2f, 72.6f)
                lineTo(268.6f, 70.6f)
                close()
                moveTo(553.4f, 403.1f)
                curveTo(546.3f, 397.9f, 536.3f, 399.5f, 531.1f, 406.6f)
                lineTo(478.1f, 479.4f)
                lineTo(451.4f, 452.6f)
                curveTo(445.2f, 446.4f, 435.0f, 446.4f, 428.8f, 452.6f)
                curveTo(422.6f, 458.8f, 422.6f, 469.0f, 428.8f, 475.2f)
                lineTo(468.8f, 515.2f)
                curveTo(472.1f, 518.5f, 476.7f, 520.2f, 481.4f, 519.9f)
                curveTo(486.1f, 519.6f, 490.3f, 517.1f, 493.1f, 513.3f)
                lineTo(557.1f, 425.3f)
                curveTo(562.3f, 418.2f, 560.7f, 408.2f, 553.6f, 403.0f)
                close()
            }
        }
        .build()
        return `_house-circle-check`!!
    }

private var `_house-circle-check`: ImageVector? = null
