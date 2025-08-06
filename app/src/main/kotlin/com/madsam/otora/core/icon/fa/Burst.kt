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

public val Fa.Burst: ImageVector
    get() {
        if (_burst != null) {
            return _burst!!
        }
        _burst = Builder(name = "Burst", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(101.6f, 68.2f)
                curveTo(92.0f, 61.7f, 79.2f, 62.9f, 71.0f, 71.0f)
                curveTo(62.8f, 79.1f, 61.7f, 92.0f, 68.2f, 101.6f)
                lineTo(180.2f, 264.9f)
                lineTo(80.6f, 297.2f)
                curveTo(70.7f, 300.4f, 64.0f, 309.6f, 64.0f, 320.0f)
                curveTo(64.0f, 330.4f, 70.7f, 339.6f, 80.6f, 342.8f)
                lineTo(183.7f, 376.2f)
                lineTo(130.8f, 476.8f)
                curveTo(125.9f, 486.1f, 127.6f, 497.5f, 135.1f, 504.9f)
                curveTo(142.6f, 512.3f, 153.9f, 514.1f, 163.2f, 509.2f)
                lineTo(263.8f, 456.3f)
                lineTo(297.2f, 559.4f)
                curveTo(300.4f, 569.3f, 309.6f, 576.0f, 320.0f, 576.0f)
                curveTo(330.4f, 576.0f, 339.6f, 569.3f, 342.8f, 559.4f)
                lineTo(376.2f, 456.3f)
                lineTo(476.8f, 509.2f)
                curveTo(486.1f, 514.1f, 497.5f, 512.4f, 504.9f, 504.9f)
                curveTo(512.3f, 497.4f, 514.1f, 486.1f, 509.2f, 476.8f)
                lineTo(456.3f, 376.2f)
                lineTo(559.4f, 342.8f)
                curveTo(569.3f, 339.6f, 576.0f, 330.4f, 576.0f, 320.0f)
                curveTo(576.0f, 309.6f, 569.3f, 300.4f, 559.4f, 297.2f)
                lineTo(452.9f, 262.7f)
                lineTo(478.6f, 192.3f)
                curveTo(481.8f, 183.5f, 479.6f, 173.7f, 473.0f, 167.1f)
                curveTo(466.4f, 160.5f, 456.6f, 158.3f, 447.8f, 161.5f)
                lineTo(377.4f, 187.2f)
                lineTo(342.9f, 80.7f)
                curveTo(339.6f, 70.7f, 330.4f, 64.0f, 320.0f, 64.0f)
                curveTo(309.6f, 64.0f, 300.4f, 70.7f, 297.2f, 80.6f)
                lineTo(264.9f, 180.2f)
                lineTo(101.6f, 68.2f)
                close()
            }
        }
        .build()
        return _burst!!
    }

private var _burst: ImageVector? = null
