package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.icon.fa.Clock
import com.madsam.otora.core.icon.fa.Wifi
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralDataUpdateScreen(
    onNavigateBack: () -> Unit
) {
    var autoUpdateEnabled by remember { mutableStateOf(true) }
    var wifiOnlyEnabled by remember { mutableStateOf(false) }

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
                    text = "通用数据设置",
                    fontFamily = sarasaBold,
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
                scrolledContainerColor = Color.Unspecified, navigationIconContentColor = colorScheme.onSurface,
                titleContentColor = colorScheme.onSurface,
                actionIconContentColor = Color.Unspecified
            )
        )
        
        // 设置内容
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 自动更新设置
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "自动更新",
                        color = colorScheme.onSurface,
                        fontSize = 16.sp,
                        fontFamily = sarasaBold
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    // 自动更新开关
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Fa.Clock,
                            contentDescription = null,
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(24.dp)
                        )
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "启用自动更新",
                                color = colorScheme.onSurface,
                                fontSize = 16.sp,
                                fontFamily = sarasaSemiBold
                            )
                            
                            Text(
                                text = "定期自动更新游戏数据",
                                color = colorScheme.onSurfaceVariant,
                                fontSize = 14.sp,
                                fontFamily = sarasaRegular
                            )
                        }
                        
                        Switch(
                            checked = autoUpdateEnabled,
                            onCheckedChange = { autoUpdateEnabled = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = colorScheme.onSurface,
                                checkedTrackColor = colorScheme.onSurface.copy(alpha = 0.5f),
                                uncheckedThumbColor = colorScheme.outline,
                                uncheckedTrackColor = colorScheme.surfaceContainerHighest
                            )
                        )
                    }
                }
            }
            
            // 网络设置
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "网络设置",
                        color = colorScheme.onSurface,
                        fontSize = 16.sp,
                        fontFamily = sarasaBold
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    // 仅WiFi更新开关
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Fa.Wifi,
                            contentDescription = null,
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(24.dp)
                        )
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "仅在WiFi下更新",
                                color = colorScheme.onSurface,
                                fontSize = 16.sp,
                                fontFamily = sarasaSemiBold
                            )
                            
                            Text(
                                text = "节省移动数据流量",
                                color = colorScheme.onSurfaceVariant,
                                fontSize = 14.sp,
                                fontFamily = sarasaRegular
                            )
                        }
                        
                        Switch(
                            checked = wifiOnlyEnabled,
                            onCheckedChange = { wifiOnlyEnabled = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = colorScheme.onSurface,
                                checkedTrackColor = colorScheme.onSurface.copy(alpha = 0.5f),
                                uncheckedThumbColor = colorScheme.outline,
                                uncheckedTrackColor = colorScheme.surfaceContainerHighest
                            )
                        )
                    }
                }
            }
        }
    }
}
