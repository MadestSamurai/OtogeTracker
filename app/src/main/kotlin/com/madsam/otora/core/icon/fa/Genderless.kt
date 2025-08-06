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

public val Fa.Genderless: ImageVector
    get() {
        if (_genderless != null) {
            return _genderless!!
        }
        _genderless = Builder(name = "Genderless", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 192.0f)
                curveTo(390.7f, 192.0f, 448.0f, 249.3f, 448.0f, 320.0f)
                curveTo(448.0f, 390.7f, 390.7f, 448.0f, 320.0f, 448.0f)
                curveTo(249.3f, 448.0f, 192.0f, 390.7f, 192.0f, 320.0f)
                curveTo(192.0f, 249.3f, 249.3f, 192.0f, 320.0f, 192.0f)
                close()
                moveTo(320.0f, 512.0f)
                curveTo(426.0f, 512.0f, 512.0f, 426.0f, 512.0f, 320.0f)
                curveTo(512.0f, 214.0f, 426.0f, 128.0f, 320.0f, 128.0f)
                curveTo(214.0f, 128.0f, 128.0f, 214.0f, 128.0f, 320.0f)
                curveTo(128.0f, 426.0f, 214.0f, 512.0f, 320.0f, 512.0f)
                close()
            }
        }
        .build()
        return _genderless!!
    }

private var _genderless: ImageVector? = null
