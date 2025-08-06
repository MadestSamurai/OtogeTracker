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

public val Fa.Ribbon: ImageVector
    get() {
        if (_ribbon != null) {
            return _ribbon!!
        }
        _ribbon = Builder(name = "Ribbon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(363.1f, 64.0f)
                curveTo(396.5f, 64.0f, 427.6f, 81.4f, 445.0f, 109.9f)
                curveTo(446.2f, 111.9f, 458.0f, 131.2f, 480.3f, 167.7f)
                curveTo(501.4f, 202.2f, 498.6f, 246.2f, 473.3f, 277.7f)
                lineTo(406.3f, 361.7f)
                lineTo(492.5f, 470.0f)
                curveTo(498.0f, 476.9f, 496.9f, 486.9f, 490.0f, 492.5f)
                lineTo(410.0f, 556.5f)
                curveTo(403.1f, 562.0f, 393.0f, 560.9f, 387.5f, 554.0f)
                lineTo(166.6f, 277.8f)
                curveTo(141.3f, 246.3f, 138.5f, 202.3f, 159.6f, 167.8f)
                curveTo(182.0f, 131.2f, 193.7f, 111.9f, 195.0f, 109.9f)
                curveTo(212.4f, 81.4f, 243.4f, 64.0f, 276.9f, 64.0f)
                lineTo(363.2f, 64.0f)
                close()
                moveTo(320.0f, 253.2f)
                lineTo(368.6f, 192.0f)
                lineTo(271.3f, 192.0f)
                lineTo(319.9f, 253.2f)
                close()
                moveTo(203.0f, 400.2f)
                lineTo(289.2f, 508.0f)
                lineTo(252.4f, 554.0f)
                curveTo(246.9f, 560.9f, 236.8f, 562.0f, 229.9f, 556.5f)
                lineTo(149.9f, 492.5f)
                curveTo(143.0f, 487.0f, 141.9f, 476.9f, 147.4f, 470.0f)
                lineTo(203.0f, 400.2f)
                close()
            }
        }
        .build()
        return _ribbon!!
    }

private var _ribbon: ImageVector? = null
