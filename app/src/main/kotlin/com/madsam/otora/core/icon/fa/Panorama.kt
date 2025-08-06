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

public val Fa.Panorama: ImageVector
    get() {
        if (_panorama != null) {
            return _panorama!!
        }
        _panorama = Builder(name = "Panorama", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(75.9f, 112.0f)
                curveTo(51.7f, 112.0f, 32.0f, 131.7f, 32.0f, 155.9f)
                lineTo(32.0f, 484.1f)
                curveTo(32.0f, 508.4f, 51.7f, 528.0f, 75.9f, 528.0f)
                curveTo(81.4f, 528.0f, 86.6f, 527.0f, 91.6f, 525.1f)
                curveTo(104.5f, 520.2f, 195.0f, 488.0f, 320.0f, 488.0f)
                curveTo(445.0f, 488.0f, 535.5f, 520.3f, 548.4f, 525.1f)
                curveTo(553.4f, 527.0f, 558.6f, 528.0f, 564.1f, 528.0f)
                curveTo(588.4f, 528.0f, 608.0f, 508.3f, 608.0f, 484.1f)
                lineTo(608.0f, 155.9f)
                curveTo(608.0f, 131.6f, 588.3f, 112.0f, 564.1f, 112.0f)
                curveTo(558.6f, 112.0f, 553.4f, 113.0f, 548.4f, 114.9f)
                curveTo(535.5f, 119.8f, 445.0f, 152.0f, 320.0f, 152.0f)
                curveTo(195.0f, 152.0f, 104.5f, 119.7f, 91.6f, 114.9f)
                curveTo(86.6f, 113.0f, 81.4f, 112.0f, 75.9f, 112.0f)
                close()
                moveTo(104.0f, 240.0f)
                curveTo(104.0f, 217.9f, 121.9f, 200.0f, 144.0f, 200.0f)
                curveTo(166.1f, 200.0f, 184.0f, 217.9f, 184.0f, 240.0f)
                curveTo(184.0f, 262.1f, 166.1f, 280.0f, 144.0f, 280.0f)
                curveTo(121.9f, 280.0f, 104.0f, 262.1f, 104.0f, 240.0f)
                close()
                moveTo(368.1f, 224.0f)
                curveTo(375.6f, 224.0f, 382.7f, 227.6f, 387.2f, 233.6f)
                lineTo(511.7f, 400.2f)
                curveTo(517.6f, 408.1f, 518.1f, 418.7f, 513.0f, 427.1f)
                curveTo(507.9f, 435.5f, 498.2f, 439.9f, 488.5f, 438.2f)
                curveTo(442.7f, 430.4f, 385.2f, 424.0f, 320.1f, 424.0f)
                curveTo(254.5f, 424.0f, 196.7f, 430.5f, 150.8f, 438.4f)
                curveTo(141.0f, 440.1f, 131.1f, 435.5f, 126.1f, 426.9f)
                curveTo(121.1f, 418.3f, 121.8f, 407.5f, 128.0f, 399.7f)
                lineTo(197.3f, 313.0f)
                curveTo(201.9f, 307.3f, 208.8f, 304.0f, 216.0f, 304.0f)
                curveTo(223.2f, 304.0f, 230.2f, 307.3f, 234.7f, 313.0f)
                lineTo(262.2f, 347.4f)
                lineTo(348.9f, 233.5f)
                curveTo(353.5f, 227.5f, 360.6f, 224.0f, 368.1f, 224.0f)
                close()
            }
        }
        .build()
        return _panorama!!
    }

private var _panorama: ImageVector? = null
