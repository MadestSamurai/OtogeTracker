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

public val Fa.Tired: ImageVector
    get() {
        if (_tired != null) {
            return _tired!!
        }
        _tired = Builder(name = "Tired", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(228.7f, 392.7f)
                curveTo(250.7f, 370.7f, 282.6f, 352.0f, 320.0f, 352.0f)
                curveTo(357.4f, 352.0f, 389.3f, 370.7f, 411.3f, 392.7f)
                curveTo(422.4f, 403.8f, 431.4f, 416.1f, 437.7f, 428.1f)
                curveTo(443.9f, 439.8f, 448.0f, 452.5f, 448.0f, 464.0f)
                curveTo(448.0f, 469.2f, 445.4f, 474.2f, 441.1f, 477.2f)
                curveTo(436.8f, 480.2f, 431.3f, 480.9f, 426.4f, 479.0f)
                lineTo(405.9f, 471.3f)
                curveTo(379.0f, 461.2f, 350.4f, 456.0f, 321.6f, 456.0f)
                lineTo(318.4f, 456.0f)
                curveTo(289.6f, 456.0f, 261.1f, 461.2f, 234.1f, 471.3f)
                lineTo(213.6f, 479.0f)
                curveTo(208.7f, 480.8f, 203.2f, 480.2f, 198.9f, 477.2f)
                curveTo(194.6f, 474.2f, 192.0f, 469.2f, 192.0f, 464.0f)
                curveTo(192.0f, 452.4f, 196.2f, 439.8f, 202.3f, 428.1f)
                curveTo(208.6f, 416.1f, 217.6f, 403.8f, 228.7f, 392.7f)
                close()
                moveTo(186.6f, 223.2f)
                curveTo(191.1f, 216.4f, 199.9f, 214.0f, 207.2f, 217.7f)
                lineTo(286.8f, 257.7f)
                curveTo(292.2f, 260.4f, 295.6f, 265.9f, 295.6f, 272.0f)
                curveTo(295.6f, 278.1f, 292.2f, 283.6f, 286.8f, 286.3f)
                lineTo(207.2f, 326.3f)
                curveTo(199.9f, 329.9f, 191.1f, 327.6f, 186.6f, 320.8f)
                curveTo(182.1f, 314.0f, 183.5f, 304.9f, 189.7f, 299.7f)
                lineTo(223.0f, 272.0f)
                lineTo(189.8f, 244.3f)
                curveTo(183.6f, 239.1f, 182.2f, 230.0f, 186.7f, 223.2f)
                close()
                moveTo(450.2f, 244.3f)
                lineTo(417.0f, 272.0f)
                lineTo(450.2f, 299.7f)
                curveTo(456.4f, 304.9f, 457.8f, 314.0f, 453.3f, 320.8f)
                curveTo(448.8f, 327.6f, 440.0f, 330.0f, 432.7f, 326.3f)
                lineTo(353.1f, 286.3f)
                curveTo(347.7f, 283.6f, 344.3f, 278.1f, 344.3f, 272.0f)
                curveTo(344.3f, 265.9f, 347.7f, 260.4f, 353.1f, 257.7f)
                lineTo(432.7f, 217.7f)
                curveTo(440.0f, 214.1f, 448.8f, 216.4f, 453.3f, 223.2f)
                curveTo(457.8f, 230.0f, 456.4f, 239.1f, 450.2f, 244.3f)
                close()
            }
        }
        .build()
        return _tired!!
    }

private var _tired: ImageVector? = null
