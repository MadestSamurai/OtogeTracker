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

public val Fa.Language: ImageVector
    get() {
        if (_language != null) {
            return _language!!
        }
        _language = Builder(name = "Language", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(209.7f, 64.0f, 224.0f, 78.3f, 224.0f, 96.0f)
                lineTo(224.0f, 128.0f)
                lineTo(352.0f, 128.0f)
                curveTo(369.7f, 128.0f, 384.0f, 142.3f, 384.0f, 160.0f)
                curveTo(384.0f, 177.7f, 369.7f, 192.0f, 352.0f, 192.0f)
                lineTo(342.4f, 192.0f)
                lineTo(334.0f, 215.1f)
                curveTo(317.6f, 260.3f, 292.9f, 301.6f, 261.8f, 337.1f)
                curveTo(276.0f, 345.9f, 290.8f, 353.7f, 306.2f, 360.6f)
                lineTo(356.6f, 383.0f)
                lineTo(418.8f, 243.0f)
                curveTo(423.9f, 231.4f, 435.4f, 224.0f, 448.0f, 224.0f)
                curveTo(460.6f, 224.0f, 472.1f, 231.4f, 477.2f, 243.0f)
                lineTo(605.2f, 531.0f)
                curveTo(612.4f, 547.2f, 605.1f, 566.1f, 589.0f, 573.2f)
                curveTo(572.9f, 580.3f, 553.9f, 573.1f, 546.8f, 557.0f)
                lineTo(526.8f, 512.0f)
                lineTo(369.3f, 512.0f)
                lineTo(349.3f, 557.0f)
                curveTo(342.1f, 573.2f, 323.2f, 580.4f, 307.1f, 573.2f)
                curveTo(291.0f, 566.0f, 283.7f, 547.1f, 290.9f, 531.0f)
                lineTo(330.7f, 441.5f)
                lineTo(280.3f, 419.1f)
                curveTo(257.3f, 408.9f, 235.3f, 396.7f, 214.5f, 382.7f)
                curveTo(193.2f, 399.9f, 169.9f, 414.9f, 145.0f, 427.4f)
                lineTo(110.3f, 444.6f)
                curveTo(94.5f, 452.5f, 75.3f, 446.1f, 67.4f, 430.3f)
                curveTo(59.5f, 414.5f, 65.9f, 395.3f, 81.7f, 387.4f)
                lineTo(116.2f, 370.1f)
                curveTo(132.5f, 361.9f, 148.0f, 352.4f, 162.6f, 341.8f)
                curveTo(148.8f, 329.1f, 135.8f, 315.4f, 123.7f, 300.9f)
                lineTo(113.6f, 288.7f)
                curveTo(102.3f, 275.1f, 104.1f, 254.9f, 117.7f, 243.6f)
                curveTo(131.3f, 232.3f, 151.5f, 234.1f, 162.8f, 247.7f)
                lineTo(173.0f, 259.9f)
                curveTo(184.5f, 273.8f, 197.1f, 286.7f, 210.4f, 298.6f)
                curveTo(237.9f, 268.2f, 259.6f, 232.5f, 273.9f, 193.2f)
                lineTo(274.4f, 192.0f)
                lineTo(64.1f, 192.0f)
                curveTo(46.3f, 192.0f, 32.0f, 177.7f, 32.0f, 160.0f)
                curveTo(32.0f, 142.3f, 46.3f, 128.0f, 64.0f, 128.0f)
                lineTo(160.0f, 128.0f)
                lineTo(160.0f, 96.0f)
                curveTo(160.0f, 78.3f, 174.3f, 64.0f, 192.0f, 64.0f)
                close()
                moveTo(448.0f, 334.8f)
                lineTo(397.7f, 448.0f)
                lineTo(498.3f, 448.0f)
                lineTo(448.0f, 334.8f)
                close()
            }
        }
        .build()
        return _language!!
    }

private var _language: ImageVector? = null
