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

public val Fa.`Laugh-wink`: ImageVector
    get() {
        if (`_laugh-wink` != null) {
            return `_laugh-wink`!!
        }
        `_laugh-wink` = Builder(name = "Laugh-wink", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(165.6f, 378.0f)
                curveTo(161.9f, 364.3f, 173.1f, 352.0f, 187.3f, 352.0f)
                lineTo(452.7f, 352.0f)
                curveTo(466.9f, 352.0f, 478.1f, 364.3f, 474.4f, 378.0f)
                curveTo(455.9f, 446.0f, 393.8f, 496.0f, 320.0f, 496.0f)
                curveTo(246.2f, 496.0f, 184.0f, 446.0f, 165.6f, 378.0f)
                close()
                moveTo(208.0f, 256.0f)
                curveTo(208.0f, 238.3f, 222.3f, 224.0f, 240.0f, 224.0f)
                curveTo(257.7f, 224.0f, 272.0f, 238.3f, 272.0f, 256.0f)
                curveTo(272.0f, 273.7f, 257.7f, 288.0f, 240.0f, 288.0f)
                curveTo(222.3f, 288.0f, 208.0f, 273.7f, 208.0f, 256.0f)
                close()
                moveTo(372.0f, 264.0f)
                curveTo(372.0f, 275.0f, 363.0f, 284.0f, 352.0f, 284.0f)
                curveTo(341.0f, 284.0f, 332.0f, 275.0f, 332.0f, 264.0f)
                curveTo(332.0f, 230.9f, 358.9f, 204.0f, 392.0f, 204.0f)
                lineTo(408.0f, 204.0f)
                curveTo(441.1f, 204.0f, 468.0f, 230.9f, 468.0f, 264.0f)
                curveTo(468.0f, 275.0f, 459.0f, 284.0f, 448.0f, 284.0f)
                curveTo(437.0f, 284.0f, 428.0f, 275.0f, 428.0f, 264.0f)
                curveTo(428.0f, 253.0f, 419.0f, 244.0f, 408.0f, 244.0f)
                lineTo(392.0f, 244.0f)
                curveTo(381.0f, 244.0f, 372.0f, 253.0f, 372.0f, 264.0f)
                close()
            }
        }
        .build()
        return `_laugh-wink`!!
    }

private var `_laugh-wink`: ImageVector? = null
