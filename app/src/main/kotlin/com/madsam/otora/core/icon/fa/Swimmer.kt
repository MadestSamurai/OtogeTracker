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

public val Fa.Swimmer: ImageVector
    get() {
        if (_swimmer != null) {
            return _swimmer!!
        }
        _swimmer = Builder(name = "Swimmer", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(552.0f, 216.0f)
                curveTo(552.0f, 185.1f, 526.9f, 160.0f, 496.0f, 160.0f)
                curveTo(465.1f, 160.0f, 440.0f, 185.1f, 440.0f, 216.0f)
                curveTo(440.0f, 246.9f, 465.1f, 272.0f, 496.0f, 272.0f)
                curveTo(526.9f, 272.0f, 552.0f, 246.9f, 552.0f, 216.0f)
                close()
                moveTo(293.4f, 262.2f)
                lineTo(204.8f, 336.1f)
                curveTo(205.9f, 336.1f, 207.0f, 336.0f, 208.1f, 336.0f)
                curveTo(241.2f, 335.8f, 274.4f, 346.2f, 302.5f, 367.4f)
                curveTo(324.6f, 384.0f, 331.6f, 384.0f, 353.7f, 367.4f)
                curveTo(381.2f, 346.7f, 413.6f, 336.2f, 446.1f, 336.0f)
                curveTo(450.9f, 336.0f, 455.8f, 336.2f, 460.6f, 336.6f)
                curveTo(452.3f, 306.6f, 436.3f, 278.9f, 413.8f, 256.4f)
                curveTo(395.4f, 238.0f, 373.2f, 223.7f, 348.8f, 214.6f)
                lineTo(280.2f, 188.9f)
                curveTo(252.8f, 178.6f, 222.2f, 181.4f, 197.1f, 196.5f)
                lineTo(143.6f, 228.6f)
                curveTo(128.4f, 237.7f, 123.5f, 257.3f, 132.6f, 272.5f)
                curveTo(141.7f, 287.7f, 161.3f, 292.6f, 176.5f, 283.5f)
                lineTo(230.0f, 251.3f)
                curveTo(238.4f, 246.3f, 248.6f, 245.4f, 257.7f, 248.8f)
                lineTo(293.4f, 262.2f)
                close()
                moveTo(403.4f, 444.1f)
                curveTo(424.7f, 428.0f, 453.3f, 428.0f, 474.6f, 444.1f)
                curveTo(493.6f, 458.5f, 516.5f, 472.3f, 541.8f, 477.4f)
                curveTo(568.3f, 482.8f, 596.1f, 478.2f, 622.5f, 458.3f)
                curveTo(633.1f, 450.3f, 635.2f, 435.3f, 627.2f, 424.7f)
                curveTo(619.2f, 414.1f, 604.2f, 412.0f, 593.6f, 420.0f)
                curveTo(578.7f, 431.2f, 565.0f, 433.1f, 551.3f, 430.3f)
                curveTo(536.4f, 427.3f, 520.4f, 418.4f, 503.5f, 405.7f)
                curveTo(465.1f, 376.7f, 413.0f, 376.7f, 374.5f, 405.7f)
                curveTo(350.5f, 423.8f, 333.8f, 432.0f, 320.0f, 432.0f)
                curveTo(306.2f, 432.0f, 289.5f, 423.8f, 265.5f, 405.7f)
                curveTo(227.1f, 376.7f, 175.0f, 376.7f, 136.5f, 405.7f)
                curveTo(114.9f, 422.0f, 95.2f, 431.5f, 77.6f, 431.4f)
                curveTo(68.0f, 431.3f, 57.7f, 428.4f, 46.4f, 419.9f)
                curveTo(35.8f, 411.9f, 20.8f, 414.0f, 12.8f, 424.6f)
                curveTo(4.8f, 435.2f, 7.0f, 450.3f, 17.6f, 458.3f)
                curveTo(36.7f, 472.7f, 57.0f, 479.3f, 77.4f, 479.4f)
                curveTo(111.3f, 479.6f, 141.7f, 462.0f, 165.5f, 444.1f)
                curveTo(186.8f, 428.0f, 215.4f, 428.0f, 236.7f, 444.1f)
                curveTo(260.9f, 462.4f, 289.0f, 480.0f, 320.1f, 480.0f)
                curveTo(351.2f, 480.0f, 379.2f, 462.3f, 403.5f, 444.1f)
                close()
            }
        }
        .build()
        return _swimmer!!
    }

private var _swimmer: ImageVector? = null
