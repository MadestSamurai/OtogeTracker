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

public val Fa.B: ImageVector
    get() {
        if (_b != null) {
            return _b!!
        }
        _b = Builder(name = "B", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 96.0f)
                curveTo(174.3f, 96.0f, 160.0f, 110.3f, 160.0f, 128.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                lineTo(352.0f, 544.0f)
                curveTo(422.7f, 544.0f, 480.0f, 486.7f, 480.0f, 416.0f)
                curveTo(480.0f, 369.5f, 455.2f, 328.7f, 418.0f, 306.3f)
                curveTo(436.7f, 284.0f, 448.0f, 255.3f, 448.0f, 224.0f)
                curveTo(448.0f, 153.3f, 390.7f, 96.0f, 320.0f, 96.0f)
                lineTo(192.0f, 96.0f)
                close()
                moveTo(320.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                lineTo(224.0f, 160.0f)
                lineTo(320.0f, 160.0f)
                curveTo(355.3f, 160.0f, 384.0f, 188.7f, 384.0f, 224.0f)
                curveTo(384.0f, 259.3f, 355.3f, 288.0f, 320.0f, 288.0f)
                close()
                moveTo(224.0f, 352.0f)
                lineTo(352.0f, 352.0f)
                curveTo(387.3f, 352.0f, 416.0f, 380.7f, 416.0f, 416.0f)
                curveTo(416.0f, 451.3f, 387.3f, 480.0f, 352.0f, 480.0f)
                lineTo(224.0f, 480.0f)
                lineTo(224.0f, 352.0f)
                close()
            }
        }
        .build()
        return _b!!
    }

private var _b: ImageVector? = null
