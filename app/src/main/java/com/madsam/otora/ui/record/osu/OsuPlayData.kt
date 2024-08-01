package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.R
import com.madsam.otora.component.TitleText
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.CommonUtils
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
                medals,
                pp,
                playTime,
                rankedScore,
                hitAccuracy,
                playCount,
                totalScore,
                totalHits,
                maximumCombo,
                replaysWatched,
                followCount,
                mappingFollowCount,
                postsCount,
                commentsCount,
            ) = refs

            val titleSize = 14.sp
            val textSize = 17.sp
            val titleSizeLarge = 16.sp
            val textSizeLarge = 20.sp

            TitleText(
                textTitle = "Medals",
                text = playData["medalCount"] ?: "0",
                titleSize = titleSizeLarge,
                titleTextSize = textSizeLarge,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(medals) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    }
            )

            val ppSplit = playData["pp"]?.split(".")
            TitleText(
                textTitle = "PP",
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = textSizeLarge, fontWeight = FontWeight.Bold)) {
                        append(ppSplit?.get(0) ?: "0")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                        append(".${ppSplit?.get(1) ?: "00"}")
                    }
                },
                titleSize = titleSizeLarge,
                titleTextSize = textSizeLarge,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(pp) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        start.linkTo(medals.end)
                        end.linkTo(playTime.start)
                    }
            )
            
            val playTimeStr = playData["playTime"]?.split(",")
            val dayHourLabels = listOf("D", "H")
            val monthSecondLabels = listOf("M", "S")
            TitleText(
                textTitle = "Play Time",
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = textSizeLarge, fontWeight = FontWeight.Bold)) {
                        append(playTimeStr?.get(0) ?: "0")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                        append("${dayHourLabels[0]} ")
                    }
                    withStyle(style = SpanStyle(fontSize = textSizeLarge, fontWeight = FontWeight.Bold)) {
                        append(playTimeStr?.get(1) ?: "0")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                        append("${dayHourLabels[1]} ")
                    }
                    withStyle(style = SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)) {
                        append(playTimeStr?.get(2) ?: "0")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                        append("${monthSecondLabels[0]} ")
                    }
                    withStyle(style = SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)) {
                        append(playTimeStr?.get(3) ?: "0")
                    }
                    withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                        append(monthSecondLabels[1])
                    }
                },
                titleSize = titleSizeLarge,
                titleTextSize = textSizeLarge,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(playTime) {
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    }
            )

            val rankedScoreText = CommonUtils.bigNumberTextFormat(playData["rankedScore"]?:"0", textSize)
            TitleText(
                textTitle = "Ranked Score",
                text = rankedScoreText,
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(rankedScore) {
                        top.linkTo(medals.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    }
            )

            TitleText(
                textTitle = "Hit Accuracy",
                text = playData["hitAccuracy"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(hitAccuracy) {
                        top.linkTo(medals.bottom, margin = 15.dp)
                        start.linkTo(rankedScore.end)
                        end.linkTo(playCount.start)
                    }
            )

            TitleText(
                textTitle = "Play Count",
                text = playData["playCount"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(playCount) {
                        top.linkTo(medals.bottom, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    }
            )

            val totalScoreText = CommonUtils.bigNumberTextFormat(playData["totalScore"]?:"0", textSize)
            TitleText(
                textTitle = "Total Score",
                text = totalScoreText,
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(totalScore) {
                        top.linkTo(rankedScore.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    }
            )

            val totalHitsText = CommonUtils.bigNumberTextFormat(playData["totalHits"]?:"0", textSize)
            TitleText(
                textTitle = "Total Hits",
                text = totalHitsText,
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(totalHits) {
                        top.linkTo(rankedScore.bottom, margin = 15.dp)
                        start.linkTo(totalScore.end)
                        end.linkTo(maximumCombo.start)
                    }
            )

            val maximumComboText = CommonUtils.bigNumberTextFormat(playData["maximumCombo"]?:"0", textSize)
            TitleText(
                textTitle = "Max Combo",
                text = maximumComboText,
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(maximumCombo) {
                        top.linkTo(rankedScore.bottom, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    }
            )

            val replayWatchedText = CommonUtils.bigNumberTextFormat(playData["replaysWatchedByOthers"]?:"0", textSize)
            TitleText(
                textTitle = "Replays Watched By Others",
                text = replayWatchedText,
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(replaysWatched) {
                        top.linkTo(totalScore.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                    }
            )

            TitleText(
                textTitle = "Mapping Followers",
                text = playData["mappingFollowerCount"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(mappingFollowCount) {
                        top.linkTo(totalScore.bottom, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    }
            )

            TitleText(
                textTitle = "Followers",
                text = playData["followerCount"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(followCount) {
                        top.linkTo(replaysWatched.bottom, margin = 15.dp)
                        start.linkTo(parent.start, margin = 15.dp)
                        bottom.linkTo(parent.bottom, margin = 15.dp)
                    }
            )

            TitleText(
                textTitle = "Posts",
                text = playData["postCount"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(postsCount) {
                        top.linkTo(replaysWatched.bottom, margin = 15.dp)
                        start.linkTo(followCount.end)
                        end.linkTo(commentsCount.start)
                    }
            )
            TitleText(
                textTitle = "Comments",
                text = playData["commentsCount"] ?: "0",
                titleSize = titleSize,
                titleTextSize = textSize,
                color = iconTextColor,
                modifier = Modifier
                    .constrainAs(commentsCount) {
                        top.linkTo(replaysWatched.bottom, margin = 15.dp)
                        end.linkTo(parent.end, margin = 15.dp)
                    }
            )
        }
    }
}