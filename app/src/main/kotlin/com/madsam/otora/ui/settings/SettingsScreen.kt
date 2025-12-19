package com.madsam.otora.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.core.datastore.AppLanguage
import com.madsam.otora.core.datastore.ThemeDataStore
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.icon.fa.`Chevron-right`
import com.madsam.otora.core.icon.fa.Cloud
import com.madsam.otora.core.icon.fa.Cog
import com.madsam.otora.core.icon.fa.Font
import com.madsam.otora.core.icon.fa.Language
import com.madsam.otora.core.icon.fa.Moon
import com.madsam.otora.core.icon.fa.Palette
import com.madsam.otora.core.icon.fa.Sun
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    onThemeChanged: ((autoDarkMode: Boolean, darkModeEnabled: Boolean) -> Unit)? = null
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val themeDataStore = remember { ThemeDataStore(context) }
    
    var selectedDataUpdateSetting by remember { mutableStateOf<DataUpdateSettings?>(null) }
    var selectedAppearanceSetting by remember { mutableStateOf<AppearanceSettings?>(null) }
    var selectedNetworkSetting by remember { mutableStateOf<NetworkSettings?>(null) }
    
    // 从 DataStore 读取主题设置
    val themeSettings by themeDataStore.getThemeSettingsFlow().collectAsState(
        initial = ThemeDataStore.ThemeSettings()
    )
    
    // 从 DataStore 读取语言设置
    val currentLanguage by themeDataStore.getLanguageFlow().collectAsState(
        initial = AppLanguage.FOLLOW_SYSTEM
    )
    
    // 自动深色模式状态
    var autoDarkModeEnabled by remember { mutableStateOf(themeSettings.autoDarkMode) }
    var isDarkModeEnabled by remember { mutableStateOf(themeSettings.darkModeEnabled) }
    
    // 当 DataStore 数据更新时，同步状态
    LaunchedEffect(themeSettings) {
        autoDarkModeEnabled = themeSettings.autoDarkMode
        isDarkModeEnabled = themeSettings.darkModeEnabled
    }
    
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
            AppearanceSettings.ThemeColor -> {
                ThemeColorSettingScreen(
                    onNavigateBack = { selectedAppearanceSetting = null }
                )
            }
            AppearanceSettings.Language -> {
                LanguageSettingScreen(
                    onNavigateBack = { selectedAppearanceSetting = null }
                )
            }
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
            }
        }
    } else {
        // 显示主设置页面
        val colorScheme = MaterialTheme.colorScheme
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colorScheme.surface)
        ) {
            // 顶栏
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.settings_title),
                        fontFamily = sarasaBold,
                        color = colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Fa.`Chevron-left`,
                            contentDescription = stringResource(R.string.settings_back),
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
                        title = stringResource(R.string.settings_group_data_update),
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
                    Column {
                        // 组标题
                        Text(
                            text = stringResource(R.string.settings_group_appearance),
                            color = colorScheme.onSurface,
                            fontSize = 14.sp,
                            fontFamily = sarasaSemiBold,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
                        )
                        
                        // 组内容卡片
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column {
                                // 1. 跟随系统
                                ToggleSettingItem(
                                    setting = AppearanceSettings.AutoDarkMode,
                                    checked = autoDarkModeEnabled,
                                    onToggle = { enabled ->
                                        autoDarkModeEnabled = enabled
                                        scope.launch {
                                            themeDataStore.saveAutoDarkMode(enabled)
                                            onThemeChanged?.invoke(enabled, isDarkModeEnabled)
                                        }
                                    }
                                )
                                
                                // 分割线
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(0.5.dp)
                                        .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
                                        .padding(horizontal = 56.dp)
                                )
                                
                                // 2. 深色模式 (带动画)
                                AnimatedVisibility(
                                    visible = !autoDarkModeEnabled,
                                    enter = expandVertically() + fadeIn(),
                                    exit = shrinkVertically() + fadeOut()
                                ) {
                                    Column {
                                        ToggleSettingItem(
                                            setting = AppearanceSettings.DarkMode,
                                            checked = isDarkModeEnabled,
                                            onToggle = { enabled ->
                                                isDarkModeEnabled = enabled
                                                scope.launch {
                                                    themeDataStore.saveDarkModeEnabled(enabled)
                                                    onThemeChanged?.invoke(autoDarkModeEnabled, enabled)
                                                }
                                            }
                                        )
                                        
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(0.5.dp)
                                                .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
                                                .padding(horizontal = 56.dp)
                                        )
                                    }
                                }
                                
                                // 3. 主题颜色
                                SelectionSettingItem(
                                    setting = AppearanceSettings.ThemeColor,
                                    onClick = { selectedAppearanceSetting = AppearanceSettings.ThemeColor }
                                )
                                
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(0.5.dp)
                                        .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
                                        .padding(horizontal = 56.dp)
                                )
                                
                                // 4. 语言
                                SelectionSettingItem(
                                    setting = AppearanceSettings.Language,
                                    currentValue = stringResource(
                                        when (currentLanguage) {
                                            AppLanguage.FOLLOW_SYSTEM -> R.string.language_follow_system
                                            AppLanguage.ENGLISH -> R.string.language_english
                                            AppLanguage.CHINESE_SIMPLIFIED -> R.string.language_chinese_simplified
                                        }
                                    ),
                                    onClick = { selectedAppearanceSetting = AppearanceSettings.Language }
                                )
                                
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(0.5.dp)
                                        .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
                                        .padding(horizontal = 56.dp)
                                )
                                
                                // 5. 字体大小
                                SelectionSettingItem(
                                    setting = AppearanceSettings.FontSize,
                                    onClick = { selectedAppearanceSetting = AppearanceSettings.FontSize }
                                )
                            }
                        }
                    }
                }
                
                // 网络设置组
                item {
                    SettingsGroup(
                        title = stringResource(R.string.settings_group_network),
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
    val colorScheme = MaterialTheme.colorScheme
    Column {
        // 组标题
        Text(
            text = title,
            color = colorScheme.onSurface,
            fontSize = 14.sp,
            fontFamily = sarasaSemiBold,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        )
        
        // 组内容卡片
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
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
                                .background(colorScheme.outlineVariant.copy(alpha = 0.5f))
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
    val colorScheme = MaterialTheme.colorScheme
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
            tint = colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(setting.titleResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold
            )
            
            Text(
                text = stringResource(setting.descriptionResId),
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
            
            if (setting.lastUpdate.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.settings_last_update, setting.lastUpdate),
                    color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
            }
        }
        
        Icon(
            imageVector = Fa.`Chevron-right`,
            contentDescription = null,
            tint = colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun ToggleSettingItem(
    setting: AppearanceSettings,
    checked: Boolean? = null,
    onToggle: (Boolean) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    var internalState by remember { mutableStateOf(setting.defaultValue as? Boolean ?: false) }
    val isEnabled = checked ?: internalState
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = setting.icon,
            contentDescription = null,
            tint = colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(setting.titleResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold
            )
            
            Text(
                text = stringResource(setting.descriptionResId),
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
        }
        
        Switch(
            checked = isEnabled,
            onCheckedChange = { newValue ->
                if (checked == null) {
                    internalState = newValue
                }
                onToggle(newValue)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = colorScheme.onSurface,
                checkedTrackColor = colorScheme.onSurface.copy(alpha = 0.5f),
                uncheckedThumbColor = colorScheme.outline,
                uncheckedTrackColor = colorScheme.surfaceContainerHighest
            )
        )
    }
}

@Composable
private fun NetworkToggleSettingItem(
    setting: NetworkSettings,
    onToggle: (Boolean) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
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
            tint = colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(setting.titleResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold
            )
            
            Text(
                text = stringResource(setting.descriptionResId),
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
        }
        
        Switch(
            checked = isEnabled,
            onCheckedChange = { newValue ->
                isEnabled = newValue
                onToggle(newValue)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = colorScheme.onSurface,
                checkedTrackColor = colorScheme.onSurface.copy(alpha = 0.5f),
                uncheckedThumbColor = colorScheme.outline,
                uncheckedTrackColor = colorScheme.surfaceContainerHighest
            )
        )
    }
}

@Composable
private fun SelectionSettingItem(
    setting: AppearanceSettings,
    currentValue: String = "",
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
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
            tint = colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(setting.titleResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold
            )
            
            Text(
                text = stringResource(setting.descriptionResId),
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
            
            if (currentValue.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.settings_current, currentValue),
                    color = colorScheme.onSurface.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
            }
        }
        
        Icon(
            imageVector = Fa.`Chevron-right`,
            contentDescription = null,
            tint = colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun NetworkSelectionSettingItem(
    setting: NetworkSettings,
    currentValue: String = "",
    onClick: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
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
            tint = colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(setting.titleResId),
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold
            )
            
            Text(
                text = stringResource(setting.descriptionResId),
                color = colorScheme.onSurfaceVariant,
                fontSize = 14.sp,
                fontFamily = sarasaRegular
            )
            
            if (currentValue.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.settings_current, currentValue),
                    color = colorScheme.onSurface.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
            }
        }
        
        Icon(
            imageVector = Fa.`Chevron-right`,
            contentDescription = null,
            tint = colorScheme.onSurfaceVariant,
            modifier = Modifier.size(18.dp)
        )
    }
}

enum class SettingType {
    Toggle,
    Selection
}

enum class DataUpdateSettings(
    val titleResId: Int,
    val descriptionResId: Int,
    val icon: ImageVector,
    val lastUpdate: String = ""
) {
    Osu(
        titleResId = R.string.settings_data_osu_title,
        descriptionResId = R.string.settings_data_osu_desc,
        icon = Filled.OsuIcon,
        lastUpdate = "2024-08-05 14:30"
    ),
    Maimai(
        titleResId = R.string.settings_data_maimai_title,
        descriptionResId = R.string.settings_data_maimai_desc,
        icon = Filled.MaimaiIcon,
        lastUpdate = "2024-08-05 12:15"
    ),
    Chunithm(
        titleResId = R.string.settings_data_chunithm_title,
        descriptionResId = R.string.settings_data_chunithm_desc,
        icon = Filled.ChunithmIcon,
        lastUpdate = "2024-08-05 16:45"
    ),
    BOF(
        titleResId = R.string.settings_data_bof_title,
        descriptionResId = R.string.settings_data_bof_desc,
        icon = Fa.Cloud,
        lastUpdate = "2024-08-04 20:00"
    ),
    General(
        titleResId = R.string.settings_data_general_title,
        descriptionResId = R.string.settings_data_general_desc,
        icon = Fa.Cog
    )
}

enum class AppearanceSettings(
    val titleResId: Int,
    val descriptionResId: Int,
    val icon: ImageVector,
    val type: SettingType,
    val defaultValue: Any? = null
) {
    AutoDarkMode(
        titleResId = R.string.settings_auto_dark_title,
        descriptionResId = R.string.settings_auto_dark_desc,
        icon = Fa.Sun,
        type = SettingType.Toggle,
        defaultValue = true
    ),
    DarkMode(
        titleResId = R.string.settings_dark_mode_title,
        descriptionResId = R.string.settings_dark_mode_desc,
        icon = Fa.Moon,
        type = SettingType.Toggle,
        defaultValue = false
    ),
    ThemeColor(
        titleResId = R.string.settings_theme_color_title,
        descriptionResId = R.string.settings_theme_color_desc,
        icon = Fa.Palette,
        type = SettingType.Selection
    ),
    Language(
        titleResId = R.string.settings_language_title,
        descriptionResId = R.string.settings_language_desc,
        icon = Fa.Language,
        type = SettingType.Selection
    ),
    FontSize(
        titleResId = R.string.settings_font_size_title,
        descriptionResId = R.string.settings_font_size_desc,
        icon = Fa.Font,
        type = SettingType.Selection
    )
}

enum class NetworkSettings(
    val titleResId: Int,
    val descriptionResId: Int,
    val icon: ImageVector,
    val type: SettingType,
    val defaultValue: Any? = null
) {
    UserAgent(
        titleResId = R.string.settings_user_agent_title,
        descriptionResId = R.string.settings_user_agent_desc,
        icon = Fa.Cog,
        type = SettingType.Selection
    )
}
