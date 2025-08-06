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

public val Fa.`Camera-rotate`: ImageVector
    get() {
        if (`_camera-rotate` != null) {
            return `_camera-rotate`!!
        }
        `_camera-rotate` = Builder(name = "Camera-rotate", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(202.7f, 160.0f)
                lineTo(213.1f, 128.8f)
                curveTo(219.6f, 109.2f, 237.9f, 96.0f, 258.6f, 96.0f)
                lineTo(381.4f, 96.0f)
                curveTo(402.1f, 96.0f, 420.4f, 109.2f, 426.9f, 128.8f)
                lineTo(437.3f, 160.0f)
                lineTo(512.0f, 160.0f)
                curveTo(547.3f, 160.0f, 576.0f, 188.7f, 576.0f, 224.0f)
                lineTo(576.0f, 480.0f)
                curveTo(576.0f, 515.3f, 547.3f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                lineTo(64.0f, 224.0f)
                curveTo(64.0f, 188.7f, 92.7f, 160.0f, 128.0f, 160.0f)
                lineTo(202.7f, 160.0f)
                close()
                moveTo(160.0f, 369.9f)
                curveTo(160.0f, 373.8f, 161.4f, 377.6f, 164.0f, 380.5f)
                lineTo(212.0f, 434.5f)
                curveTo(218.4f, 441.7f, 229.6f, 441.7f, 235.9f, 434.5f)
                lineTo(283.9f, 380.5f)
                curveTo(286.5f, 377.6f, 287.9f, 373.8f, 287.9f, 369.9f)
                lineTo(287.9f, 368.0f)
                curveTo(287.9f, 359.2f, 280.7f, 352.0f, 271.9f, 352.0f)
                lineTo(247.9f, 352.0f)
                curveTo(247.9f, 312.2f, 280.1f, 280.0f, 319.9f, 280.0f)
                curveTo(324.3f, 280.0f, 328.6f, 280.4f, 332.8f, 281.2f)
                lineTo(367.7f, 241.9f)
                curveTo(353.1f, 235.5f, 336.9f, 232.0f, 319.9f, 232.0f)
                curveTo(253.6f, 232.0f, 199.9f, 285.7f, 199.9f, 352.0f)
                lineTo(175.9f, 352.0f)
                curveTo(167.1f, 352.0f, 159.9f, 359.2f, 159.9f, 368.0f)
                lineTo(159.9f, 369.9f)
                close()
                moveTo(356.0f, 323.4f)
                curveTo(353.4f, 326.3f, 352.0f, 330.1f, 352.0f, 334.0f)
                lineTo(352.0f, 335.9f)
                curveTo(352.0f, 344.7f, 359.2f, 351.9f, 368.0f, 351.9f)
                lineTo(392.0f, 351.9f)
                curveTo(392.0f, 391.7f, 359.8f, 423.9f, 320.0f, 423.9f)
                curveTo(315.6f, 423.9f, 311.3f, 423.5f, 307.1f, 422.7f)
                lineTo(272.2f, 462.0f)
                curveTo(286.9f, 468.4f, 303.0f, 471.9f, 320.0f, 471.9f)
                curveTo(386.3f, 471.9f, 440.0f, 418.2f, 440.0f, 351.9f)
                lineTo(464.0f, 351.9f)
                curveTo(472.8f, 351.9f, 480.0f, 344.7f, 480.0f, 335.9f)
                lineTo(480.0f, 334.0f)
                curveTo(480.0f, 330.1f, 478.6f, 326.3f, 476.0f, 323.4f)
                lineTo(428.0f, 269.4f)
                curveTo(421.6f, 262.2f, 410.4f, 262.2f, 404.1f, 269.4f)
                lineTo(356.1f, 323.4f)
                close()
            }
        }
        .build()
        return `_camera-rotate`!!
    }

private var `_camera-rotate`: ImageVector? = null
