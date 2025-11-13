package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.NumberFormatUtils.formatThousand
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayDataCategoryProvider
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayDataUiModel
import com.madsam.otora.data.chunithm.ui.model.PlayDataCategoryType
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun PlayDataList(
    width: Dp,
    chunithmPlayDataUiModel: MutableStateFlow<ChunithmPlayDataUiModel>
) {
    val playData by chunithmPlayDataUiModel.collectAsState()
    
    // 当前选择的分类方式
    val selectedCategoryType = remember { mutableStateOf(PlayDataCategoryType.DIFFICULTY) }
    
    // 根据分类类型获取页面列表
    val pages = remember(selectedCategoryType.value) {
        when (selectedCategoryType.value) {
            PlayDataCategoryType.DIFFICULTY -> listOf("Basic", "Advanced", "Expert", "Master", "Ultima")
            PlayDataCategoryType.GENRE -> ChunithmPlayDataCategoryProvider.getGenreCategories().map { it.name }
            PlayDataCategoryType.VERSION -> ChunithmPlayDataCategoryProvider.getVersionCategories().map { it.name }
            PlayDataCategoryType.LEVEL -> ChunithmPlayDataCategoryProvider.getLevelCategories().map { it.name }
        }
    }
    
    val pagerState = rememberPagerState(pageCount = { pages.size })
    
    // 当分类类型变化时，滚动到第一页
    LaunchedEffect(selectedCategoryType.value) {
        pagerState.scrollToPage(0)
    }
    
    // 当前页面信息
    val currentPage by remember {
        derivedStateOf { pages[pagerState.currentPage] }
    }
    
    // 计算卡片宽度：总宽度的 85%
    val cardWidth = width * 0.85f
    
    // 计算平滑的 padding - 添加 pages.size 作为依赖
    val startPadding by remember(pages.size) {
        derivedStateOf {
            val maxPadding = width - cardWidth
            val centerPadding = maxPadding / 2
            val pageCount = pages.size
            
            val padding = when {
                // 只有1页：保持居中
                pageCount <= 1 -> centerPadding
                
                // 只有2页：第一页贴左，第二页贴右
                pageCount == 2 -> {
                    val currentPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
                    maxPadding * (currentPosition / 1f)
                }
                
                // 3页及以上：第一页贴左，最后一页贴右，中间居中
                else -> {
                    val currentPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
                    val lastPageIndex = pageCount - 1
                    
                    when {
                        // 第一页：0
                        currentPosition <= 0f -> 0.dp
                        
                        // 从第一页到第二页的过渡：0 -> centerPadding
                        currentPosition < 1f -> {
                            centerPadding * currentPosition
                        }
                        
                        // 中间页面（第2页到倒数第2页）：居中
                        currentPosition < lastPageIndex - 1f -> {
                            centerPadding
                        }
                        
                        // 从倒数第二页到最后一页的过渡：centerPadding -> maxPadding
                        currentPosition < lastPageIndex -> {
                            val progress = currentPosition - (lastPageIndex - 1f)
                            centerPadding + centerPadding * progress
                        }
                        
                        // 最后一页：maxPadding
                        else -> maxPadding
                    }
                }
            }
            
            // 确保 padding 在有效范围内
            padding.coerceIn(0.dp, maxPadding)
        }
    }
    
    val endPadding by remember(pages.size) {
        derivedStateOf {
            val padding = width - cardWidth - startPadding
            // 确保 padding 不为负数
            padding.coerceAtLeast(0.dp)
        }
    }

    Column(
        modifier = Modifier
            .padding(bottom = 12.dp)
            .width(width)
    ) {
        // 固定标题栏
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "游玩数据",
                fontSize = 16.sp,
                fontFamily = sarasaBold,
                color = Beige500
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            // 当前分类方式提示（仅在非难度模式显示）
            if (selectedCategoryType.value != PlayDataCategoryType.DIFFICULTY) {
                Text(
                    text = when (selectedCategoryType.value) {
                        PlayDataCategoryType.GENRE -> "类型"
                        PlayDataCategoryType.VERSION -> "版本"
                        PlayDataCategoryType.LEVEL -> "定数"
                        else -> ""
                    },
                    fontSize = 12.sp,
                    fontFamily = sarasaBold,
                    color = Beige500.copy(alpha = 0.7f),
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Red700.copy(alpha = 0.3f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                
                Spacer(modifier = Modifier.width(8.dp))
            }
            
            // 难度标签（仅在难度模式显示）
            if (selectedCategoryType.value == PlayDataCategoryType.DIFFICULTY) {
                Text(
                    text = currentPage.toUpperCase(Locale.current),
                    fontSize = 12.sp,
                    fontFamily = sarasaBold,
                    color = White1000,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            when (currentPage) {
                                "Basic" -> CHUNI_DIFF_BASIC
                                "Advanced" -> CHUNI_DIFF_ADVANCED
                                "Expert" -> CHUNI_DIFF_EXPERT
                                "Master" -> CHUNI_DIFF_MASTER
                                "Ultima" -> CHUNI_DIFF_ULTIMA_1
                                else -> Red500
                            }
                        )
                        .border(
                            width = if (currentPage == "Ultima") 1.dp else 0.dp,
                            color = if (currentPage == "Ultima") CHUNI_DIFF_ULTIMA_2 else Color.Transparent,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // 详细按钮
            Text(
                text = "详细",
                color = Red500,
                fontSize = 14.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Red700)
                    .clickable { /* TODO: 跳转到游玩数据详情 */ }
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
        
        // 分类方式选择器
        PlayDataCategorySelector(
            selectedType = selectedCategoryType.value,
            onTypeChange = { selectedCategoryType.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        
        // 横向分页器 - 滑动式布局，显示左右预览
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(
                start = startPadding,
                end = endPadding
            ),
            pageSpacing = 8.dp
        ) { page ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
                    .background(Red700)
                    .padding(horizontal = 6.dp, vertical = 8.dp)
            ) {
                // 根据分类类型显示不同数据
                when (selectedCategoryType.value) {
                    PlayDataCategoryType.DIFFICULTY -> {
                        when (pages[page]) {
                            "Basic" -> DifficultyPlayData(playData.basicPlayData)
                            "Advanced" -> DifficultyPlayData(playData.advancedPlayData)
                            "Expert" -> DifficultyPlayData(playData.expertPlayData)
                            "Master" -> DifficultyPlayData(playData.masterPlayData)
                            "Ultima" -> DifficultyPlayData(playData.ultimaPlayData)
                        }
                    }
                    PlayDataCategoryType.GENRE -> {
                        // TODO: 显示类型分类数据（需要 ViewModel 提供数据）
                        PlaceholderPlayData(pages[page], "类型")
                    }
                    PlayDataCategoryType.VERSION -> {
                        // TODO: 显示版本分类数据（需要 ViewModel 提供数据）
                        PlaceholderPlayData(pages[page], "版本")
                    }
                    PlayDataCategoryType.LEVEL -> {
                        // TODO: 显示定数分类数据（需要 ViewModel 提供数据）
                        PlaceholderPlayData(pages[page], "定数")
                    }
                }
            }
        }
    }
}

/**
 * 占位符数据显示（用于暂未实现的分类）
 */
@Composable
private fun PlaceholderPlayData(categoryName: String, categoryType: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = categoryName,
            fontSize = 18.sp,
            fontFamily = sarasaBold,
            color = White1000
        )
        Text(
            text = "按${categoryType}分类的数据统计",
            fontSize = 14.sp,
            fontFamily = sarasaRegular,
            color = Beige500.copy(alpha = 0.8f)
        )
        Text(
            text = "即将推出",
            fontSize = 12.sp,
            fontFamily = sarasaRegular,
            color = Beige500.copy(alpha = 0.6f),
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(Red500.copy(alpha = 0.3f))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

/**
 * 单个难度页面：显示该难度所有评级
 */
@Composable
private fun DifficultyPlayData(data: ChunithmPlayDataUiModel.ChunithmPlayDataItemUI) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        // 评级区：S/S+/SS/SS+/SSS/SSS+ 复合条子
        ScoreRankBar(
            s = data.rateS,
            sp = data.rateSp,
            ss = data.rateSS,
            ssp = data.rateSSp,
            sss = data.rateSSS,
            sssp = data.rateSSSp,
            total = data.totalSongs
        )
        
        // 通关类型：CLEAR/HARD/BRAVE/ABSOLUTE/CATASTROPHY 复合条子
        ClearTypeBar(
            clear = data.rateClear,
            hard = data.rateHard,
            brave = data.rateBrave,
            absolute = data.rateAbs,
            catastrophy = data.rateCatas,
            total = data.totalSongs
        )
        
        // 其他评级：一排显示，两行布局
        OtherStatsRow(
            fc = data.rateFC,
            aj = data.rateAJ,
            ajc = data.rateAJC,
            fchain = data.rateFChain,
            fchainPlus = data.rateFChainP
        )
    }
}

/**
 * 评级进度条：单根复合条子显示评级分布
 */
@Composable
private fun ScoreRankBar(
    s: Int, sp: Int, ss: Int, ssp: Int, sss: Int, sssp: Int,
    total: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Red500.copy(alpha = 0.6f))
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // 标题行：左侧标题 + 右侧总数
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SCORE RANK",
                fontSize = 11.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f)
            )
            Text(
                text = "${formatThousand(s)} / ${formatThousand(total)}",
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500
            )
        }
        
        // 单根复合进度条（总宽度基于total，从左到右：S → S+ → SS → SS+ → SSS → SSS+）
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Red700.copy(alpha = 0.3f))
        ) {
            // 计算每段的实际数量（不是累积值，而是各自独立的数量）
            val countS = s - sp  // 只有S的数量
            val countSp = sp - ss
            val countSS = ss - ssp
            val countSSp = ssp - sss
            val countSSs = sss - sssp
            val countSSsp = sssp
            val countBelowS = total - s  // 低于S的数量
            
            // S (铜色)
            if (countS > 0) {
                Box(
                    modifier = Modifier
                        .weight(countS.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFCD7F32))
                )
            }
            // S+ (铜色)
            if (countSp > 0) {
                Box(
                    modifier = Modifier
                        .weight(countSp.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFCD7F32).copy(alpha = 0.85f))
                )
            }
            // SS (银色)
            if (countSS > 0) {
                Box(
                    modifier = Modifier
                        .weight(countSS.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFC0C0C0))
                )
            }
            // SS+ (银色)
            if (countSSp > 0) {
                Box(
                    modifier = Modifier
                        .weight(countSSp.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFC0C0C0).copy(alpha = 0.85f))
                )
            }
            // SSS (金色)
            if (countSSs > 0) {
                Box(
                    modifier = Modifier
                        .weight(countSSs.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFFFD700))
                )
            }
            // SSS+ (金色)
            if (countSSsp > 0) {
                Box(
                    modifier = Modifier
                        .weight(countSSsp.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFFFD700).copy(alpha = 0.85f))
                )
            }
            // 低于S的部分（透明/暗色）
            if (countBelowS > 0) {
                Box(
                    modifier = Modifier
                        .weight(countBelowS.toFloat())
                        .fillMaxHeight()
                        .background(Red700.copy(alpha = 0.3f))
                )
            }
        }
        
        // 标签和数值（均匀分布）
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ScoreRankLabel("S", s - sp, Color(0xFFCD7F32))
            ScoreRankLabel("S+", sp - ss, Color(0xFFCD7F32))
            ScoreRankLabel("SS", ss - ssp, Color(0xFFC0C0C0))
            ScoreRankLabel("SS+", ssp - sss, Color(0xFFC0C0C0))
            ScoreRankLabel("SSS", sss - sssp, Color(0xFFFFD700))
            ScoreRankLabel("SSS+", sssp, Color(0xFFFFD700))
        }
    }
}

/**
 * 通关类型进度条：单根复合条子显示通关类型分布
 */
@Composable
private fun ClearTypeBar(
    clear: Int, hard: Int, brave: Int, absolute: Int, catastrophy: Int,
    total: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Red500.copy(alpha = 0.6f))
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // 标题行：左侧标题 + 右侧总数
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "CLEAR TYPE",
                fontSize = 11.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f)
            )
            Text(
                text = "${formatThousand(clear)} / ${formatThousand(total)}",
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500
            )
        }
        
        // 单根复合进度条（总宽度基于total，从左到右：CLEAR → HARD → BRAVE → ABS → CATAS）
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Red700.copy(alpha = 0.3f))
        ) {
            // 计算每段的实际数量
            val countClear = clear - hard
            val countHard = hard - brave
            val countBrave = brave - absolute
            val countAbs = absolute - catastrophy
            val countCatas = catastrophy
            val countNoClear = total - clear  // 未通关
            
            // CLEAR (绿色)
            if (countClear > 0) {
                Box(
                    modifier = Modifier
                        .weight(countClear.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFF4CAF50))
                )
            }
            // HARD (蓝色)
            if (countHard > 0) {
                Box(
                    modifier = Modifier
                        .weight(countHard.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFF2196F3))
                )
            }
            // BRAVE (橙色)
            if (countBrave > 0) {
                Box(
                    modifier = Modifier
                        .weight(countBrave.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFFF9800))
                )
            }
            // ABSOLUTE (紫色)
            if (countAbs > 0) {
                Box(
                    modifier = Modifier
                        .weight(countAbs.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFF9C27B0))
                )
            }
            // CATASTROPHY (粉红色)
            if (countCatas > 0) {
                Box(
                    modifier = Modifier
                        .weight(countCatas.toFloat())
                        .fillMaxHeight()
                        .background(Color(0xFFE91E63))
                )
            }
            // 未通关的部分（暗色）
            if (countNoClear > 0) {
                Box(
                    modifier = Modifier
                        .weight(countNoClear.toFloat())
                        .fillMaxHeight()
                        .background(Red700.copy(alpha = 0.3f))
                )
            }
        }
        
        // 标签和数值（均匀分布）
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ClearTypeLabel("CLR", clear - hard, Color(0xFF4CAF50))
            ClearTypeLabel("HRD", hard - brave, Color(0xFF2196F3))
            ClearTypeLabel("BRV", brave - absolute, Color(0xFFFF9800))
            ClearTypeLabel("ABS", absolute - catastrophy, Color(0xFF9C27B0))
            ClearTypeLabel("CATAS", catastrophy, Color(0xFFE91E63))
        }
    }
}

/**
 * 通关类型标签和数值
 */
@Composable
private fun ClearTypeLabel(
    label: String,
    count: Int,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontFamily = sarasaBold,
            color = color
        )
        Text(
            text = formatThousand(count),
            fontSize = 10.sp,
            fontFamily = sarasaRegular,
            color = Beige500
        )
    }
}

/**
 * 其他统计数据：一排显示5个数据，两行布局
 */
@Composable
private fun OtherStatsRow(
    fc: Int, aj: Int, ajc: Int, fchain: Int, fchainPlus: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Red500.copy(alpha = 0.6f))
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // 第一行：标签
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "FC",
                fontSize = 10.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "AJ",
                fontSize = 10.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "AJC",
                fontSize = 10.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "FCHAIN",
                fontSize = 10.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "FCHAIN+",
                fontSize = 10.sp,
                fontFamily = sarasaBold,
                color = White1000.copy(alpha = 0.85f),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
        
        // 第二行：数值
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = formatThousand(fc),
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = formatThousand(aj),
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = formatThousand(ajc),
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = formatThousand(fchain),
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = formatThousand(fchainPlus),
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                color = Beige500,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * 评级标签和数值
 */
@Composable
private fun ScoreRankLabel(
    rank: String,
    count: Int,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = rank,
            fontSize = 10.sp,
            fontFamily = sarasaBold,
            color = color
        )
        Text(
            text = formatThousand(count),
            fontSize = 10.sp,
            fontFamily = sarasaRegular,
            color = Beige500
        )
    }
}