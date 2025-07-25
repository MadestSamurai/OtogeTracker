package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Heart1: ImageVector
    get() {
        if (_Heart1 != null) {
            return _Heart1!!
        }
        _Heart1 = ImageVector.Builder(
            name = "Heart1",
            defaultWidth = 16.dp,
            defaultHeight = 14.dp,
            viewportWidth = 16f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(1.487f, 8.07f)
                lineTo(7.134f, 13.342f)
                curveTo(7.369f, 13.561f, 7.678f, 13.683f, 8f, 13.683f)
                curveTo(8.322f, 13.683f, 8.631f, 13.561f, 8.866f, 13.342f)
                lineTo(14.512f, 8.07f)
                curveTo(15.462f, 7.186f, 16f, 5.945f, 16f, 4.648f)
                verticalLineTo(4.467f)
                curveTo(16f, 2.283f, 14.422f, 0.42f, 12.269f, 0.061f)
                curveTo(10.844f, -0.177f, 9.394f, 0.289f, 8.375f, 1.308f)
                lineTo(8f, 1.683f)
                lineTo(7.625f, 1.308f)
                curveTo(6.606f, 0.289f, 5.156f, -0.177f, 3.731f, 0.061f)
                curveTo(1.578f, 0.42f, 0f, 2.283f, 0f, 4.467f)
                verticalLineTo(4.648f)
                curveTo(0f, 5.945f, 0.538f, 7.186f, 1.487f, 8.07f)
                close()
            }
        }.build()

        return _Heart1!!
    }

@Suppress("ObjectPropertyName")
private var _Heart1: ImageVector? = null
