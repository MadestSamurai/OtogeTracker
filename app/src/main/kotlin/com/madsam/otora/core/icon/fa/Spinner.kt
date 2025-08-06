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

public val Fa.Spinner: ImageVector
    get() {
        if (_spinner != null) {
            return _spinner!!
        }
        _spinner = Builder(name = "Spinner", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.0f, 112.0f)
                curveTo(272.0f, 85.5f, 293.5f, 64.0f, 320.0f, 64.0f)
                curveTo(346.5f, 64.0f, 368.0f, 85.5f, 368.0f, 112.0f)
                curveTo(368.0f, 138.5f, 346.5f, 160.0f, 320.0f, 160.0f)
                curveTo(293.5f, 160.0f, 272.0f, 138.5f, 272.0f, 112.0f)
                close()
                moveTo(272.0f, 528.0f)
                curveTo(272.0f, 501.5f, 293.5f, 480.0f, 320.0f, 480.0f)
                curveTo(346.5f, 480.0f, 368.0f, 501.5f, 368.0f, 528.0f)
                curveTo(368.0f, 554.5f, 346.5f, 576.0f, 320.0f, 576.0f)
                curveTo(293.5f, 576.0f, 272.0f, 554.5f, 272.0f, 528.0f)
                close()
                moveTo(112.0f, 272.0f)
                curveTo(138.5f, 272.0f, 160.0f, 293.5f, 160.0f, 320.0f)
                curveTo(160.0f, 346.5f, 138.5f, 368.0f, 112.0f, 368.0f)
                curveTo(85.5f, 368.0f, 64.0f, 346.5f, 64.0f, 320.0f)
                curveTo(64.0f, 293.5f, 85.5f, 272.0f, 112.0f, 272.0f)
                close()
                moveTo(480.0f, 320.0f)
                curveTo(480.0f, 293.5f, 501.5f, 272.0f, 528.0f, 272.0f)
                curveTo(554.5f, 272.0f, 576.0f, 293.5f, 576.0f, 320.0f)
                curveTo(576.0f, 346.5f, 554.5f, 368.0f, 528.0f, 368.0f)
                curveTo(501.5f, 368.0f, 480.0f, 346.5f, 480.0f, 320.0f)
                close()
                moveTo(139.0f, 433.1f)
                curveTo(157.8f, 414.3f, 188.1f, 414.3f, 206.9f, 433.1f)
                curveTo(225.7f, 451.9f, 225.7f, 482.2f, 206.9f, 501.0f)
                curveTo(188.1f, 519.8f, 157.8f, 519.8f, 139.0f, 501.0f)
                curveTo(120.2f, 482.2f, 120.2f, 451.9f, 139.0f, 433.1f)
                close()
                moveTo(139.0f, 139.0f)
                curveTo(157.8f, 120.2f, 188.1f, 120.2f, 206.9f, 139.0f)
                curveTo(225.7f, 157.8f, 225.7f, 188.1f, 206.9f, 206.9f)
                curveTo(188.1f, 225.7f, 157.8f, 225.7f, 139.0f, 206.9f)
                curveTo(120.2f, 188.1f, 120.2f, 157.8f, 139.0f, 139.0f)
                close()
                moveTo(501.0f, 433.1f)
                curveTo(519.8f, 451.9f, 519.8f, 482.2f, 501.0f, 501.0f)
                curveTo(482.2f, 519.8f, 451.9f, 519.8f, 433.1f, 501.0f)
                curveTo(414.3f, 482.2f, 414.3f, 451.9f, 433.1f, 433.1f)
                curveTo(451.9f, 414.3f, 482.2f, 414.3f, 501.0f, 433.1f)
                close()
            }
        }
        .build()
        return _spinner!!
    }

private var _spinner: ImageVector? = null
