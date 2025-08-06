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

public val Fa.`Circle-nodes`: ImageVector
    get() {
        if (`_circle-nodes` != null) {
            return `_circle-nodes`!!
        }
        `_circle-nodes` = Builder(name = "Circle-nodes", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(482.4f, 221.9f)
                curveTo(517.7f, 213.6f, 544.0f, 181.9f, 544.0f, 144.0f)
                curveTo(544.0f, 99.8f, 508.2f, 64.0f, 464.0f, 64.0f)
                curveTo(420.6f, 64.0f, 385.3f, 98.5f, 384.0f, 141.5f)
                lineTo(200.2f, 215.1f)
                curveTo(185.7f, 200.8f, 165.9f, 192.0f, 144.0f, 192.0f)
                curveTo(99.8f, 192.0f, 64.0f, 227.8f, 64.0f, 272.0f)
                curveTo(64.0f, 316.2f, 99.8f, 352.0f, 144.0f, 352.0f)
                curveTo(156.2f, 352.0f, 167.8f, 349.3f, 178.1f, 344.4f)
                lineTo(323.7f, 471.8f)
                curveTo(321.3f, 479.4f, 320.0f, 487.6f, 320.0f, 496.0f)
                curveTo(320.0f, 540.2f, 355.8f, 576.0f, 400.0f, 576.0f)
                curveTo(444.2f, 576.0f, 480.0f, 540.2f, 480.0f, 496.0f)
                curveTo(480.0f, 468.3f, 466.0f, 443.9f, 444.6f, 429.6f)
                lineTo(482.4f, 221.9f)
                close()
                moveTo(220.3f, 296.2f)
                curveTo(222.5f, 289.3f, 223.8f, 282.0f, 224.0f, 274.5f)
                lineTo(407.8f, 201.0f)
                curveTo(411.4f, 204.5f, 415.2f, 207.7f, 419.4f, 210.5f)
                lineTo(381.6f, 418.1f)
                curveTo(376.1f, 419.4f, 370.8f, 421.2f, 365.8f, 423.6f)
                lineTo(220.3f, 296.2f)
                close()
            }
        }
        .build()
        return `_circle-nodes`!!
    }

private var `_circle-nodes`: ImageVector? = null
