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

public val Fa.`Id-card-alt`: ImageVector
    get() {
        if (`_id-card-alt` != null) {
            return `_id-card-alt`!!
        }
        `_id-card-alt` = Builder(name = "Id-card-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 32.0f)
                lineTo(352.0f, 32.0f)
                curveTo(369.7f, 32.0f, 384.0f, 46.3f, 384.0f, 64.0f)
                lineTo(384.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                lineTo(256.0f, 64.0f)
                curveTo(256.0f, 46.3f, 270.3f, 32.0f, 288.0f, 32.0f)
                close()
                moveTo(96.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                lineTo(208.0f, 128.0f)
                curveTo(208.0f, 154.5f, 229.5f, 176.0f, 256.0f, 176.0f)
                lineTo(384.0f, 176.0f)
                curveTo(410.5f, 176.0f, 432.0f, 154.5f, 432.0f, 128.0f)
                lineTo(432.0f, 96.0f)
                lineTo(544.0f, 96.0f)
                curveTo(579.3f, 96.0f, 608.0f, 124.7f, 608.0f, 160.0f)
                lineTo(608.0f, 480.0f)
                curveTo(608.0f, 515.3f, 579.3f, 544.0f, 544.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                lineTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                close()
                moveTo(208.0f, 464.0f)
                curveTo(208.0f, 472.8f, 215.2f, 480.0f, 224.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(424.8f, 480.0f, 432.0f, 472.8f, 432.0f, 464.0f)
                curveTo(432.0f, 419.8f, 396.2f, 384.0f, 352.0f, 384.0f)
                lineTo(288.0f, 384.0f)
                curveTo(243.8f, 384.0f, 208.0f, 419.8f, 208.0f, 464.0f)
                close()
                moveTo(320.0f, 344.0f)
                curveTo(350.9f, 344.0f, 376.0f, 318.9f, 376.0f, 288.0f)
                curveTo(376.0f, 257.1f, 350.9f, 232.0f, 320.0f, 232.0f)
                curveTo(289.1f, 232.0f, 264.0f, 257.1f, 264.0f, 288.0f)
                curveTo(264.0f, 318.9f, 289.1f, 344.0f, 320.0f, 344.0f)
                close()
            }
        }
        .build()
        return `_id-card-alt`!!
    }

private var `_id-card-alt`: ImageVector? = null
