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

public val Fa.Landmark: ImageVector
    get() {
        if (_landmark != null) {
            return _landmark!!
        }
        _landmark = Builder(name = "Landmark", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(302.7f, 69.1f)
                curveTo(313.2f, 62.3f, 326.8f, 62.3f, 337.3f, 69.1f)
                lineTo(561.3f, 213.1f)
                curveTo(573.2f, 220.8f, 578.7f, 235.4f, 574.7f, 249.0f)
                curveTo(570.7f, 262.6f, 558.2f, 272.0f, 544.0f, 272.0f)
                lineTo(512.0f, 272.0f)
                lineTo(512.0f, 480.0f)
                lineTo(563.2f, 518.4f)
                curveTo(571.3f, 524.4f, 576.0f, 533.9f, 576.0f, 544.0f)
                curveTo(576.0f, 561.7f, 561.7f, 576.0f, 544.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(78.3f, 576.0f, 64.0f, 561.7f, 64.0f, 544.0f)
                curveTo(64.0f, 533.9f, 68.7f, 524.4f, 76.8f, 518.4f)
                lineTo(128.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                lineTo(128.0f, 272.0f)
                lineTo(96.0f, 272.0f)
                curveTo(81.8f, 272.0f, 69.3f, 262.6f, 65.3f, 249.0f)
                curveTo(61.3f, 235.4f, 66.8f, 220.7f, 78.7f, 213.1f)
                lineTo(302.7f, 69.1f)
                close()
                moveTo(400.0f, 272.0f)
                lineTo(400.0f, 480.0f)
                lineTo(464.0f, 480.0f)
                lineTo(464.0f, 272.0f)
                lineTo(400.0f, 272.0f)
                close()
                moveTo(288.0f, 480.0f)
                lineTo(352.0f, 480.0f)
                lineTo(352.0f, 272.0f)
                lineTo(288.0f, 272.0f)
                lineTo(288.0f, 480.0f)
                close()
                moveTo(176.0f, 272.0f)
                lineTo(176.0f, 480.0f)
                lineTo(240.0f, 480.0f)
                lineTo(240.0f, 272.0f)
                lineTo(176.0f, 272.0f)
                close()
            }
        }
        .build()
        return _landmark!!
    }

private var _landmark: ImageVector? = null
