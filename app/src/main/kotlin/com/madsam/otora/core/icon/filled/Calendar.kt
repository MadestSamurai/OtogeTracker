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

val Calendar: ImageVector
    get() {
        if (_Calendar != null) {
            return _Calendar!!
        }
        _Calendar = ImageVector.Builder(
            name = "Calendar",
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
                    moveTo(4f, 0f)
                    curveTo(4.553f, 0f, 5f, 0.447f, 5f, 1f)
                    verticalLineTo(2f)
                    horizontalLineTo(9f)
                    verticalLineTo(1f)
                    curveTo(9f, 0.447f, 9.447f, 0f, 10f, 0f)
                    curveTo(10.553f, 0f, 11f, 0.447f, 11f, 1f)
                    verticalLineTo(2f)
                    horizontalLineTo(12.5f)
                    curveTo(13.328f, 2f, 14f, 2.672f, 14f, 3.5f)
                    verticalLineTo(5f)
                    horizontalLineTo(0f)
                    verticalLineTo(3.5f)
                    curveTo(0f, 2.672f, 0.672f, 2f, 1.5f, 2f)
                    horizontalLineTo(3f)
                    verticalLineTo(1f)
                    curveTo(3f, 0.447f, 3.447f, 0f, 4f, 0f)
                    close()
                    moveTo(0f, 6f)
                    horizontalLineTo(14f)
                    verticalLineTo(14.5f)
                    curveTo(14f, 15.328f, 13.328f, 16f, 12.5f, 16f)
                    horizontalLineTo(1.5f)
                    curveTo(0.672f, 16f, 0f, 15.328f, 0f, 14.5f)
                    verticalLineTo(6f)
                    close()
                    moveTo(2.5f, 8f)
                    curveTo(2.225f, 8f, 2f, 8.225f, 2f, 8.5f)
                    verticalLineTo(11.5f)
                    curveTo(2f, 11.775f, 2.225f, 12f, 2.5f, 12f)
                    horizontalLineTo(5.5f)
                    curveTo(5.775f, 12f, 6f, 11.775f, 6f, 11.5f)
                    verticalLineTo(8.5f)
                    curveTo(6f, 8.225f, 5.775f, 8f, 5.5f, 8f)
                    horizontalLineTo(2.5f)
                    close()
                }
            }
        }.build()

        return _Calendar!!
    }

@Suppress("ObjectPropertyName")
private var _Calendar: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun CalendarPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Calendar, contentDescription = null)
    }
}
