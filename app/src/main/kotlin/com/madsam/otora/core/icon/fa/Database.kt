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

public val Fa.Database: ImageVector
    get() {
        if (_database != null) {
            return _database!!
        }
        _database = Builder(name = "Database", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 269.8f)
                curveTo(529.2f, 279.6f, 512.2f, 287.5f, 494.5f, 293.8f)
                curveTo(447.5f, 310.6f, 385.8f, 320.0f, 320.0f, 320.0f)
                curveTo(254.2f, 320.0f, 192.4f, 310.5f, 145.5f, 293.8f)
                curveTo(127.9f, 287.5f, 110.8f, 279.6f, 96.0f, 269.8f)
                lineTo(96.0f, 352.0f)
                curveTo(96.0f, 396.2f, 196.3f, 432.0f, 320.0f, 432.0f)
                curveTo(443.7f, 432.0f, 544.0f, 396.2f, 544.0f, 352.0f)
                lineTo(544.0f, 269.8f)
                close()
                moveTo(544.0f, 192.0f)
                lineTo(544.0f, 144.0f)
                curveTo(544.0f, 99.8f, 443.7f, 64.0f, 320.0f, 64.0f)
                curveTo(196.3f, 64.0f, 96.0f, 99.8f, 96.0f, 144.0f)
                lineTo(96.0f, 192.0f)
                curveTo(96.0f, 236.2f, 196.3f, 272.0f, 320.0f, 272.0f)
                curveTo(443.7f, 272.0f, 544.0f, 236.2f, 544.0f, 192.0f)
                close()
                moveTo(494.5f, 453.8f)
                curveTo(447.6f, 470.5f, 385.9f, 480.0f, 320.0f, 480.0f)
                curveTo(254.1f, 480.0f, 192.4f, 470.5f, 145.5f, 453.8f)
                curveTo(127.9f, 447.5f, 110.8f, 439.6f, 96.0f, 429.8f)
                lineTo(96.0f, 496.0f)
                curveTo(96.0f, 540.2f, 196.3f, 576.0f, 320.0f, 576.0f)
                curveTo(443.7f, 576.0f, 544.0f, 540.2f, 544.0f, 496.0f)
                lineTo(544.0f, 429.8f)
                curveTo(529.2f, 439.6f, 512.2f, 447.5f, 494.5f, 453.8f)
                close()
            }
        }
        .build()
        return _database!!
    }

private var _database: ImageVector? = null
