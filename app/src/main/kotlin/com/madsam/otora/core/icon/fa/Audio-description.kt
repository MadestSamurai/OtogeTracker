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

public val Fa.`Audio-description`: ImageVector
    get() {
        if (`_audio-description` != null) {
            return `_audio-description`!!
        }
        `_audio-description` = Builder(name = "Audio-description", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                curveTo(547.3f, 128.0f, 576.0f, 156.7f, 576.0f, 192.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                close()
                moveTo(160.0f, 288.0f)
                lineTo(160.0f, 392.0f)
                curveTo(160.0f, 405.3f, 170.7f, 416.0f, 184.0f, 416.0f)
                curveTo(197.3f, 416.0f, 208.0f, 405.3f, 208.0f, 392.0f)
                lineTo(208.0f, 368.0f)
                lineTo(256.0f, 368.0f)
                lineTo(256.0f, 392.0f)
                curveTo(256.0f, 405.3f, 266.7f, 416.0f, 280.0f, 416.0f)
                curveTo(293.3f, 416.0f, 304.0f, 405.3f, 304.0f, 392.0f)
                lineTo(304.0f, 288.0f)
                curveTo(304.0f, 252.7f, 275.3f, 224.0f, 240.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                curveTo(188.7f, 224.0f, 160.0f, 252.7f, 160.0f, 288.0f)
                close()
                moveTo(208.0f, 320.0f)
                lineTo(208.0f, 288.0f)
                curveTo(208.0f, 279.2f, 215.2f, 272.0f, 224.0f, 272.0f)
                lineTo(240.0f, 272.0f)
                curveTo(248.8f, 272.0f, 256.0f, 279.2f, 256.0f, 288.0f)
                lineTo(256.0f, 320.0f)
                lineTo(208.0f, 320.0f)
                close()
                moveTo(360.0f, 224.0f)
                curveTo(346.7f, 224.0f, 336.0f, 234.7f, 336.0f, 248.0f)
                lineTo(336.0f, 392.0f)
                curveTo(336.0f, 405.3f, 346.7f, 416.0f, 360.0f, 416.0f)
                lineTo(408.0f, 416.0f)
                curveTo(447.8f, 416.0f, 480.0f, 383.8f, 480.0f, 344.0f)
                lineTo(480.0f, 296.0f)
                curveTo(480.0f, 256.2f, 447.8f, 224.0f, 408.0f, 224.0f)
                lineTo(360.0f, 224.0f)
                close()
                moveTo(408.0f, 368.0f)
                lineTo(384.0f, 368.0f)
                lineTo(384.0f, 272.0f)
                lineTo(408.0f, 272.0f)
                curveTo(421.3f, 272.0f, 432.0f, 282.7f, 432.0f, 296.0f)
                lineTo(432.0f, 344.0f)
                curveTo(432.0f, 357.3f, 421.3f, 368.0f, 408.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_audio-description`!!
    }

private var `_audio-description`: ImageVector? = null
