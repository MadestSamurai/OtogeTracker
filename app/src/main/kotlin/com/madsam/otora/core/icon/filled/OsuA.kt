package com.madsam.otora.core.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OsuA: ImageVector
    get() {
        if (_OsuA != null) {
            return _OsuA!!
        }
        _OsuA = ImageVector.Builder(
            name = "OsuA",
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
                path(fill = SolidColor(Color(0xFF7CCE14))) {
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
                path(fill = SolidColor(Color(0xFF88DA20))) {
                    moveTo(16f, -9f)
                    lineTo(33.32f, 21f)
                    horizontalLineTo(-1.321f)
                    lineTo(16f, -9f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF72C904))) {
                    moveTo(27.5f, 3f)
                    lineTo(33.995f, 14.25f)
                    horizontalLineTo(21.005f)
                    lineTo(27.5f, 3f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF69BB00))) {
                    moveTo(7.5f, -2f)
                    lineTo(11.397f, 4.75f)
                    horizontalLineTo(3.603f)
                    lineTo(7.5f, -2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF69BB00))) {
                    moveTo(9.5f, 13f)
                    lineTo(13.397f, 19.75f)
                    horizontalLineTo(5.603f)
                    lineTo(9.5f, 13f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF275227))) {
                    moveTo(18.542f, 5.492f)
                    curveTo(18.014f, 4.472f, 17.402f, 3.752f, 15.998f, 3.752f)
                    curveTo(14.594f, 3.752f, 13.97f, 4.472f, 13.454f, 5.492f)
                    lineTo(10.094f, 12.08f)
                    horizontalLineTo(11.93f)
                    lineTo(12.974f, 10.052f)
                    horizontalLineTo(19.022f)
                    lineTo(20.066f, 12.08f)
                    horizontalLineTo(21.914f)
                    lineTo(18.542f, 5.492f)
                    close()
                    moveTo(18.23f, 8.528f)
                    horizontalLineTo(13.754f)
                    lineTo(15.146f, 5.84f)
                    curveTo(15.326f, 5.492f, 15.554f, 5.276f, 15.998f, 5.276f)
                    curveTo(16.442f, 5.276f, 16.67f, 5.492f, 16.85f, 5.84f)
                    lineTo(18.23f, 8.528f)
                    close()
                }
            }
        }.build()

        return _OsuA!!
    }

@Suppress("ObjectPropertyName")
private var _OsuA: ImageVector? = null
