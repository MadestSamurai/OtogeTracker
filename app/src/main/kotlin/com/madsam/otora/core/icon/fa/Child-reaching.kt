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

public val Fa.`Child-reaching`: ImageVector
    get() {
        if (`_child-reaching` != null) {
            return `_child-reaching`!!
        }
        `_child-reaching` = Builder(name = "Child-reaching", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 128.0f)
                curveTo(384.0f, 92.7f, 355.3f, 64.0f, 320.0f, 64.0f)
                curveTo(284.7f, 64.0f, 256.0f, 92.7f, 256.0f, 128.0f)
                curveTo(256.0f, 163.3f, 284.7f, 192.0f, 320.0f, 192.0f)
                curveTo(355.3f, 192.0f, 384.0f, 163.3f, 384.0f, 128.0f)
                close()
                moveTo(280.9f, 233.3f)
                curveTo(257.2f, 224.9f, 236.4f, 209.0f, 222.1f, 187.5f)
                lineTo(202.6f, 158.2f)
                curveTo(192.8f, 143.5f, 173.0f, 139.6f, 158.3f, 149.4f)
                curveTo(143.6f, 159.2f, 139.6f, 179.0f, 149.4f, 193.8f)
                lineTo(168.9f, 223.0f)
                curveTo(187.0f, 250.1f, 211.7f, 271.4f, 240.0f, 285.4f)
                lineTo(240.0f, 544.0f)
                curveTo(240.0f, 561.7f, 254.3f, 576.0f, 272.0f, 576.0f)
                curveTo(289.7f, 576.0f, 304.0f, 561.7f, 304.0f, 544.0f)
                lineTo(304.0f, 448.0f)
                lineTo(336.0f, 448.0f)
                lineTo(336.0f, 544.0f)
                curveTo(336.0f, 561.7f, 350.3f, 576.0f, 368.0f, 576.0f)
                curveTo(385.7f, 576.0f, 400.0f, 561.7f, 400.0f, 544.0f)
                lineTo(400.0f, 285.6f)
                curveTo(429.1f, 271.4f, 454.4f, 249.4f, 472.7f, 221.4f)
                lineTo(490.9f, 193.5f)
                curveTo(500.5f, 178.7f, 496.3f, 158.9f, 481.5f, 149.2f)
                curveTo(466.7f, 139.5f, 446.9f, 143.7f, 437.2f, 158.6f)
                lineTo(419.0f, 186.4f)
                curveTo(397.2f, 219.8f, 360.1f, 240.0f, 320.2f, 240.0f)
                curveTo(307.6f, 240.0f, 295.3f, 238.0f, 283.6f, 234.2f)
                curveTo(282.7f, 233.9f, 281.8f, 233.5f, 280.9f, 233.3f)
                close()
            }
        }
        .build()
        return `_child-reaching`!!
    }

private var `_child-reaching`: ImageVector? = null
