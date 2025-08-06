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

public val Fa.Users: ImageVector
    get() {
        if (_users != null) {
            return _users!!
        }
        _users = Builder(name = "Users", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 80.0f)
                curveTo(377.4f, 80.0f, 424.0f, 126.6f, 424.0f, 184.0f)
                curveTo(424.0f, 241.4f, 377.4f, 288.0f, 320.0f, 288.0f)
                curveTo(262.6f, 288.0f, 216.0f, 241.4f, 216.0f, 184.0f)
                curveTo(216.0f, 126.6f, 262.6f, 80.0f, 320.0f, 80.0f)
                close()
                moveTo(96.0f, 152.0f)
                curveTo(135.8f, 152.0f, 168.0f, 184.2f, 168.0f, 224.0f)
                curveTo(168.0f, 263.8f, 135.8f, 296.0f, 96.0f, 296.0f)
                curveTo(56.2f, 296.0f, 24.0f, 263.8f, 24.0f, 224.0f)
                curveTo(24.0f, 184.2f, 56.2f, 152.0f, 96.0f, 152.0f)
                close()
                moveTo(0.0f, 480.0f)
                curveTo(0.0f, 409.3f, 57.3f, 352.0f, 128.0f, 352.0f)
                curveTo(140.8f, 352.0f, 153.2f, 353.9f, 164.9f, 357.4f)
                curveTo(132.0f, 394.2f, 112.0f, 442.8f, 112.0f, 496.0f)
                lineTo(112.0f, 512.0f)
                curveTo(112.0f, 523.4f, 114.4f, 534.2f, 118.7f, 544.0f)
                lineTo(32.0f, 544.0f)
                curveTo(14.3f, 544.0f, 0.0f, 529.7f, 0.0f, 512.0f)
                lineTo(0.0f, 480.0f)
                close()
                moveTo(521.3f, 544.0f)
                curveTo(525.6f, 534.2f, 528.0f, 523.4f, 528.0f, 512.0f)
                lineTo(528.0f, 496.0f)
                curveTo(528.0f, 442.8f, 508.0f, 394.2f, 475.1f, 357.4f)
                curveTo(486.8f, 353.9f, 499.2f, 352.0f, 512.0f, 352.0f)
                curveTo(582.7f, 352.0f, 640.0f, 409.3f, 640.0f, 480.0f)
                lineTo(640.0f, 512.0f)
                curveTo(640.0f, 529.7f, 625.7f, 544.0f, 608.0f, 544.0f)
                lineTo(521.3f, 544.0f)
                close()
                moveTo(472.0f, 224.0f)
                curveTo(472.0f, 184.2f, 504.2f, 152.0f, 544.0f, 152.0f)
                curveTo(583.8f, 152.0f, 616.0f, 184.2f, 616.0f, 224.0f)
                curveTo(616.0f, 263.8f, 583.8f, 296.0f, 544.0f, 296.0f)
                curveTo(504.2f, 296.0f, 472.0f, 263.8f, 472.0f, 224.0f)
                close()
                moveTo(160.0f, 496.0f)
                curveTo(160.0f, 407.6f, 231.6f, 336.0f, 320.0f, 336.0f)
                curveTo(408.4f, 336.0f, 480.0f, 407.6f, 480.0f, 496.0f)
                lineTo(480.0f, 512.0f)
                curveTo(480.0f, 529.7f, 465.7f, 544.0f, 448.0f, 544.0f)
                lineTo(192.0f, 544.0f)
                curveTo(174.3f, 544.0f, 160.0f, 529.7f, 160.0f, 512.0f)
                lineTo(160.0f, 496.0f)
                close()
            }
        }
        .build()
        return _users!!
    }

private var _users: ImageVector? = null
