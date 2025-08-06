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

public val Fa.`User-shield`: ImageVector
    get() {
        if (`_user-shield` != null) {
            return `_user-shield`!!
        }
        `_user-shield` = Builder(name = "User-shield", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 312.0f)
                curveTo(322.3f, 312.0f, 376.0f, 258.3f, 376.0f, 192.0f)
                curveTo(376.0f, 125.7f, 322.3f, 72.0f, 256.0f, 72.0f)
                curveTo(189.7f, 72.0f, 136.0f, 125.7f, 136.0f, 192.0f)
                curveTo(136.0f, 258.3f, 189.7f, 312.0f, 256.0f, 312.0f)
                close()
                moveTo(226.3f, 368.0f)
                curveTo(127.8f, 368.0f, 48.0f, 447.8f, 48.0f, 546.3f)
                curveTo(48.0f, 562.7f, 61.3f, 576.0f, 77.7f, 576.0f)
                lineTo(329.2f, 576.0f)
                curveTo(293.0f, 533.4f, 272.0f, 478.5f, 272.0f, 420.4f)
                lineTo(272.0f, 389.3f)
                curveTo(272.0f, 382.0f, 273.0f, 374.8f, 274.9f, 368.0f)
                lineTo(226.3f, 368.0f)
                close()
                moveTo(477.3f, 552.5f)
                lineTo(464.0f, 558.8f)
                lineTo(464.0f, 370.7f)
                lineTo(560.0f, 402.7f)
                lineTo(560.0f, 422.3f)
                curveTo(560.0f, 478.1f, 527.8f, 528.8f, 477.3f, 552.6f)
                close()
                moveTo(453.9f, 323.5f)
                lineTo(341.9f, 360.8f)
                curveTo(328.8f, 365.2f, 320.0f, 377.4f, 320.0f, 391.2f)
                lineTo(320.0f, 422.3f)
                curveTo(320.0f, 496.7f, 363.0f, 564.4f, 430.2f, 596.0f)
                lineTo(448.7f, 604.7f)
                curveTo(453.5f, 606.9f, 458.7f, 608.1f, 463.9f, 608.1f)
                curveTo(469.1f, 608.1f, 474.4f, 606.9f, 479.1f, 604.7f)
                lineTo(497.6f, 596.0f)
                curveTo(565.0f, 564.3f, 608.0f, 496.6f, 608.0f, 422.2f)
                lineTo(608.0f, 391.1f)
                curveTo(608.0f, 377.3f, 599.2f, 365.1f, 586.1f, 360.7f)
                lineTo(474.1f, 323.4f)
                curveTo(467.5f, 321.2f, 460.4f, 321.2f, 453.9f, 323.4f)
                close()
            }
        }
        .build()
        return `_user-shield`!!
    }

private var `_user-shield`: ImageVector? = null
