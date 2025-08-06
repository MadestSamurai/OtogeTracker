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

public val Fa.Skull: ImageVector
    get() {
        if (_skull != null) {
            return _skull!!
        }
        _skull = Builder(name = "Skull", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 491.4f)
                curveTo(538.5f, 447.4f, 576.0f, 379.8f, 576.0f, 304.0f)
                curveTo(576.0f, 171.5f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 171.5f, 64.0f, 304.0f)
                curveTo(64.0f, 379.8f, 101.5f, 447.4f, 160.0f, 491.4f)
                lineTo(160.0f, 528.0f)
                curveTo(160.0f, 554.5f, 181.5f, 576.0f, 208.0f, 576.0f)
                lineTo(240.0f, 576.0f)
                lineTo(240.0f, 536.0f)
                curveTo(240.0f, 522.7f, 250.7f, 512.0f, 264.0f, 512.0f)
                curveTo(277.3f, 512.0f, 288.0f, 522.7f, 288.0f, 536.0f)
                lineTo(288.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                lineTo(352.0f, 536.0f)
                curveTo(352.0f, 522.7f, 362.7f, 512.0f, 376.0f, 512.0f)
                curveTo(389.3f, 512.0f, 400.0f, 522.7f, 400.0f, 536.0f)
                lineTo(400.0f, 576.0f)
                lineTo(432.0f, 576.0f)
                curveTo(458.5f, 576.0f, 480.0f, 554.5f, 480.0f, 528.0f)
                lineTo(480.0f, 491.4f)
                close()
                moveTo(160.0f, 320.0f)
                curveTo(160.0f, 284.7f, 188.7f, 256.0f, 224.0f, 256.0f)
                curveTo(259.3f, 256.0f, 288.0f, 284.7f, 288.0f, 320.0f)
                curveTo(288.0f, 355.3f, 259.3f, 384.0f, 224.0f, 384.0f)
                curveTo(188.7f, 384.0f, 160.0f, 355.3f, 160.0f, 320.0f)
                close()
                moveTo(416.0f, 256.0f)
                curveTo(451.3f, 256.0f, 480.0f, 284.7f, 480.0f, 320.0f)
                curveTo(480.0f, 355.3f, 451.3f, 384.0f, 416.0f, 384.0f)
                curveTo(380.7f, 384.0f, 352.0f, 355.3f, 352.0f, 320.0f)
                curveTo(352.0f, 284.7f, 380.7f, 256.0f, 416.0f, 256.0f)
                close()
            }
        }
        .build()
        return _skull!!
    }

private var _skull: ImageVector? = null
