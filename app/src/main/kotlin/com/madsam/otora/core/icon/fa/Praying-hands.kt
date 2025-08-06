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

public val Fa.`Praying-hands`: ImageVector
    get() {
        if (`_praying-hands` != null) {
            return `_praying-hands`!!
        }
        `_praying-hands` = Builder(name = "Praying-hands", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 360.0f)
                curveTo(224.0f, 373.3f, 213.3f, 384.0f, 200.0f, 384.0f)
                curveTo(186.7f, 384.0f, 176.0f, 373.3f, 176.0f, 360.0f)
                lineTo(176.0f, 247.4f)
                lineTo(264.2f, 127.7f)
                curveTo(277.3f, 109.9f, 273.5f, 84.9f, 255.7f, 71.8f)
                curveTo(237.9f, 58.7f, 212.9f, 62.5f, 199.8f, 80.3f)
                lineTo(106.5f, 206.9f)
                curveTo(89.3f, 230.2f, 80.0f, 258.5f, 80.0f, 287.6f)
                lineTo(80.0f, 398.3f)
                lineTo(21.9f, 417.7f)
                curveTo(8.8f, 422.0f, 0.0f, 434.2f, 0.0f, 448.0f)
                lineTo(0.0f, 544.0f)
                curveTo(0.0f, 554.0f, 4.7f, 563.5f, 12.7f, 569.5f)
                curveTo(20.7f, 575.5f, 31.1f, 577.5f, 40.8f, 574.7f)
                lineTo(195.2f, 530.6f)
                curveTo(250.2f, 514.9f, 288.0f, 464.7f, 288.0f, 407.5f)
                lineTo(288.0f, 288.0f)
                curveTo(288.0f, 270.3f, 273.7f, 256.0f, 256.0f, 256.0f)
                curveTo(238.3f, 256.0f, 224.0f, 270.3f, 224.0f, 288.0f)
                lineTo(224.0f, 360.0f)
                close()
                moveTo(416.0f, 360.0f)
                lineTo(416.0f, 288.0f)
                curveTo(416.0f, 270.3f, 401.7f, 256.0f, 384.0f, 256.0f)
                curveTo(366.3f, 256.0f, 352.0f, 270.3f, 352.0f, 288.0f)
                lineTo(352.0f, 407.6f)
                curveTo(352.0f, 464.8f, 389.9f, 515.0f, 444.8f, 530.7f)
                lineTo(599.2f, 574.8f)
                curveTo(608.9f, 577.6f, 619.2f, 575.6f, 627.3f, 569.6f)
                curveTo(635.4f, 563.6f, 640.0f, 554.0f, 640.0f, 544.0f)
                lineTo(640.0f, 448.0f)
                curveTo(640.0f, 434.2f, 631.2f, 422.0f, 618.1f, 417.6f)
                lineTo(560.0f, 398.2f)
                lineTo(560.0f, 287.5f)
                curveTo(560.0f, 258.5f, 550.7f, 230.2f, 533.5f, 206.8f)
                lineTo(440.2f, 80.3f)
                curveTo(427.1f, 62.5f, 402.1f, 58.7f, 384.3f, 71.8f)
                curveTo(366.5f, 84.9f, 362.7f, 109.9f, 375.8f, 127.7f)
                lineTo(464.0f, 247.4f)
                lineTo(464.0f, 360.0f)
                curveTo(464.0f, 373.3f, 453.3f, 384.0f, 440.0f, 384.0f)
                curveTo(426.7f, 384.0f, 416.0f, 373.3f, 416.0f, 360.0f)
                close()
            }
        }
        .build()
        return `_praying-hands`!!
    }

private var `_praying-hands`: ImageVector? = null
