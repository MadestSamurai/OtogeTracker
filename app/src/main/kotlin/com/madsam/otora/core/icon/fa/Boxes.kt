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

public val Fa.Boxes: ImageVector
    get() {
        if (_boxes != null) {
            return _boxes!!
        }
        _boxes = Builder(name = "Boxes", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 64.0f)
                lineTo(288.0f, 128.0f)
                curveTo(288.0f, 136.8f, 295.2f, 144.0f, 304.0f, 144.0f)
                lineTo(336.0f, 144.0f)
                curveTo(344.8f, 144.0f, 352.0f, 136.8f, 352.0f, 128.0f)
                lineTo(352.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                curveTo(419.3f, 64.0f, 448.0f, 92.7f, 448.0f, 128.0f)
                lineTo(448.0f, 256.0f)
                curveTo(448.0f, 261.5f, 447.3f, 266.9f, 446.0f, 272.0f)
                lineTo(194.0f, 272.0f)
                curveTo(192.7f, 266.9f, 192.0f, 261.5f, 192.0f, 256.0f)
                lineTo(192.0f, 128.0f)
                curveTo(192.0f, 92.7f, 220.7f, 64.0f, 256.0f, 64.0f)
                lineTo(288.0f, 64.0f)
                close()
                moveTo(384.0f, 576.0f)
                curveTo(372.8f, 576.0f, 362.2f, 573.1f, 353.0f, 568.0f)
                curveTo(362.5f, 551.5f, 368.0f, 532.4f, 368.0f, 512.0f)
                lineTo(368.0f, 384.0f)
                curveTo(368.0f, 363.6f, 362.5f, 344.5f, 353.0f, 328.0f)
                curveTo(362.2f, 322.9f, 372.7f, 320.0f, 384.0f, 320.0f)
                lineTo(416.0f, 320.0f)
                lineTo(416.0f, 384.0f)
                curveTo(416.0f, 392.8f, 423.2f, 400.0f, 432.0f, 400.0f)
                lineTo(464.0f, 400.0f)
                curveTo(472.8f, 400.0f, 480.0f, 392.8f, 480.0f, 384.0f)
                lineTo(480.0f, 320.0f)
                lineTo(512.0f, 320.0f)
                curveTo(547.3f, 320.0f, 576.0f, 348.7f, 576.0f, 384.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 547.3f, 547.3f, 576.0f, 512.0f, 576.0f)
                lineTo(384.0f, 576.0f)
                close()
                moveTo(64.0f, 384.0f)
                curveTo(64.0f, 348.7f, 92.7f, 320.0f, 128.0f, 320.0f)
                lineTo(160.0f, 320.0f)
                lineTo(160.0f, 384.0f)
                curveTo(160.0f, 392.8f, 167.2f, 400.0f, 176.0f, 400.0f)
                lineTo(208.0f, 400.0f)
                curveTo(216.8f, 400.0f, 224.0f, 392.8f, 224.0f, 384.0f)
                lineTo(224.0f, 320.0f)
                lineTo(256.0f, 320.0f)
                curveTo(291.3f, 320.0f, 320.0f, 348.7f, 320.0f, 384.0f)
                lineTo(320.0f, 512.0f)
                curveTo(320.0f, 547.3f, 291.3f, 576.0f, 256.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(92.7f, 576.0f, 64.0f, 547.3f, 64.0f, 512.0f)
                lineTo(64.0f, 384.0f)
                close()
            }
        }
        .build()
        return _boxes!!
    }

private var _boxes: ImageVector? = null
