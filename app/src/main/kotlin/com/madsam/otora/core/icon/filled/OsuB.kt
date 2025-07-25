package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OsuB: ImageVector
    get() {
        if (_OsuB != null) {
            return _OsuB!!
        }
        _OsuB = ImageVector.Builder(
            name = "OsuB",
            defaultWidth = 32.dp,
            defaultHeight = 16.dp,
            viewportWidth = 32f,
            viewportHeight = 16f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(32f)
                    verticalLineToRelative(16f)
                    horizontalLineToRelative(-32f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFFE3B130))) {
                    moveTo(8f, 0f)
                    lineTo(24f, 0f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 32f, 8f)
                    lineTo(32f, 8f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 16f)
                    lineTo(8f, 16f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 8f)
                    lineTo(0f, 8f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 0f)
                    close()
                }
            }
            group(
                clipPathData = PathData {
                    moveTo(8f, 0f)
                    lineTo(24f, 0f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 32f, 8f)
                    lineTo(32f, 8f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 24f, 16f)
                    lineTo(8f, 16f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 8f)
                    lineTo(0f, 8f)
                    arcTo(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 0f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFFEBBD48))) {
                    moveTo(16f, -9f)
                    lineTo(33.32f, 21f)
                    horizontalLineTo(-1.321f)
                    lineTo(16f, -9f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFDCA519))) {
                    moveTo(27.5f, 3f)
                    lineTo(33.995f, 14.25f)
                    horizontalLineTo(21.005f)
                    lineTo(27.5f, 3f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD99D03))) {
                    moveTo(7.5f, -2f)
                    lineTo(11.397f, 4.75f)
                    horizontalLineTo(3.603f)
                    lineTo(7.5f, -2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD99D03))) {
                    moveTo(9.5f, 13f)
                    lineTo(13.397f, 19.75f)
                    horizontalLineTo(5.603f)
                    lineTo(9.5f, 13f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF553A2B))) {
                    moveTo(21.173f, 6.044f)
                    curveTo(21.173f, 5.432f, 20.981f, 3.872f, 18.017f, 3.872f)
                    horizontalLineTo(10.997f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(18.185f)
                    curveTo(20.453f, 12.08f, 21.389f, 11.156f, 21.389f, 9.86f)
                    curveTo(21.389f, 8.924f, 20.897f, 8.216f, 19.769f, 7.892f)
                    curveTo(20.609f, 7.628f, 21.173f, 7.076f, 21.173f, 6.044f)
                    close()
                    moveTo(18.245f, 8.612f)
                    curveTo(19.373f, 8.612f, 19.697f, 9.176f, 19.697f, 9.632f)
                    curveTo(19.697f, 10.088f, 19.373f, 10.544f, 18.365f, 10.544f)
                    horizontalLineTo(12.653f)
                    verticalLineTo(8.612f)
                    horizontalLineTo(18.245f)
                    close()
                    moveTo(12.653f, 7.148f)
                    verticalLineTo(5.384f)
                    horizontalLineTo(18.245f)
                    curveTo(19.121f, 5.384f, 19.505f, 5.756f, 19.505f, 6.284f)
                    curveTo(19.505f, 6.848f, 19.061f, 7.148f, 18.125f, 7.148f)
                    horizontalLineTo(12.653f)
                    close()
                }
            }
        }.build()

        return _OsuB!!
    }

@Suppress("ObjectPropertyName")
private var _OsuB: ImageVector? = null