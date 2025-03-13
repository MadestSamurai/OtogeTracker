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

val Gift: ImageVector
    get() {
        if (_Gift != null) {
            return _Gift!!
        }
        _Gift = ImageVector.Builder(
            name = "Gift",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(16f)
                    verticalLineToRelative(16f)
                    horizontalLineToRelative(-16f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(5.953f, 2.15f)
                    lineTo(7.041f, 4f)
                    horizontalLineTo(7f)
                    horizontalLineTo(4.75f)
                    curveTo(4.059f, 4f, 3.5f, 3.441f, 3.5f, 2.75f)
                    curveTo(3.5f, 2.059f, 4.059f, 1.5f, 4.75f, 1.5f)
                    horizontalLineTo(4.819f)
                    curveTo(5.284f, 1.5f, 5.719f, 1.747f, 5.953f, 2.15f)
                    close()
                    moveTo(2f, 2.75f)
                    curveTo(2f, 3.2f, 2.109f, 3.625f, 2.3f, 4f)
                    horizontalLineTo(1f)
                    curveTo(0.447f, 4f, 0f, 4.447f, 0f, 5f)
                    verticalLineTo(7f)
                    curveTo(0f, 7.553f, 0.447f, 8f, 1f, 8f)
                    horizontalLineTo(15f)
                    curveTo(15.553f, 8f, 16f, 7.553f, 16f, 7f)
                    verticalLineTo(5f)
                    curveTo(16f, 4.447f, 15.553f, 4f, 15f, 4f)
                    horizontalLineTo(13.7f)
                    curveTo(13.891f, 3.625f, 14f, 3.2f, 14f, 2.75f)
                    curveTo(14f, 1.231f, 12.769f, 0f, 11.25f, 0f)
                    horizontalLineTo(11.181f)
                    curveTo(10.184f, 0f, 9.259f, 0.528f, 8.753f, 1.388f)
                    lineTo(8f, 2.672f)
                    lineTo(7.247f, 1.391f)
                    curveTo(6.741f, 0.528f, 5.816f, 0f, 4.819f, 0f)
                    horizontalLineTo(4.75f)
                    curveTo(3.231f, 0f, 2f, 1.231f, 2f, 2.75f)
                    close()
                    moveTo(12.5f, 2.75f)
                    curveTo(12.5f, 3.441f, 11.941f, 4f, 11.25f, 4f)
                    horizontalLineTo(9f)
                    horizontalLineTo(8.959f)
                    lineTo(10.047f, 2.15f)
                    curveTo(10.284f, 1.747f, 10.716f, 1.5f, 11.181f, 1.5f)
                    horizontalLineTo(11.25f)
                    curveTo(11.941f, 1.5f, 12.5f, 2.059f, 12.5f, 2.75f)
                    close()
                    moveTo(1f, 9f)
                    verticalLineTo(14.5f)
                    curveTo(1f, 15.328f, 1.672f, 16f, 2.5f, 16f)
                    horizontalLineTo(7f)
                    verticalLineTo(9f)
                    horizontalLineTo(1f)
                    close()
                    moveTo(9f, 16f)
                    horizontalLineTo(13.5f)
                    curveTo(14.328f, 16f, 15f, 15.328f, 15f, 14.5f)
                    verticalLineTo(9f)
                    horizontalLineTo(9f)
                    verticalLineTo(16f)
                    close()
                }
            }
        }.build()

        return _Gift!!
    }

@Suppress("ObjectPropertyName")
private var _Gift: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun GiftPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Gift, contentDescription = null)
    }
}
