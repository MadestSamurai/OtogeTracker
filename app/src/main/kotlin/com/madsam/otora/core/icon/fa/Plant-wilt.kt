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

public val Fa.`Plant-wilt`: ImageVector
    get() {
        if (`_plant-wilt` != null) {
            return `_plant-wilt`!!
        }
        `_plant-wilt` = Builder(name = "Plant-wilt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(408.0f, 32.0f)
                curveTo(474.3f, 32.0f, 528.0f, 85.7f, 528.0f, 152.0f)
                lineTo(528.0f, 158.2f)
                curveTo(557.3f, 170.4f, 576.0f, 199.5f, 576.0f, 235.1f)
                curveTo(576.0f, 263.0f, 550.7f, 309.9f, 510.0f, 346.8f)
                curveTo(506.2f, 350.3f, 501.2f, 352.1f, 496.0f, 352.1f)
                curveTo(490.8f, 352.1f, 485.8f, 350.3f, 482.0f, 346.8f)
                curveTo(441.3f, 310.0f, 416.0f, 263.1f, 416.0f, 235.1f)
                curveTo(416.0f, 199.5f, 434.7f, 170.4f, 464.0f, 158.2f)
                lineTo(464.0f, 152.0f)
                curveTo(464.0f, 121.1f, 438.9f, 96.0f, 408.0f, 96.0f)
                curveTo(377.1f, 96.0f, 352.0f, 121.1f, 352.0f, 152.0f)
                lineTo(352.0f, 576.0f)
                curveTo(352.0f, 593.7f, 337.7f, 608.0f, 320.0f, 608.0f)
                curveTo(302.3f, 608.0f, 288.0f, 593.7f, 288.0f, 576.0f)
                lineTo(288.0f, 280.0f)
                curveTo(288.0f, 249.1f, 262.9f, 224.0f, 232.0f, 224.0f)
                curveTo(201.1f, 224.0f, 176.0f, 249.1f, 176.0f, 280.0f)
                lineTo(176.0f, 318.2f)
                curveTo(205.3f, 330.4f, 224.0f, 359.5f, 224.0f, 395.1f)
                curveTo(224.0f, 423.0f, 198.7f, 469.9f, 158.0f, 506.8f)
                curveTo(154.2f, 510.3f, 149.2f, 512.1f, 144.0f, 512.1f)
                curveTo(138.8f, 512.1f, 133.8f, 510.3f, 130.0f, 506.8f)
                curveTo(89.3f, 469.9f, 64.0f, 423.0f, 64.0f, 395.1f)
                curveTo(64.0f, 359.4f, 82.7f, 330.4f, 112.0f, 318.2f)
                lineTo(112.0f, 280.0f)
                curveTo(112.0f, 213.7f, 165.7f, 160.0f, 232.0f, 160.0f)
                curveTo(252.2f, 160.0f, 271.3f, 165.0f, 288.0f, 173.8f)
                lineTo(288.0f, 152.0f)
                curveTo(288.0f, 85.7f, 341.7f, 32.0f, 408.0f, 32.0f)
                close()
            }
        }
        .build()
        return `_plant-wilt`!!
    }

private var `_plant-wilt`: ImageVector? = null
