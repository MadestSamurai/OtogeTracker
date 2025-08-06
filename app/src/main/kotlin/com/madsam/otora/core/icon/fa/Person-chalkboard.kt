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

public val Fa.`Person-chalkboard`: ImageVector
    get() {
        if (`_person-chalkboard` != null) {
            return `_person-chalkboard`!!
        }
        `_person-chalkboard` = Builder(name = "Person-chalkboard", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 144.0f)
                curveTo(222.9f, 144.0f, 248.0f, 118.9f, 248.0f, 88.0f)
                curveTo(248.0f, 57.1f, 222.9f, 32.0f, 192.0f, 32.0f)
                curveTo(161.1f, 32.0f, 136.0f, 57.1f, 136.0f, 88.0f)
                curveTo(136.0f, 118.9f, 161.1f, 144.0f, 192.0f, 144.0f)
                close()
                moveTo(176.0f, 576.0f)
                lineTo(176.0f, 416.0f)
                curveTo(176.0f, 407.2f, 183.2f, 400.0f, 192.0f, 400.0f)
                curveTo(200.8f, 400.0f, 208.0f, 407.2f, 208.0f, 416.0f)
                lineTo(208.0f, 576.0f)
                curveTo(208.0f, 593.7f, 222.3f, 608.0f, 240.0f, 608.0f)
                curveTo(257.7f, 608.0f, 272.0f, 593.7f, 272.0f, 576.0f)
                lineTo(272.0f, 240.0f)
                lineTo(400.0f, 240.0f)
                curveTo(417.7f, 240.0f, 432.0f, 225.7f, 432.0f, 208.0f)
                curveTo(432.0f, 190.3f, 417.7f, 176.0f, 400.0f, 176.0f)
                lineTo(384.0f, 176.0f)
                lineTo(384.0f, 128.0f)
                lineTo(576.0f, 128.0f)
                lineTo(576.0f, 320.0f)
                lineTo(384.0f, 320.0f)
                lineTo(384.0f, 288.0f)
                lineTo(320.0f, 288.0f)
                lineTo(320.0f, 336.0f)
                curveTo(320.0f, 362.5f, 341.5f, 384.0f, 368.0f, 384.0f)
                lineTo(592.0f, 384.0f)
                curveTo(618.5f, 384.0f, 640.0f, 362.5f, 640.0f, 336.0f)
                lineTo(640.0f, 112.0f)
                curveTo(640.0f, 85.5f, 618.5f, 64.0f, 592.0f, 64.0f)
                lineTo(368.0f, 64.0f)
                curveTo(341.5f, 64.0f, 320.0f, 85.5f, 320.0f, 112.0f)
                lineTo(320.0f, 176.0f)
                lineTo(197.3f, 176.0f)
                curveTo(151.7f, 176.0f, 108.8f, 197.6f, 81.7f, 234.2f)
                lineTo(14.3f, 324.9f)
                curveTo(3.8f, 339.1f, 6.7f, 359.1f, 20.9f, 369.7f)
                curveTo(35.1f, 380.3f, 55.1f, 377.3f, 65.7f, 363.1f)
                lineTo(112.0f, 300.7f)
                lineTo(112.0f, 576.0f)
                curveTo(112.0f, 593.7f, 126.3f, 608.0f, 144.0f, 608.0f)
                curveTo(161.7f, 608.0f, 176.0f, 593.7f, 176.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_person-chalkboard`!!
    }

private var `_person-chalkboard`: ImageVector? = null
