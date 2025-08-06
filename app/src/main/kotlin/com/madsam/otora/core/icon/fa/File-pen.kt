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

public val Fa.`File-pen`: ImageVector
    get() {
        if (`_file-pen` != null) {
            return `_file-pen`!!
        }
        `_file-pen` = Builder(name = "File-pen", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.1f, 64.0f)
                curveTo(92.8f, 64.0f, 64.1f, 92.7f, 64.1f, 128.0f)
                lineTo(64.1f, 512.0f)
                curveTo(64.1f, 547.3f, 92.8f, 576.0f, 128.1f, 576.0f)
                lineTo(274.3f, 576.0f)
                lineTo(285.2f, 521.5f)
                curveTo(289.5f, 499.8f, 300.2f, 479.9f, 315.8f, 464.3f)
                lineTo(448.0f, 332.1f)
                lineTo(448.0f, 234.6f)
                curveTo(448.0f, 217.6f, 441.3f, 201.3f, 429.3f, 189.3f)
                lineTo(322.8f, 82.7f)
                curveTo(310.8f, 70.7f, 294.5f, 64.0f, 277.6f, 64.0f)
                lineTo(128.1f, 64.0f)
                close()
                moveTo(389.6f, 240.0f)
                lineTo(296.1f, 240.0f)
                curveTo(282.8f, 240.0f, 272.1f, 229.3f, 272.1f, 216.0f)
                lineTo(272.1f, 122.5f)
                lineTo(389.6f, 240.0f)
                close()
                moveTo(332.3f, 530.9f)
                lineTo(320.4f, 590.5f)
                curveTo(320.2f, 591.4f, 320.1f, 592.4f, 320.1f, 593.4f)
                curveTo(320.1f, 601.4f, 326.6f, 608.0f, 334.7f, 608.0f)
                curveTo(335.7f, 608.0f, 336.6f, 607.9f, 337.6f, 607.7f)
                lineTo(397.2f, 595.8f)
                curveTo(409.6f, 593.3f, 421.0f, 587.2f, 429.9f, 578.3f)
                lineTo(548.8f, 459.4f)
                lineTo(468.8f, 379.4f)
                lineTo(349.9f, 498.3f)
                curveTo(341.0f, 507.2f, 334.9f, 518.6f, 332.4f, 531.0f)
                close()
                moveTo(600.1f, 407.9f)
                curveTo(622.2f, 385.8f, 622.2f, 350.0f, 600.1f, 327.9f)
                curveTo(578.0f, 305.8f, 542.2f, 305.8f, 520.1f, 327.9f)
                lineTo(491.3f, 356.7f)
                lineTo(571.3f, 436.7f)
                lineTo(600.1f, 407.9f)
                close()
            }
        }
        .build()
        return `_file-pen`!!
    }

private var `_file-pen`: ImageVector? = null
