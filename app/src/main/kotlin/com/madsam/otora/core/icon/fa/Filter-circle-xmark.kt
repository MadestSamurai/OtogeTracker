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

public val Fa.`Filter-circle-xmark`: ImageVector
    get() {
        if (`_filter-circle-xmark` != null) {
            return `_filter-circle-xmark`!!
        }
        `_filter-circle-xmark` = Builder(name = "Filter-circle-xmark", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 128.0f)
                curveTo(51.1f, 128.0f, 39.4f, 135.8f, 34.4f, 147.8f)
                lineTo(305.6f, 572.6f)
                curveTo(313.8f, 576.7f, 323.5f, 577.2f, 332.2f, 573.6f)
                curveTo(341.3f, 569.8f, 348.0f, 562.1f, 350.7f, 553.0f)
                curveTo(377.1f, 586.5f, 418.0f, 608.1f, 464.0f, 608.1f)
                curveTo(543.5f, 608.1f, 608.0f, 543.6f, 608.0f, 464.1f)
                curveTo(608.0f, 384.6f, 543.5f, 320.0f, 464.0f, 320.0f)
                curveTo(418.8f, 320.0f, 378.4f, 340.9f, 352.0f, 373.5f)
                lineTo(352.0f, 365.3f)
                lineTo(534.6f, 182.7f)
                curveTo(543.8f, 173.5f, 546.5f, 159.8f, 541.5f, 147.8f)
                curveTo(536.5f, 135.8f, 524.9f, 128.0f, 512.0f, 128.0f)
                lineTo(64.0f, 128.0f)
                close()
                moveTo(523.3f, 427.3f)
                lineTo(486.6f, 464.0f)
                lineTo(523.3f, 500.7f)
                curveTo(529.5f, 506.9f, 529.5f, 517.1f, 523.3f, 523.3f)
                curveTo(517.1f, 529.5f, 506.9f, 529.5f, 500.7f, 523.3f)
                lineTo(464.0f, 486.6f)
                lineTo(427.3f, 523.3f)
                curveTo(421.1f, 529.5f, 410.9f, 529.5f, 404.7f, 523.3f)
                curveTo(398.5f, 517.1f, 398.5f, 506.9f, 404.7f, 500.7f)
                lineTo(441.4f, 464.0f)
                lineTo(404.7f, 427.3f)
                curveTo(398.5f, 421.1f, 398.5f, 410.9f, 404.7f, 404.7f)
                curveTo(410.9f, 398.5f, 421.1f, 398.5f, 427.3f, 404.7f)
                lineTo(464.0f, 441.4f)
                lineTo(500.7f, 404.7f)
                curveTo(506.9f, 398.5f, 517.1f, 398.5f, 523.3f, 404.7f)
                curveTo(529.5f, 410.9f, 529.5f, 421.1f, 523.3f, 427.3f)
                close()
            }
        }
        .build()
        return `_filter-circle-xmark`!!
    }

private var `_filter-circle-xmark`: ImageVector? = null
