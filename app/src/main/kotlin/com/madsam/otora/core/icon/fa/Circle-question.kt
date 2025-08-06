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

public val Fa.`Circle-question`: ImageVector
    get() {
        if (`_circle-question` != null) {
            return `_circle-question`!!
        }
        `_circle-question` = Builder(name = "Circle-question", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(320.0f, 240.0f)
                curveTo(302.3f, 240.0f, 288.0f, 254.3f, 288.0f, 272.0f)
                curveTo(288.0f, 285.3f, 277.3f, 296.0f, 264.0f, 296.0f)
                curveTo(250.7f, 296.0f, 240.0f, 285.3f, 240.0f, 272.0f)
                curveTo(240.0f, 227.8f, 275.8f, 192.0f, 320.0f, 192.0f)
                curveTo(364.2f, 192.0f, 400.0f, 227.8f, 400.0f, 272.0f)
                curveTo(400.0f, 319.2f, 364.0f, 339.2f, 344.0f, 346.5f)
                lineTo(344.0f, 350.3f)
                curveTo(344.0f, 363.6f, 333.3f, 374.3f, 320.0f, 374.3f)
                curveTo(306.7f, 374.3f, 296.0f, 363.6f, 296.0f, 350.3f)
                lineTo(296.0f, 342.2f)
                curveTo(296.0f, 321.7f, 310.8f, 307.0f, 326.1f, 302.0f)
                curveTo(332.5f, 299.9f, 339.3f, 296.5f, 344.3f, 291.7f)
                curveTo(348.6f, 287.5f, 352.0f, 281.7f, 352.0f, 272.1f)
                curveTo(352.0f, 254.4f, 337.7f, 240.1f, 320.0f, 240.1f)
                close()
                moveTo(288.0f, 432.0f)
                curveTo(288.0f, 414.3f, 302.3f, 400.0f, 320.0f, 400.0f)
                curveTo(337.7f, 400.0f, 352.0f, 414.3f, 352.0f, 432.0f)
                curveTo(352.0f, 449.7f, 337.7f, 464.0f, 320.0f, 464.0f)
                curveTo(302.3f, 464.0f, 288.0f, 449.7f, 288.0f, 432.0f)
                close()
            }
        }
        .build()
        return `_circle-question`!!
    }

private var `_circle-question`: ImageVector? = null
