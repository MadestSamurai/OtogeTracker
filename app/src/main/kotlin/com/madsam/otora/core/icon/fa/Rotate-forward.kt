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

public val Fa.`Rotate-forward`: ImageVector
    get() {
        if (`_rotate-forward` != null) {
            return `_rotate-forward`!!
        }
        `_rotate-forward` = Builder(name = "Rotate-forward", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(552.0f, 256.0f)
                lineTo(408.0f, 256.0f)
                curveTo(398.3f, 256.0f, 389.5f, 250.2f, 385.8f, 241.2f)
                curveTo(382.1f, 232.2f, 384.1f, 221.9f, 391.0f, 215.0f)
                lineTo(437.7f, 168.3f)
                curveTo(362.4f, 109.7f, 253.4f, 115.0f, 184.2f, 184.2f)
                curveTo(109.2f, 259.2f, 109.2f, 380.7f, 184.2f, 455.7f)
                curveTo(259.2f, 530.7f, 380.7f, 530.7f, 455.7f, 455.7f)
                curveTo(463.9f, 447.5f, 471.2f, 438.8f, 477.6f, 429.6f)
                curveTo(487.7f, 415.1f, 507.7f, 411.6f, 522.2f, 421.7f)
                curveTo(536.7f, 431.8f, 540.2f, 451.8f, 530.1f, 466.3f)
                curveTo(521.6f, 478.5f, 511.9f, 490.1f, 501.0f, 501.0f)
                curveTo(401.0f, 601.0f, 238.9f, 601.0f, 139.0f, 501.0f)
                curveTo(39.1f, 401.0f, 39.0f, 239.0f, 139.0f, 139.0f)
                curveTo(233.3f, 44.7f, 382.7f, 39.4f, 483.3f, 122.8f)
                lineTo(535.0f, 71.0f)
                curveTo(541.9f, 64.1f, 552.2f, 62.1f, 561.2f, 65.8f)
                curveTo(570.2f, 69.5f, 576.0f, 78.3f, 576.0f, 88.0f)
                lineTo(576.0f, 232.0f)
                curveTo(576.0f, 245.3f, 565.3f, 256.0f, 552.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_rotate-forward`!!
    }

private var `_rotate-forward`: ImageVector? = null
