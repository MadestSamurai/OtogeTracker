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

public val Fa.`Person-through-window`: ImageVector
    get() {
        if (`_person-through-window` != null) {
            return `_person-through-window`!!
        }
        `_person-through-window` = Builder(name = "Person-through-window", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                lineTo(288.0f, 128.0f)
                lineTo(288.0f, 137.8f)
                curveTo(288.0f, 176.8f, 264.3f, 211.8f, 228.1f, 226.2f)
                curveTo(167.6f, 250.4f, 128.0f, 308.9f, 128.0f, 374.1f)
                lineTo(128.0f, 447.9f)
                lineTo(64.0f, 447.9f)
                lineTo(64.0f, 127.9f)
                close()
                moveTo(352.0f, 128.0f)
                lineTo(576.0f, 128.0f)
                lineTo(576.0f, 448.0f)
                lineTo(508.3f, 448.0f)
                lineTo(504.6f, 443.5f)
                lineTo(429.4f, 353.3f)
                curveTo(420.3f, 342.4f, 406.8f, 336.0f, 392.5f, 336.0f)
                lineTo(321.4f, 336.0f)
                lineTo(280.4f, 272.9f)
                curveTo(280.1f, 272.4f, 279.8f, 271.9f, 279.4f, 271.5f)
                curveTo(324.1f, 242.5f, 351.9f, 192.5f, 351.9f, 137.9f)
                lineTo(351.9f, 128.1f)
                close()
                moveTo(425.0f, 448.0f)
                lineTo(398.4f, 448.0f)
                lineTo(441.1f, 512.0f)
                lineTo(592.0f, 512.0f)
                curveTo(618.5f, 512.0f, 640.0f, 490.5f, 640.0f, 464.0f)
                lineTo(640.0f, 112.0f)
                curveTo(640.0f, 85.5f, 618.5f, 64.0f, 592.0f, 64.0f)
                lineTo(48.0f, 64.0f)
                curveTo(21.5f, 64.0f, 0.0f, 85.5f, 0.0f, 112.0f)
                lineTo(0.0f, 464.0f)
                curveTo(0.0f, 490.5f, 21.5f, 512.0f, 48.0f, 512.0f)
                lineTo(308.2f, 512.0f)
                lineTo(341.4f, 561.8f)
                curveTo(351.2f, 576.5f, 371.1f, 580.5f, 385.8f, 570.7f)
                curveTo(400.5f, 560.9f, 404.5f, 541.0f, 394.7f, 526.3f)
                lineTo(310.5f, 400.1f)
                lineTo(385.1f, 400.1f)
                lineTo(425.1f, 448.1f)
                close()
                moveTo(265.5f, 448.0f)
                lineTo(192.0f, 448.0f)
                lineTo(192.0f, 374.2f)
                curveTo(192.0f, 364.0f, 193.6f, 354.1f, 196.7f, 344.7f)
                lineTo(265.5f, 448.0f)
                close()
                moveTo(192.0f, 192.0f)
                curveTo(192.0f, 165.5f, 170.5f, 144.0f, 144.0f, 144.0f)
                curveTo(117.5f, 144.0f, 96.0f, 165.5f, 96.0f, 192.0f)
                curveTo(96.0f, 218.5f, 117.5f, 240.0f, 144.0f, 240.0f)
                curveTo(170.5f, 240.0f, 192.0f, 218.5f, 192.0f, 192.0f)
                close()
            }
        }
        .build()
        return `_person-through-window`!!
    }

private var `_person-through-window`: ImageVector? = null
