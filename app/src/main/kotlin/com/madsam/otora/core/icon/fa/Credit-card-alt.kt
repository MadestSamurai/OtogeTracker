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

public val Fa.`Credit-card-alt`: ImageVector
    get() {
        if (`_credit-card-alt` != null) {
            return `_credit-card-alt`!!
        }
        `_credit-card-alt` = Builder(name = "Credit-card-alt", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 192.0f)
                lineTo(64.0f, 224.0f)
                lineTo(576.0f, 224.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                close()
                moveTo(64.0f, 272.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 272.0f)
                lineTo(64.0f, 272.0f)
                close()
                moveTo(128.0f, 424.0f)
                curveTo(128.0f, 410.7f, 138.7f, 400.0f, 152.0f, 400.0f)
                lineTo(200.0f, 400.0f)
                curveTo(213.3f, 400.0f, 224.0f, 410.7f, 224.0f, 424.0f)
                curveTo(224.0f, 437.3f, 213.3f, 448.0f, 200.0f, 448.0f)
                lineTo(152.0f, 448.0f)
                curveTo(138.7f, 448.0f, 128.0f, 437.3f, 128.0f, 424.0f)
                close()
                moveTo(272.0f, 424.0f)
                curveTo(272.0f, 410.7f, 282.7f, 400.0f, 296.0f, 400.0f)
                lineTo(360.0f, 400.0f)
                curveTo(373.3f, 400.0f, 384.0f, 410.7f, 384.0f, 424.0f)
                curveTo(384.0f, 437.3f, 373.3f, 448.0f, 360.0f, 448.0f)
                lineTo(296.0f, 448.0f)
                curveTo(282.7f, 448.0f, 272.0f, 437.3f, 272.0f, 424.0f)
                close()
            }
        }
        .build()
        return `_credit-card-alt`!!
    }

private var `_credit-card-alt`: ImageVector? = null
