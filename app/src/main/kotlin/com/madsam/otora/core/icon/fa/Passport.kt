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

public val Fa.Passport: ImageVector
    get() {
        if (_passport != null) {
            return _passport!!
        }
        _passport = Builder(name = "Passport", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(483.3f, 64.0f, 512.0f, 92.7f, 512.0f, 128.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(224.0f, 472.0f)
                curveTo(224.0f, 485.3f, 234.7f, 496.0f, 248.0f, 496.0f)
                lineTo(392.0f, 496.0f)
                curveTo(405.3f, 496.0f, 416.0f, 485.3f, 416.0f, 472.0f)
                curveTo(416.0f, 458.7f, 405.3f, 448.0f, 392.0f, 448.0f)
                lineTo(248.0f, 448.0f)
                curveTo(234.7f, 448.0f, 224.0f, 458.7f, 224.0f, 472.0f)
                close()
                moveTo(406.6f, 272.0f)
                curveTo(401.8f, 298.4f, 385.1f, 320.7f, 362.4f, 333.2f)
                curveTo(369.1f, 316.2f, 373.6f, 295.2f, 375.0f, 272.0f)
                lineTo(406.6f, 272.0f)
                close()
                moveTo(233.5f, 272.0f)
                lineTo(265.1f, 272.0f)
                curveTo(266.5f, 295.1f, 271.1f, 316.2f, 277.7f, 333.2f)
                curveTo(255.0f, 320.7f, 238.3f, 298.4f, 233.5f, 272.0f)
                close()
                moveTo(309.9f, 327.0f)
                curveTo(303.7f, 313.6f, 298.8f, 294.5f, 297.2f, 272.0f)
                lineTo(343.0f, 272.0f)
                curveTo(341.4f, 294.5f, 336.5f, 313.6f, 330.3f, 327.0f)
                curveTo(325.8f, 336.6f, 322.1f, 340.8f, 320.1f, 342.5f)
                curveTo(318.1f, 340.8f, 314.4f, 336.7f, 309.9f, 327.0f)
                close()
                moveTo(309.9f, 185.0f)
                curveTo(314.4f, 175.4f, 318.1f, 171.2f, 320.1f, 169.5f)
                curveTo(322.1f, 171.2f, 325.8f, 175.3f, 330.3f, 185.0f)
                curveTo(336.5f, 198.4f, 341.4f, 217.5f, 343.0f, 240.0f)
                lineTo(297.2f, 240.0f)
                curveTo(298.8f, 217.5f, 303.7f, 198.4f, 309.9f, 185.0f)
                close()
                moveTo(406.6f, 240.0f)
                lineTo(375.0f, 240.0f)
                curveTo(373.6f, 216.9f, 369.0f, 195.8f, 362.4f, 178.8f)
                curveTo(385.1f, 191.3f, 401.8f, 213.6f, 406.6f, 240.0f)
                close()
                moveTo(265.0f, 240.0f)
                lineTo(233.4f, 240.0f)
                curveTo(238.2f, 213.6f, 254.9f, 191.3f, 277.6f, 178.8f)
                curveTo(270.9f, 195.8f, 266.4f, 216.8f, 265.0f, 240.0f)
                close()
                moveTo(448.0f, 256.0f)
                curveTo(448.0f, 185.3f, 390.7f, 128.0f, 320.0f, 128.0f)
                curveTo(249.3f, 128.0f, 192.0f, 185.3f, 192.0f, 256.0f)
                curveTo(192.0f, 326.7f, 249.3f, 384.0f, 320.0f, 384.0f)
                curveTo(390.7f, 384.0f, 448.0f, 326.7f, 448.0f, 256.0f)
                close()
            }
        }
        .build()
        return _passport!!
    }

private var _passport: ImageVector? = null
