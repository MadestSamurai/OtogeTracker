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

public val Fa.Couch: ImageVector
    get() {
        if (_couch != null) {
            return _couch!!
        }
        _couch = Builder(name = "Couch", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 336.0f)
                curveTo(144.0f, 288.7f, 109.8f, 249.4f, 64.8f, 241.5f)
                curveTo(72.0f, 177.6f, 126.2f, 128.0f, 192.0f, 128.0f)
                lineTo(448.0f, 128.0f)
                curveTo(513.8f, 128.0f, 568.0f, 177.6f, 575.2f, 241.5f)
                curveTo(530.2f, 249.5f, 496.0f, 288.7f, 496.0f, 336.0f)
                lineTo(496.0f, 368.0f)
                lineTo(144.0f, 368.0f)
                lineTo(144.0f, 336.0f)
                close()
                moveTo(0.0f, 448.0f)
                lineTo(0.0f, 336.0f)
                curveTo(0.0f, 309.5f, 21.5f, 288.0f, 48.0f, 288.0f)
                curveTo(74.5f, 288.0f, 96.0f, 309.5f, 96.0f, 336.0f)
                lineTo(96.0f, 416.0f)
                lineTo(544.0f, 416.0f)
                lineTo(544.0f, 336.0f)
                curveTo(544.0f, 309.5f, 565.5f, 288.0f, 592.0f, 288.0f)
                curveTo(618.5f, 288.0f, 640.0f, 309.5f, 640.0f, 336.0f)
                lineTo(640.0f, 448.0f)
                curveTo(640.0f, 483.3f, 611.3f, 512.0f, 576.0f, 512.0f)
                lineTo(64.0f, 512.0f)
                curveTo(28.7f, 512.0f, 0.0f, 483.3f, 0.0f, 448.0f)
                close()
            }
        }
        .build()
        return _couch!!
    }

private var _couch: ImageVector? = null
