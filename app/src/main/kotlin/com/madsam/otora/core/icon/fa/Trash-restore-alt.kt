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

public val Fa.`Trash-restore-alt`: ImageVector
    get() {
        if (`_trash-restore-alt` != null) {
            return `_trash-restore-alt`!!
        }
        `_trash-restore-alt` = Builder(name = "Trash-restore-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(263.1f, 48.0f)
                lineTo(377.0f, 48.0f)
                curveTo(390.8f, 48.0f, 403.0f, 56.8f, 407.4f, 69.9f)
                lineTo(416.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(529.7f, 96.0f, 544.0f, 110.3f, 544.0f, 128.0f)
                curveTo(544.0f, 145.7f, 529.7f, 160.0f, 512.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                curveTo(110.3f, 160.0f, 96.0f, 145.7f, 96.0f, 128.0f)
                curveTo(96.0f, 110.3f, 110.3f, 96.0f, 128.0f, 96.0f)
                lineTo(224.0f, 96.0f)
                lineTo(232.7f, 69.9f)
                curveTo(237.1f, 56.8f, 249.3f, 48.0f, 263.1f, 48.0f)
                close()
                moveTo(128.0f, 208.0f)
                lineTo(512.0f, 208.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 208.0f)
                close()
                moveTo(337.0f, 287.0f)
                curveTo(327.6f, 277.6f, 312.4f, 277.6f, 303.1f, 287.0f)
                lineTo(231.1f, 359.0f)
                curveTo(221.7f, 368.4f, 221.7f, 383.6f, 231.1f, 392.9f)
                curveTo(240.5f, 402.2f, 255.7f, 402.3f, 265.0f, 392.9f)
                lineTo(296.0f, 361.9f)
                lineTo(296.0f, 464.0f)
                curveTo(296.0f, 477.3f, 306.7f, 488.0f, 320.0f, 488.0f)
                curveTo(333.3f, 488.0f, 344.0f, 477.3f, 344.0f, 464.0f)
                lineTo(344.0f, 361.9f)
                lineTo(375.0f, 392.9f)
                curveTo(384.4f, 402.3f, 399.6f, 402.3f, 408.9f, 392.9f)
                curveTo(418.2f, 383.5f, 418.3f, 368.3f, 408.9f, 359.0f)
                lineTo(336.9f, 287.0f)
                close()
            }
        }
        .build()
        return `_trash-restore-alt`!!
    }

private var `_trash-restore-alt`: ImageVector? = null
