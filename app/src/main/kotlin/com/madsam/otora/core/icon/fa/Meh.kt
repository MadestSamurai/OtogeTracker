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

public val Fa.Meh: ImageVector
    get() {
        if (_meh != null) {
            return _meh!!
        }
        _meh = Builder(name = "Meh", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
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
                moveTo(240.0f, 240.0f)
                curveTo(257.7f, 240.0f, 272.0f, 254.3f, 272.0f, 272.0f)
                curveTo(272.0f, 289.7f, 257.7f, 304.0f, 240.0f, 304.0f)
                curveTo(222.3f, 304.0f, 208.0f, 289.7f, 208.0f, 272.0f)
                curveTo(208.0f, 254.3f, 222.3f, 240.0f, 240.0f, 240.0f)
                close()
                moveTo(368.0f, 272.0f)
                curveTo(368.0f, 254.3f, 382.3f, 240.0f, 400.0f, 240.0f)
                curveTo(417.7f, 240.0f, 432.0f, 254.3f, 432.0f, 272.0f)
                curveTo(432.0f, 289.7f, 417.7f, 304.0f, 400.0f, 304.0f)
                curveTo(382.3f, 304.0f, 368.0f, 289.7f, 368.0f, 272.0f)
                close()
                moveTo(240.0f, 384.0f)
                lineTo(400.0f, 384.0f)
                curveTo(413.3f, 384.0f, 424.0f, 394.7f, 424.0f, 408.0f)
                curveTo(424.0f, 421.3f, 413.3f, 432.0f, 400.0f, 432.0f)
                lineTo(240.0f, 432.0f)
                curveTo(226.7f, 432.0f, 216.0f, 421.3f, 216.0f, 408.0f)
                curveTo(216.0f, 394.7f, 226.7f, 384.0f, 240.0f, 384.0f)
                close()
            }
        }
        .build()
        return _meh!!
    }

private var _meh: ImageVector? = null
