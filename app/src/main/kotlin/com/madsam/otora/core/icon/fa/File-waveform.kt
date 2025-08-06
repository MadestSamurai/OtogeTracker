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

public val Fa.`File-waveform`: ImageVector
    get() {
        if (`_file-waveform` != null) {
            return `_file-waveform`!!
        }
        `_file-waveform` = Builder(name = "File-waveform", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(341.5f, 64.0f)
                curveTo(358.5f, 64.0f, 374.8f, 70.7f, 386.8f, 82.7f)
                lineTo(493.3f, 189.3f)
                curveTo(505.3f, 201.3f, 512.0f, 217.6f, 512.0f, 234.6f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 416.0f)
                lineTo(188.3f, 416.0f)
                lineTo(237.1f, 478.7f)
                curveTo(242.2f, 485.3f, 250.4f, 488.7f, 258.7f, 487.8f)
                curveTo(267.0f, 486.9f, 274.2f, 481.7f, 277.8f, 474.2f)
                lineTo(320.7f, 383.0f)
                lineTo(330.6f, 402.8f)
                curveTo(334.7f, 410.9f, 343.0f, 416.1f, 352.1f, 416.1f)
                lineTo(424.1f, 416.1f)
                curveTo(437.4f, 416.1f, 448.1f, 405.4f, 448.1f, 392.1f)
                curveTo(448.1f, 378.8f, 437.4f, 368.1f, 424.1f, 368.1f)
                lineTo(366.9f, 368.1f)
                lineTo(341.5f, 317.4f)
                curveTo(337.4f, 309.2f, 328.9f, 304.0f, 319.7f, 304.1f)
                curveTo(310.5f, 304.2f, 302.2f, 309.6f, 298.3f, 317.9f)
                lineTo(251.0f, 418.5f)
                lineTo(219.0f, 377.4f)
                curveTo(214.4f, 371.4f, 207.4f, 368.0f, 200.0f, 368.0f)
                lineTo(128.0f, 368.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(336.0f, 122.5f)
                lineTo(336.0f, 216.0f)
                curveTo(336.0f, 229.3f, 346.7f, 240.0f, 360.0f, 240.0f)
                lineTo(453.5f, 240.0f)
                lineTo(336.0f, 122.5f)
                close()
            }
        }
        .build()
        return `_file-waveform`!!
    }

private var `_file-waveform`: ImageVector? = null
