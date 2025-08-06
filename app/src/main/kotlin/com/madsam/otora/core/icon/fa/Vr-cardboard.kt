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

public val Fa.`Vr-cardboard`: ImageVector
    get() {
        if (`_vr-cardboard` != null) {
            return `_vr-cardboard`!!
        }
        `_vr-cardboard` = Builder(name = "Vr-cardboard", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 160.0f)
                lineTo(96.0f, 160.0f)
                curveTo(60.7f, 160.0f, 32.0f, 188.7f, 32.0f, 224.0f)
                lineTo(32.0f, 416.0f)
                curveTo(32.0f, 451.3f, 60.7f, 480.0f, 96.0f, 480.0f)
                lineTo(213.5f, 480.0f)
                curveTo(230.5f, 480.0f, 246.8f, 473.3f, 258.8f, 461.3f)
                lineTo(292.7f, 427.4f)
                curveTo(299.9f, 420.2f, 309.8f, 416.1f, 320.0f, 416.1f)
                curveTo(330.2f, 416.1f, 340.1f, 420.2f, 347.3f, 427.4f)
                lineTo(381.2f, 461.3f)
                curveTo(393.2f, 473.3f, 409.5f, 480.0f, 426.5f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(579.3f, 480.0f, 608.0f, 451.3f, 608.0f, 416.0f)
                lineTo(608.0f, 224.0f)
                curveTo(608.0f, 188.7f, 579.3f, 160.0f, 544.0f, 160.0f)
                close()
                moveTo(112.0f, 304.0f)
                curveTo(112.0f, 268.7f, 140.7f, 240.0f, 176.0f, 240.0f)
                curveTo(211.3f, 240.0f, 240.0f, 268.7f, 240.0f, 304.0f)
                curveTo(240.0f, 339.3f, 211.3f, 368.0f, 176.0f, 368.0f)
                curveTo(140.7f, 368.0f, 112.0f, 339.3f, 112.0f, 304.0f)
                close()
                moveTo(464.0f, 240.0f)
                curveTo(499.3f, 240.0f, 528.0f, 268.7f, 528.0f, 304.0f)
                curveTo(528.0f, 339.3f, 499.3f, 368.0f, 464.0f, 368.0f)
                curveTo(428.7f, 368.0f, 400.0f, 339.3f, 400.0f, 304.0f)
                curveTo(400.0f, 268.7f, 428.7f, 240.0f, 464.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_vr-cardboard`!!
    }

private var `_vr-cardboard`: ImageVector? = null
