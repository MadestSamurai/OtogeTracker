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

public val Fa.`File-upload`: ImageVector
    get() {
        if (`_file-upload` != null) {
            return `_file-upload`!!
        }
        `_file-upload` = Builder(name = "File-upload", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(337.0f, 327.0f)
                curveTo(327.6f, 317.6f, 312.4f, 317.6f, 303.1f, 327.0f)
                lineTo(239.1f, 391.0f)
                curveTo(229.7f, 400.4f, 229.7f, 415.6f, 239.1f, 424.9f)
                curveTo(248.5f, 434.2f, 263.7f, 434.3f, 273.0f, 424.9f)
                lineTo(296.0f, 401.9f)
                lineTo(296.0f, 488.0f)
                curveTo(296.0f, 501.3f, 306.7f, 512.0f, 320.0f, 512.0f)
                curveTo(333.3f, 512.0f, 344.0f, 501.3f, 344.0f, 488.0f)
                lineTo(344.0f, 401.9f)
                lineTo(367.0f, 424.9f)
                curveTo(376.4f, 434.3f, 391.6f, 434.3f, 400.9f, 424.9f)
                curveTo(410.2f, 415.5f, 410.3f, 400.3f, 400.9f, 391.0f)
                lineTo(336.9f, 327.0f)
                close()
            }
        }
        .build()
        return `_file-upload`!!
    }

private var `_file-upload`: ImageVector? = null
