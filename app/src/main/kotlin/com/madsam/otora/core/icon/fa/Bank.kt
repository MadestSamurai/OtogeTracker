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

public val Fa.Bank: ImageVector
    get() {
        if (_bank != null) {
            return _bank!!
        }
        _bank = Builder(name = "Bank", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(335.9f, 84.2f)
                curveTo(326.1f, 78.6f, 314.0f, 78.6f, 304.1f, 84.2f)
                lineTo(80.1f, 212.2f)
                curveTo(67.5f, 219.4f, 61.3f, 234.2f, 65.0f, 248.2f)
                curveTo(68.7f, 262.2f, 81.5f, 272.0f, 96.0f, 272.0f)
                lineTo(128.0f, 272.0f)
                lineTo(128.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                lineTo(76.8f, 518.4f)
                curveTo(68.7f, 524.4f, 64.0f, 533.9f, 64.0f, 544.0f)
                curveTo(64.0f, 561.7f, 78.3f, 576.0f, 96.0f, 576.0f)
                lineTo(544.0f, 576.0f)
                curveTo(561.7f, 576.0f, 576.0f, 561.7f, 576.0f, 544.0f)
                curveTo(576.0f, 533.9f, 571.3f, 524.4f, 563.2f, 518.4f)
                lineTo(512.0f, 480.0f)
                lineTo(512.0f, 272.0f)
                lineTo(544.0f, 272.0f)
                curveTo(558.5f, 272.0f, 571.2f, 262.2f, 574.9f, 248.2f)
                curveTo(578.6f, 234.2f, 572.4f, 219.4f, 559.8f, 212.2f)
                lineTo(335.8f, 84.2f)
                close()
                moveTo(464.0f, 272.0f)
                lineTo(464.0f, 480.0f)
                lineTo(400.0f, 480.0f)
                lineTo(400.0f, 272.0f)
                lineTo(464.0f, 272.0f)
                close()
                moveTo(352.0f, 272.0f)
                lineTo(352.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                lineTo(288.0f, 272.0f)
                lineTo(352.0f, 272.0f)
                close()
                moveTo(240.0f, 272.0f)
                lineTo(240.0f, 480.0f)
                lineTo(176.0f, 480.0f)
                lineTo(176.0f, 272.0f)
                lineTo(240.0f, 272.0f)
                close()
                moveTo(320.0f, 160.0f)
                curveTo(337.7f, 160.0f, 352.0f, 174.3f, 352.0f, 192.0f)
                curveTo(352.0f, 209.7f, 337.7f, 224.0f, 320.0f, 224.0f)
                curveTo(302.3f, 224.0f, 288.0f, 209.7f, 288.0f, 192.0f)
                curveTo(288.0f, 174.3f, 302.3f, 160.0f, 320.0f, 160.0f)
                close()
            }
        }
        .build()
        return _bank!!
    }

private var _bank: ImageVector? = null
