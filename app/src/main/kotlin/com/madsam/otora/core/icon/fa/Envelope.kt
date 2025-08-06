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

public val Fa.Envelope: ImageVector
    get() {
        if (_envelope != null) {
            return _envelope!!
        }
        _envelope = Builder(name = "Envelope", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(112.0f, 128.0f)
                curveTo(85.5f, 128.0f, 64.0f, 149.5f, 64.0f, 176.0f)
                curveTo(64.0f, 191.1f, 71.1f, 205.3f, 83.2f, 214.4f)
                lineTo(291.2f, 370.4f)
                curveTo(308.3f, 383.2f, 331.7f, 383.2f, 348.8f, 370.4f)
                lineTo(556.8f, 214.4f)
                curveTo(568.9f, 205.3f, 576.0f, 191.1f, 576.0f, 176.0f)
                curveTo(576.0f, 149.5f, 554.5f, 128.0f, 528.0f, 128.0f)
                lineTo(112.0f, 128.0f)
                close()
                moveTo(64.0f, 260.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 260.0f)
                lineTo(377.6f, 408.8f)
                curveTo(343.5f, 434.4f, 296.5f, 434.4f, 262.4f, 408.8f)
                lineTo(64.0f, 260.0f)
                close()
            }
        }
        .build()
        return _envelope!!
    }

private var _envelope: ImageVector? = null
