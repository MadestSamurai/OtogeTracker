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

public val Fa.Sign: ImageVector
    get() {
        if (_sign != null) {
            return _sign!!
        }
        _sign = Builder(name = "Sign", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(177.7f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                lineTo(192.0f, 128.0f)
                lineTo(544.0f, 128.0f)
                curveTo(561.7f, 128.0f, 576.0f, 142.3f, 576.0f, 160.0f)
                curveTo(576.0f, 177.7f, 561.7f, 192.0f, 544.0f, 192.0f)
                lineTo(192.0f, 192.0f)
                lineTo(192.0f, 544.0f)
                curveTo(192.0f, 561.7f, 177.7f, 576.0f, 160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 192.0f)
                lineTo(96.0f, 192.0f)
                curveTo(78.3f, 192.0f, 64.0f, 177.7f, 64.0f, 160.0f)
                curveTo(64.0f, 142.3f, 78.3f, 128.0f, 96.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                lineTo(128.0f, 96.0f)
                curveTo(128.0f, 78.3f, 142.3f, 64.0f, 160.0f, 64.0f)
                close()
                moveTo(272.0f, 240.0f)
                lineTo(512.0f, 240.0f)
                curveTo(529.7f, 240.0f, 544.0f, 254.3f, 544.0f, 272.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 433.7f, 529.7f, 448.0f, 512.0f, 448.0f)
                lineTo(272.0f, 448.0f)
                curveTo(254.3f, 448.0f, 240.0f, 433.7f, 240.0f, 416.0f)
                lineTo(240.0f, 272.0f)
                curveTo(240.0f, 254.3f, 254.3f, 240.0f, 272.0f, 240.0f)
                close()
            }
        }
        .build()
        return _sign!!
    }

private var _sign: ImageVector? = null
