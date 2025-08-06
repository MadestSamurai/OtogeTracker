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

public val Fa.`Face-angry`: ImageVector
    get() {
        if (`_face-angry` != null) {
            return `_face-angry`!!
        }
        `_face-angry` = Builder(name = "Face-angry", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(320.0f, 432.0f)
                curveTo(344.1f, 432.0f, 365.4f, 443.8f, 378.5f, 462.0f)
                curveTo(386.2f, 472.8f, 401.2f, 475.2f, 412.0f, 467.5f)
                curveTo(422.8f, 459.8f, 425.2f, 444.8f, 417.5f, 434.0f)
                curveTo(395.8f, 403.8f, 360.2f, 384.0f, 320.0f, 384.0f)
                curveTo(279.8f, 384.0f, 244.3f, 403.8f, 222.5f, 434.0f)
                curveTo(214.8f, 444.8f, 217.2f, 459.8f, 228.0f, 467.5f)
                curveTo(238.8f, 475.2f, 253.8f, 472.8f, 261.5f, 462.0f)
                curveTo(274.6f, 443.8f, 295.9f, 432.0f, 320.0f, 432.0f)
                close()
                moveTo(240.0f, 336.0f)
                curveTo(257.7f, 336.0f, 272.0f, 321.7f, 272.0f, 304.0f)
                lineTo(272.0f, 303.7f)
                lineTo(281.7f, 306.9f)
                curveTo(292.2f, 310.4f, 303.5f, 304.7f, 307.0f, 294.3f)
                curveTo(310.5f, 283.9f, 304.8f, 272.5f, 294.4f, 269.0f)
                lineTo(198.4f, 237.0f)
                curveTo(187.9f, 233.5f, 176.6f, 239.2f, 173.1f, 249.6f)
                curveTo(169.6f, 260.0f, 175.3f, 271.4f, 185.7f, 274.9f)
                lineTo(214.6f, 284.5f)
                curveTo(210.5f, 289.9f, 208.0f, 296.6f, 208.0f, 303.9f)
                curveTo(208.0f, 321.6f, 222.3f, 335.9f, 240.0f, 335.9f)
                close()
                moveTo(432.0f, 304.0f)
                curveTo(432.0f, 296.7f, 429.6f, 290.0f, 425.4f, 284.6f)
                lineTo(454.3f, 275.0f)
                curveTo(464.8f, 271.5f, 470.4f, 260.2f, 466.9f, 249.7f)
                curveTo(463.4f, 239.2f, 452.1f, 233.6f, 441.6f, 237.1f)
                lineTo(345.6f, 269.1f)
                curveTo(335.1f, 272.6f, 329.5f, 283.9f, 333.0f, 294.4f)
                curveTo(336.5f, 304.9f, 347.8f, 310.5f, 358.3f, 307.0f)
                lineTo(368.0f, 303.8f)
                lineTo(368.0f, 304.1f)
                curveTo(368.0f, 321.8f, 382.3f, 336.1f, 400.0f, 336.1f)
                curveTo(417.7f, 336.1f, 432.0f, 321.8f, 432.0f, 304.1f)
                close()
            }
        }
        .build()
        return `_face-angry`!!
    }

private var `_face-angry`: ImageVector? = null
