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

public val Fa.Unlock: ImageVector
    get() {
        if (_unlock != null) {
            return _unlock!!
        }
        _unlock = Builder(name = "Unlock", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 160.0f)
                curveTo(256.0f, 124.7f, 284.7f, 96.0f, 320.0f, 96.0f)
                curveTo(351.7f, 96.0f, 378.0f, 119.0f, 383.1f, 149.3f)
                curveTo(386.0f, 166.7f, 402.5f, 178.5f, 420.0f, 175.6f)
                curveTo(437.5f, 172.7f, 449.2f, 156.2f, 446.3f, 138.7f)
                curveTo(436.1f, 78.1f, 383.5f, 32.0f, 320.0f, 32.0f)
                curveTo(249.3f, 32.0f, 192.0f, 89.3f, 192.0f, 160.0f)
                lineTo(192.0f, 224.0f)
                curveTo(156.7f, 224.0f, 128.0f, 252.7f, 128.0f, 288.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 288.0f)
                curveTo(512.0f, 252.7f, 483.3f, 224.0f, 448.0f, 224.0f)
                lineTo(256.0f, 224.0f)
                lineTo(256.0f, 160.0f)
                close()
            }
        }
        .build()
        return _unlock!!
    }

private var _unlock: ImageVector? = null
