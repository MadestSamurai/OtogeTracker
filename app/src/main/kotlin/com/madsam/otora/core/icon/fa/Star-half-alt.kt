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

public val Fa.`Star-half-alt`: ImageVector
    get() {
        if (`_star-half-alt` != null) {
            return `_star-half-alt`!!
        }
        `_star-half-alt` = Builder(name = "Star-half-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.1f, 417.6f)
                curveTo(330.1f, 417.6f, 340.0f, 419.9f, 349.1f, 424.6f)
                lineTo(423.5f, 462.5f)
                lineTo(410.5f, 380.0f)
                curveTo(407.3f, 359.8f, 414.0f, 339.3f, 428.4f, 324.8f)
                lineTo(487.4f, 265.7f)
                lineTo(404.9f, 252.6f)
                curveTo(384.7f, 249.4f, 367.2f, 236.7f, 357.9f, 218.5f)
                lineTo(319.9f, 144.1f)
                lineTo(319.9f, 417.7f)
                close()
                moveTo(489.4f, 553.0f)
                curveTo(482.1f, 558.3f, 472.4f, 559.1f, 464.4f, 555.0f)
                lineTo(320.1f, 481.6f)
                lineTo(175.8f, 555.0f)
                curveTo(167.8f, 559.1f, 158.1f, 558.3f, 150.8f, 553.0f)
                curveTo(143.5f, 547.7f, 139.8f, 538.8f, 141.2f, 529.8f)
                lineTo(166.4f, 369.9f)
                lineTo(52.0f, 255.4f)
                curveTo(45.6f, 249.0f, 43.4f, 239.6f, 46.2f, 231.0f)
                curveTo(49.0f, 222.4f, 56.3f, 216.1f, 65.3f, 214.7f)
                lineTo(225.2f, 189.3f)
                lineTo(298.8f, 45.1f)
                curveTo(302.9f, 37.1f, 311.2f, 32.0f, 320.2f, 32.0f)
                curveTo(329.2f, 32.0f, 337.5f, 37.1f, 341.6f, 45.1f)
                lineTo(415.0f, 189.3f)
                lineTo(574.9f, 214.7f)
                curveTo(583.8f, 216.1f, 591.2f, 222.4f, 594.0f, 231.0f)
                curveTo(596.8f, 239.6f, 594.5f, 249.0f, 588.2f, 255.4f)
                lineTo(473.7f, 369.9f)
                lineTo(499.0f, 529.8f)
                curveTo(500.4f, 538.7f, 496.7f, 547.7f, 489.4f, 553.0f)
                close()
            }
        }
        .build()
        return `_star-half-alt`!!
    }

private var `_star-half-alt`: ImageVector? = null
