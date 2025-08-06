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

public val Fa.`Chess-knight`: ImageVector
    get() {
        if (`_chess-knight` != null) {
            return `_chess-knight`!!
        }
        `_chess-knight` = Builder(name = "Chess-knight", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 32.0f)
                curveTo(426.0f, 32.0f, 512.0f, 118.0f, 512.0f, 224.0f)
                lineTo(512.0f, 357.5f)
                curveTo(512.0f, 374.5f, 505.2f, 390.7f, 493.3f, 402.7f)
                lineTo(448.0f, 448.0f)
                lineTo(498.8f, 498.7f)
                curveTo(507.3f, 507.2f, 512.0f, 518.7f, 512.0f, 530.7f)
                curveTo(512.0f, 555.7f, 491.7f, 575.9f, 466.8f, 576.0f)
                lineTo(173.3f, 576.0f)
                curveTo(148.3f, 576.0f, 128.1f, 555.7f, 128.1f, 530.7f)
                curveTo(128.1f, 518.7f, 132.9f, 507.2f, 141.3f, 498.7f)
                lineTo(192.0f, 448.0f)
                lineTo(192.0f, 413.4f)
                curveTo(192.0f, 394.7f, 200.2f, 377.0f, 214.3f, 364.8f)
                lineTo(304.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                lineTo(243.9f, 300.1f)
                curveTo(231.2f, 312.8f, 213.9f, 320.0f, 195.9f, 320.0f)
                curveTo(158.4f, 320.0f, 128.0f, 289.6f, 128.0f, 252.1f)
                lineTo(128.0f, 243.4f)
                curveTo(128.0f, 220.6f, 136.2f, 198.5f, 151.1f, 181.1f)
                lineTo(224.0f, 96.0f)
                lineTo(224.0f, 64.0f)
                curveTo(224.0f, 46.3f, 238.3f, 32.0f, 256.0f, 32.0f)
                lineTo(320.0f, 32.0f)
                close()
                moveTo(288.0f, 136.0f)
                curveTo(274.7f, 136.0f, 264.0f, 146.7f, 264.0f, 160.0f)
                curveTo(264.0f, 173.3f, 274.7f, 184.0f, 288.0f, 184.0f)
                curveTo(301.3f, 184.0f, 312.0f, 173.3f, 312.0f, 160.0f)
                curveTo(312.0f, 146.7f, 301.3f, 136.0f, 288.0f, 136.0f)
                close()
            }
        }
        .build()
        return `_chess-knight`!!
    }

private var `_chess-knight`: ImageVector? = null
