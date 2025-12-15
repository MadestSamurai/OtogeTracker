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
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Arrow-left`
import androidx.compose.material3.MaterialTheme
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.datastore.UserAgentDataStore
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAgentSettingScreen(
    onNavigateBack: () -> Unit,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val context = LocalContext.current
    val userAgentState = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    
    // 加载已保存的User-Agent
    LaunchedEffect(Unit) {
        val userAgentDataStore = UserAgentDataStore(context)
        val savedUserAgent = userAgentDataStore.getUserAgent()
        userAgentState.value = savedUserAgent
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
                    text = "User-Agent 设置",
                    fontFamily = sarasaBold,
                    color = colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Fa.`Arrow-left`,
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
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "浏览器标识设置",
                    color = White1000,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "设置用于maimai DX、CHUNITHM等应用更新时的浏览器User-Agent标识，这有助于某些服务正确识别请求",
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // User-Agent输入框
                TextField(
                    value = userAgentState.value,
                    onValueChange = { userAgentState.value = it },
                    label = { 
                        Text(
                            "User-Agent",
                            fontFamily = sarasaRegular,
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    placeholder = {
                        Text(
                            "例如: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
                            fontFamily = sarasaRegular,
                            color = White1000.copy(alpha = 0.5f),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = colorScheme.surface,
                        unfocusedContainerColor = colorScheme.surface,
                        focusedIndicatorColor = colorScheme.onSurface,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f)
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 常用User-Agent示例
                Text(
                    text = "常用示例：",
                    color = White1000.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontFamily = sarasaSemiBold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Chrome (Windows): Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
                    color = White1000.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Safari (macOS): Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15",
                    color = White1000.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 保存按钮
                Button(
                    onClick = {
                        scope.launch {
                            val userAgentDataStore = UserAgentDataStore(context)
                            userAgentDataStore.saveUserAgent(userAgentState.value)
                            snackbarHostState.showSnackbar(
                                if (userAgentState.value.isNotBlank()) "User-Agent已保存" else "已清空User-Agent设置"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorScheme.onSurface,
                        contentColor = colorScheme.surfaceContainer
                    )
                ) {
                    Text(
                        "保存设置",
                        fontFamily = sarasaSemiBold
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // 重置按钮
                Button(
                    onClick = {
                        userAgentState.value = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = White1000.copy(alpha = 0.1f),
                        contentColor = White1000
                    )
                ) {
                    Text(
                        "清空设置",
                        fontFamily = sarasaSemiBold
                    )
                }
            }
        }
    }
}
