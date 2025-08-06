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

public val Fa.Feather: ImageVector
    get() {
        if (_feather != null) {
            return _feather!!
        }
        _feather = Builder(name = "Feather", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 64.0f)
                curveTo(457.0f, 64.0f, 496.3f, 80.3f, 525.2f, 109.2f)
                lineTo(530.7f, 114.7f)
                curveTo(559.7f, 143.7f, 576.0f, 183.0f, 576.0f, 223.9f)
                curveTo(576.0f, 248.0f, 570.3f, 271.5f, 559.8f, 292.7f)
                curveTo(557.9f, 296.4f, 554.5f, 299.2f, 550.5f, 300.4f)
                lineTo(438.5f, 334.0f)
                curveTo(434.6f, 335.2f, 432.0f, 338.7f, 432.0f, 342.8f)
                curveTo(432.0f, 347.9f, 436.1f, 352.0f, 441.2f, 352.0f)
                lineTo(473.4f, 352.0f)
                curveTo(487.7f, 352.0f, 494.8f, 369.2f, 484.7f, 379.3f)
                lineTo(462.3f, 401.7f)
                curveTo(460.4f, 403.6f, 458.1f, 404.9f, 455.6f, 405.7f)
                lineTo(374.6f, 430.0f)
                curveTo(370.7f, 431.2f, 368.1f, 434.7f, 368.1f, 438.8f)
                curveTo(368.1f, 443.9f, 372.2f, 448.0f, 377.3f, 448.0f)
                curveTo(390.5f, 448.0f, 396.2f, 463.7f, 385.1f, 470.9f)
                curveTo(344.0f, 497.5f, 295.8f, 512.0f, 246.1f, 512.0f)
                lineTo(160.1f, 512.0f)
                lineTo(112.1f, 560.0f)
                curveTo(103.3f, 568.8f, 88.9f, 568.8f, 80.1f, 560.0f)
                curveTo(71.3f, 551.2f, 71.3f, 536.8f, 80.1f, 528.0f)
                lineTo(320.0f, 288.0f)
                curveTo(328.8f, 279.2f, 328.8f, 264.8f, 320.0f, 256.0f)
                curveTo(311.2f, 247.2f, 296.8f, 247.2f, 288.0f, 256.0f)
                lineTo(143.5f, 400.5f)
                curveTo(137.8f, 406.2f, 128.0f, 402.2f, 128.0f, 394.1f)
                curveTo(128.0f, 326.2f, 155.0f, 261.1f, 203.0f, 213.1f)
                lineTo(306.8f, 109.2f)
                curveTo(335.7f, 80.3f, 375.0f, 64.0f, 416.0f, 64.0f)
                close()
            }
        }
        .build()
        return _feather!!
    }

private var _feather: ImageVector? = null
