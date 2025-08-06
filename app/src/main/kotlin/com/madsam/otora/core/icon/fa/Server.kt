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

public val Fa.Server: ImageVector
    get() {
        if (_server != null) {
            return _server!!
        }
        _server = Builder(name = "Server", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 224.0f)
                curveTo(96.0f, 259.3f, 124.7f, 288.0f, 160.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(515.3f, 288.0f, 544.0f, 259.3f, 544.0f, 224.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(376.0f, 168.0f)
                curveTo(389.3f, 168.0f, 400.0f, 178.7f, 400.0f, 192.0f)
                curveTo(400.0f, 205.3f, 389.3f, 216.0f, 376.0f, 216.0f)
                curveTo(362.7f, 216.0f, 352.0f, 205.3f, 352.0f, 192.0f)
                curveTo(352.0f, 178.7f, 362.7f, 168.0f, 376.0f, 168.0f)
                close()
                moveTo(432.0f, 192.0f)
                curveTo(432.0f, 178.7f, 442.7f, 168.0f, 456.0f, 168.0f)
                curveTo(469.3f, 168.0f, 480.0f, 178.7f, 480.0f, 192.0f)
                curveTo(480.0f, 205.3f, 469.3f, 216.0f, 456.0f, 216.0f)
                curveTo(442.7f, 216.0f, 432.0f, 205.3f, 432.0f, 192.0f)
                close()
                moveTo(160.0f, 352.0f)
                curveTo(124.7f, 352.0f, 96.0f, 380.7f, 96.0f, 416.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 380.7f, 515.3f, 352.0f, 480.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                close()
                moveTo(376.0f, 424.0f)
                curveTo(389.3f, 424.0f, 400.0f, 434.7f, 400.0f, 448.0f)
                curveTo(400.0f, 461.3f, 389.3f, 472.0f, 376.0f, 472.0f)
                curveTo(362.7f, 472.0f, 352.0f, 461.3f, 352.0f, 448.0f)
                curveTo(352.0f, 434.7f, 362.7f, 424.0f, 376.0f, 424.0f)
                close()
                moveTo(432.0f, 448.0f)
                curveTo(432.0f, 434.7f, 442.7f, 424.0f, 456.0f, 424.0f)
                curveTo(469.3f, 424.0f, 480.0f, 434.7f, 480.0f, 448.0f)
                curveTo(480.0f, 461.3f, 469.3f, 472.0f, 456.0f, 472.0f)
                curveTo(442.7f, 472.0f, 432.0f, 461.3f, 432.0f, 448.0f)
                close()
            }
        }
        .build()
        return _server!!
    }

private var _server: ImageVector? = null
