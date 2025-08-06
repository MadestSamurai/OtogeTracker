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

public val Fa.Section: ImageVector
    get() {
        if (_section != null) {
            return _section!!
        }
        _section = Builder(name = "Section", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(302.0f, 64.0f)
                curveTo(241.2f, 64.0f, 192.0f, 113.2f, 192.0f, 174.0f)
                curveTo(192.0f, 197.7f, 199.6f, 219.8f, 212.5f, 238.0f)
                curveTo(199.6f, 256.0f, 192.0f, 278.1f, 192.0f, 302.0f)
                curveTo(192.0f, 355.7f, 230.9f, 401.6f, 283.9f, 410.4f)
                lineTo(345.6f, 420.7f)
                curveTo(367.8f, 424.4f, 384.0f, 443.6f, 384.0f, 466.0f)
                curveTo(384.0f, 491.4f, 363.4f, 512.0f, 338.0f, 512.0f)
                lineTo(240.0f, 512.0f)
                curveTo(222.3f, 512.0f, 208.0f, 526.3f, 208.0f, 544.0f)
                curveTo(208.0f, 561.7f, 222.3f, 576.0f, 240.0f, 576.0f)
                lineTo(338.0f, 576.0f)
                curveTo(398.7f, 576.0f, 448.0f, 526.8f, 448.0f, 466.0f)
                curveTo(448.0f, 442.3f, 440.4f, 420.1f, 427.5f, 402.0f)
                curveTo(440.4f, 384.0f, 448.0f, 361.9f, 448.0f, 338.0f)
                curveTo(448.0f, 284.2f, 409.1f, 238.4f, 356.1f, 229.5f)
                lineTo(294.4f, 219.2f)
                curveTo(272.2f, 215.6f, 256.0f, 196.4f, 256.0f, 174.0f)
                curveTo(256.0f, 148.6f, 276.6f, 128.0f, 302.0f, 128.0f)
                lineTo(400.0f, 128.0f)
                curveTo(417.7f, 128.0f, 432.0f, 113.7f, 432.0f, 96.0f)
                curveTo(432.0f, 78.3f, 417.7f, 64.0f, 400.0f, 64.0f)
                lineTo(302.0f, 64.0f)
                close()
                moveTo(376.7f, 363.1f)
                curveTo(370.2f, 360.7f, 363.3f, 358.8f, 356.2f, 357.6f)
                lineTo(294.5f, 347.3f)
                curveTo(272.3f, 343.6f, 256.1f, 324.4f, 256.1f, 302.0f)
                curveTo(256.1f, 292.8f, 258.8f, 284.2f, 263.5f, 277.0f)
                curveTo(270.0f, 279.4f, 276.9f, 281.3f, 284.0f, 282.5f)
                lineTo(345.7f, 292.8f)
                curveTo(367.9f, 296.5f, 384.1f, 315.7f, 384.1f, 338.1f)
                curveTo(384.1f, 347.3f, 381.4f, 355.9f, 376.7f, 363.1f)
                close()
            }
        }
        .build()
        return _section!!
    }

private var _section: ImageVector? = null
