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

public val Fa.Ghost: ImageVector
    get() {
        if (_ghost != null) {
            return _ghost!!
        }
        _ghost = Builder(name = "Ghost", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(168.1f, 531.1f)
                lineTo(156.9f, 540.1f)
                curveTo(153.7f, 542.6f, 149.8f, 544.0f, 145.8f, 544.0f)
                curveTo(136.0f, 544.0f, 128.0f, 536.0f, 128.0f, 526.2f)
                lineTo(128.0f, 256.0f)
                curveTo(128.0f, 150.0f, 214.0f, 64.0f, 320.0f, 64.0f)
                curveTo(426.0f, 64.0f, 512.0f, 150.0f, 512.0f, 256.0f)
                lineTo(512.0f, 526.2f)
                curveTo(512.0f, 536.0f, 504.0f, 544.0f, 494.2f, 544.0f)
                curveTo(490.2f, 544.0f, 486.3f, 542.6f, 483.1f, 540.1f)
                lineTo(471.9f, 531.1f)
                curveTo(458.5f, 520.4f, 439.1f, 522.1f, 427.8f, 535.0f)
                lineTo(397.3f, 570.0f)
                curveTo(394.0f, 573.8f, 389.1f, 576.0f, 384.0f, 576.0f)
                curveTo(378.9f, 576.0f, 374.1f, 573.8f, 370.7f, 570.0f)
                lineTo(344.1f, 539.5f)
                curveTo(331.4f, 524.9f, 308.7f, 524.9f, 295.9f, 539.5f)
                lineTo(269.3f, 570.0f)
                curveTo(266.0f, 573.8f, 261.1f, 576.0f, 256.0f, 576.0f)
                curveTo(250.9f, 576.0f, 246.1f, 573.8f, 242.7f, 570.0f)
                lineTo(212.2f, 535.0f)
                curveTo(200.9f, 522.1f, 181.5f, 520.4f, 168.1f, 531.1f)
                close()
                moveTo(288.0f, 256.0f)
                curveTo(288.0f, 238.3f, 273.7f, 224.0f, 256.0f, 224.0f)
                curveTo(238.3f, 224.0f, 224.0f, 238.3f, 224.0f, 256.0f)
                curveTo(224.0f, 273.7f, 238.3f, 288.0f, 256.0f, 288.0f)
                curveTo(273.7f, 288.0f, 288.0f, 273.7f, 288.0f, 256.0f)
                close()
                moveTo(384.0f, 288.0f)
                curveTo(401.7f, 288.0f, 416.0f, 273.7f, 416.0f, 256.0f)
                curveTo(416.0f, 238.3f, 401.7f, 224.0f, 384.0f, 224.0f)
                curveTo(366.3f, 224.0f, 352.0f, 238.3f, 352.0f, 256.0f)
                curveTo(352.0f, 273.7f, 366.3f, 288.0f, 384.0f, 288.0f)
                close()
            }
        }
        .build()
        return _ghost!!
    }

private var _ghost: ImageVector? = null
