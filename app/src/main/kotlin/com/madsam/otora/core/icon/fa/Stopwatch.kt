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

public val Fa.Stopwatch: ImageVector
    get() {
        if (_stopwatch != null) {
            return _stopwatch!!
        }
        _stopwatch = Builder(name = "Stopwatch", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(264.5f, 64.0f)
                curveTo(251.2f, 64.0f, 240.5f, 74.7f, 240.5f, 88.0f)
                curveTo(240.5f, 101.3f, 251.2f, 112.0f, 264.5f, 112.0f)
                lineTo(296.5f, 112.0f)
                lineTo(296.5f, 137.3f)
                curveTo(188.5f, 149.2f, 104.5f, 240.8f, 104.5f, 352.0f)
                curveTo(104.5f, 471.3f, 201.2f, 568.0f, 320.5f, 568.0f)
                curveTo(439.8f, 568.0f, 536.5f, 471.3f, 536.5f, 352.0f)
                curveTo(536.5f, 312.2f, 525.7f, 274.9f, 506.9f, 242.8f)
                lineTo(535.1f, 214.6f)
                curveTo(547.6f, 202.1f, 547.6f, 181.8f, 535.1f, 169.3f)
                curveTo(522.6f, 156.8f, 502.3f, 156.8f, 489.8f, 169.3f)
                lineTo(466.4f, 192.7f)
                curveTo(433.5f, 162.5f, 391.2f, 142.4f, 344.4f, 137.2f)
                lineTo(344.4f, 111.9f)
                lineTo(376.4f, 111.9f)
                curveTo(389.7f, 111.9f, 400.4f, 101.2f, 400.4f, 87.9f)
                curveTo(400.4f, 74.6f, 389.7f, 63.9f, 376.4f, 63.9f)
                lineTo(264.4f, 63.9f)
                close()
                moveTo(344.5f, 248.0f)
                lineTo(344.5f, 352.0f)
                curveTo(344.5f, 365.3f, 333.8f, 376.0f, 320.5f, 376.0f)
                curveTo(307.2f, 376.0f, 296.5f, 365.3f, 296.5f, 352.0f)
                lineTo(296.5f, 248.0f)
                curveTo(296.5f, 234.7f, 307.2f, 224.0f, 320.5f, 224.0f)
                curveTo(333.8f, 224.0f, 344.5f, 234.7f, 344.5f, 248.0f)
                close()
            }
        }
        .build()
        return _stopwatch!!
    }

private var _stopwatch: ImageVector? = null
