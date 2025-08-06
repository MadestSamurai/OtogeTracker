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

public val Fa.Paperclip: ImageVector
    get() {
        if (_paperclip != null) {
            return _paperclip!!
        }
        _paperclip = Builder(name = "Paperclip", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.6f, 76.8f)
                curveTo(344.8f, 20.6f, 436.0f, 20.6f, 492.2f, 76.8f)
                curveTo(548.4f, 133.0f, 548.4f, 224.2f, 492.2f, 280.4f)
                lineTo(328.2f, 444.4f)
                curveTo(293.8f, 478.8f, 238.1f, 478.8f, 203.7f, 444.4f)
                curveTo(169.3f, 410.0f, 169.3f, 354.3f, 203.7f, 319.9f)
                lineTo(356.5f, 167.3f)
                curveTo(369.0f, 154.8f, 389.3f, 154.8f, 401.8f, 167.3f)
                curveTo(414.3f, 179.8f, 414.3f, 200.1f, 401.8f, 212.6f)
                lineTo(249.0f, 365.3f)
                curveTo(239.6f, 374.7f, 239.6f, 389.9f, 249.0f, 399.2f)
                curveTo(258.4f, 408.5f, 273.6f, 408.6f, 282.9f, 399.2f)
                lineTo(446.9f, 235.2f)
                curveTo(478.1f, 204.0f, 478.1f, 153.3f, 446.9f, 122.1f)
                curveTo(415.7f, 90.9f, 365.0f, 90.9f, 333.8f, 122.1f)
                lineTo(169.8f, 286.1f)
                curveTo(116.7f, 339.2f, 116.7f, 425.3f, 169.8f, 478.4f)
                curveTo(222.9f, 531.5f, 309.0f, 531.5f, 362.1f, 478.4f)
                lineTo(492.3f, 348.3f)
                curveTo(504.8f, 335.8f, 525.1f, 335.8f, 537.6f, 348.3f)
                curveTo(550.1f, 360.8f, 550.1f, 381.1f, 537.6f, 393.6f)
                lineTo(407.4f, 523.6f)
                curveTo(329.3f, 601.7f, 202.7f, 601.7f, 124.6f, 523.6f)
                curveTo(46.5f, 445.5f, 46.5f, 318.9f, 124.6f, 240.8f)
                lineTo(288.6f, 76.8f)
                close()
            }
        }
        .build()
        return _paperclip!!
    }

private var _paperclip: ImageVector? = null
