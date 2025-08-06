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

public val Fa.`House-chimney-crack`: ImageVector
    get() {
        if (`_house-chimney-crack` != null) {
            return `_house-chimney-crack`!!
        }
        `_house-chimney-crack` = Builder(name = "House-chimney-crack", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(298.2f, 72.6f)
                curveTo(310.5f, 61.2f, 329.5f, 61.2f, 341.7f, 72.6f)
                lineTo(432.0f, 156.3f)
                lineTo(432.0f, 144.0f)
                curveTo(432.0f, 126.3f, 446.3f, 112.0f, 464.0f, 112.0f)
                lineTo(496.0f, 112.0f)
                curveTo(513.7f, 112.0f, 528.0f, 126.3f, 528.0f, 144.0f)
                lineTo(528.0f, 245.5f)
                lineTo(565.8f, 280.6f)
                curveTo(575.4f, 289.6f, 578.6f, 303.5f, 573.8f, 315.7f)
                curveTo(569.0f, 327.9f, 557.2f, 336.0f, 544.0f, 336.0f)
                lineTo(528.0f, 336.0f)
                lineTo(528.0f, 512.0f)
                curveTo(528.0f, 547.3f, 499.3f, 576.0f, 464.0f, 576.0f)
                lineTo(358.4f, 576.0f)
                lineTo(320.0f, 512.0f)
                lineTo(400.8f, 444.7f)
                curveTo(408.6f, 438.2f, 408.4f, 426.1f, 400.4f, 419.8f)
                lineTo(282.6f, 327.2f)
                curveTo(268.0f, 315.7f, 248.8f, 334.2f, 259.8f, 349.2f)
                lineTo(320.0f, 432.0f)
                lineTo(234.5f, 503.2f)
                curveTo(228.4f, 508.2f, 227.0f, 517.0f, 231.0f, 523.7f)
                lineTo(262.3f, 575.9f)
                lineTo(175.9f, 575.9f)
                curveTo(140.6f, 575.9f, 111.9f, 547.2f, 111.9f, 511.9f)
                lineTo(111.9f, 335.9f)
                lineTo(95.9f, 335.9f)
                curveTo(82.7f, 335.9f, 70.9f, 327.8f, 66.1f, 315.6f)
                curveTo(61.3f, 303.4f, 64.5f, 289.4f, 74.1f, 280.5f)
                lineTo(298.1f, 72.5f)
                close()
            }
        }
        .build()
        return `_house-chimney-crack`!!
    }

private var `_house-chimney-crack`: ImageVector? = null
