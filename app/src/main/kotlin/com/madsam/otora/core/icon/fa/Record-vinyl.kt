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

public val Fa.`Record-vinyl`: ImageVector
    get() {
        if (`_record-vinyl` != null) {
            return `_record-vinyl`!!
        }
        `_record-vinyl` = Builder(name = "Record-vinyl", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(320.0f, 224.0f)
                curveTo(373.0f, 224.0f, 416.0f, 267.0f, 416.0f, 320.0f)
                curveTo(416.0f, 373.0f, 373.0f, 416.0f, 320.0f, 416.0f)
                curveTo(267.0f, 416.0f, 224.0f, 373.0f, 224.0f, 320.0f)
                curveTo(224.0f, 267.0f, 267.0f, 224.0f, 320.0f, 224.0f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(399.5f, 464.0f, 464.0f, 399.5f, 464.0f, 320.0f)
                curveTo(464.0f, 240.5f, 399.5f, 176.0f, 320.0f, 176.0f)
                curveTo(240.5f, 176.0f, 176.0f, 240.5f, 176.0f, 320.0f)
                curveTo(176.0f, 399.5f, 240.5f, 464.0f, 320.0f, 464.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(337.7f, 352.0f, 352.0f, 337.7f, 352.0f, 320.0f)
                curveTo(352.0f, 302.3f, 337.7f, 288.0f, 320.0f, 288.0f)
                curveTo(302.3f, 288.0f, 288.0f, 302.3f, 288.0f, 320.0f)
                curveTo(288.0f, 337.7f, 302.3f, 352.0f, 320.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_record-vinyl`!!
    }

private var `_record-vinyl`: ImageVector? = null
