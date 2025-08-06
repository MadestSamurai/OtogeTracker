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

public val Fa.`Id-card`: ImageVector
    get() {
        if (`_id-card` != null) {
            return `_id-card`!!
        }
        `_id-card` = Builder(name = "Id-card", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(579.3f, 96.0f, 608.0f, 124.7f, 608.0f, 160.0f)
                lineTo(32.0f, 160.0f)
                close()
                moveTo(32.0f, 208.0f)
                lineTo(608.0f, 208.0f)
                lineTo(608.0f, 480.0f)
                curveTo(608.0f, 515.3f, 579.3f, 544.0f, 544.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                lineTo(32.0f, 208.0f)
                close()
                moveTo(279.3f, 480.0f)
                curveTo(299.5f, 480.0f, 314.6f, 460.6f, 301.7f, 445.0f)
                curveTo(287.0f, 427.3f, 264.8f, 416.0f, 240.0f, 416.0f)
                lineTo(176.0f, 416.0f)
                curveTo(151.2f, 416.0f, 129.0f, 427.3f, 114.3f, 445.0f)
                curveTo(101.4f, 460.6f, 116.5f, 480.0f, 136.7f, 480.0f)
                lineTo(279.2f, 480.0f)
                close()
                moveTo(208.0f, 376.0f)
                curveTo(238.9f, 376.0f, 264.0f, 350.9f, 264.0f, 320.0f)
                curveTo(264.0f, 289.1f, 238.9f, 264.0f, 208.0f, 264.0f)
                curveTo(177.1f, 264.0f, 152.0f, 289.1f, 152.0f, 320.0f)
                curveTo(152.0f, 350.9f, 177.1f, 376.0f, 208.0f, 376.0f)
                close()
                moveTo(392.0f, 272.0f)
                curveTo(378.7f, 272.0f, 368.0f, 282.7f, 368.0f, 296.0f)
                curveTo(368.0f, 309.3f, 378.7f, 320.0f, 392.0f, 320.0f)
                lineTo(504.0f, 320.0f)
                curveTo(517.3f, 320.0f, 528.0f, 309.3f, 528.0f, 296.0f)
                curveTo(528.0f, 282.7f, 517.3f, 272.0f, 504.0f, 272.0f)
                lineTo(392.0f, 272.0f)
                close()
                moveTo(392.0f, 368.0f)
                curveTo(378.7f, 368.0f, 368.0f, 378.7f, 368.0f, 392.0f)
                curveTo(368.0f, 405.3f, 378.7f, 416.0f, 392.0f, 416.0f)
                lineTo(504.0f, 416.0f)
                curveTo(517.3f, 416.0f, 528.0f, 405.3f, 528.0f, 392.0f)
                curveTo(528.0f, 378.7f, 517.3f, 368.0f, 504.0f, 368.0f)
                lineTo(392.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_id-card`!!
    }

private var `_id-card`: ImageVector? = null
