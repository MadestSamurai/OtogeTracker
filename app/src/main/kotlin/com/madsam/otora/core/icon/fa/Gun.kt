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

public val Fa.Gun: ImageVector
    get() {
        if (_gun != null) {
            return _gun!!
        }
        _gun = Builder(name = "Gun", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(560.0f, 120.0f)
                curveTo(560.0f, 106.7f, 549.3f, 96.0f, 536.0f, 96.0f)
                curveTo(522.7f, 96.0f, 512.0f, 106.7f, 512.0f, 120.0f)
                lineTo(512.0f, 128.0f)
                lineTo(64.0f, 128.0f)
                curveTo(46.3f, 128.0f, 32.0f, 142.3f, 32.0f, 160.0f)
                lineTo(32.0f, 272.0f)
                curveTo(32.0f, 289.7f, 46.3f, 304.0f, 64.0f, 304.0f)
                lineTo(74.0f, 304.0f)
                curveTo(94.8f, 304.0f, 110.1f, 323.6f, 105.0f, 343.8f)
                lineTo(65.0f, 504.2f)
                curveTo(62.6f, 513.8f, 64.8f, 523.9f, 70.8f, 531.7f)
                curveTo(76.8f, 539.5f, 86.1f, 544.0f, 96.0f, 544.0f)
                lineTo(192.0f, 544.0f)
                curveTo(206.7f, 544.0f, 219.5f, 534.0f, 223.0f, 519.8f)
                lineTo(249.0f, 416.0f)
                lineTo(353.4f, 416.0f)
                curveTo(377.1f, 416.0f, 398.2f, 401.1f, 406.1f, 378.8f)
                lineTo(432.8f, 304.0f)
                lineTo(463.9f, 304.0f)
                curveTo(472.4f, 304.0f, 480.5f, 300.6f, 486.5f, 294.6f)
                lineTo(509.1f, 272.0f)
                lineTo(575.8f, 272.0f)
                curveTo(593.5f, 272.0f, 607.8f, 257.7f, 607.8f, 240.0f)
                lineTo(607.8f, 160.0f)
                curveTo(607.8f, 142.3f, 593.5f, 128.0f, 575.8f, 128.0f)
                lineTo(559.8f, 128.0f)
                lineTo(559.8f, 120.0f)
                close()
                moveTo(353.4f, 368.0f)
                lineTo(260.9f, 368.0f)
                lineTo(276.9f, 304.0f)
                lineTo(381.9f, 304.0f)
                lineTo(360.9f, 362.7f)
                curveTo(359.8f, 365.9f, 356.7f, 368.0f, 353.4f, 368.0f)
                close()
                moveTo(112.0f, 192.0f)
                lineTo(496.0f, 192.0f)
                curveTo(504.8f, 192.0f, 512.0f, 199.2f, 512.0f, 208.0f)
                curveTo(512.0f, 216.8f, 504.8f, 224.0f, 496.0f, 224.0f)
                lineTo(112.0f, 224.0f)
                curveTo(103.2f, 224.0f, 96.0f, 216.8f, 96.0f, 208.0f)
                curveTo(96.0f, 199.2f, 103.2f, 192.0f, 112.0f, 192.0f)
                close()
            }
        }
        .build()
        return _gun!!
    }

private var _gun: ImageVector? = null
