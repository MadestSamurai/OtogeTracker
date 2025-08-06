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

public val Fa.Cat: ImageVector
    get() {
        if (_cat != null) {
            return _cat!!
        }
        _cat = Builder(name = "Cat", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 160.0f)
                curveTo(149.0f, 160.0f, 192.0f, 203.0f, 192.0f, 256.0f)
                lineTo(192.0f, 341.8f)
                curveTo(221.7f, 297.1f, 269.8f, 265.6f, 325.4f, 257.8f)
                curveTo(351.0f, 317.8f, 410.6f, 359.9f, 480.0f, 359.9f)
                curveTo(490.9f, 359.9f, 501.6f, 358.8f, 512.0f, 356.8f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                curveTo(462.3f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(448.0f, 403.2f)
                lineTo(312.0f, 512.0f)
                lineTo(368.0f, 512.0f)
                curveTo(385.7f, 512.0f, 400.0f, 526.3f, 400.0f, 544.0f)
                curveTo(400.0f, 561.7f, 385.7f, 576.0f, 368.0f, 576.0f)
                lineTo(224.0f, 576.0f)
                curveTo(171.0f, 576.0f, 128.0f, 533.0f, 128.0f, 480.0f)
                lineTo(128.0f, 256.0f)
                curveTo(128.0f, 239.4f, 115.4f, 225.8f, 99.3f, 224.2f)
                lineTo(92.7f, 223.9f)
                curveTo(76.6f, 222.2f, 64.0f, 208.6f, 64.0f, 192.0f)
                curveTo(64.0f, 174.3f, 78.3f, 160.0f, 96.0f, 160.0f)
                close()
                moveTo(565.8f, 67.2f)
                curveTo(576.2f, 58.5f, 592.0f, 65.9f, 592.0f, 79.5f)
                lineTo(592.0f, 192.0f)
                curveTo(592.0f, 253.9f, 541.9f, 304.0f, 480.0f, 304.0f)
                curveTo(418.1f, 304.0f, 368.0f, 253.9f, 368.0f, 192.0f)
                lineTo(368.0f, 79.5f)
                curveTo(368.0f, 65.9f, 383.8f, 58.5f, 394.2f, 67.2f)
                lineTo(448.0f, 112.0f)
                lineTo(512.0f, 112.0f)
                lineTo(565.8f, 67.2f)
                close()
                moveTo(432.0f, 172.0f)
                curveTo(421.0f, 172.0f, 412.0f, 181.0f, 412.0f, 192.0f)
                curveTo(412.0f, 203.0f, 421.0f, 212.0f, 432.0f, 212.0f)
                curveTo(443.0f, 212.0f, 452.0f, 203.0f, 452.0f, 192.0f)
                curveTo(452.0f, 181.0f, 443.0f, 172.0f, 432.0f, 172.0f)
                close()
                moveTo(528.0f, 172.0f)
                curveTo(517.0f, 172.0f, 508.0f, 181.0f, 508.0f, 192.0f)
                curveTo(508.0f, 203.0f, 517.0f, 212.0f, 528.0f, 212.0f)
                curveTo(539.0f, 212.0f, 548.0f, 203.0f, 548.0f, 192.0f)
                curveTo(548.0f, 181.0f, 539.0f, 172.0f, 528.0f, 172.0f)
                close()
            }
        }
        .build()
        return _cat!!
    }

private var _cat: ImageVector? = null
