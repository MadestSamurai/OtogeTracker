package com.madsam.otora.core.icon.filled

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OsuSh: ImageVector
    get() {
        if (_OsuSh != null) {
            return _OsuSh!!
        }
        _OsuSh = ImageVector.Builder(
            name = "OsuSh",
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
                path(fill = SolidColor(Color(0xFF00A8B5))) {
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
                path(
                    fill = SolidColor(Color(0xFF095056)),
                    fillAlpha = 0.5f
                ) {
                    moveTo(10.548f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(18.215f)
                    curveTo(20.686f, 13.08f, 21.633f, 12.031f, 21.633f, 10.546f)
                    curveTo(21.633f, 8.779f, 20.302f, 8.126f, 18.241f, 7.96f)
                    lineTo(14.209f, 7.64f)
                    curveTo(12.775f, 7.525f, 12.442f, 7.269f, 12.442f, 6.782f)
                    curveTo(12.442f, 6.194f, 12.929f, 5.963f, 13.786f, 5.963f)
                    horizontalLineTo(21.07f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(13.953f)
                    curveTo(12.148f, 4.325f, 10.586f, 4.978f, 10.586f, 6.834f)
                    curveTo(10.586f, 8.446f, 11.764f, 9.15f, 13.735f, 9.304f)
                    lineTo(17.972f, 9.637f)
                    curveTo(19.226f, 9.739f, 19.751f, 10.034f, 19.751f, 10.623f)
                    curveTo(19.751f, 11.109f, 19.406f, 11.442f, 18.33f, 11.442f)
                    horizontalLineTo(10.548f)
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
                path(fill = SolidColor(Color(0xFF02B5C3))) {
                    moveTo(16f, -9f)
                    lineTo(33.32f, 21f)
                    horizontalLineTo(-1.321f)
                    lineTo(16f, -9f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF009DAA))) {
                    moveTo(27.5f, 3f)
                    lineTo(33.995f, 14.25f)
                    horizontalLineTo(21.005f)
                    lineTo(27.5f, 3f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0096A2))) {
                    moveTo(7.5f, -2f)
                    lineTo(11.397f, 4.75f)
                    horizontalLineTo(3.603f)
                    lineTo(7.5f, -2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0096A2))) {
                    moveTo(9.5f, 13f)
                    lineTo(13.397f, 19.75f)
                    horizontalLineTo(5.603f)
                    lineTo(9.5f, 13f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF095056)),
                    fillAlpha = 0.5f
                ) {
                    moveTo(10.548f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(18.215f)
                    curveTo(20.686f, 13.08f, 21.633f, 12.031f, 21.633f, 10.546f)
                    curveTo(21.633f, 8.779f, 20.302f, 8.126f, 18.241f, 7.96f)
                    lineTo(14.209f, 7.64f)
                    curveTo(12.775f, 7.525f, 12.442f, 7.269f, 12.442f, 6.782f)
                    curveTo(12.442f, 6.194f, 12.929f, 5.963f, 13.786f, 5.963f)
                    horizontalLineTo(21.07f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(13.953f)
                    curveTo(12.148f, 4.325f, 10.586f, 4.978f, 10.586f, 6.834f)
                    curveTo(10.586f, 8.446f, 11.764f, 9.15f, 13.735f, 9.304f)
                    lineTo(17.972f, 9.637f)
                    curveTo(19.226f, 9.739f, 19.751f, 10.034f, 19.751f, 10.623f)
                    curveTo(19.751f, 11.109f, 19.406f, 11.442f, 18.33f, 11.442f)
                    horizontalLineTo(10.548f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFFFFFF),
                            1f to Color(0xFFAADFF0)
                        ),
                        start = Offset(16f, 2.08f),
                        end = Offset(16f, 16f)
                    )
                ) {
                    moveTo(10.548f, 10.442f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(18.215f)
                    curveTo(20.686f, 12.08f, 21.633f, 11.031f, 21.633f, 9.546f)
                    curveTo(21.633f, 7.779f, 20.302f, 7.126f, 18.241f, 6.96f)
                    lineTo(14.209f, 6.64f)
                    curveTo(12.775f, 6.525f, 12.442f, 6.269f, 12.442f, 5.782f)
                    curveTo(12.442f, 5.194f, 12.929f, 4.963f, 13.786f, 4.963f)
                    horizontalLineTo(21.07f)
                    verticalLineTo(3.325f)
                    horizontalLineTo(13.953f)
                    curveTo(12.148f, 3.325f, 10.586f, 3.978f, 10.586f, 5.834f)
                    curveTo(10.586f, 7.446f, 11.764f, 8.15f, 13.735f, 8.304f)
                    lineTo(17.972f, 8.637f)
                    curveTo(19.226f, 8.739f, 19.751f, 9.034f, 19.751f, 9.622f)
                    curveTo(19.751f, 10.109f, 19.406f, 10.442f, 18.33f, 10.442f)
                    horizontalLineTo(10.548f)
                    close()
                }
            }
        }.build()

        return _OsuSh!!
    }

@Suppress("ObjectPropertyName")
private var _OsuSh: ImageVector? = null