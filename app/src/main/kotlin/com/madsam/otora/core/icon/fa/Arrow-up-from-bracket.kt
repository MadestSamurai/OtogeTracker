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

public val Fa.`Arrow-up-from-bracket`: ImageVector
    get() {
        if (`_arrow-up-from-bracket` != null) {
            return `_arrow-up-from-bracket`!!
        }
        `_arrow-up-from-bracket` = Builder(name = "Arrow-up-from-bracket", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 73.4f)
                curveTo(330.1f, 60.9f, 309.8f, 60.9f, 297.3f, 73.4f)
                lineTo(169.3f, 201.4f)
                curveTo(156.8f, 213.9f, 156.8f, 234.2f, 169.3f, 246.7f)
                curveTo(181.8f, 259.2f, 202.1f, 259.2f, 214.6f, 246.7f)
                lineTo(288.0f, 173.3f)
                lineTo(288.0f, 384.0f)
                curveTo(288.0f, 401.7f, 302.3f, 416.0f, 320.0f, 416.0f)
                curveTo(337.7f, 416.0f, 352.0f, 401.7f, 352.0f, 384.0f)
                lineTo(352.0f, 173.3f)
                lineTo(425.4f, 246.7f)
                curveTo(437.9f, 259.2f, 458.2f, 259.2f, 470.7f, 246.7f)
                curveTo(483.2f, 234.2f, 483.2f, 213.9f, 470.7f, 201.4f)
                lineTo(342.7f, 73.4f)
                close()
                moveTo(160.0f, 416.0f)
                curveTo(160.0f, 398.3f, 145.7f, 384.0f, 128.0f, 384.0f)
                curveTo(110.3f, 384.0f, 96.0f, 398.3f, 96.0f, 416.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 533.0f, 139.0f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(501.0f, 576.0f, 544.0f, 533.0f, 544.0f, 480.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 398.3f, 529.7f, 384.0f, 512.0f, 384.0f)
                curveTo(494.3f, 384.0f, 480.0f, 398.3f, 480.0f, 416.0f)
                lineTo(480.0f, 480.0f)
                curveTo(480.0f, 497.7f, 465.7f, 512.0f, 448.0f, 512.0f)
                lineTo(192.0f, 512.0f)
                curveTo(174.3f, 512.0f, 160.0f, 497.7f, 160.0f, 480.0f)
                lineTo(160.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_arrow-up-from-bracket`!!
    }

private var `_arrow-up-from-bracket`: ImageVector? = null
