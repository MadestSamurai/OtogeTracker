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

public val Fa.`Id-badge`: ImageVector
    get() {
        if (`_id-badge` != null) {
            return `_id-badge`!!
        }
        `_id-badge` = Builder(name = "Id-badge", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                close()
                moveTo(288.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                curveTo(396.2f, 416.0f, 432.0f, 451.8f, 432.0f, 496.0f)
                curveTo(432.0f, 504.8f, 424.8f, 512.0f, 416.0f, 512.0f)
                lineTo(224.0f, 512.0f)
                curveTo(215.2f, 512.0f, 208.0f, 504.8f, 208.0f, 496.0f)
                curveTo(208.0f, 451.8f, 243.8f, 416.0f, 288.0f, 416.0f)
                close()
                moveTo(264.0f, 320.0f)
                curveTo(264.0f, 289.1f, 289.1f, 264.0f, 320.0f, 264.0f)
                curveTo(350.9f, 264.0f, 376.0f, 289.1f, 376.0f, 320.0f)
                curveTo(376.0f, 350.9f, 350.9f, 376.0f, 320.0f, 376.0f)
                curveTo(289.1f, 376.0f, 264.0f, 350.9f, 264.0f, 320.0f)
                close()
                moveTo(280.0f, 128.0f)
                lineTo(360.0f, 128.0f)
                curveTo(373.3f, 128.0f, 384.0f, 138.7f, 384.0f, 152.0f)
                curveTo(384.0f, 165.3f, 373.3f, 176.0f, 360.0f, 176.0f)
                lineTo(280.0f, 176.0f)
                curveTo(266.7f, 176.0f, 256.0f, 165.3f, 256.0f, 152.0f)
                curveTo(256.0f, 138.7f, 266.7f, 128.0f, 280.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_id-badge`!!
    }

private var `_id-badge`: ImageVector? = null
