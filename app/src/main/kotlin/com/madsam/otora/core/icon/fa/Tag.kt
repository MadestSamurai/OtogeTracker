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

public val Fa.Tag: ImageVector
    get() {
        if (_tag != null) {
            return _tag!!
        }
        _tag = Builder(name = "Tag", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.5f, 160.0f)
                lineTo(96.5f, 309.5f)
                curveTo(96.5f, 326.5f, 103.2f, 342.8f, 115.2f, 354.8f)
                lineTo(307.2f, 546.8f)
                curveTo(332.2f, 571.8f, 372.7f, 571.8f, 397.7f, 546.8f)
                lineTo(547.2f, 397.3f)
                curveTo(572.2f, 372.3f, 572.2f, 331.8f, 547.2f, 306.8f)
                lineTo(355.2f, 114.8f)
                curveTo(343.2f, 102.7f, 327.0f, 96.0f, 310.0f, 96.0f)
                lineTo(160.5f, 96.0f)
                curveTo(125.2f, 96.0f, 96.5f, 124.7f, 96.5f, 160.0f)
                close()
                moveTo(208.5f, 176.0f)
                curveTo(226.2f, 176.0f, 240.5f, 190.3f, 240.5f, 208.0f)
                curveTo(240.5f, 225.7f, 226.2f, 240.0f, 208.5f, 240.0f)
                curveTo(190.8f, 240.0f, 176.5f, 225.7f, 176.5f, 208.0f)
                curveTo(176.5f, 190.3f, 190.8f, 176.0f, 208.5f, 176.0f)
                close()
            }
        }
        .build()
        return _tag!!
    }

private var _tag: ImageVector? = null
