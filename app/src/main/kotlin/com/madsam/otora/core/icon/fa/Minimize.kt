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

public val Fa.Minimize: ImageVector
    get() {
        if (_minimize != null) {
            return _minimize!!
        }
        _minimize = Builder(name = "Minimize", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(520.0f, 288.0f)
                lineTo(376.0f, 288.0f)
                curveTo(362.7f, 288.0f, 352.0f, 277.3f, 352.0f, 264.0f)
                lineTo(352.0f, 120.0f)
                curveTo(352.0f, 110.3f, 357.8f, 101.5f, 366.8f, 97.8f)
                curveTo(375.8f, 94.1f, 386.1f, 96.2f, 393.0f, 103.0f)
                lineTo(433.0f, 143.0f)
                lineTo(506.4f, 69.6f)
                curveTo(510.0f, 66.0f, 514.9f, 64.0f, 520.0f, 64.0f)
                curveTo(525.1f, 64.0f, 530.0f, 66.0f, 533.7f, 69.7f)
                lineTo(570.4f, 106.4f)
                curveTo(574.0f, 110.0f, 576.0f, 114.9f, 576.0f, 120.0f)
                curveTo(576.0f, 125.1f, 574.0f, 130.0f, 570.3f, 133.7f)
                lineTo(497.0f, 207.0f)
                lineTo(537.0f, 247.0f)
                curveTo(543.9f, 253.9f, 545.9f, 264.2f, 542.2f, 273.2f)
                curveTo(538.5f, 282.2f, 529.7f, 288.0f, 520.0f, 288.0f)
                close()
                moveTo(520.0f, 352.0f)
                curveTo(529.7f, 352.0f, 538.5f, 357.8f, 542.2f, 366.8f)
                curveTo(545.9f, 375.8f, 543.9f, 386.1f, 537.0f, 393.0f)
                lineTo(497.0f, 433.0f)
                lineTo(570.4f, 506.4f)
                curveTo(574.0f, 510.0f, 576.1f, 514.9f, 576.1f, 520.1f)
                curveTo(576.1f, 525.3f, 574.1f, 530.1f, 570.4f, 533.8f)
                lineTo(533.7f, 570.5f)
                curveTo(530.0f, 574.0f, 525.1f, 576.0f, 520.0f, 576.0f)
                curveTo(514.9f, 576.0f, 510.0f, 574.0f, 506.3f, 570.3f)
                lineTo(433.0f, 497.0f)
                lineTo(393.0f, 537.0f)
                curveTo(386.1f, 543.9f, 375.8f, 545.9f, 366.8f, 542.2f)
                curveTo(357.8f, 538.5f, 352.0f, 529.7f, 352.0f, 520.0f)
                lineTo(352.0f, 376.0f)
                curveTo(352.0f, 362.7f, 362.7f, 352.0f, 376.0f, 352.0f)
                lineTo(520.0f, 352.0f)
                close()
                moveTo(264.0f, 352.0f)
                curveTo(277.3f, 352.0f, 288.0f, 362.7f, 288.0f, 376.0f)
                lineTo(288.0f, 520.0f)
                curveTo(288.0f, 529.7f, 282.2f, 538.5f, 273.2f, 542.2f)
                curveTo(264.2f, 545.9f, 253.9f, 543.9f, 247.0f, 537.0f)
                lineTo(207.0f, 497.0f)
                lineTo(133.6f, 570.4f)
                curveTo(130.0f, 574.0f, 125.1f, 576.0f, 120.0f, 576.0f)
                curveTo(114.9f, 576.0f, 110.0f, 574.0f, 106.3f, 570.3f)
                lineTo(69.7f, 533.7f)
                curveTo(66.0f, 530.0f, 64.0f, 525.1f, 64.0f, 520.0f)
                curveTo(64.0f, 514.9f, 66.0f, 510.0f, 69.7f, 506.3f)
                lineTo(143.0f, 433.0f)
                lineTo(103.0f, 393.0f)
                curveTo(96.1f, 386.1f, 94.1f, 375.8f, 97.8f, 366.8f)
                curveTo(101.5f, 357.8f, 110.3f, 352.0f, 120.0f, 352.0f)
                lineTo(264.0f, 352.0f)
                close()
                moveTo(120.0f, 288.0f)
                curveTo(110.3f, 288.0f, 101.5f, 282.2f, 97.8f, 273.2f)
                curveTo(94.1f, 264.2f, 96.2f, 253.9f, 103.0f, 247.0f)
                lineTo(143.0f, 207.0f)
                lineTo(69.7f, 133.7f)
                curveTo(66.0f, 130.0f, 64.0f, 125.1f, 64.0f, 120.0f)
                curveTo(64.0f, 114.9f, 66.0f, 110.0f, 69.7f, 106.3f)
                lineTo(106.3f, 69.7f)
                curveTo(110.0f, 66.0f, 114.9f, 64.0f, 120.0f, 64.0f)
                curveTo(125.1f, 64.0f, 130.0f, 66.0f, 133.7f, 69.7f)
                lineTo(207.0f, 143.0f)
                lineTo(247.0f, 103.0f)
                curveTo(253.9f, 96.1f, 264.2f, 94.1f, 273.2f, 97.8f)
                curveTo(282.2f, 101.5f, 288.0f, 110.3f, 288.0f, 120.0f)
                lineTo(288.0f, 264.0f)
                curveTo(288.0f, 277.3f, 277.3f, 288.0f, 264.0f, 288.0f)
                lineTo(120.0f, 288.0f)
                close()
            }
        }
        .build()
        return _minimize!!
    }

private var _minimize: ImageVector? = null
