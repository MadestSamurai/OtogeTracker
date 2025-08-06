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

public val Fa.`Line-chart`: ImageVector
    get() {
        if (`_line-chart` != null) {
            return `_line-chart`!!
        }
        `_line-chart` = Builder(name = "Line-chart", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 110.3f, 113.7f, 96.0f, 96.0f, 96.0f)
                curveTo(78.3f, 96.0f, 64.0f, 110.3f, 64.0f, 128.0f)
                lineTo(64.0f, 464.0f)
                curveTo(64.0f, 508.2f, 99.8f, 544.0f, 144.0f, 544.0f)
                lineTo(544.0f, 544.0f)
                curveTo(561.7f, 544.0f, 576.0f, 529.7f, 576.0f, 512.0f)
                curveTo(576.0f, 494.3f, 561.7f, 480.0f, 544.0f, 480.0f)
                lineTo(144.0f, 480.0f)
                curveTo(135.2f, 480.0f, 128.0f, 472.8f, 128.0f, 464.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(534.6f, 214.6f)
                curveTo(547.1f, 202.1f, 547.1f, 181.8f, 534.6f, 169.3f)
                curveTo(522.1f, 156.8f, 501.8f, 156.8f, 489.3f, 169.3f)
                lineTo(384.0f, 274.7f)
                lineTo(326.6f, 217.4f)
                curveTo(314.1f, 204.9f, 293.8f, 204.9f, 281.3f, 217.4f)
                lineTo(185.3f, 313.4f)
                curveTo(172.8f, 325.9f, 172.8f, 346.2f, 185.3f, 358.7f)
                curveTo(197.8f, 371.2f, 218.1f, 371.2f, 230.6f, 358.7f)
                lineTo(304.0f, 285.3f)
                lineTo(361.4f, 342.7f)
                curveTo(373.9f, 355.2f, 394.2f, 355.2f, 406.7f, 342.7f)
                lineTo(534.7f, 214.7f)
                close()
            }
        }
        .build()
        return `_line-chart`!!
    }

private var `_line-chart`: ImageVector? = null
