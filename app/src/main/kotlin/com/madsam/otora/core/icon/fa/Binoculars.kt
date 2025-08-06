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

public val Fa.Binoculars: ImageVector
    get() {
        if (_binoculars != null) {
            return _binoculars!!
        }
        _binoculars = Builder(name = "Binoculars", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 96.0f)
                lineTo(224.0f, 96.0f)
                curveTo(241.7f, 96.0f, 256.0f, 110.3f, 256.0f, 128.0f)
                lineTo(256.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                lineTo(160.0f, 128.0f)
                curveTo(160.0f, 110.3f, 174.3f, 96.0f, 192.0f, 96.0f)
                close()
                moveTo(256.0f, 192.0f)
                lineTo(256.0f, 512.0f)
                curveTo(256.0f, 529.7f, 241.7f, 544.0f, 224.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 452.9f)
                curveTo(64.0f, 418.3f, 73.4f, 384.3f, 91.2f, 354.6f)
                curveTo(104.9f, 331.8f, 113.7f, 306.4f, 117.0f, 280.0f)
                lineTo(124.5f, 220.0f)
                curveTo(126.5f, 204.0f, 140.1f, 192.0f, 156.3f, 192.0f)
                lineTo(256.1f, 192.0f)
                close()
                moveTo(483.8f, 192.0f)
                curveTo(499.9f, 192.0f, 513.6f, 204.0f, 515.6f, 220.0f)
                lineTo(523.0f, 280.0f)
                curveTo(526.3f, 306.4f, 535.1f, 331.8f, 548.8f, 354.6f)
                curveTo(566.6f, 384.3f, 576.0f, 418.3f, 576.0f, 452.9f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(416.0f, 544.0f)
                curveTo(398.3f, 544.0f, 384.0f, 529.7f, 384.0f, 512.0f)
                lineTo(384.0f, 192.0f)
                lineTo(483.8f, 192.0f)
                close()
                moveTo(384.0f, 128.0f)
                curveTo(384.0f, 110.3f, 398.3f, 96.0f, 416.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(465.7f, 96.0f, 480.0f, 110.3f, 480.0f, 128.0f)
                lineTo(480.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                lineTo(384.0f, 128.0f)
                close()
                moveTo(352.0f, 192.0f)
                lineTo(352.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 192.0f)
                lineTo(352.0f, 192.0f)
                close()
            }
        }
        .build()
        return _binoculars!!
    }

private var _binoculars: ImageVector? = null
