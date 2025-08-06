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

public val Fa.`File-powerpoint`: ImageVector
    get() {
        if (`_file-powerpoint` != null) {
            return `_file-powerpoint`!!
        }
        `_file-powerpoint` = Builder(name = "File-powerpoint", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(280.0f, 320.0f)
                curveTo(266.7f, 320.0f, 256.0f, 330.7f, 256.0f, 344.0f)
                lineTo(256.0f, 488.0f)
                curveTo(256.0f, 501.3f, 266.7f, 512.0f, 280.0f, 512.0f)
                curveTo(293.3f, 512.0f, 304.0f, 501.3f, 304.0f, 488.0f)
                lineTo(304.0f, 464.0f)
                lineTo(328.0f, 464.0f)
                curveTo(367.8f, 464.0f, 400.0f, 431.8f, 400.0f, 392.0f)
                curveTo(400.0f, 352.2f, 367.8f, 320.0f, 328.0f, 320.0f)
                lineTo(280.0f, 320.0f)
                close()
                moveTo(328.0f, 416.0f)
                lineTo(304.0f, 416.0f)
                lineTo(304.0f, 368.0f)
                lineTo(328.0f, 368.0f)
                curveTo(341.3f, 368.0f, 352.0f, 378.7f, 352.0f, 392.0f)
                curveTo(352.0f, 405.3f, 341.3f, 416.0f, 328.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_file-powerpoint`!!
    }

private var `_file-powerpoint`: ImageVector? = null
