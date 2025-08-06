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

public val Fa.`Wheelchair-alt`: ImageVector
    get() {
        if (`_wheelchair-alt` != null) {
            return `_wheelchair-alt`!!
        }
        `_wheelchair-alt` = Builder(name = "Wheelchair-alt", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(408.0f, 120.0f)
                curveTo(408.0f, 89.1f, 433.1f, 64.0f, 464.0f, 64.0f)
                curveTo(494.9f, 64.0f, 520.0f, 89.1f, 520.0f, 120.0f)
                curveTo(520.0f, 150.9f, 494.9f, 176.0f, 464.0f, 176.0f)
                curveTo(433.1f, 176.0f, 408.0f, 150.9f, 408.0f, 120.0f)
                close()
                moveTo(301.4f, 188.1f)
                curveTo(295.0f, 182.9f, 285.8f, 183.4f, 280.0f, 189.2f)
                lineTo(246.6f, 222.6f)
                curveTo(234.1f, 235.1f, 213.8f, 235.1f, 201.3f, 222.6f)
                curveTo(188.8f, 210.1f, 188.8f, 189.8f, 201.3f, 177.3f)
                lineTo(234.8f, 144.0f)
                curveTo(263.8f, 115.0f, 310.0f, 112.6f, 341.8f, 138.5f)
                lineTo(423.1f, 204.5f)
                curveTo(444.5f, 221.9f, 446.9f, 253.7f, 428.3f, 274.0f)
                lineTo(386.5f, 320.0f)
                lineTo(484.5f, 320.0f)
                curveTo(514.8f, 320.0f, 537.5f, 347.7f, 531.6f, 377.4f)
                lineTo(503.4f, 518.3f)
                curveTo(499.9f, 535.6f, 483.1f, 546.9f, 465.7f, 543.4f)
                curveTo(448.3f, 539.9f, 437.1f, 523.1f, 440.6f, 505.7f)
                lineTo(465.0f, 384.0f)
                lineTo(412.8f, 384.0f)
                curveTo(414.9f, 394.3f, 416.0f, 405.0f, 416.0f, 416.0f)
                curveTo(416.0f, 504.4f, 344.4f, 576.0f, 256.0f, 576.0f)
                curveTo(167.6f, 576.0f, 96.0f, 504.4f, 96.0f, 416.0f)
                curveTo(96.0f, 327.6f, 167.6f, 256.0f, 256.0f, 256.0f)
                curveTo(262.0f, 256.0f, 267.9f, 256.3f, 273.8f, 257.0f)
                lineTo(324.2f, 206.6f)
                lineTo(301.5f, 188.1f)
                close()
                moveTo(256.0f, 512.0f)
                curveTo(309.0f, 512.0f, 352.0f, 469.0f, 352.0f, 416.0f)
                curveTo(352.0f, 363.0f, 309.0f, 320.0f, 256.0f, 320.0f)
                curveTo(203.0f, 320.0f, 160.0f, 363.0f, 160.0f, 416.0f)
                curveTo(160.0f, 469.0f, 203.0f, 512.0f, 256.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_wheelchair-alt`!!
    }

private var `_wheelchair-alt`: ImageVector? = null
