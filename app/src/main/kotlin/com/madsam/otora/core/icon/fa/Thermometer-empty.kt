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

public val Fa.`Thermometer-empty`: ImageVector
    get() {
        if (`_thermometer-empty` != null) {
            return `_thermometer-empty`!!
        }
        `_thermometer-empty` = Builder(name = "Thermometer-empty", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 160.0f)
                curveTo(224.0f, 107.0f, 267.0f, 64.0f, 320.0f, 64.0f)
                curveTo(373.0f, 64.0f, 416.0f, 107.0f, 416.0f, 160.0f)
                lineTo(416.0f, 324.7f)
                curveTo(445.5f, 351.1f, 464.0f, 389.4f, 464.0f, 432.0f)
                curveTo(464.0f, 511.5f, 399.5f, 576.0f, 320.0f, 576.0f)
                curveTo(240.5f, 576.0f, 176.0f, 511.5f, 176.0f, 432.0f)
                curveTo(176.0f, 389.4f, 194.5f, 351.0f, 224.0f, 324.7f)
                lineTo(224.0f, 160.0f)
                close()
                moveTo(320.0f, 496.0f)
                curveTo(355.3f, 496.0f, 384.0f, 467.3f, 384.0f, 432.0f)
                curveTo(384.0f, 396.7f, 355.3f, 368.0f, 320.0f, 368.0f)
                curveTo(284.7f, 368.0f, 256.0f, 396.7f, 256.0f, 432.0f)
                curveTo(256.0f, 467.3f, 284.7f, 496.0f, 320.0f, 496.0f)
                close()
            }
        }
        .build()
        return `_thermometer-empty`!!
    }

private var `_thermometer-empty`: ImageVector? = null
