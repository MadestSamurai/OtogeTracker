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

public val Fa.`Sim-card`: ImageVector
    get() {
        if (`_sim-card` != null) {
            return `_sim-card`!!
        }
        `_sim-card` = Builder(name = "Sim-card", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(386.7f, 64.0f)
                curveTo(403.7f, 64.0f, 420.0f, 70.7f, 432.0f, 82.7f)
                lineTo(493.3f, 144.0f)
                curveTo(505.3f, 156.0f, 512.0f, 172.3f, 512.0f, 189.3f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(224.0f, 320.0f)
                curveTo(206.3f, 320.0f, 192.0f, 334.3f, 192.0f, 352.0f)
                lineTo(192.0f, 392.0f)
                lineTo(320.0f, 392.0f)
                lineTo(320.0f, 320.0f)
                lineTo(224.0f, 320.0f)
                close()
                moveTo(192.0f, 480.0f)
                curveTo(192.0f, 497.7f, 206.3f, 512.0f, 224.0f, 512.0f)
                lineTo(272.0f, 512.0f)
                lineTo(272.0f, 440.0f)
                lineTo(192.0f, 440.0f)
                lineTo(192.0f, 480.0f)
                close()
                moveTo(448.0f, 480.0f)
                lineTo(448.0f, 440.0f)
                lineTo(320.0f, 440.0f)
                lineTo(320.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(433.7f, 512.0f, 448.0f, 497.7f, 448.0f, 480.0f)
                close()
                moveTo(448.0f, 352.0f)
                curveTo(448.0f, 334.3f, 433.7f, 320.0f, 416.0f, 320.0f)
                lineTo(368.0f, 320.0f)
                lineTo(368.0f, 392.0f)
                lineTo(448.0f, 392.0f)
                lineTo(448.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_sim-card`!!
    }

private var `_sim-card`: ImageVector? = null
