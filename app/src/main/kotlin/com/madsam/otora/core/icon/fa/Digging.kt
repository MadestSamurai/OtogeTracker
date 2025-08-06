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

public val Fa.Digging: ImageVector
    get() {
        if (_digging != null) {
            return _digging!!
        }
        _digging = Builder(name = "Digging", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 104.0f)
                curveTo(240.0f, 73.1f, 265.1f, 48.0f, 296.0f, 48.0f)
                curveTo(326.9f, 48.0f, 352.0f, 73.1f, 352.0f, 104.0f)
                curveTo(352.0f, 134.9f, 326.9f, 160.0f, 296.0f, 160.0f)
                curveTo(265.1f, 160.0f, 240.0f, 134.9f, 240.0f, 104.0f)
                close()
                moveTo(42.5f, 245.3f)
                curveTo(48.4f, 233.4f, 62.8f, 228.6f, 74.7f, 234.6f)
                lineTo(99.3f, 246.9f)
                lineTo(111.5f, 226.5f)
                curveTo(130.4f, 195.0f, 164.7f, 176.0f, 201.1f, 176.0f)
                curveTo(247.3f, 176.0f, 288.8f, 206.5f, 301.6f, 251.4f)
                lineTo(333.8f, 364.1f)
                lineTo(426.7f, 410.5f)
                lineTo(452.5f, 367.5f)
                curveTo(458.3f, 357.9f, 468.7f, 352.0f, 479.9f, 352.0f)
                curveTo(491.1f, 352.0f, 501.6f, 357.9f, 507.3f, 367.5f)
                lineTo(603.3f, 527.5f)
                curveTo(609.2f, 537.4f, 609.4f, 549.7f, 603.7f, 559.7f)
                curveTo(598.0f, 569.7f, 587.5f, 576.0f, 576.0f, 576.0f)
                lineTo(384.0f, 576.0f)
                curveTo(372.5f, 576.0f, 361.8f, 569.8f, 356.2f, 559.8f)
                curveTo(350.6f, 549.8f, 350.7f, 537.5f, 356.6f, 527.6f)
                lineTo(402.0f, 451.8f)
                lineTo(53.3f, 277.5f)
                curveTo(41.4f, 271.6f, 36.6f, 257.2f, 42.6f, 245.3f)
                close()
                moveTo(126.3f, 371.4f)
                lineTo(238.3f, 427.4f)
                curveTo(249.1f, 432.8f, 256.0f, 443.9f, 256.0f, 456.0f)
                lineTo(256.0f, 544.0f)
                curveTo(256.0f, 561.7f, 241.7f, 576.0f, 224.0f, 576.0f)
                curveTo(206.3f, 576.0f, 192.0f, 561.7f, 192.0f, 544.0f)
                lineTo(192.0f, 475.8f)
                lineTo(130.7f, 445.1f)
                lineTo(94.4f, 554.1f)
                curveTo(88.8f, 570.9f, 70.7f, 579.9f, 53.9f, 574.3f)
                curveTo(37.1f, 568.7f, 28.1f, 550.6f, 33.7f, 533.9f)
                lineTo(81.7f, 389.9f)
                curveTo(84.6f, 381.1f, 91.2f, 374.0f, 99.8f, 370.5f)
                curveTo(108.4f, 367.0f, 118.1f, 367.3f, 126.4f, 371.4f)
                close()
            }
        }
        .build()
        return _digging!!
    }

private var _digging: ImageVector? = null
