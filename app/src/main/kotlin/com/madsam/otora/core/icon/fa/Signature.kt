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

public val Fa.Signature: ImageVector
    get() {
        if (_signature != null) {
            return _signature!!
        }
        _signature = Builder(name = "Signature", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 192.0f)
                curveTo(192.0f, 174.3f, 206.3f, 160.0f, 224.0f, 160.0f)
                curveTo(241.7f, 160.0f, 256.0f, 174.3f, 256.0f, 192.0f)
                lineTo(256.0f, 199.8f)
                curveTo(256.0f, 227.5f, 253.6f, 255.1f, 248.9f, 282.3f)
                lineTo(164.5f, 307.6f)
                curveTo(123.9f, 319.8f, 96.1f, 357.2f, 96.1f, 399.6f)
                lineTo(96.1f, 432.0f)
                lineTo(24.1f, 432.0f)
                curveTo(10.8f, 432.0f, 0.1f, 442.7f, 0.1f, 456.0f)
                curveTo(0.1f, 469.3f, 10.8f, 480.0f, 24.1f, 480.0f)
                lineTo(96.6f, 480.0f)
                curveTo(100.8f, 516.0f, 131.4f, 544.0f, 168.6f, 544.0f)
                curveTo(194.6f, 544.0f, 218.6f, 530.1f, 231.5f, 507.5f)
                lineTo(245.4f, 483.2f)
                curveTo(272.2f, 436.2f, 291.9f, 385.5f, 303.8f, 332.7f)
                lineTo(398.2f, 304.4f)
                lineTo(385.7f, 341.9f)
                curveTo(382.4f, 351.7f, 384.1f, 362.4f, 390.1f, 370.7f)
                curveTo(396.1f, 379.0f, 405.7f, 384.0f, 416.0f, 384.0f)
                lineTo(544.0f, 384.0f)
                curveTo(561.7f, 384.0f, 576.0f, 369.7f, 576.0f, 352.0f)
                curveTo(576.0f, 334.3f, 561.7f, 320.0f, 544.0f, 320.0f)
                lineTo(460.4f, 320.0f)
                lineTo(478.4f, 266.1f)
                curveTo(482.2f, 254.8f, 479.3f, 242.3f, 471.0f, 233.7f)
                curveTo(462.7f, 225.1f, 450.3f, 221.9f, 438.8f, 225.3f)
                lineTo(316.4f, 262.1f)
                curveTo(318.8f, 241.4f, 320.0f, 220.7f, 320.0f, 199.8f)
                lineTo(320.0f, 192.0f)
                curveTo(320.0f, 139.0f, 277.0f, 96.0f, 224.0f, 96.0f)
                curveTo(171.0f, 96.0f, 128.0f, 139.0f, 128.0f, 192.0f)
                lineTo(128.0f, 224.0f)
                curveTo(128.0f, 241.7f, 142.3f, 256.0f, 160.0f, 256.0f)
                curveTo(177.7f, 256.0f, 192.0f, 241.7f, 192.0f, 224.0f)
                lineTo(192.0f, 192.0f)
                close()
                moveTo(182.8f, 369.0f)
                lineTo(231.8f, 354.3f)
                curveTo(221.4f, 388.1f, 207.3f, 420.7f, 189.7f, 451.5f)
                lineTo(175.8f, 475.8f)
                curveTo(174.3f, 478.4f, 171.5f, 480.1f, 168.4f, 480.1f)
                curveTo(163.7f, 480.1f, 159.9f, 476.3f, 159.9f, 471.6f)
                lineTo(159.9f, 399.7f)
                curveTo(159.9f, 385.6f, 169.2f, 373.1f, 182.7f, 369.0f)
                close()
                moveTo(616.0f, 480.0f)
                curveTo(629.3f, 480.0f, 640.0f, 469.3f, 640.0f, 456.0f)
                curveTo(640.0f, 442.7f, 629.3f, 432.0f, 616.0f, 432.0f)
                lineTo(323.1f, 432.0f)
                curveTo(316.6f, 448.3f, 309.4f, 464.3f, 301.5f, 480.0f)
                lineTo(616.0f, 480.0f)
                close()
            }
        }
        .build()
        return _signature!!
    }

private var _signature: ImageVector? = null
