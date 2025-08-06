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

public val Fa.Subscript: ImageVector
    get() {
        if (_subscript != null) {
            return _subscript!!
        }
        _subscript = Builder(name = "Subscript", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(110.3f, 128.0f, 96.0f, 142.3f, 96.0f, 160.0f)
                curveTo(96.0f, 177.7f, 110.3f, 192.0f, 128.0f, 192.0f)
                lineTo(143.3f, 192.0f)
                lineTo(232.9f, 320.0f)
                lineTo(143.3f, 448.0f)
                lineTo(128.0f, 448.0f)
                curveTo(110.3f, 448.0f, 96.0f, 462.3f, 96.0f, 480.0f)
                curveTo(96.0f, 497.7f, 110.3f, 512.0f, 128.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                curveTo(170.4f, 512.0f, 180.2f, 506.9f, 186.2f, 498.4f)
                lineTo(272.0f, 375.8f)
                lineTo(357.8f, 498.4f)
                curveTo(363.8f, 507.0f, 373.6f, 512.0f, 384.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                curveTo(433.7f, 512.0f, 448.0f, 497.7f, 448.0f, 480.0f)
                curveTo(448.0f, 462.3f, 433.7f, 448.0f, 416.0f, 448.0f)
                lineTo(400.7f, 448.0f)
                lineTo(311.1f, 320.0f)
                lineTo(400.7f, 192.0f)
                lineTo(416.0f, 192.0f)
                curveTo(433.7f, 192.0f, 448.0f, 177.7f, 448.0f, 160.0f)
                curveTo(448.0f, 142.3f, 433.7f, 128.0f, 416.0f, 128.0f)
                lineTo(384.0f, 128.0f)
                curveTo(373.6f, 128.0f, 363.8f, 133.1f, 357.8f, 141.6f)
                lineTo(272.0f, 264.2f)
                lineTo(186.2f, 141.6f)
                curveTo(180.2f, 133.1f, 170.4f, 128.0f, 160.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(576.0f, 384.0f)
                curveTo(576.0f, 372.9f, 570.3f, 362.6f, 560.8f, 356.8f)
                curveTo(551.3f, 351.0f, 539.6f, 350.4f, 529.7f, 355.4f)
                lineTo(497.7f, 371.4f)
                curveTo(481.9f, 379.3f, 475.5f, 398.5f, 483.4f, 414.3f)
                curveTo(489.0f, 425.5f, 500.3f, 432.0f, 512.0f, 432.0f)
                lineTo(512.0f, 512.0f)
                curveTo(494.3f, 512.0f, 480.0f, 526.3f, 480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 494.3f, 576.0f, 512.0f, 576.0f)
                lineTo(576.0f, 576.0f)
                curveTo(593.7f, 576.0f, 608.0f, 561.7f, 608.0f, 544.0f)
                curveTo(608.0f, 526.3f, 593.7f, 512.0f, 576.0f, 512.0f)
                lineTo(576.0f, 384.0f)
                close()
            }
        }
        .build()
        return _subscript!!
    }

private var _subscript: ImageVector? = null
