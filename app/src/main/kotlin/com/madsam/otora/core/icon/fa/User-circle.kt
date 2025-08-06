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

public val Fa.`User-circle`: ImageVector
    get() {
        if (`_user-circle` != null) {
            return `_user-circle`!!
        }
        `_user-circle` = Builder(name = "User-circle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(463.0f, 448.2f)
                curveTo(440.9f, 409.8f, 399.4f, 384.0f, 352.0f, 384.0f)
                lineTo(288.0f, 384.0f)
                curveTo(240.6f, 384.0f, 199.1f, 409.8f, 177.0f, 448.2f)
                curveTo(212.2f, 487.4f, 263.2f, 512.0f, 320.0f, 512.0f)
                curveTo(376.8f, 512.0f, 427.8f, 487.3f, 463.0f, 448.2f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(320.0f, 336.0f)
                curveTo(359.8f, 336.0f, 392.0f, 303.8f, 392.0f, 264.0f)
                curveTo(392.0f, 224.2f, 359.8f, 192.0f, 320.0f, 192.0f)
                curveTo(280.2f, 192.0f, 248.0f, 224.2f, 248.0f, 264.0f)
                curveTo(248.0f, 303.8f, 280.2f, 336.0f, 320.0f, 336.0f)
                close()
            }
        }
        .build()
        return `_user-circle`!!
    }

private var `_user-circle`: ImageVector? = null
