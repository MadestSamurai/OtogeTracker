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

public val Fa.`User-times`: ImageVector
    get() {
        if (`_user-times` != null) {
            return `_user-times`!!
        }
        `_user-times` = Builder(name = "User-times", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(136.4f, 192.0f)
                curveTo(136.4f, 125.7f, 190.1f, 72.0f, 256.4f, 72.0f)
                curveTo(322.7f, 72.0f, 376.4f, 125.7f, 376.4f, 192.0f)
                curveTo(376.4f, 258.3f, 322.7f, 312.0f, 256.4f, 312.0f)
                curveTo(190.1f, 312.0f, 136.4f, 258.3f, 136.4f, 192.0f)
                close()
                moveTo(48.4f, 546.3f)
                curveTo(48.4f, 447.8f, 128.2f, 368.0f, 226.7f, 368.0f)
                lineTo(286.1f, 368.0f)
                curveTo(384.6f, 368.0f, 464.4f, 447.8f, 464.4f, 546.3f)
                curveTo(464.4f, 562.7f, 451.1f, 576.0f, 434.7f, 576.0f)
                lineTo(78.1f, 576.0f)
                curveTo(61.7f, 576.0f, 48.4f, 562.7f, 48.4f, 546.3f)
                close()
                moveTo(612.3f, 188.1f)
                curveTo(621.7f, 197.5f, 621.7f, 212.7f, 612.3f, 222.0f)
                lineTo(578.4f, 255.9f)
                lineTo(612.3f, 289.8f)
                curveTo(621.7f, 299.2f, 621.7f, 314.4f, 612.3f, 323.7f)
                curveTo(602.9f, 333.0f, 587.7f, 333.1f, 578.4f, 323.7f)
                lineTo(544.5f, 289.8f)
                lineTo(510.6f, 323.7f)
                curveTo(501.2f, 333.1f, 486.0f, 333.1f, 476.7f, 323.7f)
                curveTo(467.4f, 314.3f, 467.3f, 299.1f, 476.7f, 289.8f)
                lineTo(510.6f, 255.9f)
                lineTo(476.7f, 222.0f)
                curveTo(467.3f, 212.6f, 467.3f, 197.4f, 476.7f, 188.1f)
                curveTo(486.1f, 178.8f, 501.3f, 178.7f, 510.6f, 188.1f)
                lineTo(544.5f, 222.0f)
                lineTo(578.4f, 188.1f)
                curveTo(587.8f, 178.7f, 603.0f, 178.7f, 612.3f, 188.1f)
                close()
            }
        }
        .build()
        return `_user-times`!!
    }

private var `_user-times`: ImageVector? = null
