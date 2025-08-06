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

public val Fa.Tags: ImageVector
    get() {
        if (_tags != null) {
            return _tags!!
        }
        _tags = Builder(name = "Tags", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(433.2f, 103.1f)
                lineTo(581.4f, 253.4f)
                curveTo(609.1f, 281.5f, 609.1f, 326.5f, 581.4f, 354.6f)
                lineTo(425.0f, 512.9f)
                curveTo(415.7f, 522.3f, 400.5f, 522.4f, 391.1f, 513.1f)
                curveTo(381.7f, 503.8f, 381.6f, 488.6f, 390.9f, 479.2f)
                lineTo(547.3f, 320.8f)
                curveTo(556.5f, 311.5f, 556.5f, 296.4f, 547.3f, 287.1f)
                lineTo(399.0f, 136.9f)
                curveTo(389.7f, 127.5f, 389.8f, 112.3f, 399.2f, 103.0f)
                curveTo(408.6f, 93.7f, 423.8f, 93.8f, 433.1f, 103.2f)
                close()
                moveTo(64.1f, 293.5f)
                lineTo(64.1f, 160.0f)
                curveTo(64.1f, 124.7f, 92.8f, 96.0f, 128.1f, 96.0f)
                lineTo(261.6f, 96.0f)
                curveTo(278.6f, 96.0f, 294.9f, 102.7f, 306.9f, 114.7f)
                lineTo(450.9f, 258.7f)
                curveTo(475.9f, 283.7f, 475.9f, 324.2f, 450.9f, 349.2f)
                lineTo(317.4f, 482.7f)
                curveTo(292.4f, 507.7f, 251.9f, 507.7f, 226.9f, 482.7f)
                lineTo(82.9f, 338.7f)
                curveTo(70.9f, 326.7f, 64.2f, 310.4f, 64.2f, 293.4f)
                close()
                moveTo(208.1f, 208.0f)
                curveTo(208.1f, 190.3f, 193.8f, 176.0f, 176.1f, 176.0f)
                curveTo(158.4f, 176.0f, 144.1f, 190.3f, 144.1f, 208.0f)
                curveTo(144.1f, 225.7f, 158.4f, 240.0f, 176.1f, 240.0f)
                curveTo(193.8f, 240.0f, 208.1f, 225.7f, 208.1f, 208.0f)
                close()
            }
        }
        .build()
        return _tags!!
    }

private var _tags: ImageVector? = null
