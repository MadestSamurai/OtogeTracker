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

public val Fa.`Fill-drip`: ImageVector
    get() {
        if (`_fill-drip` != null) {
            return `_fill-drip`!!
        }
        `_fill-drip` = Builder(name = "Fill-drip", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(341.7f, 135.6f)
                lineTo(277.3f, 200.0f)
                lineTo(310.7f, 233.4f)
                curveTo(323.2f, 245.9f, 323.2f, 266.2f, 310.7f, 278.7f)
                curveTo(298.2f, 291.2f, 277.9f, 291.2f, 265.4f, 278.7f)
                lineTo(232.0f, 245.3f)
                lineTo(135.6f, 341.7f)
                curveTo(132.7f, 344.6f, 130.5f, 348.2f, 129.3f, 352.0f)
                lineTo(450.8f, 352.0f)
                lineTo(504.5f, 298.3f)
                curveTo(509.4f, 293.4f, 512.1f, 286.8f, 512.1f, 280.0f)
                curveTo(512.1f, 273.2f, 509.4f, 266.5f, 504.5f, 261.7f)
                lineTo(378.3f, 135.6f)
                curveTo(373.5f, 130.7f, 366.9f, 128.0f, 360.0f, 128.0f)
                curveTo(353.1f, 128.0f, 346.5f, 130.7f, 341.7f, 135.6f)
                close()
                moveTo(90.3f, 296.4f)
                lineTo(186.7f, 200.0f)
                lineTo(137.3f, 150.6f)
                curveTo(124.8f, 138.1f, 124.8f, 117.8f, 137.3f, 105.3f)
                curveTo(149.8f, 92.8f, 170.1f, 92.8f, 182.6f, 105.3f)
                lineTo(232.0f, 154.7f)
                lineTo(296.4f, 90.3f)
                curveTo(313.3f, 73.5f, 336.1f, 64.0f, 360.0f, 64.0f)
                curveTo(383.9f, 64.0f, 406.7f, 73.5f, 423.6f, 90.3f)
                lineTo(549.7f, 216.4f)
                curveTo(566.5f, 233.3f, 576.0f, 256.1f, 576.0f, 280.0f)
                curveTo(576.0f, 303.9f, 566.5f, 326.7f, 549.7f, 343.6f)
                lineTo(343.6f, 549.7f)
                curveTo(326.7f, 566.5f, 303.9f, 576.0f, 280.0f, 576.0f)
                curveTo(256.1f, 576.0f, 233.3f, 566.5f, 216.4f, 549.7f)
                lineTo(90.3f, 423.6f)
                curveTo(73.5f, 406.7f, 64.0f, 383.9f, 64.0f, 360.0f)
                curveTo(64.0f, 336.1f, 73.5f, 313.3f, 90.3f, 296.4f)
                close()
                moveTo(544.0f, 608.0f)
                curveTo(508.7f, 608.0f, 480.0f, 579.3f, 480.0f, 544.0f)
                curveTo(480.0f, 518.8f, 512.6f, 464.4f, 531.2f, 435.3f)
                curveTo(537.2f, 425.9f, 550.7f, 425.9f, 556.7f, 435.3f)
                curveTo(575.4f, 464.4f, 607.9f, 518.8f, 607.9f, 544.0f)
                curveTo(607.9f, 579.3f, 579.2f, 608.0f, 543.9f, 608.0f)
                close()
            }
        }
        .build()
        return `_fill-drip`!!
    }

private var `_fill-drip`: ImageVector? = null
