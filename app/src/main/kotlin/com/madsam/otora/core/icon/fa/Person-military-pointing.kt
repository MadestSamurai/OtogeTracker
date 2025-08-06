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

public val Fa.`Person-military-pointing`: ImageVector
    get() {
        if (`_person-military-pointing` != null) {
            return `_person-military-pointing`!!
        }
        `_person-military-pointing` = Builder(name = "Person-military-pointing", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(278.9f, 78.1f)
                curveTo(266.0f, 79.2f, 256.0f, 90.0f, 256.0f, 103.0f)
                curveTo(256.0f, 116.8f, 267.2f, 128.0f, 281.0f, 128.0f)
                lineTo(432.0f, 128.0f)
                curveTo(440.8f, 128.0f, 448.0f, 120.8f, 448.0f, 112.0f)
                lineTo(448.0f, 81.4f)
                curveTo(448.0f, 72.0f, 440.0f, 64.7f, 430.7f, 65.4f)
                lineTo(278.9f, 78.1f)
                close()
                moveTo(272.0f, 176.0f)
                curveTo(272.0f, 220.2f, 307.8f, 256.0f, 352.0f, 256.0f)
                curveTo(396.2f, 256.0f, 432.0f, 220.2f, 432.0f, 176.0f)
                curveTo(432.0f, 170.5f, 431.4f, 165.2f, 430.4f, 160.0f)
                lineTo(273.6f, 160.0f)
                curveTo(272.6f, 165.2f, 272.0f, 170.5f, 272.0f, 176.0f)
                close()
                moveTo(104.0f, 288.0f)
                curveTo(81.9f, 288.0f, 64.0f, 305.9f, 64.0f, 328.0f)
                curveTo(64.0f, 350.1f, 81.9f, 368.0f, 104.0f, 368.0f)
                lineTo(256.0f, 368.0f)
                lineTo(256.0f, 457.4f)
                lineTo(418.8f, 294.6f)
                curveTo(405.5f, 290.3f, 391.5f, 288.1f, 377.2f, 288.1f)
                lineTo(104.0f, 288.0f)
                close()
                moveTo(449.7f, 308.9f)
                lineTo(278.6f, 480.0f)
                lineTo(448.0f, 480.0f)
                lineTo(448.0f, 433.7f)
                lineTo(501.6f, 524.3f)
                curveTo(512.8f, 543.3f, 537.4f, 549.6f, 556.4f, 538.4f)
                curveTo(575.4f, 527.2f, 581.7f, 502.6f, 570.5f, 483.6f)
                lineTo(494.3f, 354.8f)
                curveTo(483.1f, 335.8f, 467.7f, 320.3f, 449.7f, 308.9f)
                close()
                moveTo(256.0f, 512.0f)
                lineTo(256.0f, 544.0f)
                curveTo(256.0f, 561.7f, 270.3f, 576.0f, 288.0f, 576.0f)
                lineTo(416.0f, 576.0f)
                curveTo(433.7f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(448.0f, 512.0f)
                lineTo(256.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_person-military-pointing`!!
    }

private var `_person-military-pointing`: ImageVector? = null
