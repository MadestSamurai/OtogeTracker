package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.datastore.ThemeColor
import com.madsam.otora.core.datastore.ThemeDataStore
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.theme.plexSemi
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeColorSettingScreen(
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val themeDataStore = remember { ThemeDataStore(context) }
    
    // 获取当前主题颜色
    val themeSettings by themeDataStore.getThemeSettingsFlow().collectAsState(
        initial = ThemeDataStore.ThemeSettings()
    )
    val currentColor = themeSettings.themeColor
    
    val colorScheme = MaterialTheme.colorScheme
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "主题颜色",
                    fontFamily = plexBold,
                    color = colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Fa.`Chevron-left`,
                        contentDescription = "返回",
                        tint = colorScheme.onSurface,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorScheme.surfaceContainer,
                scrolledContainerColor = Color.Unspecified,
                navigationIconContentColor = colorScheme.onSurface,
                titleContentColor = colorScheme.onSurface,
                actionIconContentColor = Color.Unspecified
            )
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // 预览区域
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "当前主题色",
                        color = colorScheme.onSurfaceVariant,
                        fontSize = 14.sp,
                        fontFamily = plexRegular
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    // 当前颜色展示
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(currentColor)
                            .border(2.dp, colorScheme.outline, CircleShape)
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    // 显示颜色名称
                    val colorName = ThemeColor.entries.find { 
                        it.color.value == currentColor.value 
                    }?.displayName ?: "自定义"
                    
                    Text(
                        text = colorName,
                        color = colorScheme.onSurface,
                        fontSize = 16.sp,
                        fontFamily = plexSemi
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 颜色选择标题
            Text(
                text = "选择颜色",
                color = colorScheme.onSurface,
                fontSize = 14.sp,
                fontFamily = plexSemi,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
            )
            
            // 颜色网格
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(ThemeColor.entries) { themeColor ->
                        ColorItem(
                            color = themeColor.color,
                            name = themeColor.displayName,
                            isSelected = themeColor.color.value == currentColor.value,
                            onClick = {
                                scope.launch {
                                    themeDataStore.saveThemeColor(themeColor.color)
                                }
                            }
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 提示文字
            Text(
                text = "选择的颜色将作为应用的主题色，影响整体界面配色",
                color = colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                fontFamily = plexRegular,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
private fun ColorItem(
    color: Color,
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(color)
                .then(
                    if (isSelected) {
                        Modifier.border(3.dp, colorScheme.onSurface, CircleShape)
                    } else {
                        Modifier.border(1.dp, colorScheme.outline.copy(alpha = 0.5f), CircleShape)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Filled.Tick,
                    contentDescription = "已选中",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = name,
            color = if (isSelected) colorScheme.onSurface else colorScheme.onSurfaceVariant,
            fontSize = 10.sp,
            fontFamily = if (isSelected) plexSemi else plexRegular
        )
    }
}
