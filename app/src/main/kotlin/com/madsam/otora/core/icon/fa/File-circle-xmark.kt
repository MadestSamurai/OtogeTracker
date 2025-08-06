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

public val Fa.`File-circle-xmark`: ImageVector
    get() {
        if (`_file-circle-xmark` != null) {
            return `_file-circle-xmark`!!
        }
        `_file-circle-xmark` = Builder(name = "File-circle-xmark", defaultWidth = 640.0.dp,
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
                moveTo(464.0f, 608.0f)
                curveTo(543.5f, 608.0f, 608.0f, 543.5f, 608.0f, 464.0f)
                curveTo(608.0f, 384.5f, 543.5f, 320.0f, 464.0f, 320.0f)
                curveTo(384.5f, 320.0f, 320.0f, 384.5f, 320.0f, 464.0f)
                curveTo(320.0f, 543.5f, 384.5f, 608.0f, 464.0f, 608.0f)
                close()
                moveTo(523.3f, 427.3f)
                lineTo(486.6f, 464.0f)
                lineTo(523.3f, 500.7f)
                curveTo(529.5f, 506.9f, 529.5f, 517.1f, 523.3f, 523.3f)
                curveTo(517.1f, 529.5f, 506.9f, 529.5f, 500.7f, 523.3f)
                lineTo(464.0f, 486.6f)
                lineTo(427.3f, 523.3f)
                curveTo(421.1f, 529.5f, 410.9f, 529.5f, 404.7f, 523.3f)
                curveTo(398.5f, 517.1f, 398.5f, 506.9f, 404.7f, 500.7f)
                lineTo(441.4f, 464.0f)
                lineTo(404.7f, 427.3f)
                curveTo(398.5f, 421.1f, 398.5f, 410.9f, 404.7f, 404.7f)
                curveTo(410.9f, 398.5f, 421.1f, 398.5f, 427.3f, 404.7f)
                lineTo(464.0f, 441.4f)
                lineTo(500.7f, 404.7f)
                curveTo(506.9f, 398.5f, 517.1f, 398.5f, 523.3f, 404.7f)
                curveTo(529.5f, 410.9f, 529.5f, 421.1f, 523.3f, 427.3f)
                close()
            }
        }
        .build()
        return `_file-circle-xmark`!!
    }

private var `_file-circle-xmark`: ImageVector? = null
