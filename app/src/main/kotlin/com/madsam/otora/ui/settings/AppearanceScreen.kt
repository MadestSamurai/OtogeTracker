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
import com.madsam.otora.core.icon.Fa
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
fun AppearanceScreen(
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
                    text = "外观设置",
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
        
        // 设置选项列表
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(AppearanceSetting.values()) { setting ->
                when (setting.type) {
                    SettingType.Toggle -> {
                        ToggleSettingCard(
                            setting = setting,
                            onToggle = { /* TODO: 实现设置保存 */ }
                        )
                    }
                    SettingType.Selection -> {
                        SelectionSettingCard(
                            setting = setting,
                            onClick = { /* TODO: 打开选择对话框 */ }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ToggleSettingCard(
    setting: AppearanceSetting,
    onToggle: (Boolean) -> Unit
) {
    var isEnabled by remember { mutableStateOf(setting.defaultValue as? Boolean ?: false) }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
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
                imageVector = setting.icon,
                contentDescription = null,
                tint = White1000,
                modifier = Modifier.size(28.dp)
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
}

@Composable
private fun SelectionSettingCard(
    setting: AppearanceSetting,
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
                imageVector = setting.icon,
                contentDescription = null,
                tint = White1000,
                modifier = Modifier.size(28.dp)
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
                    Spacer(modifier = Modifier.height(4.dp))
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
                tint = White1000.copy(alpha = 0.7f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

enum class SettingType {
    Toggle,
    Selection
}

enum class AppearanceSetting(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val type: SettingType,
    val defaultValue: Any? = null,
    val currentValue: String = ""
) {
    DarkMode(
        title = "深色模式",
        description = "切换应用的明暗主题",
        icon = Fa.Moon,
        type = SettingType.Toggle,
        defaultValue = true
    ),
    ThemeColor(
        title = "主题色彩",
        description = "选择应用的主色调",
        icon = Fa.Palette,
        type = SettingType.Selection,
        currentValue = "经典红色"
    ),
    Language(
        title = "语言设置",
        description = "选择应用界面语言",
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
    ),
    AutoDarkMode(
        title = "自动深色模式",
        description = "根据系统设置自动切换主题",
        icon = Fa.Sun,
        type = SettingType.Toggle,
        defaultValue = false
    )
}
