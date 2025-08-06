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

public val Fa.Microphone: ImageVector
    get() {
        if (_microphone != null) {
            return _microphone!!
        }
        _microphone = Builder(name = "Microphone", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(267.0f, 64.0f, 224.0f, 107.0f, 224.0f, 160.0f)
                lineTo(224.0f, 288.0f)
                curveTo(224.0f, 341.0f, 267.0f, 384.0f, 320.0f, 384.0f)
                curveTo(373.0f, 384.0f, 416.0f, 341.0f, 416.0f, 288.0f)
                lineTo(416.0f, 160.0f)
                curveTo(416.0f, 107.0f, 373.0f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(176.0f, 248.0f)
                curveTo(176.0f, 234.7f, 165.3f, 224.0f, 152.0f, 224.0f)
                curveTo(138.7f, 224.0f, 128.0f, 234.7f, 128.0f, 248.0f)
                lineTo(128.0f, 288.0f)
                curveTo(128.0f, 385.9f, 201.3f, 466.7f, 296.0f, 478.5f)
                lineTo(296.0f, 528.0f)
                lineTo(248.0f, 528.0f)
                curveTo(234.7f, 528.0f, 224.0f, 538.7f, 224.0f, 552.0f)
                curveTo(224.0f, 565.3f, 234.7f, 576.0f, 248.0f, 576.0f)
                lineTo(392.0f, 576.0f)
                curveTo(405.3f, 576.0f, 416.0f, 565.3f, 416.0f, 552.0f)
                curveTo(416.0f, 538.7f, 405.3f, 528.0f, 392.0f, 528.0f)
                lineTo(344.0f, 528.0f)
                lineTo(344.0f, 478.5f)
                curveTo(438.7f, 466.7f, 512.0f, 385.9f, 512.0f, 288.0f)
                lineTo(512.0f, 248.0f)
                curveTo(512.0f, 234.7f, 501.3f, 224.0f, 488.0f, 224.0f)
                curveTo(474.7f, 224.0f, 464.0f, 234.7f, 464.0f, 248.0f)
                lineTo(464.0f, 288.0f)
                curveTo(464.0f, 367.5f, 399.5f, 432.0f, 320.0f, 432.0f)
                curveTo(240.5f, 432.0f, 176.0f, 367.5f, 176.0f, 288.0f)
                lineTo(176.0f, 248.0f)
                close()
            }
        }
        .build()
        return _microphone!!
    }

private var _microphone: ImageVector? = null
