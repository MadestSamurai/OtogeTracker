package com.madsam.otora.core.icon.fa

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Fa

public val Fa.Disease: ImageVector
    get() {
        if (_disease != null) {
            return _disease!!
        }
        _disease = Builder(name = "Disease", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(300.5f, 93.4f)
                lineTo(288.0f, 112.0f)
                curveTo(268.0f, 142.0f, 234.4f, 160.0f, 198.3f, 160.0f)
                lineTo(132.0f, 160.0f)
                curveTo(94.5f, 160.0f, 64.1f, 190.4f, 64.1f, 227.9f)
                curveTo(64.1f, 245.9f, 71.3f, 263.1f, 84.0f, 275.8f)
                lineTo(111.0f, 302.8f)
                curveTo(122.0f, 313.8f, 128.2f, 328.7f, 128.2f, 344.3f)
                curveTo(128.2f, 360.1f, 121.8f, 375.2f, 110.5f, 386.3f)
                lineTo(97.4f, 399.1f)
                curveTo(86.3f, 409.9f, 80.1f, 424.8f, 80.1f, 440.3f)
                curveTo(80.1f, 477.1f, 114.2f, 504.5f, 150.2f, 496.5f)
                lineTo(212.5f, 482.7f)
                curveTo(220.2f, 481.0f, 228.2f, 480.1f, 236.1f, 480.1f)
                curveTo(268.9f, 480.1f, 300.3f, 494.7f, 321.3f, 519.9f)
                lineTo(351.8f, 556.5f)
                curveTo(362.2f, 568.9f, 377.5f, 576.1f, 393.7f, 576.1f)
                curveTo(423.8f, 576.1f, 448.2f, 551.7f, 448.2f, 521.6f)
                lineTo(448.2f, 470.4f)
                curveTo(448.2f, 429.0f, 473.6f, 391.9f, 512.2f, 376.9f)
                lineTo(534.4f, 368.3f)
                curveTo(559.6f, 358.5f, 576.2f, 334.2f, 576.2f, 307.2f)
                curveTo(576.2f, 280.8f, 560.3f, 256.9f, 535.9f, 246.7f)
                lineTo(493.0f, 228.8f)
                curveTo(459.8f, 214.9f, 435.4f, 185.8f, 427.5f, 150.7f)
                lineTo(419.6f, 115.5f)
                curveTo(412.8f, 85.4f, 386.1f, 64.0f, 355.3f, 64.0f)
                curveTo(333.3f, 64.0f, 312.7f, 75.0f, 300.5f, 93.4f)
                close()
                moveTo(224.0f, 256.0f)
                curveTo(241.7f, 256.0f, 256.0f, 270.3f, 256.0f, 288.0f)
                curveTo(256.0f, 305.7f, 241.7f, 320.0f, 224.0f, 320.0f)
                curveTo(206.3f, 320.0f, 192.0f, 305.7f, 192.0f, 288.0f)
                curveTo(192.0f, 270.3f, 206.3f, 256.0f, 224.0f, 256.0f)
                close()
                moveTo(320.0f, 256.0f)
                curveTo(320.0f, 238.3f, 334.3f, 224.0f, 352.0f, 224.0f)
                curveTo(369.7f, 224.0f, 384.0f, 238.3f, 384.0f, 256.0f)
                curveTo(384.0f, 273.7f, 369.7f, 288.0f, 352.0f, 288.0f)
                curveTo(334.3f, 288.0f, 320.0f, 273.7f, 320.0f, 256.0f)
                close()
                moveTo(352.0f, 352.0f)
                curveTo(369.7f, 352.0f, 384.0f, 366.3f, 384.0f, 384.0f)
                curveTo(384.0f, 401.7f, 369.7f, 416.0f, 352.0f, 416.0f)
                curveTo(334.3f, 416.0f, 320.0f, 401.7f, 320.0f, 384.0f)
                curveTo(320.0f, 366.3f, 334.3f, 352.0f, 352.0f, 352.0f)
                close()
            }
        }
        .build()
        return _disease!!
    }

private var _disease: ImageVector? = null
