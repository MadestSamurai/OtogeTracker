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

public val Fa.`Undo-alt`: ImageVector
    get() {
        if (`_undo-alt` != null) {
            return `_undo-alt`!!
        }
        `_undo-alt` = Builder(name = "Undo-alt", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(88.0f, 256.0f)
                lineTo(232.0f, 256.0f)
                curveTo(241.7f, 256.0f, 250.5f, 250.2f, 254.2f, 241.2f)
                curveTo(257.9f, 232.2f, 255.9f, 221.9f, 249.0f, 215.0f)
                lineTo(202.3f, 168.3f)
                curveTo(277.6f, 109.7f, 386.6f, 115.0f, 455.8f, 184.2f)
                curveTo(530.8f, 259.2f, 530.8f, 380.7f, 455.8f, 455.7f)
                curveTo(380.8f, 530.7f, 259.3f, 530.7f, 184.3f, 455.7f)
                curveTo(174.1f, 445.5f, 165.3f, 434.4f, 157.9f, 422.7f)
                curveTo(148.4f, 407.8f, 128.6f, 403.4f, 113.7f, 412.9f)
                curveTo(98.8f, 422.4f, 94.4f, 442.2f, 103.9f, 457.1f)
                curveTo(113.7f, 472.7f, 125.4f, 487.5f, 139.0f, 501.0f)
                curveTo(239.0f, 601.0f, 401.0f, 601.0f, 501.0f, 501.0f)
                curveTo(601.0f, 401.0f, 601.0f, 239.0f, 501.0f, 139.0f)
                curveTo(406.8f, 44.7f, 257.3f, 39.3f, 156.7f, 122.8f)
                lineTo(105.0f, 71.0f)
                curveTo(98.1f, 64.2f, 87.8f, 62.1f, 78.8f, 65.8f)
                curveTo(69.8f, 69.5f, 64.0f, 78.3f, 64.0f, 88.0f)
                lineTo(64.0f, 232.0f)
                curveTo(64.0f, 245.3f, 74.7f, 256.0f, 88.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_undo-alt`!!
    }

private var `_undo-alt`: ImageVector? = null
