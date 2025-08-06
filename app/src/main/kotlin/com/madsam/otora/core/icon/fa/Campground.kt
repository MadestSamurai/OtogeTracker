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

public val Fa.Campground: ImageVector
    get() {
        if (_campground != null) {
            return _campground!!
        }
        _campground = Builder(name = "Campground", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(408.8f, 116.3f)
                curveTo(420.0f, 102.6f, 418.0f, 82.5f, 404.3f, 71.3f)
                curveTo(390.6f, 60.1f, 370.5f, 62.1f, 359.3f, 75.8f)
                lineTo(320.1f, 123.8f)
                lineTo(280.9f, 75.8f)
                curveTo(269.6f, 62.1f, 249.4f, 60.0f, 235.7f, 71.2f)
                curveTo(222.0f, 82.4f, 220.0f, 102.6f, 231.2f, 116.2f)
                lineTo(278.6f, 174.2f)
                lineTo(76.6f, 421.1f)
                curveTo(68.5f, 431.1f, 64.0f, 443.6f, 64.0f, 456.6f)
                lineTo(64.0f, 496.0f)
                curveTo(64.0f, 522.5f, 85.5f, 544.0f, 112.0f, 544.0f)
                lineTo(528.0f, 544.0f)
                curveTo(554.5f, 544.0f, 576.0f, 522.5f, 576.0f, 496.0f)
                lineTo(576.0f, 456.6f)
                curveTo(576.0f, 443.7f, 571.5f, 431.1f, 563.3f, 421.1f)
                lineTo(361.3f, 174.2f)
                lineTo(408.7f, 116.2f)
                close()
                moveTo(320.0f, 352.0f)
                lineTo(432.0f, 480.0f)
                lineTo(208.0f, 480.0f)
                lineTo(320.0f, 352.0f)
                close()
            }
        }
        .build()
        return _campground!!
    }

private var _campground: ImageVector? = null
