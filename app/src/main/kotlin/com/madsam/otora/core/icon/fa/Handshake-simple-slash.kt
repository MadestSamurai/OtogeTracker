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

public val Fa.`Handshake-simple-slash`: ImageVector
    get() {
        if (`_handshake-simple-slash` != null) {
            return `_handshake-simple-slash`!!
        }
        `_handshake-simple-slash` = Builder(name = "Handshake-simple-slash", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(312.9f, 279.2f)
                lineTo(327.1f, 265.0f)
                curveTo(331.3f, 260.8f, 336.6f, 258.5f, 342.0f, 258.1f)
                curveTo(348.8f, 257.5f, 355.8f, 259.8f, 361.0f, 265.0f)
                lineTo(537.6f, 440.0f)
                lineTo(608.0f, 384.0f)
                lineTo(608.0f, 96.0f)
                lineTo(496.0f, 160.0f)
                lineTo(472.2f, 144.1f)
                curveTo(456.4f, 133.6f, 437.9f, 128.0f, 418.9f, 128.0f)
                lineTo(348.5f, 128.0f)
                curveTo(347.4f, 128.0f, 346.2f, 128.0f, 345.1f, 128.1f)
                curveTo(328.2f, 129.0f, 312.3f, 136.6f, 300.9f, 149.2f)
                lineTo(245.1f, 211.3f)
                lineTo(211.1f, 177.3f)
                lineTo(255.4f, 128.1f)
                lineTo(215.7f, 128.1f)
                curveTo(200.4f, 128.1f, 185.6f, 131.7f, 172.2f, 138.5f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(32.0f, 133.8f)
                lineTo(32.0f, 384.0f)
                lineTo(188.4f, 514.3f)
                curveTo(211.4f, 533.5f, 240.4f, 544.0f, 270.3f, 544.0f)
                lineTo(286.0f, 544.0f)
                lineTo(279.0f, 537.0f)
                curveTo(269.6f, 527.6f, 269.6f, 512.4f, 279.0f, 503.1f)
                curveTo(288.4f, 493.8f, 303.6f, 493.7f, 312.9f, 503.1f)
                lineTo(353.9f, 544.1f)
                lineTo(362.9f, 544.1f)
                curveTo(385.1f, 544.1f, 406.7f, 538.3f, 425.7f, 527.7f)
                lineTo(32.0f, 133.8f)
                close()
            }
        }
        .build()
        return `_handshake-simple-slash`!!
    }

private var `_handshake-simple-slash`: ImageVector? = null
