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

public val Fa.Upload: ImageVector
    get() {
        if (_upload != null) {
            return _upload!!
        }
        _upload = Builder(name = "Upload", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 173.3f)
                lineTo(352.0f, 384.0f)
                curveTo(352.0f, 401.7f, 337.7f, 416.0f, 320.0f, 416.0f)
                curveTo(302.3f, 416.0f, 288.0f, 401.7f, 288.0f, 384.0f)
                lineTo(288.0f, 173.3f)
                lineTo(246.6f, 214.7f)
                curveTo(234.1f, 227.2f, 213.8f, 227.2f, 201.3f, 214.7f)
                curveTo(188.8f, 202.2f, 188.8f, 181.9f, 201.3f, 169.4f)
                lineTo(297.3f, 73.4f)
                curveTo(309.8f, 60.9f, 330.1f, 60.9f, 342.6f, 73.4f)
                lineTo(438.6f, 169.4f)
                curveTo(451.1f, 181.9f, 451.1f, 202.2f, 438.6f, 214.7f)
                curveTo(426.1f, 227.2f, 405.8f, 227.2f, 393.3f, 214.7f)
                lineTo(352.0f, 173.3f)
                close()
                moveTo(320.0f, 464.0f)
                curveTo(364.2f, 464.0f, 400.0f, 428.2f, 400.0f, 384.0f)
                lineTo(480.0f, 384.0f)
                curveTo(515.3f, 384.0f, 544.0f, 412.7f, 544.0f, 448.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 515.3f, 515.3f, 544.0f, 480.0f, 544.0f)
                lineTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 412.7f, 124.7f, 384.0f, 160.0f, 384.0f)
                lineTo(240.0f, 384.0f)
                curveTo(240.0f, 428.2f, 275.8f, 464.0f, 320.0f, 464.0f)
                close()
                moveTo(464.0f, 488.0f)
                curveTo(477.3f, 488.0f, 488.0f, 477.3f, 488.0f, 464.0f)
                curveTo(488.0f, 450.7f, 477.3f, 440.0f, 464.0f, 440.0f)
                curveTo(450.7f, 440.0f, 440.0f, 450.7f, 440.0f, 464.0f)
                curveTo(440.0f, 477.3f, 450.7f, 488.0f, 464.0f, 488.0f)
                close()
            }
        }
        .build()
        return _upload!!
    }

private var _upload: ImageVector? = null
