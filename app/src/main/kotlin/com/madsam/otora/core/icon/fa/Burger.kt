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

public val Fa.Burger: ImageVector
    get() {
        if (_burger != null) {
            return _burger!!
        }
        _burger = Builder(name = "Burger", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(112.0f, 448.0f)
                curveTo(103.2f, 448.0f, 96.0f, 455.2f, 96.0f, 464.0f)
                curveTo(96.0f, 508.2f, 131.8f, 544.0f, 176.0f, 544.0f)
                lineTo(464.0f, 544.0f)
                curveTo(508.2f, 544.0f, 544.0f, 508.2f, 544.0f, 464.0f)
                curveTo(544.0f, 455.2f, 536.8f, 448.0f, 528.0f, 448.0f)
                lineTo(112.0f, 448.0f)
                close()
                moveTo(96.0f, 266.0f)
                curveTo(96.0f, 278.2f, 105.9f, 288.0f, 118.0f, 288.0f)
                lineTo(522.0f, 288.0f)
                curveTo(534.2f, 288.0f, 544.0f, 278.1f, 544.0f, 266.0f)
                curveTo(544.0f, 248.8f, 541.4f, 231.6f, 533.2f, 216.5f)
                curveTo(511.0f, 175.7f, 450.9f, 96.0f, 320.0f, 96.0f)
                curveTo(189.1f, 96.0f, 129.0f, 175.6f, 106.8f, 216.5f)
                curveTo(98.6f, 231.6f, 96.0f, 248.8f, 96.0f, 266.0f)
                close()
                moveTo(64.0f, 368.0f)
                curveTo(64.0f, 385.7f, 78.3f, 400.0f, 96.0f, 400.0f)
                lineTo(544.0f, 400.0f)
                curveTo(561.7f, 400.0f, 576.0f, 385.7f, 576.0f, 368.0f)
                curveTo(576.0f, 350.3f, 561.7f, 336.0f, 544.0f, 336.0f)
                lineTo(96.0f, 336.0f)
                curveTo(78.3f, 336.0f, 64.0f, 350.3f, 64.0f, 368.0f)
                close()
                moveTo(320.0f, 136.0f)
                curveTo(333.3f, 136.0f, 344.0f, 146.7f, 344.0f, 160.0f)
                curveTo(344.0f, 173.3f, 333.3f, 184.0f, 320.0f, 184.0f)
                curveTo(306.7f, 184.0f, 296.0f, 173.3f, 296.0f, 160.0f)
                curveTo(296.0f, 146.7f, 306.7f, 136.0f, 320.0f, 136.0f)
                close()
                moveTo(184.0f, 192.0f)
                curveTo(184.0f, 178.7f, 194.7f, 168.0f, 208.0f, 168.0f)
                curveTo(221.3f, 168.0f, 232.0f, 178.7f, 232.0f, 192.0f)
                curveTo(232.0f, 205.3f, 221.3f, 216.0f, 208.0f, 216.0f)
                curveTo(194.7f, 216.0f, 184.0f, 205.3f, 184.0f, 192.0f)
                close()
                moveTo(432.0f, 168.0f)
                curveTo(445.3f, 168.0f, 456.0f, 178.7f, 456.0f, 192.0f)
                curveTo(456.0f, 205.3f, 445.3f, 216.0f, 432.0f, 216.0f)
                curveTo(418.7f, 216.0f, 408.0f, 205.3f, 408.0f, 192.0f)
                curveTo(408.0f, 178.7f, 418.7f, 168.0f, 432.0f, 168.0f)
                close()
            }
        }
        .build()
        return _burger!!
    }

private var _burger: ImageVector? = null
