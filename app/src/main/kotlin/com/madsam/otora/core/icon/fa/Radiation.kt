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

public val Fa.Radiation: ImageVector
    get() {
        if (_radiation != null) {
            return _radiation!!
        }
        _radiation = Builder(name = "Radiation", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(478.2f, 98.5f)
                curveTo(464.0f, 88.4f, 444.7f, 93.9f, 436.0f, 109.0f)
                lineTo(363.6f, 234.3f)
                curveTo(394.9f, 250.1f, 416.4f, 282.6f, 416.4f, 320.0f)
                lineTo(560.4f, 320.0f)
                curveTo(578.1f, 320.0f, 592.6f, 305.6f, 590.5f, 288.1f)
                curveTo(581.4f, 210.0f, 539.1f, 142.0f, 478.2f, 98.5f)
                close()
                moveTo(204.7f, 108.9f)
                curveTo(196.0f, 93.8f, 176.7f, 88.3f, 162.5f, 98.5f)
                curveTo(101.6f, 141.9f, 59.3f, 209.9f, 50.2f, 288.1f)
                curveTo(48.1f, 305.6f, 62.7f, 320.0f, 80.3f, 320.0f)
                lineTo(224.3f, 320.0f)
                curveTo(224.3f, 282.5f, 245.8f, 250.1f, 277.1f, 234.3f)
                lineTo(204.7f, 108.9f)
                close()
                moveTo(195.3f, 525.7f)
                curveTo(186.6f, 540.8f, 191.5f, 560.2f, 207.3f, 567.5f)
                curveTo(241.7f, 583.2f, 280.0f, 592.0f, 320.3f, 592.0f)
                curveTo(360.6f, 592.0f, 398.9f, 583.2f, 433.3f, 567.5f)
                curveTo(449.1f, 560.3f, 454.0f, 540.8f, 445.3f, 525.7f)
                lineTo(373.0f, 400.3f)
                curveTo(357.9f, 410.2f, 339.8f, 416.0f, 320.4f, 416.0f)
                curveTo(301.0f, 416.0f, 282.9f, 410.2f, 267.8f, 400.3f)
                lineTo(195.3f, 525.7f)
                close()
                moveTo(320.3f, 368.0f)
                curveTo(346.8f, 367.8f, 368.1f, 346.2f, 368.0f, 319.7f)
                curveTo(367.8f, 293.1f, 346.1f, 271.8f, 319.6f, 272.0f)
                curveTo(293.1f, 272.2f, 271.8f, 293.8f, 272.0f, 320.4f)
                curveTo(272.1f, 346.9f, 293.8f, 368.2f, 320.3f, 368.0f)
                close()
            }
        }
        .build()
        return _radiation!!
    }

private var _radiation: ImageVector? = null
