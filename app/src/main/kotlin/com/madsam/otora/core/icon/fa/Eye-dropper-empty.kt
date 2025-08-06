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

public val Fa.`Eye-dropper-empty`: ImageVector
    get() {
        if (`_eye-dropper-empty` != null) {
            return `_eye-dropper-empty`!!
        }
        `_eye-dropper-empty` = Builder(name = "Eye-dropper-empty", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(405.6f, 93.2f)
                lineTo(304.0f, 194.8f)
                lineTo(294.6f, 185.4f)
                curveTo(282.1f, 172.9f, 261.8f, 172.9f, 249.3f, 185.4f)
                curveTo(236.8f, 197.9f, 236.8f, 218.2f, 249.3f, 230.7f)
                lineTo(409.3f, 390.7f)
                curveTo(421.8f, 403.2f, 442.1f, 403.2f, 454.6f, 390.7f)
                curveTo(467.1f, 378.2f, 467.1f, 357.9f, 454.6f, 345.4f)
                lineTo(445.2f, 336.0f)
                lineTo(546.8f, 234.4f)
                curveTo(585.8f, 195.4f, 585.8f, 132.2f, 546.8f, 93.3f)
                curveTo(507.8f, 54.4f, 444.6f, 54.3f, 405.7f, 93.3f)
                close()
                moveTo(119.4f, 387.3f)
                curveTo(104.4f, 402.3f, 96.0f, 422.7f, 96.0f, 443.9f)
                lineTo(96.0f, 486.3f)
                lineTo(69.4f, 526.2f)
                curveTo(60.9f, 538.9f, 62.6f, 555.8f, 73.4f, 566.6f)
                curveTo(84.2f, 577.4f, 101.1f, 579.1f, 113.8f, 570.6f)
                lineTo(153.7f, 544.0f)
                lineTo(196.1f, 544.0f)
                curveTo(217.3f, 544.0f, 237.7f, 535.6f, 252.7f, 520.6f)
                lineTo(362.1f, 411.2f)
                lineTo(316.8f, 365.9f)
                lineTo(207.4f, 475.3f)
                curveTo(204.4f, 478.3f, 200.3f, 480.0f, 196.1f, 480.0f)
                lineTo(160.0f, 480.0f)
                lineTo(160.0f, 443.9f)
                curveTo(160.0f, 439.7f, 161.7f, 435.6f, 164.7f, 432.6f)
                lineTo(274.1f, 323.2f)
                lineTo(228.8f, 277.9f)
                lineTo(119.4f, 387.3f)
                close()
            }
        }
        .build()
        return `_eye-dropper-empty`!!
    }

private var `_eye-dropper-empty`: ImageVector? = null
