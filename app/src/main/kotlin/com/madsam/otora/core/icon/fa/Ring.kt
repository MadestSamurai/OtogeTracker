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

public val Fa.Ring: ImageVector
    get() {
        if (_ring != null) {
            return _ring!!
        }
        _ring = Builder(name = "Ring", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 272.0f)
                curveTo(128.0f, 279.8f, 132.4f, 290.7f, 145.1f, 302.3f)
                curveTo(190.5f, 278.1f, 252.8f, 264.0f, 320.0f, 264.0f)
                curveTo(387.2f, 264.0f, 449.5f, 278.1f, 494.9f, 302.3f)
                curveTo(507.7f, 290.7f, 512.0f, 279.8f, 512.0f, 272.0f)
                curveTo(512.0f, 259.7f, 501.2f, 240.0f, 464.1f, 221.4f)
                curveTo(428.9f, 203.8f, 378.0f, 192.0f, 320.0f, 192.0f)
                curveTo(262.0f, 192.0f, 211.1f, 203.8f, 175.9f, 221.4f)
                curveTo(138.8f, 240.0f, 128.0f, 259.7f, 128.0f, 272.0f)
                close()
                moveTo(320.0f, 312.0f)
                curveTo(273.0f, 312.0f, 230.7f, 319.6f, 197.1f, 331.7f)
                curveTo(230.3f, 344.1f, 272.8f, 352.0f, 320.0f, 352.0f)
                curveTo(367.2f, 352.0f, 409.7f, 344.2f, 442.9f, 331.7f)
                curveTo(409.3f, 319.6f, 367.0f, 312.0f, 320.0f, 312.0f)
                close()
                moveTo(64.0f, 272.0f)
                curveTo(64.0f, 222.4f, 103.4f, 186.2f, 147.3f, 164.2f)
                curveTo(193.1f, 141.3f, 254.3f, 128.0f, 320.0f, 128.0f)
                curveTo(385.7f, 128.0f, 446.9f, 141.3f, 492.7f, 164.2f)
                curveTo(536.6f, 186.2f, 576.0f, 222.4f, 576.0f, 272.0f)
                lineTo(576.0f, 368.0f)
                curveTo(576.0f, 417.6f, 536.6f, 453.8f, 492.7f, 475.8f)
                curveTo(446.8f, 498.7f, 385.7f, 512.0f, 320.0f, 512.0f)
                curveTo(254.3f, 512.0f, 193.1f, 498.7f, 147.3f, 475.8f)
                curveTo(103.4f, 453.8f, 64.0f, 417.6f, 64.0f, 368.0f)
                lineTo(64.0f, 272.0f)
                close()
            }
        }
        .build()
        return _ring!!
    }

private var _ring: ImageVector? = null
