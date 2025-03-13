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

val OsuOnline: ImageVector
    get() {
        if (_OsuOnline != null) {
            return _OsuOnline!!
        }
        _OsuOnline = ImageVector.Builder(
            name = "OsuOnline",
            defaultWidth = 121.74.dp,
            defaultHeight = 121.74.dp,
            viewportWidth = 121.74f,
            viewportHeight = 121.74f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(60.87f, 121.74f)
                curveTo(27.31f, 121.74f, 0f, 94.43f, 0f, 60.87f)
                reflectiveCurveTo(27.31f, 0f, 60.87f, 0f)
                reflectiveCurveToRelative(60.87f, 27.31f, 60.87f, 60.87f)
                reflectiveCurveToRelative(-27.31f, 60.87f, -60.87f, 60.87f)
                close()
                moveTo(60.87f, 14f)
                curveToRelative(-25.84f, 0f, -46.87f, 21.03f, -46.87f, 46.87f)
                reflectiveCurveToRelative(21.03f, 46.87f, 46.87f, 46.87f)
                reflectiveCurveToRelative(46.87f, -21.03f, 46.87f, -46.87f)
                reflectiveCurveTo(86.72f, 14f, 60.87f, 14f)
                close()
            }
        }.build()

        return _OsuOnline!!
    }

@Suppress("ObjectPropertyName")
private var _OsuOnline: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun OsuOnlinePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = OsuOnline, contentDescription = null)
    }
}
