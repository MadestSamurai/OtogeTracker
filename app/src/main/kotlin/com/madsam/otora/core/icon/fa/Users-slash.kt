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

public val Fa.`Users-slash`: ImageVector
    get() {
        if (`_users-slash` != null) {
            return `_users-slash`!!
        }
        `_users-slash` = Builder(name = "Users-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(321.8f, 288.0f)
                curveTo(378.4f, 287.0f, 424.0f, 240.8f, 424.0f, 184.0f)
                curveTo(424.0f, 126.6f, 377.4f, 80.0f, 320.0f, 80.0f)
                curveTo(263.2f, 80.0f, 217.0f, 125.6f, 216.0f, 182.2f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(512.0f, 352.0f)
                curveTo(494.8f, 352.0f, 478.3f, 355.4f, 463.3f, 361.6f)
                lineTo(633.3f, 531.6f)
                curveTo(637.5f, 526.2f, 640.0f, 519.4f, 640.0f, 512.0f)
                lineTo(640.0f, 480.0f)
                curveTo(640.0f, 409.3f, 582.7f, 352.0f, 512.0f, 352.0f)
                close()
                moveTo(59.9f, 161.7f)
                curveTo(38.4f, 174.2f, 24.0f, 197.4f, 24.0f, 224.0f)
                curveTo(24.0f, 263.8f, 56.2f, 296.0f, 96.0f, 296.0f)
                curveTo(122.6f, 296.0f, 145.8f, 281.6f, 158.3f, 260.1f)
                lineTo(59.9f, 161.7f)
                close()
                moveTo(250.2f, 352.0f)
                curveTo(196.8f, 377.9f, 160.0f, 432.7f, 160.0f, 496.0f)
                lineTo(160.0f, 512.0f)
                curveTo(160.0f, 529.7f, 174.3f, 544.0f, 192.0f, 544.0f)
                lineTo(442.2f, 544.0f)
                lineTo(250.2f, 352.0f)
                close()
                moveTo(128.0f, 352.0f)
                curveTo(57.3f, 352.0f, 0.0f, 409.3f, 0.0f, 480.0f)
                lineTo(0.0f, 512.0f)
                curveTo(0.0f, 529.7f, 14.3f, 544.0f, 32.0f, 544.0f)
                lineTo(118.7f, 544.0f)
                curveTo(114.4f, 534.2f, 112.0f, 523.4f, 112.0f, 512.0f)
                lineTo(112.0f, 496.0f)
                curveTo(112.0f, 442.8f, 132.0f, 394.2f, 164.9f, 357.4f)
                curveTo(153.2f, 353.9f, 140.8f, 352.0f, 128.0f, 352.0f)
                close()
                moveTo(616.0f, 224.0f)
                curveTo(616.0f, 184.2f, 583.8f, 152.0f, 544.0f, 152.0f)
                curveTo(504.2f, 152.0f, 472.0f, 184.2f, 472.0f, 224.0f)
                curveTo(472.0f, 263.8f, 504.2f, 296.0f, 544.0f, 296.0f)
                curveTo(583.8f, 296.0f, 616.0f, 263.8f, 616.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_users-slash`!!
    }

private var `_users-slash`: ImageVector? = null
