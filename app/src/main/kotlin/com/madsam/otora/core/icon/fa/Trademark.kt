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

public val Fa.Trademark: ImageVector
    get() {
        if (_trademark != null) {
            return _trademark!!
        }
        _trademark = Builder(name = "Trademark", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(346.6f, 174.2f)
                curveTo(338.8f, 162.5f, 324.2f, 157.2f, 310.7f, 161.3f)
                curveTo(297.2f, 165.4f, 288.0f, 177.9f, 288.0f, 192.0f)
                lineTo(288.0f, 448.0f)
                curveTo(288.0f, 465.7f, 302.3f, 480.0f, 320.0f, 480.0f)
                curveTo(337.7f, 480.0f, 352.0f, 465.7f, 352.0f, 448.0f)
                lineTo(352.0f, 297.7f)
                lineTo(421.4f, 401.8f)
                curveTo(427.3f, 410.7f, 437.3f, 416.0f, 448.0f, 416.0f)
                curveTo(458.7f, 416.0f, 468.7f, 410.7f, 474.6f, 401.8f)
                lineTo(544.0f, 297.7f)
                lineTo(544.0f, 448.0f)
                curveTo(544.0f, 465.7f, 558.3f, 480.0f, 576.0f, 480.0f)
                curveTo(593.7f, 480.0f, 608.0f, 465.7f, 608.0f, 448.0f)
                lineTo(608.0f, 192.0f)
                curveTo(608.0f, 177.9f, 598.8f, 165.5f, 585.3f, 161.4f)
                curveTo(571.8f, 157.3f, 557.2f, 162.5f, 549.4f, 174.3f)
                lineTo(448.0f, 326.3f)
                lineTo(346.6f, 174.2f)
                close()
                moveTo(32.0f, 160.0f)
                curveTo(14.3f, 160.0f, 0.0f, 174.3f, 0.0f, 192.0f)
                curveTo(0.0f, 209.7f, 14.3f, 224.0f, 32.0f, 224.0f)
                lineTo(96.0f, 224.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 465.7f, 110.3f, 480.0f, 128.0f, 480.0f)
                curveTo(145.7f, 480.0f, 160.0f, 465.7f, 160.0f, 448.0f)
                lineTo(160.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                curveTo(241.7f, 224.0f, 256.0f, 209.7f, 256.0f, 192.0f)
                curveTo(256.0f, 174.3f, 241.7f, 160.0f, 224.0f, 160.0f)
                lineTo(32.0f, 160.0f)
                close()
            }
        }
        .build()
        return _trademark!!
    }

private var _trademark: ImageVector? = null
