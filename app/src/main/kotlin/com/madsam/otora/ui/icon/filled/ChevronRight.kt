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

val ChevronRight: ImageVector
    get() {
        if (_ChevronRight != null) {
            return _ChevronRight!!
        }
        _ChevronRight = ImageVector.Builder(
            name = "ChevronRight",
            defaultWidth = 8.dp,
            defaultHeight = 14.dp,
            viewportWidth = 8f,
            viewportHeight = 14f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(7.706f, 6.294f)
                curveTo(8.097f, 6.684f, 8.097f, 7.319f, 7.706f, 7.709f)
                lineTo(1.706f, 13.709f)
                curveTo(1.316f, 14.1f, 0.681f, 14.1f, 0.291f, 13.709f)
                curveTo(-0.1f, 13.319f, -0.1f, 12.684f, 0.291f, 12.294f)
                lineTo(5.584f, 7f)
                lineTo(0.294f, 1.706f)
                curveTo(-0.097f, 1.316f, -0.097f, 0.681f, 0.294f, 0.291f)
                curveTo(0.684f, -0.1f, 1.319f, -0.1f, 1.709f, 0.291f)
                lineTo(7.709f, 6.291f)
                lineTo(7.706f, 6.294f)
                close()
            }
        }.build()

        return _ChevronRight!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronRight: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ChevronRightPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ChevronRight, contentDescription = null)
    }
}
