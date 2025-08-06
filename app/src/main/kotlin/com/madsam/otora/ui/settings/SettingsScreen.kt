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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.Cloud
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.icon.fa.Font
import com.madsam.otora.core.icon.fa.Language
import com.madsam.otora.core.icon.fa.Moon
import com.madsam.otora.core.icon.fa.Palette
import com.madsam.otora.core.icon.fa.Sun
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
    var selectedDataUpdateSetting by remember { mutableStateOf<DataUpdateSettings?>(null) }
    var selectedAppearanceSetting by remember { mutableStateOf<AppearanceSettings?>(null) }
    var selectedNetworkSetting by remember { mutableStateOf<NetworkSettings?>(null) }
    
    if (selectedDataUpdateSetting != null) {
        // 显示具体游戏的数据更新页面
        when (selectedDataUpdateSetting) {
            DataUpdateSettings.Osu -> {
                OsuDataUpdateScreen(
                    onNavigateBack = { selectedDataUpdateSetting = null }
                )
            }
            DataUpdateSettings.Maimai -> {
                MaimaiDataUpdateScreen(
                    onNavigateBack = { selectedDataUpdateSetting = null },
                    onNavigateToUserAgent = { 
                        selectedDataUpdateSetting = null
                        selectedNetworkSetting = NetworkSettings.UserAgent
                    }
                )
            }
            DataUpdateSettings.Chunithm -> {
                ChunithmDataUpdateScreen(
                    onNavigateBack = { selectedDataUpdateSetting = null },
                    onNavigateToUserAgent = { 
                        selectedDataUpdateSetting = null
                        selectedNetworkSetting = NetworkSettings.UserAgent
                    }
                )
            }
            DataUpdateSettings.BOF -> {
                BOFDataUpdateScreen(
                    onNavigateBack = { selectedDataUpdateSetting = null }
                )
            }
            DataUpdateSettings.General -> {
                GeneralDataUpdateScreen(
                    onNavigateBack = { selectedDataUpdateSetting = null }
                )
            }
            else -> {
                // 不应该到达这里
            }
        }
    } else if (selectedAppearanceSetting != null) {
        // 显示外观设置页面
        when (selectedAppearanceSetting) {
            else -> {
                // 其他外观设置暂未实现
                selectedAppearanceSetting = null
            }
        }
    } else if (selectedNetworkSetting != null) {
        // 显示网络设置页面
        when (selectedNetworkSetting) {
            NetworkSettings.UserAgent -> {
                UserAgentSettingScreen(
                    onNavigateBack = { selectedNetworkSetting = null }
                )
            }
            else -> {
                // 其他网络设置暂未实现
                selectedNetworkSetting = null
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
            
            // 设置列表
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 数据更新组
                item {
                    SettingsGroup(
                        title = "数据更新",
                        items = DataUpdateSettings.entries.toTypedArray()
                    ) { setting ->
                        DataUpdateSettingItem(
                            setting = setting,
                            onClick = { selectedDataUpdateSetting = setting }
                        )
                    }
                }
                
                // 外观设置组
                item {
                    SettingsGroup(
                        title = "外观设置",
                        items = AppearanceSettings.entries.toTypedArray()
                    ) { setting ->
                        when (setting.type) {
                            SettingType.Toggle -> {
                                ToggleSettingItem(
                                    setting = setting,
                                    onToggle = { /* TODO: 实现设置保存 */ }
                                )
                            }
                            SettingType.Selection -> {
                                SelectionSettingItem(
                                    setting = setting,
                                    onClick = { 
                                        selectedAppearanceSetting = setting
                                    }
                                )
                            }
                        }
                    }
                }
                
                // 网络设置组
                item {
                    SettingsGroup(
                        title = "网络设置",
                        items = NetworkSettings.entries.toTypedArray()
                    ) { setting ->
                        when (setting.type) {
                            SettingType.Toggle -> {
                                NetworkToggleSettingItem(
                                    setting = setting,
                                    onToggle = { /* TODO: 实现设置保存 */ }
                                )
                            }
                            SettingType.Selection -> {
                                NetworkSelectionSettingItem(
                                    setting = setting,
                                    onClick = { 
                                        selectedNetworkSetting = setting
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun <T> SettingsGroup(
    title: String,
    items: Array<T>,
    content: @Composable (T) -> Unit
) {
    Column {
        // 组标题
        Text(
            text = title,
            color = Beige400,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = sarasaFont,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        )
        
        // 组内容卡片
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Red500),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column {
                items.forEachIndexed { index, item ->
                    content(item)
                    // 除了最后一项，都添加分割线
                    if (index < items.size - 1) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.5.dp)
                                .background(White1000.copy(alpha = 0.1f))
                                .padding(horizontal = 56.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DataUpdateSettingItem(
    setting: DataUpdateSettings,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = White1000,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = setting.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            Text(
                text = setting.description,
                color = White1000.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontFamily = sarasaFont
            )
            
            if (setting.lastUpdate.isNotEmpty()) {
                Text(
                    text = "上次更新: ${setting.lastUpdate}",
                    color = White1000.copy(alpha = 0.5f),
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

@Composable
private fun ToggleSettingItem(
    setting: AppearanceSettings,
    onToggle: (Boolean) -> Unit
) {
    var isEnabled by remember { mutableStateOf(setting.defaultValue as? Boolean ?: false) }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = White1000,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = setting.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            Text(
                text = setting.description,
                color = White1000.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontFamily = sarasaFont
            )
        }
        
        Switch(
            checked = isEnabled,
            onCheckedChange = { newValue ->
                isEnabled = newValue
                onToggle(newValue)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Beige400,
                checkedTrackColor = Beige400.copy(alpha = 0.5f),
                uncheckedThumbColor = White1000.copy(alpha = 0.7f),
                uncheckedTrackColor = White1000.copy(alpha = 0.3f)
            )
        )
    }
}

@Composable
private fun NetworkToggleSettingItem(
    setting: NetworkSettings,
    onToggle: (Boolean) -> Unit
) {
    var isEnabled by remember { mutableStateOf(setting.defaultValue as? Boolean ?: false) }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = White1000,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = setting.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            Text(
                text = setting.description,
                color = White1000.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontFamily = sarasaFont
            )
        }
        
        Switch(
            checked = isEnabled,
            onCheckedChange = { newValue ->
                isEnabled = newValue
                onToggle(newValue)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Beige400,
                checkedTrackColor = Beige400.copy(alpha = 0.5f),
                uncheckedThumbColor = White1000.copy(alpha = 0.7f),
                uncheckedTrackColor = White1000.copy(alpha = 0.3f)
            )
        )
    }
}

@Composable
private fun SelectionSettingItem(
    setting: AppearanceSettings,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = White1000,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = setting.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            Text(
                text = setting.description,
                color = White1000.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontFamily = sarasaFont
            )
            
            if (setting.currentValue.isNotEmpty()) {
                Text(
                    text = "当前: ${setting.currentValue}",
                    color = Beige400.copy(alpha = 0.8f),
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

@Composable
private fun NetworkSelectionSettingItem(
    setting: NetworkSettings,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = White1000,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = setting.title,
                color = White1000,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = sarasaFont
            )
            
            Text(
                text = setting.description,
                color = White1000.copy(alpha = 0.7f),
                fontSize = 14.sp,
                fontFamily = sarasaFont
            )
            
            if (setting.currentValue.isNotEmpty()) {
                Text(
                    text = "当前: ${setting.currentValue}",
                    color = Beige400.copy(alpha = 0.8f),
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

enum class SettingType {
    Toggle,
    Selection
}

enum class DataUpdateSettings(
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

enum class AppearanceSettings(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val type: SettingType,
    val defaultValue: Any? = null,
    val currentValue: String = ""
) {
    DarkMode(
        title = "深色模式",
        description = "启用深色主题界面",
        icon = Fa.Moon,
        type = SettingType.Toggle,
        defaultValue = false
    ),
    AutoDarkMode(
        title = "跟随系统",
        description = "根据系统设置自动切换主题",
        icon = Fa.Sun,
        type = SettingType.Toggle,
        defaultValue = true
    ),
    ThemeColor(
        title = "主题颜色",
        description = "选择应用的主色调",
        icon = Fa.Palette,
        type = SettingType.Selection,
        currentValue = "红色"
    ),
    Language(
        title = "语言",
        description = "选择应用显示语言",
        icon = Fa.Language,
        type = SettingType.Selection,
        currentValue = "简体中文"
    ),
    FontSize(
        title = "字体大小",
        description = "调整界面文字大小",
        icon = Fa.Font,
        type = SettingType.Selection,
        currentValue = "标准"
    )
}

enum class NetworkSettings(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val type: SettingType,
    val defaultValue: Any? = null,
    val currentValue: String = ""
) {
    UserAgent(
        title = "User-Agent",
        description = "设置用于maimai DX、CHUNITHM等应用更新的浏览器标识",
        icon = Fa.Cog,
        type = SettingType.Selection,
        currentValue = "默认"
    )
}
