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

public val Fa.Heptagon: ImageVector
    get() {
        if (_heptagon != null) {
            return _heptagon!!
        }
        _heptagon = Builder(name = "Heptagon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(299.4f, 32.5f)
                curveTo(315.3f, 27.0f, 332.9f, 27.9f, 348.2f, 35.2f)
                lineTo(520.6f, 118.2f)
                lineTo(526.9f, 121.7f)
                curveTo(541.1f, 130.7f, 551.4f, 145.0f, 555.2f, 161.6f)
                lineTo(597.8f, 348.1f)
                lineTo(599.0f, 355.3f)
                curveTo(600.6f, 369.6f, 597.3f, 384.1f, 589.6f, 396.4f)
                lineTo(585.4f, 402.3f)
                lineTo(466.1f, 551.9f)
                curveTo(454.0f, 567.1f, 435.5f, 576.0f, 416.1f, 576.0f)
                lineTo(224.8f, 576.0f)
                curveTo(205.3f, 576.0f, 186.9f, 567.1f, 174.8f, 551.9f)
                lineTo(55.5f, 402.4f)
                curveTo(43.4f, 387.2f, 38.8f, 367.2f, 43.2f, 348.2f)
                lineTo(85.8f, 161.7f)
                lineTo(87.8f, 154.7f)
                curveTo(93.4f, 138.8f, 105.0f, 125.7f, 120.4f, 118.3f)
                lineTo(292.8f, 35.3f)
                lineTo(299.5f, 32.6f)
                close()
            }
        }
        .build()
        return _heptagon!!
    }

private var _heptagon: ImageVector? = null
