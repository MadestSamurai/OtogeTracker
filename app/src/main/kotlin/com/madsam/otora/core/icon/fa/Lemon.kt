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

public val Fa.Lemon: ImageVector
    get() {
        if (_lemon != null) {
            return _lemon!!
        }
        _lemon = Builder(name = "Lemon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                curveTo(473.4f, 96.0f, 467.0f, 97.0f, 461.0f, 98.9f)
                curveTo(438.5f, 105.9f, 412.9f, 113.8f, 390.0f, 107.9f)
                curveTo(314.8f, 88.8f, 233.6f, 118.9f, 176.3f, 176.2f)
                curveTo(119.0f, 233.5f, 88.8f, 314.8f, 107.9f, 390.0f)
                curveTo(113.7f, 412.9f, 105.9f, 438.4f, 98.9f, 461.0f)
                curveTo(97.0f, 467.0f, 96.0f, 473.4f, 96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                curveTo(166.6f, 544.0f, 173.0f, 543.0f, 179.1f, 541.1f)
                curveTo(201.6f, 534.1f, 227.2f, 526.2f, 250.1f, 532.1f)
                curveTo(325.3f, 551.2f, 406.5f, 521.1f, 463.8f, 463.8f)
                curveTo(521.1f, 406.5f, 551.2f, 325.2f, 532.1f, 250.0f)
                curveTo(526.3f, 227.1f, 534.1f, 201.6f, 541.1f, 179.0f)
                curveTo(543.0f, 173.0f, 544.0f, 166.6f, 544.0f, 159.9f)
                close()
                moveTo(318.7f, 207.0f)
                curveTo(266.7f, 222.2f, 222.2f, 266.7f, 207.0f, 318.7f)
                curveTo(203.3f, 331.4f, 189.9f, 338.7f, 177.2f, 335.0f)
                curveTo(164.5f, 331.3f, 157.2f, 318.0f, 161.0f, 305.3f)
                curveTo(180.8f, 237.6f, 237.6f, 180.8f, 305.3f, 161.0f)
                curveTo(318.0f, 157.3f, 331.4f, 164.6f, 335.1f, 177.3f)
                curveTo(338.8f, 190.0f, 331.5f, 203.4f, 318.8f, 207.1f)
                close()
            }
        }
        .build()
        return _lemon!!
    }

private var _lemon: ImageVector? = null
