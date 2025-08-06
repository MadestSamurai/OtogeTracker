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

public val Fa.Bone: ImageVector
    get() {
        if (_bone != null) {
            return _bone!!
        }
        _bone = Builder(name = "Bone", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(197.4f, 224.0f)
                curveTo(193.5f, 224.0f, 190.2f, 221.2f, 189.3f, 217.4f)
                curveTo(179.1f, 175.3f, 141.2f, 144.0f, 96.0f, 144.0f)
                curveTo(43.0f, 144.0f, 0.0f, 187.0f, 0.0f, 240.0f)
                curveTo(0.0f, 269.1f, 12.9f, 295.1f, 33.3f, 312.7f)
                curveTo(37.6f, 316.4f, 37.6f, 323.5f, 33.3f, 327.2f)
                curveTo(12.9f, 344.8f, 0.0f, 370.9f, 0.0f, 399.9f)
                curveTo(0.0f, 452.9f, 43.0f, 495.9f, 96.0f, 495.9f)
                curveTo(141.2f, 495.9f, 179.1f, 464.6f, 189.3f, 422.5f)
                curveTo(190.2f, 418.7f, 193.5f, 415.9f, 197.4f, 415.9f)
                lineTo(442.5f, 415.9f)
                curveTo(446.4f, 415.9f, 449.7f, 418.7f, 450.6f, 422.5f)
                curveTo(460.8f, 464.6f, 498.7f, 495.9f, 543.9f, 495.9f)
                curveTo(596.9f, 495.9f, 639.9f, 452.9f, 639.9f, 399.9f)
                curveTo(639.9f, 370.8f, 627.0f, 344.8f, 606.6f, 327.2f)
                curveTo(602.3f, 323.5f, 602.3f, 316.4f, 606.6f, 312.7f)
                curveTo(627.0f, 295.1f, 639.9f, 269.0f, 639.9f, 240.0f)
                curveTo(639.9f, 187.0f, 596.9f, 144.0f, 543.9f, 144.0f)
                curveTo(498.7f, 144.0f, 460.8f, 175.3f, 450.6f, 217.4f)
                curveTo(449.7f, 221.2f, 446.4f, 224.0f, 442.5f, 224.0f)
                lineTo(197.4f, 224.0f)
                close()
            }
        }
        .build()
        return _bone!!
    }

private var _bone: ImageVector? = null
