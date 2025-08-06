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

public val Fa.`Paper-plane`: ImageVector
    get() {
        if (`_paper-plane` != null) {
            return `_paper-plane`!!
        }
        `_paper-plane` = Builder(name = "Paper-plane", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(568.4f, 37.7f)
                curveTo(578.2f, 34.2f, 589.0f, 36.7f, 596.4f, 44.0f)
                curveTo(603.8f, 51.3f, 606.2f, 62.2f, 602.7f, 72.0f)
                lineTo(424.7f, 568.9f)
                curveTo(419.7f, 582.8f, 406.6f, 592.0f, 391.9f, 592.0f)
                curveTo(377.7f, 592.0f, 364.9f, 583.4f, 359.6f, 570.3f)
                lineTo(295.4f, 412.3f)
                curveTo(290.9f, 401.3f, 292.9f, 388.7f, 300.6f, 379.7f)
                lineTo(395.1f, 267.3f)
                curveTo(400.2f, 261.2f, 399.8f, 252.3f, 394.2f, 246.7f)
                curveTo(388.6f, 241.1f, 379.6f, 240.7f, 373.6f, 245.8f)
                lineTo(261.2f, 340.1f)
                curveTo(252.1f, 347.7f, 239.6f, 349.7f, 228.6f, 345.3f)
                lineTo(70.1f, 280.8f)
                curveTo(57.0f, 275.5f, 48.4f, 262.7f, 48.4f, 248.5f)
                curveTo(48.4f, 233.8f, 57.6f, 220.7f, 71.5f, 215.7f)
                lineTo(568.4f, 37.7f)
                close()
            }
        }
        .build()
        return `_paper-plane`!!
    }

private var `_paper-plane`: ImageVector? = null
