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

public val Fa.Retweet: ImageVector
    get() {
        if (_retweet != null) {
            return _retweet!!
        }
        _retweet = Builder(name = "Retweet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(150.6f, 105.4f)
                curveTo(138.1f, 92.9f, 117.8f, 92.9f, 105.3f, 105.4f)
                lineTo(41.3f, 169.4f)
                curveTo(32.1f, 178.6f, 29.4f, 192.3f, 34.4f, 204.3f)
                curveTo(39.4f, 216.3f, 51.1f, 224.0f, 64.0f, 224.0f)
                lineTo(96.0f, 224.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 501.0f, 139.0f, 544.0f, 192.0f, 544.0f)
                lineTo(320.0f, 544.0f)
                curveTo(337.7f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                curveTo(352.0f, 494.3f, 337.7f, 480.0f, 320.0f, 480.0f)
                lineTo(192.0f, 480.0f)
                curveTo(174.3f, 480.0f, 160.0f, 465.7f, 160.0f, 448.0f)
                lineTo(160.0f, 224.0f)
                lineTo(192.0f, 224.0f)
                curveTo(204.9f, 224.0f, 216.6f, 216.2f, 221.6f, 204.2f)
                curveTo(226.6f, 192.2f, 223.8f, 178.5f, 214.7f, 169.3f)
                lineTo(150.7f, 105.3f)
                close()
                moveTo(489.4f, 534.6f)
                curveTo(501.9f, 547.1f, 522.2f, 547.1f, 534.7f, 534.6f)
                lineTo(598.7f, 470.6f)
                curveTo(607.9f, 461.4f, 610.6f, 447.7f, 605.6f, 435.7f)
                curveTo(600.6f, 423.7f, 588.9f, 416.0f, 576.0f, 416.0f)
                lineTo(544.0f, 416.0f)
                lineTo(544.0f, 192.0f)
                curveTo(544.0f, 139.0f, 501.0f, 96.0f, 448.0f, 96.0f)
                lineTo(320.0f, 96.0f)
                curveTo(302.3f, 96.0f, 288.0f, 110.3f, 288.0f, 128.0f)
                curveTo(288.0f, 145.7f, 302.3f, 160.0f, 320.0f, 160.0f)
                lineTo(448.0f, 160.0f)
                curveTo(465.7f, 160.0f, 480.0f, 174.3f, 480.0f, 192.0f)
                lineTo(480.0f, 416.0f)
                lineTo(448.0f, 416.0f)
                curveTo(435.1f, 416.0f, 423.4f, 423.8f, 418.4f, 435.8f)
                curveTo(413.4f, 447.8f, 416.2f, 461.5f, 425.3f, 470.7f)
                lineTo(489.3f, 534.7f)
                close()
            }
        }
        .build()
        return _retweet!!
    }

private var _retweet: ImageVector? = null
