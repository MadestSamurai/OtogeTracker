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

val Download: ImageVector
    get() {
        if (_Download != null) {
            return _Download!!
        }
        _Download = ImageVector.Builder(
            name = "Download",
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
                    moveTo(9f, 1f)
                    curveTo(9f, 0.447f, 8.553f, 0f, 8f, 0f)
                    curveTo(7.447f, 0f, 7f, 0.447f, 7f, 1f)
                    verticalLineTo(8.584f)
                    lineTo(4.706f, 6.291f)
                    curveTo(4.316f, 5.9f, 3.681f, 5.9f, 3.291f, 6.291f)
                    curveTo(2.9f, 6.681f, 2.9f, 7.316f, 3.291f, 7.706f)
                    lineTo(7.291f, 11.706f)
                    curveTo(7.681f, 12.097f, 8.316f, 12.097f, 8.706f, 11.706f)
                    lineTo(12.706f, 7.706f)
                    curveTo(13.097f, 7.316f, 13.097f, 6.681f, 12.706f, 6.291f)
                    curveTo(12.316f, 5.9f, 11.681f, 5.9f, 11.291f, 6.291f)
                    lineTo(9f, 8.584f)
                    verticalLineTo(1f)
                    close()
                    moveTo(2f, 11f)
                    curveTo(0.897f, 11f, 0f, 11.897f, 0f, 13f)
                    verticalLineTo(14f)
                    curveTo(0f, 15.103f, 0.897f, 16f, 2f, 16f)
                    horizontalLineTo(14f)
                    curveTo(15.103f, 16f, 16f, 15.103f, 16f, 14f)
                    verticalLineTo(13f)
                    curveTo(16f, 11.897f, 15.103f, 11f, 14f, 11f)
                    horizontalLineTo(10.828f)
                    lineTo(9.413f, 12.416f)
                    curveTo(8.631f, 13.197f, 7.366f, 13.197f, 6.584f, 12.416f)
                    lineTo(5.172f, 11f)
                    horizontalLineTo(2f)
                    close()
                    moveTo(13.5f, 12.75f)
                    curveTo(13.699f, 12.75f, 13.89f, 12.829f, 14.03f, 12.97f)
                    curveTo(14.171f, 13.11f, 14.25f, 13.301f, 14.25f, 13.5f)
                    curveTo(14.25f, 13.699f, 14.171f, 13.89f, 14.03f, 14.03f)
                    curveTo(13.89f, 14.171f, 13.699f, 14.25f, 13.5f, 14.25f)
                    curveTo(13.301f, 14.25f, 13.11f, 14.171f, 12.97f, 14.03f)
                    curveTo(12.829f, 13.89f, 12.75f, 13.699f, 12.75f, 13.5f)
                    curveTo(12.75f, 13.301f, 12.829f, 13.11f, 12.97f, 12.97f)
                    curveTo(13.11f, 12.829f, 13.301f, 12.75f, 13.5f, 12.75f)
                    close()
                }
            }
        }.build()

        return _Download!!
    }

@Suppress("ObjectPropertyName")
private var _Download: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun DownloadPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Download, contentDescription = null)
    }
}
