package com.madsam.otora.ui.record.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.R
import com.madsam.otora.consts.Colors
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OsuPlayData(
    osuPlayData: MutableStateFlow<Map<String, String>>,
) {
    val playData = osuPlayData.collectAsState(initial = emptyMap()).value

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
                judgeBackground,
                sshIcon,
                ssIcon,
                shIcon,
                sIcon,
                aIcon,
                sshText,
                ssText,
                shText,
                sText,
                aText,
            ) = refs

            createHorizontalChain(sshIcon, ssIcon, shIcon, sIcon, aIcon)

            val iconModifier = Modifier
                .padding(top = 16.dp)
                .height(26.dp)

            val iconTextSize = 16.sp
            val iconTextWeight = FontWeight.Bold
            val iconTextColor = Colors.DARK_RED_TEXT_LIGHT
            val iconTextModifier = Modifier.padding(top = 4.dp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Colors.DARK_RED)
                    .constrainAs(judgeBackground) {
                        top.linkTo(parent.top)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_osu_ssh),
                contentDescription = "SSH",
                modifier = iconModifier
                    .constrainAs(sshIcon) {
                        top.linkTo(parent.top)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_osu_ss),
                contentDescription = "SS",
                modifier = iconModifier
                    .constrainAs(ssIcon) {
                        top.linkTo(parent.top)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_osu_sh),
                contentDescription = "SH",
                modifier = iconModifier
                    .constrainAs(shIcon) {
                        top.linkTo(parent.top)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_osu_s),
                contentDescription = "S",
                modifier = iconModifier
                    .constrainAs(sIcon) {
                        top.linkTo(parent.top)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_osu_a),
                contentDescription = "A",
                modifier = iconModifier
                    .constrainAs(aIcon) {
                        top.linkTo(parent.top)
                    }
            )

            Text(
                text = playData["sshCount"] ?: "0",
                color = iconTextColor,
                fontSize = iconTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(sshText) {
                        start.linkTo(sshIcon.start)
                        end.linkTo(sshIcon.end)
                        top.linkTo(sshIcon.bottom)
                    }
            )

            Text(
                text = playData["ssCount"] ?: "0",
                color = iconTextColor,
                fontSize = iconTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(ssText) {
                        start.linkTo(ssIcon.start)
                        end.linkTo(ssIcon.end)
                        top.linkTo(ssIcon.bottom)
                    }
            )

            Text(
                text = playData["shCount"] ?: "0",
                color = iconTextColor,
                fontSize = iconTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(shText) {
                        start.linkTo(shIcon.start)
                        end.linkTo(shIcon.end)
                        top.linkTo(shIcon.bottom)
                    }
            )

            Text(
                text = playData["sCount"] ?: "0",
                color = iconTextColor,
                fontSize = iconTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(sText) {
                        start.linkTo(sIcon.start)
                        end.linkTo(sIcon.end)
                        top.linkTo(sIcon.bottom)
                    }
            )

            Text(
                text = playData["aCount"] ?: "0",
                color = iconTextColor,
                fontSize = iconTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(aText) {
                        start.linkTo(aIcon.start)
                        end.linkTo(aIcon.end)
                        top.linkTo(aIcon.bottom)
                    }
            )

            val (
                medalsTitle,
                ppTitle,
                playTimeTitle,
                medalsText,
                ppText,
                playTimeText,
            ) = refs

            val titleSize = 16.sp
            val titleTextSize = 20.sp

            Text(text = "Medals",
                color = iconTextColor,
                fontSize = titleSize,
                modifier = Modifier
                    .constrainAs(medalsTitle) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = playData["medalCount"] ?: "0",
                color = iconTextColor,
                fontSize = titleTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(medalsText) {
                        top.linkTo(medalsTitle.bottom)
                        start.linkTo(medalsTitle.start)
                    }
            )

            Text(text = "PP",
                color = iconTextColor,
                fontSize = titleSize,
                modifier = Modifier
                    .constrainAs(ppTitle) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        start.linkTo(ppText.start)
                    }
            )

            Text(text = playData["pp"] ?: "0",
                color = iconTextColor,
                fontSize = titleTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(ppText) {
                        top.linkTo(ppTitle.bottom)
                        start.linkTo(medalsText.end)
                        end.linkTo(playTimeText.start)
                    }
            )

            Text(text = "Play Time",
                color = iconTextColor,
                fontSize = titleSize,
                modifier = Modifier
                    .constrainAs(playTimeTitle) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        start.linkTo(playTimeText.start)
                    }
            )

            Text(text = playData["playTime"] ?: "0",
                color = iconTextColor,
                fontSize = titleTextSize,
                fontWeight = iconTextWeight,
                modifier = iconTextModifier
                    .constrainAs(playTimeText) {
                        top.linkTo(playTimeTitle.bottom)
                        end.linkTo(parent.end, margin = 25.dp)
                    }
            )

            val (
                rankedScoreTitle,
                hitAccuracyTitle,
                playCountTitle,
                totalScoreTitle,
                totalHitsTitle,
                maximumComboTitle,
                replaysWatchedTitle,
                rankedScoreText,
                hitAccuracyText,
                playCountText,
                totalScoreText,
                totalHitsText,
                maximumComboText,
                replaysWatchedText,
            ) = refs

            val textSize = 14.sp

            Text(text = "Ranked Score",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(rankedScoreTitle) {
                        top.linkTo(medalsText.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Hit Accuracy",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(hitAccuracyTitle) {
                        top.linkTo(rankedScoreTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Play Count",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(playCountTitle) {
                        top.linkTo(hitAccuracyTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Total Score",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(totalScoreTitle) {
                        top.linkTo(playCountTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Total Hits",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(totalHitsTitle) {
                        top.linkTo(totalScoreTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Maximum Combo",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(maximumComboTitle) {
                        top.linkTo(totalHitsTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                    }
            )

            Text(text = "Replays Watched by Others",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(replaysWatchedTitle) {
                        top.linkTo(maximumComboTitle.bottom, margin = 3.dp)
                        start.linkTo(parent.start, margin = 25.dp)
                        bottom.linkTo(parent.bottom, margin = 15.dp)
                    }
            )

            Text(text = playData["replaysWatchedByOthers"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(replaysWatchedText) {
                        top.linkTo(replaysWatchedTitle.top)
                        bottom.linkTo(replaysWatchedTitle.bottom)
                        start.linkTo(replaysWatchedTitle.end)
                        end.linkTo(parent.end)
                    }
            )

            Text(text = playData["rankedScore"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(rankedScoreText) {
                        top.linkTo(rankedScoreTitle.top)
                        bottom.linkTo(rankedScoreTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )

            Text(text = playData["hitAccuracy"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(hitAccuracyText) {
                        top.linkTo(hitAccuracyTitle.top)
                        bottom.linkTo(hitAccuracyTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )

            Text(text = playData["playCount"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(playCountText) {
                        top.linkTo(playCountTitle.top)
                        bottom.linkTo(playCountTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )

            Text(text = playData["totalScore"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(totalScoreText) {
                        top.linkTo(totalScoreTitle.top)
                        bottom.linkTo(totalScoreTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )

            Text(text = playData["totalHits"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(totalHitsText) {
                        top.linkTo(totalHitsTitle.top)
                        bottom.linkTo(totalHitsTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )

            Text(text = playData["maximumCombo"] ?: "0",
                color = iconTextColor,
                fontSize = textSize,
                modifier = Modifier
                    .constrainAs(maximumComboText) {
                        top.linkTo(maximumComboTitle.top)
                        bottom.linkTo(maximumComboTitle.bottom)
                        start.linkTo(replaysWatchedText.start)
                    }
            )
        }
    }
}