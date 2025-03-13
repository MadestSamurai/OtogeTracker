package com.madsam.otora.core.icon.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val OsuSs: ImageVector
    get() {
        if (_OsuSs != null) {
            return _OsuSs!!
        }
        _OsuSs = ImageVector.Builder(
            name = "OsuSs",
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
                path(fill = SolidColor(Color(0xFFCE1C9D))) {
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
                    fill = SolidColor(Color(0xFF5E244E)),
                    fillAlpha = 0.5f
                ) {
                    moveTo(5.339f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(13.007f)
                    curveTo(15.477f, 13.08f, 16.424f, 12.031f, 16.424f, 10.546f)
                    curveTo(16.424f, 8.779f, 15.093f, 8.126f, 13.032f, 7.96f)
                    lineTo(9f, 7.64f)
                    curveTo(7.567f, 7.525f, 7.234f, 7.269f, 7.234f, 6.782f)
                    curveTo(7.234f, 6.194f, 7.72f, 5.963f, 8.578f, 5.963f)
                    horizontalLineTo(15.861f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(8.744f)
                    curveTo(6.939f, 4.325f, 5.378f, 4.978f, 5.378f, 6.834f)
                    curveTo(5.378f, 8.446f, 6.555f, 9.15f, 8.526f, 9.304f)
                    lineTo(12.763f, 9.637f)
                    curveTo(14.018f, 9.739f, 14.542f, 10.034f, 14.542f, 10.623f)
                    curveTo(14.542f, 11.109f, 14.197f, 11.442f, 13.122f, 11.442f)
                    horizontalLineTo(5.339f)
                    close()
                    moveTo(15.757f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(23.424f)
                    curveTo(25.894f, 13.08f, 26.842f, 12.031f, 26.842f, 10.546f)
                    curveTo(26.842f, 8.779f, 25.51f, 8.126f, 23.45f, 7.96f)
                    lineTo(19.418f, 7.64f)
                    curveTo(17.984f, 7.525f, 17.651f, 7.269f, 17.651f, 6.782f)
                    curveTo(17.651f, 6.194f, 18.138f, 5.963f, 18.995f, 5.963f)
                    horizontalLineTo(26.278f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(19.162f)
                    curveTo(17.357f, 4.325f, 15.795f, 4.978f, 15.795f, 6.834f)
                    curveTo(15.795f, 8.446f, 16.973f, 9.15f, 18.944f, 9.304f)
                    lineTo(23.181f, 9.637f)
                    curveTo(24.435f, 9.739f, 24.96f, 10.034f, 24.96f, 10.623f)
                    curveTo(24.96f, 11.109f, 24.614f, 11.442f, 23.539f, 11.442f)
                    horizontalLineTo(15.757f)
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
                path(fill = SolidColor(Color(0xFFDE31AE))) {
                    moveTo(16f, -9f)
                    lineTo(33.32f, 21f)
                    horizontalLineTo(-1.321f)
                    lineTo(16f, -9f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFC30B90))) {
                    moveTo(27.5f, 3f)
                    lineTo(33.995f, 14.25f)
                    horizontalLineTo(21.005f)
                    lineTo(27.5f, 3f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFBE0089))) {
                    moveTo(7.5f, -2f)
                    lineTo(11.397f, 4.75f)
                    horizontalLineTo(3.603f)
                    lineTo(7.5f, -2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFBE0089))) {
                    moveTo(9.5f, 13f)
                    lineTo(13.397f, 19.75f)
                    horizontalLineTo(5.603f)
                    lineTo(9.5f, 13f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF5E244E)),
                    fillAlpha = 0.5f
                ) {
                    moveTo(5.339f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(13.007f)
                    curveTo(15.477f, 13.08f, 16.424f, 12.031f, 16.424f, 10.546f)
                    curveTo(16.424f, 8.779f, 15.093f, 8.126f, 13.032f, 7.96f)
                    lineTo(9f, 7.64f)
                    curveTo(7.567f, 7.525f, 7.234f, 7.269f, 7.234f, 6.782f)
                    curveTo(7.234f, 6.194f, 7.72f, 5.963f, 8.578f, 5.963f)
                    horizontalLineTo(15.861f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(8.744f)
                    curveTo(6.939f, 4.325f, 5.378f, 4.978f, 5.378f, 6.834f)
                    curveTo(5.378f, 8.446f, 6.555f, 9.15f, 8.526f, 9.304f)
                    lineTo(12.763f, 9.637f)
                    curveTo(14.018f, 9.739f, 14.542f, 10.034f, 14.542f, 10.623f)
                    curveTo(14.542f, 11.109f, 14.197f, 11.442f, 13.122f, 11.442f)
                    horizontalLineTo(5.339f)
                    close()
                    moveTo(15.757f, 11.442f)
                    verticalLineTo(13.08f)
                    horizontalLineTo(23.424f)
                    curveTo(25.894f, 13.08f, 26.842f, 12.031f, 26.842f, 10.546f)
                    curveTo(26.842f, 8.779f, 25.51f, 8.126f, 23.45f, 7.96f)
                    lineTo(19.418f, 7.64f)
                    curveTo(17.984f, 7.525f, 17.651f, 7.269f, 17.651f, 6.782f)
                    curveTo(17.651f, 6.194f, 18.138f, 5.963f, 18.995f, 5.963f)
                    horizontalLineTo(26.278f)
                    verticalLineTo(4.325f)
                    horizontalLineTo(19.162f)
                    curveTo(17.357f, 4.325f, 15.795f, 4.978f, 15.795f, 6.834f)
                    curveTo(15.795f, 8.446f, 16.973f, 9.15f, 18.944f, 9.304f)
                    lineTo(23.181f, 9.637f)
                    curveTo(24.435f, 9.739f, 24.96f, 10.034f, 24.96f, 10.623f)
                    curveTo(24.96f, 11.109f, 24.614f, 11.442f, 23.539f, 11.442f)
                    horizontalLineTo(15.757f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF5E244E))) {
                    moveTo(5.339f, 10.442f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(13.007f)
                    curveTo(15.477f, 12.08f, 16.424f, 11.031f, 16.424f, 9.546f)
                    curveTo(16.424f, 7.779f, 15.093f, 7.126f, 13.032f, 6.96f)
                    lineTo(9f, 6.64f)
                    curveTo(7.567f, 6.525f, 7.234f, 6.269f, 7.234f, 5.782f)
                    curveTo(7.234f, 5.194f, 7.72f, 4.963f, 8.578f, 4.963f)
                    horizontalLineTo(15.861f)
                    verticalLineTo(3.325f)
                    horizontalLineTo(8.744f)
                    curveTo(6.939f, 3.325f, 5.378f, 3.978f, 5.378f, 5.834f)
                    curveTo(5.378f, 7.446f, 6.555f, 8.15f, 8.526f, 8.304f)
                    lineTo(12.763f, 8.637f)
                    curveTo(14.018f, 8.739f, 14.542f, 9.034f, 14.542f, 9.622f)
                    curveTo(14.542f, 10.109f, 14.197f, 10.442f, 13.122f, 10.442f)
                    horizontalLineTo(5.339f)
                    close()
                    moveTo(15.757f, 10.442f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(23.424f)
                    curveTo(25.894f, 12.08f, 26.842f, 11.031f, 26.842f, 9.546f)
                    curveTo(26.842f, 7.779f, 25.51f, 7.126f, 23.45f, 6.96f)
                    lineTo(19.418f, 6.64f)
                    curveTo(17.984f, 6.525f, 17.651f, 6.269f, 17.651f, 5.782f)
                    curveTo(17.651f, 5.194f, 18.138f, 4.963f, 18.995f, 4.963f)
                    horizontalLineTo(26.278f)
                    verticalLineTo(3.325f)
                    horizontalLineTo(19.162f)
                    curveTo(17.357f, 3.325f, 15.795f, 3.978f, 15.795f, 5.834f)
                    curveTo(15.795f, 7.446f, 16.973f, 8.15f, 18.944f, 8.304f)
                    lineTo(23.181f, 8.637f)
                    curveTo(24.435f, 8.739f, 24.96f, 9.034f, 24.96f, 9.622f)
                    curveTo(24.96f, 10.109f, 24.614f, 10.442f, 23.539f, 10.442f)
                    horizontalLineTo(15.757f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFFE7A8),
                            1f to Color(0xFFFFB800)
                        ),
                        start = Offset(16f, 2.08f),
                        end = Offset(16f, 16f)
                    )
                ) {
                    moveTo(5.339f, 10.442f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(13.007f)
                    curveTo(15.477f, 12.08f, 16.424f, 11.031f, 16.424f, 9.546f)
                    curveTo(16.424f, 7.779f, 15.093f, 7.126f, 13.032f, 6.96f)
                    lineTo(9f, 6.64f)
                    curveTo(7.567f, 6.525f, 7.234f, 6.269f, 7.234f, 5.782f)
                    curveTo(7.234f, 5.194f, 7.72f, 4.963f, 8.578f, 4.963f)
                    horizontalLineTo(15.861f)
                    verticalLineTo(3.325f)
                    horizontalLineTo(8.744f)
                    curveTo(6.939f, 3.325f, 5.378f, 3.978f, 5.378f, 5.834f)
                    curveTo(5.378f, 7.446f, 6.555f, 8.15f, 8.526f, 8.304f)
                    lineTo(12.763f, 8.637f)
                    curveTo(14.018f, 8.739f, 14.542f, 9.034f, 14.542f, 9.622f)
                    curveTo(14.542f, 10.109f, 14.197f, 10.442f, 13.122f, 10.442f)
                    horizontalLineTo(5.339f)
                    close()
                    moveTo(15.757f, 10.442f)
                    verticalLineTo(12.08f)
                    horizontalLineTo(23.424f)
                    curveTo(25.894f, 12.08f, 26.842f, 11.031f, 26.842f, 9.546f)
                    curveTo(26.842f, 7.779f, 25.51f, 7.126f, 23.45f, 6.96f)
                    lineTo(19.418f, 6.64f)
                    curveTo(17.984f, 6.525f, 17.651f, 6.269f, 17.651f, 5.782f)
                    curveTo(17.651f, 5.194f, 18.138f, 4.963f, 18.995f, 4.963f)
                    horizontalLineTo(26.278f)
                    verticalLineTo(3.325f)
                    horizontalLineTo(19.162f)
                    curveTo(17.357f, 3.325f, 15.795f, 3.978f, 15.795f, 5.834f)
                    curveTo(15.795f, 7.446f, 16.973f, 8.15f, 18.944f, 8.304f)
                    lineTo(23.181f, 8.637f)
                    curveTo(24.435f, 8.739f, 24.96f, 9.034f, 24.96f, 9.622f)
                    curveTo(24.96f, 10.109f, 24.614f, 10.442f, 23.539f, 10.442f)
                    horizontalLineTo(15.757f)
                    close()
                }
            }
        }.build()

        return _OsuSs!!
    }

@Suppress("ObjectPropertyName")
private var _OsuSs: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun OsuSsPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = OsuSs, contentDescription = null)
    }
}
