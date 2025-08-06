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

public val Fa.`Bottle-water`: ImageVector
    get() {
        if (`_bottle-water` != null) {
            return `_bottle-water`!!
        }
        `_bottle-water` = Builder(name = "Bottle-water", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.0f, 32.0f)
                lineTo(368.0f, 32.0f)
                curveTo(385.7f, 32.0f, 400.0f, 46.3f, 400.0f, 64.0f)
                curveTo(400.0f, 81.7f, 385.7f, 96.0f, 368.0f, 96.0f)
                lineTo(272.0f, 96.0f)
                curveTo(254.3f, 96.0f, 240.0f, 81.7f, 240.0f, 64.0f)
                curveTo(240.0f, 46.3f, 254.3f, 32.0f, 272.0f, 32.0f)
                close()
                moveTo(176.0f, 208.0f)
                curveTo(176.0f, 172.7f, 204.7f, 144.0f, 240.0f, 144.0f)
                lineTo(400.0f, 144.0f)
                curveTo(435.3f, 144.0f, 464.0f, 172.7f, 464.0f, 208.0f)
                curveTo(464.0f, 232.1f, 450.7f, 253.1f, 431.0f, 264.0f)
                curveTo(450.7f, 274.9f, 464.0f, 295.9f, 464.0f, 320.0f)
                curveTo(464.0f, 344.1f, 450.7f, 365.1f, 431.0f, 376.0f)
                curveTo(450.7f, 386.9f, 464.0f, 407.9f, 464.0f, 432.0f)
                curveTo(464.0f, 456.1f, 450.7f, 477.1f, 431.0f, 488.0f)
                curveTo(450.7f, 498.9f, 464.0f, 519.9f, 464.0f, 544.0f)
                curveTo(464.0f, 579.3f, 435.3f, 608.0f, 400.0f, 608.0f)
                lineTo(240.0f, 608.0f)
                curveTo(204.7f, 608.0f, 176.0f, 579.3f, 176.0f, 544.0f)
                curveTo(176.0f, 519.9f, 189.3f, 498.9f, 209.0f, 488.0f)
                curveTo(189.3f, 477.1f, 176.0f, 456.1f, 176.0f, 432.0f)
                curveTo(176.0f, 407.9f, 189.3f, 386.9f, 209.0f, 376.0f)
                curveTo(189.3f, 365.1f, 176.0f, 344.1f, 176.0f, 320.0f)
                curveTo(176.0f, 295.9f, 189.3f, 274.9f, 209.0f, 264.0f)
                curveTo(189.3f, 253.1f, 176.0f, 232.1f, 176.0f, 208.0f)
                close()
            }
        }
        .build()
        return `_bottle-water`!!
    }

private var `_bottle-water`: ImageVector? = null
