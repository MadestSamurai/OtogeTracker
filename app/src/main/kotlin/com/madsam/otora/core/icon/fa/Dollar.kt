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

public val Fa.Dollar: ImageVector
    get() {
        if (_dollar != null) {
            return _dollar!!
        }
        _dollar = Builder(name = "Dollar", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.0f, 88.0f)
                curveTo(296.0f, 74.7f, 306.7f, 64.0f, 320.0f, 64.0f)
                curveTo(333.3f, 64.0f, 344.0f, 74.7f, 344.0f, 88.0f)
                lineTo(344.0f, 128.0f)
                lineTo(400.0f, 128.0f)
                curveTo(417.7f, 128.0f, 432.0f, 142.3f, 432.0f, 160.0f)
                curveTo(432.0f, 177.7f, 417.7f, 192.0f, 400.0f, 192.0f)
                lineTo(285.1f, 192.0f)
                curveTo(260.2f, 192.0f, 240.0f, 212.2f, 240.0f, 237.1f)
                curveTo(240.0f, 259.6f, 256.5f, 278.6f, 278.7f, 281.8f)
                lineTo(370.3f, 294.9f)
                curveTo(424.1f, 302.6f, 464.0f, 348.6f, 464.0f, 402.9f)
                curveTo(464.0f, 463.2f, 415.1f, 512.0f, 354.9f, 512.0f)
                lineTo(344.0f, 512.0f)
                lineTo(344.0f, 552.0f)
                curveTo(344.0f, 565.3f, 333.3f, 576.0f, 320.0f, 576.0f)
                curveTo(306.7f, 576.0f, 296.0f, 565.3f, 296.0f, 552.0f)
                lineTo(296.0f, 512.0f)
                lineTo(224.0f, 512.0f)
                curveTo(206.3f, 512.0f, 192.0f, 497.7f, 192.0f, 480.0f)
                curveTo(192.0f, 462.3f, 206.3f, 448.0f, 224.0f, 448.0f)
                lineTo(354.9f, 448.0f)
                curveTo(379.8f, 448.0f, 400.0f, 427.8f, 400.0f, 402.9f)
                curveTo(400.0f, 380.4f, 383.5f, 361.4f, 361.3f, 358.2f)
                lineTo(269.7f, 345.1f)
                curveTo(215.9f, 337.5f, 176.0f, 291.4f, 176.0f, 237.1f)
                curveTo(176.0f, 176.9f, 224.9f, 128.0f, 285.1f, 128.0f)
                lineTo(296.0f, 128.0f)
                lineTo(296.0f, 88.0f)
                close()
            }
        }
        .build()
        return _dollar!!
    }

private var _dollar: ImageVector? = null
