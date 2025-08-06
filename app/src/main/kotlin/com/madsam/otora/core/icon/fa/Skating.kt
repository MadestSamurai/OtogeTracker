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

public val Fa.Skating: ImageVector
    get() {
        if (_skating != null) {
            return _skating!!
        }
        _skating = Builder(name = "Skating", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(432.0f, 120.0f)
                curveTo(432.0f, 89.1f, 457.1f, 64.0f, 488.0f, 64.0f)
                curveTo(518.9f, 64.0f, 544.0f, 89.1f, 544.0f, 120.0f)
                curveTo(544.0f, 150.9f, 518.9f, 176.0f, 488.0f, 176.0f)
                curveTo(457.1f, 176.0f, 432.0f, 150.9f, 432.0f, 120.0f)
                close()
                moveTo(192.0f, 192.0f)
                curveTo(192.0f, 174.3f, 206.3f, 160.0f, 224.0f, 160.0f)
                lineTo(374.1f, 160.0f)
                curveTo(424.0f, 160.0f, 449.0f, 220.3f, 413.7f, 255.6f)
                lineTo(349.8f, 319.5f)
                lineTo(419.6f, 350.5f)
                curveTo(436.9f, 358.2f, 448.1f, 375.4f, 448.1f, 394.4f)
                lineTo(448.1f, 480.0f)
                curveTo(448.1f, 497.7f, 433.8f, 512.0f, 416.1f, 512.0f)
                curveTo(398.4f, 512.0f, 384.1f, 497.7f, 384.1f, 480.0f)
                lineTo(384.1f, 404.8f)
                lineTo(301.7f, 368.2f)
                curveTo(260.7f, 350.0f, 250.7f, 296.2f, 282.4f, 264.5f)
                lineTo(322.8f, 224.1f)
                lineTo(224.1f, 224.1f)
                curveTo(206.4f, 224.1f, 192.1f, 209.8f, 192.1f, 192.1f)
                close()
                moveTo(153.4f, 425.4f)
                lineTo(229.3f, 349.5f)
                curveTo(237.0f, 369.2f, 250.9f, 386.8f, 270.3f, 399.1f)
                lineTo(198.7f, 470.7f)
                curveTo(186.2f, 483.2f, 165.9f, 483.2f, 153.4f, 470.7f)
                curveTo(140.9f, 458.2f, 140.9f, 437.9f, 153.4f, 425.4f)
                close()
                moveTo(499.9f, 512.5f)
                curveTo(508.5f, 514.6f, 513.7f, 523.3f, 511.5f, 531.9f)
                lineTo(511.1f, 533.6f)
                curveTo(504.9f, 558.5f, 482.5f, 576.0f, 456.8f, 576.0f)
                lineTo(368.0f, 576.0f)
                curveTo(359.2f, 576.0f, 352.0f, 568.8f, 352.0f, 560.0f)
                curveTo(352.0f, 551.2f, 359.2f, 544.0f, 368.0f, 544.0f)
                lineTo(456.8f, 544.0f)
                curveTo(467.8f, 544.0f, 477.4f, 536.5f, 480.1f, 525.8f)
                lineTo(480.5f, 524.1f)
                curveTo(482.6f, 515.5f, 491.3f, 510.3f, 499.9f, 512.5f)
                close()
                moveTo(207.2f, 550.3f)
                lineTo(201.0f, 553.4f)
                curveTo(179.4f, 564.2f, 153.4f, 560.0f, 136.4f, 542.9f)
                lineTo(76.7f, 483.3f)
                curveTo(70.5f, 477.1f, 70.5f, 466.9f, 76.7f, 460.7f)
                curveTo(82.9f, 454.5f, 93.1f, 454.5f, 99.3f, 460.7f)
                lineTo(158.9f, 520.3f)
                curveTo(166.2f, 527.6f, 177.4f, 529.4f, 186.6f, 524.8f)
                lineTo(192.8f, 521.7f)
                curveTo(200.7f, 517.7f, 210.3f, 521.0f, 214.3f, 528.9f)
                curveTo(218.3f, 536.8f, 215.0f, 546.4f, 207.1f, 550.4f)
                close()
            }
        }
        .build()
        return _skating!!
    }

private var _skating: ImageVector? = null
