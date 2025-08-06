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

public val Fa.Compass: ImageVector
    get() {
        if (_compass != null) {
            return _compass!!
        }
        _compass = Builder(name = "Compass", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(370.7f, 389.1f)
                lineTo(226.4f, 444.6f)
                curveTo(207.0f, 452.1f, 187.9f, 433.0f, 195.4f, 413.6f)
                lineTo(250.9f, 269.3f)
                curveTo(254.2f, 260.8f, 260.8f, 254.2f, 269.3f, 250.9f)
                lineTo(413.6f, 195.4f)
                curveTo(433.0f, 187.9f, 452.1f, 207.0f, 444.6f, 226.4f)
                lineTo(389.1f, 370.7f)
                curveTo(385.9f, 379.2f, 379.2f, 385.8f, 370.7f, 389.1f)
                close()
                moveTo(352.0f, 320.0f)
                curveTo(352.0f, 302.3f, 337.7f, 288.0f, 320.0f, 288.0f)
                curveTo(302.3f, 288.0f, 288.0f, 302.3f, 288.0f, 320.0f)
                curveTo(288.0f, 337.7f, 302.3f, 352.0f, 320.0f, 352.0f)
                curveTo(337.7f, 352.0f, 352.0f, 337.7f, 352.0f, 320.0f)
                close()
            }
        }
        .build()
        return _compass!!
    }

private var _compass: ImageVector? = null
