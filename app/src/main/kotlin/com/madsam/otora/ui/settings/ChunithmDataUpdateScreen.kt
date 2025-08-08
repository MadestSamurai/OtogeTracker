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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.core.utils.UserAgentUtils
import com.madsam.otora.data.chunithm.remote.api.ChunithmRequestService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class UpdateState {
    IDLE,    // 空闲状态
    LOADING, // 加载中
    SUCCESS  // 成功状态
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChunithmDataUpdateScreen(
    onNavigateBack: () -> Unit,
    onNavigateToUserAgent: (() -> Unit)? = null,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val context = LocalContext.current
    val requestState = remember { mutableStateOf("") }
    val responseState = remember { mutableStateOf("") }
    val requestError = remember { mutableStateOf(false) }
    val responseError = remember { mutableStateOf(false) }
    val updateState = remember { mutableStateOf(UpdateState.IDLE) }
    val cookieState = remember { mutableStateOf(UpdateState.IDLE) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "CHUNITHM 数据更新",
                    fontFamily = sarasaBold,
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
        
        // 设置内容
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Red500),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(scrollState)
            ) {
                // User-Agent检查提示
                if (!UserAgentUtils.isUserAgentValid(context)) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Red300),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "⚠️ User-Agent未设置",
                                color = White1000,
                                fontSize = 14.sp,
                                fontFamily = sarasaSemiBold
                            )
                            Text(
                                text = "建议设置User-Agent以确保CHUNITHM数据更新正常工作",
                                color = White1000.copy(alpha = 0.8f),
                                fontSize = 12.sp,
                                fontFamily = sarasaRegular
                            )
                            
                            if (onNavigateToUserAgent != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(
                                    onClick = onNavigateToUserAgent,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Beige400,
                                        contentColor = Red500
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
                
                // 歌曲数据更新部分
                Text(
                    text = "歌曲数据更新",
                    color = White1000,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "更新CHUNITHM歌曲数据库",
                    color = White1000.copy(alpha = 0.7f),
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 更新歌曲数据按钮
                Button(
                    onClick = {
                        if (updateState.value == UpdateState.IDLE) {
                            updateState.value = UpdateState.LOADING
                            scope.launch {
                                snackbarHostState.showSnackbar("开始更新歌曲数据")
                            }
                            
                            val chunithmRequestService = ChunithmRequestService(context)
                            chunithmRequestService.getChuniSongsData(
                                onSuccess = {
                                    updateState.value = UpdateState.SUCCESS
                                    scope.launch {
                                        snackbarHostState.showSnackbar("歌曲数据更新完成")
                                    }
                                    
                                    // 延时后恢复到空闲状态
                                    scope.launch {
                                        delay(1500)
                                        updateState.value = UpdateState.IDLE
                                    }
                                },
                                onError = { errorMessage ->
                                    updateState.value = UpdateState.IDLE
                                    scope.launch {
                                        snackbarHostState.showSnackbar("更新失败: $errorMessage")
                                    }
                                }
                            )
                        }
                    },
                    enabled = updateState.value == UpdateState.IDLE,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (updateState.value) {
                            UpdateState.IDLE -> Beige400
                            UpdateState.LOADING -> Beige400.copy(alpha = 0.8f)
                            UpdateState.SUCCESS -> Beige400
                        },
                        contentColor = Red500,
                        disabledContainerColor = Beige400.copy(alpha = 0.6f),
                        disabledContentColor = Red500.copy(alpha = 0.6f)
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (updateState.value) {
                            UpdateState.IDLE -> {
                                Text(
                                    "更新歌曲数据",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            UpdateState.LOADING -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(16.dp),
                                    color = Red500,
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "正在更新...",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            UpdateState.SUCCESS -> {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "完成",
                                    modifier = Modifier.size(16.dp),
                                    tint = Red500
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
                
                // 个人信息获取部分
                Text(
                    text = "个人信息获取",
                    color = White1000,
                    fontSize = 18.sp,
                    fontFamily = sarasaBold
                )
                
                Text(
                    text = "输入从CHUNITHM官方公众号获取的Cookie信息，用于获取和保存您的账号数据",
                    color = White1000.copy(alpha = 0.7f),
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
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    isError = requestError.value,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    minLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = Red300,
                        unfocusedContainerColor = Red300,
                        focusedIndicatorColor = Beige400,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f),
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
                            color = White1000.copy(alpha = 0.7f)
                        )
                    },
                    isError = responseError.value,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    minLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = White1000,
                        unfocusedTextColor = White1000,
                        focusedContainerColor = Red300,
                        unfocusedContainerColor = Red300,
                        focusedIndicatorColor = Beige400,
                        unfocusedIndicatorColor = White1000.copy(alpha = 0.5f),
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
                        if (cookieState.value == UpdateState.IDLE) {
                            requestError.value = requestState.value.isEmpty()
                            responseError.value = responseState.value.isEmpty()
                            if (requestError.value || responseError.value) {
                                return@Button
                            }
                            
                            val requestCookieMap = CommonUtils.parseCookie(requestState.value)
                            val responseCookieMap = CommonUtils.parseCookie(responseState.value)
                            
                            if (requestCookieMap.isEmpty() || responseCookieMap.isEmpty()) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Cookie格式无效")
                                }
                                return@Button
                            }
                            
                            cookieState.value = UpdateState.LOADING
                            scope.launch {
                                snackbarHostState.showSnackbar("开始保存Cookie并获取用户数据")
                            }
                            
                            // 保存Cookie信息
                            ShareUtil.putString("chuniToken", responseCookieMap["_t"] ?: "", context)
                            ShareUtil.putString("chuniUserId", requestCookieMap["userId"] ?: "", context)
                            ShareUtil.putString("chuniFriendCodeList", requestCookieMap["friendCodeList"] ?: "", context)
                            ShareUtil.putString("chuniExpires", responseCookieMap["expires"] ?: "", context)
                            ShareUtil.putString("chuniMaxAge", responseCookieMap["Max-Age"] ?: "", context)
                            ShareUtil.putString("chuniPath", responseCookieMap["path"] ?: "", context)
                            ShareUtil.putString("chuniSameSite", responseCookieMap["SameSite"] ?: "", context)
                            ShareUtil.putString("chuniGa", requestCookieMap["_ga"] ?: "", context)
                            
                            val gaCount = requestCookieMap.count { it.key.startsWith("_ga_") }
                            if (gaCount == 1) {
                                val entry = requestCookieMap.entries.first { it.key.startsWith("_ga_") }
                                ShareUtil.putString("chuniGaKey", entry.key, context)
                                ShareUtil.putString("chuniGaValue", entry.value, context)
                            }
                            
                            // 获取用户数据，类似Dialog中的逻辑
                            val chunithmRequestService = ChunithmRequestService(context)
                            chunithmRequestService.getUserData(
                                onSuccess = {
                                    cookieState.value = UpdateState.SUCCESS
                                    scope.launch {
                                        snackbarHostState.showSnackbar("用户数据获取成功")
                                    }
                                    
                                    // 延时后恢复到空闲状态
                                    scope.launch {
                                        delay(1500)
                                        cookieState.value = UpdateState.IDLE
                                    }
                                },
                                onError = { errorMessage ->
                                    cookieState.value = UpdateState.IDLE
                                    scope.launch {
                                        snackbarHostState.showSnackbar("Cookie保存成功，但用户数据获取失败: $errorMessage")
                                    }
                                }
                            )
                        }
                    },
                    enabled = cookieState.value == UpdateState.IDLE,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (cookieState.value) {
                            UpdateState.IDLE -> Beige400
                            UpdateState.LOADING -> Beige400.copy(alpha = 0.8f)
                            UpdateState.SUCCESS -> Beige400
                        },
                        contentColor = Red500,
                        disabledContainerColor = Beige400.copy(alpha = 0.6f),
                        disabledContentColor = Red500.copy(alpha = 0.6f)
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (cookieState.value) {
                            UpdateState.IDLE -> {
                                Text(
                                    "保存并获取用户数据",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            UpdateState.LOADING -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(16.dp),
                                    color = Red500,
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "正在获取...",
                                    fontFamily = sarasaSemiBold
                                )
                            }
                            UpdateState.SUCCESS -> {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "完成",
                                    modifier = Modifier.size(16.dp),
                                    tint = Red500
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
