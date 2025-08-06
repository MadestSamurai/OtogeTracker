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

public val Fa.Tarp: ImageVector
    get() {
        if (_tarp != null) {
            return _tarp!!
        }
        _tarp = Builder(name = "Tarp", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 128.0f)
                curveTo(547.3f, 128.0f, 576.0f, 156.7f, 576.0f, 192.0f)
                lineTo(576.0f, 341.5f)
                curveTo(576.0f, 358.5f, 569.3f, 374.8f, 557.3f, 386.8f)
                lineTo(450.7f, 493.3f)
                curveTo(438.7f, 505.3f, 422.4f, 512.0f, 405.4f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                close()
                moveTo(517.5f, 336.0f)
                lineTo(424.0f, 336.0f)
                curveTo(410.7f, 336.0f, 400.0f, 346.7f, 400.0f, 360.0f)
                lineTo(400.0f, 453.5f)
                lineTo(517.5f, 336.0f)
                close()
                moveTo(160.0f, 256.0f)
                curveTo(177.7f, 256.0f, 192.0f, 241.7f, 192.0f, 224.0f)
                curveTo(192.0f, 206.3f, 177.7f, 192.0f, 160.0f, 192.0f)
                curveTo(142.3f, 192.0f, 128.0f, 206.3f, 128.0f, 224.0f)
                curveTo(128.0f, 241.7f, 142.3f, 256.0f, 160.0f, 256.0f)
                close()
            }
        }
        .build()
        return _tarp!!
    }

private var _tarp: ImageVector? = null
