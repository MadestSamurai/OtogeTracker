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

public val Fa.`User-clock`: ImageVector
    get() {
        if (`_user-clock` != null) {
            return `_user-clock`!!
        }
        `_user-clock` = Builder(name = "User-clock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 72.0f)
                curveTo(322.3f, 72.0f, 376.0f, 125.7f, 376.0f, 192.0f)
                curveTo(376.0f, 258.3f, 322.3f, 312.0f, 256.0f, 312.0f)
                curveTo(189.7f, 312.0f, 136.0f, 258.3f, 136.0f, 192.0f)
                curveTo(136.0f, 125.7f, 189.7f, 72.0f, 256.0f, 72.0f)
                close()
                moveTo(226.3f, 368.0f)
                lineTo(285.7f, 368.0f)
                curveTo(289.6f, 368.0f, 293.6f, 368.1f, 297.5f, 368.4f)
                curveTo(281.3f, 396.6f, 272.0f, 429.2f, 272.0f, 464.0f)
                curveTo(272.0f, 505.8f, 285.4f, 544.5f, 308.0f, 576.0f)
                lineTo(77.7f, 576.0f)
                curveTo(61.3f, 576.0f, 48.0f, 562.7f, 48.0f, 546.3f)
                curveTo(48.0f, 447.8f, 127.8f, 368.0f, 226.3f, 368.0f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(320.0f, 384.5f, 384.5f, 320.0f, 464.0f, 320.0f)
                curveTo(543.5f, 320.0f, 608.0f, 384.5f, 608.0f, 464.0f)
                curveTo(608.0f, 543.5f, 543.5f, 608.0f, 464.0f, 608.0f)
                curveTo(384.5f, 608.0f, 320.0f, 543.5f, 320.0f, 464.0f)
                close()
                moveTo(464.0f, 384.0f)
                curveTo(455.2f, 384.0f, 448.0f, 391.2f, 448.0f, 400.0f)
                lineTo(448.0f, 464.0f)
                curveTo(448.0f, 472.8f, 455.2f, 480.0f, 464.0f, 480.0f)
                lineTo(512.0f, 480.0f)
                curveTo(520.8f, 480.0f, 528.0f, 472.8f, 528.0f, 464.0f)
                curveTo(528.0f, 455.2f, 520.8f, 448.0f, 512.0f, 448.0f)
                lineTo(480.0f, 448.0f)
                lineTo(480.0f, 400.0f)
                curveTo(480.0f, 391.2f, 472.8f, 384.0f, 464.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_user-clock`!!
    }

private var `_user-clock`: ImageVector? = null
