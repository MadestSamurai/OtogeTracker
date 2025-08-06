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

public val Fa.Tape: ImageVector
    get() {
        if (_tape != null) {
            return _tape!!
        }
        _tape = Builder(name = "Tape", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(444.8f, 480.0f)
                curveTo(486.3f, 439.3f, 512.0f, 382.7f, 512.0f, 320.0f)
                curveTo(512.0f, 196.3f, 411.7f, 96.0f, 288.0f, 96.0f)
                curveTo(164.3f, 96.0f, 64.0f, 196.3f, 64.0f, 320.0f)
                curveTo(64.0f, 443.7f, 164.3f, 544.0f, 288.0f, 544.0f)
                lineTo(576.0f, 544.0f)
                curveTo(593.7f, 544.0f, 608.0f, 529.7f, 608.0f, 512.0f)
                curveTo(608.0f, 494.3f, 593.7f, 480.0f, 576.0f, 480.0f)
                lineTo(444.8f, 480.0f)
                close()
                moveTo(288.0f, 224.0f)
                curveTo(341.0f, 224.0f, 384.0f, 267.0f, 384.0f, 320.0f)
                curveTo(384.0f, 373.0f, 341.0f, 416.0f, 288.0f, 416.0f)
                curveTo(235.0f, 416.0f, 192.0f, 373.0f, 192.0f, 320.0f)
                curveTo(192.0f, 267.0f, 235.0f, 224.0f, 288.0f, 224.0f)
                close()
                moveTo(336.0f, 320.0f)
                curveTo(336.0f, 293.5f, 314.5f, 272.0f, 288.0f, 272.0f)
                curveTo(261.5f, 272.0f, 240.0f, 293.5f, 240.0f, 320.0f)
                curveTo(240.0f, 346.5f, 261.5f, 368.0f, 288.0f, 368.0f)
                curveTo(314.5f, 368.0f, 336.0f, 346.5f, 336.0f, 320.0f)
                close()
            }
        }
        .build()
        return _tape!!
    }

private var _tape: ImageVector? = null
