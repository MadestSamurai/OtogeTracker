package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO

/**
 * Chunithm 登录奖励跟踪器
 * 显示：下一个常驻签到奖励 | 下一个月度签到奖励 | 当天的加成
 *
 * @param loginBonus 登录奖励数据
 */
@Composable
fun LoginBonusTracker(loginBonus: ChuniLoginBonusDTO?) {
    if (loginBonus == null) return
    
    val colorScheme = MaterialTheme.colorScheme
    
    // 找到下一个常驻签到奖励（14天循环）
    val nextDailyReward = loginBonus.dailyRewards.firstOrNull { !it.isReceived }
    
    // 找到下一个月度签到奖励
    val nextMonthlyReward = loginBonus.monthlyRewards.firstOrNull { !it.isCompleted }
    
    // 找到当天的加成
    val todayBonus = loginBonus.weekdayBonuses.firstOrNull { it.isTodayBonus() }
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        // 当前天数信息
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "登录奖励",
                color = colorScheme.primary,
                fontSize = 16.sp,
                fontFamily = sarasaBold
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 版本签到天数
                Text(
                    text = "版本签到：${loginBonus.dailyLoginDay} 天",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
                
                // 月度签到天数
                Text(
                    text = "本月签到：${loginBonus.currentMonth} 天",
                    color = colorScheme.primary,
                    fontSize = 12.sp,
                    fontFamily = sarasaSemiBold
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // 详细按钮
            Text(
                text = "详细",
                color = colorScheme.surfaceContainer,
                fontSize = 14.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(colorScheme.surfaceContainerHigh)
                    .clickable { /* TODO: 跳转到登录奖励详情 */ }
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
        
        // 奖励卡片
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 下一个常驻签到奖励
            BonusCard(
                modifier = Modifier.weight(1f),
                title = "下一个版本签到",
                subtitle = nextDailyReward?.let { "第${it.day}天" } ?: "已完成",
                imageUrl = nextDailyReward?.imageUrl ?: "",
                rewardName = nextDailyReward?.rewardName ?: "",
                colorScheme = colorScheme
            )
            
            // 下一个月度签到奖励
            BonusCard(
                modifier = Modifier.weight(1f),
                title = "下一个月度签到",
                subtitle = nextMonthlyReward?.let { "第${it.day}天" } ?: "已完成",
                imageUrl = nextMonthlyReward?.imageUrl ?: "",
                rewardName = nextMonthlyReward?.rewardName ?: "",
                colorScheme = colorScheme
            )
            
            // 当天的加成
            BonusCard(
                modifier = Modifier.weight(1f),
                title = "今日加成",
                subtitle = todayBonus?.weekday ?: "",
                imageUrl = todayBonus?.iconUrl ?: "",
                rewardName = todayBonus?.description ?: "",
                colorScheme = colorScheme
            )
        }
    }
}

/**
 * 奖励卡片
 */
@Composable
private fun BonusCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    imageUrl: String,
    rewardName: String,
    colorScheme: androidx.compose.material3.ColorScheme
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorScheme.surfaceContainerHigh)
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // 标题
        Text(
            text = title,
            color = colorScheme.onSurface,
            fontSize = 11.sp,
            fontFamily = sarasaBold,
            textAlign = TextAlign.Center
        )
        
        // 副标题（天数或星期）
        if (subtitle.isNotEmpty()) {
            Text(
                text = subtitle,
                color = colorScheme.onSurfaceVariant,
                fontSize = 10.sp,
                fontFamily = sarasaRegular,
                textAlign = TextAlign.Center
            )
        }
        
        // 奖励图片
        if (imageUrl.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(colorScheme.surfaceContainer),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = rewardName,
                    modifier = Modifier.size(52.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
        
        // 奖励名称
        if (rewardName.isNotEmpty()) {
            Text(
                text = rewardName,
                color = colorScheme.onSurfaceVariant,
                fontSize = 9.sp,
                fontFamily = sarasaRegular,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.basicMarquee()
            )
        }
    }
}
