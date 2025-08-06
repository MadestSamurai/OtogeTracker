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

public val Fa.Umbrella: ImageVector
    get() {
        if (_umbrella != null) {
            return _umbrella!!
        }
        _umbrella = Builder(name = "Umbrella", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(337.7f, 32.0f, 352.0f, 46.3f, 352.0f, 64.0f)
                lineTo(352.0f, 66.0f)
                curveTo(478.3f, 81.7f, 576.0f, 189.5f, 576.0f, 320.0f)
                curveTo(576.0f, 323.8f, 575.9f, 327.5f, 575.8f, 331.3f)
                curveTo(575.5f, 338.2f, 570.8f, 344.1f, 564.1f, 346.0f)
                curveTo(557.4f, 347.9f, 550.3f, 345.3f, 546.5f, 339.5f)
                curveTo(532.1f, 318.1f, 507.7f, 304.0f, 480.0f, 304.0f)
                curveTo(450.7f, 304.0f, 425.1f, 319.7f, 411.1f, 343.3f)
                curveTo(408.4f, 347.9f, 403.5f, 350.9f, 398.1f, 351.1f)
                curveTo(392.7f, 351.3f, 387.6f, 348.9f, 384.4f, 344.6f)
                curveTo(369.8f, 324.8f, 346.4f, 312.0f, 319.9f, 312.0f)
                curveTo(293.4f, 312.0f, 270.0f, 324.8f, 255.4f, 344.6f)
                curveTo(252.2f, 348.9f, 247.1f, 351.4f, 241.7f, 351.1f)
                curveTo(236.3f, 350.8f, 231.5f, 347.9f, 228.7f, 343.3f)
                curveTo(214.7f, 319.7f, 189.1f, 304.0f, 159.8f, 304.0f)
                curveTo(132.1f, 304.0f, 107.7f, 318.1f, 93.3f, 339.5f)
                curveTo(89.4f, 345.2f, 82.3f, 347.9f, 75.7f, 346.0f)
                curveTo(69.1f, 344.1f, 64.5f, 338.2f, 64.2f, 331.3f)
                curveTo(64.1f, 327.5f, 64.0f, 323.8f, 64.0f, 320.0f)
                curveTo(64.0f, 189.5f, 161.7f, 81.7f, 288.0f, 66.0f)
                lineTo(288.0f, 64.0f)
                curveTo(288.0f, 46.3f, 302.3f, 32.0f, 320.0f, 32.0f)
                close()
                moveTo(352.0f, 392.0f)
                lineTo(352.0f, 494.6f)
                curveTo(352.0f, 539.6f, 315.5f, 576.0f, 270.6f, 576.0f)
                curveTo(239.8f, 576.0f, 211.6f, 558.6f, 197.8f, 531.0f)
                lineTo(195.5f, 526.3f)
                curveTo(187.6f, 510.5f, 194.0f, 491.3f, 209.8f, 483.4f)
                curveTo(225.6f, 475.5f, 244.8f, 481.9f, 252.7f, 497.7f)
                lineTo(255.0f, 502.4f)
                curveTo(258.0f, 508.3f, 264.0f, 512.0f, 270.6f, 512.0f)
                curveTo(280.2f, 512.0f, 288.0f, 504.2f, 288.0f, 494.6f)
                lineTo(288.0f, 392.0f)
                curveTo(288.0f, 374.3f, 302.3f, 360.0f, 320.0f, 360.0f)
                curveTo(337.7f, 360.0f, 352.0f, 374.3f, 352.0f, 392.0f)
                close()
            }
        }
        .build()
        return _umbrella!!
    }

private var _umbrella: ImageVector? = null
