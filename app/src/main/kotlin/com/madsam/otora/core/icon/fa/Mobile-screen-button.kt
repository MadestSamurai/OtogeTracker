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

public val Fa.`Mobile-screen-button`: ImageVector
    get() {
        if (`_mobile-screen-button` != null) {
            return `_mobile-screen-button`!!
        }
        `_mobile-screen-button` = Builder(name = "Mobile-screen-button", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 128.0f)
                curveTo(144.0f, 92.7f, 172.7f, 64.0f, 208.0f, 64.0f)
                lineTo(432.0f, 64.0f)
                curveTo(467.3f, 64.0f, 496.0f, 92.7f, 496.0f, 128.0f)
                lineTo(496.0f, 512.0f)
                curveTo(496.0f, 547.3f, 467.3f, 576.0f, 432.0f, 576.0f)
                lineTo(208.0f, 576.0f)
                curveTo(172.7f, 576.0f, 144.0f, 547.3f, 144.0f, 512.0f)
                lineTo(144.0f, 128.0f)
                close()
                moveTo(208.0f, 128.0f)
                lineTo(208.0f, 432.0f)
                lineTo(432.0f, 432.0f)
                lineTo(432.0f, 128.0f)
                lineTo(208.0f, 128.0f)
                close()
                moveTo(320.0f, 536.0f)
                curveTo(337.7f, 536.0f, 352.0f, 521.7f, 352.0f, 504.0f)
                curveTo(352.0f, 486.3f, 337.7f, 472.0f, 320.0f, 472.0f)
                curveTo(302.3f, 472.0f, 288.0f, 486.3f, 288.0f, 504.0f)
                curveTo(288.0f, 521.7f, 302.3f, 536.0f, 320.0f, 536.0f)
                close()
            }
        }
        .build()
        return `_mobile-screen-button`!!
    }

private var `_mobile-screen-button`: ImageVector? = null
