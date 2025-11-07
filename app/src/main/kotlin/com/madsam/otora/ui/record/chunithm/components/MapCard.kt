package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Chunithm 地图卡片 UI Model
 * 每个卡片代表一个地图的一页（因为页面无法翻页，每次只能看到一页）
 */
data class ChunithmMapUiModel(
    val mapName: String = "",
    val currentPage: Int = 1,           // 当前是第几页
    val totalPages: Int = 1,            // 该地图总共有几页
    val completedAreas: Int = 0,        // 这一页中已完成的格子数
    val totalAreas: Int = 0,            // 这一页中非空格子总数
    val progressPercentage: Double = 0.0, // 这一页的完成度
    val areas: List<MapAreaUiModel> = emptyList()  // 这一页的9个格子
)

/**
 * 地图格子 UI Model
 */
data class MapAreaUiModel(
    val position: Int = 0,        // 格子位置 0-8（3x3网格）
    val imageUrl: String = "",
    val remain: Int = 0,
    val skillSeed: String = "",
    val isEmpty: Boolean = false
)

/**
 * Chunithm 地图九宫格组件
 * 使用 HorizontalPager 在不同地图卡片之间左右滑动
 * 标题栏固定不动，内容随页面切换而渐变
 * 显示当前卡片和左右卡片的部分预览
 * 
 * @param mapDataFlow 地图数据流（每个元素代表一个地图的一页）
 * @param width 卡片宽度
 */
@Composable
fun MapCard(
    mapDataFlow: MutableStateFlow<List<ChunithmMapUiModel>>,
    width: Dp
) {
    val mapList by mapDataFlow.collectAsState()
    
    if (mapList.isEmpty()) return
    
    // 使用 HorizontalPager 在不同地图卡片之间滑动
    val pagerState = rememberPagerState(pageCount = { mapList.size })
    
    // 当前页的地图数据
    val currentMapData by remember {
        derivedStateOf {
            if (pagerState.currentPage < mapList.size) {
                mapList[pagerState.currentPage]
            } else {
                mapList.firstOrNull()
            }
        }
    }
    
    // 计算卡片宽度：总宽度的 85%
    val cardWidth = width * 0.85f
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        // 固定标题栏（不随滑动移动，但内容会渐变）
        currentMapData?.let { mapData ->
            MapTitleBar(
                mapData = mapData,
                currentPage = pagerState.currentPage + 1,
                totalMaps = mapList.size,
                onDetailClick = {
                    // TODO: 跳转到地图详情页
                }
            )
        }
        
        // 计算平滑的 padding（完全基于当前位置，避免状态跳变）
        val startPadding by remember {
            derivedStateOf {
                when {
                    // 只有1页：保持居中
                    mapList.size <= 1 -> {
                        (width - cardWidth) / 2
                    }
                    // 只有2页的情况：直接从 0 过渡到 (width - cardWidth)
                    mapList.size == 2 -> {
                        val currentPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
                        (width - cardWidth) * currentPosition
                    }
                    // 3页及以上
                    else -> {
                        val currentPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
                        val lastPageIndex = mapList.size - 1
                        val centerPadding = (width - cardWidth) / 2
                        
                        when {
                            // 从第一页到第二页：0 -> centerPadding
                            currentPosition < 1f -> {
                                centerPadding * currentPosition
                            }
                            // 从倒数第二页到最后一页：centerPadding -> (width - cardWidth)
                            currentPosition > lastPageIndex - 1f -> {
                                val progress = currentPosition - (lastPageIndex - 1f)
                                centerPadding + centerPadding * progress
                            }
                            // 中间所有页面：保持居中
                            else -> {
                                centerPadding
                            }
                        }
                    }
                }
            }
        }
        
        val endPadding by remember {
            derivedStateOf {
                width - cardWidth - startPadding
            }
        }
        
        // 横向分页器 - 只滑动网格内容，显示左右预览
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = startPadding,
                end = endPadding
            ),
            pageSpacing = 8.dp
        ) { page ->
            MapGridPage(
                areas = mapList[page].areas,
                width = cardWidth
            )
        }
    }
}

/**
 * 地图标题栏（固定不动）
 */
@Composable
private fun MapTitleBar(
    mapData: ChunithmMapUiModel,
    currentPage: Int,
    totalMaps: Int,
    onDetailClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        // 第一行：地图名称 + 详细按钮
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mapData.mapName,
                color = Beige500,
                fontSize = 18.sp,
                fontFamily = sarasaBold,
                modifier = Modifier.weight(1f)
            )
            
            // 详细按钮
            Text(
                text = "详细",
                color = Red500,
                fontSize = 14.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Red700)
                    .clickable { onDetailClick() }
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
        
        // 第二行：页码信息 + 完成进度
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (mapData.totalPages > 1) {
                Text(
                    text = "第 ${mapData.currentPage}/${mapData.totalPages} 页",
                    color = Beige400,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                Text(
                    text = "·",
                    color = Beige400,
                    fontSize = 14.sp
                )
            }
            Text(
                text = "${mapData.completedAreas} / ${mapData.totalAreas}",
                color = Beige400,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
        }
    }
}

/**
 * 单页地图网格（3x3）
 */
@Composable
private fun MapGridPage(
    areas: List<MapAreaUiModel>,
    width: Dp
) {
    val cellWidth = (width - 32.dp) / 3 // 每个格子的宽度
    val cellHeight = cellWidth * 1.3f // 格子高度 = 宽度 × 1.3，形成竖长方形
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Red700)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 3 行
        for (row in 0..2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // 3 列
                for (col in 0..2) {
                    val position = row * 3 + col
                    val area = areas.firstOrNull { it.position == position }
                    
                    MapGridCell(
                        area = area,
                        width = cellWidth,
                        height = cellHeight
                    )
                }
            }
        }
    }
}

/**
 * 单个地图格子（竖长方形设计）
 */
@Composable
private fun MapGridCell(
    area: MapAreaUiModel?,
    width: Dp,
    height: Dp
) {
    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (area?.isEmpty == true) Color.Transparent
                else Red500
            ),
        contentAlignment = Alignment.Center
    ) {
        if (area != null && !area.isEmpty) {
            // 图标区域（完整显示图像，不裁切）
            if (area.imageUrl.isNotEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(area.imageUrl),
                    contentDescription = "Map Area Icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            // 完成度标记（悬浮在右上角）
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        if (area.remain > 0) Red700 else Color(0xFF4CAF50)
                    )
                    .padding(horizontal = 6.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                if (area.remain > 0) {
                    Text(
                        text = area.remain.toString(),
                        color = Beige500,
                        fontSize = 10.sp,
                        fontFamily = sarasaBold,
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                } else {
                    Text(
                        text = "✓",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = sarasaBold
                    )
                }
            }
            
            // 技能种子（独立在底部）
            if (area.skillSeed.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color(0x99000000)) // 半透明黑色背景
                        .padding(vertical = 2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = area.skillSeed,
                        color = Beige400,
                        fontSize = 9.sp,
                        fontFamily = sarasaRegular,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
