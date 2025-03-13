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

val ArrowWindDown: ImageVector
    get() {
        if (_ArrowWindDown != null) {
            return _ArrowWindDown!!
        }
        _ArrowWindDown = ImageVector.Builder(
            name = "ArrowWindDown",
            defaultWidth = 18.dp,
            defaultHeight = 10.dp,
            viewportWidth = 18f,
            viewportHeight = 10f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(12f, 8f)
                curveTo(11.447f, 8f, 11f, 8.447f, 11f, 9f)
                curveTo(11f, 9.553f, 11.447f, 10f, 12f, 10f)
                horizontalLineTo(17f)
                curveTo(17.553f, 10f, 18f, 9.553f, 18f, 9f)
                verticalLineTo(4f)
                curveTo(18f, 3.447f, 17.553f, 3f, 17f, 3f)
                curveTo(16.447f, 3f, 16f, 3.447f, 16f, 4f)
                verticalLineTo(6.584f)
                lineTo(10.706f, 1.294f)
                curveTo(10.316f, 0.903f, 9.681f, 0.903f, 9.291f, 1.294f)
                lineTo(6f, 4.584f)
                lineTo(1.706f, 0.294f)
                curveTo(1.316f, -0.097f, 0.681f, -0.097f, 0.291f, 0.294f)
                curveTo(-0.1f, 0.684f, -0.1f, 1.319f, 0.291f, 1.709f)
                lineTo(5.291f, 6.709f)
                curveTo(5.681f, 7.1f, 6.316f, 7.1f, 6.706f, 6.709f)
                lineTo(10f, 3.416f)
                lineTo(14.584f, 8f)
                horizontalLineTo(12f)
                close()
            }
        }.build()

        return _ArrowWindDown!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowWindDown: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ArrowWindDownPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ArrowWindDown, contentDescription = null)
    }
}
