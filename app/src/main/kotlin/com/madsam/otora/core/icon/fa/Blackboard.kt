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

public val Fa.Blackboard: ImageVector
    get() {
        if (_blackboard != null) {
            return _blackboard!!
        }
        _blackboard = Builder(name = "Blackboard", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(46.3f, 448.0f, 32.0f, 462.3f, 32.0f, 480.0f)
                curveTo(32.0f, 497.7f, 46.3f, 512.0f, 64.0f, 512.0f)
                lineTo(576.0f, 512.0f)
                curveTo(593.7f, 512.0f, 608.0f, 497.7f, 608.0f, 480.0f)
                curveTo(608.0f, 462.3f, 593.7f, 448.0f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(512.0f, 448.0f)
                lineTo(448.0f, 448.0f)
                lineTo(448.0f, 416.0f)
                curveTo(448.0f, 398.3f, 433.7f, 384.0f, 416.0f, 384.0f)
                lineTo(320.0f, 384.0f)
                curveTo(302.3f, 384.0f, 288.0f, 398.3f, 288.0f, 416.0f)
                lineTo(288.0f, 448.0f)
                lineTo(128.0f, 448.0f)
                lineTo(128.0f, 192.0f)
                lineTo(512.0f, 192.0f)
                lineTo(512.0f, 448.0f)
                close()
            }
        }
        .build()
        return _blackboard!!
    }

private var _blackboard: ImageVector? = null
