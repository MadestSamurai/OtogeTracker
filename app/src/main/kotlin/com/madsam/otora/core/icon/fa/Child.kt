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

public val Fa.Child: ImageVector
    get() {
        if (_child != null) {
            return _child!!
        }
        _child = Builder(name = "Child", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 128.0f)
                curveTo(256.0f, 92.7f, 284.7f, 64.0f, 320.0f, 64.0f)
                curveTo(355.3f, 64.0f, 384.0f, 92.7f, 384.0f, 128.0f)
                curveTo(384.0f, 163.3f, 355.3f, 192.0f, 320.0f, 192.0f)
                curveTo(284.7f, 192.0f, 256.0f, 163.3f, 256.0f, 128.0f)
                close()
                moveTo(304.0f, 448.0f)
                lineTo(304.0f, 544.0f)
                curveTo(304.0f, 561.7f, 289.7f, 576.0f, 272.0f, 576.0f)
                curveTo(254.3f, 576.0f, 240.0f, 561.7f, 240.0f, 544.0f)
                lineTo(240.0f, 351.8f)
                lineTo(219.1f, 385.0f)
                curveTo(209.7f, 400.0f, 189.9f, 404.4f, 175.0f, 395.0f)
                curveTo(160.1f, 385.6f, 155.5f, 365.9f, 164.9f, 351.0f)
                lineTo(204.8f, 287.7f)
                curveTo(229.7f, 248.0f, 273.2f, 224.0f, 320.0f, 224.0f)
                curveTo(366.8f, 224.0f, 410.3f, 248.0f, 435.2f, 287.6f)
                lineTo(475.1f, 351.0f)
                curveTo(484.5f, 366.0f, 480.0f, 385.7f, 465.1f, 395.1f)
                curveTo(450.2f, 404.5f, 430.4f, 400.0f, 421.0f, 385.1f)
                lineTo(400.0f, 351.8f)
                lineTo(400.0f, 544.0f)
                curveTo(400.0f, 561.7f, 385.7f, 576.0f, 368.0f, 576.0f)
                curveTo(350.3f, 576.0f, 336.0f, 561.7f, 336.0f, 544.0f)
                lineTo(336.0f, 448.0f)
                lineTo(304.0f, 448.0f)
                close()
            }
        }
        .build()
        return _child!!
    }

private var _child: ImageVector? = null
