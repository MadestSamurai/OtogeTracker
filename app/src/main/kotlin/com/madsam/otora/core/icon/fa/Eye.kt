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

public val Fa.Eye: ImageVector
    get() {
        if (_eye != null) {
            return _eye!!
        }
        _eye = Builder(name = "Eye", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 96.0f)
                curveTo(239.2f, 96.0f, 174.5f, 132.8f, 127.4f, 176.6f)
                curveTo(80.6f, 220.1f, 49.3f, 272.0f, 34.4f, 307.7f)
                curveTo(31.1f, 315.6f, 31.1f, 324.4f, 34.4f, 332.3f)
                curveTo(49.3f, 368.0f, 80.6f, 420.0f, 127.4f, 463.4f)
                curveTo(174.5f, 507.1f, 239.2f, 544.0f, 320.0f, 544.0f)
                curveTo(400.8f, 544.0f, 465.5f, 507.2f, 512.6f, 463.4f)
                curveTo(559.4f, 419.9f, 590.7f, 368.0f, 605.6f, 332.3f)
                curveTo(608.9f, 324.4f, 608.9f, 315.6f, 605.6f, 307.7f)
                curveTo(590.7f, 272.0f, 559.4f, 220.0f, 512.6f, 176.6f)
                curveTo(465.5f, 132.9f, 400.8f, 96.0f, 320.0f, 96.0f)
                close()
                moveTo(176.0f, 320.0f)
                curveTo(176.0f, 240.5f, 240.5f, 176.0f, 320.0f, 176.0f)
                curveTo(399.5f, 176.0f, 464.0f, 240.5f, 464.0f, 320.0f)
                curveTo(464.0f, 399.5f, 399.5f, 464.0f, 320.0f, 464.0f)
                curveTo(240.5f, 464.0f, 176.0f, 399.5f, 176.0f, 320.0f)
                close()
                moveTo(320.0f, 256.0f)
                curveTo(320.0f, 291.3f, 291.3f, 320.0f, 256.0f, 320.0f)
                curveTo(244.5f, 320.0f, 233.7f, 317.0f, 224.3f, 311.6f)
                curveTo(223.3f, 322.5f, 224.2f, 333.7f, 227.2f, 344.8f)
                curveTo(240.9f, 396.0f, 293.6f, 426.4f, 344.8f, 412.7f)
                curveTo(396.0f, 399.0f, 426.4f, 346.3f, 412.7f, 295.1f)
                curveTo(400.5f, 249.4f, 357.2f, 220.3f, 311.6f, 224.3f)
                curveTo(316.9f, 233.6f, 320.0f, 244.4f, 320.0f, 256.0f)
                close()
            }
        }
        .build()
        return _eye!!
    }

private var _eye: ImageVector? = null
