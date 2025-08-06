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

public val Fa.Headphones: ImageVector
    get() {
        if (_headphones != null) {
            return _headphones!!
        }
        _headphones = Builder(name = "Headphones", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 288.0f)
                curveTo(160.0f, 199.6f, 231.6f, 128.0f, 320.0f, 128.0f)
                curveTo(408.4f, 128.0f, 480.0f, 199.6f, 480.0f, 288.0f)
                lineTo(480.0f, 325.5f)
                curveTo(470.0f, 322.0f, 459.2f, 320.0f, 448.0f, 320.0f)
                lineTo(432.0f, 320.0f)
                curveTo(405.5f, 320.0f, 384.0f, 341.5f, 384.0f, 368.0f)
                lineTo(384.0f, 496.0f)
                curveTo(384.0f, 522.5f, 405.5f, 544.0f, 432.0f, 544.0f)
                lineTo(448.0f, 544.0f)
                curveTo(501.0f, 544.0f, 544.0f, 501.0f, 544.0f, 448.0f)
                lineTo(544.0f, 288.0f)
                curveTo(544.0f, 164.3f, 443.7f, 64.0f, 320.0f, 64.0f)
                curveTo(196.3f, 64.0f, 96.0f, 164.3f, 96.0f, 288.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 501.0f, 139.0f, 544.0f, 192.0f, 544.0f)
                lineTo(208.0f, 544.0f)
                curveTo(234.5f, 544.0f, 256.0f, 522.5f, 256.0f, 496.0f)
                lineTo(256.0f, 368.0f)
                curveTo(256.0f, 341.5f, 234.5f, 320.0f, 208.0f, 320.0f)
                lineTo(192.0f, 320.0f)
                curveTo(180.8f, 320.0f, 170.0f, 321.9f, 160.0f, 325.5f)
                lineTo(160.0f, 288.0f)
                close()
            }
        }
        .build()
        return _headphones!!
    }

private var _headphones: ImageVector? = null
