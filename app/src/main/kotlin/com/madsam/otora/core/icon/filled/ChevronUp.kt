package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ChevronUp: ImageVector
    get() {
        if (_ChevronUp != null) {
            return _ChevronUp!!
        }
        _ChevronUp = ImageVector.Builder(
            name = "ChevronUp",
            defaultWidth = 14.dp,
            defaultHeight = 8.dp,
            viewportWidth = 14f,
            viewportHeight = 8f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(6.294f, 0.294f)
                curveTo(6.684f, -0.097f, 7.319f, -0.097f, 7.709f, 0.294f)
                lineTo(13.709f, 6.294f)
                curveTo(14.1f, 6.684f, 14.1f, 7.319f, 13.709f, 7.709f)
                curveTo(13.319f, 8.1f, 12.684f, 8.1f, 12.294f, 7.709f)
                lineTo(7f, 2.416f)
                lineTo(1.706f, 7.706f)
                curveTo(1.316f, 8.097f, 0.681f, 8.097f, 0.291f, 7.706f)
                curveTo(-0.1f, 7.316f, -0.1f, 6.681f, 0.291f, 6.291f)
                lineTo(6.291f, 0.291f)
                lineTo(6.294f, 0.294f)
                close()
            }
        }.build()

        return _ChevronUp!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronUp: ImageVector? = null