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

public val Fa.`File-word`: ImageVector
    get() {
        if (`_file-word` != null) {
            return `_file-word`!!
        }
        `_file-word` = Builder(name = "File-word", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(263.4f, 338.8f)
                curveTo(260.5f, 325.9f, 247.7f, 317.7f, 234.8f, 320.6f)
                curveTo(221.9f, 323.5f, 213.7f, 336.3f, 216.6f, 349.2f)
                lineTo(248.6f, 493.2f)
                curveTo(250.9f, 503.7f, 260.0f, 511.4f, 270.8f, 512.0f)
                curveTo(281.6f, 512.6f, 291.4f, 505.9f, 294.8f, 495.6f)
                lineTo(320.0f, 419.9f)
                lineTo(345.2f, 495.6f)
                curveTo(348.6f, 505.8f, 358.4f, 512.5f, 369.2f, 512.0f)
                curveTo(380.0f, 511.5f, 389.1f, 503.8f, 391.4f, 493.2f)
                lineTo(423.4f, 349.2f)
                curveTo(426.3f, 336.3f, 418.1f, 323.4f, 405.2f, 320.6f)
                curveTo(392.3f, 317.8f, 379.4f, 325.9f, 376.6f, 338.8f)
                lineTo(363.4f, 398.2f)
                lineTo(342.8f, 336.4f)
                curveTo(339.5f, 326.6f, 330.4f, 320.0f, 320.0f, 320.0f)
                curveTo(309.6f, 320.0f, 300.5f, 326.6f, 297.2f, 336.4f)
                lineTo(276.6f, 398.2f)
                lineTo(263.4f, 338.8f)
                close()
            }
        }
        .build()
        return `_file-word`!!
    }

private var `_file-word`: ImageVector? = null
