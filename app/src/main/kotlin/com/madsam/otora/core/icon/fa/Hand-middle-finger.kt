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

public val Fa.`Hand-middle-finger`: ImageVector
    get() {
        if (`_hand-middle-finger` != null) {
            return `_hand-middle-finger`!!
        }
        `_hand-middle-finger` = Builder(name = "Hand-middle-finger", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(328.0f, 64.0f)
                curveTo(305.9f, 64.0f, 288.0f, 81.9f, 288.0f, 104.0f)
                lineTo(288.0f, 268.2f)
                curveTo(279.5f, 260.6f, 268.3f, 256.0f, 256.0f, 256.0f)
                curveTo(229.5f, 256.0f, 208.0f, 277.5f, 208.0f, 304.0f)
                lineTo(208.0f, 384.0f)
                curveTo(208.0f, 392.8f, 200.8f, 400.0f, 192.0f, 400.0f)
                curveTo(183.2f, 400.0f, 176.0f, 392.8f, 176.0f, 384.0f)
                lineTo(176.0f, 328.3f)
                curveTo(174.0f, 329.7f, 172.1f, 331.3f, 170.2f, 332.8f)
                lineTo(151.0f, 348.8f)
                curveTo(136.4f, 361.0f, 128.0f, 379.0f, 128.0f, 398.0f)
                lineTo(128.0f, 436.0f)
                curveTo(128.0f, 474.0f, 144.9f, 510.0f, 174.1f, 534.3f)
                lineTo(179.5f, 538.8f)
                curveTo(208.3f, 562.8f, 244.5f, 575.9f, 281.9f, 575.9f)
                lineTo(400.0f, 576.0f)
                curveTo(470.7f, 576.0f, 528.0f, 518.7f, 528.0f, 448.0f)
                lineTo(528.0f, 352.0f)
                curveTo(528.0f, 325.5f, 506.5f, 304.0f, 480.0f, 304.0f)
                curveTo(467.6f, 304.0f, 456.4f, 308.7f, 447.9f, 316.3f)
                curveTo(446.0f, 291.5f, 425.3f, 272.0f, 400.0f, 272.0f)
                curveTo(387.7f, 272.0f, 376.5f, 276.6f, 368.0f, 284.2f)
                lineTo(368.0f, 104.0f)
                curveTo(368.0f, 81.9f, 350.1f, 64.0f, 328.0f, 64.0f)
                close()
            }
        }
        .build()
        return `_hand-middle-finger`!!
    }

private var `_hand-middle-finger`: ImageVector? = null
