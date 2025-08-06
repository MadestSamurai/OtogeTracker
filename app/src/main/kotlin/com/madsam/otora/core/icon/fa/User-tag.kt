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

public val Fa.`User-tag`: ImageVector
    get() {
        if (`_user-tag` != null) {
            return `_user-tag`!!
        }
        `_user-tag` = Builder(name = "User-tag", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.1f, 72.0f)
                curveTo(322.4f, 72.0f, 376.1f, 125.7f, 376.1f, 192.0f)
                curveTo(376.1f, 258.3f, 322.4f, 312.0f, 256.1f, 312.0f)
                curveTo(189.8f, 312.0f, 136.1f, 258.3f, 136.1f, 192.0f)
                curveTo(136.1f, 125.7f, 189.8f, 72.0f, 256.1f, 72.0f)
                close()
                moveTo(226.4f, 368.0f)
                lineTo(285.8f, 368.0f)
                curveTo(292.5f, 368.0f, 299.0f, 368.4f, 305.5f, 369.1f)
                curveTo(304.6f, 374.0f, 304.1f, 379.0f, 304.1f, 384.1f)
                lineTo(304.1f, 476.2f)
                curveTo(304.1f, 501.7f, 314.2f, 526.1f, 332.2f, 544.1f)
                lineTo(364.1f, 576.0f)
                lineTo(77.8f, 576.0f)
                curveTo(61.4f, 576.0f, 48.1f, 562.7f, 48.1f, 546.3f)
                curveTo(48.1f, 447.8f, 127.9f, 368.0f, 226.4f, 368.0f)
                close()
                moveTo(352.1f, 476.2f)
                lineTo(352.1f, 384.1f)
                curveTo(352.1f, 366.4f, 366.4f, 352.1f, 384.1f, 352.1f)
                lineTo(476.2f, 352.1f)
                curveTo(488.9f, 352.1f, 501.1f, 357.2f, 510.1f, 366.2f)
                lineTo(606.1f, 462.2f)
                curveTo(624.8f, 480.9f, 624.8f, 511.3f, 606.1f, 530.1f)
                lineTo(530.0f, 606.2f)
                curveTo(511.3f, 624.9f, 480.9f, 624.9f, 462.1f, 606.2f)
                lineTo(366.1f, 510.2f)
                curveTo(357.1f, 501.2f, 352.0f, 489.0f, 352.0f, 476.3f)
                close()
                moveTo(456.1f, 432.0f)
                curveTo(456.1f, 418.7f, 445.4f, 408.0f, 432.1f, 408.0f)
                curveTo(418.8f, 408.0f, 408.1f, 418.7f, 408.1f, 432.0f)
                curveTo(408.1f, 445.3f, 418.8f, 456.0f, 432.1f, 456.0f)
                curveTo(445.4f, 456.0f, 456.1f, 445.3f, 456.1f, 432.0f)
                close()
            }
        }
        .build()
        return `_user-tag`!!
    }

private var `_user-tag`: ImageVector? = null
