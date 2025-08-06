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

public val Fa.`Martini-glass-citrus`: ImageVector
    get() {
        if (`_martini-glass-citrus` != null) {
            return `_martini-glass-citrus`!!
        }
        `_martini-glass-citrus` = Builder(name = "Martini-glass-citrus", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 144.0f)
                curveTo(576.0f, 99.8f, 540.2f, 64.0f, 496.0f, 64.0f)
                curveTo(478.0f, 64.0f, 461.4f, 70.0f, 448.0f, 80.0f)
                lineTo(367.0f, 80.0f)
                curveTo(390.6f, 32.6f, 439.5f, 0.0f, 496.0f, 0.0f)
                curveTo(575.5f, 0.0f, 640.0f, 64.5f, 640.0f, 144.0f)
                curveTo(640.0f, 223.5f, 575.5f, 288.0f, 496.0f, 288.0f)
                curveTo(489.5f, 288.0f, 483.0f, 287.6f, 476.7f, 286.7f)
                lineTo(540.7f, 212.0f)
                curveTo(541.8f, 210.7f, 542.9f, 209.3f, 544.0f, 207.9f)
                curveTo(563.4f, 193.3f, 576.0f, 170.1f, 576.0f, 143.9f)
                close()
                moveTo(66.9f, 146.6f)
                curveTo(72.2f, 135.3f, 83.5f, 128.0f, 96.0f, 128.0f)
                lineTo(480.0f, 128.0f)
                curveTo(492.5f, 128.0f, 503.8f, 135.3f, 509.1f, 146.6f)
                curveTo(514.4f, 157.9f, 512.5f, 171.3f, 504.3f, 180.8f)
                lineTo(320.0f, 395.8f)
                lineTo(320.0f, 512.0f)
                lineTo(384.0f, 512.0f)
                curveTo(401.7f, 512.0f, 416.0f, 526.3f, 416.0f, 544.0f)
                curveTo(416.0f, 561.7f, 401.7f, 576.0f, 384.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(174.3f, 576.0f, 160.0f, 561.7f, 160.0f, 544.0f)
                curveTo(160.0f, 526.3f, 174.3f, 512.0f, 192.0f, 512.0f)
                lineTo(256.0f, 512.0f)
                lineTo(256.0f, 395.8f)
                lineTo(71.7f, 180.8f)
                curveTo(63.6f, 171.3f, 61.7f, 158.0f, 66.9f, 146.6f)
                close()
                moveTo(165.6f, 192.0f)
                lineTo(288.0f, 334.8f)
                lineTo(410.4f, 192.0f)
                lineTo(165.6f, 192.0f)
                close()
            }
        }
        .build()
        return `_martini-glass-citrus`!!
    }

private var `_martini-glass-citrus`: ImageVector? = null
