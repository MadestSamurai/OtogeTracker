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

val ChevronLeft: ImageVector
    get() {
        if (_ChevronLeft != null) {
            return _ChevronLeft!!
        }
        _ChevronLeft = ImageVector.Builder(
            name = "ChevronLeft",
            defaultWidth = 8.dp,
            defaultHeight = 14.dp,
            viewportWidth = 8f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(0.294f, 6.294f)
                curveTo(-0.097f, 6.684f, -0.097f, 7.319f, 0.294f, 7.709f)
                lineTo(6.294f, 13.709f)
                curveTo(6.684f, 14.1f, 7.319f, 14.1f, 7.709f, 13.709f)
                curveTo(8.1f, 13.319f, 8.1f, 12.684f, 7.709f, 12.294f)
                lineTo(2.416f, 7f)
                lineTo(7.706f, 1.706f)
                curveTo(8.097f, 1.316f, 8.097f, 0.681f, 7.706f, 0.291f)
                curveTo(7.316f, -0.1f, 6.681f, -0.1f, 6.291f, 0.291f)
                lineTo(0.291f, 6.291f)
                lineTo(0.294f, 6.294f)
                close()
            }
        }.build()

        return _ChevronLeft!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronLeft: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ChevronLeftPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ChevronLeft, contentDescription = null)
    }
}
