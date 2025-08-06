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

public val Fa.`Pound-sign`: ImageVector
    get() {
        if (`_pound-sign` != null) {
            return `_pound-sign`!!
        }
        `_pound-sign` = Builder(name = "Pound-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(219.3f, 352.0f)
                lineTo(184.5f, 352.0f)
                curveTo(171.2f, 352.0f, 160.5f, 341.3f, 160.5f, 328.0f)
                curveTo(160.5f, 314.7f, 171.2f, 304.0f, 184.5f, 304.0f)
                lineTo(205.9f, 304.0f)
                curveTo(165.3f, 211.3f, 233.1f, 106.0f, 335.6f, 106.0f)
                lineTo(343.8f, 106.0f)
                curveTo(377.4f, 106.0f, 410.0f, 117.3f, 436.3f, 138.2f)
                lineTo(452.4f, 150.9f)
                curveTo(466.3f, 161.9f, 468.6f, 182.0f, 457.6f, 195.9f)
                curveTo(446.6f, 209.8f, 426.5f, 212.1f, 412.6f, 201.1f)
                lineTo(396.5f, 188.4f)
                curveTo(381.5f, 176.5f, 362.9f, 170.0f, 343.7f, 170.0f)
                lineTo(335.5f, 170.0f)
                curveTo(278.2f, 170.0f, 240.8f, 229.9f, 265.8f, 281.4f)
                curveTo(269.4f, 288.8f, 272.4f, 296.3f, 274.9f, 304.0f)
                lineTo(424.4f, 304.0f)
                curveTo(437.7f, 304.0f, 448.4f, 314.7f, 448.4f, 328.0f)
                curveTo(448.4f, 341.3f, 437.7f, 352.0f, 424.4f, 352.0f)
                lineTo(283.2f, 352.0f)
                curveTo(284.2f, 387.3f, 274.5f, 422.6f, 254.3f, 452.9f)
                lineTo(236.2f, 480.0f)
                lineTo(448.4f, 480.0f)
                curveTo(466.1f, 480.0f, 480.4f, 494.3f, 480.4f, 512.0f)
                curveTo(480.4f, 529.7f, 466.1f, 544.0f, 448.4f, 544.0f)
                lineTo(176.4f, 544.0f)
                curveTo(164.6f, 544.0f, 153.8f, 537.5f, 148.2f, 527.1f)
                curveTo(142.6f, 516.7f, 143.2f, 504.1f, 149.8f, 494.2f)
                lineTo(201.0f, 417.4f)
                curveTo(214.1f, 397.8f, 220.2f, 374.8f, 219.2f, 352.0f)
                close()
            }
        }
        .build()
        return `_pound-sign`!!
    }

private var `_pound-sign`: ImageVector? = null
