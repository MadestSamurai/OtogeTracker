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

public val Fa.`Helmet-safety`: ImageVector
    get() {
        if (`_helmet-safety` != null) {
            return `_helmet-safety`!!
        }
        `_helmet-safety` = Builder(name = "Helmet-safety", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 328.0f)
                lineTo(384.0f, 128.0f)
                curveTo(384.0f, 110.3f, 369.7f, 96.0f, 352.0f, 96.0f)
                lineTo(288.0f, 96.0f)
                curveTo(270.3f, 96.0f, 256.0f, 110.3f, 256.0f, 128.0f)
                lineTo(256.0f, 328.0f)
                curveTo(256.0f, 341.3f, 245.3f, 352.0f, 232.0f, 352.0f)
                curveTo(218.7f, 352.0f, 208.0f, 341.3f, 208.0f, 328.0f)
                lineTo(208.0f, 142.1f)
                curveTo(122.0f, 173.8f, 64.0f, 255.8f, 64.0f, 352.0f)
                lineTo(64.0f, 416.0f)
                lineTo(576.0f, 416.0f)
                lineTo(576.0f, 352.0f)
                curveTo(575.0f, 256.8f, 517.6f, 174.3f, 432.0f, 142.2f)
                lineTo(432.0f, 328.0f)
                curveTo(432.0f, 341.3f, 421.3f, 352.0f, 408.0f, 352.0f)
                curveTo(394.7f, 352.0f, 384.0f, 341.3f, 384.0f, 328.0f)
                close()
                moveTo(72.0f, 464.0f)
                curveTo(49.9f, 464.0f, 32.0f, 481.9f, 32.0f, 504.0f)
                curveTo(32.0f, 526.1f, 49.9f, 544.0f, 72.0f, 544.0f)
                lineTo(568.0f, 544.0f)
                curveTo(590.1f, 544.0f, 608.0f, 526.1f, 608.0f, 504.0f)
                curveTo(608.0f, 481.9f, 590.1f, 464.0f, 568.0f, 464.0f)
                lineTo(72.0f, 464.0f)
                close()
            }
        }
        .build()
        return `_helmet-safety`!!
    }

private var `_helmet-safety`: ImageVector? = null
