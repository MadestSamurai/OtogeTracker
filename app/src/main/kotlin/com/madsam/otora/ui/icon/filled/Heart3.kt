package com.madsam.otora.ui.icon.filled

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

val Heart3: ImageVector
    get() {
        if (_Heart3 != null) {
            return _Heart3!!
        }
        _Heart3 = ImageVector.Builder(
            name = "Heart3",
            defaultWidth = 44.dp,
            defaultHeight = 14.dp,
            viewportWidth = 44f,
            viewportHeight = 14f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(1.487f, 8.07f)
                lineTo(7.134f, 13.342f)
                curveTo(7.369f, 13.561f, 7.678f, 13.683f, 8f, 13.683f)
                curveTo(8.322f, 13.683f, 8.631f, 13.561f, 8.866f, 13.342f)
                lineTo(14.512f, 8.07f)
                curveTo(14.69f, 7.905f, 14.852f, 7.728f, 15f, 7.54f)
                curveTo(15.148f, 7.728f, 15.31f, 7.905f, 15.488f, 8.07f)
                lineTo(21.134f, 13.342f)
                curveTo(21.369f, 13.561f, 21.678f, 13.683f, 22f, 13.683f)
                curveTo(22.322f, 13.683f, 22.631f, 13.561f, 22.866f, 13.342f)
                lineTo(28.513f, 8.07f)
                curveTo(28.69f, 7.905f, 28.852f, 7.728f, 29f, 7.54f)
                curveTo(29.148f, 7.728f, 29.31f, 7.905f, 29.487f, 8.07f)
                lineTo(35.134f, 13.342f)
                curveTo(35.369f, 13.561f, 35.678f, 13.683f, 36f, 13.683f)
                curveTo(36.322f, 13.683f, 36.631f, 13.561f, 36.866f, 13.342f)
                lineTo(42.513f, 8.07f)
                curveTo(43.463f, 7.186f, 44f, 5.945f, 44f, 4.648f)
                verticalLineTo(4.467f)
                curveTo(44f, 2.283f, 42.422f, 0.42f, 40.269f, 0.061f)
                curveTo(38.844f, -0.177f, 37.394f, 0.289f, 36.375f, 1.308f)
                lineTo(36f, 1.683f)
                lineTo(35.625f, 1.308f)
                curveTo(34.606f, 0.289f, 33.156f, -0.177f, 31.731f, 0.061f)
                curveTo(30.623f, 0.246f, 29.667f, 0.829f, 29f, 1.65f)
                curveTo(28.333f, 0.829f, 27.377f, 0.246f, 26.269f, 0.061f)
                curveTo(24.844f, -0.177f, 23.394f, 0.289f, 22.375f, 1.308f)
                lineTo(22f, 1.683f)
                lineTo(21.625f, 1.308f)
                curveTo(20.606f, 0.289f, 19.156f, -0.177f, 17.731f, 0.061f)
                curveTo(16.623f, 0.246f, 15.667f, 0.829f, 15f, 1.65f)
                curveTo(14.333f, 0.829f, 13.377f, 0.246f, 12.269f, 0.061f)
                curveTo(10.844f, -0.177f, 9.394f, 0.289f, 8.375f, 1.308f)
                lineTo(8f, 1.683f)
                lineTo(7.625f, 1.308f)
                curveTo(6.606f, 0.289f, 5.156f, -0.177f, 3.731f, 0.061f)
                curveTo(1.578f, 0.42f, 0f, 2.283f, 0f, 4.467f)
                verticalLineTo(4.648f)
                curveTo(0f, 5.945f, 0.538f, 7.186f, 1.487f, 8.07f)
                close()
            }
        }.build()

        return _Heart3!!
    }

@Suppress("ObjectPropertyName")
private var _Heart3: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun Heart3Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Heart3, contentDescription = null)
    }
}
