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

public val Fa.Wheelchair: ImageVector
    get() {
        if (_wheelchair != null) {
            return _wheelchair!!
        }
        _wheelchair = Builder(name = "Wheelchair", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(200.0f, 104.0f)
                curveTo(200.0f, 73.1f, 225.1f, 48.0f, 256.0f, 48.0f)
                curveTo(286.9f, 48.0f, 312.0f, 73.1f, 312.0f, 104.0f)
                curveTo(312.0f, 134.9f, 286.9f, 160.0f, 256.0f, 160.0f)
                curveTo(225.1f, 160.0f, 200.0f, 134.9f, 200.0f, 104.0f)
                close()
                moveTo(181.9f, 261.6f)
                lineTo(194.5f, 324.6f)
                curveTo(155.9f, 337.0f, 128.0f, 373.3f, 128.0f, 416.0f)
                curveTo(128.0f, 469.0f, 171.0f, 512.0f, 224.0f, 512.0f)
                curveTo(259.6f, 512.0f, 290.7f, 492.6f, 307.3f, 463.8f)
                curveTo(309.6f, 463.9f, 311.9f, 464.0f, 314.3f, 464.0f)
                lineTo(318.4f, 464.0f)
                curveTo(319.4f, 464.0f, 320.5f, 464.0f, 321.5f, 464.0f)
                lineTo(376.7f, 464.0f)
                curveTo(356.3f, 528.9f, 295.7f, 576.0f, 224.0f, 576.0f)
                curveTo(135.6f, 576.0f, 64.0f, 504.4f, 64.0f, 416.0f)
                curveTo(64.0f, 342.2f, 114.0f, 280.1f, 181.9f, 261.6f)
                close()
                moveTo(330.5f, 233.5f)
                lineTo(354.2f, 352.0f)
                lineTo(414.7f, 352.0f)
                curveTo(448.0f, 352.0f, 477.9f, 372.7f, 489.6f, 403.9f)
                lineTo(515.1f, 471.9f)
                lineTo(533.8f, 465.7f)
                curveTo(550.6f, 460.1f, 568.7f, 469.2f, 574.3f, 485.9f)
                curveTo(579.9f, 502.6f, 570.8f, 520.8f, 554.1f, 526.4f)
                lineTo(506.1f, 542.4f)
                curveTo(489.8f, 547.8f, 472.1f, 539.4f, 466.0f, 523.3f)
                lineTo(429.7f, 426.4f)
                curveTo(427.4f, 420.2f, 421.4f, 416.0f, 414.7f, 416.0f)
                lineTo(328.6f, 416.0f)
                curveTo(328.2f, 416.0f, 327.8f, 416.0f, 327.3f, 416.0f)
                lineTo(314.2f, 416.0f)
                curveTo(283.7f, 416.0f, 257.4f, 394.5f, 251.4f, 364.6f)
                lineTo(229.3f, 253.7f)
                curveTo(222.9f, 221.8f, 247.3f, 192.0f, 279.9f, 192.0f)
                curveTo(304.5f, 192.0f, 325.7f, 209.4f, 330.5f, 233.5f)
                close()
            }
        }
        .build()
        return _wheelchair!!
    }

private var _wheelchair: ImageVector? = null
