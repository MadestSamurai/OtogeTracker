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

val XLogo: ImageVector
    get() {
        if (_XLogo != null) {
            return _XLogo!!
        }
        _XLogo = ImageVector.Builder(
            name = "XLogo",
            defaultWidth = 22.dp,
            defaultHeight = 20.dp,
            viewportWidth = 22f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(17.244f, 0.25f)
                horizontalLineTo(20.552f)
                lineTo(13.325f, 8.51f)
                lineTo(21.827f, 19.75f)
                horizontalLineTo(15.17f)
                lineTo(9.956f, 12.933f)
                lineTo(3.99f, 19.75f)
                horizontalLineTo(0.68f)
                lineTo(8.41f, 10.915f)
                lineTo(0.254f, 0.25f)
                horizontalLineTo(7.08f)
                lineTo(11.793f, 6.481f)
                lineTo(17.244f, 0.25f)
                close()
                moveTo(16.083f, 17.77f)
                horizontalLineTo(17.916f)
                lineTo(6.084f, 2.126f)
                horizontalLineTo(4.117f)
                lineTo(16.083f, 17.77f)
                close()
            }
        }.build()

        return _XLogo!!
    }

@Suppress("ObjectPropertyName")
private var _XLogo: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun XLogoPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = XLogo, contentDescription = null)
    }
}
