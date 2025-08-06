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

public val Fa.Bacon: ImageVector
    get() {
        if (_bacon != null) {
            return _bacon!!
        }
        _bacon = Builder(name = "Bacon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(589.0f, 160.7f)
                curveTo(603.4f, 175.1f, 601.4f, 199.1f, 584.7f, 210.9f)
                lineTo(520.1f, 256.6f)
                curveTo(476.4f, 287.5f, 440.9f, 328.5f, 416.7f, 376.2f)
                lineTo(391.4f, 426.0f)
                curveTo(366.3f, 475.3f, 329.3f, 517.5f, 283.6f, 548.6f)
                lineTo(209.5f, 599.2f)
                curveTo(196.4f, 608.1f, 178.8f, 606.5f, 167.7f, 595.3f)
                lineTo(122.8f, 550.4f)
                lineTo(209.3f, 483.9f)
                curveTo(251.6f, 451.4f, 286.0f, 409.6f, 309.9f, 361.9f)
                lineTo(334.4f, 312.8f)
                curveTo(358.9f, 263.8f, 396.2f, 222.2f, 442.3f, 192.6f)
                lineTo(551.0f, 122.7f)
                lineTo(589.0f, 160.7f)
                close()
                moveTo(516.2f, 87.9f)
                lineTo(416.3f, 152.2f)
                curveTo(362.9f, 186.5f, 319.8f, 234.6f, 291.4f, 291.3f)
                lineTo(266.9f, 340.4f)
                curveTo(246.3f, 381.7f, 216.6f, 417.7f, 180.0f, 445.8f)
                lineTo(88.6f, 516.1f)
                lineTo(51.7f, 479.2f)
                curveTo(37.3f, 464.8f, 39.3f, 440.8f, 56.0f, 429.0f)
                lineTo(120.6f, 383.3f)
                curveTo(164.3f, 352.4f, 199.8f, 311.4f, 224.0f, 263.7f)
                lineTo(249.3f, 213.9f)
                curveTo(274.3f, 164.8f, 311.3f, 122.6f, 357.0f, 91.4f)
                lineTo(431.1f, 40.8f)
                curveTo(444.2f, 31.9f, 461.7f, 33.5f, 472.9f, 44.7f)
                lineTo(516.2f, 88.0f)
                close()
            }
        }
        .build()
        return _bacon!!
    }

private var _bacon: ImageVector? = null
