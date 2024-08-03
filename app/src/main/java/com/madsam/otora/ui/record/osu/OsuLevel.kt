package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.component.GradientBorderCircle
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OsuLevel(
    osuLevelData: MutableStateFlow<Map<String, String>>
) {
    val levelData = osuLevelData.collectAsState(initial = emptyMap()).value
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    Surface(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = Color.Transparent,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val cardWidthDp = screenWidthDp - 32.dp
            val refs = createRefs()
            val (
                levelText,
                levelProgressText,
                levelProgressBar,
                levelProgress,
            ) = refs
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(55.dp)
                    .fillMaxHeight()
                    .constrainAs(levelText) {
                        start.linkTo(parent.start, margin = 16.dp)
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            ) {
                val levelBrush = CommonUtils.getLevelBrush((levelData["level"] ?: "0").toInt())
                GradientBorderCircle(
                    gradient = levelBrush,
                    borderSize = 3.dp,
                    circleSize = 50.dp
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = levelData["level"] ?: "0",
                        color = Colors.DARK_RED_TEXT_LIGHT,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Colors.DARKER_RED,
                modifier = Modifier
                    .height(25.dp)
                    .width(cardWidthDp - 103.dp)
                    .constrainAs(levelProgressBar) {
                        start.linkTo(levelText.end)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            ) {}

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Colors.OSU_DARK_RED,
                modifier = Modifier
                    .height(25.dp)
                    .width((cardWidthDp - 103.dp) * (levelData["levelProgress"]?.toFloat() ?: 0f) / 100f)
                    .constrainAs(levelProgress) {
                        start.linkTo(levelProgressBar.start)
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            ) {}

            Text(
                textAlign = TextAlign.Center,
                text = (levelData["levelProgress"] ?: "0") + "%",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = if ((levelData["levelProgress"]?.toInt() ?: 0) < 15) {
                    Modifier
                        .constrainAs(levelProgressText) {
                            start.linkTo(levelProgress.start, margin = 8.dp)
                            top.linkTo(parent.top, margin = 16.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        }
                } else {
                    Modifier
                        .constrainAs(levelProgressText) {
                            end.linkTo(levelProgress.end, margin = 4.dp)
                            top.linkTo(parent.top, margin = 16.dp)
                            bottom.linkTo(parent.bottom, margin = 16.dp)
                        }
                }
            )
        }
    }
}