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

public val Fa.Tent: ImageVector
    get() {
        if (_tent != null) {
            return _tent!!
        }
        _tent = Builder(name = "Tent", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(90.9f, 270.9f)
                lineTo(67.7f, 508.9f)
                curveTo(65.8f, 527.7f, 80.6f, 544.0f, 99.5f, 544.0f)
                lineTo(272.2f, 544.0f)
                curveTo(298.7f, 544.0f, 320.2f, 522.5f, 320.2f, 496.0f)
                lineTo(320.2f, 367.0f)
                curveTo(320.2f, 358.7f, 326.9f, 352.0f, 335.2f, 352.0f)
                curveTo(340.7f, 352.0f, 345.8f, 355.0f, 348.4f, 359.9f)
                lineTo(434.5f, 518.9f)
                curveTo(442.9f, 534.4f, 459.1f, 544.0f, 476.7f, 544.0f)
                lineTo(540.8f, 544.0f)
                curveTo(559.7f, 544.0f, 574.5f, 527.7f, 572.6f, 508.9f)
                lineTo(549.6f, 271.1f)
                curveTo(547.7f, 251.5f, 536.8f, 233.8f, 520.1f, 223.3f)
                lineTo(344.9f, 112.3f)
                curveTo(329.2f, 102.3f, 309.1f, 102.4f, 293.4f, 112.4f)
                lineTo(120.1f, 223.2f)
                curveTo(103.6f, 233.8f, 92.8f, 251.4f, 90.9f, 270.9f)
                close()
            }
        }
        .build()
        return _tent!!
    }

private var _tent: ImageVector? = null
