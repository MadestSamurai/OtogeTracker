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

public val Fa.Cubes: ImageVector
    get() {
        if (_cubes != null) {
            return _cubes!!
        }
        _cubes = Builder(name = "Cubes", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(348.0f, 62.7f)
                curveTo(330.7f, 52.7f, 309.3f, 52.7f, 292.0f, 62.7f)
                lineTo(207.8f, 111.3f)
                curveTo(190.5f, 121.3f, 179.8f, 139.8f, 179.8f, 159.8f)
                lineTo(179.8f, 261.7f)
                lineTo(91.5f, 312.7f)
                curveTo(74.2f, 322.7f, 63.5f, 341.2f, 63.5f, 361.2f)
                lineTo(63.5f, 458.5f)
                curveTo(63.5f, 478.5f, 74.2f, 497.0f, 91.5f, 507.0f)
                lineTo(175.8f, 555.6f)
                curveTo(193.1f, 565.6f, 214.5f, 565.6f, 231.8f, 555.6f)
                lineTo(320.1f, 504.6f)
                lineTo(408.4f, 555.6f)
                curveTo(425.7f, 565.6f, 447.1f, 565.6f, 464.4f, 555.6f)
                lineTo(548.5f, 507.0f)
                curveTo(565.8f, 497.0f, 576.5f, 478.5f, 576.5f, 458.5f)
                lineTo(576.5f, 361.2f)
                curveTo(576.5f, 341.2f, 565.8f, 322.7f, 548.5f, 312.7f)
                lineTo(460.2f, 261.7f)
                lineTo(460.2f, 159.8f)
                curveTo(460.2f, 139.8f, 449.5f, 121.3f, 432.2f, 111.3f)
                lineTo(348.0f, 62.7f)
                close()
                moveTo(296.0f, 356.6f)
                lineTo(296.0f, 463.1f)
                lineTo(207.7f, 514.1f)
                curveTo(206.5f, 514.8f, 205.1f, 515.2f, 203.7f, 515.2f)
                lineTo(203.7f, 409.9f)
                lineTo(296.0f, 356.6f)
                close()
                moveTo(527.4f, 357.2f)
                curveTo(528.1f, 358.4f, 528.5f, 359.8f, 528.5f, 361.2f)
                lineTo(528.5f, 458.5f)
                curveTo(528.5f, 461.4f, 527.0f, 464.0f, 524.5f, 465.4f)
                lineTo(440.2f, 514.0f)
                curveTo(439.0f, 514.7f, 437.6f, 515.1f, 436.2f, 515.1f)
                lineTo(436.2f, 409.8f)
                lineTo(527.4f, 357.2f)
                close()
                moveTo(412.3f, 159.8f)
                lineTo(412.3f, 261.7f)
                lineTo(320.0f, 315.0f)
                lineTo(320.0f, 208.5f)
                lineTo(411.2f, 155.9f)
                curveTo(411.9f, 157.1f, 412.3f, 158.5f, 412.3f, 159.9f)
                close()
            }
        }
        .build()
        return _cubes!!
    }

private var _cubes: ImageVector? = null
