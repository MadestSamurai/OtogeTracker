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

public val Fa.`File-video`: ImageVector
    get() {
        if (`_file-video` != null) {
            return `_file-video`!!
        }
        `_file-video` = Builder(name = "File-video", defaultWidth = 640.0.dp, defaultHeight =
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
                lineTo(128.0f, 128.0f)
                close()
                moveTo(336.0f, 122.5f)
                lineTo(336.0f, 216.0f)
                curveTo(336.0f, 229.3f, 346.7f, 240.0f, 360.0f, 240.0f)
                lineTo(453.5f, 240.0f)
                lineTo(336.0f, 122.5f)
                close()
                moveTo(208.0f, 368.0f)
                lineTo(208.0f, 464.0f)
                curveTo(208.0f, 481.7f, 222.3f, 496.0f, 240.0f, 496.0f)
                lineTo(336.0f, 496.0f)
                curveTo(353.7f, 496.0f, 368.0f, 481.7f, 368.0f, 464.0f)
                lineTo(368.0f, 440.0f)
                lineTo(403.0f, 475.0f)
                curveTo(406.2f, 478.2f, 410.5f, 480.0f, 415.0f, 480.0f)
                curveTo(424.4f, 480.0f, 432.0f, 472.4f, 432.0f, 463.0f)
                lineTo(432.0f, 368.9f)
                curveTo(432.0f, 359.5f, 424.4f, 351.9f, 415.0f, 351.9f)
                curveTo(410.5f, 351.9f, 406.2f, 353.7f, 403.0f, 356.9f)
                lineTo(368.0f, 391.9f)
                lineTo(368.0f, 367.9f)
                curveTo(368.0f, 350.2f, 353.7f, 335.9f, 336.0f, 335.9f)
                lineTo(240.0f, 335.9f)
                curveTo(222.3f, 335.9f, 208.0f, 350.2f, 208.0f, 367.9f)
                close()
            }
        }
        .build()
        return `_file-video`!!
    }

private var `_file-video`: ImageVector? = null
