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

public val Fa.`Face-grin-squint`: ImageVector
    get() {
        if (`_face-grin-squint` != null) {
            return `_face-grin-squint`!!
        }
        `_face-grin-squint` = Builder(name = "Face-grin-squint", defaultWidth = 640.0.dp,
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
                moveTo(450.7f, 372.9f)
                curveTo(462.6f, 369.2f, 474.6f, 379.2f, 470.3f, 391.0f)
                curveTo(447.9f, 452.3f, 389.0f, 496.1f, 320.0f, 496.1f)
                curveTo(251.0f, 496.1f, 192.1f, 452.2f, 169.7f, 390.9f)
                curveTo(165.4f, 379.1f, 177.4f, 369.1f, 189.3f, 372.8f)
                curveTo(228.5f, 385.0f, 273.0f, 391.9f, 320.0f, 391.9f)
                curveTo(367.0f, 391.9f, 411.5f, 385.0f, 450.7f, 372.8f)
                close()
                moveTo(186.6f, 207.2f)
                curveTo(191.1f, 200.4f, 199.9f, 198.0f, 207.2f, 201.7f)
                lineTo(286.8f, 241.7f)
                curveTo(292.2f, 244.4f, 295.6f, 249.9f, 295.6f, 256.0f)
                curveTo(295.6f, 262.1f, 292.2f, 267.6f, 286.8f, 270.3f)
                lineTo(207.2f, 310.3f)
                curveTo(199.9f, 313.9f, 191.1f, 311.6f, 186.6f, 304.8f)
                curveTo(182.1f, 298.0f, 183.5f, 288.9f, 189.7f, 283.7f)
                lineTo(223.0f, 256.0f)
                lineTo(189.8f, 228.3f)
                curveTo(183.6f, 223.1f, 182.2f, 214.0f, 186.7f, 207.2f)
                close()
                moveTo(450.2f, 228.3f)
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
        return `_face-grin-squint`!!
    }

private var `_face-grin-squint`: ImageVector? = null
