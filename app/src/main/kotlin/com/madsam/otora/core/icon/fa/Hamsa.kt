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

public val Fa.Hamsa: ImageVector
    get() {
        if (_hamsa != null) {
            return _hamsa!!
        }
        _hamsa = Builder(name = "Hamsa", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(98.6f, 352.0f)
                lineTo(144.0f, 352.0f)
                curveTo(152.8f, 352.0f, 160.0f, 344.8f, 160.0f, 336.0f)
                lineTo(160.0f, 136.0f)
                curveTo(160.0f, 113.9f, 177.9f, 96.0f, 200.0f, 96.0f)
                curveTo(222.1f, 96.0f, 240.0f, 113.9f, 240.0f, 136.0f)
                lineTo(240.0f, 268.0f)
                curveTo(240.0f, 279.0f, 249.0f, 288.0f, 260.0f, 288.0f)
                curveTo(271.0f, 288.0f, 280.0f, 279.0f, 280.0f, 268.0f)
                lineTo(280.0f, 104.0f)
                curveTo(280.0f, 81.9f, 297.9f, 64.0f, 320.0f, 64.0f)
                curveTo(342.1f, 64.0f, 360.0f, 81.9f, 360.0f, 104.0f)
                lineTo(360.0f, 268.0f)
                curveTo(360.0f, 279.0f, 369.0f, 288.0f, 380.0f, 288.0f)
                curveTo(391.0f, 288.0f, 400.0f, 279.0f, 400.0f, 268.0f)
                lineTo(400.0f, 136.0f)
                curveTo(400.0f, 113.9f, 417.9f, 96.0f, 440.0f, 96.0f)
                curveTo(462.1f, 96.0f, 480.0f, 113.9f, 480.0f, 136.0f)
                lineTo(480.0f, 336.0f)
                curveTo(480.0f, 344.8f, 487.2f, 352.0f, 496.0f, 352.0f)
                lineTo(541.4f, 352.0f)
                curveTo(560.5f, 352.0f, 576.0f, 367.5f, 576.0f, 386.6f)
                curveTo(576.0f, 395.2f, 572.8f, 403.5f, 567.0f, 409.9f)
                lineTo(480.6f, 505.0f)
                curveTo(439.5f, 550.2f, 381.2f, 576.0f, 320.0f, 576.0f)
                curveTo(258.8f, 576.0f, 200.6f, 550.2f, 159.4f, 505.0f)
                lineTo(73.0f, 409.9f)
                curveTo(67.2f, 403.5f, 64.0f, 395.2f, 64.0f, 386.6f)
                curveTo(64.0f, 367.5f, 79.5f, 352.0f, 98.6f, 352.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(281.6f, 352.0f, 243.2f, 387.8f, 229.4f, 402.2f)
                curveTo(225.8f, 405.9f, 224.0f, 410.9f, 224.0f, 416.0f)
                curveTo(224.0f, 421.1f, 225.8f, 426.1f, 229.4f, 429.8f)
                curveTo(243.2f, 444.2f, 281.6f, 480.0f, 320.0f, 480.0f)
                curveTo(358.4f, 480.0f, 396.8f, 444.2f, 410.6f, 429.8f)
                curveTo(414.2f, 426.1f, 416.0f, 421.1f, 416.0f, 416.0f)
                curveTo(416.0f, 410.9f, 414.2f, 405.9f, 410.6f, 402.2f)
                curveTo(396.8f, 387.8f, 358.4f, 352.0f, 320.0f, 352.0f)
                close()
                moveTo(320.0f, 384.0f)
                curveTo(337.7f, 384.0f, 352.0f, 398.3f, 352.0f, 416.0f)
                curveTo(352.0f, 433.7f, 337.7f, 448.0f, 320.0f, 448.0f)
                curveTo(302.3f, 448.0f, 288.0f, 433.7f, 288.0f, 416.0f)
                curveTo(288.0f, 398.3f, 302.3f, 384.0f, 320.0f, 384.0f)
                close()
            }
        }
        .build()
        return _hamsa!!
    }

private var _hamsa: ImageVector? = null
