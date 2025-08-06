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

public val Fa.`File-circle-exclamation`: ImageVector
    get() {
        if (`_file-circle-exclamation` != null) {
            return `_file-circle-exclamation`!!
        }
        `_file-circle-exclamation` = Builder(name = "File-circle-exclamation", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
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
                moveTo(464.0f, 608.0f)
                curveTo(543.5f, 608.0f, 608.0f, 543.5f, 608.0f, 464.0f)
                curveTo(608.0f, 384.5f, 543.5f, 320.0f, 464.0f, 320.0f)
                curveTo(384.5f, 320.0f, 320.0f, 384.5f, 320.0f, 464.0f)
                curveTo(320.0f, 543.5f, 384.5f, 608.0f, 464.0f, 608.0f)
                close()
                moveTo(464.0f, 508.0f)
                curveTo(475.0f, 508.0f, 484.0f, 517.0f, 484.0f, 528.0f)
                curveTo(484.0f, 539.0f, 475.0f, 548.0f, 464.0f, 548.0f)
                curveTo(453.0f, 548.0f, 444.0f, 539.0f, 444.0f, 528.0f)
                curveTo(444.0f, 517.0f, 453.0f, 508.0f, 464.0f, 508.0f)
                close()
                moveTo(464.0f, 368.0f)
                curveTo(472.8f, 368.0f, 480.0f, 375.2f, 480.0f, 384.0f)
                lineTo(480.0f, 464.0f)
                curveTo(480.0f, 472.8f, 472.8f, 480.0f, 464.0f, 480.0f)
                curveTo(455.2f, 480.0f, 448.0f, 472.8f, 448.0f, 464.0f)
                lineTo(448.0f, 384.0f)
                curveTo(448.0f, 375.2f, 455.2f, 368.0f, 464.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_file-circle-exclamation`!!
    }

private var `_file-circle-exclamation`: ImageVector? = null
