package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Tick: ImageVector
    get() {
        if (_Tick != null) {
            return _Tick!!
        }
        _Tick = ImageVector.Builder(
            name = "Tick",
            defaultWidth = 14.dp,
            defaultHeight = 10.dp,
            viewportWidth = 14f,
            viewportHeight = 10f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(13.706f, 0.294f)
                curveTo(14.097f, 0.684f, 14.097f, 1.319f, 13.706f, 1.709f)
                lineTo(5.706f, 9.709f)
                curveTo(5.316f, 10.1f, 4.681f, 10.1f, 4.291f, 9.709f)
                lineTo(0.291f, 5.709f)
                curveTo(-0.1f, 5.319f, -0.1f, 4.684f, 0.291f, 4.294f)
                curveTo(0.681f, 3.903f, 1.316f, 3.903f, 1.706f, 4.294f)
                lineTo(5f, 7.584f)
                lineTo(12.294f, 0.294f)
                curveTo(12.684f, -0.097f, 13.319f, -0.097f, 13.709f, 0.294f)
                horizontalLineTo(13.706f)
                close()
            }
        }.build()

        return _Tick!!
    }

@Suppress("ObjectPropertyName")
private var _Tick: ImageVector? = null