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

public val Fa.Rupee: ImageVector
    get() {
        if (_rupee != null) {
            return _rupee!!
        }
        _rupee = Builder(name = "Rupee", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 110.3f, 110.3f, 96.0f, 128.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                curveTo(287.5f, 96.0f, 352.0f, 160.5f, 352.0f, 240.0f)
                curveTo(352.0f, 294.3f, 322.0f, 341.5f, 277.6f, 366.1f)
                lineTo(318.6f, 502.8f)
                curveTo(323.7f, 519.7f, 314.1f, 537.6f, 297.1f, 542.6f)
                curveTo(280.1f, 547.6f, 262.3f, 538.1f, 257.3f, 521.1f)
                lineTo(216.1f, 383.8f)
                curveTo(213.4f, 383.9f, 210.7f, 384.0f, 208.0f, 384.0f)
                lineTo(160.0f, 384.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 145.7f, 544.0f, 128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(160.0f, 320.0f)
                lineTo(208.0f, 320.0f)
                curveTo(252.2f, 320.0f, 288.0f, 284.2f, 288.0f, 240.0f)
                curveTo(288.0f, 195.8f, 252.2f, 160.0f, 208.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                lineTo(160.0f, 320.0f)
                close()
                moveTo(445.1f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(497.7f, 288.0f, 512.0f, 302.3f, 512.0f, 320.0f)
                curveTo(512.0f, 337.7f, 497.7f, 352.0f, 480.0f, 352.0f)
                lineTo(445.1f, 352.0f)
                curveTo(437.9f, 352.0f, 432.0f, 357.9f, 432.0f, 365.1f)
                curveTo(432.0f, 370.8f, 435.7f, 375.8f, 441.1f, 377.6f)
                lineTo(490.5f, 393.5f)
                curveTo(522.4f, 403.8f, 544.0f, 433.4f, 544.0f, 466.9f)
                curveTo(544.0f, 509.5f, 509.5f, 544.0f, 466.9f, 544.0f)
                lineTo(416.0f, 544.0f)
                curveTo(398.3f, 544.0f, 384.0f, 529.7f, 384.0f, 512.0f)
                curveTo(384.0f, 494.3f, 398.3f, 480.0f, 416.0f, 480.0f)
                lineTo(466.9f, 480.0f)
                curveTo(474.1f, 480.0f, 480.0f, 474.1f, 480.0f, 466.9f)
                curveTo(480.0f, 461.2f, 476.3f, 456.2f, 470.9f, 454.4f)
                lineTo(421.5f, 438.5f)
                curveTo(389.6f, 428.2f, 368.0f, 398.6f, 368.0f, 365.1f)
                curveTo(368.0f, 322.5f, 402.5f, 288.0f, 445.1f, 288.0f)
                close()
            }
        }
        .build()
        return _rupee!!
    }

private var _rupee: ImageVector? = null
