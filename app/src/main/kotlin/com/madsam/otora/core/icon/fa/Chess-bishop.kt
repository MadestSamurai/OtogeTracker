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

public val Fa.`Chess-bishop`: ImageVector
    get() {
        if (`_chess-bishop` != null) {
            return `_chess-bishop`!!
        }
        `_chess-bishop` = Builder(name = "Chess-bishop", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 448.0f)
                lineTo(208.3f, 432.3f)
                curveTo(177.4f, 401.4f, 160.0f, 359.4f, 160.0f, 315.7f)
                curveTo(160.0f, 277.1f, 173.5f, 239.8f, 198.2f, 210.1f)
                lineTo(266.7f, 128.0f)
                lineTo(256.0f, 128.0f)
                curveTo(238.3f, 128.0f, 224.0f, 113.7f, 224.0f, 96.0f)
                curveTo(224.0f, 78.3f, 238.3f, 64.0f, 256.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                curveTo(401.7f, 64.0f, 416.0f, 78.3f, 416.0f, 96.0f)
                curveTo(416.0f, 113.7f, 401.7f, 128.0f, 384.0f, 128.0f)
                lineTo(373.3f, 128.0f)
                lineTo(420.9f, 185.1f)
                lineTo(335.0f, 271.0f)
                curveTo(325.6f, 280.4f, 325.6f, 295.6f, 335.0f, 304.9f)
                curveTo(344.4f, 314.2f, 359.6f, 314.3f, 368.9f, 304.9f)
                lineTo(451.2f, 222.6f)
                curveTo(469.9f, 249.9f, 479.9f, 282.3f, 479.9f, 315.6f)
                curveTo(479.9f, 359.3f, 462.5f, 401.3f, 431.6f, 432.2f)
                lineTo(416.0f, 448.0f)
                lineTo(472.2f, 518.3f)
                curveTo(477.2f, 524.6f, 480.0f, 532.4f, 480.0f, 540.5f)
                curveTo(480.0f, 560.1f, 464.1f, 576.0f, 444.5f, 576.0f)
                lineTo(195.5f, 576.0f)
                curveTo(175.9f, 576.0f, 160.0f, 560.1f, 160.0f, 540.5f)
                curveTo(160.0f, 532.4f, 162.7f, 524.6f, 167.8f, 518.3f)
                lineTo(224.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_chess-bishop`!!
    }

private var `_chess-bishop`: ImageVector? = null
