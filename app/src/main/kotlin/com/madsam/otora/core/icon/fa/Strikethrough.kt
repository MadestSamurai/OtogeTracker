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

public val Fa.Strikethrough: ImageVector
    get() {
        if (_strikethrough != null) {
            return _strikethrough!!
        }
        _strikethrough = Builder(name = "Strikethrough", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 221.5f)
                curveTo(160.0f, 152.2f, 216.2f, 96.0f, 285.5f, 96.0f)
                lineTo(432.0f, 96.0f)
                curveTo(449.7f, 96.0f, 464.0f, 110.3f, 464.0f, 128.0f)
                curveTo(464.0f, 145.7f, 449.7f, 160.0f, 432.0f, 160.0f)
                lineTo(285.5f, 160.0f)
                curveTo(251.5f, 160.0f, 224.0f, 187.5f, 224.0f, 221.5f)
                curveTo(224.0f, 252.5f, 247.1f, 278.7f, 277.9f, 282.5f)
                lineTo(322.0f, 288.0f)
                lineTo(544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 302.3f, 576.0f, 320.0f)
                curveTo(576.0f, 337.7f, 561.7f, 352.0f, 544.0f, 352.0f)
                lineTo(96.0f, 352.0f)
                curveTo(78.3f, 352.0f, 64.0f, 337.7f, 64.0f, 320.0f)
                curveTo(64.0f, 302.3f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(179.1f, 288.0f)
                curveTo(167.0f, 268.6f, 160.0f, 245.8f, 160.0f, 221.5f)
                close()
                moveTo(413.2f, 400.0f)
                lineTo(478.7f, 400.0f)
                curveTo(479.6f, 406.1f, 480.1f, 412.2f, 480.1f, 418.5f)
                curveTo(480.1f, 487.8f, 423.9f, 544.0f, 354.6f, 544.0f)
                lineTo(208.0f, 544.0f)
                curveTo(190.3f, 544.0f, 176.0f, 529.7f, 176.0f, 512.0f)
                curveTo(176.0f, 494.3f, 190.3f, 480.0f, 208.0f, 480.0f)
                lineTo(354.5f, 480.0f)
                curveTo(388.5f, 480.0f, 416.0f, 452.5f, 416.0f, 418.5f)
                curveTo(416.0f, 412.1f, 415.0f, 405.8f, 413.2f, 400.0f)
                close()
            }
        }
        .build()
        return _strikethrough!!
    }

private var _strikethrough: ImageVector? = null
