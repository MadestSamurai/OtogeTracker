package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Magnify: ImageVector
    get() {
        if (_Magnify != null) {
            return _Magnify!!
        }
        _Magnify = ImageVector.Builder(
            name = "Magnify",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(13f, 6.5f)
                curveTo(13f, 7.934f, 12.534f, 9.259f, 11.75f, 10.334f)
                lineTo(15.706f, 14.294f)
                curveTo(16.097f, 14.684f, 16.097f, 15.319f, 15.706f, 15.709f)
                curveTo(15.316f, 16.1f, 14.681f, 16.1f, 14.291f, 15.709f)
                lineTo(10.334f, 11.75f)
                curveTo(9.259f, 12.538f, 7.934f, 13f, 6.5f, 13f)
                curveTo(2.909f, 13f, 0f, 10.091f, 0f, 6.5f)
                curveTo(0f, 2.909f, 2.909f, 0f, 6.5f, 0f)
                curveTo(10.091f, 0f, 13f, 2.909f, 13f, 6.5f)
                close()
                moveTo(6.5f, 11f)
                curveTo(7.091f, 11f, 7.676f, 10.884f, 8.222f, 10.658f)
                curveTo(8.768f, 10.431f, 9.264f, 10.1f, 9.682f, 9.682f)
                curveTo(10.1f, 9.264f, 10.431f, 8.768f, 10.658f, 8.222f)
                curveTo(10.884f, 7.676f, 11f, 7.091f, 11f, 6.5f)
                curveTo(11f, 5.909f, 10.884f, 5.324f, 10.658f, 4.778f)
                curveTo(10.431f, 4.232f, 10.1f, 3.736f, 9.682f, 3.318f)
                curveTo(9.264f, 2.9f, 8.768f, 2.569f, 8.222f, 2.343f)
                curveTo(7.676f, 2.116f, 7.091f, 2f, 6.5f, 2f)
                curveTo(5.909f, 2f, 5.324f, 2.116f, 4.778f, 2.343f)
                curveTo(4.232f, 2.569f, 3.736f, 2.9f, 3.318f, 3.318f)
                curveTo(2.9f, 3.736f, 2.569f, 4.232f, 2.343f, 4.778f)
                curveTo(2.116f, 5.324f, 2f, 5.909f, 2f, 6.5f)
                curveTo(2f, 7.091f, 2.116f, 7.676f, 2.343f, 8.222f)
                curveTo(2.569f, 8.768f, 2.9f, 9.264f, 3.318f, 9.682f)
                curveTo(3.736f, 10.1f, 4.232f, 10.431f, 4.778f, 10.658f)
                curveTo(5.324f, 10.884f, 5.909f, 11f, 6.5f, 11f)
                close()
            }
        }.build()

        return _Magnify!!
    }

@Suppress("ObjectPropertyName")
private var _Magnify: ImageVector? = null