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

public val Fa.`User-pen`: ImageVector
    get() {
        if (`_user-pen` != null) {
            return `_user-pen`!!
        }
        `_user-pen` = Builder(name = "User-pen", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.1f, 312.0f)
                curveTo(322.4f, 312.0f, 376.1f, 258.3f, 376.1f, 192.0f)
                curveTo(376.1f, 125.7f, 322.4f, 72.0f, 256.1f, 72.0f)
                curveTo(189.8f, 72.0f, 136.1f, 125.7f, 136.1f, 192.0f)
                curveTo(136.1f, 258.3f, 189.8f, 312.0f, 256.1f, 312.0f)
                close()
                moveTo(226.4f, 368.0f)
                curveTo(127.9f, 368.0f, 48.1f, 447.8f, 48.1f, 546.3f)
                curveTo(48.1f, 562.7f, 61.4f, 576.0f, 77.8f, 576.0f)
                lineTo(274.3f, 576.0f)
                lineTo(285.2f, 521.5f)
                curveTo(289.5f, 499.8f, 300.2f, 479.9f, 315.8f, 464.3f)
                lineTo(383.1f, 397.0f)
                curveTo(355.1f, 378.7f, 321.7f, 368.1f, 285.7f, 368.1f)
                lineTo(226.3f, 368.1f)
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
        return `_user-pen`!!
    }

private var `_user-pen`: ImageVector? = null
