package com.madsam.otora.ui.icon.filled

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

val SwitchArrow: ImageVector
    get() {
        if (_SwitchArrow != null) {
            return _SwitchArrow!!
        }
        _SwitchArrow = ImageVector.Builder(
            name = "SwitchArrow1",
            defaultWidth = 14.dp,
            defaultHeight = 16.dp,
            viewportWidth = 14f,
            viewportHeight = 16f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(14f)
                    verticalLineToRelative(16f)
                    horizontalLineToRelative(-14f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(13.706f, 4.706f)
                    curveTo(14.097f, 4.316f, 14.097f, 3.681f, 13.706f, 3.291f)
                    lineTo(10.706f, 0.291f)
                    curveTo(10.316f, -0.1f, 9.681f, -0.1f, 9.291f, 0.291f)
                    curveTo(8.9f, 0.681f, 8.9f, 1.316f, 9.291f, 1.706f)
                    lineTo(10.584f, 3f)
                    horizontalLineTo(1f)
                    curveTo(0.447f, 3f, 0f, 3.447f, 0f, 4f)
                    curveTo(0f, 4.553f, 0.447f, 5f, 1f, 5f)
                    horizontalLineTo(10.584f)
                    lineTo(9.291f, 6.294f)
                    curveTo(8.9f, 6.684f, 8.9f, 7.319f, 9.291f, 7.709f)
                    curveTo(9.681f, 8.1f, 10.316f, 8.1f, 10.706f, 7.709f)
                    lineTo(13.706f, 4.709f)
                    verticalLineTo(4.706f)
                    close()
                    moveTo(3.291f, 15.706f)
                    curveTo(3.681f, 16.097f, 4.316f, 16.097f, 4.706f, 15.706f)
                    curveTo(5.097f, 15.316f, 5.097f, 14.681f, 4.706f, 14.291f)
                    lineTo(3.416f, 13f)
                    horizontalLineTo(13f)
                    curveTo(13.553f, 13f, 14f, 12.553f, 14f, 12f)
                    curveTo(14f, 11.447f, 13.553f, 11f, 13f, 11f)
                    horizontalLineTo(3.416f)
                    lineTo(4.709f, 9.706f)
                    curveTo(5.1f, 9.316f, 5.1f, 8.681f, 4.709f, 8.291f)
                    curveTo(4.319f, 7.9f, 3.684f, 7.9f, 3.294f, 8.291f)
                    lineTo(0.294f, 11.291f)
                    curveTo(-0.097f, 11.681f, -0.097f, 12.316f, 0.294f, 12.706f)
                    lineTo(3.294f, 15.706f)
                    horizontalLineTo(3.291f)
                    close()
                }
            }
        }.build()

        return _SwitchArrow!!
    }

@Suppress("ObjectPropertyName")
private var _SwitchArrow: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun SwitchArrow1Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SwitchArrow, contentDescription = null)
    }
}
