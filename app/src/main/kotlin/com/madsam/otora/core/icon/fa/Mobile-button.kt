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

public val Fa.`Mobile-button`: ImageVector
    get() {
        if (`_mobile-button` != null) {
            return `_mobile-button`!!
        }
        `_mobile-button` = Builder(name = "Mobile-button", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 64.0f)
                curveTo(172.7f, 64.0f, 144.0f, 92.7f, 144.0f, 128.0f)
                lineTo(144.0f, 512.0f)
                curveTo(144.0f, 547.3f, 172.7f, 576.0f, 208.0f, 576.0f)
                lineTo(432.0f, 576.0f)
                curveTo(467.3f, 576.0f, 496.0f, 547.3f, 496.0f, 512.0f)
                lineTo(496.0f, 128.0f)
                curveTo(496.0f, 92.7f, 467.3f, 64.0f, 432.0f, 64.0f)
                lineTo(208.0f, 64.0f)
                close()
                moveTo(320.0f, 528.0f)
                curveTo(302.3f, 528.0f, 288.0f, 513.7f, 288.0f, 496.0f)
                curveTo(288.0f, 478.3f, 302.3f, 464.0f, 320.0f, 464.0f)
                curveTo(337.7f, 464.0f, 352.0f, 478.3f, 352.0f, 496.0f)
                curveTo(352.0f, 513.7f, 337.7f, 528.0f, 320.0f, 528.0f)
                close()
            }
        }
        .build()
        return `_mobile-button`!!
    }

private var `_mobile-button`: ImageVector? = null
