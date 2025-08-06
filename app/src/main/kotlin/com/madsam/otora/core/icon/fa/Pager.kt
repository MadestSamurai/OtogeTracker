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

public val Fa.Pager: ImageVector
    get() {
        if (_pager != null) {
            return _pager!!
        }
        _pager = Builder(name = "Pager", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                curveTo(547.3f, 128.0f, 576.0f, 156.7f, 576.0f, 192.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                close()
                moveTo(128.0f, 224.0f)
                lineTo(128.0f, 288.0f)
                curveTo(128.0f, 305.7f, 142.3f, 320.0f, 160.0f, 320.0f)
                lineTo(480.0f, 320.0f)
                curveTo(497.7f, 320.0f, 512.0f, 305.7f, 512.0f, 288.0f)
                lineTo(512.0f, 224.0f)
                curveTo(512.0f, 206.3f, 497.7f, 192.0f, 480.0f, 192.0f)
                lineTo(160.0f, 192.0f)
                curveTo(142.3f, 192.0f, 128.0f, 206.3f, 128.0f, 224.0f)
                close()
                moveTo(152.0f, 384.0f)
                curveTo(138.7f, 384.0f, 128.0f, 394.7f, 128.0f, 408.0f)
                curveTo(128.0f, 421.3f, 138.7f, 432.0f, 152.0f, 432.0f)
                lineTo(200.0f, 432.0f)
                curveTo(213.3f, 432.0f, 224.0f, 421.3f, 224.0f, 408.0f)
                curveTo(224.0f, 394.7f, 213.3f, 384.0f, 200.0f, 384.0f)
                lineTo(152.0f, 384.0f)
                close()
                moveTo(280.0f, 384.0f)
                curveTo(266.7f, 384.0f, 256.0f, 394.7f, 256.0f, 408.0f)
                curveTo(256.0f, 421.3f, 266.7f, 432.0f, 280.0f, 432.0f)
                lineTo(328.0f, 432.0f)
                curveTo(341.3f, 432.0f, 352.0f, 421.3f, 352.0f, 408.0f)
                curveTo(352.0f, 394.7f, 341.3f, 384.0f, 328.0f, 384.0f)
                lineTo(280.0f, 384.0f)
                close()
            }
        }
        .build()
        return _pager!!
    }

private var _pager: ImageVector? = null
