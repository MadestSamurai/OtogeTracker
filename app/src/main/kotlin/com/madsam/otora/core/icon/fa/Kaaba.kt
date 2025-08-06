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

public val Fa.Kaaba: ImageVector
    get() {
        if (_kaaba != null) {
            return _kaaba!!
        }
        _kaaba = Builder(name = "Kaaba", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 115.3f)
                lineTo(156.8f, 176.4f)
                lineTo(311.5f, 235.1f)
                curveTo(317.0f, 237.2f, 323.0f, 237.2f, 328.5f, 235.1f)
                lineTo(483.2f, 176.4f)
                lineTo(320.0f, 115.3f)
                close()
                moveTo(64.0f, 193.3f)
                curveTo(64.0f, 173.3f, 76.4f, 155.4f, 95.1f, 148.4f)
                lineTo(303.1f, 70.4f)
                curveTo(314.0f, 66.3f, 325.9f, 66.3f, 336.8f, 70.4f)
                lineTo(544.8f, 148.4f)
                curveTo(563.5f, 155.4f, 575.9f, 173.3f, 575.9f, 193.3f)
                lineTo(575.9f, 229.3f)
                lineTo(322.7f, 325.3f)
                curveTo(320.9f, 326.0f, 318.9f, 326.0f, 317.0f, 325.3f)
                lineTo(63.8f, 229.3f)
                lineTo(63.8f, 193.3f)
                close()
                moveTo(64.0f, 333.3f)
                lineTo(64.0f, 280.6f)
                lineTo(300.1f, 370.2f)
                curveTo(312.9f, 375.1f, 327.0f, 375.1f, 339.8f, 370.2f)
                lineTo(575.9f, 280.6f)
                lineTo(575.9f, 333.3f)
                lineTo(447.9f, 381.9f)
                lineTo(447.9f, 433.2f)
                lineTo(575.9f, 384.6f)
                lineTo(575.9f, 446.8f)
                curveTo(575.9f, 466.8f, 563.5f, 484.7f, 544.8f, 491.7f)
                lineTo(336.8f, 569.7f)
                curveTo(325.9f, 573.8f, 314.0f, 573.8f, 303.1f, 569.7f)
                lineTo(95.1f, 491.7f)
                curveTo(76.4f, 484.7f, 64.0f, 466.7f, 64.0f, 446.7f)
                lineTo(64.0f, 384.5f)
                lineTo(192.0f, 433.1f)
                lineTo(192.0f, 381.8f)
                lineTo(64.0f, 333.2f)
                close()
                moveTo(300.1f, 474.1f)
                curveTo(312.9f, 479.0f, 327.0f, 479.0f, 339.8f, 474.1f)
                lineTo(399.9f, 451.3f)
                lineTo(399.9f, 400.0f)
                lineTo(322.7f, 429.3f)
                curveTo(320.9f, 430.0f, 318.9f, 430.0f, 317.0f, 429.3f)
                lineTo(239.8f, 400.0f)
                lineTo(239.8f, 451.3f)
                lineTo(299.9f, 474.1f)
                close()
            }
        }
        .build()
        return _kaaba!!
    }

private var _kaaba: ImageVector? = null
