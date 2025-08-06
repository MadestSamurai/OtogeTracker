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

public val Fa.`User-plus`: ImageVector
    get() {
        if (`_user-plus` != null) {
            return `_user-plus`!!
        }
        `_user-plus` = Builder(name = "User-plus", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(136.0f, 192.0f)
                curveTo(136.0f, 125.7f, 189.7f, 72.0f, 256.0f, 72.0f)
                curveTo(322.3f, 72.0f, 376.0f, 125.7f, 376.0f, 192.0f)
                curveTo(376.0f, 258.3f, 322.3f, 312.0f, 256.0f, 312.0f)
                curveTo(189.7f, 312.0f, 136.0f, 258.3f, 136.0f, 192.0f)
                close()
                moveTo(48.0f, 546.3f)
                curveTo(48.0f, 447.8f, 127.8f, 368.0f, 226.3f, 368.0f)
                lineTo(285.7f, 368.0f)
                curveTo(384.2f, 368.0f, 464.0f, 447.8f, 464.0f, 546.3f)
                curveTo(464.0f, 562.7f, 450.7f, 576.0f, 434.3f, 576.0f)
                lineTo(77.7f, 576.0f)
                curveTo(61.3f, 576.0f, 48.0f, 562.7f, 48.0f, 546.3f)
                close()
                moveTo(544.0f, 160.0f)
                curveTo(557.3f, 160.0f, 568.0f, 170.7f, 568.0f, 184.0f)
                lineTo(568.0f, 232.0f)
                lineTo(616.0f, 232.0f)
                curveTo(629.3f, 232.0f, 640.0f, 242.7f, 640.0f, 256.0f)
                curveTo(640.0f, 269.3f, 629.3f, 280.0f, 616.0f, 280.0f)
                lineTo(568.0f, 280.0f)
                lineTo(568.0f, 328.0f)
                curveTo(568.0f, 341.3f, 557.3f, 352.0f, 544.0f, 352.0f)
                curveTo(530.7f, 352.0f, 520.0f, 341.3f, 520.0f, 328.0f)
                lineTo(520.0f, 280.0f)
                lineTo(472.0f, 280.0f)
                curveTo(458.7f, 280.0f, 448.0f, 269.3f, 448.0f, 256.0f)
                curveTo(448.0f, 242.7f, 458.7f, 232.0f, 472.0f, 232.0f)
                lineTo(520.0f, 232.0f)
                lineTo(520.0f, 184.0f)
                curveTo(520.0f, 170.7f, 530.7f, 160.0f, 544.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_user-plus`!!
    }

private var `_user-plus`: ImageVector? = null
