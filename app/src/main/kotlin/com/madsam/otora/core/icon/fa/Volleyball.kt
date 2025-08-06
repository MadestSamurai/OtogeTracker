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

public val Fa.Volleyball: ImageVector
    get() {
        if (_volleyball != null) {
            return _volleyball!!
        }
        _volleyball = Builder(name = "Volleyball", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 322.9f)
                curveTo(552.6f, 330.9f, 528.2f, 336.0f, 503.4f, 338.0f)
                curveTo(509.3f, 239.4f, 472.7f, 146.9f, 408.5f, 79.7f)
                curveTo(506.3f, 115.7f, 576.0f, 209.7f, 576.0f, 320.0f)
                curveTo(576.0f, 321.0f, 576.0f, 321.9f, 576.0f, 322.9f)
                close()
                moveTo(570.1f, 374.9f)
                curveTo(564.9f, 398.6f, 556.5f, 421.1f, 545.2f, 441.8f)
                curveTo(450.5f, 494.0f, 331.2f, 491.8f, 236.8f, 428.2f)
                curveTo(258.5f, 396.9f, 286.6f, 369.3f, 320.6f, 347.7f)
                curveTo(400.1f, 389.3f, 489.1f, 396.8f, 570.1f, 374.8f)
                close()
                moveTo(343.7f, 305.6f)
                curveTo(340.0f, 215.9f, 302.0f, 135.1f, 242.4f, 75.9f)
                curveTo(264.7f, 68.8f, 288.4f, 64.7f, 312.9f, 64.0f)
                curveTo(405.4f, 119.9f, 463.2f, 224.3f, 455.3f, 337.8f)
                curveTo(417.3f, 334.6f, 379.4f, 324.1f, 343.7f, 305.5f)
                close()
                moveTo(194.5f, 96.8f)
                curveTo(213.1f, 113.1f, 229.8f, 131.7f, 243.9f, 152.2f)
                curveTo(155.5f, 196.3f, 93.7f, 274.3f, 67.7f, 363.5f)
                curveTo(65.3f, 349.3f, 64.0f, 334.8f, 64.0f, 320.0f)
                curveTo(64.0f, 224.2f, 116.6f, 140.7f, 194.5f, 96.8f)
                close()
                moveTo(267.9f, 193.8f)
                curveTo(284.2f, 228.3f, 294.0f, 266.4f, 295.8f, 306.6f)
                curveTo(220.0f, 354.6f, 169.0f, 427.9f, 147.5f, 509.1f)
                curveTo(129.9f, 493.0f, 114.5f, 474.5f, 102.0f, 454.1f)
                curveTo(104.1f, 346.0f, 165.7f, 243.7f, 267.9f, 193.8f)
                close()
                moveTo(320.0f, 576.0f)
                curveTo(272.3f, 576.0f, 227.7f, 563.0f, 189.5f, 540.3f)
                curveTo(194.3f, 516.0f, 202.1f, 492.3f, 212.7f, 469.9f)
                curveTo(295.1f, 524.3f, 393.5f, 538.8f, 483.7f, 516.9f)
                curveTo(439.3f, 553.9f, 382.2f, 576.1f, 320.0f, 576.1f)
                close()
            }
        }
        .build()
        return _volleyball!!
    }

private var _volleyball: ImageVector? = null
