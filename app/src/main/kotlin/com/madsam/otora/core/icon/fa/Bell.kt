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

public val Fa.Bell: ImageVector
    get() {
        if (_bell != null) {
            return _bell!!
        }
        _bell = Builder(name = "Bell", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 99.2f)
                curveTo(215.0f, 114.0f, 160.0f, 178.6f, 160.0f, 256.0f)
                lineTo(160.0f, 277.7f)
                curveTo(160.0f, 325.8f, 143.6f, 372.5f, 113.6f, 410.1f)
                lineTo(103.8f, 422.3f)
                curveTo(98.7f, 428.6f, 96.0f, 436.4f, 96.0f, 444.5f)
                curveTo(96.0f, 464.1f, 111.9f, 480.0f, 131.5f, 480.0f)
                lineTo(508.4f, 480.0f)
                curveTo(528.0f, 480.0f, 543.9f, 464.1f, 543.9f, 444.5f)
                curveTo(543.9f, 436.4f, 541.2f, 428.6f, 536.1f, 422.3f)
                lineTo(526.3f, 410.1f)
                curveTo(496.4f, 372.5f, 480.0f, 325.8f, 480.0f, 277.7f)
                lineTo(480.0f, 256.0f)
                curveTo(480.0f, 178.6f, 425.0f, 114.0f, 352.0f, 99.2f)
                lineTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(258.0f, 528.0f)
                curveTo(265.1f, 555.6f, 290.2f, 576.0f, 320.0f, 576.0f)
                curveTo(349.8f, 576.0f, 374.9f, 555.6f, 382.0f, 528.0f)
                lineTo(258.0f, 528.0f)
                close()
            }
        }
        .build()
        return _bell!!
    }

private var _bell: ImageVector? = null
