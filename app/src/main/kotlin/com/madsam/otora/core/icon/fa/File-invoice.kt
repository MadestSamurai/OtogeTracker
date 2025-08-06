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

public val Fa.`File-invoice`: ImageVector
    get() {
        if (`_file-invoice` != null) {
            return `_file-invoice`!!
        }
        `_file-invoice` = Builder(name = "File-invoice", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(483.3f, 576.0f, 512.0f, 547.3f, 512.0f, 512.0f)
                lineTo(512.0f, 234.5f)
                curveTo(512.0f, 217.5f, 505.3f, 201.2f, 493.3f, 189.2f)
                lineTo(386.7f, 82.7f)
                curveTo(374.7f, 70.7f, 358.5f, 64.0f, 341.5f, 64.0f)
                lineTo(192.0f, 64.0f)
                close()
                moveTo(453.5f, 240.0f)
                lineTo(360.0f, 240.0f)
                curveTo(346.7f, 240.0f, 336.0f, 229.3f, 336.0f, 216.0f)
                lineTo(336.0f, 122.5f)
                lineTo(453.5f, 240.0f)
                close()
                moveTo(192.0f, 448.0f)
                lineTo(192.0f, 384.0f)
                curveTo(192.0f, 366.3f, 206.3f, 352.0f, 224.0f, 352.0f)
                lineTo(416.0f, 352.0f)
                curveTo(433.7f, 352.0f, 448.0f, 366.3f, 448.0f, 384.0f)
                lineTo(448.0f, 448.0f)
                curveTo(448.0f, 465.7f, 433.7f, 480.0f, 416.0f, 480.0f)
                lineTo(224.0f, 480.0f)
                curveTo(206.3f, 480.0f, 192.0f, 465.7f, 192.0f, 448.0f)
                close()
                moveTo(216.0f, 128.0f)
                lineTo(264.0f, 128.0f)
                curveTo(277.3f, 128.0f, 288.0f, 138.7f, 288.0f, 152.0f)
                curveTo(288.0f, 165.3f, 277.3f, 176.0f, 264.0f, 176.0f)
                lineTo(216.0f, 176.0f)
                curveTo(202.7f, 176.0f, 192.0f, 165.3f, 192.0f, 152.0f)
                curveTo(192.0f, 138.7f, 202.7f, 128.0f, 216.0f, 128.0f)
                close()
                moveTo(216.0f, 224.0f)
                lineTo(264.0f, 224.0f)
                curveTo(277.3f, 224.0f, 288.0f, 234.7f, 288.0f, 248.0f)
                curveTo(288.0f, 261.3f, 277.3f, 272.0f, 264.0f, 272.0f)
                lineTo(216.0f, 272.0f)
                curveTo(202.7f, 272.0f, 192.0f, 261.3f, 192.0f, 248.0f)
                curveTo(192.0f, 234.7f, 202.7f, 224.0f, 216.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_file-invoice`!!
    }

private var `_file-invoice`: ImageVector? = null
