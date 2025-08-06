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

public val Fa.Archive: ImageVector
    get() {
        if (_archive != null) {
            return _archive!!
        }
        _archive = Builder(name = "Archive", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(561.7f, 96.0f, 576.0f, 110.3f, 576.0f, 128.0f)
                lineTo(576.0f, 160.0f)
                curveTo(576.0f, 177.7f, 561.7f, 192.0f, 544.0f, 192.0f)
                lineTo(96.0f, 192.0f)
                curveTo(78.3f, 192.0f, 64.0f, 177.7f, 64.0f, 160.0f)
                lineTo(64.0f, 128.0f)
                close()
                moveTo(96.0f, 240.0f)
                lineTo(544.0f, 240.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 240.0f)
                close()
                moveTo(248.0f, 304.0f)
                curveTo(234.7f, 304.0f, 224.0f, 314.7f, 224.0f, 328.0f)
                curveTo(224.0f, 341.3f, 234.7f, 352.0f, 248.0f, 352.0f)
                lineTo(392.0f, 352.0f)
                curveTo(405.3f, 352.0f, 416.0f, 341.3f, 416.0f, 328.0f)
                curveTo(416.0f, 314.7f, 405.3f, 304.0f, 392.0f, 304.0f)
                lineTo(248.0f, 304.0f)
                close()
            }
        }
        .build()
        return _archive!!
    }

private var _archive: ImageVector? = null
