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

public val Fa.Paw: ImageVector
    get() {
        if (_paw != null) {
            return _paw!!
        }
        _paw = Builder(name = "Paw", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(298.5f, 156.9f)
                curveTo(312.8f, 199.8f, 298.2f, 243.1f, 265.9f, 253.7f)
                curveTo(233.6f, 264.3f, 195.8f, 238.1f, 181.5f, 195.2f)
                curveTo(167.2f, 152.3f, 181.8f, 109.0f, 214.1f, 98.4f)
                curveTo(246.4f, 87.8f, 284.2f, 114.0f, 298.5f, 156.9f)
                close()
                moveTo(164.4f, 262.6f)
                curveTo(183.3f, 295.0f, 178.7f, 332.7f, 154.2f, 346.7f)
                curveTo(129.7f, 360.7f, 94.5f, 345.8f, 75.7f, 313.4f)
                curveTo(56.9f, 281.0f, 61.4f, 243.3f, 85.9f, 229.3f)
                curveTo(110.4f, 215.3f, 145.6f, 230.2f, 164.4f, 262.6f)
                close()
                moveTo(133.2f, 465.2f)
                curveTo(185.6f, 323.9f, 278.7f, 288.0f, 320.0f, 288.0f)
                curveTo(361.3f, 288.0f, 454.4f, 323.9f, 506.8f, 465.2f)
                curveTo(510.4f, 474.9f, 512.0f, 485.3f, 512.0f, 495.7f)
                lineTo(512.0f, 497.3f)
                curveTo(512.0f, 523.1f, 491.1f, 544.0f, 465.3f, 544.0f)
                curveTo(453.8f, 544.0f, 442.4f, 542.6f, 431.3f, 539.8f)
                lineTo(343.3f, 517.8f)
                curveTo(328.0f, 514.0f, 312.0f, 514.0f, 296.7f, 517.8f)
                lineTo(208.7f, 539.8f)
                curveTo(197.6f, 542.6f, 186.2f, 544.0f, 174.7f, 544.0f)
                curveTo(148.9f, 544.0f, 128.0f, 523.1f, 128.0f, 497.3f)
                lineTo(128.0f, 495.7f)
                curveTo(128.0f, 485.3f, 129.6f, 474.9f, 133.2f, 465.2f)
                close()
                moveTo(485.8f, 346.7f)
                curveTo(461.3f, 332.7f, 456.7f, 295.0f, 475.6f, 262.6f)
                curveTo(494.5f, 230.2f, 529.6f, 215.3f, 554.1f, 229.3f)
                curveTo(578.6f, 243.3f, 583.2f, 281.0f, 564.3f, 313.4f)
                curveTo(545.4f, 345.8f, 510.3f, 360.7f, 485.8f, 346.7f)
                close()
                moveTo(374.1f, 253.7f)
                curveTo(341.8f, 243.1f, 327.2f, 199.8f, 341.5f, 156.9f)
                curveTo(355.8f, 114.0f, 393.6f, 87.8f, 425.9f, 98.4f)
                curveTo(458.2f, 109.0f, 472.8f, 152.3f, 458.5f, 195.2f)
                curveTo(444.2f, 238.1f, 406.4f, 264.3f, 374.1f, 253.7f)
                close()
            }
        }
        .build()
        return _paw!!
    }

private var _paw: ImageVector? = null
