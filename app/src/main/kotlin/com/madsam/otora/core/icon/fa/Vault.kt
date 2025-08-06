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

public val Fa.Vault: ImageVector
    get() {
        if (_vault != null) {
            return _vault!!
        }
        _vault = Builder(name = "Vault", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                curveTo(128.0f, 561.7f, 142.3f, 576.0f, 160.0f, 576.0f)
                curveTo(177.7f, 576.0f, 192.0f, 561.7f, 192.0f, 544.0f)
                lineTo(448.0f, 544.0f)
                curveTo(448.0f, 561.7f, 462.3f, 576.0f, 480.0f, 576.0f)
                curveTo(497.7f, 576.0f, 512.0f, 561.7f, 512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 160.0f)
                curveTo(576.0f, 124.7f, 547.3f, 96.0f, 512.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                close()
                moveTo(320.0f, 320.0f)
                curveTo(320.0f, 284.7f, 291.3f, 256.0f, 256.0f, 256.0f)
                curveTo(220.7f, 256.0f, 192.0f, 284.7f, 192.0f, 320.0f)
                curveTo(192.0f, 355.3f, 220.7f, 384.0f, 256.0f, 384.0f)
                curveTo(291.3f, 384.0f, 320.0f, 355.3f, 320.0f, 320.0f)
                close()
                moveTo(128.0f, 320.0f)
                curveTo(128.0f, 249.3f, 185.3f, 192.0f, 256.0f, 192.0f)
                curveTo(326.7f, 192.0f, 384.0f, 249.3f, 384.0f, 320.0f)
                curveTo(384.0f, 390.7f, 326.7f, 448.0f, 256.0f, 448.0f)
                curveTo(185.3f, 448.0f, 128.0f, 390.7f, 128.0f, 320.0f)
                close()
                moveTo(512.0f, 272.0f)
                curveTo(512.0f, 289.8f, 502.3f, 305.3f, 488.0f, 313.6f)
                lineTo(488.0f, 392.0f)
                curveTo(488.0f, 405.3f, 477.3f, 416.0f, 464.0f, 416.0f)
                curveTo(450.7f, 416.0f, 440.0f, 405.3f, 440.0f, 392.0f)
                lineTo(440.0f, 313.6f)
                curveTo(425.7f, 305.3f, 416.0f, 289.8f, 416.0f, 272.0f)
                curveTo(416.0f, 245.5f, 437.5f, 224.0f, 464.0f, 224.0f)
                curveTo(490.5f, 224.0f, 512.0f, 245.5f, 512.0f, 272.0f)
                close()
            }
        }
        .build()
        return _vault!!
    }

private var _vault: ImageVector? = null
