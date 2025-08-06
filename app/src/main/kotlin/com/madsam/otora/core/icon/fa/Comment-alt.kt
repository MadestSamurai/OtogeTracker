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

public val Fa.`Comment-alt`: ImageVector
    get() {
        if (`_comment-alt` != null) {
            return `_comment-alt`!!
        }
        `_comment-alt` = Builder(name = "Comment-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 416.0f)
                lineTo(64.0f, 192.0f)
                curveTo(64.0f, 139.0f, 107.0f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(533.0f, 96.0f, 576.0f, 139.0f, 576.0f, 192.0f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 469.0f, 533.0f, 512.0f, 480.0f, 512.0f)
                lineTo(360.0f, 512.0f)
                curveTo(354.8f, 512.0f, 349.8f, 513.7f, 345.6f, 516.8f)
                lineTo(230.4f, 603.2f)
                curveTo(226.2f, 606.3f, 221.2f, 608.0f, 216.0f, 608.0f)
                curveTo(202.7f, 608.0f, 192.0f, 597.3f, 192.0f, 584.0f)
                lineTo(192.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                curveTo(107.0f, 512.0f, 64.0f, 469.0f, 64.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_comment-alt`!!
    }

private var `_comment-alt`: ImageVector? = null
