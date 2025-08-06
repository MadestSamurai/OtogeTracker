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

public val Fa.`Person-pregnant`: ImageVector
    get() {
        if (`_person-pregnant` != null) {
            return `_person-pregnant`!!
        }
        `_person-pregnant` = Builder(name = "Person-pregnant", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 144.0f)
                curveTo(350.9f, 144.0f, 376.0f, 118.9f, 376.0f, 88.0f)
                curveTo(376.0f, 57.1f, 350.9f, 32.0f, 320.0f, 32.0f)
                curveTo(289.1f, 32.0f, 264.0f, 57.1f, 264.0f, 88.0f)
                curveTo(264.0f, 118.9f, 289.1f, 144.0f, 320.0f, 144.0f)
                close()
                moveTo(400.0f, 465.2f)
                curveTo(408.6f, 460.7f, 416.8f, 455.2f, 424.3f, 448.7f)
                lineTo(428.3f, 445.3f)
                curveTo(450.9f, 425.9f, 464.0f, 397.6f, 464.0f, 367.7f)
                curveTo(464.0f, 331.8f, 445.2f, 298.6f, 414.4f, 280.1f)
                lineTo(384.0f, 261.9f)
                lineTo(384.0f, 260.1f)
                curveTo(384.0f, 213.6f, 346.3f, 176.0f, 299.9f, 176.0f)
                curveTo(271.8f, 176.0f, 245.5f, 190.1f, 229.9f, 213.5f)
                lineTo(149.4f, 334.2f)
                curveTo(139.6f, 348.9f, 143.6f, 368.8f, 158.3f, 378.6f)
                curveTo(173.0f, 388.4f, 192.9f, 384.4f, 202.7f, 369.7f)
                lineTo(231.7f, 326.2f)
                lineTo(201.2f, 439.7f)
                curveTo(198.6f, 449.3f, 200.6f, 459.6f, 206.7f, 467.5f)
                curveTo(212.8f, 475.4f, 222.0f, 480.0f, 232.0f, 480.0f)
                lineTo(240.0f, 480.0f)
                lineTo(240.0f, 576.0f)
                curveTo(240.0f, 593.7f, 254.3f, 608.0f, 272.0f, 608.0f)
                curveTo(289.7f, 608.0f, 304.0f, 593.7f, 304.0f, 576.0f)
                lineTo(304.0f, 480.0f)
                lineTo(336.0f, 480.0f)
                lineTo(336.0f, 576.0f)
                curveTo(336.0f, 593.7f, 350.3f, 608.0f, 368.0f, 608.0f)
                curveTo(385.7f, 608.0f, 400.0f, 593.7f, 400.0f, 576.0f)
                lineTo(400.0f, 465.2f)
                close()
            }
        }
        .build()
        return `_person-pregnant`!!
    }

private var `_person-pregnant`: ImageVector? = null
