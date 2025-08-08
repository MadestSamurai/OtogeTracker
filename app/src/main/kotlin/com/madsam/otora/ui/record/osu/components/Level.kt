package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.OSU_DARK_RED
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.Red900
import com.madsam.otora.core.theme.interTightBold
import com.madsam.otora.core.theme.interTightSemiBold
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.data.osu.ui.model.OsuLevelUiModel
import com.madsam.otora.ui.components.GradientBorderCircle
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Level(
    osuLevelData: MutableStateFlow<OsuLevelUiModel>,
    cardWidthDp: Dp
) {
    val levelData by osuLevelData.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Red700)
            .width(cardWidthDp)
    ) {
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
                .height(55.dp)
                .constrainAs(levelText) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
        ) {
            val levelBrush = CommonUtils.getLevelBrush(levelData.level.toInt())
            GradientBorderCircle(
                gradient = levelBrush,
                borderSize = 3.dp,
                circleSize = 50.dp
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = levelData.level.toString(),
                    color = Beige400,
                    fontFamily = interTightBold,
                    fontSize = 22.sp,
                )
            }
        }

        Surface(
            shape = RoundedCornerShape(4.dp),
            color = Red900,
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
            color = OSU_DARK_RED,
            modifier = Modifier
                .height(25.dp)
                .width(
                    (cardWidthDp - 103.dp) * (levelData.levelProgress / 100f)
                )
                .constrainAs(levelProgress) {
                    start.linkTo(levelProgressBar.start)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
        ) {}

        Text(
            textAlign = TextAlign.Center,
            text = "${levelData.levelProgress}%",
            color = Beige400,
            fontFamily = interTightSemiBold,
            fontSize = 14.sp,
            modifier = if (levelData.levelProgress < 15) {
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