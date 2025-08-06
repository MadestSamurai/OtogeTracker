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

public val Fa.`Heart-circle-exclamation`: ImageVector
    get() {
        if (`_heart-circle-exclamation` != null) {
            return `_heart-circle-exclamation`!!
        }
        `_heart-circle-exclamation` = Builder(name = "Heart-circle-exclamation", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
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
                moveTo(464.0f, 320.0f)
                curveTo(543.5f, 320.0f, 608.0f, 384.5f, 608.0f, 464.0f)
                curveTo(608.0f, 543.5f, 543.5f, 608.0f, 464.0f, 608.0f)
                curveTo(384.5f, 608.0f, 320.0f, 543.5f, 320.0f, 464.0f)
                curveTo(320.0f, 384.5f, 384.5f, 320.0f, 464.0f, 320.0f)
                close()
                moveTo(464.0f, 548.0f)
                curveTo(475.0f, 548.0f, 484.0f, 539.0f, 484.0f, 528.0f)
                curveTo(484.0f, 517.0f, 475.0f, 508.0f, 464.0f, 508.0f)
                curveTo(453.0f, 508.0f, 444.0f, 517.0f, 444.0f, 528.0f)
                curveTo(444.0f, 539.0f, 453.0f, 548.0f, 464.0f, 548.0f)
                close()
                moveTo(464.0f, 368.0f)
                curveTo(455.2f, 368.0f, 448.0f, 375.2f, 448.0f, 384.0f)
                lineTo(448.0f, 464.0f)
                curveTo(448.0f, 472.8f, 455.2f, 480.0f, 464.0f, 480.0f)
                curveTo(472.8f, 480.0f, 480.0f, 472.8f, 480.0f, 464.0f)
                lineTo(480.0f, 384.0f)
                curveTo(480.0f, 375.2f, 472.8f, 368.0f, 464.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_heart-circle-exclamation`!!
    }

private var `_heart-circle-exclamation`: ImageVector? = null
