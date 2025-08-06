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

public val Fa.`Fire-extinguisher`: ImageVector
    get() {
        if (`_fire-extinguisher` != null) {
            return `_fire-extinguisher`!!
        }
        `_fire-extinguisher` = Builder(name = "Fire-extinguisher", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 96.0f)
                curveTo(576.0f, 86.4f, 571.7f, 77.3f, 564.3f, 71.3f)
                curveTo(556.9f, 65.3f, 547.1f, 62.7f, 537.7f, 64.6f)
                lineTo(377.7f, 96.6f)
                curveTo(365.5f, 99.1f, 356.0f, 108.3f, 353.0f, 120.0f)
                lineTo(288.0f, 120.0f)
                lineTo(288.0f, 96.0f)
                curveTo(288.0f, 78.3f, 273.7f, 64.0f, 256.0f, 64.0f)
                lineTo(224.0f, 64.0f)
                curveTo(206.3f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                lineTo(192.0f, 124.4f)
                curveTo(136.7f, 136.7f, 90.7f, 173.9f, 66.5f, 223.5f)
                curveTo(60.7f, 235.4f, 65.6f, 249.8f, 77.6f, 255.6f)
                curveTo(89.6f, 261.4f, 103.9f, 256.5f, 109.7f, 244.5f)
                curveTo(126.0f, 210.9f, 155.8f, 185.1f, 192.0f, 174.0f)
                lineTo(192.0f, 202.8f)
                curveTo(154.2f, 220.8f, 128.0f, 259.3f, 128.0f, 304.0f)
                lineTo(128.0f, 432.0f)
                lineTo(352.0f, 432.0f)
                lineTo(352.0f, 304.0f)
                curveTo(352.0f, 259.3f, 325.8f, 220.8f, 288.0f, 202.8f)
                lineTo(288.0f, 168.0f)
                lineTo(353.0f, 168.0f)
                curveTo(356.0f, 179.7f, 365.5f, 188.9f, 377.7f, 191.4f)
                lineTo(537.7f, 223.4f)
                curveTo(547.1f, 225.3f, 556.8f, 222.8f, 564.3f, 216.8f)
                curveTo(571.8f, 210.8f, 576.0f, 201.6f, 576.0f, 192.0f)
                lineTo(576.0f, 96.0f)
                close()
                moveTo(352.0f, 512.0f)
                lineTo(352.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(288.0f, 576.0f)
                curveTo(323.3f, 576.0f, 352.0f, 547.3f, 352.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_fire-extinguisher`!!
    }

private var `_fire-extinguisher`: ImageVector? = null
