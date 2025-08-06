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

public val Fa.`Folder-plus`: ImageVector
    get() {
        if (`_folder-plus` != null) {
            return `_folder-plus`!!
        }
        `_folder-plus` = Builder(name = "Folder-plus", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 448.0f)
                curveTo(576.0f, 483.3f, 547.3f, 512.0f, 512.0f, 512.0f)
                lineTo(128.0f, 512.0f)
                curveTo(92.7f, 512.0f, 64.0f, 483.3f, 64.0f, 448.0f)
                lineTo(64.0f, 160.0f)
                curveTo(64.0f, 124.7f, 92.7f, 96.0f, 128.0f, 96.0f)
                lineTo(266.7f, 96.0f)
                curveTo(280.5f, 96.0f, 294.0f, 100.5f, 305.1f, 108.8f)
                lineTo(343.5f, 137.6f)
                curveTo(349.0f, 141.8f, 355.8f, 144.0f, 362.7f, 144.0f)
                lineTo(512.0f, 144.0f)
                curveTo(547.3f, 144.0f, 576.0f, 172.7f, 576.0f, 208.0f)
                lineTo(576.0f, 448.0f)
                close()
                moveTo(320.0f, 224.0f)
                curveTo(306.7f, 224.0f, 296.0f, 234.7f, 296.0f, 248.0f)
                lineTo(296.0f, 296.0f)
                lineTo(248.0f, 296.0f)
                curveTo(234.7f, 296.0f, 224.0f, 306.7f, 224.0f, 320.0f)
                curveTo(224.0f, 333.3f, 234.7f, 344.0f, 248.0f, 344.0f)
                lineTo(296.0f, 344.0f)
                lineTo(296.0f, 392.0f)
                curveTo(296.0f, 405.3f, 306.7f, 416.0f, 320.0f, 416.0f)
                curveTo(333.3f, 416.0f, 344.0f, 405.3f, 344.0f, 392.0f)
                lineTo(344.0f, 344.0f)
                lineTo(392.0f, 344.0f)
                curveTo(405.3f, 344.0f, 416.0f, 333.3f, 416.0f, 320.0f)
                curveTo(416.0f, 306.7f, 405.3f, 296.0f, 392.0f, 296.0f)
                lineTo(344.0f, 296.0f)
                lineTo(344.0f, 248.0f)
                curveTo(344.0f, 234.7f, 333.3f, 224.0f, 320.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_folder-plus`!!
    }

private var `_folder-plus`: ImageVector? = null
