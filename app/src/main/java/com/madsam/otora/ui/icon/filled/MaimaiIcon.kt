package com.madsam.otora.ui.icon.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val MaimaiIcon: ImageVector
    get() {
        if (_MaimaiIcon != null) {
            return _MaimaiIcon!!
        }
        _MaimaiIcon = ImageVector.Builder(
            name = "MaimaiIcon",
            defaultWidth = 33.dp,
            defaultHeight = 32.dp,
            viewportWidth = 33f,
            viewportHeight = 32f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(33f)
                    verticalLineToRelative(32f)
                    horizontalLineToRelative(-33f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(14.836f, 0f)
                    horizontalLineTo(18.121f)
                    curveTo(27.778f, 0.91f, 34.608f, 10.276f, 32.668f, 19.571f)
                    curveTo(27.771f, 36.129f, 5.157f, 36.153f, 0.289f, 19.573f)
                    curveTo(0.285f, 19.535f, 0.268f, 19.5f, 0.243f, 19.472f)
                    curveTo(-1.317f, 9.902f, 4.753f, 1.214f, 14.836f, 0f)
                    close()
                    moveTo(23.2f, 7.895f)
                    curveTo(18.685f, 4.851f, 14.22f, 4.875f, 9.765f, 7.885f)
                    curveTo(8.889f, 7.367f, 8.452f, 7.343f, 8.019f, 7.771f)
                    curveTo(7.854f, 7.933f, 7.774f, 8.137f, 7.726f, 8.35f)
                    curveTo(7.623f, 8.804f, 7.98f, 9.105f, 8.17f, 9.437f)
                    curveTo(4.102f, 14.722f, 5.928f, 20.839f, 9.534f, 23.854f)
                    curveTo(13.282f, 26.988f, 18.915f, 27.201f, 22.936f, 24.218f)
                    curveTo(24.961f, 22.716f, 26.283f, 20.737f, 26.838f, 18.308f)
                    curveTo(27.583f, 15.044f, 26.814f, 12.093f, 24.775f, 9.471f)
                    curveTo(25.335f, 8.636f, 25.371f, 8.219f, 24.954f, 7.786f)
                    curveTo(24.528f, 7.343f, 24.052f, 7.369f, 23.2f, 7.897f)
                    verticalLineTo(7.895f)
                    close()
                    moveTo(5.023f, 17.729f)
                    curveTo(4.762f, 16.533f, 4.789f, 15.41f, 5.005f, 14.25f)
                    curveTo(3.717f, 14.001f, 2.494f, 13.763f, 1.228f, 13.518f)
                    curveTo(0.928f, 15.203f, 0.904f, 16.816f, 1.243f, 18.47f)
                    curveTo(2.515f, 18.221f, 3.721f, 17.984f, 5.023f, 17.729f)
                    close()
                    moveTo(18.256f, 27.121f)
                    curveTo(17.025f, 27.436f, 15.873f, 27.347f, 14.713f, 27.175f)
                    curveTo(14.455f, 28.435f, 14.214f, 29.621f, 13.963f, 30.848f)
                    curveTo(15.684f, 31.132f, 17.338f, 31.157f, 19.026f, 30.823f)
                    curveTo(18.766f, 29.576f, 18.523f, 28.403f, 18.258f, 27.121f)
                    horizontalLineTo(18.256f)
                    close()
                    moveTo(18.264f, 4.828f)
                    curveTo(18.522f, 3.579f, 18.766f, 2.389f, 19.026f, 1.135f)
                    curveTo(17.304f, 0.865f, 15.648f, 0.82f, 13.962f, 1.154f)
                    curveTo(14.22f, 2.399f, 14.464f, 3.585f, 14.715f, 4.793f)
                    curveTo(15.327f, 4.786f, 15.88f, 4.635f, 16.45f, 4.646f)
                    curveTo(17.023f, 4.656f, 17.584f, 4.729f, 18.264f, 4.828f)
                    close()
                    moveTo(19.978f, 30.619f)
                    curveTo(21.513f, 30.369f, 23.596f, 29.522f, 24.639f, 28.722f)
                    curveTo(23.943f, 27.713f, 23.245f, 26.704f, 22.533f, 25.671f)
                    curveTo(21.475f, 26.26f, 20.418f, 26.685f, 19.252f, 27.001f)
                    curveTo(19.5f, 28.235f, 19.74f, 29.427f, 19.978f, 30.619f)
                    close()
                    moveTo(24.673f, 3.216f)
                    curveTo(23.212f, 2.335f, 21.679f, 1.683f, 19.96f, 1.338f)
                    curveTo(19.797f, 2.604f, 19.405f, 3.769f, 19.296f, 5.012f)
                    curveTo(20.464f, 5.284f, 21.495f, 5.773f, 22.546f, 6.304f)
                    curveTo(23.26f, 5.268f, 23.949f, 4.269f, 24.673f, 3.216f)
                    close()
                    moveTo(6.544f, 10.096f)
                    curveTo(5.464f, 9.393f, 4.428f, 8.718f, 3.357f, 8.021f)
                    curveTo(2.428f, 9.463f, 1.786f, 10.948f, 1.422f, 12.598f)
                    curveTo(2.733f, 12.748f, 3.939f, 13.178f, 5.205f, 13.231f)
                    curveTo(5.494f, 12.108f, 5.946f, 11.13f, 6.543f, 10.096f)
                    horizontalLineTo(6.544f)
                    close()
                    moveTo(5.188f, 18.689f)
                    curveTo(3.898f, 18.935f, 2.676f, 19.169f, 1.417f, 19.41f)
                    curveTo(1.812f, 21.055f, 2.425f, 22.556f, 3.367f, 23.966f)
                    curveTo(4.443f, 23.262f, 5.481f, 22.58f, 6.546f, 21.882f)
                    curveTo(5.938f, 20.871f, 5.497f, 19.865f, 5.188f, 18.689f)
                    close()
                    moveTo(7.09f, 22.693f)
                    curveTo(6.021f, 23.393f, 4.969f, 24.08f, 3.906f, 24.776f)
                    curveTo(4.944f, 26.147f, 6.082f, 27.295f, 7.494f, 28.238f)
                    curveTo(8.22f, 27.179f, 8.916f, 26.166f, 9.619f, 25.14f)
                    curveTo(8.65f, 24.417f, 7.837f, 23.616f, 7.09f, 22.693f)
                    close()
                    moveTo(31.731f, 18.45f)
                    curveTo(32.032f, 16.781f, 32.056f, 15.171f, 31.717f, 13.54f)
                    curveTo(30.43f, 13.794f, 29.211f, 14.035f, 27.943f, 14.285f)
                    curveTo(28.198f, 15.451f, 28.165f, 16.571f, 27.964f, 17.709f)
                    curveTo(29.23f, 17.958f, 30.432f, 18.194f, 31.732f, 18.45f)
                    horizontalLineTo(31.731f)
                    close()
                    moveTo(8.314f, 3.203f)
                    curveTo(9.049f, 4.272f, 9.741f, 5.279f, 10.45f, 6.31f)
                    curveTo(11.499f, 5.702f, 12.565f, 5.305f, 13.726f, 4.971f)
                    curveTo(13.48f, 3.741f, 13.242f, 2.547f, 12.996f, 1.316f)
                    curveTo(11.337f, 1.695f, 9.819f, 2.286f, 8.314f, 3.203f)
                    close()
                    moveTo(13.707f, 26.984f)
                    curveTo(12.493f, 26.708f, 11.47f, 26.206f, 10.426f, 25.693f)
                    curveTo(9.711f, 26.745f, 9.024f, 27.754f, 8.34f, 28.759f)
                    curveTo(9.652f, 29.634f, 11.388f, 30.329f, 12.99f, 30.633f)
                    curveTo(13.234f, 29.44f, 13.522f, 28.254f, 13.707f, 26.983f)
                    verticalLineTo(26.984f)
                    close()
                    moveTo(26.421f, 10.117f)
                    curveTo(27.048f, 11.142f, 27.457f, 12.181f, 27.798f, 13.31f)
                    curveTo(29.061f, 13.07f, 30.288f, 12.837f, 31.558f, 12.596f)
                    curveTo(31.143f, 10.973f, 30.567f, 9.466f, 29.602f, 8.051f)
                    curveTo(28.531f, 8.746f, 27.511f, 9.408f, 26.421f, 10.115f)
                    verticalLineTo(10.117f)
                    close()
                    moveTo(27.771f, 18.669f)
                    curveTo(27.486f, 19.875f, 26.967f, 20.868f, 26.443f, 21.885f)
                    curveTo(27.525f, 22.582f, 28.56f, 23.25f, 29.625f, 23.937f)
                    curveTo(30.546f, 22.472f, 31.173f, 21.002f, 31.545f, 19.383f)
                    curveTo(30.291f, 19.145f, 29.064f, 18.913f, 27.771f, 18.669f)
                    close()
                    moveTo(25.878f, 22.669f)
                    curveTo(25.129f, 23.612f, 24.31f, 24.408f, 23.358f, 25.134f)
                    curveTo(24.076f, 26.174f, 24.781f, 27.197f, 25.498f, 28.234f)
                    curveTo(26.907f, 27.223f, 28.086f, 26.115f, 29.055f, 24.742f)
                    curveTo(27.985f, 24.045f, 26.961f, 23.375f, 25.878f, 22.669f)
                    close()
                    moveTo(3.909f, 7.22f)
                    curveTo(4.851f, 7.833f, 5.769f, 8.428f, 6.768f, 9.077f)
                    curveTo(6.726f, 8.275f, 6.81f, 7.605f, 7.362f, 7.071f)
                    curveTo(7.906f, 6.545f, 8.61f, 6.524f, 9.399f, 6.518f)
                    curveTo(8.719f, 5.534f, 8.104f, 4.644f, 7.479f, 3.738f)
                    curveTo(6.066f, 4.732f, 4.897f, 5.859f, 3.907f, 7.219f)
                    lineTo(3.909f, 7.22f)
                    close()
                    moveTo(23.559f, 6.569f)
                    curveTo(24.438f, 6.473f, 25.095f, 6.594f, 25.635f, 7.111f)
                    curveTo(26.185f, 7.637f, 26.208f, 8.324f, 26.208f, 9.102f)
                    curveTo(27.216f, 8.442f, 28.132f, 7.844f, 29.047f, 7.246f)
                    curveTo(28.152f, 5.947f, 26.761f, 4.596f, 25.479f, 3.773f)
                    curveTo(24.865f, 4.666f, 24.253f, 5.56f, 23.559f, 6.571f)
                    verticalLineTo(6.569f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(16.242f, 20.121f)
                    curveTo(15.936f, 19.892f, 15.601f, 19.674f, 15.601f, 19.148f)
                    curveTo(16.261f, 18.803f, 16.935f, 18.871f, 17.626f, 19.081f)
                    curveTo(17.793f, 19.633f, 17.358f, 19.834f, 17.085f, 20.118f)
                    curveTo(16.902f, 20.67f, 17.09f, 21.097f, 17.534f, 21.457f)
                    curveTo(17.722f, 21.611f, 17.883f, 21.8f, 18.038f, 21.988f)
                    curveTo(18.154f, 22.131f, 18.177f, 22.308f, 18.028f, 22.448f)
                    curveTo(17.864f, 22.604f, 17.667f, 22.61f, 17.497f, 22.458f)
                    curveTo(17.209f, 22.198f, 16.935f, 21.926f, 16.662f, 21.664f)
                    curveTo(16.1f, 21.85f, 15.943f, 22.647f, 15.228f, 22.538f)
                    curveTo(14.993f, 22.293f, 15.043f, 22.086f, 15.246f, 21.889f)
                    curveTo(15.439f, 21.702f, 15.621f, 21.5f, 15.834f, 21.336f)
                    curveTo(16.219f, 21.037f, 16.401f, 20.677f, 16.242f, 20.123f)
                    verticalLineTo(20.121f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(11.382f, 20.355f)
                    curveTo(10.696f, 20.372f, 10.082f, 19.802f, 10.073f, 19.14f)
                    curveTo(10.062f, 18.482f, 10.667f, 17.89f, 11.351f, 17.888f)
                    curveTo(12.015f, 17.888f, 12.578f, 18.42f, 12.6f, 19.073f)
                    curveTo(12.625f, 19.77f, 12.087f, 20.337f, 11.382f, 20.355f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(22.002f, 20.353f)
                    curveTo(21.292f, 20.356f, 20.733f, 19.805f, 20.739f, 19.11f)
                    curveTo(20.747f, 18.423f, 21.33f, 17.869f, 22.028f, 17.888f)
                    curveTo(22.705f, 17.907f, 23.228f, 18.428f, 23.238f, 19.1f)
                    curveTo(23.25f, 19.813f, 22.719f, 20.35f, 22f, 20.353f)
                    horizontalLineTo(22.002f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(24.744f, 25.404f)
                    curveTo(24.717f, 25.535f, 24.639f, 25.614f, 24.498f, 25.594f)
                    curveTo(24.396f, 25.579f, 24.315f, 25.5f, 24.321f, 25.406f)
                    curveTo(24.329f, 25.292f, 24.387f, 25.18f, 24.532f, 25.177f)
                    curveTo(24.685f, 25.174f, 24.719f, 25.289f, 24.744f, 25.404f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0A0D0D))) {
                    moveTo(26.383f, 23.927f)
                    curveTo(26.354f, 24.046f, 26.31f, 24.154f, 26.153f, 24.135f)
                    curveTo(26.046f, 24.124f, 25.969f, 24.052f, 25.956f, 23.959f)
                    curveTo(25.94f, 23.832f, 26.024f, 23.737f, 26.149f, 23.715f)
                    curveTo(26.306f, 23.688f, 26.344f, 23.814f, 26.383f, 23.925f)
                    verticalLineTo(23.927f)
                    close()
                }
            }
        }.build()

        return _MaimaiIcon!!
    }

@Suppress("ObjectPropertyName")
private var _MaimaiIcon: ImageVector? = null

@Preview(showBackground = true)
@Composable
private fun MaimaiIconPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = MaimaiIcon, contentDescription = null)
    }
}
