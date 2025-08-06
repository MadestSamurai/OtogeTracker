package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import com.madsam.otora.core.icon.Fa
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.Cloud
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataUpdateScreen(
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "数据更新",
                    fontFamily = sarasaFont,
                    fontWeight = FontWeight.Bold,
                    color = Beige400
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "返回",
                        tint = Beige400,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Red500,
                titleContentColor = Beige400,
                navigationIconContentColor = Beige400
            )
        )
        
        // 数据源列表
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(DataSource.entries.toTypedArray()) { dataSource ->
                DataSourceItem(
                    dataSource = dataSource,
                    onClick = {
                        // TODO: 导航到具体的游戏数据更新页面
                    }
                )
                
                // 添加分割线，除了最后一项
                if (dataSource != DataSource.entries.last()) {
                    HorizontalDivider(
                        color = Beige400.copy(alpha = 0.2f),
                        thickness = 0.5.dp,
                        modifier = Modifier.padding(horizontal = 56.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DataSourceItem(
    dataSource: DataSource,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = dataSource.icon,
            contentDescription = null,
            tint = Beige400,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = dataSource.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            if (dataSource.description.isNotEmpty()) {
                Text(
                    text = dataSource.description,
                    color = White1000.copy(alpha = 0.6f),
                    fontSize = 14.sp,
                    fontFamily = sarasaFont
                )
            }
            
            if (dataSource.lastUpdate.isNotEmpty()) {
                Text(
                    text = "上次更新: ${dataSource.lastUpdate}",
                    color = White1000.copy(alpha = 0.4f),
                    fontSize = 12.sp,
                    fontFamily = sarasaFont
                )
            }
        }
        
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = White1000.copy(alpha = 0.5f),
            modifier = Modifier.size(18.dp)
        )
    }
}

enum class DataSource(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val lastUpdate: String = ""
) {
    Osu(
        title = "osu!",
        description = "更新osu!谱面和成绩数据",
        icon = Filled.OsuIcon,
        lastUpdate = "2024-08-05 14:30"
    ),
    Maimai(
        title = "maimai DX",
        description = "更新maimai DX歌曲和成绩数据",
        icon = Filled.MaimaiIcon,
        lastUpdate = "2024-08-05 12:15"
    ),
    Chunithm(
        title = "CHUNITHM",
        description = "更新CHUNITHM歌曲和成绩数据",
        icon = Filled.ChunithmIcon,
        lastUpdate = "2024-08-05 16:45"
    ),
    BOF(
        title = "BOF数据",
        description = "更新BOF活动和相关数据",
        icon = Fa.Cloud,
        lastUpdate = "2024-08-04 20:00"
    ),
    General(
        title = "通用设置",
        description = "自动更新频率和网络设置",
        icon = Fa.Cog
    )
}
