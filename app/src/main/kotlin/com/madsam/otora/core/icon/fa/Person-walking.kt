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

public val Fa.`Person-walking`: ImageVector
    get() {
        if (`_person-walking` != null) {
            return `_person-walking`!!
        }
        `_person-walking` = Builder(name = "Person-walking", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 144.0f)
                curveTo(350.9f, 144.0f, 376.0f, 118.9f, 376.0f, 88.0f)
                curveTo(376.0f, 57.1f, 350.9f, 32.0f, 320.0f, 32.0f)
                curveTo(289.1f, 32.0f, 264.0f, 57.1f, 264.0f, 88.0f)
                curveTo(264.0f, 118.9f, 289.1f, 144.0f, 320.0f, 144.0f)
                close()
                moveTo(233.4f, 291.9f)
                lineTo(256.0f, 269.3f)
                lineTo(256.0f, 338.6f)
                curveTo(256.0f, 366.6f, 268.2f, 393.3f, 289.5f, 411.5f)
                lineTo(360.9f, 472.7f)
                curveTo(366.8f, 477.8f, 370.7f, 484.8f, 371.8f, 492.5f)
                lineTo(384.4f, 580.6f)
                curveTo(386.9f, 598.1f, 403.1f, 610.3f, 420.6f, 607.8f)
                curveTo(438.1f, 605.3f, 450.3f, 589.1f, 447.8f, 571.6f)
                lineTo(435.2f, 483.5f)
                curveTo(431.9f, 460.4f, 420.3f, 439.4f, 402.6f, 424.2f)
                lineTo(368.1f, 394.6f)
                lineTo(368.1f, 279.4f)
                lineTo(371.9f, 284.1f)
                curveTo(390.1f, 306.9f, 417.7f, 320.1f, 446.9f, 320.1f)
                lineTo(480.1f, 320.1f)
                curveTo(497.8f, 320.1f, 512.1f, 305.8f, 512.1f, 288.1f)
                curveTo(512.1f, 270.4f, 497.8f, 256.1f, 480.1f, 256.1f)
                lineTo(446.9f, 256.1f)
                curveTo(437.2f, 256.1f, 428.0f, 251.7f, 421.9f, 244.1f)
                lineTo(404.0f, 221.7f)
                curveTo(381.0f, 192.9f, 346.1f, 176.1f, 309.2f, 176.1f)
                curveTo(277.0f, 176.1f, 246.1f, 188.9f, 223.4f, 211.7f)
                lineTo(188.1f, 246.6f)
                curveTo(170.1f, 264.6f, 160.0f, 289.0f, 160.0f, 314.5f)
                lineTo(160.0f, 352.0f)
                curveTo(160.0f, 369.7f, 174.3f, 384.0f, 192.0f, 384.0f)
                curveTo(209.7f, 384.0f, 224.0f, 369.7f, 224.0f, 352.0f)
                lineTo(224.0f, 314.5f)
                curveTo(224.0f, 306.0f, 227.4f, 297.9f, 233.4f, 291.9f)
                close()
                moveTo(245.8f, 471.3f)
                curveTo(244.3f, 476.5f, 241.5f, 481.3f, 237.7f, 485.1f)
                lineTo(169.4f, 553.4f)
                curveTo(156.9f, 565.9f, 156.9f, 586.2f, 169.4f, 598.7f)
                curveTo(181.9f, 611.2f, 202.2f, 611.2f, 214.7f, 598.7f)
                lineTo(283.0f, 530.4f)
                curveTo(294.5f, 518.9f, 302.9f, 504.6f, 307.4f, 488.9f)
                lineTo(309.6f, 481.3f)
                lineTo(263.6f, 441.9f)
                curveTo(261.1f, 439.7f, 258.6f, 437.5f, 256.2f, 435.1f)
                lineTo(245.8f, 471.3f)
                close()
            }
        }
        .build()
        return `_person-walking`!!
    }

private var `_person-walking`: ImageVector? = null
