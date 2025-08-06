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

public val Fa.`Search-minus`: ImageVector
    get() {
        if (`_search-minus` != null) {
            return `_search-minus`!!
        }
        `_search-minus` = Builder(name = "Search-minus", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 272.0f)
                curveTo(480.0f, 317.9f, 465.1f, 360.3f, 440.0f, 394.7f)
                lineTo(566.6f, 521.4f)
                curveTo(579.1f, 533.9f, 579.1f, 554.2f, 566.6f, 566.7f)
                curveTo(554.1f, 579.2f, 533.8f, 579.2f, 521.3f, 566.7f)
                lineTo(394.7f, 440.0f)
                curveTo(360.3f, 465.1f, 317.9f, 480.0f, 272.0f, 480.0f)
                curveTo(157.1f, 480.0f, 64.0f, 386.9f, 64.0f, 272.0f)
                curveTo(64.0f, 157.1f, 157.1f, 64.0f, 272.0f, 64.0f)
                curveTo(386.9f, 64.0f, 480.0f, 157.1f, 480.0f, 272.0f)
                close()
                moveTo(200.0f, 248.0f)
                curveTo(186.7f, 248.0f, 176.0f, 258.7f, 176.0f, 272.0f)
                curveTo(176.0f, 285.3f, 186.7f, 296.0f, 200.0f, 296.0f)
                lineTo(344.0f, 296.0f)
                curveTo(357.3f, 296.0f, 368.0f, 285.3f, 368.0f, 272.0f)
                curveTo(368.0f, 258.7f, 357.3f, 248.0f, 344.0f, 248.0f)
                lineTo(200.0f, 248.0f)
                close()
            }
        }
        .build()
        return `_search-minus`!!
    }

private var `_search-minus`: ImageVector? = null
