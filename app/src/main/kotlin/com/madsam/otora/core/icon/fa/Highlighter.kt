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

public val Fa.Highlighter: ImageVector
    get() {
        if (_highlighter != null) {
            return _highlighter!!
        }
        _highlighter = Builder(name = "Highlighter", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(347.0f, 379.0f)
                lineTo(505.4f, 163.9f)
                lineTo(476.1f, 134.6f)
                lineTo(261.0f, 293.0f)
                lineTo(347.0f, 379.0f)
                close()
                moveTo(160.0f, 384.0f)
                lineTo(160.0f, 384.0f)
                lineTo(160.0f, 312.3f)
                curveTo(160.0f, 297.0f, 167.2f, 282.7f, 179.5f, 273.7f)
                lineTo(452.6f, 72.4f)
                curveTo(460.0f, 66.9f, 469.0f, 64.0f, 478.2f, 64.0f)
                curveTo(489.6f, 64.0f, 500.5f, 68.5f, 508.6f, 76.6f)
                lineTo(563.4f, 131.4f)
                curveTo(571.5f, 139.5f, 576.0f, 150.4f, 576.0f, 161.9f)
                curveTo(576.0f, 171.1f, 573.1f, 180.1f, 567.6f, 187.5f)
                lineTo(366.4f, 460.5f)
                curveTo(357.4f, 472.8f, 343.0f, 480.0f, 327.8f, 480.0f)
                lineTo(256.1f, 480.0f)
                lineTo(230.7f, 505.4f)
                curveTo(218.2f, 517.9f, 197.9f, 517.9f, 185.4f, 505.4f)
                lineTo(134.7f, 454.7f)
                curveTo(122.2f, 442.2f, 122.2f, 421.9f, 134.7f, 409.4f)
                lineTo(160.0f, 384.0f)
                close()
                moveTo(39.0f, 530.3f)
                lineTo(90.7f, 478.6f)
                lineTo(161.3f, 549.2f)
                lineTo(141.6f, 568.9f)
                curveTo(137.1f, 573.4f, 131.0f, 575.9f, 124.6f, 575.9f)
                lineTo(56.0f, 576.0f)
                curveTo(42.7f, 576.0f, 32.0f, 565.3f, 32.0f, 552.0f)
                lineTo(32.0f, 547.3f)
                curveTo(32.0f, 540.9f, 34.5f, 534.8f, 39.0f, 530.3f)
                close()
            }
        }
        .build()
        return _highlighter!!
    }

private var _highlighter: ImageVector? = null
