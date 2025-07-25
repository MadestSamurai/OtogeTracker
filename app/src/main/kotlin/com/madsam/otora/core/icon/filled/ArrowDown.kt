package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArrowDown: ImageVector
    get() {
        if (_ArrowDown != null) {
            return _ArrowDown!!
        }
        _ArrowDown = ImageVector.Builder(
            name = "ArrowDown",
            defaultWidth = 12.dp,
            defaultHeight = 14.dp,
            viewportWidth = 12f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(5.294f, 13.706f)
                curveTo(5.684f, 14.097f, 6.319f, 14.097f, 6.709f, 13.706f)
                lineTo(11.709f, 8.706f)
                curveTo(12.1f, 8.316f, 12.1f, 7.681f, 11.709f, 7.291f)
                curveTo(11.319f, 6.9f, 10.684f, 6.9f, 10.294f, 7.291f)
                lineTo(7f, 10.587f)
                verticalLineTo(1f)
                curveTo(7f, 0.447f, 6.553f, 0f, 6f, 0f)
                curveTo(5.447f, 0f, 5f, 0.447f, 5f, 1f)
                verticalLineTo(10.584f)
                lineTo(1.706f, 7.294f)
                curveTo(1.316f, 6.903f, 0.681f, 6.903f, 0.291f, 7.294f)
                curveTo(-0.1f, 7.684f, -0.1f, 8.319f, 0.291f, 8.709f)
                lineTo(5.291f, 13.709f)
                lineTo(5.294f, 13.706f)
                close()
            }
        }.build()

        return _ArrowDown!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowDown: ImageVector? = null
