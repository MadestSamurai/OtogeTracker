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

public val Fa.Asterisk: ImageVector
    get() {
        if (_asterisk != null) {
            return _asterisk!!
        }
        _asterisk = Builder(name = "Asterisk", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(337.7f, 64.0f, 352.0f, 78.3f, 352.0f, 96.0f)
                lineTo(352.0f, 264.6f)
                lineTo(496.0f, 181.5f)
                curveTo(511.3f, 172.7f, 530.9f, 177.9f, 539.7f, 193.2f)
                curveTo(548.5f, 208.5f, 543.3f, 228.1f, 528.0f, 236.9f)
                lineTo(384.0f, 320.0f)
                lineTo(528.0f, 403.1f)
                curveTo(543.3f, 411.9f, 548.6f, 431.5f, 539.7f, 446.8f)
                curveTo(530.8f, 462.1f, 511.3f, 467.4f, 496.0f, 458.5f)
                lineTo(352.0f, 375.4f)
                lineTo(352.0f, 544.0f)
                curveTo(352.0f, 561.7f, 337.7f, 576.0f, 320.0f, 576.0f)
                curveTo(302.3f, 576.0f, 288.0f, 561.7f, 288.0f, 544.0f)
                lineTo(288.0f, 375.4f)
                lineTo(144.0f, 458.5f)
                curveTo(128.7f, 467.3f, 109.1f, 462.1f, 100.3f, 446.8f)
                curveTo(91.5f, 431.5f, 96.7f, 412.0f, 112.0f, 403.1f)
                lineTo(256.0f, 320.0f)
                lineTo(112.0f, 236.9f)
                curveTo(96.7f, 228.0f, 91.5f, 208.5f, 100.3f, 193.1f)
                curveTo(109.1f, 177.7f, 128.7f, 172.6f, 144.0f, 181.4f)
                lineTo(288.0f, 264.6f)
                lineTo(288.0f, 96.0f)
                curveTo(288.0f, 78.3f, 302.3f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return _asterisk!!
    }

private var _asterisk: ImageVector? = null
