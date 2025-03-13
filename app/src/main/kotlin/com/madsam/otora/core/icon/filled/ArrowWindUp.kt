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

val ArrowWindUp: ImageVector
    get() {
        if (_ArrowWindUp != null) {
            return _ArrowWindUp!!
        }
        _ArrowWindUp = ImageVector.Builder(
            name = "ArrowWindUp",
            defaultWidth = 18.dp,
            defaultHeight = 10.dp,
            viewportWidth = 18f,
            viewportHeight = 10f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(12f, 2f)
                curveTo(11.447f, 2f, 11f, 1.553f, 11f, 1f)
                curveTo(11f, 0.447f, 11.447f, 0f, 12f, 0f)
                horizontalLineTo(17f)
                curveTo(17.553f, 0f, 18f, 0.447f, 18f, 1f)
                verticalLineTo(6f)
                curveTo(18f, 6.553f, 17.553f, 7f, 17f, 7f)
                curveTo(16.447f, 7f, 16f, 6.553f, 16f, 6f)
                verticalLineTo(3.416f)
                lineTo(10.706f, 8.706f)
                curveTo(10.316f, 9.097f, 9.681f, 9.097f, 9.291f, 8.706f)
                lineTo(6f, 5.416f)
                lineTo(1.706f, 9.706f)
                curveTo(1.316f, 10.097f, 0.681f, 10.097f, 0.291f, 9.706f)
                curveTo(-0.1f, 9.316f, -0.1f, 8.681f, 0.291f, 8.291f)
                lineTo(5.291f, 3.291f)
                curveTo(5.681f, 2.9f, 6.316f, 2.9f, 6.706f, 3.291f)
                lineTo(10f, 6.584f)
                lineTo(14.584f, 2f)
                horizontalLineTo(12f)
                close()
            }
        }.build()

        return _ArrowWindUp!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowWindUp: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun ArrowWindUpPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = ArrowWindUp, contentDescription = null)
    }
}
