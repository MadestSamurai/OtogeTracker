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

public val Fa.Jar: ImageVector
    get() {
        if (_jar != null) {
            return _jar!!
        }
        _jar = Builder(name = "Jar", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 56.0f)
                curveTo(192.0f, 42.7f, 202.7f, 32.0f, 216.0f, 32.0f)
                lineTo(424.0f, 32.0f)
                curveTo(437.3f, 32.0f, 448.0f, 42.7f, 448.0f, 56.0f)
                curveTo(448.0f, 69.3f, 437.3f, 80.0f, 424.0f, 80.0f)
                lineTo(216.0f, 80.0f)
                curveTo(202.7f, 80.0f, 192.0f, 69.3f, 192.0f, 56.0f)
                close()
                moveTo(160.0f, 192.0f)
                curveTo(160.0f, 156.7f, 188.7f, 128.0f, 224.0f, 128.0f)
                lineTo(416.0f, 128.0f)
                curveTo(451.3f, 128.0f, 480.0f, 156.7f, 480.0f, 192.0f)
                lineTo(480.0f, 512.0f)
                curveTo(480.0f, 547.3f, 451.3f, 576.0f, 416.0f, 576.0f)
                lineTo(224.0f, 576.0f)
                curveTo(188.7f, 576.0f, 160.0f, 547.3f, 160.0f, 512.0f)
                lineTo(160.0f, 192.0f)
                close()
                moveTo(256.0f, 256.0f)
                curveTo(238.3f, 256.0f, 224.0f, 270.3f, 224.0f, 288.0f)
                lineTo(224.0f, 416.0f)
                curveTo(224.0f, 433.7f, 238.3f, 448.0f, 256.0f, 448.0f)
                lineTo(384.0f, 448.0f)
                curveTo(401.7f, 448.0f, 416.0f, 433.7f, 416.0f, 416.0f)
                lineTo(416.0f, 288.0f)
                curveTo(416.0f, 270.3f, 401.7f, 256.0f, 384.0f, 256.0f)
                lineTo(256.0f, 256.0f)
                close()
            }
        }
        .build()
        return _jar!!
    }

private var _jar: ImageVector? = null
