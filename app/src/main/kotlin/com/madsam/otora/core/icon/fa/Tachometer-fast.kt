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

public val Fa.`Tachometer-fast`: ImageVector
    get() {
        if (`_tachometer-fast` != null) {
            return `_tachometer-fast`!!
        }
        `_tachometer-fast` = Builder(name = "Tachometer-fast", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(384.0f, 416.0f)
                curveTo(384.0f, 399.8f, 378.0f, 384.9f, 368.0f, 373.7f)
                lineTo(437.5f, 234.8f)
                curveTo(443.4f, 222.9f, 438.6f, 208.5f, 426.8f, 202.6f)
                curveTo(415.0f, 196.7f, 400.5f, 201.5f, 394.6f, 213.3f)
                lineTo(325.1f, 352.2f)
                curveTo(323.4f, 352.1f, 321.7f, 352.0f, 320.0f, 352.0f)
                curveTo(284.7f, 352.0f, 256.0f, 380.7f, 256.0f, 416.0f)
                curveTo(256.0f, 451.3f, 284.7f, 480.0f, 320.0f, 480.0f)
                curveTo(355.3f, 480.0f, 384.0f, 451.3f, 384.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_tachometer-fast`!!
    }

private var `_tachometer-fast`: ImageVector? = null
