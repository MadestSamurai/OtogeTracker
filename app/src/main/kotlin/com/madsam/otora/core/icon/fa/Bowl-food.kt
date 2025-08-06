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

public val Fa.`Bowl-food`: ImageVector
    get() {
        if (`_bowl-food` != null) {
            return `_bowl-food`!!
        }
        `_bowl-food` = Builder(name = "Bowl-food", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 240.0f)
                curveTo(64.0f, 204.7f, 92.7f, 176.0f, 128.0f, 176.0f)
                curveTo(128.5f, 176.0f, 129.1f, 176.0f, 129.6f, 176.0f)
                curveTo(137.0f, 139.5f, 169.3f, 112.0f, 208.0f, 112.0f)
                curveTo(223.0f, 112.0f, 237.0f, 116.1f, 248.9f, 123.2f)
                curveTo(262.2f, 97.5f, 289.0f, 80.0f, 320.0f, 80.0f)
                curveTo(351.0f, 80.0f, 377.8f, 97.6f, 391.1f, 123.2f)
                curveTo(403.1f, 116.1f, 417.1f, 112.0f, 432.0f, 112.0f)
                curveTo(470.7f, 112.0f, 503.0f, 139.5f, 510.4f, 176.0f)
                curveTo(510.9f, 176.0f, 511.5f, 176.0f, 512.0f, 176.0f)
                curveTo(547.3f, 176.0f, 576.0f, 204.7f, 576.0f, 240.0f)
                curveTo(576.0f, 251.7f, 572.9f, 262.6f, 567.4f, 272.0f)
                lineTo(72.6f, 272.0f)
                curveTo(67.1f, 262.6f, 64.0f, 251.7f, 64.0f, 240.0f)
                close()
                moveTo(64.0f, 347.4f)
                curveTo(64.0f, 332.3f, 76.3f, 320.0f, 91.4f, 320.0f)
                lineTo(548.5f, 320.0f)
                curveTo(563.6f, 320.0f, 575.9f, 332.3f, 575.9f, 347.4f)
                curveTo(575.9f, 417.9f, 531.5f, 478.1f, 469.2f, 501.5f)
                lineTo(467.5f, 516.0f)
                curveTo(465.5f, 532.0f, 451.9f, 544.0f, 435.7f, 544.0f)
                lineTo(204.2f, 544.0f)
                curveTo(188.1f, 544.0f, 174.4f, 532.0f, 172.4f, 516.0f)
                lineTo(170.6f, 501.6f)
                curveTo(108.4f, 478.1f, 64.0f, 417.9f, 64.0f, 347.4f)
                close()
            }
        }
        .build()
        return `_bowl-food`!!
    }

private var `_bowl-food`: ImageVector? = null
