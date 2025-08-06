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

public val Fa.Link: ImageVector
    get() {
        if (_link != null) {
            return _link!!
        }
        _link = Builder(name = "Link", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(451.5f, 160.0f)
                curveTo(434.9f, 160.0f, 418.8f, 164.5f, 404.7f, 172.7f)
                curveTo(388.9f, 156.7f, 370.5f, 143.3f, 350.2f, 133.2f)
                curveTo(378.4f, 109.2f, 414.3f, 96.0f, 451.5f, 96.0f)
                curveTo(537.9f, 96.0f, 608.0f, 166.0f, 608.0f, 252.5f)
                curveTo(608.0f, 294.0f, 591.5f, 333.8f, 562.2f, 363.1f)
                lineTo(491.1f, 434.2f)
                curveTo(461.8f, 463.5f, 422.0f, 480.0f, 380.5f, 480.0f)
                curveTo(294.1f, 480.0f, 224.0f, 410.0f, 224.0f, 323.5f)
                curveTo(224.0f, 322.0f, 224.0f, 320.5f, 224.1f, 319.0f)
                curveTo(224.6f, 301.3f, 239.3f, 287.4f, 257.0f, 287.9f)
                curveTo(274.7f, 288.4f, 288.6f, 303.1f, 288.1f, 320.8f)
                curveTo(288.1f, 321.7f, 288.1f, 322.6f, 288.1f, 323.4f)
                curveTo(288.1f, 374.5f, 329.5f, 415.9f, 380.6f, 415.9f)
                curveTo(405.1f, 415.9f, 428.6f, 406.2f, 446.0f, 388.8f)
                lineTo(517.1f, 317.7f)
                curveTo(534.4f, 300.4f, 544.2f, 276.8f, 544.2f, 252.3f)
                curveTo(544.2f, 201.2f, 502.8f, 159.8f, 451.7f, 159.8f)
                close()
                moveTo(307.2f, 237.3f)
                curveTo(305.3f, 236.5f, 303.4f, 235.4f, 301.7f, 234.2f)
                curveTo(289.1f, 227.7f, 274.7f, 224.0f, 259.6f, 224.0f)
                curveTo(235.1f, 224.0f, 211.6f, 233.7f, 194.2f, 251.1f)
                lineTo(123.1f, 322.2f)
                curveTo(105.8f, 339.5f, 96.0f, 363.1f, 96.0f, 387.6f)
                curveTo(96.0f, 438.7f, 137.4f, 480.1f, 188.5f, 480.1f)
                curveTo(205.0f, 480.1f, 221.1f, 475.7f, 235.2f, 467.5f)
                curveTo(251.0f, 483.5f, 269.4f, 496.9f, 289.8f, 507.0f)
                curveTo(261.6f, 530.9f, 225.8f, 544.2f, 188.5f, 544.2f)
                curveTo(102.1f, 544.2f, 32.0f, 474.2f, 32.0f, 387.7f)
                curveTo(32.0f, 346.2f, 48.5f, 306.4f, 77.8f, 277.1f)
                lineTo(148.9f, 206.0f)
                curveTo(178.2f, 176.7f, 218.0f, 160.2f, 259.5f, 160.2f)
                curveTo(346.1f, 160.2f, 416.0f, 230.8f, 416.0f, 317.1f)
                curveTo(416.0f, 318.4f, 416.0f, 319.7f, 416.0f, 321.0f)
                curveTo(415.6f, 338.7f, 400.9f, 352.6f, 383.2f, 352.2f)
                curveTo(365.5f, 351.8f, 351.6f, 337.1f, 352.0f, 319.4f)
                curveTo(352.0f, 318.6f, 352.0f, 317.9f, 352.0f, 317.1f)
                curveTo(352.0f, 283.4f, 334.0f, 253.8f, 307.2f, 237.5f)
                close()
            }
        }
        .build()
        return _link!!
    }

private var _link: ImageVector? = null
