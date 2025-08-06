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

public val Fa.Hotdog: ImageVector
    get() {
        if (_hotdog != null) {
            return _hotdog!!
        }
        _hotdog = Builder(name = "Hotdog", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 64.0f)
                curveTo(331.5f, 64.0f, 311.9f, 72.1f, 297.4f, 86.6f)
                lineTo(86.6f, 297.4f)
                curveTo(72.1f, 311.9f, 64.0f, 331.5f, 64.0f, 352.0f)
                curveTo(64.0f, 364.2f, 66.9f, 376.1f, 72.2f, 386.7f)
                lineTo(386.7f, 72.2f)
                curveTo(376.1f, 66.9f, 364.2f, 64.0f, 352.0f, 64.0f)
                close()
                moveTo(288.0f, 576.0f)
                curveTo(308.5f, 576.0f, 328.1f, 567.9f, 342.6f, 553.4f)
                lineTo(553.4f, 342.6f)
                curveTo(567.9f, 328.1f, 576.0f, 308.5f, 576.0f, 288.0f)
                curveTo(576.0f, 275.8f, 573.1f, 263.9f, 567.8f, 253.3f)
                lineTo(253.3f, 567.8f)
                curveTo(264.0f, 573.2f, 275.9f, 576.0f, 288.0f, 576.0f)
                close()
                moveTo(520.6f, 232.6f)
                curveTo(551.8f, 201.4f, 551.8f, 150.7f, 520.6f, 119.5f)
                curveTo(489.4f, 88.3f, 438.7f, 88.3f, 407.5f, 119.5f)
                lineTo(119.5f, 407.5f)
                curveTo(88.3f, 438.7f, 88.3f, 489.4f, 119.5f, 520.6f)
                curveTo(150.7f, 551.8f, 201.4f, 551.8f, 232.6f, 520.6f)
                lineTo(520.6f, 232.6f)
                close()
            }
        }
        .build()
        return _hotdog!!
    }

private var _hotdog: ImageVector? = null
