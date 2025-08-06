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

public val Fa.`Window-restore`: ImageVector
    get() {
        if (`_window-restore` != null) {
            return `_window-restore`!!
        }
        `_window-restore` = Builder(name = "Window-restore", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 160.0f)
                lineTo(192.0f, 160.0f)
                curveTo(192.0f, 124.7f, 220.7f, 96.0f, 256.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(579.3f, 96.0f, 608.0f, 124.7f, 608.0f, 160.0f)
                lineTo(608.0f, 352.0f)
                curveTo(608.0f, 387.3f, 579.3f, 416.0f, 544.0f, 416.0f)
                lineTo(496.0f, 416.0f)
                lineTo(496.0f, 352.0f)
                lineTo(544.0f, 352.0f)
                lineTo(544.0f, 160.0f)
                close()
                moveTo(32.0f, 288.0f)
                curveTo(32.0f, 252.7f, 60.7f, 224.0f, 96.0f, 224.0f)
                lineTo(384.0f, 224.0f)
                curveTo(419.3f, 224.0f, 448.0f, 252.7f, 448.0f, 288.0f)
                lineTo(448.0f, 480.0f)
                curveTo(448.0f, 515.3f, 419.3f, 544.0f, 384.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                lineTo(32.0f, 288.0f)
                close()
                moveTo(96.0f, 328.0f)
                curveTo(96.0f, 341.3f, 106.7f, 352.0f, 120.0f, 352.0f)
                lineTo(360.0f, 352.0f)
                curveTo(373.3f, 352.0f, 384.0f, 341.3f, 384.0f, 328.0f)
                curveTo(384.0f, 314.7f, 373.3f, 304.0f, 360.0f, 304.0f)
                lineTo(120.0f, 304.0f)
                curveTo(106.7f, 304.0f, 96.0f, 314.7f, 96.0f, 328.0f)
                close()
            }
        }
        .build()
        return `_window-restore`!!
    }

private var `_window-restore`: ImageVector? = null
