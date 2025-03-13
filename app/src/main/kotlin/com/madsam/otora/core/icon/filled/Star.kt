package com.madsam.otora.core.icon.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Star: ImageVector
    get() {
        if (_Star != null) {
            return _Star!!
        }
        _Star = ImageVector.Builder(
            name = "Star",
            defaultWidth = 18.dp,
            defaultHeight = 16.dp,
            viewportWidth = 18f,
            viewportHeight = 16f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(18f)
                    verticalLineToRelative(16f)
                    horizontalLineToRelative(-18f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(9.903f, 0.563f)
                    curveTo(9.738f, 0.219f, 9.387f, 0f, 9.003f, 0f)
                    curveTo(8.619f, 0f, 8.272f, 0.219f, 8.103f, 0.563f)
                    lineTo(6.094f, 4.697f)
                    lineTo(1.606f, 5.359f)
                    curveTo(1.231f, 5.416f, 0.919f, 5.678f, 0.803f, 6.037f)
                    curveTo(0.688f, 6.397f, 0.781f, 6.794f, 1.05f, 7.059f)
                    lineTo(4.306f, 10.281f)
                    lineTo(3.537f, 14.834f)
                    curveTo(3.475f, 15.209f, 3.631f, 15.591f, 3.941f, 15.813f)
                    curveTo(4.25f, 16.034f, 4.659f, 16.063f, 4.997f, 15.884f)
                    lineTo(9.006f, 13.744f)
                    lineTo(13.016f, 15.884f)
                    curveTo(13.353f, 16.063f, 13.762f, 16.038f, 14.072f, 15.813f)
                    curveTo(14.381f, 15.587f, 14.538f, 15.209f, 14.475f, 14.834f)
                    lineTo(13.703f, 10.281f)
                    lineTo(16.959f, 7.059f)
                    curveTo(17.228f, 6.794f, 17.325f, 6.397f, 17.206f, 6.037f)
                    curveTo(17.087f, 5.678f, 16.778f, 5.416f, 16.403f, 5.359f)
                    lineTo(11.913f, 4.697f)
                    lineTo(9.903f, 0.563f)
                    close()
                }
            }
        }.build()

        return _Star!!
    }

@Suppress("ObjectPropertyName")
private var _Star: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun StarPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Star, contentDescription = null)
    }
}
