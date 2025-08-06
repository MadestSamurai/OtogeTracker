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

public val Fa.`Cloud-moon`: ImageVector
    get() {
        if (`_cloud-moon` != null) {
            return `_cloud-moon`!!
        }
        `_cloud-moon` = Builder(name = "Cloud-moon", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 64.0f)
                curveTo(494.6f, 64.0f, 508.8f, 65.6f, 522.5f, 68.7f)
                curveTo(529.9f, 70.4f, 535.5f, 76.5f, 536.4f, 84.1f)
                curveTo(537.3f, 91.7f, 533.4f, 99.0f, 526.6f, 102.4f)
                curveTo(481.2f, 125.0f, 450.0f, 171.9f, 450.0f, 226.0f)
                curveTo(450.0f, 302.2f, 511.8f, 364.0f, 588.0f, 364.0f)
                curveTo(591.7f, 364.0f, 595.4f, 363.9f, 599.1f, 363.6f)
                curveTo(606.7f, 363.0f, 613.8f, 367.2f, 616.9f, 374.2f)
                curveTo(620.0f, 381.2f, 618.4f, 389.3f, 613.0f, 394.6f)
                curveTo(587.0f, 419.6f, 553.9f, 437.3f, 517.1f, 444.5f)
                curveTo(506.0f, 419.2f, 486.9f, 398.2f, 463.0f, 384.7f)
                curveTo(455.4f, 321.3f, 401.4f, 272.1f, 335.9f, 272.1f)
                curveTo(324.7f, 272.1f, 313.8f, 273.6f, 303.4f, 276.3f)
                curveTo(298.6f, 272.1f, 293.5f, 268.1f, 288.2f, 264.5f)
                curveTo(288.1f, 261.7f, 288.0f, 258.9f, 288.0f, 256.1f)
                curveTo(288.0f, 150.1f, 374.0f, 64.1f, 480.0f, 64.1f)
                close()
                moveTo(479.9f, 495.9f)
                curveTo(479.9f, 540.1f, 444.1f, 575.9f, 399.9f, 575.9f)
                lineTo(128.0f, 575.9f)
                curveTo(75.0f, 575.9f, 32.0f, 532.9f, 32.0f, 479.9f)
                curveTo(32.0f, 432.3f, 66.6f, 392.9f, 112.0f, 385.3f)
                curveTo(111.6f, 332.5f, 154.9f, 288.0f, 208.0f, 288.0f)
                curveTo(242.9f, 288.0f, 273.4f, 306.6f, 290.2f, 334.4f)
                curveTo(303.2f, 325.3f, 319.0f, 320.0f, 336.0f, 320.0f)
                curveTo(380.2f, 320.0f, 416.0f, 355.8f, 416.0f, 400.0f)
                curveTo(416.0f, 405.9f, 415.4f, 411.7f, 414.1f, 417.2f)
                curveTo(451.5f, 423.9f, 479.9f, 456.6f, 479.9f, 495.9f)
                close()
            }
        }
        .build()
        return `_cloud-moon`!!
    }

private var `_cloud-moon`: ImageVector? = null
