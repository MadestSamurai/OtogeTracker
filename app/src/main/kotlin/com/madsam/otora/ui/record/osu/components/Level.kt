package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.OSU_DARK_RED
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.Red900
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.data.osu.ui.model.OsuLevelUiModel
import com.madsam.otora.ui.components.GradientBorderCircle
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Level(
    osuLevelData: MutableStateFlow<OsuLevelUiModel>,
    modifier: Modifier = Modifier
) {
    val levelData by osuLevelData.collectAsState()

    Row(
        modifier = modifier
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Red700)
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 等级圆圈
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(55.dp)
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
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        }

        // 进度条区域
        Box(
            modifier = Modifier
                .weight(1f)
                .height(25.dp)
        ) {
            // 背景进度条
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Red900,
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Box {
                // 实际进度条
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(levelData.levelProgress / 100f)
                        .background(
                            color = OSU_DARK_RED,
                            shape = RoundedCornerShape(4.dp)
                        )
                )

                // 进度文字
                Text(
                    textAlign = TextAlign.Center,
                    text = "${levelData.levelProgress}%",
                    color = Beige400,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .align(
                            if (levelData.levelProgress < 15)
                                Alignment.CenterStart
                            else
                                Alignment.CenterEnd
                        )
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}