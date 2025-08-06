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

public val Fa.S: ImageVector
    get() {
        if (_s != null) {
            return _s!!
        }
        _s = Builder(name = "S", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 221.5f)
                curveTo(160.0f, 152.2f, 216.2f, 96.0f, 285.5f, 96.0f)
                lineTo(432.0f, 96.0f)
                curveTo(449.7f, 96.0f, 464.0f, 110.3f, 464.0f, 128.0f)
                curveTo(464.0f, 145.7f, 449.7f, 160.0f, 432.0f, 160.0f)
                lineTo(285.5f, 160.0f)
                curveTo(251.5f, 160.0f, 224.0f, 187.5f, 224.0f, 221.5f)
                curveTo(224.0f, 252.5f, 247.1f, 278.7f, 277.9f, 282.5f)
                lineTo(370.1f, 294.0f)
                curveTo(432.9f, 301.9f, 480.0f, 355.2f, 480.0f, 418.5f)
                curveTo(480.0f, 487.8f, 423.8f, 544.0f, 354.5f, 544.0f)
                lineTo(208.0f, 544.0f)
                curveTo(190.3f, 544.0f, 176.0f, 529.7f, 176.0f, 512.0f)
                curveTo(176.0f, 494.3f, 190.3f, 480.0f, 208.0f, 480.0f)
                lineTo(354.5f, 480.0f)
                curveTo(388.5f, 480.0f, 416.0f, 452.5f, 416.0f, 418.5f)
                curveTo(416.0f, 387.5f, 392.9f, 361.3f, 362.1f, 357.5f)
                lineTo(269.9f, 346.0f)
                curveTo(207.1f, 338.1f, 160.0f, 284.8f, 160.0f, 221.5f)
                close()
            }
        }
        .build()
        return _s!!
    }

private var _s: ImageVector? = null
