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

public val Fa.`Beer-mug-empty`: ImageVector
    get() {
        if (`_beer-mug-empty` != null) {
            return `_beer-mug-empty`!!
        }
        `_beer-mug-empty` = Builder(name = "Beer-mug-empty", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 144.0f)
                curveTo(96.0f, 117.5f, 117.5f, 96.0f, 144.0f, 96.0f)
                lineTo(432.0f, 96.0f)
                curveTo(458.5f, 96.0f, 480.0f, 117.5f, 480.0f, 144.0f)
                lineTo(480.0f, 160.0f)
                lineTo(544.0f, 160.0f)
                curveTo(579.3f, 160.0f, 608.0f, 188.7f, 608.0f, 224.0f)
                lineTo(608.0f, 332.2f)
                curveTo(608.0f, 356.4f, 594.3f, 378.6f, 572.6f, 389.4f)
                lineTo(480.0f, 435.8f)
                lineTo(480.0f, 448.0f)
                curveTo(480.0f, 501.0f, 437.0f, 544.0f, 384.0f, 544.0f)
                lineTo(192.0f, 544.0f)
                curveTo(139.0f, 544.0f, 96.0f, 501.0f, 96.0f, 448.0f)
                lineTo(96.0f, 144.0f)
                close()
                moveTo(480.0f, 364.2f)
                lineTo(544.0f, 332.2f)
                lineTo(544.0f, 224.0f)
                lineTo(480.0f, 224.0f)
                lineTo(480.0f, 364.2f)
                close()
                moveTo(224.0f, 216.0f)
                curveTo(224.0f, 202.7f, 213.3f, 192.0f, 200.0f, 192.0f)
                curveTo(186.7f, 192.0f, 176.0f, 202.7f, 176.0f, 216.0f)
                lineTo(176.0f, 424.0f)
                curveTo(176.0f, 437.3f, 186.7f, 448.0f, 200.0f, 448.0f)
                curveTo(213.3f, 448.0f, 224.0f, 437.3f, 224.0f, 424.0f)
                lineTo(224.0f, 216.0f)
                close()
                moveTo(312.0f, 216.0f)
                curveTo(312.0f, 202.7f, 301.3f, 192.0f, 288.0f, 192.0f)
                curveTo(274.7f, 192.0f, 264.0f, 202.7f, 264.0f, 216.0f)
                lineTo(264.0f, 424.0f)
                curveTo(264.0f, 437.3f, 274.7f, 448.0f, 288.0f, 448.0f)
                curveTo(301.3f, 448.0f, 312.0f, 437.3f, 312.0f, 424.0f)
                lineTo(312.0f, 216.0f)
                close()
                moveTo(400.0f, 216.0f)
                curveTo(400.0f, 202.7f, 389.3f, 192.0f, 376.0f, 192.0f)
                curveTo(362.7f, 192.0f, 352.0f, 202.7f, 352.0f, 216.0f)
                lineTo(352.0f, 424.0f)
                curveTo(352.0f, 437.3f, 362.7f, 448.0f, 376.0f, 448.0f)
                curveTo(389.3f, 448.0f, 400.0f, 437.3f, 400.0f, 424.0f)
                lineTo(400.0f, 216.0f)
                close()
            }
        }
        .build()
        return `_beer-mug-empty`!!
    }

private var `_beer-mug-empty`: ImageVector? = null
