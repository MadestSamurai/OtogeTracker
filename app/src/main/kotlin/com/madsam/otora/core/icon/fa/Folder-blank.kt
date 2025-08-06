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

public val Fa.`Folder-blank`: ImageVector
    get() {
        if (`_folder-blank` != null) {
            return `_folder-blank`!!
        }
        `_folder-blank` = Builder(name = "Folder-blank", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 208.0f)
                curveTo(576.0f, 172.7f, 547.3f, 144.0f, 512.0f, 144.0f)
                lineTo(362.7f, 144.0f)
                curveTo(355.8f, 144.0f, 349.0f, 141.8f, 343.5f, 137.6f)
                lineTo(305.1f, 108.8f)
                curveTo(294.0f, 100.5f, 280.5f, 96.0f, 266.7f, 96.0f)
                lineTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_folder-blank`!!
    }

private var `_folder-blank`: ImageVector? = null
