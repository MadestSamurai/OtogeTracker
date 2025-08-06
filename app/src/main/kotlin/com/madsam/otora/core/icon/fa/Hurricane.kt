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

public val Fa.Hurricane: ImageVector
    get() {
        if (_hurricane != null) {
            return _hurricane!!
        }
        _hurricane = Builder(name = "Hurricane", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 272.0f)
                curveTo(128.0f, 168.4f, 203.7f, 82.5f, 302.9f, 66.6f)
                curveTo(312.0f, 65.2f, 320.0f, 72.6f, 320.0f, 81.9f)
                lineTo(320.0f, 145.2f)
                curveTo(320.0f, 153.6f, 326.5f, 160.5f, 334.7f, 161.7f)
                curveTo(435.0f, 176.6f, 512.0f, 263.0f, 512.0f, 367.4f)
                curveTo(512.0f, 471.0f, 436.3f, 556.9f, 337.1f, 572.8f)
                curveTo(327.9f, 574.3f, 320.0f, 566.9f, 320.0f, 557.6f)
                lineTo(320.0f, 494.3f)
                curveTo(320.0f, 485.9f, 313.5f, 479.0f, 305.3f, 477.7f)
                curveTo(205.0f, 462.9f, 128.0f, 376.4f, 128.0f, 272.0f)
                close()
                moveTo(416.0f, 320.0f)
                curveTo(416.0f, 267.0f, 373.0f, 224.0f, 320.0f, 224.0f)
                curveTo(267.0f, 224.0f, 224.0f, 267.0f, 224.0f, 320.0f)
                curveTo(224.0f, 373.0f, 267.0f, 416.0f, 320.0f, 416.0f)
                curveTo(373.0f, 416.0f, 416.0f, 373.0f, 416.0f, 320.0f)
                close()
                moveTo(320.0f, 288.0f)
                curveTo(337.7f, 288.0f, 352.0f, 302.3f, 352.0f, 320.0f)
                curveTo(352.0f, 337.7f, 337.7f, 352.0f, 320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 337.7f, 288.0f, 320.0f)
                curveTo(288.0f, 302.3f, 302.3f, 288.0f, 320.0f, 288.0f)
                close()
            }
        }
        .build()
        return _hurricane!!
    }

private var _hurricane: ImageVector? = null
