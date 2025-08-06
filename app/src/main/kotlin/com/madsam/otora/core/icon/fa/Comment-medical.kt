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

public val Fa.`Comment-medical`: ImageVector
    get() {
        if (`_comment-medical` != null) {
            return `_comment-medical`!!
        }
        `_comment-medical` = Builder(name = "Comment-medical", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(281.6f, 217.6f)
                curveTo(281.6f, 207.0f, 290.2f, 198.4f, 300.8f, 198.4f)
                lineTo(339.2f, 198.4f)
                curveTo(349.8f, 198.4f, 358.4f, 207.0f, 358.4f, 217.6f)
                lineTo(358.4f, 265.6f)
                lineTo(406.4f, 265.6f)
                curveTo(417.0f, 265.6f, 425.6f, 274.2f, 425.6f, 284.8f)
                lineTo(425.6f, 323.2f)
                curveTo(425.6f, 333.8f, 417.0f, 342.4f, 406.4f, 342.4f)
                lineTo(358.4f, 342.4f)
                lineTo(358.4f, 390.4f)
                curveTo(358.4f, 401.0f, 349.8f, 409.6f, 339.2f, 409.6f)
                lineTo(300.8f, 409.6f)
                curveTo(290.2f, 409.6f, 281.6f, 401.0f, 281.6f, 390.4f)
                lineTo(281.6f, 342.4f)
                lineTo(233.6f, 342.4f)
                curveTo(223.0f, 342.4f, 214.4f, 333.8f, 214.4f, 323.2f)
                lineTo(214.4f, 284.8f)
                curveTo(214.4f, 274.2f, 223.0f, 265.6f, 233.6f, 265.6f)
                lineTo(281.6f, 265.6f)
                lineTo(281.6f, 217.6f)
                close()
            }
        }
        .build()
        return `_comment-medical`!!
    }

private var `_comment-medical`: ImageVector? = null
