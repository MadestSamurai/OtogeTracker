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

public val Fa.`Star-and-crescent`: ImageVector
    get() {
        if (`_star-and-crescent` != null) {
            return `_star-and-crescent`!!
        }
        `_star-and-crescent` = Builder(name = "Star-and-crescent", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(353.0f, 64.0f, 384.6f, 70.3f, 413.6f, 81.7f)
                curveTo(421.0f, 84.6f, 425.1f, 92.4f, 423.4f, 100.1f)
                curveTo(421.7f, 107.8f, 414.6f, 113.1f, 406.7f, 112.5f)
                curveTo(401.9f, 112.2f, 397.0f, 112.0f, 392.1f, 112.0f)
                curveTo(277.2f, 112.0f, 184.1f, 205.1f, 184.1f, 320.0f)
                curveTo(184.1f, 434.9f, 277.2f, 528.0f, 392.1f, 528.0f)
                curveTo(397.0f, 528.0f, 401.9f, 527.8f, 406.7f, 527.5f)
                curveTo(414.6f, 527.0f, 421.7f, 532.2f, 423.4f, 539.9f)
                curveTo(425.1f, 547.6f, 421.0f, 555.4f, 413.6f, 558.3f)
                curveTo(384.6f, 569.7f, 353.0f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(439.4f, 201.4f)
                curveTo(442.9f, 194.3f, 453.1f, 194.3f, 456.6f, 201.4f)
                lineTo(488.1f, 265.2f)
                curveTo(489.5f, 268.0f, 492.2f, 270.0f, 495.3f, 270.5f)
                lineTo(565.7f, 280.7f)
                curveTo(573.6f, 281.8f, 576.7f, 291.5f, 571.0f, 297.1f)
                lineTo(520.1f, 346.7f)
                curveTo(517.8f, 348.9f, 516.8f, 352.1f, 517.3f, 355.2f)
                lineTo(529.3f, 425.3f)
                curveTo(530.6f, 433.1f, 522.4f, 439.1f, 515.4f, 435.4f)
                lineTo(452.4f, 402.3f)
                curveTo(449.6f, 400.8f, 446.3f, 400.8f, 443.5f, 402.3f)
                lineTo(380.5f, 435.4f)
                curveTo(373.5f, 439.1f, 365.2f, 433.1f, 366.6f, 425.3f)
                lineTo(378.6f, 355.2f)
                curveTo(379.1f, 352.1f, 378.1f, 348.9f, 375.8f, 346.7f)
                lineTo(325.0f, 297.1f)
                curveTo(319.3f, 291.5f, 322.4f, 281.9f, 330.3f, 280.7f)
                lineTo(400.7f, 270.5f)
                curveTo(403.8f, 270.0f, 406.5f, 268.1f, 407.9f, 265.2f)
                lineTo(439.4f, 201.4f)
                close()
            }
        }
        .build()
        return `_star-and-crescent`!!
    }

private var `_star-and-crescent`: ImageVector? = null
