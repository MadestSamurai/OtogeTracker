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

public val Fa.`Heart-circle-check`: ImageVector
    get() {
        if (`_heart-circle-check` != null) {
            return `_heart-circle-check`!!
        }
        `_heart-circle-check` = Builder(name = "Heart-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(273.0f, 151.1f)
                lineTo(288.0f, 171.8f)
                lineTo(303.0f, 151.1f)
                curveTo(328.0f, 116.5f, 368.2f, 96.0f, 410.9f, 96.0f)
                curveTo(484.4f, 96.0f, 544.0f, 155.6f, 544.0f, 229.1f)
                lineTo(544.0f, 231.7f)
                curveTo(544.0f, 249.3f, 540.6f, 267.3f, 534.5f, 285.4f)
                curveTo(512.7f, 276.8f, 488.9f, 272.0f, 464.0f, 272.0f)
                curveTo(358.0f, 272.0f, 272.0f, 358.0f, 272.0f, 464.0f)
                curveTo(272.0f, 492.5f, 278.2f, 519.6f, 289.4f, 544.0f)
                curveTo(288.9f, 544.0f, 288.5f, 544.0f, 288.0f, 544.0f)
                curveTo(272.5f, 544.0f, 257.2f, 539.4f, 244.9f, 529.9f)
                curveTo(171.9f, 474.2f, 32.0f, 343.9f, 32.0f, 231.7f)
                lineTo(32.0f, 229.1f)
                curveTo(32.0f, 155.6f, 91.6f, 96.0f, 165.1f, 96.0f)
                curveTo(207.8f, 96.0f, 248.0f, 116.5f, 273.0f, 151.1f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(320.0f, 384.5f, 384.5f, 320.0f, 464.0f, 320.0f)
                curveTo(543.5f, 320.0f, 608.0f, 384.5f, 608.0f, 464.0f)
                curveTo(608.0f, 543.5f, 543.5f, 608.0f, 464.0f, 608.0f)
                curveTo(384.5f, 608.0f, 320.0f, 543.5f, 320.0f, 464.0f)
                close()
                moveTo(521.4f, 403.1f)
                curveTo(514.3f, 397.9f, 504.2f, 399.5f, 499.0f, 406.6f)
                lineTo(446.0f, 479.5f)
                lineTo(419.2f, 452.7f)
                curveTo(413.0f, 446.5f, 402.8f, 446.5f, 396.6f, 452.7f)
                curveTo(390.4f, 458.9f, 390.4f, 469.1f, 396.6f, 475.3f)
                lineTo(436.6f, 515.3f)
                curveTo(439.9f, 518.6f, 444.5f, 520.3f, 449.2f, 519.9f)
                curveTo(453.9f, 519.5f, 458.1f, 517.1f, 460.9f, 513.4f)
                lineTo(524.9f, 425.4f)
                curveTo(530.1f, 418.3f, 528.5f, 408.2f, 521.4f, 403.1f)
                close()
            }
        }
        .build()
        return `_heart-circle-check`!!
    }

private var `_heart-circle-check`: ImageVector? = null
