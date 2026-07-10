package com.madsam.otora.ui.record.osu.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import com.madsam.otora.data.osu.ui.model.OsuCardUiModel
import com.madsam.otora.ui.components.GroupListItem
import com.madsam.otora.ui.components.PopupTip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Material 3 重构版本的用户卡片
 * 拆分为三个独立卡片：
 * 1. 用户概览卡片 - 头像、姓名、在线状态、Supporter
 * 2. 排名卡片 - 全球排名和国家排名
 * 3. 徽章/组别展示通过其他组件完成
 */
@Composable
internal fun Card(
    osuCardData: MutableStateFlow<OsuCardUiModel>,
    osuGroupDTOList: MutableStateFlow<List<OsuGroupDTO>>,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val cardData by osuCardData.collectAsState()
    val groupListData = osuGroupDTOList.collectAsState(initial = emptyList()).value

    Column(
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        // 用户概览卡片（封面 + 头像 + 基本信息）
        UserProfileCard(
            cardData = cardData,
            groupListData = groupListData,
            cardWidthDp = cardWidthDp,
            colorScheme = colorScheme
        )
    }
}

/**
 * 用户概览卡片 - Material 3 Card组件
 * 包含：封面图、头像、用户名、在线状态、Supporter标志、Title标志、组别列表
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun UserProfileCard(
    cardData: OsuCardUiModel,
    groupListData: List<OsuGroupDTO>,
    cardWidthDp: Dp,
    colorScheme: androidx.compose.material3.ColorScheme
) {
    val gifLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
            add(GifDecoder.Factory())
        }
        .build()
    
    Card(
        modifier = Modifier.width(cardWidthDp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp // M3扁平化设计
        )
    ) {
        Box {
            // 封面图
            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.coverUrl,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = stringResource(R.string.osu_cd_cover_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )
            
            // Title标志
            if (cardData.isTitle) {
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = colorScheme.primaryContainer
                ) {
                    Text(
                        text = cardData.title,
                        color = colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
            
            // 组别列表
            LazyRow(
                reverseLayout = true,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 12.dp)
                    .wrapContentHeight()
                    .width(cardWidthDp - 24.dp)
            ) {
                items(groupListData.size) { index ->
                    GroupListItem(osuGroupDTO = groupListData[index])
                }
            }
        }

        // Tournament Banner（如果有）
        if (cardData.tournamentBannerImage2x.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.tournamentBannerImage2x,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = stringResource(R.string.osu_cd_tournament_banner),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(cardWidthDp / 50 * 3)
            )
        }
        
        // 用户信息区域
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 头像
            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.avatarUrl,
                    imageLoader = gifLoader,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = stringResource(R.string.osu_cd_avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // 用户名和状态
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val formerUsernameShowPopup = remember { MutableTransitionState(false) }
                    Text(
                        text = cardData.username,
                        color = colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            formerUsernameShowPopup.targetState = true
                        }
                    )
                    
                    // Supporter标志
                    if (cardData.isSupporter) {
                        val supporterTooltipState = rememberTooltipState()
                        val supporterTooltipScope = rememberCoroutineScope()

                        TooltipBox(
                            positionProvider = TooltipDefaults.rememberTooltipPositionProvider(
                                positioning = TooltipAnchorPosition.Above,
                                spacingBetweenTooltipAndAnchor = 4.dp
                            ),
                            tooltip = {
                                PlainTooltip(
                                    shadowElevation = 2.dp
                                ) {
                                    Text(
                                        text = stringResource(
                                            R.string.osu_supporter_rank_format,
                                            cardData.supporterRank
                                        ),
                                        style = MaterialTheme.typography.labelMedium,
                                        lineHeight = 16.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            },
                            state = supporterTooltipState,
                            focusable = false,
                            enableUserInput = false
                        ) {
                            Surface(
                                modifier = Modifier
                                    .height(20.dp)
                                    .clickable {
                                        supporterTooltipScope.launch {
                                            supporterTooltipState.show()
                                        }
                                    },
                                shape = RoundedCornerShape(100.dp),
                                color = MaterialTheme.colorScheme.tertiary
                            ) {
                                Image(
                                    painter = rememberVectorPainter(
                                        image = when (cardData.supporterRank) {
                                            1 -> Filled.Heart1
                                            2 -> Filled.Heart2
                                            3 -> Filled.Heart3
                                            else -> Filled.Heart1
                                        }
                                    ),
                                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onTertiary),
                                    contentDescription = stringResource(R.string.osu_cd_supporter_rank),
                                    modifier = Modifier
                                        .height(20.dp)
                                        .padding(horizontal = 12.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                    
                    // Former username popup
                    if (cardData.formerUsernames.isNotEmpty()) {
                        PopupTip(
                            stringResource(
                                R.string.osu_former_usernames_format,
                                cardData.formerUsernames
                            ),
                            colorScheme.onSurface,
                            Modifier,
                            formerUsernameShowPopup,
                            Alignment.TopStart
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // 国家和Team信息
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // 国旗
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(cardData.flagUrl)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.width(20.dp)
                    )
                    
                    // 国家名
                    Text(
                        text = localizedCountryName(cardData.countryCode, cardData.country),
                        color = colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall
                    )
                    
                    // Team信息（如果存在）
                    if (cardData.teamId != 0 && cardData.teamShortName.isNotEmpty()) {
                        Text(
                            text = "•",
                            color = colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall
                        )
                        
                        // Team旗帜
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(cardData.teamFlagUrl)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.width(20.dp)
                        )
                        
                        // Team简称
                        Text(
                            text = cardData.teamShortName,
                            color = colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // 在线状态
                OnlineStatus(cardData = cardData, colorScheme = colorScheme)
            }
        }
    }
}

/**
 * 在线状态指示器
 */
@Composable
private fun OnlineStatus(
    cardData: OsuCardUiModel,
    colorScheme: androidx.compose.material3.ColorScheme
) {
    val inlineContent = mapOf(
        "onlineMark" to InlineTextContent(
            Placeholder(
                width = 20.sp,
                height = 16.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
            )
        ) {
            Icon(
                painter = rememberVectorPainter(image = Filled.OsuOnline),
                tint = if (cardData.isOnline) Color(0xFF8DC63F) else colorScheme.onSurface.copy(alpha = 0.38f), // TODO: 硬编码颜色 - 在线绿色指示器，是否改为主题色？
                contentDescription = stringResource(id = R.string.online_mark),
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )
        }
    )
    
    Text(
        text = buildAnnotatedString {
            appendInlineContent("onlineMark", "[${stringResource(id = R.string.online_mark)}]")
            append(stringResource(id = if (cardData.isOnline) R.string.online else R.string.offline))
        },
        inlineContent = inlineContent,
        color = if (cardData.isOnline) colorScheme.secondary else colorScheme.onSurface.copy(alpha = 0.6f),
        style = MaterialTheme.typography.bodyMedium
    )
}
