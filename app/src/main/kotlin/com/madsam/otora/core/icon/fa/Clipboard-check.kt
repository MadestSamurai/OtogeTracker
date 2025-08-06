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

public val Fa.`Clipboard-check`: ImageVector
    get() {
        if (`_clipboard-check` != null) {
            return `_clipboard-check`!!
        }
        `_clipboard-check` = Builder(name = "Clipboard-check", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(439.4f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(483.3f, 96.0f, 512.0f, 124.7f, 512.0f, 160.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 160.0f)
                curveTo(128.0f, 124.7f, 156.7f, 96.0f, 192.0f, 96.0f)
                lineTo(200.6f, 96.0f)
                curveTo(211.6f, 76.9f, 232.3f, 64.0f, 256.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                curveTo(407.7f, 64.0f, 428.4f, 76.9f, 439.4f, 96.0f)
                close()
                moveTo(376.0f, 176.0f)
                curveTo(389.3f, 176.0f, 400.0f, 165.3f, 400.0f, 152.0f)
                curveTo(400.0f, 138.7f, 389.3f, 128.0f, 376.0f, 128.0f)
                lineTo(264.0f, 128.0f)
                curveTo(250.7f, 128.0f, 240.0f, 138.7f, 240.0f, 152.0f)
                curveTo(240.0f, 165.3f, 250.7f, 176.0f, 264.0f, 176.0f)
                lineTo(376.0f, 176.0f)
                close()
                moveTo(404.4f, 324.7f)
                curveTo(411.4f, 313.5f, 408.0f, 298.7f, 396.8f, 291.6f)
                curveTo(385.6f, 284.5f, 370.8f, 288.0f, 363.7f, 299.2f)
                lineTo(302.3f, 397.5f)
                lineTo(275.3f, 361.5f)
                curveTo(267.3f, 350.9f, 252.3f, 348.7f, 241.7f, 356.7f)
                curveTo(231.1f, 364.7f, 228.9f, 379.7f, 236.9f, 390.3f)
                lineTo(284.9f, 454.3f)
                curveTo(289.6f, 460.6f, 297.2f, 464.2f, 305.1f, 463.9f)
                curveTo(313.0f, 463.6f, 320.2f, 459.4f, 324.4f, 452.6f)
                lineTo(404.4f, 324.6f)
                close()
            }
        }
        .build()
        return `_clipboard-check`!!
    }

private var `_clipboard-check`: ImageVector? = null
