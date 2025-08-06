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

public val Fa.Futbol: ImageVector
    get() {
        if (_futbol != null) {
            return _futbol!!
        }
        _futbol = Builder(name = "Futbol", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(481.3f, 424.1f)
                lineTo(409.7f, 419.3f)
                curveTo(404.5f, 419.0f, 399.4f, 420.4f, 395.2f, 423.5f)
                curveTo(391.0f, 426.6f, 388.0f, 430.9f, 386.8f, 436.0f)
                lineTo(369.2f, 505.6f)
                curveTo(353.5f, 509.8f, 337.0f, 512.0f, 320.0f, 512.0f)
                curveTo(303.0f, 512.0f, 286.5f, 509.8f, 270.8f, 505.6f)
                lineTo(253.2f, 436.0f)
                curveTo(251.9f, 431.0f, 248.9f, 426.6f, 244.8f, 423.5f)
                curveTo(240.7f, 420.4f, 235.5f, 419.0f, 230.3f, 419.3f)
                lineTo(158.7f, 424.1f)
                curveTo(141.1f, 396.9f, 130.2f, 364.9f, 128.3f, 330.5f)
                lineTo(189.0f, 292.3f)
                curveTo(193.4f, 289.5f, 196.6f, 285.3f, 198.2f, 280.4f)
                curveTo(199.8f, 275.5f, 199.6f, 270.2f, 197.7f, 265.4f)
                lineTo(171.0f, 198.8f)
                curveTo(192.0f, 173.2f, 219.3f, 153.0f, 250.7f, 140.9f)
                lineTo(305.9f, 186.9f)
                curveTo(309.9f, 190.2f, 314.9f, 192.0f, 320.0f, 192.0f)
                curveTo(325.1f, 192.0f, 330.2f, 190.2f, 334.1f, 186.9f)
                lineTo(389.3f, 140.9f)
                curveTo(420.6f, 153.0f, 448.0f, 173.2f, 468.9f, 198.8f)
                lineTo(442.2f, 265.4f)
                curveTo(440.3f, 270.2f, 440.1f, 275.5f, 441.7f, 280.4f)
                curveTo(443.3f, 285.3f, 446.6f, 289.5f, 450.9f, 292.3f)
                lineTo(511.6f, 330.5f)
                curveTo(509.7f, 364.9f, 498.8f, 396.9f, 481.2f, 424.1f)
                close()
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(334.1f, 250.3f)
                curveTo(325.7f, 244.2f, 314.3f, 244.2f, 305.9f, 250.3f)
                lineTo(258.0f, 285.0f)
                curveTo(249.6f, 291.1f, 246.1f, 301.9f, 249.3f, 311.8f)
                lineTo(267.6f, 368.1f)
                curveTo(270.8f, 378.0f, 280.0f, 384.7f, 290.4f, 384.7f)
                lineTo(349.6f, 384.7f)
                curveTo(360.0f, 384.7f, 369.2f, 378.0f, 372.4f, 368.1f)
                lineTo(390.7f, 311.8f)
                curveTo(393.9f, 301.9f, 390.4f, 291.1f, 382.0f, 285.0f)
                lineTo(334.1f, 250.2f)
                close()
            }
        }
        .build()
        return _futbol!!
    }

private var _futbol: ImageVector? = null
