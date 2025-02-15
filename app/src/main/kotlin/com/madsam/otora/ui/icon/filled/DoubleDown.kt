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

val DoubleDown: ImageVector
    get() {
        if (_DoubleDown != null) {
            return _DoubleDown!!
        }
        _DoubleDown = ImageVector.Builder(
            name = "DoubleDown",
            defaultWidth = 12.dp,
            defaultHeight = 13.dp,
            viewportWidth = 12f,
            viewportHeight = 13f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(6.706f, 12.706f)
                curveTo(6.316f, 13.097f, 5.681f, 13.097f, 5.291f, 12.706f)
                lineTo(0.291f, 7.706f)
                curveTo(-0.1f, 7.316f, -0.1f, 6.681f, 0.291f, 6.291f)
                curveTo(0.681f, 5.9f, 1.316f, 5.9f, 1.706f, 6.291f)
                lineTo(6f, 10.584f)
                lineTo(10.294f, 6.294f)
                curveTo(10.684f, 5.903f, 11.319f, 5.903f, 11.709f, 6.294f)
                curveTo(12.1f, 6.684f, 12.1f, 7.319f, 11.709f, 7.709f)
                lineTo(6.709f, 12.709f)
                lineTo(6.706f, 12.706f)
                close()
                moveTo(11.706f, 1.706f)
                lineTo(6.706f, 6.706f)
                curveTo(6.316f, 7.097f, 5.681f, 7.097f, 5.291f, 6.706f)
                lineTo(0.291f, 1.706f)
                curveTo(-0.1f, 1.316f, -0.1f, 0.681f, 0.291f, 0.291f)
                curveTo(0.681f, -0.1f, 1.316f, -0.1f, 1.706f, 0.291f)
                lineTo(6f, 4.584f)
                lineTo(10.294f, 0.294f)
                curveTo(10.684f, -0.097f, 11.319f, -0.097f, 11.709f, 0.294f)
                curveTo(12.1f, 0.684f, 12.1f, 1.319f, 11.709f, 1.709f)
                lineTo(11.706f, 1.706f)
                close()
            }
        }.build()

        return _DoubleDown!!
    }

@Suppress("ObjectPropertyName")
private var _DoubleDown: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun DoubleDownPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = DoubleDown, contentDescription = null)
    }
}
