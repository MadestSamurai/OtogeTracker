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

public val Fa.Crosshairs: ImageVector
    get() {
        if (_crosshairs != null) {
            return _crosshairs!!
        }
        _crosshairs = Builder(name = "Crosshairs", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 48.0f)
                curveTo(337.7f, 48.0f, 352.0f, 62.3f, 352.0f, 80.0f)
                lineTo(352.0f, 98.3f)
                curveTo(450.1f, 112.3f, 527.7f, 189.9f, 541.7f, 288.0f)
                lineTo(560.0f, 288.0f)
                curveTo(577.7f, 288.0f, 592.0f, 302.3f, 592.0f, 320.0f)
                curveTo(592.0f, 337.7f, 577.7f, 352.0f, 560.0f, 352.0f)
                lineTo(541.7f, 352.0f)
                curveTo(527.7f, 450.1f, 450.1f, 527.7f, 352.0f, 541.7f)
                lineTo(352.0f, 560.0f)
                curveTo(352.0f, 577.7f, 337.7f, 592.0f, 320.0f, 592.0f)
                curveTo(302.3f, 592.0f, 288.0f, 577.7f, 288.0f, 560.0f)
                lineTo(288.0f, 541.7f)
                curveTo(189.9f, 527.7f, 112.3f, 450.1f, 98.3f, 352.0f)
                lineTo(80.0f, 352.0f)
                curveTo(62.3f, 352.0f, 48.0f, 337.7f, 48.0f, 320.0f)
                curveTo(48.0f, 302.3f, 62.3f, 288.0f, 80.0f, 288.0f)
                lineTo(98.3f, 288.0f)
                curveTo(112.3f, 189.9f, 189.9f, 112.3f, 288.0f, 98.3f)
                lineTo(288.0f, 80.0f)
                curveTo(288.0f, 62.3f, 302.3f, 48.0f, 320.0f, 48.0f)
                close()
                moveTo(163.2f, 352.0f)
                curveTo(175.9f, 414.7f, 225.3f, 464.1f, 288.0f, 476.8f)
                lineTo(288.0f, 464.0f)
                curveTo(288.0f, 446.3f, 302.3f, 432.0f, 320.0f, 432.0f)
                curveTo(337.7f, 432.0f, 352.0f, 446.3f, 352.0f, 464.0f)
                lineTo(352.0f, 476.8f)
                curveTo(414.7f, 464.1f, 464.1f, 414.7f, 476.8f, 352.0f)
                lineTo(464.0f, 352.0f)
                curveTo(446.3f, 352.0f, 432.0f, 337.7f, 432.0f, 320.0f)
                curveTo(432.0f, 302.3f, 446.3f, 288.0f, 464.0f, 288.0f)
                lineTo(476.8f, 288.0f)
                curveTo(464.1f, 225.3f, 414.7f, 175.9f, 352.0f, 163.2f)
                lineTo(352.0f, 176.0f)
                curveTo(352.0f, 193.7f, 337.7f, 208.0f, 320.0f, 208.0f)
                curveTo(302.3f, 208.0f, 288.0f, 193.7f, 288.0f, 176.0f)
                lineTo(288.0f, 163.2f)
                curveTo(225.3f, 175.9f, 175.9f, 225.3f, 163.2f, 288.0f)
                lineTo(176.0f, 288.0f)
                curveTo(193.7f, 288.0f, 208.0f, 302.3f, 208.0f, 320.0f)
                curveTo(208.0f, 337.7f, 193.7f, 352.0f, 176.0f, 352.0f)
                lineTo(163.2f, 352.0f)
                close()
                moveTo(320.0f, 272.0f)
                curveTo(346.5f, 272.0f, 368.0f, 293.5f, 368.0f, 320.0f)
                curveTo(368.0f, 346.5f, 346.5f, 368.0f, 320.0f, 368.0f)
                curveTo(293.5f, 368.0f, 272.0f, 346.5f, 272.0f, 320.0f)
                curveTo(272.0f, 293.5f, 293.5f, 272.0f, 320.0f, 272.0f)
                close()
            }
        }
        .build()
        return _crosshairs!!
    }

private var _crosshairs: ImageVector? = null
