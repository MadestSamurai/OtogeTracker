package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArrowRotate: ImageVector
    get() {
        if (_ArrowRotate != null) {
            return _ArrowRotate!!
        }
        _ArrowRotate = ImageVector.Builder(
            name = "ArrowRotate",
            defaultWidth = 16.dp,
            defaultHeight = 14.dp,
            viewportWidth = 16f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(4.466f, 3.466f)
                curveTo(3.919f, 4.012f, 3.525f, 4.653f, 3.284f, 5.334f)
                curveTo(3.1f, 5.856f, 2.528f, 6.128f, 2.009f, 5.944f)
                curveTo(1.491f, 5.759f, 1.216f, 5.188f, 1.4f, 4.669f)
                curveTo(1.737f, 3.709f, 2.287f, 2.813f, 3.05f, 2.05f)
                curveTo(5.775f, -0.675f, 10.184f, -0.684f, 12.919f, 2.019f)
                lineTo(14.219f, 0.719f)
                curveTo(14.434f, 0.503f, 14.756f, 0.441f, 15.038f, 0.556f)
                curveTo(15.319f, 0.672f, 15.5f, 0.947f, 15.5f, 1.25f)
                verticalLineTo(5.25f)
                curveTo(15.5f, 5.666f, 15.166f, 6f, 14.75f, 6f)
                horizontalLineTo(14.488f)
                horizontalLineTo(10.75f)
                curveTo(10.447f, 6f, 10.172f, 5.819f, 10.056f, 5.537f)
                curveTo(9.941f, 5.256f, 10.003f, 4.934f, 10.219f, 4.719f)
                lineTo(11.503f, 3.434f)
                curveTo(9.547f, 1.513f, 6.406f, 1.522f, 4.463f, 3.466f)
                horizontalLineTo(4.466f)
                close()
                moveTo(0.5f, 8.75f)
                curveTo(0.5f, 8.334f, 0.834f, 8f, 1.25f, 8f)
                horizontalLineTo(1.487f)
                horizontalLineTo(1.509f)
                horizontalLineTo(5.25f)
                curveTo(5.553f, 8f, 5.828f, 8.181f, 5.944f, 8.462f)
                curveTo(6.059f, 8.744f, 5.997f, 9.066f, 5.781f, 9.281f)
                lineTo(4.497f, 10.566f)
                curveTo(6.453f, 12.488f, 9.594f, 12.478f, 11.538f, 10.534f)
                curveTo(12.084f, 9.988f, 12.478f, 9.347f, 12.719f, 8.666f)
                curveTo(12.903f, 8.144f, 13.475f, 7.872f, 13.994f, 8.056f)
                curveTo(14.512f, 8.241f, 14.788f, 8.813f, 14.603f, 9.331f)
                curveTo(14.266f, 10.288f, 13.716f, 11.184f, 12.95f, 11.95f)
                curveTo(10.225f, 14.675f, 5.816f, 14.684f, 3.081f, 11.981f)
                lineTo(1.781f, 13.281f)
                curveTo(1.566f, 13.497f, 1.244f, 13.559f, 0.962f, 13.444f)
                curveTo(0.681f, 13.328f, 0.5f, 13.053f, 0.5f, 12.75f)
                verticalLineTo(9.012f)
                verticalLineTo(8.991f)
                verticalLineTo(8.753f)
                verticalLineTo(8.75f)
                close()
            }
        }.build()

        return _ArrowRotate!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowRotate: ImageVector? = null
