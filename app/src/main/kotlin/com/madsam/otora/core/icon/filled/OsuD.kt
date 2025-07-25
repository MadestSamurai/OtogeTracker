package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OsuD: ImageVector
    get() {
        if (_OsuD != null) {
            return _OsuD!!
        }
        _OsuD = ImageVector.Builder(
            name = "OsuD",
            defaultWidth = 32.dp,
            defaultHeight = 16.dp,
            viewportWidth = 32f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFFE95353))) {
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
                path(fill = SolidColor(Color(0xFFFF5A5A))) {
                    moveTo(16f, -9f)
                    lineTo(33.32f, 21f)
                    horizontalLineTo(-1.321f)
                    lineTo(16f, -9f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFDE4949))) {
                    moveTo(27.5f, 3f)
                    lineTo(33.995f, 14.25f)
                    horizontalLineTo(21.005f)
                    lineTo(27.5f, 3f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD63D3D))) {
                    moveTo(7.5f, -2f)
                    lineTo(11.397f, 4.75f)
                    horizontalLineTo(3.603f)
                    lineTo(7.5f, -2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD63D3D))) {
                    moveTo(9.5f, 13f)
                    lineTo(13.397f, 19.75f)
                    horizontalLineTo(5.603f)
                    lineTo(9.5f, 13f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF512525))) {
                    moveTo(10.838f, 12.08f)
                    horizontalLineTo(17.582f)
                    curveTo(20.522f, 12.08f, 21.53f, 10.676f, 21.53f, 7.976f)
                    curveTo(21.53f, 5.276f, 20.522f, 3.872f, 17.582f, 3.872f)
                    horizontalLineTo(10.838f)
                    verticalLineTo(12.08f)
                    close()
                    moveTo(19.778f, 7.976f)
                    curveTo(19.778f, 9.548f, 19.538f, 10.4f, 17.582f, 10.4f)
                    horizontalLineTo(12.554f)
                    verticalLineTo(5.54f)
                    horizontalLineTo(17.582f)
                    curveTo(19.538f, 5.54f, 19.778f, 6.404f, 19.778f, 7.976f)
                    close()
                }
            }
        }.build()

        return _OsuD!!
    }

@Suppress("ObjectPropertyName")
private var _OsuD: ImageVector? = null