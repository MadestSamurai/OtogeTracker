package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold

@Composable
fun ChunithmFilterComponent(
    isFilterExpanded: Boolean,
    genres: List<String>,
    versions: List<String>,
    selectedGenres: MutableState<Set<String>>,
    selectedVersions: MutableState<Set<String>>,
    selectedDifficulties: MutableState<Set<String>>,
    internalLevelRange: MutableState<IntRange>,
    filterInternalLevelRange: MutableState<IntRange>,
    cnLevelRange: MutableState<IntRange>,
    filterCnLevelRange: MutableState<IntRange>,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = isFilterExpanded,
        enter = expandVertically(),
        exit = shrinkVertically(),
        modifier = modifier
            .fillMaxWidth()
            .zIndex(1f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Red300)
        ) {
            // Genre 筛选行
            GenreFilterRow(
                genres = genres,
                selectedGenres = selectedGenres
            )

            // Version 筛选行
            VersionFilterRow(
                versions = versions,
                selectedVersions = selectedVersions
            )

            // 难度筛选按钮
            DifficultyFilterRow(
                selectedDifficulties = selectedDifficulties
            )

            // JP Value range filter
            JpValueRangeFilter(
                internalLevelRange = internalLevelRange,
                filterInternalLevelRange = filterInternalLevelRange
            )

            // CN Value range filter
            CnValueRangeFilter(
                cnLevelRange = cnLevelRange,
                filterCnLevelRange = filterCnLevelRange
            )
        }
    }
}

@Composable
private fun GenreFilterRow(
    genres: List<String>,
    selectedGenres: MutableState<Set<String>>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val allSelected = selectedGenres.value.size == genres.size
        val toggleText = if (allSelected) "全不选" else "全选"
        Box(
            modifier = Modifier
                .height(32.dp)
                .background(
                    if (allSelected) Red300 else Red500,
                    RoundedCornerShape(12.dp)
                )
                .clickable {
                    selectedGenres.value = if (allSelected) emptySet() else genres.toSet()
                }
                .padding(horizontal = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = toggleText,
                fontSize = 13.sp,
                fontFamily = sarasaBold,
                color = Beige500,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        LazyRow(
            modifier = Modifier.weight(1f)
        ) {
            items(genres.size) { index ->
                val genre = genres[index]
                val isSelected = selectedGenres.value.contains(genre)
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .height(32.dp)
                        .background(
                            if (isSelected) Red500 else Red300,
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            selectedGenres.value = if (isSelected) {
                                selectedGenres.value - genre
                            } else {
                                selectedGenres.value + genre
                            }
                        }
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = genre,
                        color = Beige500,
                        fontSize = 13.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun VersionFilterRow(
    versions: List<String>,
    selectedVersions: MutableState<Set<String>>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val allSelected = selectedVersions.value.size == versions.size
        val toggleText = if (allSelected) "全不选" else "全选"
        Box(
            modifier = Modifier
                .height(32.dp)
                .background(
                    if (allSelected) Red300 else Red500,
                    RoundedCornerShape(12.dp)
                )
                .clickable {
                    selectedVersions.value = if (allSelected) emptySet() else versions.toSet()
                }
                .padding(horizontal = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = toggleText,
                fontSize = 13.sp,
                fontFamily = sarasaBold,
                color = Beige500,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        LazyRow(
            modifier = Modifier.weight(1f)
        ) {
            items(versions.size) { index ->
                val version = versions[index]
                val isSelected = selectedVersions.value.contains(version)
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .height(32.dp)
                        .background(
                            if (isSelected) Red500 else Red300,
                            RoundedCornerShape(12.dp)
                        )
                        .clickable {
                            selectedVersions.value = if (isSelected) {
                                selectedVersions.value - version
                            } else {
                                selectedVersions.value + version
                            }
                        }
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = version,
                        color = Beige500,
                        fontSize = 13.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun DifficultyFilterRow(
    selectedDifficulties: MutableState<Set<String>>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val difficulties = listOf("basic", "advanced", "expert", "master", "ultima")
        val difficultyLabels = listOf("BASIC", "ADVANCED", "EXPERT", "MASTER", "ULTIMA")
        val difficultyColors = listOf(
            CHUNI_DIFF_BASIC,
            CHUNI_DIFF_ADVANCED,
            CHUNI_DIFF_EXPERT,
            CHUNI_DIFF_MASTER,
            CHUNI_DIFF_ULTIMA_1
        )

        difficulties.forEachIndexed { index, difficulty ->
            val isSelected = selectedDifficulties.value.contains(difficulty)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(24.dp)
                    .background(
                        if (isSelected) difficultyColors[index] else Red300,
                        RoundedCornerShape(6.dp)
                    )
                    .run {
                        if (difficulty == "ultima" && isSelected) {
                            border(
                                width = 1.dp,
                                color = CHUNI_DIFF_ULTIMA_2,
                                shape = RoundedCornerShape(6.dp)
                            )
                        } else this
                    }
                    .clickable {
                        selectedDifficulties.value = if (isSelected) {
                            selectedDifficulties.value - difficulty
                        } else {
                            selectedDifficulties.value + difficulty
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = difficultyLabels[index],
                    color = if (isSelected) White1000 else Beige500,
                    fontSize = 12.sp,
                    fontFamily = sarasaBold,
                    textAlign = TextAlign.Center,
                    letterSpacing = if (difficulty == "advanced") (-0.5).sp else 0.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Visible
                )
            }
        }
    }
}

@Composable
private fun JpValueRangeFilter(
    internalLevelRange: MutableState<IntRange>,
    filterInternalLevelRange: MutableState<IntRange>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "JP Value Filter: ${(internalLevelRange.value.start / 10.0).round(1)} - ${(internalLevelRange.value.endInclusive / 10.0).round(1)}",
                color = Beige500,
                modifier = Modifier.weight(1f)
            )

            // 不可见的占位符，保持与CN Filter行高一致
            Box(modifier = Modifier.padding(start = 8.dp)) {
                Switch(
                    checked = false,
                    onCheckedChange = { },
                    modifier = Modifier.alpha(0f), // 完全透明
                    enabled = false
                )
            }
        }
        RangeSlider(
            value = internalLevelRange.value.start.toFloat()..internalLevelRange.value.endInclusive.toFloat(),
            onValueChange = { range ->
                // 使用 kotlin.math.round 确保精确的整数转换
                val startInt = kotlin.math.round(range.start).toInt()
                val endInt = kotlin.math.round(range.endInclusive).toInt()
                val intRange = startInt..endInt
                internalLevelRange.value = intRange
                filterInternalLevelRange.value = intRange // 立即更新筛选范围
            },
            valueRange = 10f..157f,
            steps = 147, // 157 - 10 = 147 steps
            colors = SliderDefaults.colors(
                thumbColor = Beige500,
                activeTrackColor = Red500,
                inactiveTrackColor = Red300,
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        change.consume()
                    }
                },
        )
    }
}

@Composable
private fun CnValueRangeFilter(
    cnLevelRange: MutableState<IntRange>,
    filterCnLevelRange: MutableState<IntRange>
) {
    val isCnFilterEnabled = remember { mutableStateOf(true) }
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "CN Value Filter: ${(cnLevelRange.value.start / 10.0).round(1)} - ${(cnLevelRange.value.endInclusive / 10.0).round(1)}",
                color = Beige500,
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = isCnFilterEnabled.value,
                onCheckedChange = { enabled ->
                    isCnFilterEnabled.value = enabled
                    filterCnLevelRange.value = if (enabled) cnLevelRange.value else 0..1000
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Beige500,
                    checkedTrackColor = Red500,
                    uncheckedThumbColor = Red300,
                    uncheckedTrackColor = Beige500.copy(alpha = 0.5f)
                )
            )
        }

        RangeSlider(
            value = cnLevelRange.value.start.toFloat()..cnLevelRange.value.endInclusive.toFloat(),
            onValueChange = { range ->
                val startInt = kotlin.math.round(range.start).toInt()
                val endInt = kotlin.math.round(range.endInclusive).toInt()
                val intRange = startInt..endInt
                cnLevelRange.value = intRange
                // 立即更新筛选范围（如果CN filter启用）
                if (isCnFilterEnabled.value) {
                    filterCnLevelRange.value = intRange
                }
            },
            valueRange = 10f..154f,
            steps = 144, // 154 - 10 = 144 steps
            enabled = isCnFilterEnabled.value,
            colors = SliderDefaults.colors(
                thumbColor = Beige500,
                activeTrackColor = Red500,
                inactiveTrackColor = Red300,
                disabledThumbColor = Red300,
                disabledActiveTrackColor = Red300.copy(alpha = 0.5f),
                disabledInactiveTrackColor = Red300.copy(alpha = 0.3f),
                activeTickColor = Color.Transparent,
                inactiveTickColor = Color.Transparent,
                disabledActiveTickColor = Color.Transparent,
                disabledInactiveTickColor = Color.Transparent
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        change.consume()
                    }
                },
        )
    }
}

private fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}
