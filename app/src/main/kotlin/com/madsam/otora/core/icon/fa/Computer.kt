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

public val Fa.Computer: ImageVector
    get() {
        if (_computer != null) {
            return _computer!!
        }
        _computer = Builder(name = "Computer", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(380.8f, 96.0f)
                curveTo(372.7f, 110.1f, 368.0f, 126.5f, 368.0f, 144.0f)
                lineTo(368.0f, 160.0f)
                lineTo(96.0f, 160.0f)
                lineTo(96.0f, 384.0f)
                lineTo(368.0f, 384.0f)
                lineTo(368.0f, 448.0f)
                lineTo(96.0f, 448.0f)
                curveTo(60.7f, 448.0f, 32.0f, 419.3f, 32.0f, 384.0f)
                lineTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(380.8f, 96.0f)
                close()
                moveTo(368.0f, 496.0f)
                curveTo(368.0f, 513.5f, 372.7f, 529.9f, 380.8f, 544.0f)
                lineTo(152.0f, 544.0f)
                curveTo(138.7f, 544.0f, 128.0f, 533.3f, 128.0f, 520.0f)
                curveTo(128.0f, 506.7f, 138.7f, 496.0f, 152.0f, 496.0f)
                lineTo(368.0f, 496.0f)
                close()
                moveTo(464.0f, 96.0f)
                lineTo(560.0f, 96.0f)
                curveTo(586.5f, 96.0f, 608.0f, 117.5f, 608.0f, 144.0f)
                lineTo(608.0f, 496.0f)
                curveTo(608.0f, 522.5f, 586.5f, 544.0f, 560.0f, 544.0f)
                lineTo(464.0f, 544.0f)
                curveTo(437.5f, 544.0f, 416.0f, 522.5f, 416.0f, 496.0f)
                lineTo(416.0f, 144.0f)
                curveTo(416.0f, 117.5f, 437.5f, 96.0f, 464.0f, 96.0f)
                close()
                moveTo(488.0f, 160.0f)
                curveTo(474.7f, 160.0f, 464.0f, 170.7f, 464.0f, 184.0f)
                curveTo(464.0f, 197.3f, 474.7f, 208.0f, 488.0f, 208.0f)
                lineTo(536.0f, 208.0f)
                curveTo(549.3f, 208.0f, 560.0f, 197.3f, 560.0f, 184.0f)
                curveTo(560.0f, 170.7f, 549.3f, 160.0f, 536.0f, 160.0f)
                lineTo(488.0f, 160.0f)
                close()
                moveTo(488.0f, 256.0f)
                curveTo(474.7f, 256.0f, 464.0f, 266.7f, 464.0f, 280.0f)
                curveTo(464.0f, 293.3f, 474.7f, 304.0f, 488.0f, 304.0f)
                lineTo(536.0f, 304.0f)
                curveTo(549.3f, 304.0f, 560.0f, 293.3f, 560.0f, 280.0f)
                curveTo(560.0f, 266.7f, 549.3f, 256.0f, 536.0f, 256.0f)
                lineTo(488.0f, 256.0f)
                close()
                moveTo(544.0f, 400.0f)
                curveTo(544.0f, 382.3f, 529.7f, 368.0f, 512.0f, 368.0f)
                curveTo(494.3f, 368.0f, 480.0f, 382.3f, 480.0f, 400.0f)
                curveTo(480.0f, 417.7f, 494.3f, 432.0f, 512.0f, 432.0f)
                curveTo(529.7f, 432.0f, 544.0f, 417.7f, 544.0f, 400.0f)
                close()
            }
        }
        .build()
        return _computer!!
    }

private var _computer: ImageVector? = null
