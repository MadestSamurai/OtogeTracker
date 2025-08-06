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

public val Fa.Seedling: ImageVector
    get() {
        if (_seedling != null) {
            return _seedling!!
        }
        _seedling = Builder(name = "Seedling", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 96.0f)
                curveTo(576.0f, 204.1f, 499.4f, 294.3f, 397.6f, 315.4f)
                curveTo(389.7f, 257.3f, 363.6f, 205.0f, 325.1f, 164.5f)
                curveTo(365.2f, 104.0f, 433.9f, 64.0f, 512.0f, 64.0f)
                lineTo(544.0f, 64.0f)
                curveTo(561.7f, 64.0f, 576.0f, 78.3f, 576.0f, 96.0f)
                close()
                moveTo(64.0f, 160.0f)
                curveTo(64.0f, 142.3f, 78.3f, 128.0f, 96.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                curveTo(251.7f, 128.0f, 352.0f, 228.3f, 352.0f, 352.0f)
                lineTo(352.0f, 544.0f)
                curveTo(352.0f, 561.7f, 337.7f, 576.0f, 320.0f, 576.0f)
                curveTo(302.3f, 576.0f, 288.0f, 561.7f, 288.0f, 544.0f)
                lineTo(288.0f, 384.0f)
                curveTo(164.3f, 384.0f, 64.0f, 283.7f, 64.0f, 160.0f)
                close()
            }
        }
        .build()
        return _seedling!!
    }

private var _seedling: ImageVector? = null
