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

public val Fa.`File-circle-check`: ImageVector
    get() {
        if (`_file-circle-check` != null) {
            return `_file-circle-check`!!
        }
        `_file-circle-check` = Builder(name = "File-circle-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(92.7f, 64.0f, 64.0f, 92.7f, 64.0f, 128.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                lineTo(308.0f, 576.0f)
                curveTo(285.3f, 544.5f, 272.0f, 505.8f, 272.0f, 464.0f)
                curveTo(272.0f, 363.4f, 349.4f, 280.8f, 448.0f, 272.7f)
                lineTo(448.0f, 234.6f)
                curveTo(448.0f, 217.6f, 441.3f, 201.3f, 429.3f, 189.3f)
                lineTo(322.7f, 82.7f)
                curveTo(310.7f, 70.7f, 294.5f, 64.0f, 277.5f, 64.0f)
                lineTo(128.0f, 64.0f)
                close()
                moveTo(389.5f, 240.0f)
                lineTo(296.0f, 240.0f)
                curveTo(282.7f, 240.0f, 272.0f, 229.3f, 272.0f, 216.0f)
                lineTo(272.0f, 122.5f)
                lineTo(389.5f, 240.0f)
                close()
                moveTo(608.0f, 464.0f)
                curveTo(608.0f, 384.5f, 543.5f, 320.0f, 464.0f, 320.0f)
                curveTo(384.5f, 320.0f, 320.0f, 384.5f, 320.0f, 464.0f)
                curveTo(320.0f, 543.5f, 384.5f, 608.0f, 464.0f, 608.0f)
                curveTo(543.5f, 608.0f, 608.0f, 543.5f, 608.0f, 464.0f)
                close()
                moveTo(521.4f, 403.1f)
                curveTo(528.5f, 408.3f, 530.1f, 418.3f, 524.9f, 425.4f)
                lineTo(460.9f, 513.4f)
                curveTo(458.1f, 517.2f, 453.9f, 519.6f, 449.2f, 519.9f)
                curveTo(444.5f, 520.2f, 439.9f, 518.6f, 436.6f, 515.3f)
                lineTo(396.6f, 475.3f)
                curveTo(390.4f, 469.1f, 390.4f, 458.9f, 396.6f, 452.7f)
                curveTo(402.8f, 446.5f, 413.0f, 446.5f, 419.2f, 452.7f)
                lineTo(446.0f, 479.5f)
                lineTo(499.0f, 406.6f)
                curveTo(504.2f, 399.5f, 514.2f, 397.9f, 521.4f, 403.1f)
                close()
            }
        }
        .build()
        return `_file-circle-check`!!
    }

private var `_file-circle-check`: ImageVector? = null
