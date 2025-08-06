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

public val Fa.Ticket: ImageVector
    get() {
        if (_ticket != null) {
            return _ticket!!
        }
        _ticket = Builder(name = "Ticket", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(60.7f, 128.0f, 32.0f, 156.7f, 32.0f, 192.0f)
                lineTo(32.0f, 256.0f)
                curveTo(32.0f, 264.8f, 39.4f, 271.7f, 47.7f, 274.6f)
                curveTo(66.5f, 281.1f, 80.0f, 299.0f, 80.0f, 320.0f)
                curveTo(80.0f, 341.0f, 66.5f, 358.9f, 47.7f, 365.4f)
                curveTo(39.4f, 368.3f, 32.0f, 375.2f, 32.0f, 384.0f)
                lineTo(32.0f, 448.0f)
                curveTo(32.0f, 483.3f, 60.7f, 512.0f, 96.0f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(579.3f, 512.0f, 608.0f, 483.3f, 608.0f, 448.0f)
                lineTo(608.0f, 384.0f)
                curveTo(608.0f, 375.2f, 600.6f, 368.3f, 592.3f, 365.4f)
                curveTo(573.5f, 358.9f, 560.0f, 341.0f, 560.0f, 320.0f)
                curveTo(560.0f, 299.0f, 573.5f, 281.1f, 592.3f, 274.6f)
                curveTo(600.6f, 271.7f, 608.0f, 264.8f, 608.0f, 256.0f)
                lineTo(608.0f, 192.0f)
                curveTo(608.0f, 156.7f, 579.3f, 128.0f, 544.0f, 128.0f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(448.0f, 400.0f)
                lineTo(448.0f, 240.0f)
                lineTo(192.0f, 240.0f)
                lineTo(192.0f, 400.0f)
                lineTo(448.0f, 400.0f)
                close()
                moveTo(144.0f, 224.0f)
                curveTo(144.0f, 206.3f, 158.3f, 192.0f, 176.0f, 192.0f)
                lineTo(464.0f, 192.0f)
                curveTo(481.7f, 192.0f, 496.0f, 206.3f, 496.0f, 224.0f)
                lineTo(496.0f, 416.0f)
                curveTo(496.0f, 433.7f, 481.7f, 448.0f, 464.0f, 448.0f)
                lineTo(176.0f, 448.0f)
                curveTo(158.3f, 448.0f, 144.0f, 433.7f, 144.0f, 416.0f)
                lineTo(144.0f, 224.0f)
                close()
            }
        }
        .build()
        return _ticket!!
    }

private var _ticket: ImageVector? = null
