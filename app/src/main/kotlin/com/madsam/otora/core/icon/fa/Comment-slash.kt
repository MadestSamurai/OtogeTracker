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

public val Fa.`Comment-slash`: ImageVector
    get() {
        if (`_comment-slash` != null) {
            return `_comment-slash`!!
        }
        `_comment-slash` = Builder(name = "Comment-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.0f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.0f, 39.0f)
                curveTo(29.6f, 48.3f, 29.7f, 63.6f, 39.0f, 73.0f)
                lineTo(567.0f, 601.0f)
                curveTo(576.4f, 610.4f, 591.6f, 610.4f, 600.9f, 601.0f)
                curveTo(610.2f, 591.6f, 610.3f, 576.4f, 600.9f, 567.1f)
                lineTo(504.3f, 470.5f)
                curveTo(548.7f, 427.3f, 575.9f, 368.7f, 575.9f, 304.0f)
                curveTo(575.9f, 171.5f, 461.3f, 64.0f, 319.9f, 64.0f)
                curveTo(256.9f, 64.0f, 199.1f, 85.4f, 154.5f, 120.8f)
                lineTo(73.0f, 39.0f)
                close()
                moveTo(92.4f, 194.0f)
                curveTo(74.2f, 227.0f, 64.0f, 264.3f, 64.0f, 303.9f)
                curveTo(64.0f, 358.2f, 83.2f, 408.2f, 115.6f, 448.4f)
                lineTo(66.8f, 540.7f)
                curveTo(62.0f, 549.7f, 63.5f, 560.7f, 70.4f, 568.2f)
                curveTo(77.3f, 575.7f, 88.1f, 578.0f, 97.5f, 574.0f)
                lineTo(215.9f, 523.3f)
                curveTo(247.7f, 536.6f, 283.0f, 544.0f, 320.0f, 544.0f)
                curveTo(356.4f, 544.0f, 390.9f, 536.9f, 422.3f, 524.1f)
                lineTo(92.3f, 194.1f)
                close()
            }
        }
        .build()
        return `_comment-slash`!!
    }

private var `_comment-slash`: ImageVector? = null
