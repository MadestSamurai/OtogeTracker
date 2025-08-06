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

public val Fa.Ankh: ImageVector
    get() {
        if (_ankh != null) {
            return _ankh!!
        }
        _ankh = Builder(name = "Ankh", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 192.0f)
                curveTo(256.0f, 156.7f, 284.7f, 128.0f, 320.0f, 128.0f)
                curveTo(355.3f, 128.0f, 384.0f, 156.7f, 384.0f, 192.0f)
                curveTo(384.0f, 233.6f, 363.3f, 268.6f, 337.4f, 296.1f)
                curveTo(331.5f, 302.3f, 325.6f, 307.9f, 320.0f, 312.8f)
                curveTo(314.4f, 307.9f, 308.5f, 302.3f, 302.6f, 296.1f)
                curveTo(276.7f, 268.6f, 256.0f, 233.5f, 256.0f, 192.0f)
                close()
                moveTo(320.0f, 64.0f)
                curveTo(249.3f, 64.0f, 192.0f, 121.3f, 192.0f, 192.0f)
                curveTo(192.0f, 244.4f, 213.5f, 287.5f, 238.8f, 320.0f)
                lineTo(192.0f, 320.0f)
                curveTo(174.3f, 320.0f, 160.0f, 334.3f, 160.0f, 352.0f)
                curveTo(160.0f, 369.7f, 174.3f, 384.0f, 192.0f, 384.0f)
                lineTo(288.0f, 384.0f)
                lineTo(288.0f, 544.0f)
                curveTo(288.0f, 561.7f, 302.3f, 576.0f, 320.0f, 576.0f)
                curveTo(337.7f, 576.0f, 352.0f, 561.7f, 352.0f, 544.0f)
                lineTo(352.0f, 384.0f)
                lineTo(448.0f, 384.0f)
                curveTo(465.7f, 384.0f, 480.0f, 369.7f, 480.0f, 352.0f)
                curveTo(480.0f, 334.3f, 465.7f, 320.0f, 448.0f, 320.0f)
                lineTo(401.2f, 320.0f)
                curveTo(426.5f, 287.5f, 448.0f, 244.4f, 448.0f, 192.0f)
                curveTo(448.0f, 121.3f, 390.7f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return _ankh!!
    }

private var _ankh: ImageVector? = null
