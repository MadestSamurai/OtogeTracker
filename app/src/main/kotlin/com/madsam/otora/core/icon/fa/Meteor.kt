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

public val Fa.Meteor: ImageVector
    get() {
        if (_meteor != null) {
            return _meteor!!
        }
        _meteor = Builder(name = "Meteor", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(557.7f, 64.9f)
                lineTo(363.5f, 139.6f)
                lineTo(365.8f, 110.3f)
                curveTo(366.8f, 97.5f, 353.0f, 88.8f, 341.8f, 95.2f)
                lineTo(165.3f, 197.4f)
                curveTo(102.6f, 233.7f, 64.0f, 300.6f, 64.0f, 373.0f)
                curveTo(64.0f, 485.1f, 154.9f, 576.0f, 267.0f, 576.0f)
                curveTo(339.4f, 576.0f, 406.3f, 537.4f, 442.6f, 474.7f)
                lineTo(544.8f, 298.3f)
                curveTo(551.3f, 287.2f, 542.6f, 273.3f, 529.7f, 274.3f)
                lineTo(500.4f, 276.6f)
                lineTo(575.1f, 82.4f)
                curveTo(575.7f, 80.9f, 576.0f, 79.2f, 576.0f, 77.6f)
                curveTo(576.0f, 70.1f, 570.0f, 64.1f, 562.5f, 64.1f)
                curveTo(560.8f, 64.1f, 559.2f, 64.4f, 557.7f, 65.0f)
                close()
                moveTo(256.0f, 256.0f)
                curveTo(326.7f, 256.0f, 384.0f, 313.3f, 384.0f, 384.0f)
                curveTo(384.0f, 454.7f, 326.7f, 512.0f, 256.0f, 512.0f)
                curveTo(185.3f, 512.0f, 128.0f, 454.7f, 128.0f, 384.0f)
                curveTo(128.0f, 313.3f, 185.3f, 256.0f, 256.0f, 256.0f)
                close()
                moveTo(256.0f, 352.0f)
                curveTo(256.0f, 334.3f, 241.7f, 320.0f, 224.0f, 320.0f)
                curveTo(206.3f, 320.0f, 192.0f, 334.3f, 192.0f, 352.0f)
                curveTo(192.0f, 369.7f, 206.3f, 384.0f, 224.0f, 384.0f)
                curveTo(241.7f, 384.0f, 256.0f, 369.7f, 256.0f, 352.0f)
                close()
                moveTo(272.0f, 448.0f)
                curveTo(280.8f, 448.0f, 288.0f, 440.8f, 288.0f, 432.0f)
                curveTo(288.0f, 423.2f, 280.8f, 416.0f, 272.0f, 416.0f)
                curveTo(263.2f, 416.0f, 256.0f, 423.2f, 256.0f, 432.0f)
                curveTo(256.0f, 440.8f, 263.2f, 448.0f, 272.0f, 448.0f)
                close()
            }
        }
        .build()
        return _meteor!!
    }

private var _meteor: ImageVector? = null
