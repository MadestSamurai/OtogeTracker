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

public val Fa.Hryvnia: ImageVector
    get() {
        if (_hryvnia != null) {
            return _hryvnia!!
        }
        _hryvnia = Builder(name = "Hryvnia", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(464.0f, 213.4f)
                curveTo(464.0f, 141.0f, 396.5f, 87.5f, 326.0f, 104.1f)
                lineTo(221.2f, 128.9f)
                curveTo(204.0f, 132.9f, 193.4f, 150.2f, 197.4f, 167.4f)
                curveTo(201.4f, 184.6f, 218.7f, 195.3f, 235.9f, 191.2f)
                lineTo(340.7f, 166.5f)
                curveTo(371.0f, 159.4f, 400.0f, 182.3f, 400.0f, 213.4f)
                curveTo(400.0f, 231.0f, 390.4f, 247.2f, 375.0f, 255.7f)
                lineTo(374.3f, 256.1f)
                lineTo(152.0f, 256.1f)
                curveTo(138.7f, 256.1f, 128.0f, 266.8f, 128.0f, 280.1f)
                curveTo(128.0f, 293.4f, 138.7f, 304.1f, 152.0f, 304.1f)
                lineTo(488.0f, 304.1f)
                curveTo(501.3f, 304.1f, 512.0f, 293.4f, 512.0f, 280.1f)
                curveTo(512.0f, 266.8f, 501.3f, 256.1f, 488.0f, 256.1f)
                lineTo(455.6f, 256.1f)
                curveTo(461.1f, 242.8f, 464.0f, 228.3f, 464.0f, 213.5f)
                close()
                moveTo(488.0f, 336.0f)
                lineTo(152.0f, 336.0f)
                curveTo(138.7f, 336.0f, 128.0f, 346.7f, 128.0f, 360.0f)
                curveTo(128.0f, 373.3f, 138.7f, 384.0f, 152.0f, 384.0f)
                lineTo(185.3f, 384.0f)
                curveTo(179.2f, 397.4f, 176.0f, 412.1f, 176.0f, 427.3f)
                curveTo(176.0f, 491.4f, 232.9f, 540.7f, 296.4f, 531.5f)
                lineTo(434.3f, 511.6f)
                curveTo(451.8f, 509.1f, 463.9f, 492.9f, 461.4f, 475.4f)
                curveTo(458.9f, 457.9f, 442.6f, 445.8f, 425.2f, 448.3f)
                lineTo(287.2f, 468.2f)
                curveTo(262.3f, 471.8f, 240.0f, 452.5f, 240.0f, 427.3f)
                curveTo(240.0f, 412.2f, 248.2f, 398.4f, 261.4f, 391.1f)
                lineTo(274.4f, 384.0f)
                lineTo(488.0f, 384.0f)
                curveTo(501.3f, 384.0f, 512.0f, 373.3f, 512.0f, 360.0f)
                curveTo(512.0f, 346.7f, 501.3f, 336.0f, 488.0f, 336.0f)
                close()
            }
        }
        .build()
        return _hryvnia!!
    }

private var _hryvnia: ImageVector? = null
