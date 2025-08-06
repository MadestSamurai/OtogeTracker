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

public val Fa.Automobile: ImageVector
    get() {
        if (_automobile != null) {
            return _automobile!!
        }
        _automobile = Builder(name = "Automobile", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(199.2f, 181.4f)
                lineTo(173.1f, 256.0f)
                lineTo(466.9f, 256.0f)
                lineTo(440.8f, 181.4f)
                curveTo(436.3f, 168.6f, 424.2f, 160.0f, 410.6f, 160.0f)
                lineTo(229.4f, 160.0f)
                curveTo(215.8f, 160.0f, 203.7f, 168.6f, 199.2f, 181.4f)
                close()
                moveTo(103.6f, 260.8f)
                lineTo(138.8f, 160.3f)
                curveTo(152.3f, 121.8f, 188.6f, 96.0f, 229.4f, 96.0f)
                lineTo(410.6f, 96.0f)
                curveTo(451.4f, 96.0f, 487.7f, 121.8f, 501.2f, 160.3f)
                lineTo(536.4f, 260.8f)
                curveTo(559.6f, 270.4f, 576.0f, 293.3f, 576.0f, 320.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(494.3f, 544.0f, 480.0f, 529.7f, 480.0f, 512.0f)
                lineTo(480.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 145.7f, 544.0f, 128.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 320.0f)
                curveTo(64.0f, 293.3f, 80.4f, 270.4f, 103.6f, 260.8f)
                close()
                moveTo(192.0f, 368.0f)
                curveTo(192.0f, 350.3f, 177.7f, 336.0f, 160.0f, 336.0f)
                curveTo(142.3f, 336.0f, 128.0f, 350.3f, 128.0f, 368.0f)
                curveTo(128.0f, 385.7f, 142.3f, 400.0f, 160.0f, 400.0f)
                curveTo(177.7f, 400.0f, 192.0f, 385.7f, 192.0f, 368.0f)
                close()
                moveTo(480.0f, 400.0f)
                curveTo(497.7f, 400.0f, 512.0f, 385.7f, 512.0f, 368.0f)
                curveTo(512.0f, 350.3f, 497.7f, 336.0f, 480.0f, 336.0f)
                curveTo(462.3f, 336.0f, 448.0f, 350.3f, 448.0f, 368.0f)
                curveTo(448.0f, 385.7f, 462.3f, 400.0f, 480.0f, 400.0f)
                close()
            }
        }
        .build()
        return _automobile!!
    }

private var _automobile: ImageVector? = null
