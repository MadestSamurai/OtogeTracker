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

public val Fa.`File-shield`: ImageVector
    get() {
        if (`_file-shield` != null) {
            return `_file-shield`!!
        }
        `_file-shield` = Builder(name = "File-shield", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(92.7f, 64.0f, 64.0f, 92.7f, 64.0f, 128.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(329.2f, 576.0f)
                curveTo(293.0f, 533.4f, 272.0f, 478.5f, 272.0f, 420.4f)
                lineTo(272.0f, 389.3f)
                curveTo(272.0f, 354.9f, 294.0f, 324.3f, 326.7f, 313.4f)
                lineTo(438.7f, 276.1f)
                curveTo(441.8f, 275.1f, 444.9f, 274.3f, 448.0f, 273.6f)
                lineTo(448.0f, 234.5f)
                curveTo(448.0f, 217.5f, 441.3f, 201.2f, 429.3f, 189.2f)
                lineTo(322.7f, 82.7f)
                curveTo(310.7f, 70.7f, 294.5f, 64.0f, 277.5f, 64.0f)
                lineTo(128.0f, 64.0f)
                close()
                moveTo(389.5f, 240.0f)
                lineTo(296.0f, 240.0f)
                curveTo(282.7f, 240.0f, 272.0f, 229.3f, 272.0f, 216.0f)
                lineTo(272.0f, 122.5f)
                lineTo(389.5f, 240.0f)
                close()
                moveTo(477.3f, 552.5f)
                lineTo(464.0f, 558.8f)
                lineTo(464.0f, 370.7f)
                lineTo(560.0f, 402.7f)
                lineTo(560.0f, 422.3f)
                curveTo(560.0f, 478.1f, 527.8f, 528.8f, 477.3f, 552.6f)
                close()
                moveTo(453.9f, 323.5f)
                lineTo(341.9f, 360.8f)
                curveTo(328.8f, 365.2f, 320.0f, 377.4f, 320.0f, 391.2f)
                lineTo(320.0f, 422.3f)
                curveTo(320.0f, 496.7f, 363.0f, 564.4f, 430.2f, 596.0f)
                lineTo(448.7f, 604.7f)
                curveTo(453.5f, 606.9f, 458.7f, 608.1f, 463.9f, 608.1f)
                curveTo(469.1f, 608.1f, 474.4f, 606.9f, 479.1f, 604.7f)
                lineTo(497.6f, 596.0f)
                curveTo(565.0f, 564.3f, 608.0f, 496.6f, 608.0f, 422.2f)
                lineTo(608.0f, 391.1f)
                curveTo(608.0f, 377.3f, 599.2f, 365.1f, 586.1f, 360.7f)
                lineTo(474.1f, 323.4f)
                curveTo(467.5f, 321.2f, 460.4f, 321.2f, 453.9f, 323.4f)
                close()
            }
        }
        .build()
        return `_file-shield`!!
    }

private var `_file-shield`: ImageVector? = null
