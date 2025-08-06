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

public val Fa.`User-lock`: ImageVector
    get() {
        if (`_user-lock` != null) {
            return `_user-lock`!!
        }
        `_user-lock` = Builder(name = "User-lock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 72.0f)
                curveTo(322.3f, 72.0f, 376.0f, 125.7f, 376.0f, 192.0f)
                curveTo(376.0f, 258.3f, 322.3f, 312.0f, 256.0f, 312.0f)
                curveTo(189.7f, 312.0f, 136.0f, 258.3f, 136.0f, 192.0f)
                curveTo(136.0f, 125.7f, 189.7f, 72.0f, 256.0f, 72.0f)
                close()
                moveTo(226.3f, 368.0f)
                lineTo(285.7f, 368.0f)
                curveTo(315.4f, 368.0f, 343.4f, 375.3f, 368.0f, 388.1f)
                lineTo(368.0f, 392.4f)
                curveTo(348.4f, 410.0f, 336.0f, 435.5f, 336.0f, 463.9f)
                lineTo(336.0f, 559.9f)
                curveTo(336.0f, 565.4f, 336.5f, 570.8f, 337.3f, 576.0f)
                lineTo(77.7f, 576.0f)
                curveTo(61.3f, 576.0f, 48.0f, 562.7f, 48.0f, 546.3f)
                curveTo(48.0f, 447.8f, 127.8f, 368.0f, 226.3f, 368.0f)
                close()
                moveTo(528.0f, 368.1f)
                curveTo(528.0f, 350.4f, 513.7f, 336.1f, 496.0f, 336.1f)
                curveTo(478.3f, 336.1f, 464.0f, 350.4f, 464.0f, 368.1f)
                lineTo(464.0f, 416.0f)
                lineTo(528.0f, 416.0f)
                lineTo(528.0f, 368.1f)
                close()
                moveTo(384.0f, 464.0f)
                curveTo(384.0f, 443.1f, 397.4f, 425.3f, 416.0f, 418.7f)
                lineTo(416.0f, 368.1f)
                curveTo(416.0f, 323.9f, 451.8f, 288.1f, 496.0f, 288.1f)
                curveTo(540.2f, 288.1f, 576.0f, 323.9f, 576.0f, 368.1f)
                lineTo(576.0f, 418.7f)
                curveTo(594.6f, 425.3f, 608.0f, 443.1f, 608.0f, 464.0f)
                lineTo(608.0f, 560.0f)
                curveTo(608.0f, 586.5f, 586.5f, 608.0f, 560.0f, 608.0f)
                lineTo(432.0f, 608.0f)
                curveTo(405.5f, 608.0f, 384.0f, 586.5f, 384.0f, 560.0f)
                lineTo(384.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_user-lock`!!
    }

private var `_user-lock`: ImageVector? = null
