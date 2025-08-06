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

public val Fa.`User-friends`: ImageVector
    get() {
        if (`_user-friends` != null) {
            return `_user-friends`!!
        }
        `_user-friends` = Builder(name = "User-friends", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 192.0f)
                curveTo(96.0f, 130.1f, 146.1f, 80.0f, 208.0f, 80.0f)
                curveTo(269.9f, 80.0f, 320.0f, 130.1f, 320.0f, 192.0f)
                curveTo(320.0f, 253.9f, 269.9f, 304.0f, 208.0f, 304.0f)
                curveTo(146.1f, 304.0f, 96.0f, 253.9f, 96.0f, 192.0f)
                close()
                moveTo(32.0f, 528.0f)
                curveTo(32.0f, 430.8f, 110.8f, 352.0f, 208.0f, 352.0f)
                curveTo(305.2f, 352.0f, 384.0f, 430.8f, 384.0f, 528.0f)
                lineTo(384.0f, 534.0f)
                curveTo(384.0f, 557.2f, 365.2f, 576.0f, 342.0f, 576.0f)
                lineTo(74.0f, 576.0f)
                curveTo(50.8f, 576.0f, 32.0f, 557.2f, 32.0f, 534.0f)
                lineTo(32.0f, 528.0f)
                close()
                moveTo(464.0f, 128.0f)
                curveTo(517.0f, 128.0f, 560.0f, 171.0f, 560.0f, 224.0f)
                curveTo(560.0f, 277.0f, 517.0f, 320.0f, 464.0f, 320.0f)
                curveTo(411.0f, 320.0f, 368.0f, 277.0f, 368.0f, 224.0f)
                curveTo(368.0f, 171.0f, 411.0f, 128.0f, 464.0f, 128.0f)
                close()
                moveTo(464.0f, 368.0f)
                curveTo(543.5f, 368.0f, 608.0f, 432.5f, 608.0f, 512.0f)
                lineTo(608.0f, 534.4f)
                curveTo(608.0f, 557.4f, 589.4f, 576.0f, 566.4f, 576.0f)
                lineTo(421.6f, 576.0f)
                curveTo(428.2f, 563.5f, 432.0f, 549.2f, 432.0f, 534.0f)
                lineTo(432.0f, 528.0f)
                curveTo(432.0f, 476.5f, 414.6f, 429.1f, 385.5f, 391.3f)
                curveTo(408.1f, 376.6f, 435.1f, 368.0f, 464.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_user-friends`!!
    }

private var `_user-friends`: ImageVector? = null
