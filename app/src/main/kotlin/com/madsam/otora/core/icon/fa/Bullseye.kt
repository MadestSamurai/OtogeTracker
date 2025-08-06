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

public val Fa.Bullseye: ImageVector
    get() {
        if (_bullseye != null) {
            return _bullseye!!
        }
        _bullseye = Builder(name = "Bullseye", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(512.0f, 320.0f)
                curveTo(512.0f, 214.0f, 426.0f, 128.0f, 320.0f, 128.0f)
                curveTo(214.0f, 128.0f, 128.0f, 214.0f, 128.0f, 320.0f)
                curveTo(128.0f, 426.0f, 214.0f, 512.0f, 320.0f, 512.0f)
                curveTo(426.0f, 512.0f, 512.0f, 426.0f, 512.0f, 320.0f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(320.0f, 400.0f)
                curveTo(364.2f, 400.0f, 400.0f, 364.2f, 400.0f, 320.0f)
                curveTo(400.0f, 275.8f, 364.2f, 240.0f, 320.0f, 240.0f)
                curveTo(275.8f, 240.0f, 240.0f, 275.8f, 240.0f, 320.0f)
                curveTo(240.0f, 364.2f, 275.8f, 400.0f, 320.0f, 400.0f)
                close()
                moveTo(320.0f, 176.0f)
                curveTo(399.5f, 176.0f, 464.0f, 240.5f, 464.0f, 320.0f)
                curveTo(464.0f, 399.5f, 399.5f, 464.0f, 320.0f, 464.0f)
                curveTo(240.5f, 464.0f, 176.0f, 399.5f, 176.0f, 320.0f)
                curveTo(176.0f, 240.5f, 240.5f, 176.0f, 320.0f, 176.0f)
                close()
                moveTo(288.0f, 320.0f)
                curveTo(288.0f, 302.3f, 302.3f, 288.0f, 320.0f, 288.0f)
                curveTo(337.7f, 288.0f, 352.0f, 302.3f, 352.0f, 320.0f)
                curveTo(352.0f, 337.7f, 337.7f, 352.0f, 320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 337.7f, 288.0f, 320.0f)
                close()
            }
        }
        .build()
        return _bullseye!!
    }

private var _bullseye: ImageVector? = null
