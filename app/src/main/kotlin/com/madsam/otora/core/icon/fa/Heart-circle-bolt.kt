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

public val Fa.`Heart-circle-bolt`: ImageVector
    get() {
        if (`_heart-circle-bolt` != null) {
            return `_heart-circle-bolt`!!
        }
        `_heart-circle-bolt` = Builder(name = "Heart-circle-bolt", defaultWidth = 640.0.dp,
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
                moveTo(497.4f, 387.0f)
                curveTo(491.6f, 382.8f, 483.6f, 383.0f, 478.0f, 387.5f)
                lineTo(398.0f, 451.5f)
                curveTo(392.7f, 455.7f, 390.6f, 462.9f, 392.9f, 469.3f)
                curveTo(395.2f, 475.7f, 401.2f, 480.0f, 408.0f, 480.0f)
                lineTo(440.9f, 480.0f)
                lineTo(425.0f, 522.4f)
                curveTo(422.5f, 529.1f, 424.8f, 536.7f, 430.6f, 541.0f)
                curveTo(436.4f, 545.3f, 444.4f, 545.0f, 450.0f, 540.5f)
                lineTo(530.0f, 476.5f)
                curveTo(535.3f, 472.3f, 537.4f, 465.1f, 535.1f, 458.7f)
                curveTo(532.8f, 452.3f, 526.8f, 448.0f, 520.0f, 448.0f)
                lineTo(487.1f, 448.0f)
                lineTo(503.0f, 405.6f)
                curveTo(505.5f, 398.9f, 503.2f, 391.3f, 497.4f, 387.0f)
                close()
            }
        }
        .build()
        return `_heart-circle-bolt`!!
    }

private var `_heart-circle-bolt`: ImageVector? = null
