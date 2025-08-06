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

public val Fa.Store: ImageVector
    get() {
        if (_store != null) {
            return _store!!
        }
        _store = Builder(name = "Store", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(94.7f, 136.3f)
                curveTo(101.6f, 112.4f, 123.5f, 96.0f, 148.4f, 96.0f)
                lineTo(492.4f, 96.0f)
                curveTo(517.3f, 96.0f, 539.2f, 112.4f, 546.2f, 136.3f)
                lineTo(569.6f, 216.5f)
                curveTo(582.4f, 260.2f, 549.5f, 304.0f, 504.0f, 304.0f)
                curveTo(477.7f, 304.0f, 454.6f, 289.1f, 443.2f, 266.9f)
                curveTo(431.6f, 288.8f, 408.6f, 304.0f, 381.8f, 304.0f)
                curveTo(355.2f, 304.0f, 332.1f, 289.0f, 320.5f, 267.0f)
                curveTo(308.9f, 289.0f, 285.8f, 304.0f, 259.2f, 304.0f)
                curveTo(232.4f, 304.0f, 209.4f, 288.9f, 197.8f, 266.9f)
                curveTo(186.4f, 289.0f, 163.3f, 304.0f, 137.0f, 304.0f)
                curveTo(91.4f, 304.0f, 58.6f, 260.3f, 71.4f, 216.5f)
                lineTo(94.7f, 136.3f)
                close()
                moveTo(160.4f, 416.0f)
                lineTo(480.4f, 416.0f)
                lineTo(480.4f, 349.6f)
                curveTo(488.0f, 351.2f, 495.9f, 352.0f, 503.9f, 352.0f)
                curveTo(518.2f, 352.0f, 531.9f, 349.4f, 544.4f, 344.8f)
                lineTo(544.4f, 496.0f)
                curveTo(544.4f, 522.5f, 522.9f, 544.0f, 496.4f, 544.0f)
                lineTo(144.4f, 544.0f)
                curveTo(117.9f, 544.0f, 96.4f, 522.5f, 96.4f, 496.0f)
                lineTo(96.4f, 344.8f)
                curveTo(108.9f, 349.4f, 122.5f, 352.0f, 136.9f, 352.0f)
                curveTo(145.0f, 352.0f, 152.8f, 351.2f, 160.4f, 349.6f)
                lineTo(160.4f, 416.0f)
                close()
            }
        }
        .build()
        return _store!!
    }

private var _store: ImageVector? = null
