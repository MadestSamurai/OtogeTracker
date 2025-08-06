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

public val Fa.`Jug-detergent`: ImageVector
    get() {
        if (`_jug-detergent` != null) {
            return `_jug-detergent`!!
        }
        `_jug-detergent` = Builder(name = "Jug-detergent", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 88.0f)
                curveTo(224.0f, 74.7f, 234.7f, 64.0f, 248.0f, 64.0f)
                lineTo(328.0f, 64.0f)
                curveTo(341.3f, 64.0f, 352.0f, 74.7f, 352.0f, 88.0f)
                lineTo(352.0f, 112.0f)
                lineTo(360.0f, 112.0f)
                curveTo(373.3f, 112.0f, 384.0f, 122.7f, 384.0f, 136.0f)
                curveTo(384.0f, 149.3f, 373.3f, 160.0f, 360.0f, 160.0f)
                lineTo(216.0f, 160.0f)
                curveTo(202.7f, 160.0f, 192.0f, 149.3f, 192.0f, 136.0f)
                curveTo(192.0f, 122.7f, 202.7f, 112.0f, 216.0f, 112.0f)
                lineTo(224.0f, 112.0f)
                lineTo(224.0f, 88.0f)
                close()
                moveTo(128.0f, 320.0f)
                curveTo(128.0f, 249.3f, 185.3f, 192.0f, 256.0f, 192.0f)
                lineTo(384.0f, 192.0f)
                curveTo(454.7f, 192.0f, 512.0f, 249.3f, 512.0f, 320.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 320.0f)
                close()
                moveTo(384.0f, 320.0f)
                lineTo(384.0f, 416.0f)
                curveTo(384.0f, 433.7f, 398.3f, 448.0f, 416.0f, 448.0f)
                curveTo(433.7f, 448.0f, 448.0f, 433.7f, 448.0f, 416.0f)
                lineTo(448.0f, 320.0f)
                curveTo(448.0f, 302.3f, 433.7f, 288.0f, 416.0f, 288.0f)
                curveTo(398.3f, 288.0f, 384.0f, 302.3f, 384.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_jug-detergent`!!
    }

private var `_jug-detergent`: ImageVector? = null
