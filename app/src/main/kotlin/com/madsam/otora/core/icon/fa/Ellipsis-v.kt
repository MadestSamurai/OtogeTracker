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

public val Fa.`Ellipsis-v`: ImageVector
    get() {
        if (`_ellipsis-v` != null) {
            return `_ellipsis-v`!!
        }
        `_ellipsis-v` = Builder(name = "Ellipsis-v", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 208.0f)
                curveTo(289.1f, 208.0f, 264.0f, 182.9f, 264.0f, 152.0f)
                curveTo(264.0f, 121.1f, 289.1f, 96.0f, 320.0f, 96.0f)
                curveTo(350.9f, 96.0f, 376.0f, 121.1f, 376.0f, 152.0f)
                curveTo(376.0f, 182.9f, 350.9f, 208.0f, 320.0f, 208.0f)
                close()
                moveTo(320.0f, 432.0f)
                curveTo(350.9f, 432.0f, 376.0f, 457.1f, 376.0f, 488.0f)
                curveTo(376.0f, 518.9f, 350.9f, 544.0f, 320.0f, 544.0f)
                curveTo(289.1f, 544.0f, 264.0f, 518.9f, 264.0f, 488.0f)
                curveTo(264.0f, 457.1f, 289.1f, 432.0f, 320.0f, 432.0f)
                close()
                moveTo(376.0f, 320.0f)
                curveTo(376.0f, 350.9f, 350.9f, 376.0f, 320.0f, 376.0f)
                curveTo(289.1f, 376.0f, 264.0f, 350.9f, 264.0f, 320.0f)
                curveTo(264.0f, 289.1f, 289.1f, 264.0f, 320.0f, 264.0f)
                curveTo(350.9f, 264.0f, 376.0f, 289.1f, 376.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_ellipsis-v`!!
    }

private var `_ellipsis-v`: ImageVector? = null
