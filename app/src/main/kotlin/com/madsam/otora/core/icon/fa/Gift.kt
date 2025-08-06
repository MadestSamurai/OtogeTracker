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

public val Fa.Gift: ImageVector
    get() {
        if (_gift != null) {
            return _gift!!
        }
        _gift = Builder(name = "Gift", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(385.5f, 132.8f)
                curveTo(393.1f, 119.9f, 406.9f, 112.0f, 421.8f, 112.0f)
                lineTo(424.0f, 112.0f)
                curveTo(446.1f, 112.0f, 464.0f, 129.9f, 464.0f, 152.0f)
                curveTo(464.0f, 174.1f, 446.1f, 192.0f, 424.0f, 192.0f)
                lineTo(350.7f, 192.0f)
                lineTo(385.5f, 132.8f)
                close()
                moveTo(254.5f, 132.8f)
                lineTo(289.3f, 192.0f)
                lineTo(216.0f, 192.0f)
                curveTo(193.9f, 192.0f, 176.0f, 174.1f, 176.0f, 152.0f)
                curveTo(176.0f, 129.9f, 193.9f, 112.0f, 216.0f, 112.0f)
                lineTo(218.2f, 112.0f)
                curveTo(233.1f, 112.0f, 247.0f, 119.9f, 254.5f, 132.8f)
                close()
                moveTo(344.1f, 108.5f)
                lineTo(320.0f, 149.5f)
                lineTo(295.9f, 108.5f)
                curveTo(279.7f, 80.9f, 250.1f, 64.0f, 218.2f, 64.0f)
                lineTo(216.0f, 64.0f)
                curveTo(167.4f, 64.0f, 128.0f, 103.4f, 128.0f, 152.0f)
                curveTo(128.0f, 166.4f, 131.5f, 180.0f, 137.6f, 192.0f)
                lineTo(96.0f, 192.0f)
                curveTo(78.3f, 192.0f, 64.0f, 206.3f, 64.0f, 224.0f)
                lineTo(64.0f, 256.0f)
                curveTo(64.0f, 273.7f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 273.7f, 576.0f, 256.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 206.3f, 561.7f, 192.0f, 544.0f, 192.0f)
                lineTo(502.4f, 192.0f)
                curveTo(508.5f, 180.0f, 512.0f, 166.4f, 512.0f, 152.0f)
                curveTo(512.0f, 103.4f, 472.6f, 64.0f, 424.0f, 64.0f)
                lineTo(421.8f, 64.0f)
                curveTo(389.9f, 64.0f, 360.3f, 80.9f, 344.1f, 108.4f)
                close()
                moveTo(544.0f, 336.0f)
                lineTo(344.0f, 336.0f)
                lineTo(344.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 336.0f)
                close()
                moveTo(296.0f, 336.0f)
                lineTo(96.0f, 336.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(296.0f, 544.0f)
                lineTo(296.0f, 336.0f)
                close()
            }
        }
        .build()
        return _gift!!
    }

private var _gift: ImageVector? = null
