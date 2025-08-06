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

public val Fa.`Search-location`: ImageVector
    get() {
        if (`_search-location` != null) {
            return `_search-location`!!
        }
        `_search-location` = Builder(name = "Search-location", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(352.0f, 240.0f)
                curveTo(352.0f, 195.8f, 316.2f, 160.0f, 272.0f, 160.0f)
                curveTo(227.8f, 160.0f, 192.0f, 195.8f, 192.0f, 240.0f)
                curveTo(192.0f, 288.8f, 238.5f, 351.6f, 260.6f, 378.6f)
                curveTo(266.6f, 385.9f, 277.4f, 385.9f, 283.3f, 378.6f)
                curveTo(305.4f, 351.6f, 351.9f, 288.8f, 351.9f, 240.0f)
                close()
                moveTo(240.0f, 240.0f)
                curveTo(240.0f, 222.3f, 254.3f, 208.0f, 272.0f, 208.0f)
                curveTo(289.7f, 208.0f, 304.0f, 222.3f, 304.0f, 240.0f)
                curveTo(304.0f, 257.7f, 289.7f, 272.0f, 272.0f, 272.0f)
                curveTo(254.3f, 272.0f, 240.0f, 257.7f, 240.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_search-location`!!
    }

private var `_search-location`: ImageVector? = null
