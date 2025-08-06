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

public val Fa.`Vote-yea`: ImageVector
    get() {
        if (`_vote-yea` != null) {
            return `_vote-yea`!!
        }
        `_vote-yea` = Builder(name = "Vote-yea", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 160.0f)
                curveTo(128.0f, 124.7f, 156.7f, 96.0f, 192.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(483.3f, 96.0f, 512.0f, 124.7f, 512.0f, 160.0f)
                lineTo(512.0f, 384.0f)
                curveTo(512.0f, 419.3f, 483.3f, 448.0f, 448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(156.7f, 448.0f, 128.0f, 419.3f, 128.0f, 384.0f)
                lineTo(128.0f, 160.0f)
                close()
                moveTo(396.7f, 179.6f)
                curveTo(385.5f, 172.6f, 370.7f, 176.0f, 363.6f, 187.2f)
                lineTo(302.2f, 285.5f)
                lineTo(275.2f, 249.5f)
                curveTo(267.2f, 238.9f, 252.2f, 236.7f, 241.6f, 244.7f)
                curveTo(231.0f, 252.7f, 228.8f, 267.7f, 236.8f, 278.3f)
                lineTo(284.8f, 342.3f)
                curveTo(289.5f, 348.6f, 297.1f, 352.2f, 305.0f, 351.9f)
                curveTo(312.9f, 351.6f, 320.1f, 347.4f, 324.3f, 340.6f)
                lineTo(404.3f, 212.6f)
                curveTo(411.3f, 201.4f, 407.9f, 186.6f, 396.7f, 179.5f)
                close()
                moveTo(80.0f, 376.0f)
                lineTo(80.0f, 480.0f)
                curveTo(80.0f, 488.8f, 87.2f, 496.0f, 96.0f, 496.0f)
                lineTo(544.0f, 496.0f)
                curveTo(552.8f, 496.0f, 560.0f, 488.8f, 560.0f, 480.0f)
                lineTo(560.0f, 376.0f)
                curveTo(560.0f, 362.7f, 570.7f, 352.0f, 584.0f, 352.0f)
                curveTo(597.3f, 352.0f, 608.0f, 362.7f, 608.0f, 376.0f)
                lineTo(608.0f, 480.0f)
                curveTo(608.0f, 515.3f, 579.3f, 544.0f, 544.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                lineTo(32.0f, 376.0f)
                curveTo(32.0f, 362.7f, 42.7f, 352.0f, 56.0f, 352.0f)
                curveTo(69.3f, 352.0f, 80.0f, 362.7f, 80.0f, 376.0f)
                close()
            }
        }
        .build()
        return `_vote-yea`!!
    }

private var `_vote-yea`: ImageVector? = null
