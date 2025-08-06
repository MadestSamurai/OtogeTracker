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

public val Fa.`Share-alt`: ImageVector
    get() {
        if (`_share-alt` != null) {
            return `_share-alt`!!
        }
        `_share-alt` = Builder(name = "Share-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 256.0f)
                curveTo(501.0f, 256.0f, 544.0f, 213.0f, 544.0f, 160.0f)
                curveTo(544.0f, 107.0f, 501.0f, 64.0f, 448.0f, 64.0f)
                curveTo(395.0f, 64.0f, 352.0f, 107.0f, 352.0f, 160.0f)
                curveTo(352.0f, 165.4f, 352.5f, 170.8f, 353.3f, 176.0f)
                lineTo(223.6f, 248.1f)
                curveTo(206.7f, 233.1f, 184.4f, 224.0f, 160.0f, 224.0f)
                curveTo(107.0f, 224.0f, 64.0f, 267.0f, 64.0f, 320.0f)
                curveTo(64.0f, 373.0f, 107.0f, 416.0f, 160.0f, 416.0f)
                curveTo(184.4f, 416.0f, 206.6f, 406.9f, 223.6f, 391.9f)
                lineTo(353.3f, 464.0f)
                curveTo(352.4f, 469.2f, 352.0f, 474.5f, 352.0f, 480.0f)
                curveTo(352.0f, 533.0f, 395.0f, 576.0f, 448.0f, 576.0f)
                curveTo(501.0f, 576.0f, 544.0f, 533.0f, 544.0f, 480.0f)
                curveTo(544.0f, 427.0f, 501.0f, 384.0f, 448.0f, 384.0f)
                curveTo(423.6f, 384.0f, 401.4f, 393.1f, 384.4f, 408.1f)
                lineTo(254.7f, 336.0f)
                curveTo(255.6f, 330.8f, 256.0f, 325.5f, 256.0f, 320.0f)
                curveTo(256.0f, 314.5f, 255.5f, 309.2f, 254.7f, 304.0f)
                lineTo(384.4f, 231.9f)
                curveTo(401.3f, 246.9f, 423.6f, 256.0f, 448.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_share-alt`!!
    }

private var `_share-alt`: ImageVector? = null
