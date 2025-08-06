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

public val Fa.Clapperboard: ImageVector
    get() {
        if (_clapperboard != null) {
            return _clapperboard!!
        }
        _clapperboard = Builder(name = "Clapperboard", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 128.0f)
                curveTo(514.0f, 128.0f, 515.9f, 128.1f, 517.8f, 128.3f)
                lineTo(422.1f, 224.0f)
                lineTo(490.0f, 224.0f)
                lineTo(562.0f, 152.0f)
                curveTo(570.8f, 163.0f, 576.0f, 176.9f, 576.0f, 192.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(198.1f, 128.0f)
                lineTo(102.1f, 224.0f)
                lineTo(170.0f, 224.0f)
                lineTo(265.0f, 129.0f)
                lineTo(266.0f, 128.0f)
                lineTo(358.1f, 128.0f)
                lineTo(262.1f, 224.0f)
                lineTo(330.0f, 224.0f)
                lineTo(425.0f, 129.0f)
                lineTo(426.0f, 128.0f)
                lineTo(512.1f, 128.0f)
                close()
            }
        }
        .build()
        return _clapperboard!!
    }

private var _clapperboard: ImageVector? = null
