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

public val Fa.`Bore-hole`: ImageVector
    get() {
        if (`_bore-hole` != null) {
            return `_bore-hole`!!
        }
        `_bore-hole` = Builder(name = "Bore-hole", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 328.6f)
                curveTo(268.9f, 339.7f, 256.0f, 360.3f, 256.0f, 384.0f)
                curveTo(256.0f, 419.3f, 284.7f, 448.0f, 320.0f, 448.0f)
                curveTo(355.3f, 448.0f, 384.0f, 419.3f, 384.0f, 384.0f)
                curveTo(384.0f, 360.3f, 371.1f, 339.6f, 352.0f, 328.6f)
                lineTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(64.0f, 448.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 240.0f)
                curveTo(576.0f, 213.5f, 554.5f, 192.0f, 528.0f, 192.0f)
                lineTo(480.0f, 192.0f)
                curveTo(453.5f, 192.0f, 432.0f, 213.5f, 432.0f, 240.0f)
                lineTo(432.0f, 384.0f)
                curveTo(432.0f, 445.9f, 381.9f, 496.0f, 320.0f, 496.0f)
                curveTo(258.1f, 496.0f, 208.0f, 445.9f, 208.0f, 384.0f)
                lineTo(208.0f, 240.0f)
                curveTo(208.0f, 213.5f, 186.5f, 192.0f, 160.0f, 192.0f)
                lineTo(112.0f, 192.0f)
                curveTo(85.5f, 192.0f, 64.0f, 213.5f, 64.0f, 240.0f)
                lineTo(64.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_bore-hole`!!
    }

private var `_bore-hole`: ImageVector? = null
