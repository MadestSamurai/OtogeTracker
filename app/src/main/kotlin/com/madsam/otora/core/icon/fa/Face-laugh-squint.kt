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

public val Fa.`Face-laugh-squint`: ImageVector
    get() {
        if (`_face-laugh-squint` != null) {
            return `_face-laugh-squint`!!
        }
        `_face-laugh-squint` = Builder(name = "Face-laugh-squint", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(171.7f, 396.1f)
                curveTo(166.0f, 382.0f, 177.4f, 368.0f, 192.6f, 368.0f)
                lineTo(447.5f, 368.0f)
                curveTo(462.7f, 368.0f, 474.1f, 382.0f, 468.4f, 396.1f)
                curveTo(444.6f, 454.7f, 387.2f, 496.0f, 320.1f, 496.0f)
                curveTo(253.0f, 496.0f, 195.5f, 454.7f, 171.8f, 396.1f)
                close()
                moveTo(186.7f, 207.3f)
                curveTo(191.2f, 200.5f, 200.0f, 198.1f, 207.3f, 201.8f)
                lineTo(286.9f, 241.8f)
                curveTo(292.3f, 244.5f, 295.7f, 250.0f, 295.7f, 256.1f)
                curveTo(295.7f, 262.2f, 292.3f, 267.7f, 286.9f, 270.4f)
                lineTo(207.3f, 310.4f)
                curveTo(200.0f, 314.0f, 191.2f, 311.7f, 186.7f, 304.9f)
                curveTo(182.2f, 298.1f, 183.6f, 289.0f, 189.8f, 283.8f)
                lineTo(223.0f, 256.0f)
                lineTo(189.8f, 228.3f)
                curveTo(183.6f, 223.1f, 182.2f, 214.0f, 186.7f, 207.2f)
                close()
                moveTo(450.3f, 228.4f)
                lineTo(417.0f, 256.0f)
                lineTo(450.2f, 283.7f)
                curveTo(456.4f, 288.9f, 457.8f, 298.0f, 453.3f, 304.8f)
                curveTo(448.8f, 311.6f, 440.0f, 314.0f, 432.7f, 310.3f)
                lineTo(353.1f, 270.3f)
                curveTo(347.7f, 267.6f, 344.3f, 262.1f, 344.3f, 256.0f)
                curveTo(344.3f, 249.9f, 347.7f, 244.4f, 353.1f, 241.7f)
                lineTo(432.7f, 201.7f)
                curveTo(440.0f, 198.1f, 448.8f, 200.4f, 453.3f, 207.2f)
                curveTo(457.8f, 214.0f, 456.4f, 223.1f, 450.2f, 228.3f)
                close()
            }
        }
        .build()
        return `_face-laugh-squint`!!
    }

private var `_face-laugh-squint`: ImageVector? = null
