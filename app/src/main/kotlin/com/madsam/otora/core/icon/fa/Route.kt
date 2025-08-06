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

public val Fa.Route: ImageVector
    get() {
        if (_route != null) {
            return _route!!
        }
        _route = Builder(name = "Route", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 160.0f)
                curveTo(576.0f, 210.2f, 516.9f, 285.1f, 491.4f, 315.0f)
                curveTo(487.6f, 319.4f, 482.0f, 321.1f, 476.9f, 320.0f)
                lineTo(384.0f, 320.0f)
                curveTo(366.3f, 320.0f, 352.0f, 334.3f, 352.0f, 352.0f)
                curveTo(352.0f, 369.7f, 366.3f, 384.0f, 384.0f, 384.0f)
                lineTo(480.0f, 384.0f)
                curveTo(533.0f, 384.0f, 576.0f, 427.0f, 576.0f, 480.0f)
                curveTo(576.0f, 533.0f, 533.0f, 576.0f, 480.0f, 576.0f)
                lineTo(203.6f, 576.0f)
                curveTo(212.3f, 566.1f, 222.9f, 553.4f, 233.6f, 539.2f)
                curveTo(239.9f, 530.8f, 246.4f, 521.6f, 252.6f, 512.0f)
                lineTo(480.0f, 512.0f)
                curveTo(497.7f, 512.0f, 512.0f, 497.7f, 512.0f, 480.0f)
                curveTo(512.0f, 462.3f, 497.7f, 448.0f, 480.0f, 448.0f)
                lineTo(384.0f, 448.0f)
                curveTo(331.0f, 448.0f, 288.0f, 405.0f, 288.0f, 352.0f)
                curveTo(288.0f, 299.0f, 331.0f, 256.0f, 384.0f, 256.0f)
                lineTo(423.8f, 256.0f)
                curveTo(402.8f, 224.5f, 384.0f, 188.3f, 384.0f, 160.0f)
                curveTo(384.0f, 107.0f, 427.0f, 64.0f, 480.0f, 64.0f)
                curveTo(533.0f, 64.0f, 576.0f, 107.0f, 576.0f, 160.0f)
                close()
                moveTo(181.1f, 553.1f)
                curveTo(177.3f, 557.4f, 173.9f, 561.2f, 171.0f, 564.4f)
                lineTo(169.2f, 566.4f)
                lineTo(169.0f, 566.2f)
                curveTo(163.0f, 570.8f, 154.4f, 570.2f, 149.0f, 564.4f)
                curveTo(123.8f, 537.0f, 64.0f, 466.5f, 64.0f, 416.0f)
                curveTo(64.0f, 363.0f, 107.0f, 320.0f, 160.0f, 320.0f)
                curveTo(213.0f, 320.0f, 256.0f, 363.0f, 256.0f, 416.0f)
                curveTo(256.0f, 446.0f, 234.9f, 483.0f, 212.5f, 513.9f)
                curveTo(201.8f, 528.6f, 190.8f, 541.9f, 181.7f, 552.4f)
                lineTo(181.1f, 553.1f)
                close()
                moveTo(192.0f, 416.0f)
                curveTo(192.0f, 398.3f, 177.7f, 384.0f, 160.0f, 384.0f)
                curveTo(142.3f, 384.0f, 128.0f, 398.3f, 128.0f, 416.0f)
                curveTo(128.0f, 433.7f, 142.3f, 448.0f, 160.0f, 448.0f)
                curveTo(177.7f, 448.0f, 192.0f, 433.7f, 192.0f, 416.0f)
                close()
                moveTo(480.0f, 192.0f)
                curveTo(497.7f, 192.0f, 512.0f, 177.7f, 512.0f, 160.0f)
                curveTo(512.0f, 142.3f, 497.7f, 128.0f, 480.0f, 128.0f)
                curveTo(462.3f, 128.0f, 448.0f, 142.3f, 448.0f, 160.0f)
                curveTo(448.0f, 177.7f, 462.3f, 192.0f, 480.0f, 192.0f)
                close()
            }
        }
        .build()
        return _route!!
    }

private var _route: ImageVector? = null
