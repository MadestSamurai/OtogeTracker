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

public val Fa.`Bolt-lightning`: ImageVector
    get() {
        if (`_bolt-lightning` != null) {
            return `_bolt-lightning`!!
        }
        `_bolt-lightning` = Builder(name = "Bolt-lightning", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 320.0f)
                lineTo(156.5f, 92.0f)
                curveTo(158.5f, 76.0f, 172.1f, 64.0f, 188.3f, 64.0f)
                lineTo(356.9f, 64.0f)
                curveTo(371.9f, 64.0f, 384.0f, 76.1f, 384.0f, 91.1f)
                curveTo(384.0f, 94.3f, 383.4f, 97.6f, 382.3f, 100.6f)
                lineTo(336.0f, 224.0f)
                lineTo(475.3f, 224.0f)
                curveTo(495.5f, 224.0f, 512.0f, 240.4f, 512.0f, 260.7f)
                curveTo(512.0f, 268.1f, 509.8f, 275.3f, 505.6f, 281.4f)
                lineTo(313.4f, 562.4f)
                curveTo(307.5f, 571.0f, 297.8f, 576.1f, 287.5f, 576.1f)
                lineTo(284.6f, 576.1f)
                curveTo(268.9f, 576.1f, 256.1f, 563.3f, 256.1f, 547.6f)
                curveTo(256.1f, 545.3f, 256.4f, 543.0f, 257.0f, 540.7f)
                lineTo(304.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                curveTo(142.3f, 352.0f, 128.0f, 337.7f, 128.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_bolt-lightning`!!
    }

private var `_bolt-lightning`: ImageVector? = null
