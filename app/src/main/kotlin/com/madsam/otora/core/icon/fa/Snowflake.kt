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

public val Fa.Snowflake: ImageVector
    get() {
        if (_snowflake != null) {
            return _snowflake!!
        }
        _snowflake = Builder(name = "Snowflake", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.2f, 64.0f)
                curveTo(352.2f, 46.3f, 337.9f, 32.0f, 320.2f, 32.0f)
                curveTo(302.5f, 32.0f, 288.2f, 46.3f, 288.2f, 64.0f)
                lineTo(288.2f, 126.1f)
                lineTo(273.2f, 111.1f)
                curveTo(263.8f, 101.7f, 248.6f, 101.7f, 239.3f, 111.1f)
                curveTo(230.0f, 120.5f, 229.9f, 135.7f, 239.3f, 145.0f)
                lineTo(288.3f, 194.0f)
                lineTo(288.3f, 264.6f)
                lineTo(227.1f, 229.3f)
                lineTo(209.2f, 162.4f)
                curveTo(205.8f, 149.6f, 192.6f, 142.0f, 179.8f, 145.4f)
                curveTo(167.0f, 148.8f, 159.3f, 162.0f, 162.7f, 174.8f)
                lineTo(168.2f, 195.3f)
                lineTo(114.5f, 164.3f)
                curveTo(99.2f, 155.5f, 79.6f, 160.7f, 70.8f, 176.0f)
                curveTo(62.0f, 191.3f, 67.2f, 210.9f, 82.5f, 219.7f)
                lineTo(136.2f, 250.7f)
                lineTo(115.7f, 256.2f)
                curveTo(102.9f, 259.6f, 95.3f, 272.8f, 98.7f, 285.6f)
                curveTo(102.1f, 298.4f, 115.3f, 306.0f, 128.1f, 302.6f)
                lineTo(195.0f, 284.7f)
                lineTo(256.2f, 320.0f)
                lineTo(195.0f, 355.3f)
                lineTo(128.1f, 337.4f)
                curveTo(115.3f, 334.0f, 102.1f, 341.6f, 98.7f, 354.4f)
                curveTo(95.3f, 367.2f, 102.9f, 380.4f, 115.7f, 383.8f)
                lineTo(136.2f, 389.3f)
                lineTo(82.5f, 420.3f)
                curveTo(67.2f, 429.1f, 62.0f, 448.7f, 70.8f, 464.0f)
                curveTo(79.6f, 479.3f, 99.2f, 484.6f, 114.5f, 475.7f)
                lineTo(168.2f, 444.7f)
                lineTo(162.7f, 465.2f)
                curveTo(159.3f, 478.0f, 166.9f, 491.2f, 179.7f, 494.6f)
                curveTo(192.5f, 498.0f, 205.7f, 490.4f, 209.1f, 477.6f)
                lineTo(227.0f, 410.7f)
                lineTo(288.2f, 375.4f)
                lineTo(288.2f, 446.0f)
                lineTo(239.2f, 495.0f)
                curveTo(229.8f, 504.4f, 229.8f, 519.6f, 239.2f, 528.9f)
                curveTo(248.6f, 538.2f, 263.8f, 538.3f, 273.1f, 528.9f)
                lineTo(288.1f, 513.9f)
                lineTo(288.1f, 576.0f)
                curveTo(288.1f, 593.7f, 302.4f, 608.0f, 320.1f, 608.0f)
                curveTo(337.8f, 608.0f, 352.1f, 593.7f, 352.1f, 576.0f)
                lineTo(352.1f, 513.9f)
                lineTo(367.1f, 528.9f)
                curveTo(376.5f, 538.3f, 391.7f, 538.3f, 401.0f, 528.9f)
                curveTo(410.3f, 519.5f, 410.4f, 504.3f, 401.0f, 495.0f)
                lineTo(352.0f, 446.0f)
                lineTo(352.0f, 375.4f)
                lineTo(413.2f, 410.7f)
                lineTo(431.1f, 477.6f)
                curveTo(434.5f, 490.4f, 447.7f, 498.0f, 460.5f, 494.6f)
                curveTo(473.3f, 491.2f, 480.9f, 478.0f, 477.5f, 465.2f)
                lineTo(472.0f, 444.7f)
                lineTo(525.7f, 475.7f)
                curveTo(541.0f, 484.5f, 560.6f, 479.3f, 569.4f, 464.0f)
                curveTo(578.2f, 448.7f, 573.0f, 429.1f, 557.7f, 420.3f)
                lineTo(504.0f, 389.3f)
                lineTo(524.5f, 383.8f)
                curveTo(537.3f, 380.4f, 544.9f, 367.2f, 541.5f, 354.4f)
                curveTo(538.1f, 341.6f, 524.9f, 334.0f, 512.1f, 337.4f)
                lineTo(445.2f, 355.3f)
                lineTo(384.0f, 320.0f)
                lineTo(445.2f, 284.7f)
                lineTo(512.1f, 302.6f)
                curveTo(524.9f, 306.0f, 538.1f, 298.4f, 541.5f, 285.6f)
                curveTo(544.9f, 272.8f, 537.3f, 259.6f, 524.5f, 256.2f)
                lineTo(504.0f, 250.7f)
                lineTo(557.7f, 219.7f)
                curveTo(573.0f, 210.9f, 578.3f, 191.3f, 569.4f, 176.0f)
                curveTo(560.5f, 160.7f, 541.0f, 155.5f, 525.7f, 164.3f)
                lineTo(472.0f, 195.3f)
                lineTo(477.5f, 174.8f)
                curveTo(480.9f, 162.0f, 473.3f, 148.8f, 460.5f, 145.4f)
                curveTo(447.7f, 142.0f, 434.5f, 149.6f, 431.1f, 162.4f)
                lineTo(413.2f, 229.3f)
                lineTo(352.0f, 264.6f)
                lineTo(352.0f, 194.0f)
                lineTo(401.0f, 145.0f)
                curveTo(410.4f, 135.6f, 410.4f, 120.4f, 401.0f, 111.1f)
                curveTo(391.6f, 101.8f, 376.4f, 101.7f, 367.1f, 111.1f)
                lineTo(352.1f, 126.1f)
                lineTo(352.1f, 64.0f)
                close()
            }
        }
        .build()
        return _snowflake!!
    }

private var _snowflake: ImageVector? = null
