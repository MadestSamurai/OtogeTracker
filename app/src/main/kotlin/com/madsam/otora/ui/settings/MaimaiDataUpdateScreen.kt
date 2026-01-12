package com.madsam.otora.ui.settings

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Chevron-left`
import com.madsam.otora.core.icon.fa.Check
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.core.utils.StringUtils.parseCookie
import com.madsam.otora.core.utils.UserAgentUtils
import com.madsam.otora.data.maimai.local.datastore.MaimaiCookieDataStore
import com.madsam.otora.data.maimai.remote.api.MaimaiRequestService
import com.madsam.otora.data.maimai.remote.model.MaimaiCookieDTO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class MaimaiUpdateState {
    IDLE,    // 空闲状态
    LOADING, // 加载中
    SUCCESS  // 成功状态
}

data class MaimaiProgressState(
    val state: MaimaiUpdateState = MaimaiUpdateState.IDLE,
    val progress: Float = 0f,
    val message: String = ""
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaimaiDataUpdateScreen(
    onNavigateBack: () -> Unit,
    onNavigateToUserAgent: (() -> Unit)? = null,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val context = LocalContext.current
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val requestError = remember { mutableStateOf(false) }
    val responseError = remember { mutableStateOf(false) }
    val userDataUpdateState = remember { mutableStateOf(MaimaiProgressState()) }
    val cookieState = remember { mutableStateOf(MaimaiProgressState()) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
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
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(scrollState)
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
                
                // 用户数据更新部分
                Text(
                    text = "用户数据更新",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "更新个人游戏数据（Rating、成绩等）",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 更新用户数据按钮
                Button(
                    onClick = {
                        if (userDataUpdateState.value.state == MaimaiUpdateState.IDLE) {
                            userDataUpdateState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.0f, "开始更新...")
                            scope.launch {
                                snackbarHostState.showSnackbar("开始更新用户数据")
                            }
                            
                            val maimaiRequestService = MaimaiRequestService(context)
                            
                            scope.launch {
                                try {
                                    userDataUpdateState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.3f, "正在获取数据...")
                                    maimaiRequestService.requestAllUserData()
                                    
                                    userDataUpdateState.value = MaimaiProgressState(MaimaiUpdateState.SUCCESS, 1.0f, "更新完成")
                                    snackbarHostState.showSnackbar("用户数据更新完成")
                                    
                                    // 延时后恢复到空闲状态
                                    delay(1500)
                                    userDataUpdateState.value = MaimaiProgressState()
                                } catch (e: Exception) {
                                    userDataUpdateState.value = MaimaiProgressState()
                                    snackbarHostState.showSnackbar("更新失败: ${e.message}")
                                }
                            }
                        }
                    },
                    enabled = userDataUpdateState.value.state == MaimaiUpdateState.IDLE,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (userDataUpdateState.value.state) {
                            MaimaiUpdateState.IDLE -> colorScheme.onSurface
                            MaimaiUpdateState.LOADING -> colorScheme.onSurface.copy(alpha = 0.8f)
                            MaimaiUpdateState.SUCCESS -> colorScheme.onSurface
                        },
                        contentColor = colorScheme.surfaceContainer,
                        disabledContainerColor = colorScheme.onSurface.copy(alpha = 0.6f),
                        disabledContentColor = colorScheme.surfaceContainer.copy(alpha = 0.6f)
                    )
                ) {
                    // 动画进度值
                    val animatedProgress by animateFloatAsState(
                        targetValue = userDataUpdateState.value.progress,
                        animationSpec = tween(durationMillis = 300),
                        label = "userDataUpdateProgress"
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (userDataUpdateState.value.state) {
                            MaimaiUpdateState.IDLE -> {
                                Text(
                                    "更新用户数据",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            MaimaiUpdateState.LOADING -> {
                                CircularProgressIndicator(
                                    progress = { animatedProgress },
                                    modifier = Modifier.size(16.dp),
                                    color = colorScheme.surfaceContainer,
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    userDataUpdateState.value.message,
                                    fontFamily = sarasaSemiBold,
                                    fontSize = 12.sp
                                )
                            }
                            MaimaiUpdateState.SUCCESS -> {
                                Icon(
                                    imageVector = Fa.Check,
                                    contentDescription = "完成",
                                    modifier = Modifier.size(16.dp),
                                    tint = colorScheme.surfaceContainer
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "更新完成",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // 所有成绩获取部分
                Text(
                    text = "所有成绩获取",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "获取所有难度的完整成绩数据（约需1-2分钟）",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 添加所有成绩获取状态
                val allScoresState = remember { mutableStateOf(MaimaiProgressState()) }
                
                // 获取所有成绩按钮
                Button(
                    onClick = {
                        if (allScoresState.value.state == MaimaiUpdateState.IDLE) {
                            allScoresState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.0f, "开始获取...")
                            scope.launch {
                                snackbarHostState.showSnackbar("开始获取所有成绩")
                            }
                            
                            val maimaiRequestService = MaimaiRequestService(context)
                            
                            scope.launch {
                                try {
                                    allScoresState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.2f, "遍历所有难度...")
                                    maimaiRequestService.requestAllScores()
                                    
                                    allScoresState.value = MaimaiProgressState(MaimaiUpdateState.SUCCESS, 1.0f, "获取完成")
                                    snackbarHostState.showSnackbar("所有成绩获取完成")
                                    
                                    // 延时后恢复到空闲状态
                                    delay(1500)
                                    allScoresState.value = MaimaiProgressState()
                                } catch (e: Exception) {
                                    allScoresState.value = MaimaiProgressState()
                                    snackbarHostState.showSnackbar("获取失败: ${e.message}")
                                }
                            }
                        }
                    },
                    enabled = allScoresState.value.state == MaimaiUpdateState.IDLE,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (allScoresState.value.state) {
                            MaimaiUpdateState.IDLE -> colorScheme.onSurface
                            MaimaiUpdateState.LOADING -> colorScheme.onSurface.copy(alpha = 0.8f)
                            MaimaiUpdateState.SUCCESS -> colorScheme.onSurface
                        },
                        contentColor = colorScheme.surfaceContainer,
                        disabledContainerColor = colorScheme.onSurface.copy(alpha = 0.6f),
                        disabledContentColor = colorScheme.surfaceContainer.copy(alpha = 0.6f)
                    )
                ) {
                    // 动画进度值
                    val animatedAllScoresProgress by animateFloatAsState(
                        targetValue = allScoresState.value.progress,
                        animationSpec = tween(durationMillis = 300),
                        label = "allScoresProgress"
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (allScoresState.value.state) {
                            MaimaiUpdateState.IDLE -> {
                                Text(
                                    "获取所有成绩",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            MaimaiUpdateState.LOADING -> {
                                CircularProgressIndicator(
                                    progress = { animatedAllScoresProgress },
                                    modifier = Modifier.size(16.dp),
                                    color = colorScheme.surfaceContainer,
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    allScoresState.value.message,
                                    fontFamily = sarasaSemiBold,
                                    fontSize = 12.sp
                                )
                            }
                            MaimaiUpdateState.SUCCESS -> {
                                Icon(
                                    imageVector = Fa.Check,
                                    contentDescription = "完成",
                                    modifier = Modifier.size(16.dp),
                                    tint = colorScheme.surfaceContainer
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "获取完成",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // 个人信息获取部分
                Text(
                    text = "个人信息获取",
                    color = colorScheme.onSurface,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "输入从maimai DX官方公众号获取的Cookie信息，用于获取和保存您的账号数据",
                    color = colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Request Cookies
                TextField(
                    value = requestState.value,
                    onValueChange = {
                        requestState.value = it
                        requestError.value = it.isEmpty()
                    },
                    label = { 
                        Text(
                            "Request Cookies",
                            fontFamily = sarasaRegular,
                            color = colorScheme.onSurfaceVariant
                        )
                    },
                    isError = requestError.value,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    minLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = colorScheme.onSurface,
                        unfocusedTextColor = colorScheme.onSurface,
                        focusedContainerColor = colorScheme.surface,
                        unfocusedContainerColor = colorScheme.surface,
                        focusedIndicatorColor = colorScheme.onSurface,
                        unfocusedIndicatorColor = colorScheme.outline,
                        errorIndicatorColor = MaterialTheme.colorScheme.error
                    )
                )
                if (requestError.value) {
                    Text(
                        "Request Cookies 不能为空",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        fontFamily = sarasaRegular
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Response Cookies
                TextField(
                    value = responseState.value,
                    onValueChange = {
                        responseState.value = it
                        responseError.value = it.isEmpty()
                    },
                    label = { 
                        Text(
                            "Response Cookies",
                            fontFamily = sarasaRegular,
                            color = colorScheme.onSurfaceVariant
                        )
                    },
                    isError = responseError.value,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    minLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = colorScheme.onSurface,
                        unfocusedTextColor = colorScheme.onSurface,
                        focusedContainerColor = colorScheme.surface,
                        unfocusedContainerColor = colorScheme.surface,
                        focusedIndicatorColor = colorScheme.onSurface,
                        unfocusedIndicatorColor = colorScheme.outline,
                        errorIndicatorColor = MaterialTheme.colorScheme.error
                    )
                )
                if (responseError.value) {
                    Text(
                        "Response Cookies 不能为空",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        fontFamily = sarasaRegular
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 保存Cookies按钮
                Button(
                    onClick = {
                        if (cookieState.value.state == MaimaiUpdateState.IDLE) {
                            requestError.value = requestState.value.isEmpty()
                            responseError.value = responseState.value.isEmpty()
                            if (requestError.value || responseError.value) {
                                return@Button
                            }
                            
                            val requestCookieMap = parseCookie(requestState.value)
                            val responseCookieMap = parseCookie(responseState.value)
                            
                            if (requestCookieMap.isEmpty() || responseCookieMap.isEmpty()) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Cookie格式无效")
                                }
                                return@Button
                            }
                            
                            cookieState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.05f, "保存Cookie...")
                            scope.launch {
                                snackbarHostState.showSnackbar("开始保存Cookie并获取用户数据")
                            }
                            
                            // 先保存Cookie，然后再获取用户数据，确保使用新的Cookie
                            scope.launch {
                                try {
                                    // 1. 保存Cookie到DataStore
                                    val cookieDTO = MaimaiCookieDTO(
                                        token = responseCookieMap["_t"] ?: "",
                                        userId = requestCookieMap["userId"] ?: "",
                                        friendCodeList = requestCookieMap["friendCodeList"] ?: ""
                                    )
                                    
                                    val cookieDataStore = MaimaiCookieDataStore(context)
                                    cookieDataStore.saveCookie(cookieDTO)
                                    
                                    // 2. Cookie保存完成后，开始获取用户数据
                                    cookieState.value = MaimaiProgressState(MaimaiUpdateState.LOADING, 0.3f, "验证Cookie...")
                                    
                                    val maimaiRequestService = MaimaiRequestService(context)
                                    maimaiRequestService.requestAllUserData()
                                    
                                    cookieState.value = MaimaiProgressState(MaimaiUpdateState.SUCCESS, 1.0f, "获取完成")
                                    snackbarHostState.showSnackbar("用户数据获取成功")
                                    
                                    // 延时后恢复到空闲状态
                                    delay(1500)
                                    cookieState.value = MaimaiProgressState()
                                } catch (e: Exception) {
                                    cookieState.value = MaimaiProgressState()
                                    snackbarHostState.showSnackbar("操作失败: ${e.message}")
                                }
                            }
                        }
                    },
                    enabled = cookieState.value.state == MaimaiUpdateState.IDLE,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (cookieState.value.state) {
                            MaimaiUpdateState.IDLE -> colorScheme.onSurface
                            MaimaiUpdateState.LOADING -> colorScheme.onSurface.copy(alpha = 0.8f)
                            MaimaiUpdateState.SUCCESS -> colorScheme.onSurface
                        },
                        contentColor = colorScheme.surfaceContainer,
                        disabledContainerColor = colorScheme.onSurface.copy(alpha = 0.6f),
                        disabledContentColor = colorScheme.surfaceContainer.copy(alpha = 0.6f)
                    )
                ) {
                    // 动画进度值
                    val animatedCookieProgress by animateFloatAsState(
                        targetValue = cookieState.value.progress,
                        animationSpec = tween(durationMillis = 300),
                        label = "cookieProgress"
                    )
                    
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (cookieState.value.state) {
                            MaimaiUpdateState.IDLE -> {
                                Text(
                                    "保存并获取用户数据",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            MaimaiUpdateState.LOADING -> {
                                CircularProgressIndicator(
                                    progress = { animatedCookieProgress },
                                    modifier = Modifier.size(16.dp),
                                    color = colorScheme.surfaceContainer,
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    cookieState.value.message,
                                    fontFamily = sarasaSemiBold,
                                    fontSize = 12.sp
                                )
                            }
                            MaimaiUpdateState.SUCCESS -> {
                                Icon(
                                    imageVector = Fa.Check,
                                    contentDescription = "完成",
                                    modifier = Modifier.size(16.dp),
                                    tint = colorScheme.surfaceContainer
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "获取完成",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
