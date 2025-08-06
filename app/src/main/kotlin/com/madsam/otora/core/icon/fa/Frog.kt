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

public val Fa.Frog: ImageVector
    get() {
        if (_frog != null) {
            return _frog!!
        }
        _frog = Builder(name = "Frog", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 96.0f)
                curveTo(441.7f, 96.0f, 475.9f, 127.8f, 479.7f, 168.5f)
                lineTo(565.3f, 194.8f)
                curveTo(590.7f, 202.6f, 608.1f, 226.1f, 608.1f, 252.7f)
                curveTo(608.1f, 274.5f, 596.4f, 294.6f, 577.4f, 305.4f)
                lineTo(432.9f, 387.5f)
                lineTo(525.4f, 480.0f)
                lineTo(576.1f, 480.0f)
                curveTo(593.8f, 480.0f, 608.1f, 494.3f, 608.1f, 512.0f)
                curveTo(608.1f, 529.7f, 593.8f, 544.0f, 576.1f, 544.0f)
                lineTo(512.1f, 544.0f)
                curveTo(503.6f, 544.0f, 495.5f, 540.6f, 489.5f, 534.6f)
                lineTo(378.9f, 424.2f)
                curveTo(390.6f, 388.2f, 382.1f, 347.1f, 353.5f, 318.5f)
                curveTo(312.9f, 277.9f, 247.2f, 277.9f, 206.6f, 318.4f)
                lineTo(133.0f, 388.4f)
                curveTo(126.6f, 394.5f, 126.3f, 404.6f, 132.4f, 411.0f)
                curveTo(138.5f, 417.4f, 148.6f, 417.6f, 155.0f, 411.6f)
                lineTo(228.8f, 341.4f)
                lineTo(228.9f, 341.3f)
                lineTo(229.0f, 341.2f)
                curveTo(232.5f, 337.7f, 236.3f, 334.6f, 240.3f, 332.0f)
                curveTo(268.2f, 313.5f, 306.2f, 316.6f, 330.8f, 341.2f)
                curveTo(355.5f, 365.9f, 358.5f, 404.1f, 339.8f, 432.1f)
                curveTo(337.2f, 435.9f, 334.2f, 439.6f, 330.8f, 443.0f)
                lineTo(293.8f, 480.0f)
                lineTo(384.0f, 480.0f)
                curveTo(401.7f, 480.0f, 416.0f, 494.3f, 416.0f, 512.0f)
                curveTo(416.0f, 529.7f, 401.7f, 544.0f, 384.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                curveTo(32.0f, 313.6f, 159.0f, 176.9f, 321.3f, 161.5f)
                curveTo(328.2f, 124.2f, 360.8f, 96.0f, 400.0f, 96.0f)
                close()
                moveTo(400.0f, 200.0f)
                curveTo(413.3f, 200.0f, 424.0f, 189.3f, 424.0f, 176.0f)
                curveTo(424.0f, 162.7f, 413.3f, 152.0f, 400.0f, 152.0f)
                curveTo(386.7f, 152.0f, 376.0f, 162.7f, 376.0f, 176.0f)
                curveTo(376.0f, 189.3f, 386.7f, 200.0f, 400.0f, 200.0f)
                close()
            }
        }
        .build()
        return _frog!!
    }

private var _frog: ImageVector? = null
