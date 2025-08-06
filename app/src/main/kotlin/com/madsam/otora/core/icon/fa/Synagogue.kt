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

public val Fa.Synagogue: ImageVector
    get() {
        if (_synagogue != null) {
            return _synagogue!!
        }
        _synagogue = Builder(name = "Synagogue", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(48.0f, 144.0f)
                curveTo(48.0f, 108.7f, 76.7f, 80.0f, 112.0f, 80.0f)
                curveTo(147.3f, 80.0f, 176.0f, 108.7f, 176.0f, 144.0f)
                lineTo(176.0f, 176.0f)
                lineTo(48.0f, 176.0f)
                lineTo(48.0f, 144.0f)
                close()
                moveTo(48.0f, 512.0f)
                lineTo(48.0f, 224.0f)
                lineTo(176.0f, 224.0f)
                lineTo(302.2f, 139.8f)
                curveTo(312.9f, 132.6f, 327.0f, 132.6f, 337.7f, 139.8f)
                lineTo(463.9f, 224.0f)
                lineTo(591.9f, 224.0f)
                lineTo(591.9f, 512.0f)
                curveTo(591.9f, 547.3f, 563.2f, 576.0f, 527.9f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(76.7f, 576.0f, 48.0f, 547.3f, 48.0f, 512.0f)
                close()
                moveTo(592.0f, 176.0f)
                lineTo(464.0f, 176.0f)
                lineTo(464.0f, 144.0f)
                curveTo(464.0f, 108.7f, 492.7f, 80.0f, 528.0f, 80.0f)
                curveTo(563.3f, 80.0f, 592.0f, 108.7f, 592.0f, 144.0f)
                lineTo(592.0f, 176.0f)
                close()
                moveTo(256.0f, 448.0f)
                lineTo(256.0f, 528.0f)
                lineTo(384.0f, 528.0f)
                lineTo(384.0f, 448.0f)
                curveTo(384.0f, 412.7f, 355.3f, 384.0f, 320.0f, 384.0f)
                curveTo(284.7f, 384.0f, 256.0f, 412.7f, 256.0f, 448.0f)
                close()
                moveTo(320.0f, 296.0f)
                curveTo(342.1f, 296.0f, 360.0f, 278.1f, 360.0f, 256.0f)
                curveTo(360.0f, 233.9f, 342.1f, 216.0f, 320.0f, 216.0f)
                curveTo(297.9f, 216.0f, 280.0f, 233.9f, 280.0f, 256.0f)
                curveTo(280.0f, 278.1f, 297.9f, 296.0f, 320.0f, 296.0f)
                close()
            }
        }
        .build()
        return _synagogue!!
    }

private var _synagogue: ImageVector? = null
