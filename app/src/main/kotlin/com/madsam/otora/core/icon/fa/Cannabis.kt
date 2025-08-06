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

public val Fa.Cannabis: ImageVector
    get() {
        if (_cannabis != null) {
            return _cannabis!!
        }
        _cannabis = Builder(name = "Cannabis", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(325.3f, 64.0f, 330.3f, 66.7f, 333.3f, 71.1f)
                curveTo(349.1f, 94.6f, 370.0f, 134.8f, 382.5f, 180.1f)
                curveTo(389.8f, 206.5f, 394.3f, 235.4f, 392.8f, 264.1f)
                curveTo(404.4f, 255.2f, 416.5f, 247.4f, 428.7f, 240.4f)
                curveTo(469.7f, 217.1f, 513.1f, 203.5f, 540.9f, 197.9f)
                curveTo(546.1f, 196.9f, 551.6f, 198.5f, 555.3f, 202.3f)
                curveTo(559.0f, 206.1f, 560.7f, 211.5f, 559.7f, 216.8f)
                curveTo(554.1f, 244.5f, 540.4f, 287.7f, 517.0f, 328.5f)
                curveTo(507.9f, 344.4f, 497.1f, 360.2f, 484.5f, 374.8f)
                curveTo(512.4f, 381.4f, 537.0f, 392.0f, 551.8f, 400.2f)
                curveTo(556.9f, 403.0f, 560.0f, 408.4f, 560.0f, 414.2f)
                curveTo(560.0f, 420.0f, 556.8f, 425.4f, 551.8f, 428.2f)
                curveTo(536.6f, 436.6f, 510.9f, 447.7f, 482.0f, 454.3f)
                curveTo(461.8f, 458.9f, 439.1f, 461.5f, 416.8f, 458.9f)
                lineTo(425.1f, 492.1f)
                curveTo(426.6f, 498.2f, 424.5f, 504.6f, 419.6f, 508.5f)
                curveTo(414.7f, 512.4f, 408.0f, 513.1f, 402.4f, 510.3f)
                lineTo(344.0f, 481.2f)
                lineTo(344.0f, 552.0f)
                curveTo(344.0f, 565.3f, 333.3f, 576.0f, 320.0f, 576.0f)
                curveTo(306.7f, 576.0f, 296.0f, 565.3f, 296.0f, 552.0f)
                lineTo(296.0f, 481.2f)
                lineTo(237.5f, 510.3f)
                curveTo(231.9f, 513.1f, 225.2f, 512.4f, 220.3f, 508.5f)
                curveTo(215.4f, 504.6f, 213.3f, 498.2f, 214.8f, 492.1f)
                lineTo(223.1f, 458.9f)
                curveTo(200.9f, 461.5f, 178.1f, 458.9f, 157.9f, 454.3f)
                curveTo(129.0f, 447.7f, 103.4f, 436.7f, 88.1f, 428.2f)
                curveTo(83.0f, 425.4f, 79.9f, 420.0f, 79.9f, 414.2f)
                curveTo(79.9f, 408.4f, 83.1f, 403.0f, 88.1f, 400.2f)
                lineTo(94.3f, 396.9f)
                curveTo(109.3f, 389.3f, 131.1f, 380.5f, 155.4f, 374.7f)
                curveTo(142.9f, 360.2f, 132.1f, 344.3f, 123.0f, 328.5f)
                curveTo(99.6f, 287.7f, 85.9f, 244.5f, 80.3f, 216.8f)
                curveTo(79.2f, 211.6f, 80.9f, 206.1f, 84.7f, 202.3f)
                curveTo(88.5f, 198.5f, 93.9f, 196.9f, 99.1f, 197.9f)
                curveTo(127.0f, 203.4f, 170.3f, 217.1f, 211.3f, 240.4f)
                curveTo(223.5f, 247.3f, 235.6f, 255.2f, 247.1f, 264.1f)
                curveTo(245.7f, 235.4f, 250.2f, 206.5f, 257.4f, 180.1f)
                curveTo(269.9f, 134.8f, 290.8f, 94.6f, 306.6f, 71.1f)
                lineTo(307.8f, 69.5f)
                curveTo(310.9f, 66.0f, 315.3f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return _cannabis!!
    }

private var _cannabis: ImageVector? = null
