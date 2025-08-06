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

public val Fa.User: ImageVector
    get() {
        if (_user != null) {
            return _user!!
        }
        _user = Builder(name = "User", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 312.0f)
                curveTo(386.3f, 312.0f, 440.0f, 258.3f, 440.0f, 192.0f)
                curveTo(440.0f, 125.7f, 386.3f, 72.0f, 320.0f, 72.0f)
                curveTo(253.7f, 72.0f, 200.0f, 125.7f, 200.0f, 192.0f)
                curveTo(200.0f, 258.3f, 253.7f, 312.0f, 320.0f, 312.0f)
                close()
                moveTo(290.3f, 368.0f)
                curveTo(191.8f, 368.0f, 112.0f, 447.8f, 112.0f, 546.3f)
                curveTo(112.0f, 562.7f, 125.3f, 576.0f, 141.7f, 576.0f)
                lineTo(498.3f, 576.0f)
                curveTo(514.7f, 576.0f, 528.0f, 562.7f, 528.0f, 546.3f)
                curveTo(528.0f, 447.8f, 448.2f, 368.0f, 349.7f, 368.0f)
                lineTo(290.3f, 368.0f)
                close()
            }
        }
        .build()
        return _user!!
    }

private var _user: ImageVector? = null
