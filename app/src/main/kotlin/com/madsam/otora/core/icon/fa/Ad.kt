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

public val Fa.Ad: ImageVector
    get() {
        if (_ad != null) {
            return _ad!!
        }
        _ad = Builder(name = "Ad", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth
                = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(480.0f, 248.0f)
                lineTo(480.0f, 392.0f)
                curveTo(480.0f, 405.3f, 469.3f, 416.0f, 456.0f, 416.0f)
                curveTo(448.9f, 416.0f, 442.5f, 412.9f, 438.1f, 408.0f)
                curveTo(427.9f, 413.1f, 416.3f, 416.0f, 404.0f, 416.0f)
                curveTo(362.0f, 416.0f, 328.0f, 382.0f, 328.0f, 340.0f)
                curveTo(328.0f, 298.0f, 362.0f, 264.0f, 404.0f, 264.0f)
                curveTo(413.9f, 264.0f, 423.3f, 265.9f, 432.0f, 269.3f)
                lineTo(432.0f, 248.0f)
                curveTo(432.0f, 234.7f, 442.7f, 224.0f, 456.0f, 224.0f)
                curveTo(469.3f, 224.0f, 480.0f, 234.7f, 480.0f, 248.0f)
                close()
                moveTo(432.0f, 340.0f)
                curveTo(432.0f, 324.5f, 419.5f, 312.0f, 404.0f, 312.0f)
                curveTo(388.5f, 312.0f, 376.0f, 324.5f, 376.0f, 340.0f)
                curveTo(376.0f, 355.5f, 388.5f, 368.0f, 404.0f, 368.0f)
                curveTo(419.5f, 368.0f, 432.0f, 355.5f, 432.0f, 340.0f)
                close()
                moveTo(224.0f, 272.0f)
                curveTo(215.2f, 272.0f, 208.0f, 279.2f, 208.0f, 288.0f)
                lineTo(208.0f, 320.0f)
                lineTo(256.0f, 320.0f)
                lineTo(256.0f, 288.0f)
                curveTo(256.0f, 279.2f, 248.8f, 272.0f, 240.0f, 272.0f)
                lineTo(224.0f, 272.0f)
                close()
                moveTo(256.0f, 368.0f)
                lineTo(208.0f, 368.0f)
                lineTo(208.0f, 392.0f)
                curveTo(208.0f, 405.3f, 197.3f, 416.0f, 184.0f, 416.0f)
                curveTo(170.7f, 416.0f, 160.0f, 405.3f, 160.0f, 392.0f)
                lineTo(160.0f, 288.0f)
                curveTo(160.0f, 252.7f, 188.7f, 224.0f, 224.0f, 224.0f)
                lineTo(240.0f, 224.0f)
                curveTo(275.3f, 224.0f, 304.0f, 252.7f, 304.0f, 288.0f)
                lineTo(304.0f, 392.0f)
                curveTo(304.0f, 405.3f, 293.3f, 416.0f, 280.0f, 416.0f)
                curveTo(266.7f, 416.0f, 256.0f, 405.3f, 256.0f, 392.0f)
                lineTo(256.0f, 368.0f)
                close()
            }
        }
        .build()
        return _ad!!
    }

private var _ad: ImageVector? = null
