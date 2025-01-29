package com.madsam.otora.ui.icon.filled

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

val ArrowUp: ImageVector
    get() {
        if (_ArrowUp != null) {
            return _ArrowUp!!
        }
        _ArrowUp = ImageVector.Builder(
            name = "ArrowUp",
            defaultWidth = 12.dp,
            defaultHeight = 14.dp,
            viewportWidth = 12f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(6.706f, 0.294f)
                curveTo(6.316f, -0.097f, 5.681f, -0.097f, 5.291f, 0.294f)
                lineTo(0.291f, 5.294f)
                curveTo(-0.1f, 5.684f, -0.1f, 6.319f, 0.291f, 6.709f)
                curveTo(0.681f, 7.1f, 1.316f, 7.1f, 1.706f, 6.709f)
                lineTo(5f, 3.412f)
                verticalLineTo(13f)
                curveTo(5f, 13.553f, 5.447f, 14f, 6f, 14f)
                curveTo(6.553f, 14f, 7f, 13.553f, 7f, 13f)
                verticalLineTo(3.416f)
                lineTo(10.294f, 6.706f)
                curveTo(10.684f, 7.097f, 11.319f, 7.097f, 11.709f, 6.706f)
                curveTo(12.1f, 6.316f, 12.1f, 5.681f, 11.709f, 5.291f)
                lineTo(6.709f, 0.291f)
                lineTo(6.706f, 0.294f)
                close()
            }
        }.build()

        return _ArrowUp!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowUp: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ArrowUpPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ArrowUp, contentDescription = null)
    }
}
