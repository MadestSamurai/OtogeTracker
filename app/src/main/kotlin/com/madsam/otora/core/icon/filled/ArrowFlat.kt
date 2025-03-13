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

val ArrowFlat: ImageVector
    get() {
        if (_ArrowFlat != null) {
            return _ArrowFlat!!
        }
        _ArrowFlat = ImageVector.Builder(
            name = "ArrowFlat",
            defaultWidth = 18.dp,
            defaultHeight = 10.dp,
            viewportWidth = 18f,
            viewportHeight = 10f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(17.706f, 5.706f)
                curveTo(18.097f, 5.316f, 18.097f, 4.681f, 17.706f, 4.291f)
                lineTo(13.706f, 0.291f)
                curveTo(13.316f, -0.1f, 12.681f, -0.1f, 12.291f, 0.291f)
                curveTo(11.9f, 0.681f, 11.9f, 1.316f, 12.291f, 1.706f)
                lineTo(14.584f, 4f)
                lineTo(1f, 4f)
                curveTo(0.447f, 4f, 0f, 4.447f, 0f, 5f)
                curveTo(0f, 5.553f, 0.447f, 6f, 1f, 6f)
                lineTo(14.584f, 6f)
                lineTo(12.291f, 8.294f)
                curveTo(11.9f, 8.684f, 11.9f, 9.319f, 12.291f, 9.709f)
                curveTo(12.681f, 10.1f, 13.316f, 10.1f, 13.706f, 9.709f)
                lineTo(17.706f, 5.709f)
                verticalLineTo(5.706f)
                close()
            }
        }.build()

        return _ArrowFlat!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowFlat: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ArrowFlatPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ArrowFlat, contentDescription = null)
    }
}
