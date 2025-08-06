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

public val Fa.Comment: ImageVector
    get() {
        if (_comment != null) {
            return _comment!!
        }
        _comment = Builder(name = "Comment", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 304.0f)
                curveTo(576.0f, 436.5f, 461.4f, 544.0f, 320.0f, 544.0f)
                curveTo(282.9f, 544.0f, 247.7f, 536.6f, 215.9f, 523.3f)
                lineTo(97.5f, 574.1f)
                curveTo(88.1f, 578.1f, 77.3f, 575.8f, 70.4f, 568.3f)
                curveTo(63.5f, 560.8f, 62.0f, 549.8f, 66.8f, 540.8f)
                lineTo(115.6f, 448.6f)
                curveTo(83.2f, 408.3f, 64.0f, 358.3f, 64.0f, 304.0f)
                curveTo(64.0f, 171.5f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 171.5f, 576.0f, 304.0f)
                close()
            }
        }
        .build()
        return _comment!!
    }

private var _comment: ImageVector? = null
