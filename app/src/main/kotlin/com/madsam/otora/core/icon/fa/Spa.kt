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

public val Fa.Spa: ImageVector
    get() {
        if (_spa != null) {
            return _spa!!
        }
        _spa = Builder(name = "Spa", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(201.7f, 291.5f)
                curveTo(236.0f, 310.2f, 266.2f, 335.6f, 290.5f, 366.0f)
                curveTo(301.6f, 379.9f, 311.5f, 394.9f, 319.9f, 410.8f)
                curveTo(328.4f, 394.9f, 338.2f, 380.0f, 349.3f, 366.0f)
                curveTo(373.6f, 335.5f, 403.8f, 310.1f, 438.1f, 291.5f)
                curveTo(479.8f, 268.8f, 527.5f, 256.0f, 577.8f, 256.0f)
                lineTo(587.7f, 256.0f)
                curveTo(598.8f, 256.0f, 607.8f, 265.0f, 607.8f, 276.1f)
                curveTo(607.8f, 424.1f, 487.9f, 544.0f, 339.9f, 544.0f)
                lineTo(299.7f, 544.0f)
                curveTo(151.9f, 544.0f, 32.0f, 424.1f, 32.0f, 276.1f)
                curveTo(32.0f, 265.0f, 41.0f, 256.0f, 52.1f, 256.0f)
                lineTo(62.0f, 256.0f)
                curveTo(112.4f, 256.0f, 160.1f, 268.8f, 201.7f, 291.5f)
                close()
                moveTo(335.9f, 102.0f)
                curveTo(352.8f, 117.9f, 397.3f, 165.4f, 424.9f, 244.3f)
                curveTo(384.8f, 264.5f, 349.1f, 292.5f, 320.0f, 326.4f)
                curveTo(290.8f, 292.5f, 255.2f, 264.6f, 215.1f, 244.3f)
                curveTo(242.7f, 165.4f, 287.3f, 117.9f, 304.1f, 102.0f)
                curveTo(308.4f, 97.9f, 314.1f, 96.0f, 320.0f, 96.0f)
                curveTo(325.9f, 96.0f, 331.6f, 98.0f, 335.9f, 102.0f)
                close()
            }
        }
        .build()
        return _spa!!
    }

private var _spa: ImageVector? = null
