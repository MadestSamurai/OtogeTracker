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

public val Fa.`House-chimney-user`: ImageVector
    get() {
        if (`_house-chimney-user` != null) {
            return `_house-chimney-user`!!
        }
        `_house-chimney-user` = Builder(name = "House-chimney-user", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(298.2f, 72.6f)
                curveTo(310.5f, 61.2f, 329.5f, 61.2f, 341.7f, 72.6f)
                lineTo(432.0f, 156.3f)
                lineTo(432.0f, 144.0f)
                curveTo(432.0f, 126.3f, 446.3f, 112.0f, 464.0f, 112.0f)
                lineTo(496.0f, 112.0f)
                curveTo(513.7f, 112.0f, 528.0f, 126.3f, 528.0f, 144.0f)
                lineTo(528.0f, 245.5f)
                lineTo(565.8f, 280.6f)
                curveTo(575.4f, 289.6f, 578.6f, 303.5f, 573.8f, 315.7f)
                curveTo(569.0f, 327.9f, 557.2f, 336.0f, 544.0f, 336.0f)
                lineTo(528.0f, 336.0f)
                lineTo(528.0f, 512.0f)
                curveTo(528.0f, 547.3f, 499.3f, 576.0f, 464.0f, 576.0f)
                lineTo(176.0f, 576.0f)
                curveTo(140.7f, 576.0f, 112.0f, 547.3f, 112.0f, 512.0f)
                lineTo(112.0f, 336.0f)
                lineTo(96.0f, 336.0f)
                curveTo(82.8f, 336.0f, 71.0f, 327.9f, 66.2f, 315.7f)
                curveTo(61.4f, 303.5f, 64.6f, 289.5f, 74.2f, 280.6f)
                lineTo(298.2f, 72.6f)
                close()
                moveTo(376.0f, 320.0f)
                curveTo(376.0f, 289.1f, 350.9f, 264.0f, 320.0f, 264.0f)
                curveTo(289.1f, 264.0f, 264.0f, 289.1f, 264.0f, 320.0f)
                curveTo(264.0f, 350.9f, 289.1f, 376.0f, 320.0f, 376.0f)
                curveTo(350.9f, 376.0f, 376.0f, 350.9f, 376.0f, 320.0f)
                close()
                moveTo(208.0f, 496.0f)
                curveTo(208.0f, 504.8f, 215.2f, 512.0f, 224.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(424.8f, 512.0f, 432.0f, 504.8f, 432.0f, 496.0f)
                curveTo(432.0f, 451.8f, 396.2f, 416.0f, 352.0f, 416.0f)
                lineTo(288.0f, 416.0f)
                curveTo(243.8f, 416.0f, 208.0f, 451.8f, 208.0f, 496.0f)
                close()
            }
        }
        .build()
        return `_house-chimney-user`!!
    }

private var `_house-chimney-user`: ImageVector? = null
