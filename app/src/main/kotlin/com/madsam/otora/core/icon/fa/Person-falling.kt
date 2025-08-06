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

public val Fa.`Person-falling`: ImageVector
    get() {
        if (`_person-falling` != null) {
            return `_person-falling`!!
        }
        `_person-falling` = Builder(name = "Person-falling", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 96.0f)
                curveTo(384.0f, 78.3f, 369.7f, 64.0f, 352.0f, 64.0f)
                curveTo(334.3f, 64.0f, 320.0f, 78.3f, 320.0f, 96.0f)
                lineTo(320.0f, 101.4f)
                curveTo(320.0f, 146.4f, 296.4f, 188.0f, 257.9f, 211.2f)
                lineTo(253.3f, 214.0f)
                curveTo(195.4f, 248.7f, 160.0f, 311.1f, 160.0f, 378.6f)
                lineTo(160.0f, 448.0f)
                curveTo(160.0f, 465.7f, 174.3f, 480.0f, 192.0f, 480.0f)
                curveTo(209.7f, 480.0f, 224.0f, 465.7f, 224.0f, 448.0f)
                lineTo(224.0f, 378.6f)
                curveTo(224.0f, 361.9f, 227.3f, 345.6f, 233.4f, 330.6f)
                lineTo(423.2f, 564.2f)
                curveTo(434.3f, 577.9f, 454.5f, 580.0f, 468.2f, 568.9f)
                curveTo(481.9f, 557.8f, 484.0f, 537.6f, 472.9f, 523.9f)
                lineTo(359.2f, 384.0f)
                lineTo(464.0f, 384.0f)
                lineTo(502.4f, 435.2f)
                curveTo(513.0f, 449.3f, 533.1f, 452.2f, 547.2f, 441.6f)
                curveTo(561.3f, 431.0f, 564.2f, 410.9f, 553.6f, 396.8f)
                lineTo(510.4f, 339.2f)
                curveTo(501.3f, 327.1f, 487.1f, 320.0f, 472.0f, 320.0f)
                lineTo(383.0f, 320.0f)
                lineTo(320.1f, 244.5f)
                curveTo(360.4f, 208.5f, 384.0f, 156.6f, 384.0f, 101.4f)
                lineTo(384.0f, 96.0f)
                close()
                moveTo(168.0f, 208.0f)
                curveTo(198.9f, 208.0f, 224.0f, 182.9f, 224.0f, 152.0f)
                curveTo(224.0f, 121.1f, 198.9f, 96.0f, 168.0f, 96.0f)
                curveTo(137.1f, 96.0f, 112.0f, 121.1f, 112.0f, 152.0f)
                curveTo(112.0f, 182.9f, 137.1f, 208.0f, 168.0f, 208.0f)
                close()
            }
        }
        .build()
        return `_person-falling`!!
    }

private var `_person-falling`: ImageVector? = null
