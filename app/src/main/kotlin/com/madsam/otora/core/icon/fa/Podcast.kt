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

public val Fa.Podcast: ImageVector
    get() {
        if (_podcast != null) {
            return _podcast!!
        }
        _podcast = Builder(name = "Podcast", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(432.0f, 423.8f)
                curveTo(471.1f, 391.5f, 496.0f, 342.7f, 496.0f, 288.0f)
                curveTo(496.0f, 190.8f, 417.2f, 112.0f, 320.0f, 112.0f)
                curveTo(222.8f, 112.0f, 144.0f, 190.8f, 144.0f, 288.0f)
                curveTo(144.0f, 342.7f, 168.9f, 391.5f, 208.0f, 423.8f)
                curveTo(208.4f, 441.4f, 211.2f, 464.2f, 214.4f, 485.6f)
                curveTo(144.0f, 447.9f, 96.0f, 373.5f, 96.0f, 288.0f)
                curveTo(96.0f, 164.3f, 196.3f, 64.0f, 320.0f, 64.0f)
                curveTo(443.7f, 64.0f, 544.0f, 164.3f, 544.0f, 288.0f)
                curveTo(544.0f, 373.6f, 496.0f, 447.9f, 425.5f, 485.6f)
                curveTo(428.8f, 464.2f, 431.5f, 441.4f, 431.9f, 423.8f)
                close()
                moveTo(418.0f, 370.4f)
                curveTo(409.7f, 357.8f, 398.8f, 348.8f, 387.6f, 342.6f)
                curveTo(385.5f, 341.5f, 383.4f, 340.4f, 381.3f, 339.4f)
                curveTo(393.0f, 325.5f, 400.1f, 307.5f, 400.1f, 287.9f)
                curveTo(400.1f, 243.7f, 364.3f, 207.9f, 320.1f, 207.9f)
                curveTo(275.9f, 207.9f, 240.1f, 243.7f, 240.1f, 287.9f)
                curveTo(240.1f, 307.5f, 247.2f, 325.5f, 258.9f, 339.4f)
                curveTo(256.8f, 340.4f, 254.7f, 341.4f, 252.6f, 342.6f)
                curveTo(241.4f, 348.8f, 230.5f, 357.8f, 222.2f, 370.4f)
                curveTo(203.4f, 348.1f, 192.1f, 319.4f, 192.1f, 288.0f)
                curveTo(192.1f, 217.3f, 249.4f, 160.0f, 320.1f, 160.0f)
                curveTo(390.8f, 160.0f, 448.1f, 217.3f, 448.1f, 288.0f)
                curveTo(448.1f, 319.4f, 436.8f, 348.2f, 418.0f, 370.4f)
                close()
                moveTo(320.0f, 376.0f)
                curveTo(352.9f, 376.0f, 384.0f, 384.6f, 384.0f, 419.8f)
                curveTo(384.0f, 452.8f, 371.1f, 523.9f, 363.4f, 552.7f)
                curveTo(358.3f, 571.7f, 338.9f, 576.1f, 320.0f, 576.1f)
                curveTo(301.1f, 576.1f, 281.8f, 571.7f, 276.6f, 552.7f)
                curveTo(268.8f, 524.2f, 256.0f, 453.0f, 256.0f, 419.9f)
                curveTo(256.0f, 384.8f, 287.1f, 376.1f, 320.0f, 376.1f)
                close()
                moveTo(320.0f, 248.0f)
                curveTo(342.1f, 248.0f, 360.0f, 265.9f, 360.0f, 288.0f)
                curveTo(360.0f, 310.1f, 342.1f, 328.0f, 320.0f, 328.0f)
                curveTo(297.9f, 328.0f, 280.0f, 310.1f, 280.0f, 288.0f)
                curveTo(280.0f, 265.9f, 297.9f, 248.0f, 320.0f, 248.0f)
                close()
            }
        }
        .build()
        return _podcast!!
    }

private var _podcast: ImageVector? = null
