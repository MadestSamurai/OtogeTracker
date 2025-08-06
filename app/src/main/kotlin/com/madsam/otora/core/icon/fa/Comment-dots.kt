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

public val Fa.`Comment-dots`: ImageVector
    get() {
        if (`_comment-dots` != null) {
            return `_comment-dots`!!
        }
        `_comment-dots` = Builder(name = "Comment-dots", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 544.0f)
                curveTo(461.4f, 544.0f, 576.0f, 436.5f, 576.0f, 304.0f)
                curveTo(576.0f, 171.5f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 171.5f, 64.0f, 304.0f)
                curveTo(64.0f, 358.3f, 83.2f, 408.3f, 115.6f, 448.5f)
                lineTo(66.8f, 540.8f)
                curveTo(62.0f, 549.8f, 63.5f, 560.8f, 70.4f, 568.3f)
                curveTo(77.3f, 575.8f, 88.2f, 578.1f, 97.5f, 574.1f)
                lineTo(215.9f, 523.4f)
                curveTo(247.7f, 536.6f, 282.9f, 544.0f, 320.0f, 544.0f)
                close()
                moveTo(192.0f, 272.0f)
                curveTo(209.7f, 272.0f, 224.0f, 286.3f, 224.0f, 304.0f)
                curveTo(224.0f, 321.7f, 209.7f, 336.0f, 192.0f, 336.0f)
                curveTo(174.3f, 336.0f, 160.0f, 321.7f, 160.0f, 304.0f)
                curveTo(160.0f, 286.3f, 174.3f, 272.0f, 192.0f, 272.0f)
                close()
                moveTo(320.0f, 272.0f)
                curveTo(337.7f, 272.0f, 352.0f, 286.3f, 352.0f, 304.0f)
                curveTo(352.0f, 321.7f, 337.7f, 336.0f, 320.0f, 336.0f)
                curveTo(302.3f, 336.0f, 288.0f, 321.7f, 288.0f, 304.0f)
                curveTo(288.0f, 286.3f, 302.3f, 272.0f, 320.0f, 272.0f)
                close()
                moveTo(416.0f, 304.0f)
                curveTo(416.0f, 286.3f, 430.3f, 272.0f, 448.0f, 272.0f)
                curveTo(465.7f, 272.0f, 480.0f, 286.3f, 480.0f, 304.0f)
                curveTo(480.0f, 321.7f, 465.7f, 336.0f, 448.0f, 336.0f)
                curveTo(430.3f, 336.0f, 416.0f, 321.7f, 416.0f, 304.0f)
                close()
            }
        }
        .build()
        return `_comment-dots`!!
    }

private var `_comment-dots`: ImageVector? = null
