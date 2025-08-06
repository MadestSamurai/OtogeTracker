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

public val Fa.`Box-open`: ImageVector
    get() {
        if (`_box-open` != null) {
            return `_box-open`!!
        }
        `_box-open` = Builder(name = "Box-open", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(560.3f, 301.2f)
                curveTo(570.7f, 313.0f, 588.6f, 315.6f, 602.1f, 306.7f)
                curveTo(616.8f, 296.9f, 620.8f, 277.0f, 611.0f, 262.3f)
                lineTo(563.0f, 190.3f)
                curveTo(560.2f, 186.1f, 556.4f, 182.6f, 551.9f, 180.1f)
                lineTo(351.4f, 68.7f)
                curveTo(332.1f, 58.0f, 308.6f, 58.0f, 289.2f, 68.7f)
                lineTo(88.8f, 180.0f)
                curveTo(83.4f, 183.0f, 79.1f, 187.4f, 76.2f, 192.8f)
                lineTo(27.7f, 282.7f)
                curveTo(15.1f, 306.1f, 23.9f, 335.2f, 47.3f, 347.8f)
                lineTo(80.3f, 365.5f)
                lineTo(80.3f, 418.8f)
                curveTo(80.3f, 441.8f, 92.7f, 463.1f, 112.7f, 474.5f)
                lineTo(288.7f, 574.2f)
                curveTo(308.3f, 585.3f, 332.2f, 585.3f, 351.8f, 574.2f)
                lineTo(527.8f, 474.5f)
                curveTo(547.9f, 463.1f, 560.2f, 441.9f, 560.2f, 418.8f)
                lineTo(560.2f, 301.3f)
                close()
                moveTo(320.3f, 291.4f)
                lineTo(170.2f, 208.0f)
                lineTo(320.3f, 124.6f)
                lineTo(470.4f, 208.0f)
                lineTo(320.3f, 291.4f)
                close()
                moveTo(278.8f, 341.6f)
                lineTo(257.5f, 387.8f)
                lineTo(91.7f, 299.0f)
                lineTo(117.1f, 251.8f)
                lineTo(278.8f, 341.6f)
                close()
            }
        }
        .build()
        return `_box-open`!!
    }

private var `_box-open`: ImageVector? = null
