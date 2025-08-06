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

public val Fa.Shield: ImageVector
    get() {
        if (_shield != null) {
            return _shield!!
        }
        _shield = Builder(name = "Shield", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(324.6f, 64.0f, 329.2f, 65.0f, 333.4f, 66.9f)
                lineTo(521.8f, 146.8f)
                curveTo(543.8f, 156.1f, 560.2f, 177.8f, 560.1f, 204.0f)
                curveTo(559.6f, 303.2f, 518.8f, 484.7f, 346.5f, 567.2f)
                curveTo(329.8f, 575.2f, 310.4f, 575.2f, 293.7f, 567.2f)
                curveTo(121.3f, 484.7f, 80.6f, 303.2f, 80.1f, 204.0f)
                curveTo(80.0f, 177.8f, 96.4f, 156.1f, 118.4f, 146.8f)
                lineTo(306.7f, 66.9f)
                curveTo(310.9f, 65.0f, 315.4f, 64.0f, 320.0f, 64.0f)
                close()
            }
        }
        .build()
        return _shield!!
    }

private var _shield: ImageVector? = null
