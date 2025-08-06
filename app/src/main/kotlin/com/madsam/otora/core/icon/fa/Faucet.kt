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

public val Fa.Faucet: ImageVector
    get() {
        if (_faucet != null) {
            return _faucet!!
        }
        _faucet = Builder(name = "Faucet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 270.3f, 96.0f, 288.0f, 96.0f)
                curveTo(305.7f, 96.0f, 320.0f, 110.3f, 320.0f, 128.0f)
                lineTo(416.0f, 128.0f)
                curveTo(433.7f, 128.0f, 448.0f, 142.3f, 448.0f, 160.0f)
                curveTo(448.0f, 177.7f, 433.7f, 192.0f, 416.0f, 192.0f)
                lineTo(320.0f, 192.0f)
                lineTo(320.0f, 256.0f)
                lineTo(338.7f, 256.0f)
                curveTo(347.2f, 256.0f, 355.3f, 259.4f, 361.3f, 265.4f)
                lineTo(383.9f, 288.0f)
                lineTo(415.9f, 288.0f)
                curveTo(504.3f, 288.0f, 575.9f, 359.6f, 575.9f, 448.0f)
                curveTo(575.9f, 465.7f, 561.6f, 480.0f, 543.9f, 480.0f)
                lineTo(479.9f, 480.0f)
                curveTo(462.2f, 480.0f, 447.9f, 465.7f, 447.9f, 448.0f)
                curveTo(447.9f, 430.3f, 433.6f, 416.0f, 415.9f, 416.0f)
                lineTo(379.8f, 416.0f)
                curveTo(359.6f, 445.0f, 325.9f, 464.0f, 287.9f, 464.0f)
                curveTo(249.9f, 464.0f, 216.2f, 445.0f, 196.0f, 416.0f)
                lineTo(96.0f, 416.0f)
                curveTo(78.3f, 416.0f, 64.0f, 401.7f, 64.0f, 384.0f)
                lineTo(64.0f, 320.0f)
                curveTo(64.0f, 302.3f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(192.0f, 288.0f)
                lineTo(214.6f, 265.4f)
                curveTo(220.6f, 259.4f, 228.7f, 256.0f, 237.2f, 256.0f)
                lineTo(255.9f, 256.0f)
                lineTo(255.9f, 192.0f)
                lineTo(159.9f, 192.0f)
                curveTo(142.2f, 192.0f, 127.9f, 177.7f, 127.9f, 160.0f)
                curveTo(127.9f, 142.3f, 142.3f, 128.0f, 160.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                close()
            }
        }
        .build()
        return _faucet!!
    }

private var _faucet: ImageVector? = null
