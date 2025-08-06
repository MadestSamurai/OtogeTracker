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

public val Fa.Tablets: ImageVector
    get() {
        if (_tablets != null) {
            return _tablets!!
        }
        _tablets = Builder(name = "Tablets", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(559.3f, 140.6f)
                curveTo(554.7f, 131.9f, 543.0f, 130.9f, 536.0f, 137.9f)
                lineTo(361.9f, 312.0f)
                curveTo(354.9f, 319.0f, 355.9f, 330.7f, 364.6f, 335.3f)
                curveTo(384.7f, 346.0f, 407.6f, 352.0f, 432.0f, 352.0f)
                curveTo(511.5f, 352.0f, 576.0f, 287.5f, 576.0f, 208.0f)
                curveTo(576.0f, 183.7f, 570.0f, 160.7f, 559.3f, 140.6f)
                close()
                moveTo(304.7f, 275.4f)
                curveTo(309.3f, 284.1f, 321.0f, 285.1f, 328.0f, 278.1f)
                lineTo(502.1f, 104.0f)
                curveTo(509.1f, 97.0f, 508.1f, 85.3f, 499.4f, 80.7f)
                curveTo(479.3f, 70.0f, 456.4f, 64.0f, 432.0f, 64.0f)
                curveTo(352.5f, 64.0f, 288.0f, 128.5f, 288.0f, 208.0f)
                curveTo(288.0f, 232.3f, 294.0f, 255.3f, 304.7f, 275.4f)
                close()
                moveTo(208.0f, 288.0f)
                curveTo(143.2f, 288.0f, 88.4f, 330.8f, 70.3f, 389.6f)
                curveTo(67.4f, 399.1f, 75.0f, 408.0f, 84.9f, 408.0f)
                lineTo(331.1f, 408.0f)
                curveTo(341.0f, 408.0f, 348.6f, 399.1f, 345.7f, 389.6f)
                curveTo(344.8f, 386.6f, 343.8f, 383.7f, 342.7f, 380.9f)
                curveTo(305.3f, 362.8f, 274.7f, 332.9f, 255.7f, 296.1f)
                curveTo(240.8f, 290.9f, 224.8f, 288.0f, 208.1f, 288.0f)
                close()
                moveTo(345.7f, 474.4f)
                curveTo(348.6f, 464.9f, 341.0f, 456.0f, 331.1f, 456.0f)
                lineTo(84.9f, 456.0f)
                curveTo(75.0f, 456.0f, 67.4f, 464.9f, 70.3f, 474.4f)
                curveTo(88.4f, 533.2f, 143.2f, 576.0f, 208.0f, 576.0f)
                curveTo(272.8f, 576.0f, 327.6f, 533.2f, 345.7f, 474.4f)
                close()
            }
        }
        .build()
        return _tablets!!
    }

private var _tablets: ImageVector? = null
