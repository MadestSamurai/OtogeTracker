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

public val Fa.Baseball: ImageVector
    get() {
        if (_baseball != null) {
            return _baseball!!
        }
        _baseball = Builder(name = "Baseball", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.4f, 65.1f)
                curveTo(174.2f, 76.5f, 76.9f, 173.8f, 65.5f, 296.0f)
                curveTo(81.7f, 295.9f, 97.5f, 294.2f, 112.7f, 291.0f)
                curveTo(125.7f, 288.3f, 138.4f, 296.5f, 141.1f, 309.5f)
                curveTo(143.8f, 322.5f, 135.6f, 335.2f, 122.6f, 337.9f)
                curveTo(104.2f, 341.8f, 85.0f, 343.9f, 65.5f, 344.0f)
                curveTo(76.9f, 466.2f, 174.2f, 563.5f, 296.4f, 574.9f)
                curveTo(296.5f, 555.4f, 298.6f, 536.2f, 302.5f, 517.8f)
                curveTo(305.2f, 504.8f, 318.0f, 496.5f, 330.9f, 499.3f)
                curveTo(343.8f, 502.1f, 352.2f, 514.8f, 349.4f, 527.7f)
                curveTo(346.2f, 542.9f, 344.5f, 558.7f, 344.4f, 574.9f)
                curveTo(466.6f, 563.5f, 563.9f, 466.2f, 575.3f, 344.0f)
                curveTo(559.1f, 344.1f, 543.3f, 345.8f, 528.1f, 349.0f)
                curveTo(515.1f, 351.7f, 502.4f, 343.5f, 499.7f, 330.5f)
                curveTo(497.0f, 317.5f, 505.2f, 304.8f, 518.2f, 302.1f)
                curveTo(536.6f, 298.2f, 555.8f, 296.1f, 575.3f, 296.0f)
                curveTo(563.9f, 173.8f, 466.6f, 76.5f, 344.4f, 65.1f)
                curveTo(344.3f, 84.6f, 342.2f, 103.8f, 338.3f, 122.2f)
                curveTo(335.6f, 135.2f, 322.8f, 143.5f, 309.9f, 140.7f)
                curveTo(297.0f, 137.9f, 288.6f, 125.2f, 291.4f, 112.3f)
                curveTo(294.6f, 97.1f, 296.3f, 81.3f, 296.4f, 65.1f)
                close()
                moveTo(299.2f, 216.5f)
                curveTo(277.8f, 249.4f, 249.7f, 277.4f, 216.9f, 298.8f)
                curveTo(205.8f, 306.0f, 190.9f, 302.9f, 183.7f, 291.8f)
                curveTo(176.5f, 280.7f, 179.6f, 265.8f, 190.7f, 258.6f)
                curveTo(217.9f, 240.9f, 241.2f, 217.6f, 259.0f, 190.3f)
                curveTo(266.2f, 179.2f, 281.1f, 176.0f, 292.2f, 183.3f)
                curveTo(303.3f, 190.6f, 306.5f, 205.4f, 299.2f, 216.5f)
                close()
                moveTo(457.1f, 348.2f)
                curveTo(464.3f, 359.3f, 461.2f, 374.2f, 450.1f, 381.4f)
                curveTo(422.9f, 399.1f, 399.6f, 422.4f, 381.8f, 449.7f)
                curveTo(374.6f, 460.8f, 359.7f, 464.0f, 348.6f, 456.7f)
                curveTo(337.5f, 449.4f, 334.3f, 434.6f, 341.6f, 423.5f)
                curveTo(363.0f, 390.6f, 391.1f, 362.6f, 423.9f, 341.2f)
                curveTo(435.0f, 334.0f, 449.9f, 337.1f, 457.1f, 348.2f)
                close()
            }
        }
        .build()
        return _baseball!!
    }

private var _baseball: ImageVector? = null
