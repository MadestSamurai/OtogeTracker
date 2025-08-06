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

public val Fa.Igloo: ImageVector
    get() {
        if (_igloo != null) {
            return _igloo!!
        }
        _igloo = Builder(name = "Igloo", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 97.8f)
                lineTo(352.0f, 224.0f)
                lineTo(80.5f, 224.0f)
                curveTo(132.2f, 146.8f, 220.1f, 96.0f, 320.0f, 96.0f)
                curveTo(330.8f, 96.0f, 341.5f, 96.6f, 352.0f, 97.8f)
                close()
                moveTo(400.0f, 224.0f)
                lineTo(400.0f, 107.3f)
                curveTo(466.0f, 126.3f, 522.2f, 168.3f, 559.5f, 224.0f)
                lineTo(400.0f, 224.0f)
                close()
                moveTo(54.6f, 272.0f)
                lineTo(128.0f, 272.0f)
                lineTo(128.0f, 384.0f)
                lineTo(32.0f, 384.0f)
                curveTo(32.0f, 344.3f, 40.0f, 306.4f, 54.6f, 272.0f)
                close()
                moveTo(208.0f, 384.0f)
                lineTo(176.0f, 384.0f)
                lineTo(176.0f, 272.0f)
                lineTo(464.0f, 272.0f)
                lineTo(464.0f, 384.0f)
                lineTo(432.0f, 384.0f)
                lineTo(432.0f, 432.0f)
                lineTo(608.0f, 432.0f)
                lineTo(608.0f, 496.0f)
                curveTo(608.0f, 522.5f, 586.5f, 544.0f, 560.0f, 544.0f)
                lineTo(80.0f, 544.0f)
                curveTo(53.5f, 544.0f, 32.0f, 522.5f, 32.0f, 496.0f)
                lineTo(32.0f, 432.0f)
                lineTo(208.0f, 432.0f)
                lineTo(208.0f, 384.0f)
                close()
                moveTo(512.0f, 384.0f)
                lineTo(512.0f, 272.0f)
                lineTo(585.4f, 272.0f)
                curveTo(600.0f, 306.4f, 608.0f, 344.3f, 608.0f, 384.0f)
                lineTo(512.0f, 384.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(284.7f, 352.0f, 256.0f, 380.7f, 256.0f, 416.0f)
                lineTo(256.0f, 496.0f)
                lineTo(384.0f, 496.0f)
                lineTo(384.0f, 416.0f)
                curveTo(384.0f, 380.7f, 355.3f, 352.0f, 320.0f, 352.0f)
                close()
            }
        }
        .build()
        return _igloo!!
    }

private var _igloo: ImageVector? = null
