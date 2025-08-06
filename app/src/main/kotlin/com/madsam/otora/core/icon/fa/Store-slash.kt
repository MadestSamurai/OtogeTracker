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

public val Fa.`Store-slash`: ImageVector
    get() {
        if (`_store-slash` != null) {
            return `_store-slash`!!
        }
        `_store-slash` = Builder(name = "Store-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(542.3f, 508.6f)
                curveTo(543.4f, 504.6f, 543.9f, 500.4f, 543.9f, 496.1f)
                lineTo(543.9f, 344.9f)
                curveTo(531.4f, 349.5f, 517.8f, 352.1f, 503.4f, 352.1f)
                curveTo(495.3f, 352.1f, 487.5f, 351.3f, 479.9f, 349.7f)
                lineTo(479.9f, 416.1f)
                lineTo(449.7f, 416.1f)
                lineTo(312.2f, 278.6f)
                curveTo(315.1f, 275.0f, 317.7f, 271.2f, 319.8f, 267.1f)
                curveTo(331.4f, 289.1f, 354.5f, 304.1f, 381.1f, 304.1f)
                curveTo(407.9f, 304.1f, 430.9f, 289.0f, 442.5f, 267.0f)
                curveTo(453.9f, 289.1f, 477.0f, 304.1f, 503.3f, 304.1f)
                curveTo(548.9f, 304.1f, 581.7f, 260.4f, 568.9f, 216.6f)
                lineTo(545.8f, 136.3f)
                curveTo(538.8f, 112.4f, 516.9f, 96.0f, 492.0f, 96.0f)
                lineTo(148.0f, 96.0f)
                curveTo(142.5f, 96.0f, 137.2f, 96.8f, 132.1f, 98.3f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(183.5f, 285.3f)
                lineTo(80.7f, 182.6f)
                lineTo(70.9f, 216.5f)
                curveTo(58.1f, 260.2f, 90.9f, 304.0f, 136.5f, 304.0f)
                curveTo(154.6f, 304.0f, 171.2f, 296.9f, 183.5f, 285.3f)
                close()
                moveTo(442.2f, 544.0f)
                lineTo(314.2f, 416.0f)
                lineTo(160.0f, 416.0f)
                lineTo(160.0f, 349.6f)
                curveTo(152.4f, 351.2f, 144.5f, 352.0f, 136.5f, 352.0f)
                curveTo(122.1f, 352.0f, 108.5f, 349.4f, 96.0f, 344.8f)
                lineTo(96.0f, 496.0f)
                curveTo(96.0f, 522.5f, 117.5f, 544.0f, 144.0f, 544.0f)
                lineTo(442.2f, 544.0f)
                close()
            }
        }
        .build()
        return `_store-slash`!!
    }

private var `_store-slash`: ImageVector? = null
