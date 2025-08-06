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

public val Fa.`Hat-cowboy`: ImageVector
    get() {
        if (`_hat-cowboy` != null) {
            return `_hat-cowboy`!!
        }
        `_hat-cowboy` = Builder(name = "Hat-cowboy", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(182.2f, 140.1f)
                lineTo(130.8f, 371.5f)
                curveTo(145.5f, 388.9f, 167.4f, 400.0f, 192.0f, 400.0f)
                lineTo(448.0f, 400.0f)
                curveTo(472.6f, 400.0f, 494.5f, 388.9f, 509.2f, 371.5f)
                lineTo(457.8f, 140.1f)
                curveTo(452.1f, 114.3f, 429.2f, 96.0f, 402.8f, 96.0f)
                curveTo(390.6f, 96.0f, 378.7f, 100.0f, 369.0f, 107.3f)
                lineTo(364.3f, 110.8f)
                curveTo(338.0f, 130.5f, 301.9f, 130.5f, 275.7f, 110.8f)
                lineTo(271.0f, 107.3f)
                curveTo(261.2f, 100.0f, 249.4f, 96.0f, 237.2f, 96.0f)
                curveTo(210.8f, 96.0f, 187.9f, 114.3f, 182.2f, 140.1f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 302.3f, 49.7f, 288.0f, 32.0f, 288.0f)
                curveTo(14.3f, 288.0f, 0.0f, 302.3f, 0.0f, 320.0f)
                curveTo(0.0f, 426.0f, 86.0f, 512.0f, 192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                curveTo(554.0f, 512.0f, 640.0f, 426.0f, 640.0f, 320.0f)
                curveTo(640.0f, 302.3f, 625.7f, 288.0f, 608.0f, 288.0f)
                curveTo(590.3f, 288.0f, 576.0f, 302.3f, 576.0f, 320.0f)
                curveTo(576.0f, 390.7f, 518.7f, 448.0f, 448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(121.3f, 448.0f, 64.0f, 390.7f, 64.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_hat-cowboy`!!
    }

private var `_hat-cowboy`: ImageVector? = null
