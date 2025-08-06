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

public val Fa.`Sheet-plastic`: ImageVector
    get() {
        if (`_sheet-plastic` != null) {
            return `_sheet-plastic`!!
        }
        `_sheet-plastic` = Builder(name = "Sheet-plastic", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 512.0f)
                curveTo(128.0f, 547.3f, 156.7f, 576.0f, 192.0f, 576.0f)
                lineTo(341.5f, 576.0f)
                curveTo(358.5f, 576.0f, 374.8f, 569.3f, 386.8f, 557.3f)
                lineTo(493.3f, 450.7f)
                curveTo(505.3f, 438.7f, 512.0f, 422.4f, 512.0f, 405.4f)
                lineTo(512.0f, 128.0f)
                curveTo(512.0f, 92.7f, 483.3f, 64.0f, 448.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                curveTo(156.7f, 64.0f, 128.0f, 92.7f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                close()
                moveTo(336.0f, 517.5f)
                lineTo(336.0f, 424.0f)
                curveTo(336.0f, 410.7f, 346.7f, 400.0f, 360.0f, 400.0f)
                lineTo(453.5f, 400.0f)
                lineTo(336.0f, 517.5f)
                close()
                moveTo(281.0f, 169.0f)
                lineTo(233.0f, 217.0f)
                curveTo(223.6f, 226.4f, 208.4f, 226.4f, 199.1f, 217.0f)
                curveTo(189.8f, 207.6f, 189.7f, 192.4f, 199.1f, 183.1f)
                lineTo(247.1f, 135.1f)
                curveTo(256.5f, 125.7f, 271.7f, 125.7f, 281.0f, 135.1f)
                curveTo(290.3f, 144.5f, 290.4f, 159.7f, 281.0f, 169.0f)
                close()
                moveTo(377.0f, 201.0f)
                lineTo(265.0f, 313.0f)
                curveTo(255.6f, 322.4f, 240.4f, 322.4f, 231.1f, 313.0f)
                curveTo(221.8f, 303.6f, 221.7f, 288.4f, 231.1f, 279.1f)
                lineTo(343.0f, 167.0f)
                curveTo(352.4f, 157.6f, 367.6f, 157.6f, 376.9f, 167.0f)
                curveTo(386.2f, 176.4f, 386.3f, 191.6f, 376.9f, 200.9f)
                close()
            }
        }
        .build()
        return `_sheet-plastic`!!
    }

private var `_sheet-plastic`: ImageVector? = null
