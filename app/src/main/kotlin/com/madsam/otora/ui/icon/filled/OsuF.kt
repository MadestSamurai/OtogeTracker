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

val OsuF: ImageVector
    get() {
        if (_OsuF != null) {
            return _OsuF!!
        }
        _OsuF = ImageVector.Builder(
            name = "OsuF",
            defaultWidth = 32.dp,
            defaultHeight = 16.dp,
            viewportWidth = 32f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFFB9B9B9))) {
                moveToRelative(8f, 0f)
                horizontalLineToRelative(16f)
                curveToRelative(4.4f, 0f, 8f, 3.6f, 8f, 8f)
                horizontalLineToRelative(0f)
                curveToRelative(0f, 4.4f, -3.6f, 8f, -8f, 8f)
                horizontalLineTo(8f)
                curveTo(3.6f, 16f, 0f, 12.4f, 0f, 8f)
                horizontalLineToRelative(0f)
                curveTo(0f, 3.6f, 3.6f, 0f, 8f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFC4C4C4))) {
                moveToRelative(21.19f, 0f)
                horizontalLineToRelative(-10.38f)
                lineTo(2.74f, 14f)
                curveToRelative(1.41f, 1.24f, 3.25f, 2f, 5.26f, 2f)
                horizontalLineToRelative(16f)
                curveToRelative(2.01f, 0f, 3.85f, -0.76f, 5.26f, -2f)
                lineTo(21.19f, 0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFAFAFAF))) {
                moveToRelative(27.5f, 3f)
                lineToRelative(-6.5f, 11.2f)
                horizontalLineToRelative(8.04f)
                curveToRelative(1.25f, -1.02f, 2.19f, -2.41f, 2.64f, -3.99f)
                lineToRelative(-4.18f, -7.21f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA4A4A4))) {
                moveToRelative(6.24f, 0.2f)
                lineToRelative(-2.64f, 4.6f)
                horizontalLineToRelative(7.8f)
                lineTo(8.65f, 0f)
                horizontalLineToRelative(-0.65f)
                curveToRelative(-0.61f, 0f, -1.2f, 0.07f, -1.76f, 0.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA4A4A4))) {
                moveToRelative(8f, 16f)
                horizontalLineToRelative(3.22f)
                lineToRelative(-1.72f, -3f)
                lineToRelative(-1.71f, 2.99f)
                curveToRelative(0.07f, 0f, 0.14f, 0.01f, 0.21f, 0.01f)
                close()
            }
            path(fill = SolidColor(Color(0xFF333333))) {
                moveTo(11f, 3.9f)
                lineToRelative(10.3f, 0f)
                lineToRelative(0f, 1.3f)
                lineToRelative(-8.8f, 0f)
                lineToRelative(0f, 2.3f)
                lineToRelative(8.3f, 0f)
                lineToRelative(0f, 1.3f)
                lineToRelative(-8.3f, 0f)
                lineToRelative(0f, 3.5f)
                lineToRelative(-1.5f, 0f)
                lineToRelative(0f, -8.4f)
                close()
            }
        }.build()

        return _OsuF!!
    }

@Suppress("ObjectPropertyName")
private var _OsuF: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun OsuFPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = OsuF, contentDescription = null)
    }
}
