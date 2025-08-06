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

public val Fa.`File-image`: ImageVector
    get() {
        if (`_file-image` != null) {
            return `_file-image`!!
        }
        `_file-image` = Builder(name = "File-image", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(256.0f, 320.0f)
                curveTo(256.0f, 302.3f, 241.7f, 288.0f, 224.0f, 288.0f)
                curveTo(206.3f, 288.0f, 192.0f, 302.3f, 192.0f, 320.0f)
                curveTo(192.0f, 337.7f, 206.3f, 352.0f, 224.0f, 352.0f)
                curveTo(241.7f, 352.0f, 256.0f, 337.7f, 256.0f, 320.0f)
                close()
                moveTo(220.6f, 512.0f)
                lineTo(419.4f, 512.0f)
                curveTo(435.2f, 512.0f, 448.0f, 499.2f, 448.0f, 483.4f)
                curveTo(448.0f, 476.1f, 445.2f, 469.0f, 440.1f, 463.7f)
                lineTo(343.3f, 361.9f)
                curveTo(337.3f, 355.6f, 328.9f, 352.0f, 320.1f, 352.0f)
                lineTo(319.8f, 352.0f)
                curveTo(311.0f, 352.0f, 302.7f, 355.6f, 296.6f, 361.9f)
                lineTo(199.9f, 463.7f)
                curveTo(194.8f, 469.0f, 192.0f, 476.1f, 192.0f, 483.4f)
                curveTo(192.0f, 499.2f, 204.8f, 512.0f, 220.6f, 512.0f)
                close()
            }
        }
        .build()
        return `_file-image`!!
    }

private var `_file-image`: ImageVector? = null
