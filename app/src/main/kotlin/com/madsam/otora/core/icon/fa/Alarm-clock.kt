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

public val Fa.`Alarm-clock`: ImageVector
    get() {
        if (`_alarm-clock` != null) {
            return `_alarm-clock`!!
        }
        `_alarm-clock` = Builder(name = "Alarm-clock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(568.4f, 196.5f)
                curveTo(563.9f, 207.0f, 550.0f, 206.3f, 543.5f, 196.9f)
                curveTo(515.7f, 156.9f, 477.4f, 124.7f, 432.5f, 104.3f)
                curveTo(422.1f, 99.6f, 418.8f, 86.0f, 428.4f, 79.7f)
                curveTo(443.4f, 69.8f, 461.4f, 64.0f, 480.7f, 64.0f)
                curveTo(533.3f, 64.0f, 575.9f, 106.6f, 575.9f, 159.2f)
                curveTo(575.9f, 172.4f, 573.2f, 185.0f, 568.3f, 196.5f)
                close()
                moveTo(96.5f, 196.9f)
                curveTo(90.0f, 206.3f, 76.0f, 207.0f, 71.6f, 196.5f)
                curveTo(66.7f, 185.0f, 64.0f, 172.4f, 64.0f, 159.2f)
                curveTo(64.0f, 106.6f, 106.6f, 64.0f, 159.2f, 64.0f)
                curveTo(178.5f, 64.0f, 196.5f, 69.8f, 211.5f, 79.7f)
                curveTo(221.1f, 86.0f, 217.8f, 99.6f, 207.4f, 104.3f)
                curveTo(162.6f, 124.7f, 124.3f, 156.9f, 96.4f, 196.9f)
                close()
                moveTo(454.2f, 531.4f)
                curveTo(416.8f, 559.4f, 370.3f, 576.0f, 320.0f, 576.0f)
                curveTo(269.7f, 576.0f, 223.2f, 559.4f, 185.9f, 531.4f)
                lineTo(150.6f, 566.6f)
                curveTo(138.1f, 579.1f, 117.8f, 579.1f, 105.3f, 566.6f)
                curveTo(92.8f, 554.1f, 92.8f, 533.8f, 105.3f, 521.3f)
                lineTo(140.5f, 486.1f)
                curveTo(112.6f, 448.8f, 96.0f, 402.3f, 96.0f, 352.0f)
                curveTo(96.0f, 228.3f, 196.3f, 128.0f, 320.0f, 128.0f)
                curveTo(443.7f, 128.0f, 544.0f, 228.3f, 544.0f, 352.0f)
                curveTo(544.0f, 402.3f, 527.4f, 448.8f, 499.4f, 486.2f)
                lineTo(534.6f, 521.4f)
                curveTo(547.1f, 533.9f, 547.1f, 554.2f, 534.6f, 566.7f)
                curveTo(522.1f, 579.2f, 501.8f, 579.2f, 489.3f, 566.7f)
                lineTo(454.1f, 531.5f)
                close()
                moveTo(344.0f, 248.0f)
                curveTo(344.0f, 234.7f, 333.3f, 224.0f, 320.0f, 224.0f)
                curveTo(306.7f, 224.0f, 296.0f, 234.7f, 296.0f, 248.0f)
                lineTo(296.0f, 352.0f)
                curveTo(296.0f, 358.4f, 298.5f, 364.5f, 303.0f, 369.0f)
                lineTo(359.0f, 425.0f)
                curveTo(368.4f, 434.4f, 383.6f, 434.4f, 392.9f, 425.0f)
                curveTo(402.2f, 415.6f, 402.3f, 400.4f, 392.9f, 391.1f)
                lineTo(343.9f, 342.1f)
                lineTo(343.9f, 248.0f)
                close()
            }
        }
        .build()
        return `_alarm-clock`!!
    }

private var `_alarm-clock`: ImageVector? = null
