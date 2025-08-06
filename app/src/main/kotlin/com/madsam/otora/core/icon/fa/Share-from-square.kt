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

public val Fa.`Share-from-square`: ImageVector
    get() {
        if (`_share-from-square` != null) {
            return `_share-from-square`!!
        }
        `_share-from-square` = Builder(name = "Share-from-square", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.5f, 88.0f)
                lineTo(416.5f, 160.0f)
                lineTo(352.5f, 160.0f)
                curveTo(273.0f, 160.0f, 208.5f, 224.5f, 208.5f, 304.0f)
                curveTo(208.5f, 397.4f, 291.3f, 438.8f, 309.1f, 446.6f)
                curveTo(311.3f, 447.6f, 313.7f, 448.0f, 316.2f, 448.0f)
                lineTo(318.7f, 448.0f)
                curveTo(328.5f, 448.0f, 336.5f, 440.0f, 336.5f, 430.2f)
                curveTo(336.5f, 421.9f, 330.6f, 414.7f, 323.7f, 409.9f)
                curveTo(314.8f, 403.7f, 304.5f, 391.7f, 304.5f, 369.4f)
                curveTo(304.5f, 324.4f, 341.0f, 287.9f, 386.0f, 287.9f)
                lineTo(416.5f, 287.9f)
                lineTo(416.5f, 359.9f)
                curveTo(416.5f, 369.6f, 422.3f, 378.4f, 431.3f, 382.1f)
                curveTo(440.3f, 385.8f, 450.6f, 383.8f, 457.5f, 376.9f)
                lineTo(593.5f, 240.9f)
                curveTo(602.9f, 231.5f, 602.9f, 216.3f, 593.5f, 207.0f)
                lineTo(457.5f, 71.0f)
                curveTo(450.6f, 64.1f, 440.3f, 62.1f, 431.3f, 65.8f)
                curveTo(422.3f, 69.5f, 416.5f, 78.3f, 416.5f, 88.0f)
                close()
                moveTo(144.5f, 160.0f)
                curveTo(100.3f, 160.0f, 64.5f, 195.8f, 64.5f, 240.0f)
                lineTo(64.5f, 496.0f)
                curveTo(64.5f, 540.2f, 100.3f, 576.0f, 144.5f, 576.0f)
                lineTo(400.5f, 576.0f)
                curveTo(444.7f, 576.0f, 480.5f, 540.2f, 480.5f, 496.0f)
                lineTo(480.5f, 464.0f)
                curveTo(480.5f, 446.3f, 466.2f, 432.0f, 448.5f, 432.0f)
                curveTo(430.8f, 432.0f, 416.5f, 446.3f, 416.5f, 464.0f)
                lineTo(416.5f, 496.0f)
                curveTo(416.5f, 504.8f, 409.3f, 512.0f, 400.5f, 512.0f)
                lineTo(144.5f, 512.0f)
                curveTo(135.7f, 512.0f, 128.5f, 504.8f, 128.5f, 496.0f)
                lineTo(128.5f, 240.0f)
                curveTo(128.5f, 231.2f, 135.7f, 224.0f, 144.5f, 224.0f)
                lineTo(160.5f, 224.0f)
                curveTo(178.2f, 224.0f, 192.5f, 209.7f, 192.5f, 192.0f)
                curveTo(192.5f, 174.3f, 178.2f, 160.0f, 160.5f, 160.0f)
                lineTo(144.5f, 160.0f)
                close()
            }
        }
        .build()
        return `_share-from-square`!!
    }

private var `_share-from-square`: ImageVector? = null
