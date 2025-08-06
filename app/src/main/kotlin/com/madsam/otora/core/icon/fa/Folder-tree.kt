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

public val Fa.`Folder-tree`: ImageVector
    get() {
        if (`_folder-tree` != null) {
            return `_folder-tree`!!
        }
        `_folder-tree` = Builder(name = "Folder-tree", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(80.0f, 88.0f)
                curveTo(80.0f, 74.7f, 69.3f, 64.0f, 56.0f, 64.0f)
                curveTo(42.7f, 64.0f, 32.0f, 74.7f, 32.0f, 88.0f)
                lineTo(32.0f, 456.0f)
                curveTo(32.0f, 486.9f, 57.1f, 512.0f, 88.0f, 512.0f)
                lineTo(272.0f, 512.0f)
                lineTo(272.0f, 464.0f)
                lineTo(88.0f, 464.0f)
                curveTo(83.6f, 464.0f, 80.0f, 460.4f, 80.0f, 456.0f)
                lineTo(80.0f, 224.0f)
                lineTo(272.0f, 224.0f)
                lineTo(272.0f, 176.0f)
                lineTo(80.0f, 176.0f)
                lineTo(80.0f, 88.0f)
                close()
                moveTo(368.0f, 288.0f)
                lineTo(560.0f, 288.0f)
                curveTo(586.5f, 288.0f, 608.0f, 266.5f, 608.0f, 240.0f)
                lineTo(608.0f, 144.0f)
                curveTo(608.0f, 117.5f, 586.5f, 96.0f, 560.0f, 96.0f)
                lineTo(477.3f, 96.0f)
                curveTo(468.8f, 96.0f, 460.7f, 92.6f, 454.7f, 86.6f)
                lineTo(446.1f, 78.0f)
                curveTo(437.1f, 69.0f, 424.9f, 63.9f, 412.2f, 63.9f)
                lineTo(368.0f, 64.0f)
                curveTo(341.5f, 64.0f, 320.0f, 85.5f, 320.0f, 112.0f)
                lineTo(320.0f, 240.0f)
                curveTo(320.0f, 266.5f, 341.5f, 288.0f, 368.0f, 288.0f)
                close()
                moveTo(368.0f, 576.0f)
                lineTo(560.0f, 576.0f)
                curveTo(586.5f, 576.0f, 608.0f, 554.5f, 608.0f, 528.0f)
                lineTo(608.0f, 432.0f)
                curveTo(608.0f, 405.5f, 586.5f, 384.0f, 560.0f, 384.0f)
                lineTo(477.3f, 384.0f)
                curveTo(468.8f, 384.0f, 460.7f, 380.6f, 454.7f, 374.6f)
                lineTo(446.1f, 366.0f)
                curveTo(437.1f, 357.0f, 424.9f, 351.9f, 412.2f, 351.9f)
                lineTo(368.0f, 352.0f)
                curveTo(341.5f, 352.0f, 320.0f, 373.5f, 320.0f, 400.0f)
                lineTo(320.0f, 528.0f)
                curveTo(320.0f, 554.5f, 341.5f, 576.0f, 368.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_folder-tree`!!
    }

private var `_folder-tree`: ImageVector? = null
