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

public val Fa.Baby: ImageVector
    get() {
        if (_baby != null) {
            return _baby!!
        }
        _baby = Builder(name = "Baby", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(248.0f, 152.0f)
                curveTo(248.0f, 112.2f, 280.2f, 80.0f, 320.0f, 80.0f)
                curveTo(359.8f, 80.0f, 392.0f, 112.2f, 392.0f, 152.0f)
                curveTo(392.0f, 191.8f, 359.8f, 224.0f, 320.0f, 224.0f)
                curveTo(280.2f, 224.0f, 248.0f, 191.8f, 248.0f, 152.0f)
                close()
                moveTo(135.7f, 208.5f)
                curveTo(148.7f, 190.6f, 173.7f, 186.7f, 191.6f, 199.7f)
                lineTo(227.8f, 226.0f)
                curveTo(254.6f, 245.5f, 286.9f, 256.0f, 320.0f, 256.0f)
                curveTo(353.1f, 256.0f, 385.4f, 245.5f, 412.2f, 226.0f)
                lineTo(448.4f, 199.6f)
                curveTo(466.3f, 186.6f, 491.3f, 190.6f, 504.3f, 208.4f)
                curveTo(517.3f, 226.2f, 513.3f, 251.3f, 495.5f, 264.3f)
                lineTo(459.3f, 290.7f)
                curveTo(445.7f, 300.6f, 431.2f, 308.9f, 416.0f, 315.7f)
                lineTo(416.0f, 352.0f)
                lineTo(224.0f, 352.0f)
                lineTo(224.0f, 315.7f)
                curveTo(208.8f, 309.0f, 194.3f, 300.6f, 180.7f, 290.7f)
                lineTo(144.5f, 264.3f)
                curveTo(126.6f, 251.3f, 122.7f, 226.3f, 135.7f, 208.4f)
                close()
                moveTo(225.5f, 393.3f)
                lineTo(286.1f, 446.3f)
                lineTo(260.1f, 483.5f)
                lineTo(284.4f, 507.8f)
                curveTo(300.0f, 523.4f, 300.0f, 548.7f, 284.4f, 564.4f)
                curveTo(268.8f, 580.1f, 243.5f, 580.0f, 227.8f, 564.4f)
                lineTo(179.8f, 516.4f)
                curveTo(166.0f, 502.6f, 164.1f, 481.0f, 175.2f, 465.1f)
                lineTo(225.4f, 393.3f)
                close()
                moveTo(354.0f, 446.3f)
                lineTo(414.6f, 393.3f)
                lineTo(464.8f, 465.1f)
                curveTo(475.9f, 481.0f, 474.0f, 502.6f, 460.3f, 516.3f)
                lineTo(412.3f, 564.3f)
                curveTo(396.7f, 579.9f, 371.4f, 579.9f, 355.7f, 564.3f)
                curveTo(340.0f, 548.7f, 340.1f, 523.4f, 355.7f, 507.7f)
                lineTo(380.0f, 483.4f)
                lineTo(354.0f, 446.2f)
                close()
            }
        }
        .build()
        return _baby!!
    }

private var _baby: ImageVector? = null
