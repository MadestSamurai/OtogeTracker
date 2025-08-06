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

public val Fa.Palette: ImageVector
    get() {
        if (_palette != null) {
            return _palette!!
        }
        _palette = Builder(name = "Palette", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 320.0f)
                curveTo(576.0f, 320.9f, 576.0f, 321.8f, 576.0f, 322.7f)
                curveTo(575.6f, 359.2f, 542.4f, 384.0f, 505.9f, 384.0f)
                lineTo(408.0f, 384.0f)
                curveTo(381.5f, 384.0f, 360.0f, 405.5f, 360.0f, 432.0f)
                curveTo(360.0f, 435.4f, 360.4f, 438.7f, 361.0f, 441.9f)
                curveTo(363.1f, 452.1f, 367.5f, 461.9f, 371.8f, 471.8f)
                curveTo(377.9f, 485.6f, 383.9f, 499.3f, 383.9f, 513.8f)
                curveTo(383.9f, 545.6f, 362.3f, 574.5f, 330.5f, 575.8f)
                curveTo(327.0f, 575.9f, 323.5f, 576.0f, 319.9f, 576.0f)
                curveTo(178.5f, 576.0f, 63.9f, 461.4f, 63.9f, 320.0f)
                curveTo(63.9f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                close()
                moveTo(192.0f, 352.0f)
                curveTo(192.0f, 334.3f, 177.7f, 320.0f, 160.0f, 320.0f)
                curveTo(142.3f, 320.0f, 128.0f, 334.3f, 128.0f, 352.0f)
                curveTo(128.0f, 369.7f, 142.3f, 384.0f, 160.0f, 384.0f)
                curveTo(177.7f, 384.0f, 192.0f, 369.7f, 192.0f, 352.0f)
                close()
                moveTo(192.0f, 256.0f)
                curveTo(209.7f, 256.0f, 224.0f, 241.7f, 224.0f, 224.0f)
                curveTo(224.0f, 206.3f, 209.7f, 192.0f, 192.0f, 192.0f)
                curveTo(174.3f, 192.0f, 160.0f, 206.3f, 160.0f, 224.0f)
                curveTo(160.0f, 241.7f, 174.3f, 256.0f, 192.0f, 256.0f)
                close()
                moveTo(352.0f, 160.0f)
                curveTo(352.0f, 142.3f, 337.7f, 128.0f, 320.0f, 128.0f)
                curveTo(302.3f, 128.0f, 288.0f, 142.3f, 288.0f, 160.0f)
                curveTo(288.0f, 177.7f, 302.3f, 192.0f, 320.0f, 192.0f)
                curveTo(337.7f, 192.0f, 352.0f, 177.7f, 352.0f, 160.0f)
                close()
                moveTo(448.0f, 256.0f)
                curveTo(465.7f, 256.0f, 480.0f, 241.7f, 480.0f, 224.0f)
                curveTo(480.0f, 206.3f, 465.7f, 192.0f, 448.0f, 192.0f)
                curveTo(430.3f, 192.0f, 416.0f, 206.3f, 416.0f, 224.0f)
                curveTo(416.0f, 241.7f, 430.3f, 256.0f, 448.0f, 256.0f)
                close()
            }
        }
        .build()
        return _palette!!
    }

private var _palette: ImageVector? = null
