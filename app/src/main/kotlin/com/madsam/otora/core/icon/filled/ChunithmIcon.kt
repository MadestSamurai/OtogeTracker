package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ChunithmIcon: ImageVector
    get() {
        if (_ChunithmIcon != null) {
            return _ChunithmIcon!!
        }
        _ChunithmIcon = ImageVector.Builder(
            name = "ChunithmIcon",
            defaultWidth = 22.dp,
            defaultHeight = 24.dp,
            viewportWidth = 22f,
            viewportHeight = 24f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(22f)
                    verticalLineToRelative(24f)
                    horizontalLineToRelative(-22f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(21.108f, 3.972f)
                    curveTo(20.525f, 4.466f, 20.053f, 4.858f, 19.507f, 5.32f)
                    curveTo(22.532f, 9.384f, 22.99f, 13.517f, 19.866f, 18.121f)
                    curveTo(20.497f, 18.542f, 20.949f, 18.842f, 21.542f, 19.262f)
                    curveTo(16.976f, 24.905f, 9.492f, 25.492f, 4.351f, 21.114f)
                    curveTo(-0.995f, 16.574f, -1.461f, 8.853f, 3.212f, 3.888f)
                    curveTo(8.441f, -1.672f, 16.925f, -0.933f, 21.108f, 3.972f)
                    close()
                    moveTo(12.097f, 5.902f)
                    curveTo(8.404f, 5.911f, 5.719f, 8.479f, 5.719f, 12.002f)
                    curveTo(5.719f, 15.457f, 8.516f, 18.269f, 12.055f, 18.292f)
                    curveTo(15.258f, 18.311f, 18.512f, 16.228f, 18.498f, 11.933f)
                    curveTo(18.484f, 8.336f, 15.622f, 5.648f, 12.097f, 5.907f)
                    verticalLineTo(5.902f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(12.102f, 9.093f)
                    curveTo(13.89f, 9.079f, 15.029f, 10.151f, 15.039f, 11.854f)
                    curveTo(15.043f, 13.591f, 13.932f, 14.718f, 12.191f, 14.732f)
                    curveTo(10.416f, 14.75f, 9.324f, 13.688f, 9.296f, 11.928f)
                    curveTo(9.268f, 10.1f, 10.248f, 9.111f, 12.102f, 9.093f)
                    close()
                }
            }
        }.build()

        return _ChunithmIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ChunithmIcon: ImageVector? = null