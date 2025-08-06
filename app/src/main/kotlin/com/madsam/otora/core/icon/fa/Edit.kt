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

public val Fa.Edit: ImageVector
    get() {
        if (_edit != null) {
            return _edit!!
        }
        _edit = Builder(name = "Edit", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(535.6f, 85.7f)
                curveTo(513.7f, 63.8f, 478.3f, 63.8f, 456.4f, 85.7f)
                lineTo(432.0f, 110.1f)
                lineTo(529.9f, 208.0f)
                lineTo(554.3f, 183.6f)
                curveTo(576.2f, 161.7f, 576.2f, 126.3f, 554.3f, 104.4f)
                lineTo(535.6f, 85.7f)
                close()
                moveTo(236.4f, 305.7f)
                curveTo(230.3f, 311.8f, 225.6f, 319.3f, 222.9f, 327.6f)
                lineTo(193.3f, 416.4f)
                curveTo(190.4f, 425.0f, 192.7f, 434.5f, 199.1f, 441.0f)
                curveTo(205.5f, 447.5f, 215.0f, 449.7f, 223.7f, 446.8f)
                lineTo(312.5f, 417.2f)
                curveTo(320.7f, 414.5f, 328.2f, 409.8f, 334.4f, 403.7f)
                lineTo(496.0f, 241.9f)
                lineTo(398.1f, 144.0f)
                lineTo(236.4f, 305.7f)
                close()
                moveTo(160.0f, 128.0f)
                curveTo(107.0f, 128.0f, 64.0f, 171.0f, 64.0f, 224.0f)
                lineTo(64.0f, 480.0f)
                curveTo(64.0f, 533.0f, 107.0f, 576.0f, 160.0f, 576.0f)
                lineTo(416.0f, 576.0f)
                curveTo(469.0f, 576.0f, 512.0f, 533.0f, 512.0f, 480.0f)
                lineTo(512.0f, 384.0f)
                curveTo(512.0f, 366.3f, 497.7f, 352.0f, 480.0f, 352.0f)
                curveTo(462.3f, 352.0f, 448.0f, 366.3f, 448.0f, 384.0f)
                lineTo(448.0f, 480.0f)
                curveTo(448.0f, 497.7f, 433.7f, 512.0f, 416.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                curveTo(142.3f, 512.0f, 128.0f, 497.7f, 128.0f, 480.0f)
                lineTo(128.0f, 224.0f)
                curveTo(128.0f, 206.3f, 142.3f, 192.0f, 160.0f, 192.0f)
                lineTo(256.0f, 192.0f)
                curveTo(273.7f, 192.0f, 288.0f, 177.7f, 288.0f, 160.0f)
                curveTo(288.0f, 142.3f, 273.7f, 128.0f, 256.0f, 128.0f)
                lineTo(160.0f, 128.0f)
                close()
            }
        }
        .build()
        return _edit!!
    }

private var _edit: ImageVector? = null
