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

public val Fa.`Sack-xmark`: ImageVector
    get() {
        if (`_sack-xmark` != null) {
            return `_sack-xmark`!!
        }
        `_sack-xmark` = Builder(name = "Sack-xmark", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(392.0f, 176.0f)
                lineTo(248.0f, 176.0f)
                lineTo(210.7f, 101.5f)
                curveTo(208.9f, 97.9f, 208.0f, 93.9f, 208.0f, 89.9f)
                curveTo(208.0f, 75.6f, 219.6f, 64.0f, 233.9f, 64.0f)
                lineTo(406.1f, 64.0f)
                curveTo(420.4f, 64.0f, 432.0f, 75.6f, 432.0f, 89.9f)
                curveTo(432.0f, 93.9f, 431.1f, 97.9f, 429.3f, 101.5f)
                lineTo(392.0f, 176.0f)
                close()
                moveTo(233.6f, 224.0f)
                lineTo(406.4f, 224.0f)
                lineTo(455.1f, 264.6f)
                curveTo(521.6f, 320.0f, 560.0f, 402.0f, 560.0f, 488.5f)
                curveTo(560.0f, 536.8f, 520.8f, 576.0f, 472.5f, 576.0f)
                lineTo(167.4f, 576.0f)
                curveTo(119.2f, 576.0f, 80.0f, 536.8f, 80.0f, 488.5f)
                curveTo(80.0f, 402.0f, 118.4f, 320.0f, 184.9f, 264.6f)
                lineTo(233.6f, 224.0f)
                close()
                moveTo(387.9f, 348.1f)
                curveTo(378.5f, 338.7f, 363.3f, 338.7f, 354.0f, 348.1f)
                lineTo(320.1f, 382.0f)
                lineTo(286.2f, 348.1f)
                curveTo(276.8f, 338.7f, 261.6f, 338.7f, 252.3f, 348.1f)
                curveTo(243.0f, 357.5f, 242.9f, 372.7f, 252.3f, 382.0f)
                lineTo(286.2f, 415.9f)
                lineTo(252.3f, 449.8f)
                curveTo(242.9f, 459.2f, 242.9f, 474.4f, 252.3f, 483.7f)
                curveTo(261.7f, 493.0f, 276.9f, 493.1f, 286.2f, 483.7f)
                lineTo(320.1f, 449.8f)
                lineTo(354.0f, 483.7f)
                curveTo(363.4f, 493.1f, 378.6f, 493.1f, 387.9f, 483.7f)
                curveTo(397.2f, 474.3f, 397.3f, 459.1f, 387.9f, 449.8f)
                lineTo(354.0f, 415.9f)
                lineTo(387.9f, 382.0f)
                curveTo(397.3f, 372.6f, 397.3f, 357.4f, 387.9f, 348.1f)
                close()
            }
        }
        .build()
        return `_sack-xmark`!!
    }

private var `_sack-xmark`: ImageVector? = null
