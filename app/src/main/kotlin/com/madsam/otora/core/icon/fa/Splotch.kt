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

public val Fa.Splotch: ImageVector
    get() {
        if (_splotch != null) {
            return _splotch!!
        }
        _splotch = Builder(name = "Splotch", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.5f, 126.3f)
                lineTo(300.6f, 89.4f)
                curveTo(312.8f, 73.4f, 331.8f, 64.0f, 352.0f, 64.0f)
                curveTo(380.5f, 64.0f, 405.6f, 82.7f, 413.8f, 110.0f)
                lineTo(431.6f, 169.4f)
                curveTo(441.9f, 203.8f, 467.7f, 231.4f, 501.4f, 244.0f)
                lineTo(541.2f, 258.9f)
                curveTo(562.1f, 266.8f, 576.0f, 286.8f, 576.0f, 309.1f)
                curveTo(576.0f, 326.0f, 568.1f, 341.9f, 554.5f, 352.0f)
                lineTo(487.2f, 402.5f)
                curveTo(462.9f, 420.7f, 450.0f, 450.4f, 453.4f, 480.6f)
                lineTo(455.9f, 503.3f)
                curveTo(460.2f, 542.0f, 429.9f, 575.9f, 390.9f, 575.9f)
                curveTo(376.1f, 575.9f, 361.6f, 570.8f, 350.0f, 561.6f)
                lineTo(294.7f, 517.3f)
                curveTo(290.2f, 513.7f, 285.4f, 510.6f, 280.2f, 508.1f)
                curveTo(264.4f, 500.2f, 246.5f, 497.7f, 229.2f, 500.8f)
                lineTo(146.4f, 515.9f)
                curveTo(111.8f, 522.2f, 80.0f, 495.6f, 80.0f, 460.5f)
                curveTo(80.0f, 447.3f, 84.7f, 434.5f, 93.1f, 424.3f)
                lineTo(104.3f, 410.9f)
                curveTo(118.9f, 393.5f, 126.9f, 371.5f, 126.9f, 348.8f)
                curveTo(126.9f, 330.0f, 121.4f, 311.6f, 111.1f, 295.8f)
                lineTo(72.8f, 237.5f)
                curveTo(67.1f, 228.7f, 64.0f, 218.4f, 64.0f, 207.9f)
                curveTo(64.0f, 174.5f, 94.1f, 149.1f, 127.0f, 154.7f)
                lineTo(178.3f, 163.4f)
                curveTo(214.2f, 169.5f, 250.5f, 155.2f, 272.5f, 126.3f)
                close()
            }
        }
        .build()
        return _splotch!!
    }

private var _splotch: ImageVector? = null
