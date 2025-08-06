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

public val Fa.Trophy: ImageVector
    get() {
        if (_trophy != null) {
            return _trophy!!
        }
        _trophy = Builder(name = "Trophy", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.3f, 64.0f)
                lineTo(432.3f, 64.0f)
                curveTo(458.8f, 64.0f, 480.4f, 85.8f, 479.4f, 112.2f)
                curveTo(479.2f, 117.5f, 479.0f, 122.8f, 478.7f, 128.0f)
                lineTo(528.3f, 128.0f)
                curveTo(554.4f, 128.0f, 577.4f, 149.6f, 575.4f, 177.8f)
                curveTo(567.9f, 281.5f, 514.9f, 338.5f, 457.4f, 368.3f)
                curveTo(441.6f, 376.5f, 425.5f, 382.6f, 410.2f, 387.1f)
                curveTo(390.0f, 415.7f, 369.0f, 430.8f, 352.3f, 438.9f)
                lineTo(352.3f, 512.0f)
                lineTo(416.3f, 512.0f)
                curveTo(434.0f, 512.0f, 448.3f, 526.3f, 448.3f, 544.0f)
                curveTo(448.3f, 561.7f, 434.0f, 576.0f, 416.3f, 576.0f)
                lineTo(224.3f, 576.0f)
                curveTo(206.6f, 576.0f, 192.3f, 561.7f, 192.3f, 544.0f)
                curveTo(192.3f, 526.3f, 206.6f, 512.0f, 224.3f, 512.0f)
                lineTo(288.3f, 512.0f)
                lineTo(288.3f, 438.9f)
                curveTo(272.3f, 431.2f, 252.4f, 416.9f, 233.0f, 390.6f)
                curveTo(214.6f, 385.8f, 194.6f, 378.5f, 175.1f, 367.5f)
                curveTo(121.0f, 337.2f, 72.2f, 280.1f, 65.2f, 177.6f)
                curveTo(63.3f, 149.5f, 86.2f, 127.9f, 112.3f, 127.9f)
                lineTo(161.9f, 127.9f)
                curveTo(161.6f, 122.7f, 161.4f, 117.5f, 161.2f, 112.1f)
                curveTo(160.2f, 85.6f, 181.8f, 63.9f, 208.3f, 63.9f)
                close()
                moveTo(165.5f, 176.0f)
                lineTo(113.1f, 176.0f)
                curveTo(119.3f, 260.7f, 158.2f, 303.1f, 198.3f, 325.6f)
                curveTo(183.9f, 288.3f, 172.0f, 239.6f, 165.5f, 176.0f)
                close()
                moveTo(444.0f, 320.8f)
                curveTo(484.5f, 297.0f, 521.1f, 254.7f, 527.3f, 176.0f)
                lineTo(475.0f, 176.0f)
                curveTo(468.8f, 236.9f, 457.6f, 284.2f, 444.0f, 320.8f)
                close()
            }
        }
        .build()
        return _trophy!!
    }

private var _trophy: ImageVector? = null
