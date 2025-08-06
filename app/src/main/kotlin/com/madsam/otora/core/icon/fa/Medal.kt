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

public val Fa.Medal: ImageVector
    get() {
        if (_medal != null) {
            return _medal!!
        }
        _medal = Builder(name = "Medal", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.3f, 192.0f)
                lineTo(235.7f, 51.1f)
                curveTo(229.2f, 40.3f, 215.6f, 36.4f, 204.4f, 42.0f)
                lineTo(117.8f, 85.3f)
                curveTo(105.9f, 91.2f, 101.1f, 105.6f, 107.0f, 117.5f)
                lineTo(176.6f, 256.6f)
                curveTo(146.5f, 290.5f, 128.3f, 335.1f, 128.3f, 384.0f)
                curveTo(128.3f, 490.0f, 214.3f, 576.0f, 320.3f, 576.0f)
                curveTo(426.3f, 576.0f, 512.3f, 490.0f, 512.3f, 384.0f)
                curveTo(512.3f, 335.1f, 494.0f, 290.5f, 464.0f, 256.6f)
                lineTo(533.6f, 117.5f)
                curveTo(539.5f, 105.6f, 534.7f, 91.2f, 522.9f, 85.3f)
                lineTo(436.2f, 41.9f)
                curveTo(425.0f, 36.3f, 411.3f, 40.3f, 404.9f, 51.0f)
                lineTo(320.3f, 192.0f)
                close()
                moveTo(351.1f, 334.5f)
                curveTo(352.5f, 337.3f, 355.1f, 339.2f, 358.1f, 339.6f)
                lineTo(408.2f, 346.9f)
                curveTo(415.9f, 348.0f, 418.9f, 357.4f, 413.4f, 362.9f)
                lineTo(377.1f, 398.3f)
                curveTo(374.9f, 400.5f, 373.9f, 403.5f, 374.4f, 406.6f)
                lineTo(383.0f, 456.5f)
                curveTo(384.3f, 464.1f, 376.3f, 470.0f, 369.4f, 466.4f)
                lineTo(324.6f, 442.8f)
                curveTo(321.9f, 441.4f, 318.6f, 441.4f, 315.9f, 442.8f)
                lineTo(271.1f, 466.4f)
                curveTo(264.2f, 470.0f, 256.2f, 464.2f, 257.5f, 456.5f)
                lineTo(266.1f, 406.6f)
                curveTo(266.6f, 403.6f, 265.6f, 400.5f, 263.4f, 398.3f)
                lineTo(227.1f, 362.9f)
                curveTo(221.5f, 357.5f, 224.6f, 348.1f, 232.3f, 346.9f)
                lineTo(282.4f, 339.6f)
                curveTo(285.4f, 339.2f, 288.1f, 337.2f, 289.4f, 334.5f)
                lineTo(311.8f, 289.1f)
                curveTo(315.2f, 282.1f, 325.1f, 282.1f, 328.6f, 289.1f)
                lineTo(351.0f, 334.5f)
                close()
            }
        }
        .build()
        return _medal!!
    }

private var _medal: ImageVector? = null
