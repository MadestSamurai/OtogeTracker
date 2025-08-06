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

public val Fa.`Thumbtack-slash`: ImageVector
    get() {
        if (`_thumbtack-slash` != null) {
            return `_thumbtack-slash`!!
        }
        `_thumbtack-slash` = Builder(name = "Thumbtack-slash", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(449.8f, 416.0f)
                lineTo(480.0f, 416.0f)
                curveTo(490.0f, 416.0f, 499.5f, 411.3f, 505.5f, 403.3f)
                curveTo(511.5f, 395.3f, 513.5f, 384.9f, 510.7f, 375.2f)
                lineTo(507.0f, 361.8f)
                curveTo(494.6f, 318.5f, 466.0f, 283.3f, 428.8f, 262.1f)
                lineTo(418.5f, 128.0f)
                lineTo(448.0f, 128.0f)
                curveTo(465.7f, 128.0f, 480.0f, 113.7f, 480.0f, 96.0f)
                curveTo(480.0f, 78.3f, 465.7f, 64.0f, 448.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                curveTo(184.6f, 64.0f, 177.9f, 66.5f, 172.5f, 70.6f)
                lineTo(222.1f, 120.3f)
                lineTo(217.3f, 183.4f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(314.2f, 416.0f)
                lineTo(181.7f, 283.6f)
                curveTo(159.0f, 304.1f, 141.9f, 331.0f, 133.0f, 361.9f)
                lineTo(129.2f, 375.3f)
                curveTo(126.4f, 385.0f, 128.4f, 395.3f, 134.4f, 403.4f)
                curveTo(140.4f, 411.5f, 150.0f, 416.0f, 160.0f, 416.0f)
                lineTo(314.2f, 416.0f)
                close()
                moveTo(288.0f, 576.0f)
                curveTo(288.0f, 593.7f, 302.3f, 608.0f, 320.0f, 608.0f)
                curveTo(337.7f, 608.0f, 352.0f, 593.7f, 352.0f, 576.0f)
                lineTo(352.0f, 464.0f)
                lineTo(288.0f, 464.0f)
                lineTo(288.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_thumbtack-slash`!!
    }

private var `_thumbtack-slash`: ImageVector? = null
