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

public val Fa.Road: ImageVector
    get() {
        if (_road != null) {
            return _road!!
        }
        _road = Builder(name = "Road", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(287.9f, 96.0f)
                lineTo(211.7f, 96.0f)
                curveTo(182.3f, 96.0f, 156.6f, 116.1f, 149.6f, 144.6f)
                lineTo(65.4f, 484.5f)
                curveTo(57.9f, 514.7f, 80.8f, 544.0f, 112.0f, 544.0f)
                lineTo(287.9f, 544.0f)
                lineTo(287.9f, 480.0f)
                curveTo(287.9f, 462.3f, 302.2f, 448.0f, 319.9f, 448.0f)
                curveTo(337.6f, 448.0f, 351.9f, 462.3f, 351.9f, 480.0f)
                lineTo(351.9f, 544.0f)
                lineTo(528.0f, 544.0f)
                curveTo(559.2f, 544.0f, 582.1f, 514.7f, 574.6f, 484.5f)
                lineTo(490.5f, 144.6f)
                curveTo(483.4f, 116.1f, 457.8f, 96.0f, 428.3f, 96.0f)
                lineTo(351.9f, 96.0f)
                lineTo(351.9f, 160.0f)
                curveTo(351.9f, 177.7f, 337.6f, 192.0f, 319.9f, 192.0f)
                curveTo(302.2f, 192.0f, 287.9f, 177.7f, 287.9f, 160.0f)
                lineTo(287.9f, 96.0f)
                close()
                moveTo(351.9f, 288.0f)
                lineTo(351.9f, 352.0f)
                curveTo(351.9f, 369.7f, 337.6f, 384.0f, 319.9f, 384.0f)
                curveTo(302.2f, 384.0f, 287.9f, 369.7f, 287.9f, 352.0f)
                lineTo(287.9f, 288.0f)
                curveTo(287.9f, 270.3f, 302.2f, 256.0f, 319.9f, 256.0f)
                curveTo(337.6f, 256.0f, 351.9f, 270.3f, 351.9f, 288.0f)
                close()
            }
        }
        .build()
        return _road!!
    }

private var _road: ImageVector? = null
