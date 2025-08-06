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

public val Fa.`File-code`: ImageVector
    get() {
        if (`_file-code` != null) {
            return `_file-code`!!
        }
        `_file-code` = Builder(name = "File-code", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(341.5f, 64.0f)
                curveTo(358.5f, 64.0f, 374.8f, 70.7f, 386.8f, 82.7f)
                lineTo(493.3f, 189.3f)
                curveTo(505.3f, 201.3f, 512.0f, 217.6f, 512.0f, 234.6f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(336.0f, 122.5f)
                lineTo(336.0f, 216.0f)
                curveTo(336.0f, 229.3f, 346.7f, 240.0f, 360.0f, 240.0f)
                lineTo(453.5f, 240.0f)
                lineTo(336.0f, 122.5f)
                close()
                moveTo(282.2f, 359.6f)
                curveTo(290.8f, 349.5f, 289.7f, 334.4f, 279.6f, 325.8f)
                curveTo(269.5f, 317.2f, 254.4f, 318.3f, 245.8f, 328.4f)
                lineTo(197.8f, 384.4f)
                curveTo(190.1f, 393.4f, 190.1f, 406.6f, 197.8f, 415.6f)
                lineTo(245.8f, 471.6f)
                curveTo(254.4f, 481.7f, 269.6f, 482.8f, 279.6f, 474.2f)
                curveTo(289.6f, 465.6f, 290.8f, 450.4f, 282.2f, 440.4f)
                lineTo(247.6f, 400.0f)
                lineTo(282.2f, 359.6f)
                close()
                moveTo(394.2f, 328.4f)
                curveTo(385.6f, 318.3f, 370.4f, 317.2f, 360.4f, 325.8f)
                curveTo(350.4f, 334.4f, 349.2f, 349.6f, 357.8f, 359.6f)
                lineTo(392.4f, 400.0f)
                lineTo(357.8f, 440.4f)
                curveTo(349.2f, 450.5f, 350.3f, 465.6f, 360.4f, 474.2f)
                curveTo(370.5f, 482.8f, 385.6f, 481.7f, 394.2f, 471.6f)
                lineTo(442.2f, 415.6f)
                curveTo(449.9f, 406.6f, 449.9f, 393.4f, 442.2f, 384.4f)
                lineTo(394.2f, 328.4f)
                close()
            }
        }
        .build()
        return `_file-code`!!
    }

private var `_file-code`: ImageVector? = null
