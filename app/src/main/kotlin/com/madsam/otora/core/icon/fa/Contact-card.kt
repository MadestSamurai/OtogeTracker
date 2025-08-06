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

public val Fa.`Contact-card`: ImageVector
    get() {
        if (`_contact-card` != null) {
            return `_contact-card`!!
        }
        `_contact-card` = Builder(name = "Contact-card", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(60.7f, 96.0f, 32.0f, 124.7f, 32.0f, 160.0f)
                lineTo(32.0f, 480.0f)
                curveTo(32.0f, 515.3f, 60.7f, 544.0f, 96.0f, 544.0f)
                lineTo(544.0f, 544.0f)
                curveTo(579.3f, 544.0f, 608.0f, 515.3f, 608.0f, 480.0f)
                lineTo(608.0f, 160.0f)
                curveTo(608.0f, 124.7f, 579.3f, 96.0f, 544.0f, 96.0f)
                lineTo(96.0f, 96.0f)
                close()
                moveTo(176.0f, 352.0f)
                lineTo(240.0f, 352.0f)
                curveTo(284.2f, 352.0f, 320.0f, 387.8f, 320.0f, 432.0f)
                curveTo(320.0f, 440.8f, 312.8f, 448.0f, 304.0f, 448.0f)
                lineTo(112.0f, 448.0f)
                curveTo(103.2f, 448.0f, 96.0f, 440.8f, 96.0f, 432.0f)
                curveTo(96.0f, 387.8f, 131.8f, 352.0f, 176.0f, 352.0f)
                close()
                moveTo(152.0f, 256.0f)
                curveTo(152.0f, 225.1f, 177.1f, 200.0f, 208.0f, 200.0f)
                curveTo(238.9f, 200.0f, 264.0f, 225.1f, 264.0f, 256.0f)
                curveTo(264.0f, 286.9f, 238.9f, 312.0f, 208.0f, 312.0f)
                curveTo(177.1f, 312.0f, 152.0f, 286.9f, 152.0f, 256.0f)
                close()
                moveTo(392.0f, 208.0f)
                lineTo(504.0f, 208.0f)
                curveTo(517.3f, 208.0f, 528.0f, 218.7f, 528.0f, 232.0f)
                curveTo(528.0f, 245.3f, 517.3f, 256.0f, 504.0f, 256.0f)
                lineTo(392.0f, 256.0f)
                curveTo(378.7f, 256.0f, 368.0f, 245.3f, 368.0f, 232.0f)
                curveTo(368.0f, 218.7f, 378.7f, 208.0f, 392.0f, 208.0f)
                close()
                moveTo(392.0f, 304.0f)
                lineTo(504.0f, 304.0f)
                curveTo(517.3f, 304.0f, 528.0f, 314.7f, 528.0f, 328.0f)
                curveTo(528.0f, 341.3f, 517.3f, 352.0f, 504.0f, 352.0f)
                lineTo(392.0f, 352.0f)
                curveTo(378.7f, 352.0f, 368.0f, 341.3f, 368.0f, 328.0f)
                curveTo(368.0f, 314.7f, 378.7f, 304.0f, 392.0f, 304.0f)
                close()
            }
        }
        .build()
        return `_contact-card`!!
    }

private var `_contact-card`: ImageVector? = null
