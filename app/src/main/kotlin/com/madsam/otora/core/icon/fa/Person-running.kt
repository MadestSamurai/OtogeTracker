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

public val Fa.`Person-running`: ImageVector
    get() {
        if (`_person-running` != null) {
            return `_person-running`!!
        }
        `_person-running` = Builder(name = "Person-running", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.5f, 32.0f)
                curveTo(383.4f, 32.0f, 408.5f, 57.1f, 408.5f, 88.0f)
                curveTo(408.5f, 118.9f, 383.4f, 144.0f, 352.5f, 144.0f)
                curveTo(321.6f, 144.0f, 296.5f, 118.9f, 296.5f, 88.0f)
                curveTo(296.5f, 57.1f, 321.6f, 32.0f, 352.5f, 32.0f)
                close()
                moveTo(219.6f, 240.0f)
                curveTo(216.3f, 240.0f, 213.4f, 242.0f, 212.2f, 245.0f)
                lineTo(190.2f, 299.9f)
                curveTo(183.6f, 316.3f, 165.0f, 324.3f, 148.6f, 317.7f)
                curveTo(132.2f, 311.1f, 124.2f, 292.5f, 130.8f, 276.1f)
                lineTo(152.7f, 221.2f)
                curveTo(163.7f, 193.9f, 190.1f, 176.0f, 219.6f, 176.0f)
                lineTo(316.9f, 176.0f)
                curveTo(345.4f, 176.0f, 371.7f, 191.1f, 386.0f, 215.7f)
                lineTo(418.8f, 272.0f)
                lineTo(480.4f, 272.0f)
                curveTo(498.1f, 272.0f, 512.4f, 286.3f, 512.4f, 304.0f)
                curveTo(512.4f, 321.7f, 498.1f, 336.0f, 480.4f, 336.0f)
                lineTo(418.8f, 336.0f)
                curveTo(396.0f, 336.0f, 375.0f, 323.9f, 363.5f, 304.2f)
                lineTo(353.5f, 287.1f)
                lineTo(332.8f, 357.5f)
                lineTo(408.2f, 380.1f)
                curveTo(435.9f, 388.4f, 450.0f, 419.1f, 438.3f, 445.6f)
                lineTo(381.7f, 573.0f)
                curveTo(374.5f, 589.2f, 355.6f, 596.4f, 339.5f, 589.2f)
                curveTo(323.4f, 582.0f, 316.1f, 563.1f, 323.3f, 547.0f)
                lineTo(372.5f, 436.2f)
                lineTo(276.6f, 407.4f)
                curveTo(243.9f, 397.6f, 224.6f, 363.7f, 232.9f, 330.6f)
                lineTo(255.6f, 240.0f)
                lineTo(219.7f, 240.0f)
                close()
                moveTo(211.6f, 421.0f)
                curveTo(224.9f, 435.9f, 242.3f, 447.3f, 262.8f, 453.4f)
                lineTo(267.5f, 454.8f)
                lineTo(260.6f, 474.1f)
                curveTo(254.8f, 490.4f, 244.6f, 504.9f, 231.3f, 515.9f)
                lineTo(148.9f, 583.8f)
                curveTo(135.3f, 595.0f, 115.1f, 593.1f, 103.9f, 579.5f)
                curveTo(92.7f, 565.9f, 94.6f, 545.7f, 108.2f, 534.5f)
                lineTo(190.6f, 466.6f)
                curveTo(195.1f, 462.9f, 198.4f, 458.1f, 200.4f, 452.7f)
                lineTo(211.6f, 421.0f)
                close()
            }
        }
        .build()
        return `_person-running`!!
    }

private var `_person-running`: ImageVector? = null
