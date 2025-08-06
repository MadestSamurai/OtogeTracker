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

public val Fa.Volcano: ImageVector
    get() {
        if (_volcano != null) {
            return _volcano!!
        }
        _volcano = Builder(name = "Volcano", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 208.0f)
                curveTo(188.7f, 208.0f, 160.0f, 179.3f, 160.0f, 144.0f)
                curveTo(160.0f, 108.7f, 188.7f, 80.0f, 224.0f, 80.0f)
                curveTo(239.7f, 80.0f, 254.0f, 85.6f, 265.2f, 95.0f)
                curveTo(276.4f, 76.4f, 296.8f, 64.0f, 320.0f, 64.0f)
                curveTo(343.2f, 64.0f, 363.6f, 76.4f, 374.8f, 95.0f)
                curveTo(385.9f, 85.6f, 400.3f, 80.0f, 416.0f, 80.0f)
                curveTo(451.3f, 80.0f, 480.0f, 108.7f, 480.0f, 144.0f)
                curveTo(480.0f, 179.3f, 451.3f, 208.0f, 416.0f, 208.0f)
                curveTo(401.3f, 208.0f, 387.7f, 203.0f, 376.9f, 194.7f)
                lineTo(344.9f, 242.7f)
                curveTo(339.3f, 251.0f, 330.0f, 256.0f, 320.0f, 256.0f)
                curveTo(310.0f, 256.0f, 300.7f, 251.0f, 295.1f, 242.7f)
                lineTo(263.1f, 194.7f)
                curveTo(252.3f, 203.0f, 238.7f, 208.0f, 224.0f, 208.0f)
                close()
                moveTo(208.0f, 416.0f)
                lineTo(256.4f, 391.8f)
                curveTo(266.6f, 386.7f, 278.0f, 384.0f, 289.4f, 384.0f)
                curveTo(309.0f, 384.0f, 327.8f, 391.8f, 341.6f, 405.6f)
                lineTo(374.1f, 438.1f)
                curveTo(380.4f, 444.4f, 389.0f, 448.0f, 397.9f, 448.0f)
                curveTo(409.2f, 448.0f, 419.7f, 442.4f, 425.9f, 433.0f)
                lineTo(435.6f, 418.4f)
                lineTo(376.6f, 352.1f)
                curveTo(367.5f, 341.9f, 354.4f, 336.0f, 340.7f, 336.0f)
                lineTo(298.9f, 336.0f)
                curveTo(285.2f, 336.0f, 272.1f, 341.9f, 263.0f, 352.1f)
                lineTo(203.1f, 419.5f)
                lineTo(207.8f, 416.0f)
                close()
                moveTo(227.4f, 320.2f)
                curveTo(245.6f, 299.7f, 271.7f, 288.0f, 299.2f, 288.0f)
                lineTo(341.0f, 288.0f)
                curveTo(368.4f, 288.0f, 394.5f, 299.7f, 412.8f, 320.2f)
                lineTo(563.0f, 489.2f)
                curveTo(571.5f, 498.7f, 576.2f, 511.1f, 576.2f, 523.9f)
                curveTo(576.2f, 552.7f, 552.8f, 576.1f, 524.0f, 576.1f)
                lineTo(116.2f, 576.0f)
                curveTo(87.4f, 576.0f, 64.0f, 552.6f, 64.0f, 523.8f)
                curveTo(64.0f, 511.1f, 68.7f, 498.7f, 77.2f, 489.2f)
                lineTo(227.4f, 320.2f)
                close()
            }
        }
        .build()
        return _volcano!!
    }

private var _volcano: ImageVector? = null
