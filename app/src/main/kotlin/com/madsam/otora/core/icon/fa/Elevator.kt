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

public val Fa.Elevator: ImageVector
    get() {
        if (_elevator != null) {
            return _elevator!!
        }
        _elevator = Builder(name = "Elevator", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(356.7f, 59.3f)
                lineTo(420.7f, 123.3f)
                curveTo(426.9f, 129.5f, 437.1f, 129.5f, 443.3f, 123.3f)
                lineTo(507.3f, 59.3f)
                curveTo(511.9f, 54.7f, 513.2f, 47.8f, 510.8f, 41.9f)
                curveTo(508.4f, 36.0f, 502.5f, 32.0f, 496.0f, 32.0f)
                lineTo(368.0f, 32.0f)
                curveTo(361.5f, 32.0f, 355.7f, 35.9f, 353.2f, 41.9f)
                curveTo(350.7f, 47.9f, 352.1f, 54.8f, 356.7f, 59.3f)
                close()
                moveTo(196.7f, 36.7f)
                lineTo(132.7f, 100.7f)
                curveTo(128.1f, 105.3f, 126.8f, 112.2f, 129.2f, 118.1f)
                curveTo(131.6f, 124.0f, 137.5f, 128.0f, 144.0f, 128.0f)
                lineTo(272.0f, 128.0f)
                curveTo(278.5f, 128.0f, 284.3f, 124.1f, 286.8f, 118.1f)
                curveTo(289.3f, 112.1f, 287.9f, 105.2f, 283.3f, 100.7f)
                lineTo(219.3f, 36.7f)
                curveTo(213.1f, 30.5f, 202.9f, 30.5f, 196.7f, 36.7f)
                close()
                moveTo(128.0f, 192.0f)
                curveTo(92.7f, 192.0f, 64.0f, 220.7f, 64.0f, 256.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 256.0f)
                curveTo(576.0f, 220.7f, 547.3f, 192.0f, 512.0f, 192.0f)
                lineTo(128.0f, 192.0f)
                close()
                moveTo(224.0f, 288.0f)
                curveTo(250.5f, 288.0f, 272.0f, 309.5f, 272.0f, 336.0f)
                curveTo(272.0f, 362.5f, 250.5f, 384.0f, 224.0f, 384.0f)
                curveTo(197.5f, 384.0f, 176.0f, 362.5f, 176.0f, 336.0f)
                curveTo(176.0f, 309.5f, 197.5f, 288.0f, 224.0f, 288.0f)
                close()
                moveTo(144.0f, 464.0f)
                curveTo(144.0f, 437.5f, 165.5f, 416.0f, 192.0f, 416.0f)
                lineTo(256.0f, 416.0f)
                curveTo(282.5f, 416.0f, 304.0f, 437.5f, 304.0f, 464.0f)
                lineTo(304.0f, 480.0f)
                curveTo(304.0f, 497.7f, 289.7f, 512.0f, 272.0f, 512.0f)
                lineTo(176.0f, 512.0f)
                curveTo(158.3f, 512.0f, 144.0f, 497.7f, 144.0f, 480.0f)
                lineTo(144.0f, 464.0f)
                close()
                moveTo(336.0f, 464.0f)
                curveTo(336.0f, 437.5f, 357.5f, 416.0f, 384.0f, 416.0f)
                lineTo(448.0f, 416.0f)
                curveTo(474.5f, 416.0f, 496.0f, 437.5f, 496.0f, 464.0f)
                lineTo(496.0f, 480.0f)
                curveTo(496.0f, 497.7f, 481.7f, 512.0f, 464.0f, 512.0f)
                lineTo(368.0f, 512.0f)
                curveTo(350.3f, 512.0f, 336.0f, 497.7f, 336.0f, 480.0f)
                lineTo(336.0f, 464.0f)
                close()
                moveTo(368.0f, 336.0f)
                curveTo(368.0f, 309.5f, 389.5f, 288.0f, 416.0f, 288.0f)
                curveTo(442.5f, 288.0f, 464.0f, 309.5f, 464.0f, 336.0f)
                curveTo(464.0f, 362.5f, 442.5f, 384.0f, 416.0f, 384.0f)
                curveTo(389.5f, 384.0f, 368.0f, 362.5f, 368.0f, 336.0f)
                close()
            }
        }
        .build()
        return _elevator!!
    }

private var _elevator: ImageVector? = null
