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

public val Fa.Q: ImageVector
    get() {
        if (_q != null) {
            return _q!!
        }
        _q = Builder(name = "Q", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 320.0f)
                curveTo(160.0f, 408.4f, 231.6f, 480.0f, 320.0f, 480.0f)
                curveTo(348.9f, 480.0f, 376.0f, 472.3f, 399.4f, 458.9f)
                lineTo(327.4f, 372.5f)
                curveTo(316.1f, 358.9f, 317.9f, 338.7f, 331.5f, 327.4f)
                curveTo(345.1f, 316.1f, 365.3f, 317.9f, 376.6f, 331.5f)
                lineTo(447.5f, 416.6f)
                curveTo(467.9f, 389.8f, 480.0f, 356.3f, 480.0f, 320.0f)
                curveTo(480.0f, 231.6f, 408.4f, 160.0f, 320.0f, 160.0f)
                curveTo(231.6f, 160.0f, 160.0f, 231.6f, 160.0f, 320.0f)
                close()
                moveTo(440.9f, 508.6f)
                curveTo(406.0f, 531.0f, 364.5f, 544.0f, 320.0f, 544.0f)
                curveTo(196.3f, 544.0f, 96.0f, 443.7f, 96.0f, 320.0f)
                curveTo(96.0f, 196.3f, 196.3f, 96.0f, 320.0f, 96.0f)
                curveTo(443.7f, 96.0f, 544.0f, 196.3f, 544.0f, 320.0f)
                curveTo(544.0f, 376.1f, 523.4f, 427.4f, 489.3f, 466.7f)
                lineTo(536.6f, 523.5f)
                curveTo(547.9f, 537.1f, 546.1f, 557.3f, 532.5f, 568.6f)
                curveTo(518.9f, 579.9f, 498.7f, 578.1f, 487.4f, 564.5f)
                lineTo(440.8f, 508.6f)
                close()
            }
        }
        .build()
        return _q!!
    }

private var _q: ImageVector? = null
