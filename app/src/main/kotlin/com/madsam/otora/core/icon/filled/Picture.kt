package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Picture: ImageVector
    get() {
        if (_Picture != null) {
            return _Picture!!
        }
        _Picture = ImageVector.Builder(
            name = "Picture",
            defaultWidth = 18.dp,
            defaultHeight = 14.dp,
            viewportWidth = 18f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(5f, 0f)
                curveTo(3.897f, 0f, 3f, 0.897f, 3f, 2f)
                verticalLineTo(9f)
                curveTo(3f, 10.103f, 3.897f, 11f, 5f, 11f)
                horizontalLineTo(16f)
                curveTo(17.103f, 11f, 18f, 10.103f, 18f, 9f)
                verticalLineTo(2f)
                curveTo(18f, 0.897f, 17.103f, 0f, 16f, 0f)
                horizontalLineTo(5f)
                close()
                moveTo(12.375f, 3.334f)
                lineTo(15.375f, 7.834f)
                curveTo(15.528f, 8.066f, 15.544f, 8.359f, 15.413f, 8.603f)
                curveTo(15.281f, 8.847f, 15.028f, 9f, 14.75f, 9f)
                horizontalLineTo(10.25f)
                horizontalLineTo(8.75f)
                horizontalLineTo(6.25f)
                curveTo(5.963f, 9f, 5.7f, 8.834f, 5.575f, 8.575f)
                curveTo(5.45f, 8.316f, 5.484f, 8.006f, 5.666f, 7.781f)
                lineTo(7.666f, 5.281f)
                curveTo(7.809f, 5.103f, 8.022f, 5f, 8.25f, 5f)
                curveTo(8.478f, 5f, 8.694f, 5.103f, 8.834f, 5.281f)
                lineTo(9.375f, 5.956f)
                lineTo(11.125f, 3.331f)
                curveTo(11.266f, 3.125f, 11.5f, 3f, 11.75f, 3f)
                curveTo(12f, 3f, 12.234f, 3.125f, 12.375f, 3.334f)
                close()
                moveTo(6f, 3f)
                curveTo(6f, 2.735f, 6.105f, 2.48f, 6.293f, 2.293f)
                curveTo(6.48f, 2.105f, 6.735f, 2f, 7f, 2f)
                curveTo(7.265f, 2f, 7.52f, 2.105f, 7.707f, 2.293f)
                curveTo(7.895f, 2.48f, 8f, 2.735f, 8f, 3f)
                curveTo(8f, 3.265f, 7.895f, 3.52f, 7.707f, 3.707f)
                curveTo(7.52f, 3.895f, 7.265f, 4f, 7f, 4f)
                curveTo(6.735f, 4f, 6.48f, 3.895f, 6.293f, 3.707f)
                curveTo(6.105f, 3.52f, 6f, 3.265f, 6f, 3f)
                close()
                moveTo(1.5f, 2.75f)
                curveTo(1.5f, 2.334f, 1.166f, 2f, 0.75f, 2f)
                curveTo(0.334f, 2f, 0f, 2.334f, 0f, 2.75f)
                verticalLineTo(9.75f)
                curveTo(0f, 12.097f, 1.903f, 14f, 4.25f, 14f)
                horizontalLineTo(14.25f)
                curveTo(14.666f, 14f, 15f, 13.666f, 15f, 13.25f)
                curveTo(15f, 12.834f, 14.666f, 12.5f, 14.25f, 12.5f)
                horizontalLineTo(4.25f)
                curveTo(2.731f, 12.5f, 1.5f, 11.269f, 1.5f, 9.75f)
                verticalLineTo(2.75f)
                close()
            }
        }.build()

        return _Picture!!
    }

@Suppress("ObjectPropertyName")
private var _Picture: ImageVector? = null
