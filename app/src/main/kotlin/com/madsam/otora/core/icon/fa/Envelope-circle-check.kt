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

public val Fa.`Envelope-circle-check`: ImageVector
    get() {
        if (`_envelope-circle-check` != null) {
            return `_envelope-circle-check`!!
        }
        `_envelope-circle-check` = Builder(name = "Envelope-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 176.0f)
                curveTo(64.0f, 149.5f, 85.5f, 128.0f, 112.0f, 128.0f)
                lineTo(528.0f, 128.0f)
                curveTo(554.5f, 128.0f, 576.0f, 149.5f, 576.0f, 176.0f)
                lineTo(576.0f, 257.4f)
                curveTo(551.6f, 246.2f, 524.6f, 240.0f, 496.0f, 240.0f)
                curveTo(408.3f, 240.0f, 334.3f, 298.8f, 311.3f, 379.2f)
                curveTo(304.2f, 377.9f, 297.2f, 375.0f, 291.2f, 370.4f)
                lineTo(83.2f, 214.4f)
                curveTo(71.1f, 205.3f, 64.0f, 191.1f, 64.0f, 176.0f)
                close()
                moveTo(304.0f, 432.0f)
                curveTo(304.0f, 460.6f, 310.2f, 487.6f, 321.4f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 260.0f)
                lineTo(262.4f, 408.8f)
                curveTo(275.0f, 418.2f, 289.3f, 424.2f, 304.1f, 426.7f)
                curveTo(304.1f, 428.5f, 304.0f, 430.2f, 304.0f, 432.0f)
                close()
                moveTo(352.0f, 432.0f)
                curveTo(352.0f, 352.5f, 416.5f, 288.0f, 496.0f, 288.0f)
                curveTo(575.5f, 288.0f, 640.0f, 352.5f, 640.0f, 432.0f)
                curveTo(640.0f, 511.5f, 575.5f, 576.0f, 496.0f, 576.0f)
                curveTo(416.5f, 576.0f, 352.0f, 511.5f, 352.0f, 432.0f)
                close()
                moveTo(553.4f, 371.1f)
                curveTo(546.3f, 365.9f, 536.2f, 367.5f, 531.0f, 374.6f)
                lineTo(478.0f, 447.5f)
                lineTo(451.2f, 420.7f)
                curveTo(445.0f, 414.5f, 434.8f, 414.5f, 428.6f, 420.7f)
                curveTo(422.4f, 426.9f, 422.4f, 437.1f, 428.6f, 443.3f)
                lineTo(468.6f, 483.3f)
                curveTo(471.9f, 486.6f, 476.5f, 488.3f, 481.2f, 487.9f)
                curveTo(485.9f, 487.5f, 490.1f, 485.1f, 492.9f, 481.4f)
                lineTo(556.9f, 393.4f)
                curveTo(562.1f, 386.3f, 560.5f, 376.2f, 553.4f, 371.1f)
                close()
            }
        }
        .build()
        return `_envelope-circle-check`!!
    }

private var `_envelope-circle-check`: ImageVector? = null
