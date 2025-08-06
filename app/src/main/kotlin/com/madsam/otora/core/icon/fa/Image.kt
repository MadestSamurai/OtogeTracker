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

public val Fa.Image: ImageVector
    get() {
        if (_image != null) {
            return _image!!
        }
        _image = Builder(name = "Image", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(224.0f, 176.0f)
                curveTo(250.5f, 176.0f, 272.0f, 197.5f, 272.0f, 224.0f)
                curveTo(272.0f, 250.5f, 250.5f, 272.0f, 224.0f, 272.0f)
                curveTo(197.5f, 272.0f, 176.0f, 250.5f, 176.0f, 224.0f)
                curveTo(176.0f, 197.5f, 197.5f, 176.0f, 224.0f, 176.0f)
                close()
                moveTo(368.0f, 288.0f)
                curveTo(376.4f, 288.0f, 384.1f, 292.4f, 388.5f, 299.5f)
                lineTo(476.5f, 443.5f)
                curveTo(481.0f, 450.9f, 481.2f, 460.2f, 477.0f, 467.8f)
                curveTo(472.8f, 475.4f, 464.7f, 480.0f, 456.0f, 480.0f)
                lineTo(184.0f, 480.0f)
                curveTo(175.1f, 480.0f, 166.8f, 475.0f, 162.7f, 467.1f)
                curveTo(158.6f, 459.2f, 159.2f, 449.6f, 164.3f, 442.3f)
                lineTo(220.3f, 362.3f)
                curveTo(224.8f, 355.9f, 232.1f, 352.1f, 240.0f, 352.1f)
                curveTo(247.9f, 352.1f, 255.2f, 355.9f, 259.7f, 362.3f)
                lineTo(286.1f, 400.1f)
                lineTo(347.5f, 299.6f)
                curveTo(351.9f, 292.5f, 359.6f, 288.1f, 368.0f, 288.1f)
                close()
            }
        }
        .build()
        return _image!!
    }

private var _image: ImageVector? = null
