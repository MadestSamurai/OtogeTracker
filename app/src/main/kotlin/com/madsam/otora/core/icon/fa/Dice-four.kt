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

public val Fa.`Dice-four`: ImageVector
    get() {
        if (`_dice-four` != null) {
            return `_dice-four`!!
        }
        `_dice-four` = Builder(name = "Dice-four", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                close()
                moveTo(256.0f, 224.0f)
                curveTo(256.0f, 206.3f, 241.7f, 192.0f, 224.0f, 192.0f)
                curveTo(206.3f, 192.0f, 192.0f, 206.3f, 192.0f, 224.0f)
                curveTo(192.0f, 241.7f, 206.3f, 256.0f, 224.0f, 256.0f)
                curveTo(241.7f, 256.0f, 256.0f, 241.7f, 256.0f, 224.0f)
                close()
                moveTo(224.0f, 448.0f)
                curveTo(241.7f, 448.0f, 256.0f, 433.7f, 256.0f, 416.0f)
                curveTo(256.0f, 398.3f, 241.7f, 384.0f, 224.0f, 384.0f)
                curveTo(206.3f, 384.0f, 192.0f, 398.3f, 192.0f, 416.0f)
                curveTo(192.0f, 433.7f, 206.3f, 448.0f, 224.0f, 448.0f)
                close()
                moveTo(448.0f, 224.0f)
                curveTo(448.0f, 206.3f, 433.7f, 192.0f, 416.0f, 192.0f)
                curveTo(398.3f, 192.0f, 384.0f, 206.3f, 384.0f, 224.0f)
                curveTo(384.0f, 241.7f, 398.3f, 256.0f, 416.0f, 256.0f)
                curveTo(433.7f, 256.0f, 448.0f, 241.7f, 448.0f, 224.0f)
                close()
                moveTo(416.0f, 448.0f)
                curveTo(433.7f, 448.0f, 448.0f, 433.7f, 448.0f, 416.0f)
                curveTo(448.0f, 398.3f, 433.7f, 384.0f, 416.0f, 384.0f)
                curveTo(398.3f, 384.0f, 384.0f, 398.3f, 384.0f, 416.0f)
                curveTo(384.0f, 433.7f, 398.3f, 448.0f, 416.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_dice-four`!!
    }

private var `_dice-four`: ImageVector? = null
