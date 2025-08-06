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

public val Fa.`Child-dress`: ImageVector
    get() {
        if (`_child-dress` != null) {
            return `_child-dress`!!
        }
        `_child-dress` = Builder(name = "Child-dress", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 128.0f)
                curveTo(384.0f, 92.7f, 355.3f, 64.0f, 320.0f, 64.0f)
                curveTo(284.7f, 64.0f, 256.0f, 92.7f, 256.0f, 128.0f)
                curveTo(256.0f, 163.3f, 284.7f, 192.0f, 320.0f, 192.0f)
                curveTo(355.3f, 192.0f, 384.0f, 163.3f, 384.0f, 128.0f)
                close()
                moveTo(248.0f, 464.0f)
                lineTo(248.0f, 544.0f)
                curveTo(248.0f, 561.7f, 262.3f, 576.0f, 280.0f, 576.0f)
                curveTo(297.7f, 576.0f, 312.0f, 561.7f, 312.0f, 544.0f)
                lineTo(312.0f, 464.0f)
                lineTo(328.0f, 464.0f)
                lineTo(328.0f, 544.0f)
                curveTo(328.0f, 561.7f, 342.3f, 576.0f, 360.0f, 576.0f)
                curveTo(377.7f, 576.0f, 392.0f, 561.7f, 392.0f, 544.0f)
                lineTo(392.0f, 464.0f)
                lineTo(409.8f, 464.0f)
                curveTo(420.7f, 464.0f, 428.4f, 453.3f, 425.0f, 442.9f)
                lineTo(393.9f, 349.5f)
                lineTo(422.6f, 387.3f)
                curveTo(433.3f, 401.4f, 453.4f, 404.1f, 467.4f, 393.5f)
                curveTo(481.4f, 382.9f, 484.2f, 362.8f, 473.6f, 348.7f)
                lineTo(414.6f, 271.0f)
                curveTo(392.2f, 241.4f, 357.1f, 224.0f, 320.0f, 224.0f)
                curveTo(282.9f, 224.0f, 247.8f, 241.4f, 225.4f, 271.0f)
                lineTo(166.5f, 348.7f)
                curveTo(155.8f, 362.8f, 158.6f, 382.9f, 172.7f, 393.5f)
                curveTo(186.8f, 404.1f, 206.9f, 401.4f, 217.5f, 387.3f)
                lineTo(246.2f, 349.5f)
                lineTo(215.0f, 442.9f)
                curveTo(211.6f, 453.3f, 219.3f, 464.0f, 230.2f, 464.0f)
                lineTo(248.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_child-dress`!!
    }

private var `_child-dress`: ImageVector? = null
