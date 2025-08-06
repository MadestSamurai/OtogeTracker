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

public val Fa.Church: ImageVector
    get() {
        if (_church != null) {
            return _church!!
        }
        _church = Builder(name = "Church", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(344.0f, 56.0f)
                curveTo(344.0f, 42.7f, 333.3f, 32.0f, 320.0f, 32.0f)
                curveTo(306.7f, 32.0f, 296.0f, 42.7f, 296.0f, 56.0f)
                lineTo(296.0f, 80.0f)
                lineTo(264.0f, 80.0f)
                curveTo(250.7f, 80.0f, 240.0f, 90.7f, 240.0f, 104.0f)
                curveTo(240.0f, 117.3f, 250.7f, 128.0f, 264.0f, 128.0f)
                lineTo(296.0f, 128.0f)
                lineTo(296.0f, 176.0f)
                lineTo(197.4f, 241.8f)
                curveTo(184.0f, 250.7f, 176.0f, 265.6f, 176.0f, 281.7f)
                lineTo(176.0f, 320.0f)
                lineTo(96.2f, 365.6f)
                curveTo(76.3f, 377.0f, 64.0f, 398.2f, 64.0f, 421.1f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                curveTo(202.7f, 576.0f, 213.4f, 576.0f, 448.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 421.1f)
                curveTo(576.0f, 398.1f, 563.7f, 376.9f, 543.8f, 365.5f)
                lineTo(464.0f, 320.0f)
                lineTo(464.0f, 281.7f)
                curveTo(464.0f, 265.7f, 456.0f, 250.7f, 442.6f, 241.8f)
                lineTo(344.0f, 176.0f)
                lineTo(344.0f, 128.0f)
                lineTo(376.0f, 128.0f)
                curveTo(389.3f, 128.0f, 400.0f, 117.3f, 400.0f, 104.0f)
                curveTo(400.0f, 90.7f, 389.3f, 80.0f, 376.0f, 80.0f)
                lineTo(344.0f, 80.0f)
                lineTo(344.0f, 56.0f)
                close()
                moveTo(320.0f, 384.0f)
                curveTo(355.3f, 384.0f, 384.0f, 412.7f, 384.0f, 448.0f)
                lineTo(384.0f, 528.0f)
                lineTo(256.0f, 528.0f)
                lineTo(256.0f, 448.0f)
                curveTo(256.0f, 412.7f, 284.7f, 384.0f, 320.0f, 384.0f)
                close()
            }
        }
        .build()
        return _church!!
    }

private var _church: ImageVector? = null
