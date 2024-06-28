package com.madsam.otora.ui.record.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OsuLevel(
    osuLevelData: MutableStateFlow<Map<String, String>>
) {
    val levelData = osuLevelData.collectAsState(initial = emptyMap()).value

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
                    .fillMaxWidth(0.15f)
                    .fillMaxHeight()
                    .constrainAs(levelText) {
                        start.linkTo(parent.start, margin = 16.dp)
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            ) {
                val borderColor = CommonUtils.getLevelColor((levelData["level"] ?: "0").toInt())
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(2.dp, borderColor), // 设置边框的宽度和颜色
                    color = Color.Transparent,
                    modifier = Modifier.size(50.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(50.dp)
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
            }

            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Colors.DARKER_RED,
                modifier = Modifier
                    .height(25.dp)
                    .fillMaxWidth(0.75f)
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
                    .fillMaxWidth(
                        levelData["levelProgress"]
                            ?.toFloat()
                            ?.div(138.89f) ?: 0f
                    )
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
                modifier = Modifier
                    .constrainAs(levelProgressText) {
                        end.linkTo(levelProgress.end, margin = 8.dp)
                        top.linkTo(parent.top, margin = 16.dp)
                        bottom.linkTo(parent.bottom, margin = 16.dp)
                    }
            )
        }
    }
}