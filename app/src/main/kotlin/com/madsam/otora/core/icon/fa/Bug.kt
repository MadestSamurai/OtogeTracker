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

public val Fa.Bug: ImageVector
    get() {
        if (_bug != null) {
            return _bug!!
        }
        _bug = Builder(name = "Bug", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 160.0f)
                curveTo(224.0f, 107.0f, 267.0f, 64.0f, 320.0f, 64.0f)
                curveTo(373.0f, 64.0f, 416.0f, 107.0f, 416.0f, 160.0f)
                lineTo(416.0f, 163.6f)
                curveTo(416.0f, 179.3f, 403.3f, 192.0f, 387.6f, 192.0f)
                lineTo(252.5f, 192.0f)
                curveTo(236.8f, 192.0f, 224.1f, 179.3f, 224.1f, 163.6f)
                lineTo(224.1f, 160.0f)
                close()
                moveTo(569.6f, 172.8f)
                curveTo(580.2f, 186.9f, 577.3f, 207.0f, 563.2f, 217.6f)
                lineTo(465.4f, 290.9f)
                curveTo(470.7f, 299.8f, 474.7f, 309.6f, 477.2f, 320.0f)
                lineTo(576.0f, 320.0f)
                curveTo(593.7f, 320.0f, 608.0f, 334.3f, 608.0f, 352.0f)
                curveTo(608.0f, 369.7f, 593.7f, 384.0f, 576.0f, 384.0f)
                lineTo(480.0f, 384.0f)
                lineTo(480.0f, 416.0f)
                curveTo(480.0f, 418.6f, 479.9f, 421.3f, 479.8f, 423.9f)
                lineTo(563.2f, 486.4f)
                curveTo(577.3f, 497.0f, 580.2f, 517.1f, 569.6f, 531.2f)
                curveTo(559.0f, 545.3f, 538.9f, 548.2f, 524.8f, 537.6f)
                lineTo(461.7f, 490.3f)
                curveTo(438.5f, 534.5f, 395.2f, 566.5f, 344.0f, 574.2f)
                lineTo(344.0f, 344.0f)
                curveTo(344.0f, 330.7f, 333.3f, 320.0f, 320.0f, 320.0f)
                curveTo(306.7f, 320.0f, 296.0f, 330.7f, 296.0f, 344.0f)
                lineTo(296.0f, 574.2f)
                curveTo(244.8f, 566.5f, 201.5f, 534.5f, 178.3f, 490.3f)
                lineTo(115.2f, 537.6f)
                curveTo(101.1f, 548.2f, 81.0f, 545.3f, 70.4f, 531.2f)
                curveTo(59.8f, 517.1f, 62.7f, 497.0f, 76.8f, 486.4f)
                lineTo(160.2f, 423.9f)
                curveTo(160.1f, 421.3f, 160.0f, 418.7f, 160.0f, 416.0f)
                lineTo(160.0f, 384.0f)
                lineTo(64.0f, 384.0f)
                curveTo(46.3f, 384.0f, 32.0f, 369.7f, 32.0f, 352.0f)
                curveTo(32.0f, 334.3f, 46.3f, 320.0f, 64.0f, 320.0f)
                lineTo(162.8f, 320.0f)
                curveTo(165.3f, 309.6f, 169.3f, 299.8f, 174.6f, 290.9f)
                lineTo(76.8f, 217.6f)
                curveTo(62.7f, 207.0f, 59.8f, 186.9f, 70.4f, 172.8f)
                curveTo(81.0f, 158.7f, 101.1f, 155.8f, 115.2f, 166.4f)
                lineTo(224.0f, 248.0f)
                curveTo(236.3f, 242.9f, 249.8f, 240.0f, 264.0f, 240.0f)
                lineTo(376.0f, 240.0f)
                curveTo(390.2f, 240.0f, 403.7f, 242.8f, 416.0f, 248.0f)
                lineTo(524.8f, 166.4f)
                curveTo(538.9f, 155.8f, 559.0f, 158.7f, 569.6f, 172.8f)
                close()
            }
        }
        .build()
        return _bug!!
    }

private var _bug: ImageVector? = null
