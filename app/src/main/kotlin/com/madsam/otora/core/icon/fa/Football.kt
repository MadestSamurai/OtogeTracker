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

public val Fa.Football: ImageVector
    get() {
        if (_football != null) {
            return _football!!
        }
        _football = Builder(name = "Football", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(325.1f, 86.6f)
                curveTo(236.1f, 104.6f, 174.6f, 150.0f, 135.1f, 210.5f)
                curveTo(111.8f, 246.1f, 97.0f, 285.8f, 88.4f, 326.0f)
                lineTo(315.9f, 553.4f)
                curveTo(404.9f, 535.4f, 466.4f, 490.0f, 506.0f, 429.5f)
                curveTo(529.3f, 393.9f, 544.1f, 354.2f, 552.7f, 314.0f)
                lineTo(325.1f, 86.6f)
                close()
                moveTo(561.1f, 254.7f)
                curveTo(564.3f, 212.4f, 561.8f, 171.4f, 556.3f, 136.0f)
                curveTo(551.9f, 108.2f, 529.5f, 88.0f, 503.2f, 84.4f)
                curveTo(460.2f, 78.5f, 421.0f, 76.9f, 385.4f, 79.0f)
                lineTo(561.1f, 254.6f)
                close()
                moveTo(255.7f, 561.1f)
                lineTo(79.9f, 385.4f)
                curveTo(76.7f, 427.7f, 79.2f, 468.7f, 84.7f, 504.1f)
                curveTo(89.1f, 531.9f, 111.5f, 552.1f, 137.8f, 555.7f)
                curveTo(180.8f, 561.6f, 220.0f, 563.2f, 255.6f, 561.1f)
                close()
                moveTo(335.5f, 207.0f)
                curveTo(344.9f, 197.6f, 360.1f, 197.6f, 369.4f, 207.0f)
                lineTo(433.4f, 271.0f)
                curveTo(442.8f, 280.4f, 442.8f, 295.6f, 433.4f, 304.9f)
                curveTo(424.0f, 314.2f, 408.8f, 314.3f, 399.5f, 304.9f)
                lineTo(335.5f, 240.9f)
                curveTo(326.1f, 231.5f, 326.1f, 216.3f, 335.5f, 207.0f)
                close()
                moveTo(271.5f, 271.0f)
                curveTo(280.9f, 261.6f, 296.1f, 261.6f, 305.4f, 271.0f)
                lineTo(369.4f, 335.0f)
                curveTo(378.8f, 344.4f, 378.8f, 359.6f, 369.4f, 368.9f)
                curveTo(360.0f, 378.2f, 344.8f, 378.3f, 335.5f, 368.9f)
                lineTo(271.5f, 304.9f)
                curveTo(262.1f, 295.5f, 262.1f, 280.3f, 271.5f, 271.0f)
                close()
                moveTo(207.5f, 335.0f)
                curveTo(216.9f, 325.6f, 232.1f, 325.6f, 241.4f, 335.0f)
                lineTo(305.4f, 399.0f)
                curveTo(314.8f, 408.4f, 314.8f, 423.6f, 305.4f, 432.9f)
                curveTo(296.0f, 442.2f, 280.8f, 442.3f, 271.5f, 432.9f)
                lineTo(207.5f, 368.9f)
                curveTo(198.1f, 359.5f, 198.1f, 344.3f, 207.5f, 335.0f)
                close()
            }
        }
        .build()
        return _football!!
    }

private var _football: ImageVector? = null
