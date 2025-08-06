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

public val Fa.`User-check`: ImageVector
    get() {
        if (`_user-check` != null) {
            return `_user-check`!!
        }
        `_user-check` = Builder(name = "User-check", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(136.0f, 192.0f)
                curveTo(136.0f, 125.7f, 189.7f, 72.0f, 256.0f, 72.0f)
                curveTo(322.3f, 72.0f, 376.0f, 125.7f, 376.0f, 192.0f)
                curveTo(376.0f, 258.3f, 322.3f, 312.0f, 256.0f, 312.0f)
                curveTo(189.7f, 312.0f, 136.0f, 258.3f, 136.0f, 192.0f)
                close()
                moveTo(48.0f, 546.3f)
                curveTo(48.0f, 447.8f, 127.8f, 368.0f, 226.3f, 368.0f)
                lineTo(285.7f, 368.0f)
                curveTo(384.2f, 368.0f, 464.0f, 447.8f, 464.0f, 546.3f)
                curveTo(464.0f, 562.7f, 450.7f, 576.0f, 434.3f, 576.0f)
                lineTo(77.7f, 576.0f)
                curveTo(61.3f, 576.0f, 48.0f, 562.7f, 48.0f, 546.3f)
                close()
                moveTo(612.4f, 196.7f)
                lineTo(532.4f, 324.7f)
                curveTo(528.2f, 331.4f, 521.0f, 335.6f, 513.1f, 336.0f)
                curveTo(505.2f, 336.4f, 497.6f, 332.8f, 492.9f, 326.4f)
                lineTo(444.9f, 262.4f)
                curveTo(436.9f, 251.8f, 439.1f, 236.8f, 449.7f, 228.8f)
                curveTo(460.3f, 220.8f, 475.3f, 223.0f, 483.3f, 233.6f)
                lineTo(510.3f, 269.6f)
                lineTo(571.7f, 171.3f)
                curveTo(578.7f, 160.1f, 593.5f, 156.6f, 604.8f, 163.7f)
                curveTo(616.1f, 170.8f, 619.5f, 185.5f, 612.4f, 196.8f)
                close()
            }
        }
        .build()
        return `_user-check`!!
    }

private var `_user-check`: ImageVector? = null
