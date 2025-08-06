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

public val Fa.`Person-half-dress`: ImageVector
    get() {
        if (`_person-half-dress` != null) {
            return `_person-half-dress`!!
        }
        `_person-half-dress` = Builder(name = "Person-half-dress", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(271.4f, 60.1f)
                curveTo(281.1f, 43.3f, 299.2f, 32.0f, 320.0f, 32.0f)
                curveTo(350.9f, 32.0f, 376.0f, 57.1f, 376.0f, 88.0f)
                curveTo(376.0f, 113.4f, 359.1f, 134.8f, 336.0f, 141.7f)
                lineTo(336.0f, 141.7f)
                curveTo(330.9f, 143.2f, 325.6f, 144.0f, 320.0f, 144.0f)
                curveTo(289.1f, 144.0f, 264.0f, 118.9f, 264.0f, 88.0f)
                lineTo(264.0f, 88.0f)
                curveTo(264.0f, 77.9f, 266.7f, 68.3f, 271.4f, 60.1f)
                close()
                moveTo(446.3f, 363.1f)
                lineTo(400.0f, 300.7f)
                lineTo(400.0f, 576.0f)
                curveTo(400.0f, 593.7f, 385.7f, 608.0f, 368.0f, 608.0f)
                curveTo(350.3f, 608.0f, 336.0f, 593.7f, 336.0f, 576.0f)
                lineTo(336.0f, 416.0f)
                lineTo(336.0f, 415.6f)
                lineTo(336.0f, 177.0f)
                curveTo(372.2f, 181.4f, 405.2f, 200.4f, 427.2f, 230.0f)
                lineTo(497.7f, 325.0f)
                curveTo(508.2f, 339.2f, 505.3f, 359.2f, 491.1f, 369.8f)
                curveTo(476.9f, 380.4f, 456.9f, 377.4f, 446.3f, 363.2f)
                close()
                moveTo(304.0f, 177.0f)
                lineTo(304.0f, 576.0f)
                curveTo(304.0f, 593.7f, 289.7f, 608.0f, 272.0f, 608.0f)
                curveTo(254.3f, 608.0f, 240.0f, 593.7f, 240.0f, 576.0f)
                lineTo(240.0f, 448.0f)
                lineTo(214.2f, 448.0f)
                curveTo(203.3f, 448.0f, 195.6f, 437.3f, 199.0f, 426.9f)
                lineTo(242.0f, 297.9f)
                lineTo(193.7f, 363.0f)
                curveTo(183.2f, 377.2f, 163.1f, 380.2f, 148.9f, 369.6f)
                curveTo(134.7f, 359.0f, 131.7f, 339.0f, 142.3f, 324.8f)
                lineTo(212.8f, 229.8f)
                curveTo(234.8f, 200.2f, 267.9f, 181.2f, 304.0f, 176.8f)
                close()
            }
        }
        .build()
        return `_person-half-dress`!!
    }

private var `_person-half-dress`: ImageVector? = null
