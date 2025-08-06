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

public val Fa.Bong: ImageVector
    get() {
        if (_bong != null) {
            return _bong!!
        }
        _bong = Builder(name = "Bong", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.5f, 448.0f)
                curveTo(512.5f, 489.5f, 499.4f, 527.9f, 477.0f, 559.3f)
                curveTo(469.1f, 570.4f, 455.8f, 576.0f, 442.2f, 576.0f)
                lineTo(198.9f, 576.0f)
                curveTo(185.2f, 576.0f, 172.0f, 570.4f, 164.1f, 559.3f)
                curveTo(141.7f, 527.9f, 128.6f, 489.5f, 128.6f, 448.0f)
                curveTo(128.6f, 376.9f, 167.2f, 314.9f, 224.6f, 281.7f)
                lineTo(224.6f, 128.0f)
                curveTo(206.9f, 128.0f, 192.6f, 113.7f, 192.6f, 96.0f)
                curveTo(192.6f, 78.3f, 206.9f, 64.0f, 224.6f, 64.0f)
                lineTo(416.6f, 64.0f)
                curveTo(434.3f, 64.0f, 448.6f, 78.3f, 448.6f, 96.0f)
                curveTo(448.6f, 113.7f, 434.3f, 128.0f, 416.6f, 128.0f)
                lineTo(416.6f, 281.7f)
                curveTo(430.8f, 289.9f, 443.8f, 299.9f, 455.4f, 311.3f)
                lineTo(494.7f, 272.0f)
                lineTo(487.7f, 265.0f)
                curveTo(478.3f, 255.6f, 478.3f, 240.4f, 487.7f, 231.1f)
                curveTo(497.1f, 221.8f, 512.3f, 221.7f, 521.6f, 231.1f)
                curveTo(537.6f, 247.1f, 553.6f, 263.1f, 569.6f, 279.1f)
                curveTo(579.0f, 288.5f, 579.0f, 303.7f, 569.6f, 313.0f)
                curveTo(560.2f, 322.3f, 545.0f, 322.4f, 535.7f, 313.0f)
                lineTo(528.7f, 306.0f)
                lineTo(485.4f, 349.3f)
                curveTo(502.7f, 378.2f, 512.7f, 411.9f, 512.7f, 448.1f)
                close()
                moveTo(352.5f, 128.0f)
                lineTo(288.5f, 128.0f)
                lineTo(288.5f, 318.6f)
                lineTo(256.5f, 337.1f)
                curveTo(237.0f, 348.4f, 220.8f, 364.6f, 209.6f, 384.0f)
                lineTo(431.4f, 384.0f)
                curveTo(420.2f, 364.6f, 404.0f, 348.4f, 384.5f, 337.1f)
                lineTo(352.5f, 318.6f)
                lineTo(352.5f, 128.0f)
                close()
            }
        }
        .build()
        return _bong!!
    }

private var _bong: ImageVector? = null
