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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import com.madsam.otora.core.icon.Fa
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.Palette
import com.madsam.otora.core.icon.fa.Refresh
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf<SettingsCategory?>(null) }
    
    if (selectedCategory != null) {
        // 显示子页面
        when (selectedCategory) {
            SettingsCategory.DataUpdate -> {
                DataUpdateScreen(
                    onNavigateBack = { selectedCategory = null }
                )
            }
            SettingsCategory.Appearance -> {
                AppearanceScreen(
                    onNavigateBack = { selectedCategory = null }
                )
            }
            null -> {
                // 这个分支永远不会被执行，因为我们已经检查了 selectedCategory != null
            }
        }
    } else {
        // 显示主设置页面
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Red300)
        ) {
            // 顶栏
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "设置",
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
            
            // 设置分类列表
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(SettingsCategory.values()) { category ->
                    SettingsCategoryCard(
                        category = category,
                        onClick = { selectedCategory = category }
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsCategoryCard(
    category: SettingsCategory,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Red500),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = null,
                tint = White1000,
                modifier = Modifier.size(24.dp)
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = category.title,
                    color = White1000,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sarasaFont
                )
                
                Text(
                    text = category.description,
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = sarasaFont
                )
            }
            
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = White1000.copy(alpha = 0.7f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

enum class SettingsCategory(
    val title: String,
    val description: String,
    val icon: ImageVector
) {
    DataUpdate(
        title = "数据更新",
        description = "管理各游戏数据和BOF数据的更新",
        icon = Fa.Refresh
    ),
    Appearance(
        title = "外观设置",
        description = "主题、字体和界面显示设置",
        icon = Fa.Palette
    )
}
