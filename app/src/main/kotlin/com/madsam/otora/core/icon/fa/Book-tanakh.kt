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

public val Fa.`Book-tanakh`: ImageVector
    get() {
        if (`_book-tanakh` != null) {
            return `_book-tanakh`!!
        }
        `_book-tanakh` = Builder(name = "Book-tanakh", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 576.0f)
                lineTo(128.0f, 576.0f)
                curveTo(110.3f, 576.0f, 96.0f, 561.7f, 96.0f, 544.0f)
                curveTo(96.0f, 526.3f, 110.3f, 512.0f, 128.0f, 512.0f)
                lineTo(128.0f, 445.3f)
                curveTo(109.4f, 438.7f, 96.0f, 420.9f, 96.0f, 400.0f)
                lineTo(96.0f, 112.0f)
                curveTo(96.0f, 85.5f, 117.5f, 64.0f, 144.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(501.0f, 64.0f, 544.0f, 107.0f, 544.0f, 160.0f)
                lineTo(544.0f, 480.0f)
                curveTo(544.0f, 533.0f, 501.0f, 576.0f, 448.0f, 576.0f)
                close()
                moveTo(480.0f, 480.0f)
                curveTo(480.0f, 462.3f, 465.7f, 448.0f, 448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                lineTo(192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                curveTo(465.7f, 512.0f, 480.0f, 497.7f, 480.0f, 480.0f)
                close()
                moveTo(209.9f, 293.0f)
                curveTo(208.7f, 295.0f, 208.0f, 297.2f, 208.0f, 299.6f)
                curveTo(208.0f, 306.5f, 213.6f, 312.1f, 220.5f, 312.1f)
                lineTo(277.4f, 312.1f)
                lineTo(307.9f, 361.3f)
                curveTo(310.5f, 365.5f, 315.1f, 368.1f, 320.1f, 368.1f)
                curveTo(325.1f, 368.1f, 329.7f, 365.5f, 332.3f, 361.3f)
                lineTo(362.8f, 312.1f)
                lineTo(419.7f, 312.1f)
                curveTo(426.6f, 312.1f, 432.2f, 306.5f, 432.2f, 299.6f)
                curveTo(432.2f, 297.3f, 431.6f, 295.0f, 430.3f, 293.0f)
                lineTo(402.5f, 248.0f)
                lineTo(430.3f, 203.0f)
                curveTo(431.5f, 201.0f, 432.2f, 198.8f, 432.2f, 196.4f)
                curveTo(432.2f, 189.5f, 426.6f, 183.9f, 419.7f, 183.9f)
                lineTo(362.8f, 183.9f)
                lineTo(332.3f, 134.7f)
                curveTo(329.6f, 130.6f, 325.0f, 128.0f, 320.0f, 128.0f)
                curveTo(315.0f, 128.0f, 310.4f, 130.6f, 307.8f, 134.8f)
                lineTo(277.3f, 184.0f)
                lineTo(220.4f, 184.0f)
                curveTo(213.5f, 184.0f, 207.9f, 189.6f, 207.9f, 196.5f)
                curveTo(207.9f, 198.8f, 208.5f, 201.1f, 209.8f, 203.1f)
                lineTo(237.6f, 248.1f)
                lineTo(209.8f, 293.1f)
                close()
            }
        }
        .build()
        return `_book-tanakh`!!
    }

private var `_book-tanakh`: ImageVector? = null
