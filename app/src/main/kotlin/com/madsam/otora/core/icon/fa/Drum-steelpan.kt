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

public val Fa.`Drum-steelpan`: ImageVector
    get() {
        if (`_drum-steelpan` != null) {
            return `_drum-steelpan`!!
        }
        `_drum-steelpan` = Builder(name = "Drum-steelpan", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 96.0f)
                curveTo(479.1f, 96.0f, 608.0f, 144.0f, 608.0f, 224.0f)
                lineTo(608.0f, 416.0f)
                curveTo(608.0f, 496.0f, 479.1f, 544.0f, 320.0f, 544.0f)
                curveTo(160.9f, 544.0f, 32.0f, 496.0f, 32.0f, 416.0f)
                lineTo(32.0f, 224.0f)
                curveTo(32.0f, 144.0f, 160.9f, 96.0f, 320.0f, 96.0f)
                close()
                moveTo(560.0f, 224.0f)
                curveTo(560.0f, 214.1f, 552.0f, 194.1f, 505.0f, 174.2f)
                curveTo(486.4f, 166.3f, 464.1f, 159.8f, 439.0f, 154.8f)
                lineTo(411.2f, 198.4f)
                curveTo(403.9f, 209.9f, 400.0f, 223.2f, 400.0f, 236.8f)
                curveTo(400.0f, 254.3f, 406.4f, 271.2f, 418.1f, 284.3f)
                lineTo(427.9f, 295.3f)
                curveTo(457.7f, 290.1f, 483.8f, 282.8f, 505.1f, 273.8f)
                curveTo(552.2f, 253.9f, 560.1f, 233.9f, 560.1f, 224.0f)
                close()
                moveTo(381.2f, 301.3f)
                curveTo(373.2f, 275.1f, 348.8f, 256.0f, 320.0f, 256.0f)
                curveTo(291.2f, 256.0f, 266.7f, 275.1f, 258.8f, 301.3f)
                curveTo(278.2f, 303.0f, 298.7f, 304.0f, 320.0f, 304.0f)
                curveTo(341.3f, 304.0f, 361.8f, 303.1f, 381.2f, 301.3f)
                close()
                moveTo(201.0f, 154.8f)
                curveTo(175.8f, 159.8f, 153.6f, 166.4f, 135.0f, 174.2f)
                curveTo(87.9f, 194.1f, 80.0f, 214.1f, 80.0f, 224.0f)
                curveTo(80.0f, 233.9f, 88.0f, 253.9f, 135.0f, 273.8f)
                curveTo(156.3f, 282.8f, 182.4f, 290.1f, 212.2f, 295.3f)
                lineTo(222.0f, 284.3f)
                curveTo(233.6f, 271.2f, 240.1f, 254.3f, 240.1f, 236.8f)
                curveTo(240.1f, 223.2f, 236.2f, 209.9f, 228.9f, 198.4f)
                lineTo(201.0f, 154.8f)
                close()
                moveTo(257.3f, 146.8f)
                curveTo(256.4f, 151.1f, 255.9f, 155.5f, 255.9f, 160.0f)
                curveTo(255.9f, 195.3f, 284.6f, 224.0f, 319.9f, 224.0f)
                curveTo(355.2f, 224.0f, 383.9f, 195.3f, 383.9f, 160.0f)
                curveTo(383.9f, 155.5f, 383.4f, 151.0f, 382.5f, 146.8f)
                curveTo(362.7f, 145.0f, 341.7f, 144.0f, 319.9f, 144.0f)
                curveTo(298.1f, 144.0f, 277.1f, 145.0f, 257.3f, 146.8f)
                close()
            }
        }
        .build()
        return `_drum-steelpan`!!
    }

private var `_drum-steelpan`: ImageVector? = null
