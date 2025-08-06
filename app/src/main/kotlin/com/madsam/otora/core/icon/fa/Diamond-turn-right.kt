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

public val Fa.`Diamond-turn-right`: ImageVector
    get() {
        if (`_diamond-turn-right` != null) {
            return `_diamond-turn-right`!!
        }
        `_diamond-turn-right` = Builder(name = "Diamond-turn-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(279.0f, 81.0f)
                lineTo(81.0f, 279.0f)
                curveTo(70.1f, 289.9f, 64.0f, 304.6f, 64.0f, 320.0f)
                curveTo(64.0f, 335.4f, 70.1f, 350.1f, 81.0f, 361.0f)
                lineTo(279.0f, 559.0f)
                curveTo(289.9f, 569.9f, 304.6f, 576.0f, 320.0f, 576.0f)
                curveTo(335.4f, 576.0f, 350.1f, 569.9f, 361.0f, 559.0f)
                lineTo(559.0f, 361.0f)
                curveTo(569.9f, 350.1f, 576.0f, 335.4f, 576.0f, 320.0f)
                curveTo(576.0f, 304.6f, 569.9f, 289.9f, 559.0f, 279.0f)
                lineTo(361.0f, 81.0f)
                curveTo(350.1f, 70.1f, 335.4f, 64.0f, 320.0f, 64.0f)
                curveTo(304.6f, 64.0f, 289.9f, 70.1f, 279.0f, 81.0f)
                close()
                moveTo(449.0f, 321.0f)
                lineTo(377.0f, 393.0f)
                curveTo(367.6f, 402.4f, 352.4f, 402.4f, 343.1f, 393.0f)
                curveTo(333.8f, 383.6f, 333.7f, 368.4f, 343.1f, 359.1f)
                lineTo(374.1f, 328.1f)
                lineTo(296.0f, 328.1f)
                curveTo(282.7f, 328.1f, 272.0f, 338.8f, 272.0f, 352.1f)
                lineTo(272.0f, 392.1f)
                curveTo(272.0f, 405.4f, 261.3f, 416.1f, 248.0f, 416.1f)
                curveTo(234.7f, 416.1f, 224.0f, 405.4f, 224.0f, 392.1f)
                lineTo(224.0f, 352.1f)
                curveTo(224.0f, 312.3f, 256.2f, 280.1f, 296.0f, 280.1f)
                lineTo(374.1f, 280.1f)
                lineTo(343.1f, 249.1f)
                curveTo(333.7f, 239.7f, 333.7f, 224.5f, 343.1f, 215.2f)
                curveTo(352.5f, 205.9f, 367.7f, 205.8f, 377.0f, 215.2f)
                lineTo(449.0f, 287.2f)
                curveTo(458.4f, 296.6f, 458.4f, 311.8f, 449.0f, 321.1f)
                close()
            }
        }
        .build()
        return `_diamond-turn-right`!!
    }

private var `_diamond-turn-right`: ImageVector? = null
