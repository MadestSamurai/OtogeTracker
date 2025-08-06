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

public val Fa.`Traffic-light`: ImageVector
    get() {
        if (`_traffic-light` != null) {
            return `_traffic-light`!!
        }
        `_traffic-light` = Builder(name = "Traffic-light", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 32.0f)
                curveTo(188.7f, 32.0f, 160.0f, 60.7f, 160.0f, 96.0f)
                lineTo(160.0f, 448.0f)
                curveTo(160.0f, 536.4f, 231.6f, 608.0f, 320.0f, 608.0f)
                curveTo(408.4f, 608.0f, 480.0f, 536.4f, 480.0f, 448.0f)
                lineTo(480.0f, 96.0f)
                curveTo(480.0f, 60.7f, 451.3f, 32.0f, 416.0f, 32.0f)
                lineTo(224.0f, 32.0f)
                close()
                moveTo(320.0f, 424.0f)
                curveTo(350.9f, 424.0f, 376.0f, 449.1f, 376.0f, 480.0f)
                curveTo(376.0f, 510.9f, 350.9f, 536.0f, 320.0f, 536.0f)
                curveTo(289.1f, 536.0f, 264.0f, 510.9f, 264.0f, 480.0f)
                curveTo(264.0f, 449.1f, 289.1f, 424.0f, 320.0f, 424.0f)
                close()
                moveTo(376.0f, 320.0f)
                curveTo(376.0f, 350.9f, 350.9f, 376.0f, 320.0f, 376.0f)
                curveTo(289.1f, 376.0f, 264.0f, 350.9f, 264.0f, 320.0f)
                curveTo(264.0f, 289.1f, 289.1f, 264.0f, 320.0f, 264.0f)
                curveTo(350.9f, 264.0f, 376.0f, 289.1f, 376.0f, 320.0f)
                close()
                moveTo(320.0f, 216.0f)
                curveTo(289.1f, 216.0f, 264.0f, 190.9f, 264.0f, 160.0f)
                curveTo(264.0f, 129.1f, 289.1f, 104.0f, 320.0f, 104.0f)
                curveTo(350.9f, 104.0f, 376.0f, 129.1f, 376.0f, 160.0f)
                curveTo(376.0f, 190.9f, 350.9f, 216.0f, 320.0f, 216.0f)
                close()
            }
        }
        .build()
        return `_traffic-light`!!
    }

private var `_traffic-light`: ImageVector? = null
