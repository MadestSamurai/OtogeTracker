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

public val Fa.Rocket: ImageVector
    get() {
        if (_rocket != null) {
            return _rocket!!
        }
        _rocket = Builder(name = "Rocket", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 384.0f)
                lineTo(88.5f, 384.0f)
                curveTo(63.6f, 384.0f, 48.3f, 356.9f, 61.1f, 335.5f)
                lineTo(114.0f, 247.3f)
                curveTo(122.7f, 232.8f, 138.3f, 224.0f, 155.2f, 224.0f)
                lineTo(250.2f, 224.0f)
                curveTo(326.3f, 95.1f, 439.8f, 88.6f, 515.7f, 99.7f)
                curveTo(528.5f, 101.6f, 538.5f, 111.6f, 540.3f, 124.3f)
                curveTo(551.4f, 200.2f, 544.9f, 313.7f, 416.0f, 389.8f)
                lineTo(416.0f, 484.8f)
                curveTo(416.0f, 501.7f, 407.2f, 517.3f, 392.7f, 526.0f)
                lineTo(304.5f, 578.9f)
                curveTo(283.2f, 591.7f, 256.0f, 576.3f, 256.0f, 551.5f)
                lineTo(256.0f, 448.0f)
                curveTo(256.0f, 412.7f, 227.3f, 384.0f, 192.0f, 384.0f)
                lineTo(191.9f, 384.0f)
                close()
                moveTo(464.0f, 224.0f)
                curveTo(464.0f, 197.5f, 442.5f, 176.0f, 416.0f, 176.0f)
                curveTo(389.5f, 176.0f, 368.0f, 197.5f, 368.0f, 224.0f)
                curveTo(368.0f, 250.5f, 389.5f, 272.0f, 416.0f, 272.0f)
                curveTo(442.5f, 272.0f, 464.0f, 250.5f, 464.0f, 224.0f)
                close()
            }
        }
        .build()
        return _rocket!!
    }

private var _rocket: ImageVector? = null
