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

public val Fa.Donate: ImageVector
    get() {
        if (_donate != null) {
            return _donate!!
        }
        _donate = Builder(name = "Donate", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 288.0f)
                curveTo(128.0f, 182.0f, 214.0f, 96.0f, 320.0f, 96.0f)
                curveTo(426.0f, 96.0f, 512.0f, 182.0f, 512.0f, 288.0f)
                curveTo(512.0f, 394.0f, 426.0f, 480.0f, 320.0f, 480.0f)
                curveTo(214.0f, 480.0f, 128.0f, 394.0f, 128.0f, 288.0f)
                close()
                moveTo(304.0f, 196.0f)
                lineTo(304.0f, 200.0f)
                curveTo(275.2f, 200.3f, 252.0f, 223.7f, 252.0f, 252.5f)
                curveTo(252.0f, 278.2f, 270.5f, 300.1f, 295.9f, 304.3f)
                lineTo(337.6f, 311.3f)
                curveTo(343.6f, 312.3f, 348.0f, 317.5f, 348.0f, 323.6f)
                curveTo(348.0f, 330.5f, 342.4f, 336.1f, 335.5f, 336.1f)
                lineTo(280.0f, 336.0f)
                curveTo(269.0f, 336.0f, 260.0f, 345.0f, 260.0f, 356.0f)
                curveTo(260.0f, 367.0f, 269.0f, 376.0f, 280.0f, 376.0f)
                lineTo(304.0f, 376.0f)
                lineTo(304.0f, 380.0f)
                curveTo(304.0f, 391.0f, 313.0f, 400.0f, 324.0f, 400.0f)
                curveTo(335.0f, 400.0f, 344.0f, 391.0f, 344.0f, 380.0f)
                lineTo(344.0f, 375.3f)
                curveTo(369.0f, 371.2f, 388.0f, 349.6f, 388.0f, 323.5f)
                curveTo(388.0f, 297.8f, 369.5f, 275.9f, 344.1f, 271.7f)
                lineTo(302.4f, 264.7f)
                curveTo(296.4f, 263.7f, 292.0f, 258.5f, 292.0f, 252.4f)
                curveTo(292.0f, 245.5f, 297.6f, 239.9f, 304.5f, 239.9f)
                lineTo(352.0f, 239.9f)
                curveTo(363.0f, 239.9f, 372.0f, 230.9f, 372.0f, 219.9f)
                curveTo(372.0f, 208.9f, 363.0f, 199.9f, 352.0f, 199.9f)
                lineTo(344.0f, 199.9f)
                lineTo(344.0f, 195.9f)
                curveTo(344.0f, 184.9f, 335.0f, 175.9f, 324.0f, 175.9f)
                curveTo(313.0f, 175.9f, 304.0f, 184.9f, 304.0f, 195.9f)
                close()
                moveTo(80.0f, 408.0f)
                lineTo(80.0f, 512.0f)
                curveTo(80.0f, 520.8f, 87.2f, 528.0f, 96.0f, 528.0f)
                lineTo(544.0f, 528.0f)
                curveTo(552.8f, 528.0f, 560.0f, 520.8f, 560.0f, 512.0f)
                lineTo(560.0f, 408.0f)
                curveTo(560.0f, 394.7f, 570.7f, 384.0f, 584.0f, 384.0f)
                curveTo(597.3f, 384.0f, 608.0f, 394.7f, 608.0f, 408.0f)
                lineTo(608.0f, 512.0f)
                curveTo(608.0f, 547.3f, 579.3f, 576.0f, 544.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                curveTo(60.7f, 576.0f, 32.0f, 547.3f, 32.0f, 512.0f)
                lineTo(32.0f, 408.0f)
                curveTo(32.0f, 394.7f, 42.7f, 384.0f, 56.0f, 384.0f)
                curveTo(69.3f, 384.0f, 80.0f, 394.7f, 80.0f, 408.0f)
                close()
            }
        }
        .build()
        return _donate!!
    }

private var _donate: ImageVector? = null
