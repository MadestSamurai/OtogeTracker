package com.madsam.otora.core.icon.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val TrashArrowUp: ImageVector
    get() {
        if (_TrashArrowUp != null) {
            return _TrashArrowUp!!
        }
        _TrashArrowUp = ImageVector.Builder(
            name = "TrashArrowUp",
            defaultWidth = 14.dp,
            defaultHeight = 16.dp,
            viewportWidth = 14f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(5.119f, 0f)
                horizontalLineTo(8.881f)
                curveTo(9.259f, 0f, 9.606f, 0.213f, 9.775f, 0.553f)
                lineTo(10f, 1f)
                horizontalLineTo(13f)
                curveTo(13.553f, 1f, 14f, 1.447f, 14f, 2f)
                curveTo(14f, 2.553f, 13.553f, 3f, 13f, 3f)
                horizontalLineTo(1f)
                curveTo(0.447f, 3f, 0f, 2.553f, 0f, 2f)
                curveTo(0f, 1.447f, 0.447f, 1f, 1f, 1f)
                horizontalLineTo(4f)
                lineTo(4.225f, 0.553f)
                curveTo(4.394f, 0.213f, 4.741f, 0f, 5.119f, 0f)
                close()
                moveTo(1f, 4f)
                horizontalLineTo(13f)
                lineTo(12.337f, 14.594f)
                curveTo(12.288f, 15.384f, 11.631f, 16f, 10.841f, 16f)
                horizontalLineTo(3.159f)
                curveTo(2.369f, 16f, 1.712f, 15.384f, 1.663f, 14.594f)
                lineTo(1f, 4f)
                close()
                moveTo(7f, 6f)
                curveTo(6.8f, 6f, 6.609f, 6.078f, 6.469f, 6.219f)
                lineTo(3.969f, 8.719f)
                curveTo(3.675f, 9.012f, 3.675f, 9.488f, 3.969f, 9.778f)
                curveTo(4.262f, 10.069f, 4.738f, 10.072f, 5.028f, 9.778f)
                lineTo(6.247f, 8.559f)
                lineTo(6.25f, 12.75f)
                curveTo(6.25f, 13.166f, 6.584f, 13.5f, 7f, 13.5f)
                curveTo(7.416f, 13.5f, 7.75f, 13.166f, 7.75f, 12.75f)
                verticalLineTo(8.559f)
                lineTo(8.969f, 9.778f)
                curveTo(9.262f, 10.072f, 9.738f, 10.072f, 10.028f, 9.778f)
                curveTo(10.319f, 9.484f, 10.322f, 9.009f, 10.028f, 8.719f)
                lineTo(7.528f, 6.219f)
                curveTo(7.387f, 6.078f, 7.197f, 6f, 6.997f, 6f)
                horizontalLineTo(7f)
                close()
            }
        }.build()

        return _TrashArrowUp!!
    }

@Suppress("ObjectPropertyName")
private var _TrashArrowUp: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun TrashArrowUpPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = TrashArrowUp, contentDescription = null)
    }
}
