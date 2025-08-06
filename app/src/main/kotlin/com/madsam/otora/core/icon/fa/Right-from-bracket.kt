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

public val Fa.`Right-from-bracket`: ImageVector
    get() {
        if (`_right-from-bracket` != null) {
            return `_right-from-bracket`!!
        }
        `_right-from-bracket` = Builder(name = "Right-from-bracket", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(569.0f, 337.0f)
                curveTo(578.4f, 327.6f, 578.4f, 312.4f, 569.0f, 303.1f)
                lineTo(425.0f, 159.0f)
                curveTo(418.1f, 152.1f, 407.8f, 150.1f, 398.8f, 153.8f)
                curveTo(389.8f, 157.5f, 384.0f, 166.3f, 384.0f, 176.0f)
                lineTo(384.0f, 256.0f)
                lineTo(272.0f, 256.0f)
                curveTo(245.5f, 256.0f, 224.0f, 277.5f, 224.0f, 304.0f)
                lineTo(224.0f, 336.0f)
                curveTo(224.0f, 362.5f, 245.5f, 384.0f, 272.0f, 384.0f)
                lineTo(384.0f, 384.0f)
                lineTo(384.0f, 464.0f)
                curveTo(384.0f, 473.7f, 389.8f, 482.5f, 398.8f, 486.2f)
                curveTo(407.8f, 489.9f, 418.1f, 487.9f, 425.0f, 481.0f)
                lineTo(569.0f, 337.0f)
                close()
                moveTo(224.0f, 160.0f)
                curveTo(241.7f, 160.0f, 256.0f, 145.7f, 256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 241.7f, 96.0f, 224.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(107.0f, 96.0f, 64.0f, 139.0f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 501.0f, 107.0f, 544.0f, 160.0f, 544.0f)
                lineTo(224.0f, 544.0f)
                curveTo(241.7f, 544.0f, 256.0f, 529.7f, 256.0f, 512.0f)
                curveTo(256.0f, 494.3f, 241.7f, 480.0f, 224.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(142.3f, 480.0f, 128.0f, 465.7f, 128.0f, 448.0f)
                lineTo(128.0f, 192.0f)
                curveTo(128.0f, 174.3f, 142.3f, 160.0f, 160.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_right-from-bracket`!!
    }

private var `_right-from-bracket`: ImageVector? = null
