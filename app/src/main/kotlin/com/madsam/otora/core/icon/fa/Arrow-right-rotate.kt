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

public val Fa.`Arrow-right-rotate`: ImageVector
    get() {
        if (`_arrow-right-rotate` != null) {
            return `_arrow-right-rotate`!!
        }
        `_arrow-right-rotate` = Builder(name = "Arrow-right-rotate", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(500.7f, 138.7f)
                lineTo(512.0f, 149.4f)
                lineTo(512.0f, 96.0f)
                curveTo(512.0f, 78.3f, 526.3f, 64.0f, 544.0f, 64.0f)
                curveTo(561.7f, 64.0f, 576.0f, 78.3f, 576.0f, 96.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 241.7f, 561.7f, 256.0f, 544.0f, 256.0f)
                lineTo(416.0f, 256.0f)
                curveTo(398.3f, 256.0f, 384.0f, 241.7f, 384.0f, 224.0f)
                curveTo(384.0f, 206.3f, 398.3f, 192.0f, 416.0f, 192.0f)
                lineTo(463.9f, 192.0f)
                lineTo(456.3f, 184.8f)
                curveTo(456.1f, 184.6f, 455.9f, 184.4f, 455.7f, 184.2f)
                curveTo(380.7f, 109.2f, 259.2f, 109.2f, 184.2f, 184.2f)
                curveTo(109.2f, 259.2f, 109.2f, 380.7f, 184.2f, 455.7f)
                curveTo(259.2f, 530.7f, 380.7f, 530.7f, 455.7f, 455.7f)
                curveTo(463.9f, 447.5f, 471.2f, 438.8f, 477.6f, 429.6f)
                curveTo(487.7f, 415.1f, 507.7f, 411.6f, 522.2f, 421.7f)
                curveTo(536.7f, 431.8f, 540.2f, 451.8f, 530.1f, 466.3f)
                curveTo(521.6f, 478.5f, 511.9f, 490.1f, 501.0f, 501.0f)
                curveTo(401.0f, 601.0f, 238.9f, 601.0f, 139.0f, 501.0f)
                curveTo(39.1f, 401.0f, 39.0f, 239.0f, 139.0f, 139.0f)
                curveTo(238.9f, 39.1f, 400.7f, 39.0f, 500.7f, 138.7f)
                close()
            }
        }
        .build()
        return `_arrow-right-rotate`!!
    }

private var `_arrow-right-rotate`: ImageVector? = null
