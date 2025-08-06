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

public val Fa.Virus: ImageVector
    get() {
        if (_virus != null) {
            return _virus!!
        }
        _virus = Builder(name = "Virus", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(360.0f, 104.0f)
                curveTo(360.0f, 81.9f, 342.1f, 64.0f, 320.0f, 64.0f)
                curveTo(297.9f, 64.0f, 280.0f, 81.9f, 280.0f, 104.0f)
                curveTo(280.0f, 148.1f, 226.7f, 170.1f, 195.5f, 139.0f)
                curveTo(179.9f, 123.4f, 154.6f, 123.4f, 138.9f, 139.0f)
                curveTo(123.2f, 154.6f, 123.3f, 179.9f, 138.9f, 195.6f)
                curveTo(170.1f, 226.8f, 148.0f, 280.1f, 103.9f, 280.1f)
                curveTo(81.8f, 280.1f, 63.9f, 298.0f, 63.9f, 320.1f)
                curveTo(63.9f, 342.2f, 81.8f, 360.1f, 103.9f, 360.1f)
                curveTo(148.0f, 360.1f, 170.0f, 413.4f, 138.9f, 444.6f)
                curveTo(123.3f, 460.2f, 123.3f, 485.5f, 138.9f, 501.2f)
                curveTo(154.5f, 516.9f, 179.8f, 516.8f, 195.5f, 501.2f)
                curveTo(226.7f, 470.0f, 280.0f, 492.1f, 280.0f, 536.2f)
                curveTo(280.0f, 558.3f, 297.9f, 576.2f, 320.0f, 576.2f)
                curveTo(342.1f, 576.2f, 360.0f, 558.3f, 360.0f, 536.2f)
                curveTo(360.0f, 492.1f, 413.3f, 470.1f, 444.5f, 501.2f)
                curveTo(460.1f, 516.8f, 485.4f, 516.8f, 501.1f, 501.2f)
                curveTo(516.8f, 485.6f, 516.7f, 460.3f, 501.1f, 444.6f)
                curveTo(469.9f, 413.4f, 492.0f, 360.1f, 536.1f, 360.1f)
                curveTo(558.2f, 360.1f, 576.1f, 342.2f, 576.1f, 320.1f)
                curveTo(576.1f, 298.0f, 558.2f, 280.1f, 536.1f, 280.1f)
                curveTo(492.0f, 280.1f, 470.0f, 226.8f, 501.1f, 195.6f)
                curveTo(516.7f, 180.0f, 516.7f, 154.7f, 501.1f, 139.0f)
                curveTo(485.5f, 123.3f, 460.2f, 123.4f, 444.5f, 139.0f)
                curveTo(413.3f, 170.1f, 360.0f, 148.1f, 360.0f, 104.0f)
                close()
                moveTo(224.0f, 288.0f)
                curveTo(224.0f, 270.3f, 238.3f, 256.0f, 256.0f, 256.0f)
                curveTo(273.7f, 256.0f, 288.0f, 270.3f, 288.0f, 288.0f)
                curveTo(288.0f, 305.7f, 273.7f, 320.0f, 256.0f, 320.0f)
                curveTo(238.3f, 320.0f, 224.0f, 305.7f, 224.0f, 288.0f)
                close()
                moveTo(384.0f, 320.0f)
                curveTo(401.7f, 320.0f, 416.0f, 334.3f, 416.0f, 352.0f)
                curveTo(416.0f, 369.7f, 401.7f, 384.0f, 384.0f, 384.0f)
                curveTo(366.3f, 384.0f, 352.0f, 369.7f, 352.0f, 352.0f)
                curveTo(352.0f, 334.3f, 366.3f, 320.0f, 384.0f, 320.0f)
                close()
            }
        }
        .build()
        return _virus!!
    }

private var _virus: ImageVector? = null
