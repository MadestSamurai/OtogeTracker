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

val Link: ImageVector
    get() {
        if (_Link != null) {
            return _Link!!
        }
        _Link = ImageVector.Builder(
            name = "Link",
            defaultWidth = 20.dp,
            defaultHeight = 16.dp,
            viewportWidth = 20f,
            viewportHeight = 16f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(20f)
                    verticalLineToRelative(16f)
                    horizontalLineToRelative(-20f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(18.119f, 8.366f)
                    curveTo(19.884f, 6.6f, 19.884f, 3.741f, 18.119f, 1.975f)
                    curveTo(16.556f, 0.413f, 14.094f, 0.209f, 12.297f, 1.494f)
                    lineTo(12.247f, 1.528f)
                    curveTo(11.797f, 1.85f, 11.694f, 2.475f, 12.016f, 2.922f)
                    curveTo(12.337f, 3.369f, 12.962f, 3.475f, 13.409f, 3.153f)
                    lineTo(13.459f, 3.119f)
                    curveTo(14.462f, 2.403f, 15.834f, 2.516f, 16.703f, 3.388f)
                    curveTo(17.688f, 4.372f, 17.688f, 5.966f, 16.703f, 6.95f)
                    lineTo(13.197f, 10.462f)
                    curveTo(12.212f, 11.447f, 10.619f, 11.447f, 9.634f, 10.462f)
                    curveTo(8.762f, 9.591f, 8.65f, 8.219f, 9.366f, 7.219f)
                    lineTo(9.4f, 7.169f)
                    curveTo(9.722f, 6.719f, 9.616f, 6.094f, 9.169f, 5.775f)
                    curveTo(8.722f, 5.456f, 8.094f, 5.559f, 7.775f, 6.006f)
                    lineTo(7.741f, 6.056f)
                    curveTo(6.453f, 7.85f, 6.656f, 10.313f, 8.219f, 11.875f)
                    curveTo(9.984f, 13.641f, 12.844f, 13.641f, 14.609f, 11.875f)
                    lineTo(18.119f, 8.366f)
                    close()
                    moveTo(1.881f, 7.634f)
                    curveTo(0.116f, 9.4f, 0.116f, 12.259f, 1.881f, 14.025f)
                    curveTo(3.444f, 15.587f, 5.906f, 15.791f, 7.703f, 14.506f)
                    lineTo(7.753f, 14.472f)
                    curveTo(8.203f, 14.15f, 8.306f, 13.525f, 7.984f, 13.078f)
                    curveTo(7.662f, 12.631f, 7.037f, 12.525f, 6.591f, 12.847f)
                    lineTo(6.541f, 12.881f)
                    curveTo(5.537f, 13.597f, 4.166f, 13.484f, 3.297f, 12.613f)
                    curveTo(2.313f, 11.625f, 2.313f, 10.031f, 3.297f, 9.047f)
                    lineTo(6.803f, 5.537f)
                    curveTo(7.787f, 4.553f, 9.381f, 4.553f, 10.366f, 5.537f)
                    curveTo(11.238f, 6.409f, 11.35f, 7.781f, 10.634f, 8.784f)
                    lineTo(10.6f, 8.834f)
                    curveTo(10.278f, 9.284f, 10.384f, 9.909f, 10.831f, 10.228f)
                    curveTo(11.278f, 10.547f, 11.906f, 10.444f, 12.225f, 9.997f)
                    lineTo(12.259f, 9.947f)
                    curveTo(13.547f, 8.15f, 13.344f, 5.688f, 11.781f, 4.125f)
                    curveTo(10.016f, 2.359f, 7.156f, 2.359f, 5.391f, 4.125f)
                    lineTo(1.881f, 7.634f)
                    close()
                }
            }
        }.build()

        return _Link!!
    }

@Suppress("ObjectPropertyName")
private var _Link: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun LinkPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Link, contentDescription = null)
    }
}
