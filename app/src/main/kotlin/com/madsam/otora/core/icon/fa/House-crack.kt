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

public val Fa.`House-crack`: ImageVector
    get() {
        if (`_house-crack` != null) {
            return `_house-crack`!!
        }
        `_house-crack` = Builder(name = "House-crack", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(341.8f, 72.6f)
                curveTo(329.5f, 61.2f, 310.5f, 61.2f, 298.3f, 72.6f)
                lineTo(74.3f, 280.6f)
                curveTo(64.7f, 289.6f, 61.5f, 303.5f, 66.3f, 315.7f)
                curveTo(71.1f, 327.9f, 82.8f, 336.0f, 96.0f, 336.0f)
                lineTo(112.0f, 336.0f)
                lineTo(112.0f, 512.0f)
                curveTo(112.0f, 547.3f, 140.7f, 576.0f, 176.0f, 576.0f)
                lineTo(262.4f, 576.0f)
                lineTo(231.1f, 523.8f)
                curveTo(227.0f, 517.0f, 228.5f, 508.3f, 234.6f, 503.3f)
                lineTo(320.0f, 432.0f)
                lineTo(259.8f, 349.2f)
                curveTo(248.9f, 334.2f, 268.0f, 315.7f, 282.6f, 327.2f)
                lineTo(400.5f, 419.8f)
                curveTo(408.5f, 426.1f, 408.7f, 438.2f, 400.9f, 444.7f)
                lineTo(320.0f, 512.0f)
                lineTo(358.4f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(499.3f, 576.0f, 528.0f, 547.3f, 528.0f, 512.0f)
                lineTo(528.0f, 336.0f)
                lineTo(544.0f, 336.0f)
                curveTo(557.2f, 336.0f, 569.0f, 327.9f, 573.8f, 315.7f)
                curveTo(578.6f, 303.5f, 575.4f, 289.5f, 565.8f, 280.6f)
                lineTo(341.8f, 72.6f)
                close()
            }
        }
        .build()
        return `_house-crack`!!
    }

private var `_house-crack`: ImageVector? = null
