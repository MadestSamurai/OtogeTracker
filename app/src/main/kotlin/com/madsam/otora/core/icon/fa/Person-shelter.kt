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

public val Fa.`Person-shelter`: ImageVector
    get() {
        if (`_person-shelter` != null) {
            return `_person-shelter`!!
        }
        `_person-shelter` = Builder(name = "Person-shelter", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(335.9f, 68.2f)
                curveTo(326.1f, 62.6f, 314.0f, 62.6f, 304.1f, 68.2f)
                lineTo(80.1f, 196.2f)
                curveTo(70.2f, 201.9f, 64.0f, 212.5f, 64.0f, 224.0f)
                lineTo(64.0f, 544.0f)
                curveTo(64.0f, 561.7f, 78.3f, 576.0f, 96.0f, 576.0f)
                curveTo(113.7f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 242.6f)
                lineTo(320.0f, 132.9f)
                lineTo(512.0f, 242.6f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 526.3f, 576.0f, 544.0f, 576.0f)
                curveTo(561.7f, 576.0f, 576.0f, 561.7f, 576.0f, 544.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 212.5f, 569.8f, 201.9f, 559.9f, 196.2f)
                lineTo(335.9f, 68.2f)
                close()
                moveTo(320.0f, 272.0f)
                curveTo(342.1f, 272.0f, 360.0f, 254.1f, 360.0f, 232.0f)
                curveTo(360.0f, 209.9f, 342.1f, 192.0f, 320.0f, 192.0f)
                curveTo(297.9f, 192.0f, 280.0f, 209.9f, 280.0f, 232.0f)
                curveTo(280.0f, 254.1f, 297.9f, 272.0f, 320.0f, 272.0f)
                close()
                moveTo(312.0f, 464.0f)
                lineTo(328.0f, 464.0f)
                lineTo(328.0f, 552.0f)
                curveTo(328.0f, 565.3f, 338.7f, 576.0f, 352.0f, 576.0f)
                curveTo(365.3f, 576.0f, 376.0f, 565.3f, 376.0f, 552.0f)
                lineTo(376.0f, 377.5f)
                lineTo(402.9f, 427.4f)
                curveTo(409.2f, 439.1f, 423.7f, 443.4f, 435.4f, 437.2f)
                curveTo(447.1f, 431.0f, 451.4f, 416.4f, 445.2f, 404.7f)
                lineTo(412.0f, 343.0f)
                curveTo(393.7f, 309.1f, 358.4f, 288.0f, 320.0f, 288.0f)
                curveTo(281.6f, 288.0f, 246.3f, 309.1f, 228.1f, 342.9f)
                lineTo(194.9f, 404.6f)
                curveTo(188.6f, 416.3f, 193.0f, 430.8f, 204.7f, 437.1f)
                curveTo(216.4f, 443.4f, 230.9f, 439.0f, 237.2f, 427.3f)
                lineTo(264.0f, 377.5f)
                lineTo(264.0f, 552.0f)
                curveTo(264.0f, 565.3f, 274.7f, 576.0f, 288.0f, 576.0f)
                curveTo(301.3f, 576.0f, 312.0f, 565.3f, 312.0f, 552.0f)
                lineTo(312.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_person-shelter`!!
    }

private var `_person-shelter`: ImageVector? = null
