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

public val Fa.`Ellipsis-h`: ImageVector
    get() {
        if (`_ellipsis-h` != null) {
            return `_ellipsis-h`!!
        }
        `_ellipsis-h` = Builder(name = "Ellipsis-h", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 320.0f)
                curveTo(96.0f, 289.1f, 121.1f, 264.0f, 152.0f, 264.0f)
                curveTo(182.9f, 264.0f, 208.0f, 289.1f, 208.0f, 320.0f)
                curveTo(208.0f, 350.9f, 182.9f, 376.0f, 152.0f, 376.0f)
                curveTo(121.1f, 376.0f, 96.0f, 350.9f, 96.0f, 320.0f)
                close()
                moveTo(264.0f, 320.0f)
                curveTo(264.0f, 289.1f, 289.1f, 264.0f, 320.0f, 264.0f)
                curveTo(350.9f, 264.0f, 376.0f, 289.1f, 376.0f, 320.0f)
                curveTo(376.0f, 350.9f, 350.9f, 376.0f, 320.0f, 376.0f)
                curveTo(289.1f, 376.0f, 264.0f, 350.9f, 264.0f, 320.0f)
                close()
                moveTo(488.0f, 264.0f)
                curveTo(518.9f, 264.0f, 544.0f, 289.1f, 544.0f, 320.0f)
                curveTo(544.0f, 350.9f, 518.9f, 376.0f, 488.0f, 376.0f)
                curveTo(457.1f, 376.0f, 432.0f, 350.9f, 432.0f, 320.0f)
                curveTo(432.0f, 289.1f, 457.1f, 264.0f, 488.0f, 264.0f)
                close()
            }
        }
        .build()
        return `_ellipsis-h`!!
    }

private var `_ellipsis-h`: ImageVector? = null
