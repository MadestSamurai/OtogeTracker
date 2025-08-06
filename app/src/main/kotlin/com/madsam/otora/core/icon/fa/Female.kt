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

public val Fa.Female: ImageVector
    get() {
        if (_female != null) {
            return _female!!
        }
        _female = Builder(name = "Female", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(264.0f, 88.0f)
                curveTo(264.0f, 57.1f, 289.1f, 32.0f, 320.0f, 32.0f)
                curveTo(350.9f, 32.0f, 376.0f, 57.1f, 376.0f, 88.0f)
                curveTo(376.0f, 118.9f, 350.9f, 144.0f, 320.0f, 144.0f)
                curveTo(289.1f, 144.0f, 264.0f, 118.9f, 264.0f, 88.0f)
                close()
                moveTo(240.0f, 448.0f)
                lineTo(214.2f, 448.0f)
                curveTo(203.3f, 448.0f, 195.6f, 437.3f, 199.0f, 426.9f)
                lineTo(242.0f, 297.9f)
                lineTo(193.7f, 363.0f)
                curveTo(183.2f, 377.2f, 163.1f, 380.2f, 148.9f, 369.6f)
                curveTo(134.7f, 359.0f, 131.7f, 339.0f, 142.3f, 324.8f)
                lineTo(212.8f, 229.8f)
                curveTo(238.0f, 196.0f, 277.7f, 176.0f, 320.0f, 176.0f)
                curveTo(362.3f, 176.0f, 402.0f, 196.0f, 427.2f, 229.9f)
                lineTo(497.7f, 324.9f)
                curveTo(508.2f, 339.1f, 505.3f, 359.1f, 491.1f, 369.7f)
                curveTo(476.9f, 380.3f, 456.9f, 377.3f, 446.3f, 363.1f)
                lineTo(398.0f, 298.0f)
                lineTo(441.0f, 426.9f)
                curveTo(444.5f, 437.3f, 436.7f, 448.0f, 425.8f, 448.0f)
                lineTo(400.0f, 448.0f)
                lineTo(400.0f, 576.0f)
                curveTo(400.0f, 593.7f, 385.7f, 608.0f, 368.0f, 608.0f)
                curveTo(350.3f, 608.0f, 336.0f, 593.7f, 336.0f, 576.0f)
                lineTo(336.0f, 448.0f)
                lineTo(304.0f, 448.0f)
                lineTo(304.0f, 576.0f)
                curveTo(304.0f, 593.7f, 289.7f, 608.0f, 272.0f, 608.0f)
                curveTo(254.3f, 608.0f, 240.0f, 593.7f, 240.0f, 576.0f)
                lineTo(240.0f, 448.0f)
                close()
            }
        }
        .build()
        return _female!!
    }

private var _female: ImageVector? = null
