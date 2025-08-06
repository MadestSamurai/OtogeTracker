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

public val Fa.Inbox: ImageVector
    get() {
        if (_inbox != null) {
            return _inbox!!
        }
        _inbox = Builder(name = "Inbox", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(155.8f, 96.0f)
                curveTo(123.9f, 96.0f, 96.9f, 119.4f, 92.4f, 150.9f)
                lineTo(64.6f, 345.2f)
                curveTo(64.2f, 348.2f, 64.0f, 351.2f, 64.0f, 354.3f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 515.3f, 92.7f, 544.0f, 128.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(547.3f, 544.0f, 576.0f, 515.3f, 576.0f, 480.0f)
                lineTo(576.0f, 354.3f)
                curveTo(576.0f, 351.3f, 575.8f, 348.2f, 575.4f, 345.2f)
                lineTo(547.6f, 150.9f)
                curveTo(543.1f, 119.4f, 516.1f, 96.0f, 484.2f, 96.0f)
                lineTo(155.8f, 96.0f)
                close()
                moveTo(155.8f, 160.0f)
                lineTo(484.3f, 160.0f)
                lineTo(511.7f, 352.0f)
                lineTo(451.8f, 352.0f)
                curveTo(439.7f, 352.0f, 428.6f, 358.8f, 423.2f, 369.7f)
                lineTo(408.9f, 398.3f)
                curveTo(403.5f, 409.1f, 392.4f, 416.0f, 380.3f, 416.0f)
                lineTo(259.9f, 416.0f)
                curveTo(247.8f, 416.0f, 236.7f, 409.2f, 231.3f, 398.3f)
                lineTo(217.0f, 369.7f)
                curveTo(211.6f, 358.9f, 200.5f, 352.0f, 188.4f, 352.0f)
                lineTo(128.3f, 352.0f)
                lineTo(155.8f, 160.0f)
                close()
            }
        }
        .build()
        return _inbox!!
    }

private var _inbox: ImageVector? = null
