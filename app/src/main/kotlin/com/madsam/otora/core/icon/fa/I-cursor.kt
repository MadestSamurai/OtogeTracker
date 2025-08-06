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

public val Fa.`I-cursor`: ImageVector
    get() {
        if (`_i-cursor` != null) {
            return `_i-cursor`!!
        }
        `_i-cursor` = Builder(name = "I-cursor", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.1f, 93.3f)
                curveTo(190.6f, 111.0f, 203.7f, 126.4f, 221.3f, 127.9f)
                lineTo(229.3f, 128.6f)
                curveTo(262.5f, 131.3f, 288.0f, 159.0f, 288.0f, 192.3f)
                lineTo(288.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                curveTo(238.3f, 288.0f, 224.0f, 302.3f, 224.0f, 320.0f)
                curveTo(224.0f, 337.7f, 238.3f, 352.0f, 256.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                lineTo(288.0f, 447.7f)
                curveTo(288.0f, 481.0f, 262.5f, 508.7f, 229.3f, 511.5f)
                lineTo(221.3f, 512.2f)
                curveTo(203.7f, 513.6f, 190.6f, 529.0f, 192.1f, 546.7f)
                curveTo(193.6f, 564.4f, 209.0f, 577.4f, 226.7f, 575.9f)
                lineTo(234.7f, 575.2f)
                curveTo(268.8f, 572.4f, 298.9f, 556.3f, 320.1f, 532.3f)
                curveTo(341.3f, 556.3f, 371.3f, 572.3f, 405.5f, 575.2f)
                lineTo(413.5f, 575.9f)
                curveTo(431.1f, 577.4f, 446.6f, 564.3f, 448.0f, 546.7f)
                curveTo(449.4f, 529.1f, 436.4f, 513.6f, 418.8f, 512.2f)
                lineTo(410.8f, 511.5f)
                curveTo(377.5f, 508.7f, 352.0f, 481.0f, 352.0f, 447.7f)
                lineTo(352.0f, 352.0f)
                lineTo(384.0f, 352.0f)
                curveTo(401.7f, 352.0f, 416.0f, 337.7f, 416.0f, 320.0f)
                curveTo(416.0f, 302.3f, 401.7f, 288.0f, 384.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                lineTo(352.0f, 192.3f)
                curveTo(352.0f, 159.0f, 377.5f, 131.3f, 410.7f, 128.5f)
                lineTo(418.7f, 127.8f)
                curveTo(436.3f, 126.3f, 449.4f, 110.9f, 447.9f, 93.3f)
                curveTo(446.4f, 75.7f, 431.0f, 62.6f, 413.3f, 64.1f)
                lineTo(405.3f, 64.8f)
                curveTo(371.2f, 67.6f, 341.1f, 83.7f, 319.9f, 107.7f)
                curveTo(298.7f, 83.7f, 268.7f, 67.7f, 234.5f, 64.8f)
                lineTo(226.5f, 64.1f)
                curveTo(209.0f, 62.6f, 193.6f, 75.7f, 192.1f, 93.3f)
                close()
            }
        }
        .build()
        return `_i-cursor`!!
    }

private var `_i-cursor`: ImageVector? = null
