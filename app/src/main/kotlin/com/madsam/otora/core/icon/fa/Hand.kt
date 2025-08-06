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

public val Fa.Hand: ImageVector
    get() {
        if (_hand != null) {
            return _hand!!
        }
        _hand = Builder(name = "Hand", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 304.0f)
                curveTo(288.0f, 312.8f, 280.8f, 320.0f, 272.0f, 320.0f)
                curveTo(263.2f, 320.0f, 256.0f, 312.8f, 256.0f, 304.0f)
                lineTo(256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 241.7f, 96.0f, 224.0f, 96.0f)
                curveTo(206.3f, 96.0f, 192.0f, 110.3f, 192.0f, 128.0f)
                lineTo(192.0f, 400.0f)
                curveTo(192.0f, 401.5f, 192.0f, 403.1f, 192.1f, 404.6f)
                lineTo(131.6f, 347.0f)
                curveTo(115.6f, 331.8f, 90.3f, 332.4f, 75.0f, 348.4f)
                curveTo(59.7f, 364.4f, 60.4f, 389.7f, 76.4f, 405.0f)
                lineTo(188.8f, 512.0f)
                curveTo(231.9f, 553.1f, 289.2f, 576.0f, 348.8f, 576.0f)
                lineTo(368.0f, 576.0f)
                curveTo(465.2f, 576.0f, 544.0f, 497.2f, 544.0f, 400.0f)
                lineTo(544.0f, 192.0f)
                curveTo(544.0f, 174.3f, 529.7f, 160.0f, 512.0f, 160.0f)
                curveTo(494.3f, 160.0f, 480.0f, 174.3f, 480.0f, 192.0f)
                lineTo(480.0f, 304.0f)
                curveTo(480.0f, 312.8f, 472.8f, 320.0f, 464.0f, 320.0f)
                curveTo(455.2f, 320.0f, 448.0f, 312.8f, 448.0f, 304.0f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 110.3f, 433.7f, 96.0f, 416.0f, 96.0f)
                curveTo(398.3f, 96.0f, 384.0f, 110.3f, 384.0f, 128.0f)
                lineTo(384.0f, 304.0f)
                curveTo(384.0f, 312.8f, 376.8f, 320.0f, 368.0f, 320.0f)
                curveTo(359.2f, 320.0f, 352.0f, 312.8f, 352.0f, 304.0f)
                lineTo(352.0f, 96.0f)
                close()
            }
        }
        .build()
        return _hand!!
    }

private var _hand: ImageVector? = null
