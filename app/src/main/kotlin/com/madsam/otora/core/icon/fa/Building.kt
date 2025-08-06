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

public val Fa.Building: ImageVector
    get() {
        if (_building != null) {
            return _building!!
        }
        _building = Builder(name = "Building", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                close()
                moveTo(304.0f, 416.0f)
                lineTo(336.0f, 416.0f)
                curveTo(353.7f, 416.0f, 368.0f, 430.3f, 368.0f, 448.0f)
                lineTo(368.0f, 528.0f)
                lineTo(272.0f, 528.0f)
                lineTo(272.0f, 448.0f)
                curveTo(272.0f, 430.3f, 286.3f, 416.0f, 304.0f, 416.0f)
                close()
                moveTo(224.0f, 176.0f)
                curveTo(224.0f, 167.2f, 231.2f, 160.0f, 240.0f, 160.0f)
                lineTo(272.0f, 160.0f)
                curveTo(280.8f, 160.0f, 288.0f, 167.2f, 288.0f, 176.0f)
                lineTo(288.0f, 208.0f)
                curveTo(288.0f, 216.8f, 280.8f, 224.0f, 272.0f, 224.0f)
                lineTo(240.0f, 224.0f)
                curveTo(231.2f, 224.0f, 224.0f, 216.8f, 224.0f, 208.0f)
                lineTo(224.0f, 176.0f)
                close()
                moveTo(368.0f, 160.0f)
                lineTo(400.0f, 160.0f)
                curveTo(408.8f, 160.0f, 416.0f, 167.2f, 416.0f, 176.0f)
                lineTo(416.0f, 208.0f)
                curveTo(416.0f, 216.8f, 408.8f, 224.0f, 400.0f, 224.0f)
                lineTo(368.0f, 224.0f)
                curveTo(359.2f, 224.0f, 352.0f, 216.8f, 352.0f, 208.0f)
                lineTo(352.0f, 176.0f)
                curveTo(352.0f, 167.2f, 359.2f, 160.0f, 368.0f, 160.0f)
                close()
                moveTo(224.0f, 304.0f)
                curveTo(224.0f, 295.2f, 231.2f, 288.0f, 240.0f, 288.0f)
                lineTo(272.0f, 288.0f)
                curveTo(280.8f, 288.0f, 288.0f, 295.2f, 288.0f, 304.0f)
                lineTo(288.0f, 336.0f)
                curveTo(288.0f, 344.8f, 280.8f, 352.0f, 272.0f, 352.0f)
                lineTo(240.0f, 352.0f)
                curveTo(231.2f, 352.0f, 224.0f, 344.8f, 224.0f, 336.0f)
                lineTo(224.0f, 304.0f)
                close()
                moveTo(368.0f, 288.0f)
                lineTo(400.0f, 288.0f)
                curveTo(408.8f, 288.0f, 416.0f, 295.2f, 416.0f, 304.0f)
                lineTo(416.0f, 336.0f)
                curveTo(416.0f, 344.8f, 408.8f, 352.0f, 400.0f, 352.0f)
                lineTo(368.0f, 352.0f)
                curveTo(359.2f, 352.0f, 352.0f, 344.8f, 352.0f, 336.0f)
                lineTo(352.0f, 304.0f)
                curveTo(352.0f, 295.2f, 359.2f, 288.0f, 368.0f, 288.0f)
                close()
            }
        }
        .build()
        return _building!!
    }

private var _building: ImageVector? = null
