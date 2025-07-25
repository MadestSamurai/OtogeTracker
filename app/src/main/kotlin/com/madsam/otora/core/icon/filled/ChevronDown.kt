package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ChevronDown: ImageVector
    get() {
        if (_ChevronDown != null) {
            return _ChevronDown!!
        }
        _ChevronDown = ImageVector.Builder(
            name = "ChevronDown",
            defaultWidth = 14.dp,
            defaultHeight = 8.dp,
            viewportWidth = 14f,
            viewportHeight = 8f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(6.294f, 7.706f)
                curveTo(6.684f, 8.097f, 7.319f, 8.097f, 7.709f, 7.706f)
                lineTo(13.709f, 1.706f)
                curveTo(14.1f, 1.316f, 14.1f, 0.681f, 13.709f, 0.291f)
                curveTo(13.319f, -0.1f, 12.684f, -0.1f, 12.294f, 0.291f)
                lineTo(7f, 5.584f)
                lineTo(1.706f, 0.294f)
                curveTo(1.316f, -0.097f, 0.681f, -0.097f, 0.291f, 0.294f)
                curveTo(-0.1f, 0.684f, -0.1f, 1.319f, 0.291f, 1.709f)
                lineTo(6.291f, 7.709f)
                lineTo(6.294f, 7.706f)
                close()
            }
        }.build()

        return _ChevronDown!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronDown: ImageVector? = null