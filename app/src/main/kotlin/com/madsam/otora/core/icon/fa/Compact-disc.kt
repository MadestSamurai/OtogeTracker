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

public val Fa.`Compact-disc`: ImageVector
    get() {
        if (`_compact-disc` != null) {
            return `_compact-disc`!!
        }
        `_compact-disc` = Builder(name = "Compact-disc", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 337.7f, 288.0f, 320.0f)
                curveTo(288.0f, 302.3f, 302.3f, 288.0f, 320.0f, 288.0f)
                curveTo(337.7f, 288.0f, 352.0f, 302.3f, 352.0f, 320.0f)
                curveTo(352.0f, 337.7f, 337.7f, 352.0f, 320.0f, 352.0f)
                close()
                moveTo(224.0f, 320.0f)
                curveTo(224.0f, 373.0f, 267.0f, 416.0f, 320.0f, 416.0f)
                curveTo(373.0f, 416.0f, 416.0f, 373.0f, 416.0f, 320.0f)
                curveTo(416.0f, 267.0f, 373.0f, 224.0f, 320.0f, 224.0f)
                curveTo(267.0f, 224.0f, 224.0f, 267.0f, 224.0f, 320.0f)
                close()
                moveTo(168.0f, 304.0f)
                curveTo(168.0f, 271.6f, 184.3f, 237.4f, 210.8f, 210.8f)
                curveTo(237.3f, 184.2f, 271.6f, 168.0f, 304.0f, 168.0f)
                curveTo(317.3f, 168.0f, 328.0f, 157.3f, 328.0f, 144.0f)
                curveTo(328.0f, 130.7f, 317.3f, 120.0f, 304.0f, 120.0f)
                curveTo(256.1f, 120.0f, 210.3f, 143.5f, 176.9f, 176.9f)
                curveTo(143.5f, 210.3f, 120.0f, 256.1f, 120.0f, 304.0f)
                curveTo(120.0f, 317.3f, 130.7f, 328.0f, 144.0f, 328.0f)
                curveTo(157.3f, 328.0f, 168.0f, 317.3f, 168.0f, 304.0f)
                close()
            }
        }
        .build()
        return `_compact-disc`!!
    }

private var `_compact-disc`: ImageVector? = null
