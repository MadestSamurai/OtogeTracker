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

public val Fa.`Money-check`: ImageVector
    get() {
        if (`_money-check` != null) {
            return `_money-check`!!
        }
        `_money-check` = Builder(name = "Money-check", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 192.0f)
                curveTo(64.0f, 156.7f, 92.7f, 128.0f, 128.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                curveTo(547.3f, 128.0f, 576.0f, 156.7f, 576.0f, 192.0f)
                lineTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 192.0f)
                close()
                moveTo(160.0f, 376.0f)
                curveTo(160.0f, 389.3f, 170.7f, 400.0f, 184.0f, 400.0f)
                lineTo(328.0f, 400.0f)
                curveTo(341.3f, 400.0f, 352.0f, 389.3f, 352.0f, 376.0f)
                curveTo(352.0f, 362.7f, 341.3f, 352.0f, 328.0f, 352.0f)
                lineTo(184.0f, 352.0f)
                curveTo(170.7f, 352.0f, 160.0f, 362.7f, 160.0f, 376.0f)
                close()
                moveTo(184.0f, 240.0f)
                curveTo(170.7f, 240.0f, 160.0f, 250.7f, 160.0f, 264.0f)
                curveTo(160.0f, 277.3f, 170.7f, 288.0f, 184.0f, 288.0f)
                lineTo(456.0f, 288.0f)
                curveTo(469.3f, 288.0f, 480.0f, 277.3f, 480.0f, 264.0f)
                curveTo(480.0f, 250.7f, 469.3f, 240.0f, 456.0f, 240.0f)
                lineTo(184.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_money-check`!!
    }

private var `_money-check`: ImageVector? = null
