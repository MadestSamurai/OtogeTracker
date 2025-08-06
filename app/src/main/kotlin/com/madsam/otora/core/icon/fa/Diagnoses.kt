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

public val Fa.Diagnoses: ImageVector
    get() {
        if (_diagnoses != null) {
            return _diagnoses!!
        }
        _diagnoses = Builder(name = "Diagnoses", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(248.0f, 136.0f)
                curveTo(248.0f, 96.2f, 280.2f, 64.0f, 320.0f, 64.0f)
                curveTo(359.8f, 64.0f, 392.0f, 96.2f, 392.0f, 136.0f)
                curveTo(392.0f, 175.8f, 359.8f, 208.0f, 320.0f, 208.0f)
                curveTo(280.2f, 208.0f, 248.0f, 175.8f, 248.0f, 136.0f)
                close()
                moveTo(224.0f, 363.3f)
                curveTo(204.1f, 385.9f, 192.0f, 415.5f, 192.0f, 448.0f)
                lineTo(192.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                lineTo(128.0f, 448.0f)
                curveTo(128.0f, 342.0f, 214.0f, 256.0f, 320.0f, 256.0f)
                curveTo(426.0f, 256.0f, 512.0f, 342.0f, 512.0f, 448.0f)
                lineTo(512.0f, 480.0f)
                lineTo(448.0f, 480.0f)
                lineTo(448.0f, 448.0f)
                curveTo(448.0f, 415.5f, 435.9f, 385.9f, 416.0f, 363.3f)
                lineTo(416.0f, 480.0f)
                lineTo(224.0f, 480.0f)
                lineTo(224.0f, 363.3f)
                close()
                moveTo(296.0f, 448.0f)
                curveTo(309.3f, 448.0f, 320.0f, 437.3f, 320.0f, 424.0f)
                curveTo(320.0f, 410.7f, 309.3f, 400.0f, 296.0f, 400.0f)
                curveTo(282.7f, 400.0f, 272.0f, 410.7f, 272.0f, 424.0f)
                curveTo(272.0f, 437.3f, 282.7f, 448.0f, 296.0f, 448.0f)
                close()
                moveTo(384.0f, 344.0f)
                curveTo(384.0f, 330.7f, 373.3f, 320.0f, 360.0f, 320.0f)
                curveTo(346.7f, 320.0f, 336.0f, 330.7f, 336.0f, 344.0f)
                curveTo(336.0f, 357.3f, 346.7f, 368.0f, 360.0f, 368.0f)
                curveTo(373.3f, 368.0f, 384.0f, 357.3f, 384.0f, 344.0f)
                close()
                moveTo(88.0f, 528.0f)
                lineTo(552.0f, 528.0f)
                curveTo(565.3f, 528.0f, 576.0f, 538.7f, 576.0f, 552.0f)
                curveTo(576.0f, 565.3f, 565.3f, 576.0f, 552.0f, 576.0f)
                lineTo(88.0f, 576.0f)
                curveTo(74.7f, 576.0f, 64.0f, 565.3f, 64.0f, 552.0f)
                curveTo(64.0f, 538.7f, 74.7f, 528.0f, 88.0f, 528.0f)
                close()
                moveTo(128.0f, 248.0f)
                curveTo(128.0f, 234.7f, 138.7f, 224.0f, 152.0f, 224.0f)
                curveTo(165.3f, 224.0f, 176.0f, 234.7f, 176.0f, 248.0f)
                curveTo(176.0f, 261.3f, 165.3f, 272.0f, 152.0f, 272.0f)
                curveTo(138.7f, 272.0f, 128.0f, 261.3f, 128.0f, 248.0f)
                close()
                moveTo(552.0f, 320.0f)
                curveTo(565.3f, 320.0f, 576.0f, 330.7f, 576.0f, 344.0f)
                curveTo(576.0f, 357.3f, 565.3f, 368.0f, 552.0f, 368.0f)
                curveTo(538.7f, 368.0f, 528.0f, 357.3f, 528.0f, 344.0f)
                curveTo(528.0f, 330.7f, 538.7f, 320.0f, 552.0f, 320.0f)
                close()
            }
        }
        .build()
        return _diagnoses!!
    }

private var _diagnoses: ImageVector? = null
