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

val Discord: ImageVector
    get() {
        if (_Discord != null) {
            return _Discord!!
        }
        _Discord = ImageVector.Builder(
            name = "Discord",
            defaultWidth = 31.dp,
            defaultHeight = 24.dp,
            viewportWidth = 31f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(26.001f, 1.953f)
                curveTo(24.002f, 1.038f, 21.879f, 0.372f, 19.662f, 0f)
                curveTo(19.383f, 0.48f, 19.073f, 1.131f, 18.856f, 1.643f)
                curveTo(16.499f, 1.302f, 14.158f, 1.302f, 11.834f, 1.643f)
                curveTo(11.617f, 1.131f, 11.291f, 0.48f, 11.028f, 0f)
                curveTo(8.796f, 0.372f, 6.672f, 1.038f, 4.687f, 1.953f)
                curveTo(0.673f, 7.874f, -0.412f, 13.655f, 0.13f, 19.358f)
                curveTo(2.796f, 21.296f, 5.369f, 22.474f, 7.897f, 23.249f)
                curveTo(8.517f, 22.412f, 9.075f, 21.513f, 9.555f, 20.567f)
                curveTo(8.641f, 20.226f, 7.773f, 19.808f, 6.936f, 19.312f)
                curveTo(7.153f, 19.157f, 7.37f, 18.987f, 7.571f, 18.816f)
                curveTo(12.624f, 21.125f, 18.097f, 21.125f, 23.088f, 18.816f)
                curveTo(23.305f, 18.987f, 23.506f, 19.157f, 23.723f, 19.312f)
                curveTo(22.886f, 19.808f, 22.018f, 20.226f, 21.104f, 20.567f)
                curveTo(21.584f, 21.513f, 22.142f, 22.412f, 22.762f, 23.249f)
                curveTo(25.288f, 22.474f, 27.877f, 21.296f, 30.529f, 19.358f)
                curveTo(31.195f, 12.756f, 29.473f, 7.021f, 26.001f, 1.953f)
                close()
                moveTo(10.253f, 15.84f)
                curveTo(8.734f, 15.84f, 7.494f, 14.461f, 7.494f, 12.771f)
                curveTo(7.494f, 11.082f, 8.703f, 9.703f, 10.253f, 9.703f)
                curveTo(11.787f, 9.703f, 13.042f, 11.082f, 13.012f, 12.771f)
                curveTo(13.012f, 14.461f, 11.787f, 15.84f, 10.253f, 15.84f)
                close()
                moveTo(20.437f, 15.84f)
                curveTo(18.918f, 15.84f, 17.677f, 14.461f, 17.677f, 12.771f)
                curveTo(17.677f, 11.082f, 18.887f, 9.703f, 20.437f, 9.703f)
                curveTo(21.972f, 9.703f, 23.227f, 11.082f, 23.196f, 12.771f)
                curveTo(23.196f, 14.461f, 21.987f, 15.84f, 20.437f, 15.84f)
                close()
            }
        }.build()

        return _Discord!!
    }

@Suppress("ObjectPropertyName")
private var _Discord: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun DiscordPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Discord, contentDescription = null)
    }
}
