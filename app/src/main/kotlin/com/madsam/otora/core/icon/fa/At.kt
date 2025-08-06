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

public val Fa.At: ImageVector
    get() {
        if (_at != null) {
            return _at!!
        }
        _at = Builder(name = "At", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth
                = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(214.0f, 128.0f, 128.0f, 214.0f, 128.0f, 320.0f)
                curveTo(128.0f, 426.0f, 214.0f, 512.0f, 320.0f, 512.0f)
                curveTo(337.7f, 512.0f, 352.0f, 526.3f, 352.0f, 544.0f)
                curveTo(352.0f, 561.7f, 337.7f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                lineTo(576.0f, 352.0f)
                curveTo(576.0f, 405.0f, 533.0f, 448.0f, 480.0f, 448.0f)
                curveTo(450.7f, 448.0f, 424.4f, 434.8f, 406.8f, 414.1f)
                curveTo(384.0f, 435.1f, 353.5f, 448.0f, 320.0f, 448.0f)
                curveTo(249.3f, 448.0f, 192.0f, 390.7f, 192.0f, 320.0f)
                curveTo(192.0f, 249.3f, 249.3f, 192.0f, 320.0f, 192.0f)
                curveTo(347.9f, 192.0f, 373.7f, 200.9f, 394.7f, 216.1f)
                curveTo(400.4f, 211.1f, 407.8f, 208.0f, 416.0f, 208.0f)
                curveTo(433.7f, 208.0f, 448.0f, 222.3f, 448.0f, 240.0f)
                lineTo(448.0f, 352.0f)
                curveTo(448.0f, 369.7f, 462.3f, 384.0f, 480.0f, 384.0f)
                curveTo(497.7f, 384.0f, 512.0f, 369.7f, 512.0f, 352.0f)
                lineTo(512.0f, 320.0f)
                curveTo(512.0f, 214.0f, 426.0f, 128.0f, 320.0f, 128.0f)
                close()
                moveTo(384.0f, 320.0f)
                curveTo(384.0f, 284.7f, 355.3f, 256.0f, 320.0f, 256.0f)
                curveTo(284.7f, 256.0f, 256.0f, 284.7f, 256.0f, 320.0f)
                curveTo(256.0f, 355.3f, 284.7f, 384.0f, 320.0f, 384.0f)
                curveTo(355.3f, 384.0f, 384.0f, 355.3f, 384.0f, 320.0f)
                close()
            }
        }
        .build()
        return _at!!
    }

private var _at: ImageVector? = null
