package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.core.utils.UserAgentUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaimaiDataUpdateScreen(
    onNavigateBack: () -> Unit,
    onNavigateToUserAgent: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val isUserAgentValid = remember { mutableStateOf(true) }
    
    // 检查 UserAgent 是否有效
    LaunchedEffect(Unit) {
        isUserAgentValid.value = UserAgentUtils.isUserAgentValid(context)
    }
    
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
                    text = "maimai DX 数据更新",
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // User-Agent检查提示
                if (!isUserAgentValid.value) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorScheme.surface),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "⚠️ User-Agent未设置",
                                color = colorScheme.onSurface,
                                fontSize = 14.sp,
                                fontFamily = sarasaSemiBold
                            )
                            Text(
                                text = "建议设置User-Agent以确保maimai DX数据更新正常工作",
                                color = colorScheme.onSurfaceVariant,
                                fontSize = 12.sp,
                                fontFamily = sarasaRegular
                            )
                            
                            if (onNavigateToUserAgent != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(
                                    onClick = onNavigateToUserAgent,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = colorScheme.onSurface,
                                        contentColor = colorScheme.surfaceContainer
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        "设置User-Agent",
                                        fontFamily = sarasaRegular,
                                        fontSize = 12.sp
                                    )
                                }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                Text(
                    text = "maimai DX 数据更新",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "maimai DX 的数据更新功能即将推出。\n敬请期待！",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 占位按钮
                Button(
                    onClick = { /* TODO: 实现maimai数据更新 */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorScheme.onSurface.copy(alpha = 0.5f),
                        contentColor = colorScheme.surfaceContainer
                    ),
                    enabled = false
                ) {
                    Text(
                        "即将推出",
                        fontFamily = sarasaSemiBold
                    )
                }
            }
        }
    }
}
