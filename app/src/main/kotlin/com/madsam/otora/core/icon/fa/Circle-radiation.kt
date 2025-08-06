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

public val Fa.`Circle-radiation`: ImageVector
    get() {
        if (`_circle-radiation` != null) {
            return `_circle-radiation`!!
        }
        `_circle-radiation` = Builder(name = "Circle-radiation", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(144.0f, 320.0f)
                lineTo(208.3f, 320.0f)
                curveTo(217.0f, 320.0f, 224.0f, 312.9f, 225.6f, 304.4f)
                curveTo(230.0f, 280.0f, 243.7f, 258.9f, 262.8f, 244.7f)
                curveTo(270.2f, 239.2f, 273.4f, 229.1f, 268.8f, 221.1f)
                lineTo(236.3f, 164.8f)
                curveTo(232.0f, 157.3f, 222.4f, 154.5f, 215.1f, 159.3f)
                curveTo(166.9f, 190.8f, 133.8f, 243.5f, 128.8f, 304.1f)
                curveTo(128.1f, 312.9f, 135.3f, 320.1f, 144.1f, 320.1f)
                close()
                moveTo(281.9f, 409.8f)
                curveTo(273.4f, 406.1f, 263.1f, 408.4f, 258.4f, 416.4f)
                lineTo(227.4f, 470.2f)
                curveTo(223.1f, 477.7f, 225.5f, 487.4f, 233.2f, 491.3f)
                curveTo(259.3f, 504.5f, 288.7f, 512.0f, 320.0f, 512.0f)
                curveTo(351.3f, 512.0f, 380.7f, 504.5f, 406.8f, 491.3f)
                curveTo(414.5f, 487.4f, 416.9f, 477.7f, 412.6f, 470.2f)
                lineTo(381.6f, 416.4f)
                curveTo(377.0f, 408.4f, 366.6f, 406.1f, 358.1f, 409.8f)
                curveTo(346.4f, 414.8f, 333.6f, 417.6f, 320.0f, 417.6f)
                curveTo(306.4f, 417.6f, 293.6f, 414.8f, 281.9f, 409.8f)
                close()
                moveTo(414.4f, 304.4f)
                curveTo(416.0f, 313.0f, 422.9f, 320.0f, 431.7f, 320.0f)
                lineTo(496.0f, 320.0f)
                curveTo(504.8f, 320.0f, 512.1f, 312.8f, 511.3f, 304.0f)
                curveTo(506.3f, 243.4f, 473.2f, 190.8f, 425.0f, 159.2f)
                curveTo(417.7f, 154.4f, 408.2f, 157.2f, 403.8f, 164.7f)
                lineTo(371.3f, 221.0f)
                curveTo(366.7f, 229.0f, 369.9f, 239.1f, 377.3f, 244.6f)
                curveTo(396.4f, 258.8f, 410.0f, 280.0f, 414.5f, 304.3f)
                close()
                moveTo(320.0f, 369.7f)
                curveTo(346.5f, 369.7f, 368.0f, 348.2f, 368.0f, 321.7f)
                curveTo(368.0f, 295.2f, 346.5f, 273.7f, 320.0f, 273.7f)
                curveTo(293.5f, 273.7f, 272.0f, 295.2f, 272.0f, 321.7f)
                curveTo(272.0f, 348.2f, 293.5f, 369.7f, 320.0f, 369.7f)
                close()
            }
        }
        .build()
        return `_circle-radiation`!!
    }

private var `_circle-radiation`: ImageVector? = null
