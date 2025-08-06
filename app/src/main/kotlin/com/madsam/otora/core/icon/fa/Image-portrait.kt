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

public val Fa.`Image-portrait`: ImageVector
    get() {
        if (`_image-portrait` != null) {
            return `_image-portrait`!!
        }
        `_image-portrait` = Builder(name = "Image-portrait", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(483.3f, 64.0f, 512.0f, 92.7f, 512.0f, 128.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(208.0f, 432.0f)
                curveTo(208.0f, 440.8f, 215.2f, 448.0f, 224.0f, 448.0f)
                lineTo(416.0f, 448.0f)
                curveTo(424.8f, 448.0f, 432.0f, 440.8f, 432.0f, 432.0f)
                curveTo(432.0f, 387.8f, 396.2f, 352.0f, 352.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                curveTo(243.8f, 352.0f, 208.0f, 387.8f, 208.0f, 432.0f)
                close()
                moveTo(320.0f, 312.0f)
                curveTo(350.9f, 312.0f, 376.0f, 286.9f, 376.0f, 256.0f)
                curveTo(376.0f, 225.1f, 350.9f, 200.0f, 320.0f, 200.0f)
                curveTo(289.1f, 200.0f, 264.0f, 225.1f, 264.0f, 256.0f)
                curveTo(264.0f, 286.9f, 289.1f, 312.0f, 320.0f, 312.0f)
                close()
            }
        }
        .build()
        return `_image-portrait`!!
    }

private var `_image-portrait`: ImageVector? = null
