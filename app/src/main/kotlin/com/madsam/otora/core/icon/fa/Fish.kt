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

public val Fa.Fish: ImageVector
    get() {
        if (_fish != null) {
            return _fish!!
        }
        _fish = Builder(name = "Fish", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(212.5f, 205.5f)
                curveTo(251.7f, 172.5f, 304.6f, 144.0f, 368.0f, 144.0f)
                curveTo(431.4f, 144.0f, 484.3f, 172.5f, 523.5f, 205.5f)
                curveTo(562.6f, 238.5f, 590.4f, 277.9f, 604.5f, 305.3f)
                curveTo(609.2f, 314.5f, 609.2f, 325.4f, 604.5f, 334.6f)
                curveTo(590.4f, 362.0f, 562.6f, 401.4f, 523.5f, 434.4f)
                curveTo(484.3f, 467.5f, 431.5f, 495.9f, 368.0f, 495.9f)
                curveTo(304.5f, 495.9f, 251.7f, 467.4f, 212.5f, 434.4f)
                curveTo(196.3f, 420.7f, 182.0f, 405.9f, 169.8f, 391.3f)
                lineTo(80.1f, 443.6f)
                curveTo(67.6f, 450.9f, 51.7f, 448.9f, 41.4f, 438.7f)
                curveTo(31.1f, 428.5f, 29.0f, 412.7f, 36.1f, 400.1f)
                lineTo(82.0f, 320.0f)
                lineTo(36.2f, 239.9f)
                curveTo(29.0f, 227.3f, 31.2f, 211.5f, 41.5f, 201.3f)
                curveTo(51.8f, 191.1f, 67.6f, 189.1f, 80.2f, 196.4f)
                lineTo(169.9f, 248.7f)
                curveTo(182.1f, 234.1f, 196.4f, 219.3f, 212.6f, 205.6f)
                close()
                moveTo(480.0f, 320.0f)
                curveTo(480.0f, 302.3f, 465.7f, 288.0f, 448.0f, 288.0f)
                curveTo(430.3f, 288.0f, 416.0f, 302.3f, 416.0f, 320.0f)
                curveTo(416.0f, 337.7f, 430.3f, 352.0f, 448.0f, 352.0f)
                curveTo(465.7f, 352.0f, 480.0f, 337.7f, 480.0f, 320.0f)
                close()
            }
        }
        .build()
        return _fish!!
    }

private var _fish: ImageVector? = null
