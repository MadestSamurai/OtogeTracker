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

public val Fa.R: ImageVector
    get() {
        if (_r != null) {
            return _r!!
        }
        _r = Builder(name = "R", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 96.0f)
                curveTo(174.3f, 96.0f, 160.0f, 110.3f, 160.0f, 128.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                curveTo(209.7f, 544.0f, 224.0f, 529.7f, 224.0f, 512.0f)
                lineTo(224.0f, 384.0f)
                lineTo(319.3f, 384.0f)
                lineTo(421.7f, 530.4f)
                curveTo(431.8f, 544.9f, 451.8f, 548.4f, 466.3f, 538.3f)
                curveTo(480.8f, 528.2f, 484.3f, 508.2f, 474.2f, 493.7f)
                lineTo(390.1f, 373.5f)
                curveTo(442.8f, 352.1f, 480.0f, 300.4f, 480.0f, 240.0f)
                curveTo(480.0f, 160.5f, 415.5f, 96.0f, 336.0f, 96.0f)
                lineTo(192.0f, 96.0f)
                close()
                moveTo(336.0f, 320.0f)
                lineTo(224.0f, 320.0f)
                lineTo(224.0f, 160.0f)
                lineTo(336.0f, 160.0f)
                curveTo(380.2f, 160.0f, 416.0f, 195.8f, 416.0f, 240.0f)
                curveTo(416.0f, 284.2f, 380.2f, 320.0f, 336.0f, 320.0f)
                close()
            }
        }
        .build()
        return _r!!
    }

private var _r: ImageVector? = null
