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

public val Fa.Phone: ImageVector
    get() {
        if (_phone != null) {
            return _phone!!
        }
        _phone = Builder(name = "Phone", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.2f, 89.0f)
                curveTo(216.3f, 70.1f, 195.7f, 60.1f, 176.1f, 65.4f)
                lineTo(170.6f, 66.9f)
                curveTo(106.0f, 84.5f, 50.8f, 147.1f, 66.9f, 223.3f)
                curveTo(104.0f, 398.3f, 241.7f, 536.0f, 416.7f, 573.1f)
                curveTo(493.0f, 589.3f, 555.5f, 534.0f, 573.1f, 469.4f)
                lineTo(574.6f, 463.9f)
                curveTo(580.0f, 444.2f, 569.9f, 423.6f, 551.1f, 415.8f)
                lineTo(453.8f, 375.3f)
                curveTo(437.3f, 368.4f, 418.2f, 373.2f, 406.8f, 387.1f)
                lineTo(368.2f, 434.3f)
                curveTo(297.9f, 399.4f, 241.3f, 341.0f, 208.8f, 269.3f)
                lineTo(253.0f, 233.3f)
                curveTo(266.9f, 222.0f, 271.6f, 202.9f, 264.8f, 186.3f)
                lineTo(224.2f, 89.0f)
                close()
            }
        }
        .build()
        return _phone!!
    }

private var _phone: ImageVector? = null
