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

public val Fa.`Horse-head`: ImageVector
    get() {
        if (`_horse-head` != null) {
            return `_horse-head`!!
        }
        `_horse-head` = Builder(name = "Horse-head", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 528.0f)
                lineTo(64.0f, 380.9f)
                curveTo(64.0f, 272.5f, 132.3f, 175.8f, 234.5f, 139.6f)
                lineTo(404.2f, 79.5f)
                curveTo(425.6f, 71.9f, 448.0f, 87.8f, 448.0f, 110.4f)
                curveTo(448.0f, 121.4f, 442.5f, 131.6f, 433.4f, 137.7f)
                lineTo(400.0f, 160.0f)
                curveTo(448.1f, 160.0f, 491.2f, 189.8f, 508.1f, 234.9f)
                lineTo(556.7f, 364.4f)
                curveTo(568.5f, 395.8f, 560.8f, 431.2f, 537.1f, 454.9f)
                curveTo(521.1f, 470.9f, 499.3f, 480.0f, 476.6f, 480.0f)
                lineTo(473.2f, 480.0f)
                curveTo(447.1f, 480.0f, 422.3f, 468.4f, 405.6f, 448.3f)
                lineTo(373.3f, 409.6f)
                curveTo(361.6f, 413.7f, 349.1f, 416.0f, 336.0f, 416.0f)
                lineTo(335.9f, 416.0f)
                curveTo(329.6f, 416.0f, 323.4f, 415.5f, 317.3f, 414.5f)
                curveTo(313.7f, 413.9f, 310.1f, 413.1f, 306.6f, 412.2f)
                lineTo(306.6f, 412.2f)
                curveTo(277.7f, 404.4f, 253.5f, 385.4f, 238.8f, 360.0f)
                curveTo(234.4f, 352.3f, 224.6f, 349.7f, 216.9f, 354.2f)
                curveTo(209.2f, 358.7f, 206.6f, 368.4f, 211.1f, 376.1f)
                curveTo(235.1f, 417.6f, 279.4f, 446.1f, 330.4f, 448.0f)
                lineTo(377.6f, 518.8f)
                curveTo(381.6f, 524.9f, 383.8f, 532.0f, 383.8f, 539.2f)
                curveTo(383.8f, 559.5f, 367.3f, 576.0f, 347.0f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(85.5f, 576.0f, 64.0f, 554.5f, 64.0f, 528.0f)
                close()
                moveTo(392.0f, 288.0f)
                curveTo(405.3f, 288.0f, 416.0f, 277.3f, 416.0f, 264.0f)
                curveTo(416.0f, 250.7f, 405.3f, 240.0f, 392.0f, 240.0f)
                curveTo(378.7f, 240.0f, 368.0f, 250.7f, 368.0f, 264.0f)
                curveTo(368.0f, 277.3f, 378.7f, 288.0f, 392.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_horse-head`!!
    }

private var `_horse-head`: ImageVector? = null
