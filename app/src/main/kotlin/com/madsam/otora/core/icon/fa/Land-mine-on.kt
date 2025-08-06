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

public val Fa.`Land-mine-on`: ImageVector
    get() {
        if (`_land-mine-on` != null) {
            return `_land-mine-on`!!
        }
        `_land-mine-on` = Builder(name = "Land-mine-on", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(344.0f, 64.0f)
                lineTo(344.0f, 192.0f)
                curveTo(344.0f, 205.3f, 333.3f, 216.0f, 320.0f, 216.0f)
                curveTo(306.7f, 216.0f, 296.0f, 205.3f, 296.0f, 192.0f)
                lineTo(296.0f, 64.0f)
                curveTo(296.0f, 50.7f, 306.7f, 40.0f, 320.0f, 40.0f)
                curveTo(333.3f, 40.0f, 344.0f, 50.7f, 344.0f, 64.0f)
                close()
                moveTo(192.0f, 352.0f)
                curveTo(192.0f, 334.3f, 206.3f, 320.0f, 224.0f, 320.0f)
                lineTo(416.0f, 320.0f)
                curveTo(433.7f, 320.0f, 448.0f, 334.3f, 448.0f, 352.0f)
                lineTo(448.0f, 384.0f)
                lineTo(528.0f, 384.0f)
                curveTo(554.5f, 384.0f, 576.0f, 405.5f, 576.0f, 432.0f)
                lineTo(576.0f, 528.0f)
                curveTo(576.0f, 554.5f, 554.5f, 576.0f, 528.0f, 576.0f)
                lineTo(112.0f, 576.0f)
                curveTo(85.5f, 576.0f, 64.0f, 554.5f, 64.0f, 528.0f)
                lineTo(64.0f, 432.0f)
                curveTo(64.0f, 405.5f, 85.5f, 384.0f, 112.0f, 384.0f)
                lineTo(192.0f, 384.0f)
                lineTo(192.0f, 352.0f)
                close()
                moveTo(44.0f, 178.7f)
                curveTo(51.4f, 167.7f, 66.3f, 164.7f, 77.3f, 172.0f)
                lineTo(173.3f, 236.0f)
                curveTo(184.3f, 243.4f, 187.3f, 258.3f, 180.0f, 269.3f)
                curveTo(172.7f, 280.3f, 157.7f, 283.3f, 146.7f, 276.0f)
                lineTo(50.7f, 212.0f)
                curveTo(39.7f, 204.6f, 36.7f, 189.7f, 44.0f, 178.7f)
                close()
                moveTo(562.7f, 172.0f)
                curveTo(573.7f, 164.6f, 588.6f, 167.6f, 596.0f, 178.7f)
                curveTo(603.4f, 189.8f, 600.4f, 204.6f, 589.3f, 212.0f)
                lineTo(493.3f, 276.0f)
                curveTo(482.3f, 283.4f, 467.4f, 280.4f, 460.0f, 269.3f)
                curveTo(452.6f, 258.2f, 455.6f, 243.4f, 466.7f, 236.0f)
                lineTo(562.7f, 172.0f)
                close()
            }
        }
        .build()
        return `_land-mine-on`!!
    }

private var `_land-mine-on`: ImageVector? = null
