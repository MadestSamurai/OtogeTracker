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

public val Fa.`Code-commit`: ImageVector
    get() {
        if (`_code-commit` != null) {
            return `_code-commit`!!
        }
        `_code-commit` = Builder(name = "Code-commit", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 400.0f)
                curveTo(364.2f, 400.0f, 400.0f, 364.2f, 400.0f, 320.0f)
                curveTo(400.0f, 275.8f, 364.2f, 240.0f, 320.0f, 240.0f)
                curveTo(275.8f, 240.0f, 240.0f, 275.8f, 240.0f, 320.0f)
                curveTo(240.0f, 364.2f, 275.8f, 400.0f, 320.0f, 400.0f)
                close()
                moveTo(476.8f, 352.0f)
                curveTo(462.0f, 425.0f, 397.4f, 480.0f, 320.0f, 480.0f)
                curveTo(242.6f, 480.0f, 178.0f, 425.0f, 163.2f, 352.0f)
                lineTo(64.0f, 352.0f)
                curveTo(46.3f, 352.0f, 32.0f, 337.7f, 32.0f, 320.0f)
                curveTo(32.0f, 302.3f, 46.3f, 288.0f, 64.0f, 288.0f)
                lineTo(163.2f, 288.0f)
                curveTo(178.0f, 215.0f, 242.6f, 160.0f, 320.0f, 160.0f)
                curveTo(397.4f, 160.0f, 462.0f, 215.0f, 476.8f, 288.0f)
                lineTo(576.0f, 288.0f)
                curveTo(593.7f, 288.0f, 608.0f, 302.3f, 608.0f, 320.0f)
                curveTo(608.0f, 337.7f, 593.7f, 352.0f, 576.0f, 352.0f)
                lineTo(476.8f, 352.0f)
                close()
            }
        }
        .build()
        return `_code-commit`!!
    }

private var `_code-commit`: ImageVector? = null
