package com.madsam.otora.core.icon.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Heart2: ImageVector
    get() {
        if (_Heart2 != null) {
            return _Heart2!!
        }
        _Heart2 = ImageVector.Builder(
            name = "Heart2",
            defaultWidth = 30.dp,
            defaultHeight = 14.dp,
            viewportWidth = 30f,
            viewportHeight = 14f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.134f, 13.342f)
                lineTo(1.487f, 8.07f)
                curveTo(0.538f, 7.186f, 0f, 5.945f, 0f, 4.648f)
                verticalLineTo(4.467f)
                curveTo(0f, 2.283f, 1.578f, 0.42f, 3.731f, 0.061f)
                curveTo(5.156f, -0.177f, 6.606f, 0.289f, 7.625f, 1.308f)
                lineTo(8f, 1.683f)
                lineTo(8.375f, 1.308f)
                curveTo(9.394f, 0.289f, 10.844f, -0.177f, 12.269f, 0.061f)
                curveTo(13.377f, 0.246f, 14.333f, 0.829f, 15f, 1.65f)
                curveTo(15.667f, 0.829f, 16.623f, 0.246f, 17.731f, 0.061f)
                curveTo(19.156f, -0.177f, 20.606f, 0.289f, 21.625f, 1.308f)
                lineTo(22f, 1.683f)
                lineTo(22.375f, 1.308f)
                curveTo(23.394f, 0.289f, 24.844f, -0.177f, 26.269f, 0.061f)
                curveTo(28.422f, 0.42f, 30f, 2.283f, 30f, 4.467f)
                verticalLineTo(4.648f)
                curveTo(30f, 5.945f, 29.462f, 7.186f, 28.513f, 8.07f)
                lineTo(22.866f, 13.342f)
                curveTo(22.631f, 13.561f, 22.322f, 13.683f, 22f, 13.683f)
                curveTo(21.678f, 13.683f, 21.369f, 13.561f, 21.134f, 13.342f)
                lineTo(15.488f, 8.07f)
                curveTo(15.31f, 7.905f, 15.148f, 7.728f, 15f, 7.54f)
                curveTo(14.852f, 7.728f, 14.69f, 7.905f, 14.512f, 8.07f)
                lineTo(8.866f, 13.342f)
                curveTo(8.631f, 13.561f, 8.322f, 13.683f, 8f, 13.683f)
                curveTo(7.678f, 13.683f, 7.369f, 13.561f, 7.134f, 13.342f)
                close()
            }
        }.build()

        return _Heart2!!
    }

@Suppress("ObjectPropertyName")
private var _Heart2: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun Heart2Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Heart2, contentDescription = null)
    }
}
