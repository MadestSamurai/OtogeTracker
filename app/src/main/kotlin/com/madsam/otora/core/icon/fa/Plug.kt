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

public val Fa.Plug: ImageVector
    get() {
        if (_plug != null) {
            return _plug!!
        }
        _plug = Builder(name = "Plug", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 32.0f)
                curveTo(241.7f, 32.0f, 256.0f, 46.3f, 256.0f, 64.0f)
                lineTo(256.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                lineTo(384.0f, 64.0f)
                curveTo(384.0f, 46.3f, 398.3f, 32.0f, 416.0f, 32.0f)
                curveTo(433.7f, 32.0f, 448.0f, 46.3f, 448.0f, 64.0f)
                lineTo(448.0f, 160.0f)
                lineTo(512.0f, 160.0f)
                curveTo(529.7f, 160.0f, 544.0f, 174.3f, 544.0f, 192.0f)
                curveTo(544.0f, 209.7f, 529.7f, 224.0f, 512.0f, 224.0f)
                lineTo(512.0f, 288.0f)
                curveTo(512.0f, 383.1f, 442.8f, 462.1f, 352.0f, 477.3f)
                lineTo(352.0f, 544.0f)
                curveTo(352.0f, 561.7f, 337.7f, 576.0f, 320.0f, 576.0f)
                curveTo(302.3f, 576.0f, 288.0f, 561.7f, 288.0f, 544.0f)
                lineTo(288.0f, 477.3f)
                curveTo(197.2f, 462.1f, 128.0f, 383.1f, 128.0f, 288.0f)
                lineTo(128.0f, 224.0f)
                curveTo(110.3f, 224.0f, 96.0f, 209.7f, 96.0f, 192.0f)
                curveTo(96.0f, 174.3f, 110.3f, 160.0f, 128.0f, 160.0f)
                lineTo(192.0f, 160.0f)
                lineTo(192.0f, 64.0f)
                curveTo(192.0f, 46.3f, 206.3f, 32.0f, 224.0f, 32.0f)
                close()
            }
        }
        .build()
        return _plug!!
    }

private var _plug: ImageVector? = null
